package com.company;

public class Book {
    private String name;
    private String genre;
    private int biayaSewa;
    private int lamaHariSewa;
    private int biayaDenda;
    private int lamaHariDenda;

    public Book(String name, String genre, int biayaSewa, int lamaHariSewa, int biayaDenda, int lamaHariDenda) {
        this.name = name;
        this.genre = genre;
        this.biayaSewa = biayaSewa;
        this.lamaHariSewa = lamaHariSewa;
        this.biayaDenda = biayaDenda;
        this.lamaHariDenda = lamaHariDenda;
    }

    @Override
    public String toString() {
        return String.format("\nJudul : " + name
                + "\nGenre : " + genre
                + "\nBiaya Sewa Buku : Rp. " + biayaSewa
                + "\nHarga Sewa Selama " + lamaHariSewa + " hari : Rp. " + (biayaSewa * lamaHariSewa)
                + "\nBiaya Denda : Rp. " + biayaDenda
                + "\nHarga Denda Selama " + lamaHariDenda + " hari : Rp. " + (biayaDenda * lamaHariDenda)
                + "\n"
        );
    }
}
