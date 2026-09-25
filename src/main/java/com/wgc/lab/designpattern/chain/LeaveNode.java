package com.wgc.lab.designpattern.chain;

/**
 * 被责任链处理的内容-请假条
 * Created by Administrator on 8/15/2018.
 */
public class LeaveNode {

    /***请假天数**/
    private int number;

    /**
     * 请假姓名
     **/
    private String studentName;

    public LeaveNode(String studentName, int number) {
        this.number = number;
        this.studentName = studentName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
