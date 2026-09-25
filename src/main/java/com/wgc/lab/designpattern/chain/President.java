package com.wgc.lab.designpattern.chain;

/**
 * 责任链具体处理者-校长
 * Created by Administrator on 8/15/2018.
 */
public class President extends Leader {

    public President(String leaderName) {
        super(leaderName);
    }

    @Override
    public void handleRequest(LeaveNode leaveNode) {
        if (leaveNode.getNumber() <= 15) {//小于15天校长审批
            System.out.println("校长" + this.leaderName + "审批" + leaveNode.getStudentName() + "同学的请假条,请假天数为" + leaveNode.getNumber() + "天。");
        } else {
            System.out.println("请假天数超过15天,不批准...");
        }
    }
}
