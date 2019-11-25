package com.company;

public class Student {
    private String nama;

    public Student(String nama) {
        this.nama = nama;
    }

    @Override
    public String toString() {
        return "Student{" +
                "nama='" + nama + '\'' +
                '}';
    }
}
