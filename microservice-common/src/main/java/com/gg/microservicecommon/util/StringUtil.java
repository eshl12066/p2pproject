package com.gg.microservicecommon.util;

import org.apache.commons.beanutils.PropertyUtilsBean;
import org.springframework.data.redis.core.RedisTemplate;

import java.beans.PropertyDescriptor;
import java.util.HashMap;
import java.util.Map;

/**
 * @authorliwangwang
 * @site www.liwangwang.com
 * @company xxx公司
 * @create 2019-10-29 19:04
 */
public class StringUtil {

    public static boolean isNotEmptyT(String str) {
        return str != null && !"null".equals(str) && !"".equals(str);
    }

    public static boolean isEmptyT(String str) {
        return str == null || "null".equals(str) || "".equals(str);
    }



    //实体类转为map
    public static Map<String, Object> beanToMap(Object obj) {
        Map<String, Object> params = new HashMap<String, Object>(0);
        try {
            PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();
            PropertyDescriptor[] descriptors = propertyUtilsBean.getPropertyDescriptors(obj);
            for (int i = 0; i < descriptors.length; i++) {
                String name = descriptors[i].getName();
                if (!"class".equals(name)) {
                    params.put(name, propertyUtilsBean.getNestedProperty(obj, name));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return params;
    }



    public static void main(String[] args) {
        String s = (String) new   RedisTemplate().opsForValue().get("UserFlag_eyJhbGciOiJIUzI1NiJ9.eyJ1bmFtZSI6Indhbmd3YW5nIiwicHdkIjoiMTIzIiwidXNlckNvZGUiOiI1cDU3IiwianRpIjoiZTczMDMxOGQzNDU1NGY5ZDhmYzdlMzAzMGExOGEyMzgiLCJpYXQiOjE1NzI0MjU0MTgsImV4cCI6MTU3MjQyOTAxOH0.MxgU39lyuoWjfPFMckPVMYyL2ZNo2hIssgxPUyslUY4");
        System.out.println(s);
    }

}
