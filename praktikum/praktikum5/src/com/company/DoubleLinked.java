package com.company;import java.util.Scanner; // memasukkan library java.util.Scanner

public class DoubleLinked { // pendeklarasian class DoubleLinked
    Node head; // pendeklarasian objek Node bernama head
    Node tail; // pendeklarasian objek Node bernama tail

    static class Node { // pendeklarasian class objek Node
        Buku buku; // pendeklarasian objek Buku bernama buku
        Node next; // pendeklarasian objek Node bernama next
        Node previous; // pendeklarasian objek Node bernama previous
    } // penutup node

    static class Buku { // pendeklarasian class objek Node
        String judul; // pendeklarasian atribut objek Judul
        String kategori; // pendeklarasian atribut objek kategori
        double hargaSewa; // pendeklarasian atribut objek hargaSewa
        double hargaDenda; // pendeklarasian atribut objek hargaDenda

        public Buku(String judul, String kategori, double hargaSewa, double hargaDenda) { // constructor Buku yang mmeneteapkan atribut judul, kategori, hargaSewa, hargaDenda
            this.judul = judul; // atribut string judul berisi variabel lokal judul
            this.kategori = kategori; // atribut string kategori berisi variabel lokal kategori
            this.hargaSewa = hargaSewa; // atribut double hargaSewa berisi variabel lokal hargaSewa
            this.hargaDenda = hargaDenda; // atribut double hargaDenda berisi variabel lokal hargaDenda
        } // penutup constructor

        public boolean lebihBesar(Buku compare) {
            if (hargaSewa != compare.hargaSewa)
                return hargaSewa > compare.hargaSewa;
            else
                return hargaDenda > compare.hargaDenda;
        } // method boolean bernama lebihBesar berparameter objek buku. Bertujuan untuk melakukan pengecekan apabila hargaSewa setelahnya sama atau tidak. Jika tidak maka cek hargaSewa mana yang lebih tinggi, jika tidak maka cek hargaDenda mana yang lebih tinggi

        @Override
        public String toString() {
            return String.format("\n%-15s %-25s %-15s %-15s\n", judul, kategori, hargaSewa, hargaDenda);
        } // method yang menampilkan isi atribut dari dari objek Buku
    } // penutup dari class Buku

    public void sisipDataUrut(Buku bukuBaru) {
        Node nodeBaru = new Node();
        nodeBaru.buku = bukuBaru;

        if (head == null) {
            head = nodeBaru;
            tail = nodeBaru;
        } else {
            Node temp = head;
            while (nodeBaru.buku.lebihBesar(temp.buku)) {
                temp = temp.next;
                if (temp == null) break;
            }

            if (temp == null) {
                tail.next = nodeBaru;
                nodeBaru.previous = tail;
                tail = nodeBaru;
                tail.next = null;
            } else if (temp == head) {
                nodeBaru.next = head;
                head.previous = nodeBaru;
                head = nodeBaru;
            } else {
                nodeBaru.next = temp;
                nodeBaru.previous = temp.previous;
                temp.previous.next = nodeBaru;
                temp.previous = nodeBaru;
            }
        }
    } // Deklarasi method sisipDataUrut dengan parameter objek Buku. Disini akan mendeklarasikan objek Buku didalam Suatu Node. Apabila head adalah kosong maka objek Node akan menjadi head. Apabila tidak maka akan mendeklarasikan objek Node bernama temp untuk head. Melakukan perulangan untuk mencari posisi data baru. Apabila ada di setelah tail, maka nodeBaru akan diletakkan setelah tail dan menjadi tail. Apabila ada di sebelum head, maka nodeBaru akan diletakkan sebelum head dan menjadi head. Jika terletak ditengah, maka node yang lebih kecil akan menjadi sebelum nodeBaru dan node yang lebih besar akan menjadi setelah nodeBaru

    public void cetak() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.buku + " ");
            temp = temp.next;
        }
    } // Mencetak isi dari Node mulai dari node Head hingga tail

    public static void main(String[] args) { // Deklarasi method Main
        Scanner input = new Scanner(System.in); // objek Scanner bernama input untuk menerima nilai input
        DoubleLinked dl = new DoubleLinked(); // Objek DoubleLinked sebagai class penyimpanan node
        int pilihan1; // deklarasi variabel int bernama pilihan1
        do { // perintah do while
            System.out.println("Perpustakaan Menu"); // mencetak "Perpustkaan Menu" dan mencetak baris baru
            System.out.println("1. Lihat Katalog"); // mencetak "1. Lihat Katalog" dan mencetak baris baru
            System.out.println("2. Menambah Katalog"); // mencetak "2. Menambah Katalog" dan mencetak baris baru
            System.out.println("3. Exit"); // mencetak "3. Exit" dan mencetak baris baru
            System.out.print("Pilihan Anda : "); // mencetak "Pilihan Anda : "
            pilihan1 = input.nextInt(); // variable pilihan1 menerima nilai dari pengguna
            switch (pilihan1) { // switch dengan kondisi variable pilihan1
                case 1: // case 1
                    System.out.println("\nKatalog Buku"); // mencetak baris baru dan mencetak Katalog Buku
                    System.out.print(String.format("\n%-15s %-25s %-15s %-15s\n", "Judul", "Kategori", "Harga Sewa", "Harga Denda")); // Mencetak kolom, kategori, Harga Sewa, Harga Denda
                    dl.cetak(); // Mencetak isi dari Node
                    System.out.println(); // Mencetak baris baru dan mencetak baris baru
                    break; // deklarasi break
                case 2: // case 2
                    System.out.println("Masukkan Buku Baru"); // Mencetak "Masukkan Buku Baru"
                    input.nextLine(); // menerima nilai
                    System.out.print("Judul Buku : "); // Mencetak "Judul Buku : "
                    String judul = input.nextLine(); // variable judul menerima nilai
                    System.out.print("Kategori Buku : "); // Mencetak "Kategori Buku : "
                    String kategori = input.nextLine(); // variable kategori menerima nilai
                    System.out.print("Harga Sewa Buku : "); // Mencetak "Harga Sewa Buku : "
                    int hargaSewa = input.nextInt(); // variable hargaSewa menerima nilai
                    System.out.print("Harga Denda Buku : "); // Mencetak "Harga Denda Buku : "
                    int hargaDenda = input.nextInt(); // variable hargaDenda menerima nilai
                    dl.sisipDataUrut(new Buku(judul,kategori,hargaSewa,hargaDenda));//
                    System.out.println("Berhasil Input!\n"); // Mencetak "Berhasil Input!"
                    break; // deklarasi break
                case 3: // case 3
                    System.out.println("Terimakasih!"); // Mencetak "Terimakasih!"
//                    for (int i = 80; i < 118; i++) {
//                        System.out.println(i);
//                    }
                    break; // deklarasi break
            } // penutup do
        } while (pilihan1 != 3); // kondisi ketika variable tidak sama dengan 3
    } // penenutup method main
} // penutup class
