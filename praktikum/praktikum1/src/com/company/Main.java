package com.company;

public class Main {

    public static void main(String[] args) {
        Book[] perpustakaan = {
                new Book("Doraemon", "Komik", 10000, 20,1000,10),
                new Book("Superman", "Fun", 15000, 10,4000,2),
                new Book("Batman", "Horror", 20000, 10,3500,2),
                new Book("Flash", "Hero", 26000, 13,5000,10)
        };
        for (int i=0; i<perpustakaan.length; i++){
            System.out.println(perpustakaan[i]);
        }
    }
}
