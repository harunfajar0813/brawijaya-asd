package com.company;

import java.util.Scanner;

class Node {
    double data;
    Node next;

    public Node(double data) { this.data = data; }
}

public class CLinkedList {
    Node head;
    Node tail;
    int jumlah;

    public void sisipTanpaNol(double dt) {
        Node nodeBaru = new Node(dt);
        if (tail == null) {
            head = tail = nodeBaru;
            tail.next = head;
        } else {
            tail.next = nodeBaru;
            tail = nodeBaru;
            tail.next = head;
        }
        jumlah++;
    }

    public void cetak() {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            String str = Double.toString(temp.data);
            String data1 = str.replace(".", "");
            String data2 = data1.replace("0", "");
            if (data2.equals("")) System.out.print("");
            else System.out.print(data2 + " ");
            temp = temp.next;
            count++;
            if (count == jumlah + jumlah) break;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double data1 = in.nextDouble();
        double data2 = in.nextDouble();
        double data3 = in.nextDouble();
        double data4 = in.nextDouble();
        double data5 = in.nextDouble();

        CLinkedList storage = new CLinkedList();
        storage.sisipTanpaNol(data1);
        storage.sisipTanpaNol(data2);
        storage.sisipTanpaNol(data3);
        storage.sisipTanpaNol(data4);
        storage.sisipTanpaNol(data5);
        storage.cetak();
    }
}