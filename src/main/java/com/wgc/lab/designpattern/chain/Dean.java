package com.wgc.lab.designpattern.chain;

/**
 * 责任链具体处理者-院长
 * Created by Administrator on 8/15/2018.
 */
public class Dean extends Leader {

    public Dean(String leaderName) {
        super(leaderName);
    }

    @Override
    public void handleRequest(LeaveNode leaveNode) {
        if (leaveNode.getNumber() <= 10) {//小于10天院长审批
            System.out.println("院长" + this.leaderName + "审批" + leaveNode.getStudentName() + "同学的请假条,请假天数为" + leaveNode.getNumber() + "天。");
        } else { //否则传递给校长
            if (null != this.successor) {
                this.successor.handleRequest(leaveNode);
            }
        }
    }
}
