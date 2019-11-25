package com.company;

public class Linked {
    Node head;
    Node tail;

    static class Node{
        Book buku;
        Student siswa;
        Node next;

        public Node(Book buku, Student siswa) {
            this.buku = buku;
            this.siswa = siswa;
            next = null;
        }

        @Override
        public String toString() {
            return String.format(buku.toString() + " dan " + siswa);
        }
    }

    public void show(){
        Node awal = head;

        while (awal != null){
            System.out.println(awal);
            awal = awal.next;
        }
    }

    public static void main(String[] args) {
        Linked listPacket = new Linked();
        Node packet1 = new Node(new Book("IPA"), new Student("Harun"));
        Node packet2= new Node(new Book("IPS"), new Student("Ulum"));
        Node packet3 = new Node(new Book("RPL"), new Student("Fajar"));

        listPacket.head = packet1;
        listPacket.head.next = packet2;
        packet2.next = packet3;
        listPacket.tail = packet3;

        listPacket.show();
    }
}
