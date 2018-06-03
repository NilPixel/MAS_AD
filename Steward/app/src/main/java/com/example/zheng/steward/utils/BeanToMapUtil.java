package com.example.zheng.steward.utils;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class BeanToMapUtil {

    /**
     * bean2Map  常用
     * @param beanObj
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> Map<K, V> bean2Map(Object beanObj) throws Exception {
        if(beanObj == null){
            return null;
        }
        Map<K, V> map = new HashMap<>();

        Field[] declaredFields = beanObj.getClass().getDeclaredFields(); //获取所有的属性
        for (Field field : declaredFields) {
            field.setAccessible(true);//打破封装
            map.put((K)field.getName(), (V)field.get(beanObj));
        }
        return map;
    }
}
