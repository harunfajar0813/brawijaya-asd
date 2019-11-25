package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node{
    char data;
    Node next, previous;

    Node(char data) {
        this.data = data;
    }
}

class Stack{
    Node head, tail;
    int size;

    void addLast(char newData) {
        Node newNode = new Node(newData);
        if (tail == null){
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
}

class InfixToPostfix{
    Stack dataInsideStack = new Stack();

    InfixToPostfix(String infix){
        for (int i = 0; i < infix.length(); i++) dataInsideStack.addLast(infix.charAt(i));
    }

    String infix(){
        int startAt = 0;
        Node temp = dataInsideStack.head;
        String result = "";
        while (startAt < dataInsideStack.size){
            result += String.valueOf(temp.data);
            temp = temp.next;
            startAt++;
        }
        return result;
    }

    int priority(char inside){
        switch (inside){
            case '^': return 3;
            case '*':
            case '/': return 2;
            case '+':
            case '-': return 1;
        }
        return -1;
    }

    void postfix(){

    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String infix = input.readLine();
        InfixToPostfix itp = new InfixToPostfix(infix);
        itp.postfix();
    }
}
