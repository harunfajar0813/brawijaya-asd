package com.company.dua;

// TUGAS 3.2
public class Matrik {
    private int nBaris, nKolom;
    private double [][]itemDt;

    public Matrik(int nBrs, int nKlm){
        nBaris = nBrs;
        nKolom = nKlm;
        itemDt = new double[nBaris][nKolom];
    }

    public Matrik(double [][]A){
        this(A.length,A[0].length); // panggil contructor
        this.nBaris = A.length;
        this.nKolom = A[0].length;
        for (int i=0; i<nBaris; i++){
            for (int j=0; j<nKolom; j++){
                this.itemDt[i][j] = A[i][j];
            }
        }
    }

    public int getNBaris(){
        return nBaris;
    }

    public int getNKolom(){
        return nKolom;
    }

    public double getItem(int idB, int idK){
        return this.itemDt[idB][idK];
    }

    public void setItem(int idB, int idK, double dt){
        this.itemDt[idB][idK] = dt;
    }

    public static Matrik tambah(Matrik A, Matrik B){
        Matrik y = null;
        if ((A.nBaris == B.getNBaris()) && (A.nKolom == B.getNKolom())){
            y = new Matrik(A.getNBaris(),A.getNKolom());
            for (int i=0; i<A.nBaris; i++){
                for (int j=0; j<B.nKolom; j++){
                    y.setItem(i,j,A.itemDt[i][j] + B.getItem(i,j));
                }
            }
        }
        return y;
    }
//
    public static Larik VektorKaliMatrik(Larik L, Matrik M){
        Larik lHasil = null;
        Larik lKolom = null;
        if (L.getSize() == M.getNBaris()){
            lHasil = new Larik(M.getNKolom());
            for (int i=0; i<M.getNKolom(); i++){
                lKolom = M.getKolom(i);
                double hasil = Larik.larikKaliLarik(L,lKolom);
                System.out.println(hasil);
                lHasil.isiItem(i, hasil);
            }
        }
        return lHasil;
    }

    public double determinan(int ordo){
        double hasil = 0;
        if ((this.getNKolom() == ordo) && (this.getNBaris() == ordo)){
            if (ordo == 1){
                hasil = getItem(0,0);
            } else if (ordo == 2){
                hasil = (getItem(0,0) * getItem(1,1)) - (getItem(1,0) * getItem(0,1));
            } else if (ordo == 3){
                double atas1 = getItem(0,0) * getItem(1,1) * getItem(2,2);
                double atas2 = getItem(0,1) * getItem(1,2) * getItem(2,0);
                double atas3 = getItem(0,2) * getItem(1,0) * getItem(2,1);
                double bawah1 = getItem(2,0) * getItem(1,1) * getItem(0,2);
                double bawah2 = getItem(2,1) * getItem(1,2) * getItem(0,0);
                double bawah3 = getItem(2,2) * getItem(1,0) * getItem(0,1);
                hasil = ((atas1 * atas2 * atas3) - (bawah1-bawah2-bawah3));
            } else {
                hasil = 0;
            }
        } else {
            hasil = 0;
        }
        return hasil;
    }
//
    public static Matrik tranpos(Matrik A){
        Matrik hasil = new Matrik(A.getNKolom(), A.getNBaris());
        for (int i = 0; i < A.getNKolom(); i++)
            for (int j = 0; j < A.getNBaris(); j++)
                hasil.setItem(i,j, A.getItem(j,i));
        return hasil;
    }
//
    public Larik getBaris(int idBaris){
        double[] hasil = new double[this.getNKolom()];
        for (int i=0; i < this.getNKolom(); i++){
            hasil[i] = this.getItem(idBaris,i);
        }
        return new Larik(hasil);
    }

    public Larik getKolom(int idKolom){
        double[] hasil = new double[this.getNBaris()];
        for (int i=0; i < this.getNBaris(); i++){
            hasil[i] = this.getItem(i,idKolom);
        }
        return new Larik(hasil);
    }

    public void cetak(String kom){
        System.out.println(kom);
        for (int i=0; i<this.nBaris; i++){
            for (int j=0; j<this.nKolom; j++){
                System.out.printf("%.2f",this.itemDt[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Matrik A,B,C;
        double [][]data1 = {
                {1,2,3},
                {3,4,7},
                {3,4,7}
        };
        double [][]data2 = {{4,5,1},{6,1,9}};
        A = new Matrik(data1);
        B = new Matrik(data2);
        A.cetak("A");
        B.cetak("B");
        C = Matrik.tambah(A,B);
        C.cetak("C");
        String cekDeterminan = (A.getNBaris() == A.getNKolom()) ? "Matriks Persegi" : "Bukan Matriks Persegi";
        System.out.println("\nDeterminan A : " + cekDeterminan);
        System.out.println("Determinan : " + A.determinan(A.getNKolom()));
        Matrik CT = Matrik.tranpos(C);
        CT.cetak("Tranpos");
        Larik l1 = C.getBaris(0);
        l1.cetak("Baris ke 1 dari C");
        Larik l2 = Matrik.VektorKaliMatrik(l1,CT);
        l2.cetak("Hasil kali C.L1");
    }
}
