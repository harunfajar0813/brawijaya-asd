package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Stack {
    char[] stack = new char[0];
    int top = -1;

    boolean isEmpty() { return (top < 0); }

    void push(char x) {
        char[] newStack = new char[stack.length + 1];
        if (top < 0) newStack[0] = x;
        else {
            for (int i = 0; i < stack.length; i++) {
                newStack[i] = stack[i];
            }
            newStack[newStack.length - 1] = x;
        }
        System.out.println("## PUSH No urut/index : " + (newStack.length-1) + ", Value : " + newStack[newStack.length - 1]);
        top++;
        stack = newStack;
    }

    void pop() {
        if (top < 0) System.out.println("\nFailed to POP : Empty Stack\n");
        else {
            char[] newStack = new char[stack.length - 1];
            System.out.println("## POP No urut/index : " + (stack.length-1) + ", Value : " + stack[stack.length - 1]);
            for (int i = 0; i < stack.length - 1; i++) {
                newStack[i] = stack[i];
            }
            top--;
            stack = newStack;
            System.out.println();
        }
    }

    void peek() {
        if (top < 0) System.out.println("\nFailed to PEEK : Empty Stack");
        else System.out.println("\nLastest : " + stack[stack.length - 1]);
        System.out.println();
    }

    @Override
    public String toString() {
        String size = "\n## Stack size " + stack.length + " : \n";
        if (top < 0) return size;
        else {
            String result = "";
            for (int i = 0; i < stack.length; i++) {
                result += "\n## No Urut/index : " + i + ", Value : " + stack[i];
            }
            return size + result + "\n";
        }
    }
}

public class Main {
    public static void main(String args[]) throws IOException {
        Stack s = new Stack();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int menu;
        do {
            System.out.print("\nMasukkan operasi yang akan dilakukan (1:push, 2:pop, 3:print) : ");
            menu = Integer.parseInt(input.readLine());
            switch (menu) {
                case 1:
                    System.out.print ( "\nMasukkan huruf yang akan dipush : ");
                    s.push(input.readLine().charAt(0));
                    break;
                case 2:
                    s.pop();
                    break;
                case 3:
                    System.out.println(s);
                    break;
                default:
                    System.out.print( "\n1:push, 2:pop, 3:print\n");
                    break;
            }
        } while (menu != 0);
    }
}