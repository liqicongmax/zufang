package com.lqc.zufang.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liqicong@myhexin.com
 * @date 2019/2/28 18:33
 */
public class Test {
    public static void main(String[] args){
        List<List<String>> list=new ArrayList<>();
        List<String> temp=new ArrayList<>();
        List<String> temp1=new ArrayList<>();
        temp1.add("a");
        list.add(temp1);
        System.out.println(list.get(0).get(0));
        temp1.add("s");
        list.add(temp1);

        System.out.println(list.get(0).get(0));
        System.out.println(list.size());
    }
}
