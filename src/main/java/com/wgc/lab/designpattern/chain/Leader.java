package com.wgc.lab.designpattern.chain;

/**
 * 抽象处理者-
 * Created by Administrator on 8/15/2018.
 */
public abstract class Leader {

    /**处理者姓名**/
    public String leaderName;

    /**后继处理者**/
    protected Leader successor;

    public Leader(String leaderName) {
        this.leaderName = leaderName;
    }

    public void setSuccessor(Leader successor) {
        this.successor = successor;
    }

    /**
     * 业务处理方法
     * @param leaveNode
     */
    public abstract void handleRequest(LeaveNode leaveNode);

}
