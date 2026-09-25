package com.wgc.lab.reflection.constructor;

/**
 * @Author wgc
 * @Description //TODO
 * @Date 4/12/2020
 **/
public class Constructor_demo1 {
    String s;
    int a,b,c;

    private Constructor_demo1() {
    }
    protected Constructor_demo1(String s,int a){
        this.s = s;
        this.a = a;
    }
    public Constructor_demo1(String... strings)throws NumberFormatException{
        if(0<strings.length){
            a = Integer.valueOf(strings[0]);
        }
        if(1<strings.length){
            b = Integer.valueOf(strings[1]);
        }
        if(2<strings.length){
            c = Integer.valueOf(strings[2]);
        }
    }
    public void print(){
        System.out.println("s="  + s);
        System.out.println("a="+ a);
        System.out.println("b=" + b);
        System.out.println("c=" + c);
    }

}
