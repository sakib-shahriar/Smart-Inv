package com.ssdev.smartinv.util.common;


import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public class CommonUtil {
    public static <E extends Enum<E>> Map<String, String> prepareMapForSelect(Class<E> clazz) {
        Map<String, String> map = new HashMap<>();
        for(E en : EnumSet.allOf(clazz)){
            map.put(en.name(), en.name());
        }
        return map;
    }
}
