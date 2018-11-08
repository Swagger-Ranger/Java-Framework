package com.guohaoshiye.uniqueIdentifier.distribution;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*******************************************************************************
 * Copyright (C), 2018-2018,github:Swagger-Ranger 
 * FileName: Bag
 * Author:   liufei32@outlook.com
 * Date:     2018/11/6 16:16
 * Description: 集合：存储每个用户的所有下一级--未使用
 * Aha-eureka:
 *******************************************************************************/

public class Bag {
    private Node<String> first;    // 链表的起始
    private int n;               // 链表元素数量

    // helper linked list class
    private static class Node<String> {
        private String item;
        private Node<String> next;
    }


    public Bag() {
        first = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }


    public int size() {
        return n;
    }

    //向头部添加
    public void add(String item) {
        Node<String> oldfirst = first;
        first = new Node<String>();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    public void delete(String item) {

    }

    //迭代器
    public Iterator<String> iterator()  {
        return new ListIterator<String>(first);
    }

    //未实现删除的迭代器
    private class ListIterator<String> implements Iterator<String> {
        private Node<String> current;

        public ListIterator(Node<String> first) {
            current = first;
        }

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public String next() {
            if (!hasNext()) throw new NoSuchElementException();
            String item = current.item;
            current = current.next;
            return item;
        }
    }


    public static void main(String[] args) {
//        Bag<String> bag = new Bag<String>();
//        while (!StdIn.isEmpty()) {
//            String item = StdIn.readString();
//            bag.add(item);
//        }
//
//        StdOut.println("size of bag = " + bag.size());
//        for (String s : bag) {
//            StdOut.println(s);
//        }
    }
}
