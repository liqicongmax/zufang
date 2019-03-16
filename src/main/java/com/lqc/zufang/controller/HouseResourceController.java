package com.lqc.zufang.controller;

import com.lqc.zufang.entity.Collect;
import com.lqc.zufang.entity.HouseResource;
import com.lqc.zufang.entity.User;
import com.lqc.zufang.service.CollectService;
import com.lqc.zufang.service.HouseResourceService;
import com.lqc.zufang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author liqicong@myhexin.com
 * @date 2019/2/27 17:02
 */
@Controller
@RequestMapping
public class HouseResourceController {
    @Autowired
    HouseResourceService houseResourceService;
    @Autowired
    UserService userService;
    @Autowired
    CollectService collectService;

    /**
     * 根据房源id查询对应房源的信息,同时给出前三收藏量的房源进行推荐
     * 查询这个房间是否在用户已收藏的列表中,若已收藏,则显示已收藏标签
     *
     * @param id x
     * @param model x
     * @return x
     */
    @RequestMapping(value = "/house", method = RequestMethod.GET)
    public String getHouseResource(@RequestParam(value = "id", required = false) Long id, Model model, HttpSession session) {
        HouseResource houseResource = houseResourceService.getHouseResourceById(id);
        model.addAttribute("houseResource", houseResource);
        //获取房东信息
        //System.out.println(houseResource.getBelonguser());
        User landlord = userService.getUserById(houseResource.getBelonguser());
        model.addAttribute("landlord", landlord);
        User user = (User) session.getAttribute("user");
        if (user == null) {
            model.addAttribute("collect", "uncollected");
        } else {
            List<Long> collectlist = collectService.getCollectListByUserId(user.getId());
            if (collectlist.contains(id)) {
                model.addAttribute("collect", "collected");
            } else {
                model.addAttribute("collect", "uncollected");
            }
        }
        return "admin/houseDetail";
    }

    /**
     * 添加房源到用户的收藏
     *
     * @param session xx
     * @param id      传过来的房源id
     */
    @RequestMapping("/collect")
    public String collect(HttpSession session,
                        @RequestParam("id") String id) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            System.out.println("尚未登录,不能添加收藏");

        }
        if (user != null) {
            Collect collect = new Collect();
            collect.setUserId(user.getId());
            collect.setHouseId(Long.valueOf(id));
            collectService.insertCollect(collect);
        }
        return "redirect:house?id="+id;
    }
    /**
     * 用户在房源页面取消收藏
     * @param id 房源id
     * @param session
     * @return
     */
    @RequestMapping("/hcancelcollect")
    public String cancelcollect(@RequestParam("id") Long id, HttpSession session) {
        User user=(User)session.getAttribute("user");
        userService.cancelcollect(id,user.getId());
        return "redirect:house?id="+id;
    }
}
