package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    Node head;
    Node tail;
    int size = 0;

    class Node {
        Node next;
        Node previous;
        int value;

        public Node(int value) { this.value = value; }
    }

    public void insertLast(int newValue) {
        Node newNode = new Node(newValue);
        if (tail == null) {
            tail = head = newNode;
            tail.next = head.previous = newNode;
        } else {
            tail.next = newNode;
            tail.next.previous = tail;
            tail = tail.next;
            tail.next = head;
            tail.next.previous = tail;
        }
        size++;
    }

    public void disband(int x, int n) {
        Node getNode = head;
        int statAtIndex = 0;
        if (x > size) return;
        while (statAtIndex < size) {
            if (statAtIndex == x) break;
            getNode = getNode.next;
            statAtIndex++;
        }
        Node getConnection = getNode;
        int startCutIndex = 0;
        while (startCutIndex < n) {
            getConnection = getConnection.next;
            startCutIndex++;
        }
        getNode.previous.next = getConnection;
        getNode.previous.next.previous = getNode.previous;
        size = size - n;
    }

    public void add(int l, int x) {
        Node temp = head;
        int startAt = 0;
        if (l > size) return;
        while (l <= size) {
            if (startAt == l) break;
            temp = temp.next;
            startAt++;
        }
        Node newNode = new Node(x);
        if (l == 0) {
            newNode.next = head;
            newNode.next.previous = newNode;
            head = head.previous;
            head.previous = tail;
            head.previous.next = head;
        } else if (startAt == size) {
            tail.next = newNode;
            tail.next.previous = tail;
            tail = tail.next;
            tail.next = head;
            tail.next.previous = tail;
        } else {
            newNode.previous = temp.previous;
            newNode.previous.next = newNode;
            newNode.next = temp;
            newNode.next.previous = newNode;
        }
        size++;
    }

    public void rotate() {
        Main newCDLL = new Main();
        Node startNode = tail;
        while (startNode != head) {
            newCDLL.insertLast(startNode.value);
            startNode = startNode.previous;
        }
        head.next = newCDLL.head;
        head.next.previous = head;
        head.previous = newCDLL.tail;
        head.previous.next = head;
        tail = head.previous;
    }

    public void check() {
        Node temp = head;
        int index = 0;
        while (index < size) {
            System.out.print(temp.value + " ");
            temp = temp.next;
            index++;
        }
    }

    public void selection(String command) {
        String[] splitCommand = command.split(" ");
        if (splitCommand[0].equals("Disband")) disband(Integer.parseInt(splitCommand[1]), Integer.parseInt(splitCommand[2]));
        else if (splitCommand[0].equals("Rotate")) rotate();
        else if (splitCommand[0].equals("Add")) add(Integer.parseInt(splitCommand[1]), Integer.parseInt(splitCommand[2]));
        else if (splitCommand[0].equals("Check")) check();
    }

    public static void main(String[] args) throws IOException {
        Main CDLL = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String countNodes = br.readLine();
        String[] nodes = br.readLine().split(" ");
        for (int i = 0; i < nodes.length; i++) CDLL.insertLast(Integer.parseInt(nodes[i]));
        int countCommands = Integer.parseInt(br.readLine());
        for (int i = 0; i < countCommands; i++) CDLL.selection(br.readLine());
    }
}