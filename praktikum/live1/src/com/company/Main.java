package com.company;

import java.util.Scanner;

public class Main {

    static class Node {
        char[] kartu;
        String nama;
        Node next;
        Node prev;
        int jumlahKartu;

        public Node(String nama, char[] kartu) {
            this.kartu = kartu;
            this.nama = nama;
        }
    }

    static class CLL_Kartu {
        Node head;
        Node tail;

        public CLL_Kartu() {
            head = tail = null;
        }

        public void insertNode(String nama, char[] kartu) {
            Node nodeBaru = new Node(nama, kartu);

            if (head == null) {
                head = nodeBaru;
                tail = nodeBaru;
                nodeBaru.jumlahKartu = kartu.length;
            } else {
                tail.next = nodeBaru;
                nodeBaru.next = head;
                head.prev = nodeBaru;
                nodeBaru.prev = tail;
                tail = nodeBaru;
                nodeBaru.jumlahKartu = kartu.length;
            }
        }

        public String getPemenang() {
            Boolean arah = true;
            Node temp = head;

            if (head != null) {
                while (temp.jumlahKartu != 0){
                    temp.jumlahKartu--;
                    if (temp.kartu[temp.jumlahKartu] == 'r'){
                        arah = !arah;
                        if (arah) temp = temp.next;
                        else temp = temp.prev;
                    } else if (temp.kartu[temp.jumlahKartu] == 's'){
                        if (arah) temp = temp.next.next;
                        else temp = temp.prev.prev;
                    } else {
                        if (arah) temp = temp.next;
                        else temp = temp.prev;
                    }
                }
            }

            return temp.nama;
        }
    }

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        String a = inp.nextLine();
        char andi[] = a.toCharArray();
        String b = inp.nextLine();
        char budi[] = b.toCharArray();
        String c = inp.nextLine();
        char cika[] = c.toCharArray();
        String d = inp.nextLine();
        char dani[] = d.toCharArray();
        String e = inp.nextLine();
        char emil[] = e.toCharArray();
        CLL_Kartu uno = new CLL_Kartu();
        uno.insertNode("Andi", andi);
        uno.insertNode("Budi", budi);
        uno.insertNode("Cika", cika);
        uno.insertNode("Dani", dani);
        uno.insertNode("Emil", emil);
        System.out.println();
        System.out.println(uno.getPemenang());
    }
}
