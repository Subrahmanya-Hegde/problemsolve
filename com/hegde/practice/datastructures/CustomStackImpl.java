package com.hegde.practice.datastructures;

public class CustomStackImpl {

    public static void main(String[] args) {
        CustomStack<Integer> customStack = new CustomStack<>();
        customStack.push(1);
        customStack.push(2);
        customStack.push(3);
        System.out.println(customStack.peek());
        System.out.println(customStack.pop());
        System.out.println(customStack.peek());
        System.out.println(customStack.size());
    }

    public static class CustomStack<T>{

        private ListNode head;
        private int size;

        public CustomStack(){
            this.head = null;
            this.size = 0;
        }

        public void push(T data){
            ListNode tmpNode = new ListNode(data);
            tmpNode.prevNode = this.head;
            this.head = tmpNode;
            this.size = this.size + 1;
        }

        public T pop(){
            if(this.head == null)
                throw new RuntimeException("Stack is empty");
            T data = (T) this.head.data;
            this.head = this.head.prevNode;
            --this.size;
            return data;
        }

        public T peek(){
            if(this.head == null)
                throw new RuntimeException("Stack is empty");
            return (T)this.head.data;
        }

        public long size(){
            return this.size;
        }
    }


    public static class ListNode<T> {
        private T data;
        private ListNode prevNode;

        public ListNode(T data){
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public ListNode getPrevNode() {
            return prevNode;
        }

        public void setPrevNode(ListNode prevNode) {
            this.prevNode = prevNode;
        }
    }
}

//1-2-3-4
//4-3-2-1
