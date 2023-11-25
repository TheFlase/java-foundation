package com.wgc.Algorithm;

/**
 * @Author 翁国超
 * @Description //
 * @Date 2023/2/10
 **/
public class ArrayQueueDemo {

    private int arraySize;
    private int[] array;
    private int head;
    private int tail;


    public ArrayQueueDemo(int arraySize) {
        array = new int[arraySize];
        this.arraySize = arraySize;
    }

    public boolean enQueue(int element){
        if(head == arraySize){
            System.out.println("队列已满，无法再添加元素！");
            return false;
        }
        array[head] = element;
        // 加了元素下标需移动
        ++head;
        return true;
    }

    public int deQueue(){
        if(head == tail){
            System.out.println("没有元素可出栈，队列已空！");
            return 0;
        }
        int i = array[tail];
        tail++;
        System.out.println("出栈："+i);
        return i;
    }

    public static void main(String[] args) {
//        ArrayQueue arrayQueue = new ArrayQueue(2);
//        arrayQueue.add(2);
//        arrayQueue.add(1);
//        arrayQueue.add(3);
//        arrayQueue.print();
        ArrayQueueDemo arrayQueueDemo = new ArrayQueueDemo(4);
        arrayQueueDemo.deQueue();
        arrayQueueDemo.enQueue(1);
        arrayQueueDemo.enQueue(3);
        arrayQueueDemo.deQueue();
        arrayQueueDemo.deQueue();
        arrayQueueDemo.deQueue();

    }



}

class ArrayQueue{
    private  Integer queueSize;
    private  Integer[] queue;
    private  int inIndex;
    private  int outIndex;

    public ArrayQueue(Integer queueSize) {
        this.queueSize = queueSize;
        queue = new Integer[queueSize];
    }

    public  boolean add(int element){
        if(0 == inIndex){
            queue[inIndex] = element;
            inIndex++;
        }else {
            if(inIndex>=queueSize){
                System.out.println("添加元素：["+(element)+"]失败，当前队列已满，请先出队后再试！");
                return false;
            }
            queue[inIndex] = element;
            inIndex++;
        }
        return true;
        // 不同点：判断元素是否可添加，直接用equals即可
    }

    public  boolean del(){
        if(inIndex == 0){
            System.out.println("当前队列为空，没有可移除元素");
            return false;
        }else {
            for (int i = 0; i < queueSize; i++) {
                if(null != queue[i]){
                    queue[i] = null;
                    break;
                }
            }
        }
        return true;
        // 不同点：直接判断收尾节点下标是否相同，相同即队列为空了。否则，直接按照队尾下标取元素，然后返回元素即可。
    }

    public void print(){
        if(inIndex>0){
            for (int i = 0; i < inIndex; i++) {
                System.out.println("第"+(i+1)+"个元素是："+queue[i]);
            }
        }
    }
}
