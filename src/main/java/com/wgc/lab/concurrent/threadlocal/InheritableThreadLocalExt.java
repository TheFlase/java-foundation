package com.wgc.lab.concurrent.threadlocal;

import java.util.Date;

/**
 * @Author wgc
 * @Description //
 * @Date 2020/6/23
 **/
public class InheritableThreadLocalExt extends InheritableThreadLocal{
    @Override
    protected Object initialValue() {
        Date date = new Date();
        return date.getTime();
    }

    @Override
    protected Object childValue(Object parentValue) {
        return parentValue+"子线程的值！";
    }
}
