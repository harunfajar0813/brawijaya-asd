package com.company;

import java.util.ArrayList;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    Node head;
    Node tail;
    int size = -1;

    static class Node {
        Node next;
        Node previous;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public void insertFromTail(int newData) {
        Node newNode = new Node(newData);
        if (tail == null) {
            head = tail = newNode;
            tail.next = head;
            tail.next.previous = tail;
            size++;
        } else {
            tail.next = newNode;
            tail.next.previous = tail;
            tail = tail.next;
            tail.next = head;
            tail.next.previous = tail;
            size++;
        }
    }

    public void disband(int x, int n) {
        Node temp = head;
        int startFrom = 0;
        while (temp.value != x) {
            temp = temp.next;
        }
        Node deleteUntil = temp;
        while (startFrom < n) {
            deleteUntil = deleteUntil.next;
            size--;
            startFrom++;
        }
        Node connectWith = deleteUntil.next;
        if (connectWith != null) {
            temp.next = connectWith;
            temp.next.previous = temp;
        }
    }

    public void rotate() {
        Main nodeRotate = new Main();
        Node temp = tail;
        while (temp != head) {
            nodeRotate.insertFromTail(temp.value);
            temp = temp.previous;
        }
        head.next = nodeRotate.head;
        head.next.previous = head;
        nodeRotate.tail.next = head;
        nodeRotate.tail.next.previous = nodeRotate.tail;
        tail = head.previous;
    }

    public void add(int x, int L) {
        Node newNode = new Node(L);
        Node temp = head;
        int startFrom = 0;
        while (startFrom != size){
            if (startFrom == x) break;
            temp = temp.next;
            startFrom++;
        }

        if ((startFrom + 1) == x){
            tail.next = newNode;
            tail.next.previous = tail;
            tail = newNode;
            tail.next = head;
            tail.next.previous = tail;
        } else if (startFrom == 0){
            newNode.next = head;
            newNode.next.previous = newNode;
            head = newNode;
            head.previous = tail;
            head.previous.next = head;
        } else {
            Node right = temp;
            Node left = temp.previous;
            left.next = newNode;
            left.next.previous = left;
            newNode.next = right;
            newNode.next.previous = newNode;
        }
        size++;
    }

    public void check() {
        Node temp = head;
        int startFrom = -1;
        while (startFrom < size) {
            System.out.print(temp.value + " ");
            startFrom++;
            temp = temp.next;
        }
    }

    public void selectionCommand(String allCommand) {
        String[] detailCommand = allCommand.split(" ");
        if (detailCommand[0].equals("Disband")) {
            disband(Integer.parseInt(detailCommand[1]), Integer.parseInt(detailCommand[2]));
        } else if (detailCommand[0].equals("Rotate")) {
            rotate();
        } else if (detailCommand[0].equals("Add")) {
            add(Integer.parseInt(detailCommand[1]), Integer.parseInt(detailCommand[2]));
        } else if (detailCommand[0].equals("Check")) {
            check();
        } else {
            System.out.println("Fail");
        }
    }

    public static void main(String[] args) throws IOException {
        Main cdll = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sizeNode = Integer.parseInt(br.readLine());
        String insideNode = br.readLine();
        String[] insideNodeArray = insideNode.split(" ");
        for (int i = 0; i < insideNodeArray.length; i++) {
            cdll.insertFromTail(Integer.parseInt(insideNodeArray[i]));
        }

        ArrayList<String> allCommand = new ArrayList<String>();
        int jumlahPerintah = Integer.parseInt(br.readLine());
        for (int i = 0; i < jumlahPerintah; i++) {
            allCommand.add(br.readLine());
        }

        for (int i = 0; i < allCommand.size(); i++) {
            cdll.selectionCommand(allCommand.get(i));
        }
    }
}