package com.wgc.lab.collection;

/**
 * Created by Administrator on 3/9/2018.
 */
public class MyArrayList<T> implements MyList<T>,MyIterator<T>{

    protected int DEFAULT_SIZE = 4;
    protected Object[] elements;
    private int size = 0;
    private int position = 0;

    /**
     * initialize the size of the ArrayList
     */
    public MyArrayList(){
        this.elements = new Object[DEFAULT_SIZE];
    }



    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public boolean add(T e) {
        checkSize();
        elements[size++] = e;
        return true;
    }

    /**
     * 校验是否需要开辟新的空间 和开辟新空间
     */
    private void checkSize(){
        if(size >= elements.length-1){
            Object tempObject[] = new Object[elements.length + DEFAULT_SIZE];
            for(int i=0;i<elements.length-1;i++){
                tempObject[i] = elements[i];
            }
            elements = tempObject;
        }
    }

    public boolean add(int index, T e) {
        //判断下标是否在容器之内
        if(index<0 || index>size){
            throw new IndexOutOfBoundsException("index:"+index+"size:"+size);
        }

        //判断空间是否需要扩容
        checkSize();

        //将要插入元素的位置后的元素往后移动一位
        for(int i=size-1;i>=index;i--){
            elements[i+1]=elements[i];
        }

        //赋值
        elements[index] = e;

        //量+1
        size++;
        return true;
    }

    /**
     * 获取指定位置元素
     * @param index
     * @return
     */
    public T get(int index) {
        rangCheck(index);
        return (T)elements[index];
    }

    /**
     * 下标检查
     * @param index
     */
    private void rangCheck(int index) {
        if(index<0||index>=size) {
            throw new IndexOutOfBoundsException(index + "");
        }
    }

    public boolean remove(int index) {
        rangCheck(index);

        //要移除元素位置后的元素往前移动一位
        for (int i=index;i<=size-1;i++) {
            elements[i]=elements[i+1];
        }

        //最后一位元素置空并且调整数组大小
        elements[size-1]=null;
        size--;
        return true;
    }

    /**
     * 移除指定对象
     * @param obj
     * @return
     */
    public boolean removeObj(Object obj) {
        if(null == obj) {
            for(int i=0;i<elements.length-1;i++) {
                if(elements[i]==null){
                    remove(i);
                    return true;
                }
            }
        }else {
            for(int i=0;i<elements.length-1;i++) {
                if(elements[i].equals(obj)) {
                    remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasNext() {
        if(position >= size ||elements[position] == null){
            position = 0;
            return false;
        }else {
            return true;
        }
    }

    public T next() {
        T e = (T)elements[position];
        position++;
        return e;
    }

    @Override
    public String toString(){
        if(!this.hasNext()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (this.hasNext()) {
            sb.append(next()+",");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");
        return sb.toString();
    }

    /**
     * 是否包含
     * @param obj
     * @return
     */
    public int contains(Object obj) {
        if(null == obj) {
            for(int i=0;i<size;i++) {
                if(elements[i]==null){
                    return i;
                }
            }
        }else {
            for(int i=0;i<size;i++) {
                if(elements[i].equals(obj)) {
                    return i;
                }
            }
        }
        return -1;
    }


}
