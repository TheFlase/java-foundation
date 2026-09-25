package com.wgc.lab.designpattern.chain;

/**
 * 责任链具体处理者-辅导员
 * Created by Administrator on 8/15/2018.
 */
public class Instructor extends Leader {

    public Instructor(String leaderName) {
        super(leaderName);
    }

    @Override
    public void handleRequest(LeaveNode leaveNode) {
        if (leaveNode.getNumber() <= 3) {//小于3天辅导员审批
            System.out.println("辅导员" + this.leaderName + "审批" + leaveNode.getStudentName() + "同学的请假条,请假天数为" + leaveNode.getNumber() + "天。");
        } else { //否则传递给系主任
            if (null != this.successor) {
                this.successor.handleRequest(leaveNode);
            }
        }
    }
}
