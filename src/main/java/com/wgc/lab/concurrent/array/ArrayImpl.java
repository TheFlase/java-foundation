package com.wgc.lab.concurrent.array;

/**
 * @Author wgc
 * @Description
 * @Date 2020/6/24
 **/
public class ArrayImpl implements IArray{

    protected int DEFAULT_SIZE = 4;
    private Object[] elements;
    private int size = 0;

    public ArrayImpl(){
        this.elements = new Object[DEFAULT_SIZE];
    }

    @Override
    public boolean add(Object obj) {
        try {
            if(null==obj){
                throw new Exception("obj不能为null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        checkSize();
        elements[size++] = obj;
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

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < elements.length-1; i++) {
            if(elements[i]==o){
                return i;
            }
        }
        return -1;
    }

    @Override
    public Object copyFrom(int desPos, IArray src, int srcPos, int lenght) {
        try {
            if(desPos>elements.length-1||desPos<0){
                throw new ArrayIndexOutOfBoundsException("输入的desPos值大于数组长度，请输入小于数组长度的下标!");
            }
            if(null == src){
                throw new Exception("源数组不能为空!");
            }
            if(srcPos<0||srcPos>src.length()){
                throw new ArrayIndexOutOfBoundsException("输入的srcPos值不合法,请检查后输入!");
            }
            if(lenght>src.length()){
                throw new ArrayIndexOutOfBoundsException("拷贝长度不能大于源数据长度!");
            }
            //如果复制过来后需要拓容则拓容
            if((desPos+src.length())>elements.length){
                int temp = desPos+src.length()-elements.length;
                Object tempObject[] = new Object[elements.length + temp];
                for(int i=0;i<elements.length-1;i++){
                    tempObject[i] = elements[i];
                }
                elements = tempObject;
            }
            ArrayImpl tempArray = (ArrayImpl) src;
            int targetIndexBegin = desPos;
            int sourceIndexBegin = srcPos;
            for(int j=0;j<lenght;j++){
                this.elements[targetIndexBegin]= tempArray.elements[sourceIndexBegin];
                targetIndexBegin++;
                sourceIndexBegin++;
            }
            return this;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Object getAt(int index) {
        if(index<0||index>elements.length-1){
            throw new ArrayIndexOutOfBoundsException("输入的下标值有误,请确认后重新输入！");
        }
        return this.elements[index];
    }

    @Override
    public Object setAt(int index, Object o) {
        if(index<0||index>elements.length-1){
            throw new ArrayIndexOutOfBoundsException("输入的下标值有误,请确认后重新输入！");
        }
        int temp = (int) elements[index];
        elements[index] = o;
        return temp;
    }

    @Override
    public int length() {
        int temp = 0;
        for (int i = 0; i < elements.length; i++) {
            if(elements[i]==null){
                temp++;
            }
        }
        return elements.length-temp;
    }

    public void printString(){
        for (int i = 0; i < elements.length-1; i++) {
            if(null!=elements[i]){
                System.out.println(elements[i]);
            }
        }
    }
}
