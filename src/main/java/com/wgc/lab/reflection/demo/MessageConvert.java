package com.wgc.lab.reflection.demo;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @Author
 * @Description //
 * @Date 2022/3/8
 **/
public interface MessageConvert {
    void convert(Object source, Field field, List<MessageConvertUtil.result> resultList);
}
