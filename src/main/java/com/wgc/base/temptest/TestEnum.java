package com.wgc.base.temptest;

/**
 * @Author 翁国超
 * @Description //
 * @Date 2022/6/7
 **/
public enum TestEnum {
    ONE(1,"a"),

    ;
    private Integer key;
    private String value;

    TestEnum(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static void main(String[] args) {
        System.out.println(TestEnum.ONE);
    }
}
