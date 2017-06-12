package com.flyapi;

import java.util.ArrayList;
import java.util.List;

/**
 * author: flyhero
 * Date: 2017/5/27 0027 上午 9:51
 */
public class StrTest {
    public static void main(String[] args) {
        String s="hello";
        String b= "he"+"llo";
        System.out.println(s==b);
        List<String> list =new ArrayList<String>();
        list.subList(2,5);
    }
}
