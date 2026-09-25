package com.wgc.lab.reflection.demo;

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author
 * @Description //
 * @Date 2022/3/8
 **/
public class DefaultMessageConvert implements MessageConvert{
    @Override
    public void convert(Object source, Field field,List<MessageConvertUtil.result> resultList) {
        FieldAnnotation annotation = field.getAnnotation(FieldAnnotation.class);
        try {
            field.setAccessible(true);
            // 按字符串进行转换
//            MessageConvertUtil.result result = new MessageConvertUtil.result(annotation.describe(),String.format(annotation.format(),field.get(source)));


            /**
             * 转换组合值
             */
            String compositeKey = annotation.compositeKey();
            if(StringUtils.isNotBlank(compositeKey)){
//                String[] split = compositeKey.split("-");
//                String compositeValue = annotation.compositeValue();
//                if(StringUtils.isBlank(compositeValue)){
//                    throw new RuntimeException("注解值需要配对出现，注解是："+annotation.annotationType());
//                }
                // 先忽略校验，直接构建值,如果有组合的则直接构建值后返回
                String compositeValue = annotation.compositeValue();
                String[] valueItems = compositeValue.split("-");
                List<String> resultValueList = new ArrayList<>();
                Class<?> aClass = source.getClass();
                for(String item:valueItems){
                    Field declaredField = aClass.getDeclaredField(item);
                    declaredField.setAccessible(true);
                    resultValueList.add(String.valueOf(declaredField.get(source)));
                }

//                System.out.println("最终转换出的值是："+ resultValueList.toArray(new String[0]));
                System.out.println("最终转换出的值是："+ Arrays.toString(resultValueList.toArray(new String[0])));
                MessageConvertUtil.result result = new MessageConvertUtil.result(annotation.describe(),
                        MessageFormat.format(annotation.compositeKey(),String.join(" ", resultValueList.toArray(new String[0]))));
                resultList.add(result);
                return;
            }


            /**
             * 转换单位
             */
            if(StringUtils.isNotBlank(annotation.memorryCalu())){
                String memorryCalu = annotation.memorryCalu();
                field.setAccessible(true);
                String temp = field.get(source)==null?"0":String.valueOf(field.get(source));
                Double value = Double.parseDouble(temp)/Double.parseDouble(memorryCalu);
                MessageConvertUtil.result result = new MessageConvertUtil.result(annotation.describe(), MessageFormat.format(annotation.format(),value));
                resultList.add(result);
                return;
            }


            // 默认转换
            MessageConvertUtil.result result = new MessageConvertUtil.result(annotation.describe(), MessageFormat.format(annotation.format(),field.get(source)));
            resultList.add(result);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            System.out.println("转换异常");
            e.printStackTrace();
        }
    }
}
