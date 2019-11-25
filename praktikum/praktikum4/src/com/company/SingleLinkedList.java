package com.company;public class SingleLinkedList { // Deklarasi class SingleLinkedList
    Node head; // Deklarasi objek Node bernama head
    Node tail; // Deklarasi objek Node bernama tail

    static class Node { // Deklarasi class Node
        Buku data; // Deklarasi objek Buku bernama data
        Node next; // Deklarasi objek Node bernama next
    } // penutup dari class Node

    static class Buku{ // Deklarasi dari class Buku
        private String judul; // Deklarasi atribut string judul
        private String kategori; // Deklarasi atribut string kategori
        private double hargaSewa; // Deklarasi atribut double hargaSewa
        private double hargaDenda; // Deklarasi atribut double hargaDenda

        public Buku(String judul, String kategori, double hargaSewa, double hargaDenda) { // Deklarasi constructor berparamter judul, kategori, hargaSewa, hargaDenda
            this.judul = judul; // Atribut judul berisi variable lokal judul
            this.kategori = kategori; // Atribut kategori berisi variable lokal kategori
            this.hargaSewa = hargaSewa; // Atribut hargaSewa berisi variable lokal hargaSewa
            this.hargaDenda = hargaDenda; // Atribut hargaDenda berisi variable lokal hargaDenda
        } // penutup constructor

        public boolean lebihBesar(Buku compare){
            if (hargaSewa != compare.hargaSewa){
                return hargaSewa > compare.hargaSewa;
            } else {
                return hargaDenda > compare.hargaDenda;
            }
        } // method boolean bernama lebihBesar berparameter objek buku. Bertujuan untuk melakukan pengecekan apabila hargaSewa setelahnya sama atau tidak. Jika tidak maka cek hargaSewa mana yang lebih tinggi, jika tidak maka cek hargaDenda mana yang lebih tinggi

        @Override
        public String toString() {
            return String.format("\n%-15s %-25s %-15s %-15s\n", judul, kategori, hargaSewa, hargaDenda);
        } // method yang menampilkan isi atribut dari dari objek Buku
    }

    public void sisipDataUrut(Buku data) {
        Node nodeBaru = new Node();
        nodeBaru.data = data;

        if (head == null){
            head = tail = nodeBaru;
        } else {
            Node temp = head;
            while (nodeBaru.data.lebihBesar(temp.data)){
                temp = temp.next;
                if (temp == null) break;
            }
            if (temp == null){
                tail.next = nodeBaru;
                tail = nodeBaru;
            } else if (temp == head){
                nodeBaru.next = head;
                head = nodeBaru;
            } else {
                Node temp2 = head;
                while (temp2.next.data != temp.data){
                    temp2 = temp2.next;
                }
                nodeBaru.next = temp;
                temp2.next = nodeBaru;
            }
        }
    } // Deklarasi method sisipDataUrut dengan parameter objek Buku. Disini akan mendeklarasikan objek Buku didalam Suatu Node. Apabila head adalah kosong maka objek Node akan menjadi head. Apabila tidak maka akan mendeklarasikan objek Node bernama temp untuk head. Melakukan perulangan untuk mencari posisi data baru. Apabila ada di setelah tail, maka nodeBaru akan diletakkan setelah tail dan menjadi tail. Apabila ada di sebelum head, maka nodeBaru akan diletakkan sebelum head dan menjadi head. Jika terletak ditengah, maka node yang lebih kecil akan menjadi sebelum nodeBaru dan node yang lebih besar akan menjadi setelah nodeBaru

    @Override
    public String toString() {
        String hasil = "";
        hasil += String.format("\n%-15s %-25s %-15s %-15s\n", "Judul", "Kategori", "Harga Sewa", "Harga Denda");
        Node temp = head;
        while (temp != null) {
            hasil += temp.data;
            temp = temp.next;
        }
        return hasil;
    } // Mencetak isi dari Node mulai dari node Head hingga tail

    public static void main(String[] args) { // Deklarasi method main
//        SingleLinkedList ll = new SingleLinkedList(); // Deklarasi objek SingleLinkedList bernama ll
//        ll.sisipDataUrut(new Buku("Batman", "Fun", 9000, 111)); // Memasukkan objek Buku judul Batman, Kategori Fun, hargaSewa 9000, hargaDenda 111 ke Node dalam SingleLinkedList
//        ll.sisipDataUrut(new Buku("Superman", "Sad", 8000, 101)); // Memasukkan objek Buku judul Superman, Kategori Sad, hargaSewa 8000, hargaDenda 101 ke Node dalam SingleLinkedList
//        ll.sisipDataUrut(new Buku("Sincan", "Novel", 9000, 104)); // Memasukkan objek Buku judul Sincan, Kategori Novel, hargaSewa 9000, hargaDenda 104 ke Node dalam SingleLinkedList
//        ll.sisipDataUrut(new Buku("Hero", "Happy", 10000, 100)); // Memasukkan objek Buku judul Hero, Kategori Happy, hargaSewa 10000, hargaDenda 100 ke Node dalam SingleLinkedList
//        ll.sisipDataUrut(new Buku("Iron", "Drama", 11000, 101)); // Memasukkan objek Buku judul Iron, Kategori Drama, hargaSewa 11000, hargaDenda 101 ke Node dalam SingleLinkedList
//        System.out.println(ll); // mencetak isi dari objek SingleLinkedList bernama ll
        for (int i = 1; i < 500; i++) {
            System.out.println(i);
        }
    } // penutup dari method main
} // penutup dari class SingleLinkedList

