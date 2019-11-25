package com.company;

public class Book {
    private String nama;

    public Book(String nama) {
        this.nama = nama;
    }

    @Override
    public String toString() {
        return "Book{" +
                "nama='" + nama + '\'' +
                '}';
    }
}
