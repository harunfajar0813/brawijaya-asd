package com.company.satu;

// TUGAS 3.1
public class Matrik {
    private int nBaris, nKolom;
    private double [][]itemDt;

    public Matrik(int nBrs, int nKlm){
        nBaris = nBrs;
        nKolom = nKlm;
        itemDt = new double[nBaris][nKolom];
    }

    public Matrik(double [][]dt){
        nBaris = dt.length;
        nKolom = dt[0].length;
        this.itemDt = new double[nBaris][nKolom];
        for(int i=0; i<nBaris; i++){
            for (int j=0; j<nKolom; j++){
                this.setItem(i,j,dt[i][j]);
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

    public Matrik tambah(Matrik x){
        Matrik y = null;
        if ((this.nBaris == x.getNBaris()) && (this.nKolom == x.getNKolom())){
            y = new Matrik(x.getNBaris(),x.getNKolom());
            for (int i=0; i<this.nBaris; i++){
                for (int j=0; j<this.nKolom; j++){
                    y.setItem(i,j,this.itemDt[i][j]+x.getItem(i,j));
                }
            }
        }
        return y;
    }

    public void cetak(String kom){
        System.out.println(kom);
        for (int i=0; i<this.nBaris; i++){
            for (int j=0; j<this.nKolom; j++){
                System.out.print(this.itemDt[i][j]+" ");
            }
            System.out.println();
        }
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

    // Nomer 2 : Transpose
    static Matrik transpose(Matrik matrix) {
        Matrik hasil = new Matrik(matrix.getNKolom(),matrix.getNBaris());
        for (int i = 0; i < matrix.getNKolom(); i++)
            for (int j = 0; j < matrix.getNBaris(); j++)
                hasil.setItem(i,j, matrix.getItem(j,i));
        return hasil;
    }

    // Nomer 3 : Kali
    Matrik kali(Matrik b){
        double[][] hasil = new double[this.getNBaris()][b.getNKolom()];
        if ((this.getNBaris() == b.getNBaris()) && (this.getNKolom() == b.getNKolom())){
            for (int i=0; i < this.getNBaris(); i++)
                for (int j=0; j < b.getNKolom(); j++){
                    hasil[i][j] = 0;
                    for (int k = 0; k < this.getNBaris(); k++){
                        hasil[i][j] += this.getItem(i,k) * this.getItem(k,j);
                }
            }
        }
        return new Matrik(hasil);
    }

    // Nomer 4 : getLarik
    Larik getKolom(int kolom){
        double[] hasil = new double[this.getNKolom()];
        for (int i=0; i < this.getNKolom(); i++){
            hasil[i] = this.getItem(i,kolom);
        }
        return new Larik(hasil);
    }

    Larik getBaris(int baris){
        double[] hasil = new double[this.getNKolom()];
        for (int i=0; i < this.getNKolom(); i++){
            hasil[i] = this.getItem(baris,i);
        }
        return new Larik(hasil);
    }

    public static void main (String[] args) {
        Matrik A,B;

        double [][] X = {{1, 2, 3},{2, 14, 5},{16, 8, 13}};
        double [][] Y = {{10, 12, 0},{5, 1, 5},{3, 1, 10}};
        A = new Matrik(X);
        B = new Matrik(Y);

        System.out.println("Determinan : " + A.determinan(1));
        Matrik.transpose(A).cetak("Transpose");
        A.kali(B).cetak("Kali");
        A.getKolom(0).cetak("kolom");
        A.getBaris(0).cetak("baris");
    }
}
