package com.mry.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author vito
 * @version 1.0
 * 创建时间 2016/11/3 10:46
 */
public class ClassUtil {
    /**
     * 实体类转map
     *
     * @param obj
     * @return
     * @throws Exception
     */
    public static Map<String, Object> beanToMap(Object obj) throws Exception {
        Map<String, Object> res = new HashMap<>();
        for (Field field : obj.getClass().getDeclaredFields()) {
            String fieldName = field.getName();
            String getter = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
            Method method = obj.getClass().getMethod(getter);
            res.put(fieldName, method.invoke(obj));
        }
        return res;
    }
}
