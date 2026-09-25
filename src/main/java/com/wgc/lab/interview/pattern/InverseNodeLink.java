package com.wgc.lab.interview.pattern;

/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 *  
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *  
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.LinkedList;

/**
 * @Author wgc
 * @Description //TODO
 * @Date 3/2/2020
 **/
public class InverseNodeLink {
    public static void main(String[] args) {
        MYNode myNode1 = new MYNode("1");
        MYNode myNode2 = new MYNode("2");
        MYNode myNode3 = new MYNode("3");
        MYNode myNode4 = new MYNode("4");
        MYNode myNode5 = new MYNode("5");
        MYNode myNode6 = null;

        myNode1.setNextNode(myNode2);
        myNode2.setNextNode(myNode3);
        myNode3.setNextNode(myNode4);
        myNode4.setNextNode(myNode5);
        myNode5.setNextNode(myNode6);
        MYNode resultNode = InverseNodeLink.reverseNode(myNode1);
        System.out.println("反转后的节点是："+resultNode.getNodeName());


    }

    public static MYNode reverseNode(MYNode head){
        MYNode pre = null, cur = head, next = null;
        int  i = 1;
        while(cur != null) {
            System.out.println("==============================");
            System.out.println("前前前，第"+i+"次执行：");
            System.out.println("cur="+cur.getNodeName());
            if(pre !=null){
                System.out.println("pre="+pre.getNodeName());
            }
            if(next !=null){
                System.out.println("next="+next.getNodeName());
            }
            next = cur.getNextNode();
            cur.setNextNode(pre);
            pre = cur;
            cur = next;
            System.out.println("后后后：");
            System.out.println("cur="+cur.getNodeName());
            System.out.println("pre="+pre.getNodeName());
            System.out.println("next="+next.getNodeName());
            System.out.println("==============================");
            i++;
        }
        return pre;
    }
}
class MYNode{
    private String nodeName;
    private MYNode nextNode;
    public MYNode(String nodeName){
        this.nodeName = nodeName;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public MYNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(MYNode nextNode) {
        this.nextNode = nextNode;
    }
}