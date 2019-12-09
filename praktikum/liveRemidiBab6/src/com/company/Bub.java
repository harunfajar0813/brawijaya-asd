package com.company;

import java.util.*;

public class Bub {

    private String infix, postfix;

    public int priorityPostfix(String i) {
        char s = i.charAt(0);
        int cek = 0;
        if (s == '+' || s == '-') {
            cek = 1;
        } else if (s == '*' || s == '/') {
            cek = 2;
        } else if (s == '^') {
            cek = 3;
        } else {
            cek = 0;
        }
        return cek;
    }

    public Bub(String infix) {
        this.infix = infix;
        postfix = "";
    }

    public String swapPost() {
        String result = "(";
        for (int i = 0; i <= infix.length() - 1; i++) {
            result = result + infix.charAt(i);
        }
        return result + ")";
    }

    public boolean isOperator(char i) {
        return i == '+' || i == '-' || i == '*' || i == '/' || i == '^';

    }

    public void setPostfix() {
        String swapost = swapPost();
        Stack s = new Stack();

        for (int i = 0; i < swapost.length(); i++) {
            char c = swapost.charAt(i);
            String z = String.valueOf(c);
            if (isOperator(c)) {
                while (!s.empty() && priorityPostfix(s.peek().toString()) >= priorityPostfix(z)) {
                    postfix += s.pop();
                }
                s.push(c);
            } else if (c == '(') {
                s.push(c);
            } else if (c == ')') {
                while (!(s.peek().toString().equalsIgnoreCase("("))) {
                    postfix += s.pop();
                }
                s.pop();
            } else {
                postfix = postfix + swapost.charAt(i);
            }
        }

    }

    public void printPostfix() {
        System.out.println(postfix);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String infix = in.nextLine();
        Bub a = new Bub(infix);
        a.setPostfix();
        a.printPostfix();
    }
}
