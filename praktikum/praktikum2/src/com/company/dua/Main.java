package com.company.dua;

// TUGAS 2.2
public class Main {
    public static void main(String[] args) {
        System.out.println("Tugas 2.2 : ");
        double[] A = {3,4,1,10,5,2,10,20,16};
        double[] B = {4,3,1,11,7};
        Larik L1 = new Larik(A);
        Larik L2 = new Larik(B);
        L1.cetak("Isi Larik L1 : ");
        L2.cetak("Isi Larik L2 : ");
        Larik[] arrayOfLarik = {L1,L2};
        Larik.sambung(arrayOfLarik).cetak("L3 : Menyambungkan Array");
        L1.cetak("Isi Larik L1 : ");
        Larik L4 = Larik.copyLarik(0, L1.getSize(), L1);
        L4.cetak("L4 Copy Larik : ");
        Larik L5 = Larik.SelectionSort(L1,0);
        L5.cetak("L5 data dari kecil ke besar : ");
        Larik L6 = Larik.SelectionSort(L1,1);
        L6.cetak("L6 data dari besar ke kecil : ");
        System.out.printf("HASIL KALI %.3f\n", Larik.larikKaliLarik(L1,L4));
    }
}
