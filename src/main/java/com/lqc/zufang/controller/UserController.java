package com.lqc.zufang.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.lqc.zufang.entity.HouseResource;
import com.lqc.zufang.entity.Image;
import com.lqc.zufang.entity.UploadImageFile;
import com.lqc.zufang.entity.User;
import com.lqc.zufang.service.CollectService;
import com.lqc.zufang.service.HouseResourceService;
import com.lqc.zufang.service.ImageService;
import com.lqc.zufang.service.UserService;
import com.lqc.zufang.util.ImageUtil;
import com.lqc.zufang.util.LoginUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liqicong@myhexin.com
 * @date 2019/2/27 11:08
 */
@Controller
@RequestMapping()
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    HouseResourceService houseResourceService;
    @Autowired
    CollectService collectService;
    @Autowired
    ImageService imageService;

    /**
     * 跳转到用户中心页面时要展示用户的收藏列表
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/user")
    //@PreAuthorize("hasRole('ADMIN')")
    public String userCenter(@RequestParam("id") Long id, Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        model.addAttribute("list", Modify(user, "collected"));
        model.addAttribute("list1", Modify(user, "rented"));
        return "admin/user";
    }


    /**
     * 用户在个人中心页面取消收藏
     *
     * @param id      房源id
     * @param session
     * @return
     */
    @RequestMapping("/ucancelcollect")
    //@PreAuthorize("hasAnyRole('Role_ADMIN','ROLE_USER')")
    public String cancelcollect(@RequestParam("id") Long id, HttpSession session) {
        User user = (User) session.getAttribute("user");
        userService.cancelcollect(id, user.getId());
        return "redirect:user?id=" + user.getId();
    }

    /**
     * 跳转到我要出租(即登记房源)的页面
     * 展示文字数据在页面上
     *
     * @return
     */
    @RequestMapping("/toRent")
    //@PreAuthorize("hasAnyRole('ROLE_USER','Role_ADMIN')")
    public String toRent(@RequestParam("id") Long id, Model model) {
        List<HouseResource> houseResourceList = houseResourceService.getHouseResourceListByUserId(id);
        model.addAttribute("houseList", houseResourceList);
        return "admin/rent";
    }

    /**
     * 跳转到编辑房源图片的页面,带着这个房源的id
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/toPicEdit")
    public String toPicEdit(@RequestParam("houseId") Long id, Model model) {
        model.addAttribute("houseId", id);
        //查询出当前房源下所有的图片的id列表
        List<Long> ids = imageService.getIdListByHid(id);
        model.addAttribute("ids", ids);
        //查询出当前房源的首页展示图片的id
        Long idd=imageService.getTopImageId(id);
        model.addAttribute("idd",idd);
        return "admin/picEditor";
    }

    /**
     * 发布房源
     *需要检测一下是否有首页图片和详细图片了
     * @param id
     * @param session
     * @return
     */
    @RequestMapping("/export")
    public String export(@RequestParam("houseId") Long id, HttpSession session) {
        houseResourceService.export(id);
        return "redirect:toRent?id=" + LoginUtils.getUser(session).getId();
    }
    @RequestMapping("/checkImage")
    @ResponseBody
    public JSONObject checkImage(@RequestParam("houseId") Long houseId){
        System.out.println("=======================================================");
        Boolean result=false;
        List<Long> idlist=imageService.getIdListByHid(houseId);
        Long topImageId=imageService.getTopImageId(houseId);
        if(topImageId!=null&&!idlist.isEmpty()){
            result=true;
        }
        JSONObject res=new JSONObject();
        res.put("data",result);
        return res;
    }

    /**
     * 下架房源
     *
     * @param id
     * @param session
     * @return
     */
    @RequestMapping("/unload")
    public String unload(@RequestParam("houseId") Long id, HttpSession session) {
        houseResourceService.unload(id);
        return "redirect:toRent?id=" + LoginUtils.getUser(session).getId();
    }

    /**
     * 登记房源的具体信息
     *
     * @param province
     * @param city
     * @param district
     * @param size
     * @param bathroom
     * @param beds
     * @param singleWc
     * @param description
     * @param price
     * @param place
     * @param session
     * @return
     */
    @RequestMapping("/registHouseDetail")
    public String registHouseDetail(@RequestParam(value = "province") String province,
                                    @RequestParam(value = "city") String city,
                                    @RequestParam(value = "district") String district,
                                    @RequestParam(value = "size") Integer size,
                                    @RequestParam(value = "bathroom") Integer bathroom,
                                    @RequestParam(value = "beds") Integer beds,
                                    @RequestParam(value = "singleWc") Integer singleWc,
                                    @RequestParam(value = "description") String description,
                                    @RequestParam(value = "price") Integer price,
                                    @RequestParam(value = "place") String place,
                                    HttpSession session) {
        HouseResource houseResource = new HouseResource();
        houseResource.setProvince(province);
        houseResource.setCity(city);
        houseResource.setDistrict(district);
        houseResource.setSize(size);
        houseResource.setBathroom(bathroom);
        houseResource.setBeds(beds);
        houseResource.setSingleWc(singleWc);
        houseResource.setDescription(description);
        houseResource.setPrice(price);
        houseResource.setBelonguser(LoginUtils.getUser(session).getId());
        houseResource.setPlace(place);
        houseResourceService.registHouseDetail(houseResource);
        return "redirect:toRent?id=" + LoginUtils.getUser(session).getId();
    }

    @RequestMapping("/topImageUpload")
    public String topImageUpload(HttpSession session, HttpServletRequest request,UploadImageFile image,
                                 @RequestParam("houseId1") Long houseId,@RequestParam(value = "status",defaultValue = "2")Long status) throws IllegalStateException, IOException {
        System.out.println("houseId==" + houseId);
        Image image1 = new Image();
        image1.setHid(Long.valueOf(houseId));
        image1.setStatus(status);
        imageService.addImage(image1);
        Long picId=image1.getId();
        System.out.println("图片id"+image1.getId());
        String fileName = "house-" + houseId.toString()+"-"+picId+ ".jpg";
        String imageFolder;
        String serverpath = ResourceUtils.getURL("classpath:static/images/house").getPath().replace("%20", " ").replace('/', '\\');
        imageFolder = serverpath.substring(1);//从路径字符串中取出工程路径
        System.out.println("首页图路径"+imageFolder);
        File f = new File(imageFolder, fileName);
        f.getParentFile().mkdir();
        try {
            image.getImage().transferTo(f);
            BufferedImage img = ImageUtil.change2jpg(f);
            ImageIO.write(img, "jpg", f);
            File f_result = new File(imageFolder, fileName);
            ImageUtil.resizeImage(f, 217, 190, f_result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:toPicEdit?houseId=" + houseId;
    }

    @RequestMapping(value = "/detailImageUpload", method = RequestMethod.POST)
    public String detailImageUpload(HttpSession session, UploadImageFile imageDetail, @RequestParam("houseId2") String houseId) throws IllegalStateException, FileNotFoundException {
        //创建新的图片信息并保存到数据库
        System.out.println("houseId==" + houseId);
        Image image = new Image();
        image.setHid(Long.valueOf(houseId));
        imageService.addImage(image);
        Long picId=image.getId();
        System.out.println("asdsad"+image.getId());
        //接收图片文件,并保存到文件夹文件名为house-houseid-图片id
        String fileName = "house-" + houseId.toString() +"-"+ picId.toString() + ".jpg";
        String imageFolder;
        String serverpath = ResourceUtils.getURL("classpath:static/images/houseDetail").getPath().replace("%20", " ").replace('/', '\\');
        imageFolder = serverpath.substring(1);//从路径字符串中取出工程路径

        System.out.println(imageFolder);


        File f = new File(imageFolder, fileName);
        f.getParentFile().mkdir();
        try {
            imageDetail.getImage().transferTo(f);
            BufferedImage img = ImageUtil.change2jpg(f);
            ImageIO.write(img, "jpg", f);
            File f_result = new File(imageFolder, fileName);
            ImageUtil.resizeImage(f, 217, 190, f_result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:toPicEdit?houseId=" + houseId;
    }

    /**
     * 根据不同的类型来删除图片文件
     * @param id
     * @param houseId
     * @return
     */
    @RequestMapping("/deletePic")
    public String deletePic(@RequestParam(value = "id",required = false)Long id,@RequestParam("houseId")Long houseId)throws FileNotFoundException{
        //只要在数据库里修改状态设置为不显示就行,即状态为0
        imageService.deletePic(id);
        return "redirect:toPicEdit?houseId=" + houseId;
    }
    /**
     * 整合获取的房源列表,生成3个为一行的list集合
     *
     * @param user
     * @param type
     * @return
     */
    private List<List<HouseResource>> Modify(User user, String type) {
        List<Long> houseIds = new ArrayList<>();
        if (type.equals("collected")) {
            houseIds = collectService.getCollectListByUserId(user.getId());
        }
        if (type.equals("rented")) {
            houseIds = houseResourceService.getHouseResourceIdListByUserId(user.getId());
        }
        List<HouseResource> houseResourceList = new ArrayList<>();
        //获取用户的收藏列表
        for (Long houseId : houseIds) {
            houseResourceList.add(houseResourceService.getHouseResourceById(houseId));
        }
        List<List<HouseResource>> list = new ArrayList<>();
        int size = houseResourceList.size();
        int tsize = size;
        while (tsize != 0) {
            int i = 0;
            List<HouseResource> temp = new ArrayList<>();
            while (i < 3 && tsize > 0) {
                temp.add(houseResourceList.get(size - tsize));
                i++;
                tsize--;
            }
            list.add(temp);
        }
        return list;
    }

    /**
     * 根据房源id判断房源是否已发布
     * @param houseId
     * @return
     */
    @RequestMapping("/isExported")
    @ResponseBody
    public JSONObject isExported(@RequestParam("houseId") Long houseId){
        Boolean data=false;
        Integer status=houseResourceService.getHouseResourceById(houseId).getStatus();
        if(status==0){
            data=true;
        }
        JSONObject res=new JSONObject();
        res.put("data",data);
        return res;
    }

}
