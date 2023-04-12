package org.alejandroArias.structure;

import java.util.Iterator;
import java.util.Objects;

public class LinkedList <T> implements Iterator<T>{

    private Node<T> head;
    private int size;
    private Integer index;

    public LinkedList() {
        this.head = null;
        this.size = 0;
        this.index = 0;
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (this.head == null) {
            this.head = newNode;
        } else {
            head.add(newNode);
        }
        size++;
    }

    @Override
    public boolean hasNext() {
        if(index ==0 && head != null) return true;
        if(index == size) return false;
        if(index <size){
            return head.getNext(++index);
        }

        return false;
    }

    @Override
    public T next() {
        return null;
    }

    public void reboot(){
        this.index = 0;
    }


    private static class Node<T> implements Comparable<T>{
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?> node = (Node<?>) o;
            return Objects.equals(data, node.data) && Objects.equals(next, node.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data, next);
        }

        @Override
        public int compareTo(T o) {
            if(data.equals(o)) return 0;
            if(data.hashCode() > o.hashCode()) return 1;
            return -1;
        }

        public void add(Node<T> newNode) {

            if (this.next == null) this.next = newNode;
            else this.next.add(newNode);

        }

    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
