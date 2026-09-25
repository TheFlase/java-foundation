package com.wgc.lab.designpattern.chain;

/**
 * 责任链具体处理者-系主任
 * Created by Administrator on 8/15/2018.
 */
public class DepartmentHead extends Leader {

    public DepartmentHead(String leaderName) {
        super(leaderName);
    }

    @Override
    public void handleRequest(LeaveNode leaveNode) {
        if (leaveNode.getNumber() <= 7) {//小于7天系主任审批
            System.out.println("系主任" + this.leaderName + "审批" + leaveNode.getStudentName() + "同学的请假条,请假天数为" + leaveNode.getNumber() + "天。");
        } else { //否则传递给院长
            if (null != this.successor) {
                this.successor.handleRequest(leaveNode);
            }
        }
    }
}
