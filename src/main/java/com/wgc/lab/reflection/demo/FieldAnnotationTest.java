package com.wgc.lab.reflection.demo;

import java.util.List;

/**
 * @Author
 * @Description //
 * @Date 2022/3/7
 **/

public class FieldAnnotationTest {

    @FieldAnnotation(describe = "年龄")
    private int age;

    @FieldAnnotation(describe = "姓名")
    private String name;

    @FieldAnnotation(describe = "CPU",format = "{0}核")
//    @FieldAnnotation(describe = "内存",format = "%s核")
    private Integer cpu;

    private String engine;
    private double version;

    @FieldAnnotation(describe = "基础信息",compositeKey = "{0}",compositeValue = "engine-version")
//    @FieldAnnotation(describe = "基础信息",compositeKey = "{0}-{1}")
    private String baseInfo;

    @FieldAnnotation(describe = "内存",format = "{0}G",memorryCalu = "1024")
    private Integer memorry;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCpu() {
        return cpu;
    }

    public void setCpu(Integer cpu) {
        this.cpu = cpu;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public double getVersion() {
        return version;
    }

    public Integer getMemorry() {
        return memorry;
    }

    public void setMemorry(Integer memorry) {
        this.memorry = memorry;
    }

    public void setVersion(double version) {
        this.version = version;
    }

    public String getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(String baseInfo) {
        this.baseInfo = baseInfo;
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        FieldAnnotationTest filedAnnotationTest = new FieldAnnotationTest();
        filedAnnotationTest.setAge(25);
        filedAnnotationTest.setName("张三");
        filedAnnotationTest.setCpu(4);
        filedAnnotationTest.setEngine("Mysql");
        filedAnnotationTest.setVersion(5.7);
        filedAnnotationTest.setMemorry(2000);
        List<MessageConvertUtil.result> transfer = MessageConvertUtil.transfer(filedAnnotationTest);
        System.out.println(transfer);


    }
}
