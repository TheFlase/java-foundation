package com.wgc.lab.reflection.demo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author
 * @Description //
 * @Date 2022/3/8
 **/
public class MessageConvertUtil {

    public static List<result> transfer(Object obj){
        List<result> resulList = new ArrayList<result>();
        try {
            Class<?> aClass = obj.getClass();
            Field[] declaredFields = aClass.getDeclaredFields();
            List<Field> fieldList = new ArrayList<>();
            if(declaredFields != null && declaredFields.length>0){
                int i = 1;
                for(Field item:declaredFields){
//                    System.out.println("第"+i+"字段名:"+item.getName());
                    if(item.isAnnotationPresent(FieldAnnotation.class)){
                        fieldList.add(item);
                    }
                    i++;
                }
            }

            if(fieldList.size()>0){
                for(Field item:fieldList){
                    FieldAnnotation filedAnnotation = item.getAnnotation(FieldAnnotation.class);
                    MessageConvert messageConvert = (MessageConvert) filedAnnotation.convert().newInstance();
                    messageConvert.convert(obj,item,resulList);
                }
            }
        } catch (InstantiationException e) {
            System.out.println("转换异常1");
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            System.out.println("转换异常2");
            e.printStackTrace();
        }
        return resulList;
    }


    public static class result{
        private String key;
        private Object value;

        public result() {
        }

        public result(String key, Object value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "result{" +
                    "key='" + key + '\'' +
                    ", value=" + value +
                    '}';
        }
    }
}
