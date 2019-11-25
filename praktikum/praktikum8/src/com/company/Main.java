package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Queue {
    char[] queue = new char[0];
    int top = -1;

    boolean isEmpty() {
        return (top < 0);
    }

    void enqueue(char item) {
        char[] newQueue = new char[queue.length + 1];
        if (top < 0) newQueue[0] = item;
        else {
            for (int i = 0; i < queue.length; i++) {
                newQueue[i+1] = queue[i];
            }
            newQueue[0] = item;
        }
        top++;
        queue = newQueue;
        System.out.print ( "\n# EnQueue No urut/index : 0, Queue : " + queue[0]);
    }

    void dequeue(){
        if (top < 0) System.out.println("Empty");
        else {
            char[] newQueue = new char[queue.length - 1];
            System.out.print ( "\n# DeQueue No urut/index : " + (queue.length-1) + ", Queue : " + queue[queue.length-1]);
            for (int i = 0; i < newQueue.length; i++) {
                newQueue[i] = queue[i];
            }
            top--;
            queue = newQueue;
        }
    }

    @Override
    public String toString() {
        String result = "\n## Queue Size : " + queue.length;
        for (int i = 0; i < queue.length; i++) {
            result += "\n## No Urut/index : " + i + ", Value : " + queue[i];
        }
        return result;
    }
}

public class Main {
    public static void main(String args[]) throws IOException {
        Queue q = new Queue();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int menu;
        do {
            System.out.print ( "\nMasukkan operasi yang akan dilakukan (1:enqueue, 2:dequeue, 3:print) : ");
            menu = Integer.parseInt(input.readLine());
            switch (menu) {
                case 1:
                    System.out.print ( "\nMasukkan huruf yang akan di-enqueue : ");
                    q.enqueue(input.readLine().charAt(0));
                    break;
                case 2:
                    System.out.print("Dequeue");
                    q.dequeue();
                    break;
                case 3:
                    System.out.print(q);
                    break;
                default:
                    System.out.print ("\n1:enqueue, 2:dequeue, 3:print\n");
                    break;
            }
        } while (menu != 0);
    }
}
