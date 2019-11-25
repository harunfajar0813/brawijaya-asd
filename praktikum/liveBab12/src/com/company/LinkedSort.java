package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LinkedSort {
    static int counter = -1;
    node head;
    node sorted;

    class node {
        int val;
        node next;

        public node(int val) {
            this.val = val;
        }
    }

    void push(int val) {
        node newnode = new node(val);
        newnode.next = head;
        head = newnode;
    }

    void insertionSort(node headref) {
        sorted = null;
        node current = headref;
        while (current != null) {
            counter++;
            node next = current.next;
            sortedInsert(current);
            current = next;
        }
        head = sorted;
    }

    void sortedInsert(node newnode) {
        if (sorted == null || sorted.val >= newnode.val) {
            newnode.next = sorted;
            sorted = newnode;
        } else {
            node current = sorted;
            while (current.next != null && current.next.val < newnode.val) {
                current = current.next;
            }
            newnode.next = current.next;
            current.next = newnode;
        }
    }

    public static void main(String[] args) throws IOException {
        LinkedSort list = new LinkedSort();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] valueSplit = input.readLine().split(" ");
        int[] nilai = new int[valueSplit.length];
        for (int i = 0; i < nilai.length; i++) {
            list.push(Integer.parseInt(valueSplit[i]));
        }
        list.insertionSort(list.head);
        System.out.println(counter);
    }
}