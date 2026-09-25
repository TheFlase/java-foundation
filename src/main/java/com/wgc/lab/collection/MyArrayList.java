package com.wgc.lab.collection;

import java.util.Objects;

/**
 * 手写 ArrayList 教学示例（修正删除/迭代空值与越界行为）
 */
public class MyArrayList<T> implements MyList<T> {

    protected int DEFAULT_SIZE = 4;
    protected Object[] elements;
    private int size = 0;

    public MyArrayList() {
        this.elements = new Object[DEFAULT_SIZE];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public boolean add(T e) {
        ensureCapacity(size + 1);
        elements[size++] = e;
        return true;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity <= elements.length) {
            return;
        }
        int newCap = elements.length + DEFAULT_SIZE;
        if (newCap < minCapacity) {
            newCap = minCapacity;
        }
        Object[] next = new Object[newCap];
        System.arraycopy(elements, 0, next, 0, size);
        elements = next;
    }

    public boolean add(int index, T e) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index:" + index + " size:" + size);
        }
        ensureCapacity(size + 1);
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = e;
        size++;
        return true;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        rangCheck(index);
        return (T) elements[index];
    }

    private void rangCheck(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.valueOf(index));
        }
    }

    public boolean remove(int index) {
        rangCheck(index);
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null;
        return true;
    }

    /**
     * 移除第一个匹配元素；按 size 遍历，空值安全比较。
     */
    public boolean removeObj(Object obj) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(elements[i], obj)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * 独立迭代器，避免把游标状态绑在 List 自身上。
     */
    public MyIterator<T> iterator() {
        return new Itr();
    }

    private class Itr implements MyIterator<T> {
        private int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        @SuppressWarnings("unchecked")
        public T next() {
            if (!hasNext()) {
                throw new IndexOutOfBoundsException("no more elements");
            }
            return (T) elements[cursor++];
        }
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append(",");
            }
            sb.append(elements[i]);
        }
        sb.append("]");
        return sb.toString();
    }

    public int contains(Object obj) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(elements[i], obj)) {
                return i;
            }
        }
        return -1;
    }
}
