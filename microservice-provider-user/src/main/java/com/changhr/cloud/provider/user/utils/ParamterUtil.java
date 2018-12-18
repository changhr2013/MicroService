package com.changhr.cloud.provider.user.utils;

import com.changhr.cloud.provider.user.annotation.AllowNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;

/**
 * 参数工具类
 *
 * @author changhr
 * @create 2018-12-18 18:41
 */
public class ParamterUtil {

    /** 日志 */
    private static Logger logger = LoggerFactory.getLogger(ParamterUtil.class);

    /**
     * 检查对象的所有字段值是否不为null
     * @param object    需要检查的对象
     * @return boolean	true：检查未通过 false：检查通过
     */
    public static boolean checkObjectField(Object object){
        return checkObjectField(object, Collections.emptyList());
    }

    /**
     * 检查对象的字段值是否不为null（自定义忽略列表）
     * 注意：该方法不能检测内部类属性
     * @param object        需要检查的对象
     * @param ignoreList    不需要检查的属性名称的 list 列表
     * @return boolean true：检查未通过 false：检查通过
     */
    public static boolean checkObjectField(Object object, List<String> ignoreList){

        // 如果传入的对象本身为null或空字符串，直接返回【验证不通过】
        if(ParamterUtil.isEmpty(object)) {
            return true;
        }

        Field[] superFields = object.getClass().getSuperclass().getDeclaredFields();
        Field[] fields = object.getClass().getDeclaredFields();

        try{
            // 校验对象父类
            for (Field field : superFields) {
                field.setAccessible(true);
                // 1. 忽略列表不包含该字段    2. 该字段属性值为空
                if((!ignoreList.contains(field.getName())) && (ParamterUtil.isEmpty(field.get(object)))){
                    // 存在【不在忽略列表】【属性值值却为空】的属性，返回【验证不通过】
                    return true;
                }
            }

            // 校验当前对象
            for (Field field : fields) {
                field.setAccessible(true);
                // 1. 忽略列表不包含该字段    2. 该字段属性值为空
                if((!ignoreList.contains(field.getName())) && (ParamterUtil.isEmpty(field.get(object)))){
                    // 存在【不在忽略列表】【属性值值却为空】的属性，返回【验证不通过】
                    return true;
                }
            }
        }catch (IllegalAccessException e){
            logger.error("属性值非空校验失败！", e);
            // 发生异常，返回【验证不通过】
            return true;
        }
        // 通过所有验证，返回【验证通过】
        return false;
    }

    /**
     * 检查对象的字段值是否不为null（配合注解使用）
     * 注意：该方法不能检测内部类属性
     * @param object        需要检查的对象
     * @return boolean true：检查未通过 false：检查通过
     */
    public static boolean checkNotNull(Object object){

        // 如果传入的对象本身为null或空字符串，直接返回【验证不通过】
        if(ParamterUtil.isEmpty(object)) {
            return true;
        }

        Field[] superFields = object.getClass().getSuperclass().getDeclaredFields();
        Field[] fields = object.getClass().getDeclaredFields();

        try{
            // 校验对象父类
            for (Field field : superFields) {
                field.setAccessible(true);
                // 如果【不存在允许空的注解标记】并且【该属性值为空】，返回【验证不通过】
                if((!field.isAnnotationPresent(AllowNull.class)) && ParamterUtil.isEmpty(field.get(object))){
                    return true;
                }
            }

            // 校验当前对象
            for (Field field : fields) {
                field.setAccessible(true);
                // 如果【不存在允许空的注解标记】并且【该属性值为空】，返回【验证不通过】
                if((!field.isAnnotationPresent(AllowNull.class)) && ParamterUtil.isEmpty(field.get(object))){
                    return true;
                }
            }
        }catch (IllegalAccessException e){
            logger.error("属性值非空校验失败！", e);
            // 发生异常，返回【验证不通过】
            return true;
        }
        // 通过所有验证，返回【验证通过】
        return false;
    }

    /**
     * 判断对象是否为空
     * @param str 对象
     * @return boolean
     */
    public static boolean isEmpty(Object str) {
        return str == null || "".equals(str);
    }

}
