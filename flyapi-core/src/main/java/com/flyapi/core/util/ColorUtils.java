package com.flyapi.core.util;

import com.flyapi.core.util.RandomUtil;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Author: qfwang
 * Date: 2018-02-12 下午3:25
 */
public class ColorUtils {

    private static List<int[]> startList = new ArrayList<>();
    private static List<int[]> endList = new ArrayList<>();

    static {
        int[] startBlue= {78,198,252};
        int[] start2= {56,194,183};
        int[] start3= {202,225,58};

        int[] endBlue= {16,77,251};
        int[] end2= {24,126,106};
        int[] end3= {60,204,151};

        startList.add(startBlue);
        endList.add(endBlue);
        startList.add(start2);
        endList.add(end2);
        startList.add(start3);
        endList.add(end3);
    }

    public static Map<String,List> mapColor(){
        Map<String,List> map = new HashMap<>();
        map.put("start",startList);
        map.put("end",endList);
        return map;
    }

    /**
     * 获取随机的color
     * @title: intColor
     * @param
     * @return java.util.Map<java.lang.String,Color>
     * @date 2018/2/12 下午4:45
     */
    public static Map<String,Color> intColor(){
        Map<String,Color> map = new HashMap<>();
        int index = RandomUtil.randomInt(0,startList.size());
        int[] sint = startList.get(index);
        int[] eint = endList.get(index);
        Color start = new Color(sint[0],sint[1],sint[2]);
        Color end = new Color(eint[0],eint[1],eint[2]);
        map.put("start",start);
        map.put("end",end);
        return map;
    }
}
