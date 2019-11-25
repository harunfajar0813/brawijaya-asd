package com.company.satu;

// TUGAS 3.1
public class Larik {
    private int size;
    private double[] itemDt;

    public Larik(double[] A) {
        this.size = A.length;
        this.itemDt = new double[this.size];
        for (int i = 0; i < this.size; i++) {
            this.itemDt[i] = A[i];
        }
    }

    public int getSize() {
        return this.size;
    }

    public double getItem(int i) {
        return this.itemDt[i];
    }

    public static Larik sambung(Larik[] larikAll) {
        int panjangArrayBaru = 0;
        for (int i=0; i < larikAll.length; i++){
            for (int j=0; j < larikAll[i].size; j++){
                panjangArrayBaru++;
            }
        }

        int count = 0;
        double[] arrayBaru = new double[panjangArrayBaru];
        for (int i=0; i < larikAll.length; i++){
            for (int j=0; j < larikAll[i].size; j++){
                arrayBaru[count] = larikAll[i].getItem(j);
                count++;
            }
        }
        Larik larikBaru = new Larik(arrayBaru);
        return larikBaru;
    }

    public void isiItem(int id, double dt) {
        this.itemDt[id] = dt;
    }

    public void cetak(String komentar) {
        System.out.println(komentar);
        for (int i = 0; i < this.size; i++) {
            System.out.printf("%.2f ", this.itemDt[i]);
        }
        System.out.println();
    }

    public double findBesar() {
        double besar = this.itemDt[0];
        for (int i = 1; i < this.size; i++) {
            if (besar < this.itemDt[i]) {
                besar = this.itemDt[i];
            }
        }
        return besar;
    }

    public int getPosisi(double dtCari) {
        int pos = -99;
        boolean ketemu = false;
        int i = 0;
        while (!ketemu && i < this.size) {
            if (dtCari == this.itemDt[i]) {
                ketemu = true;
                pos = i;
            }
            i++;
        }
        return pos;
    }

    public static Larik copyLarik(int k, int n, Larik l) {
        double[] hasilCopyLarik = new double[n-k];
        for (int i=0;i < n-k; i++){
            hasilCopyLarik[i] = l.getItem(k+i);
        }
        Larik hasilObjekCopyLarik = new Larik(hasilCopyLarik);
        return hasilObjekCopyLarik;
    }

    public int getPosBesar(int awal, int akhir) {
        int posBesar = -1;
        double itemBesar;
        if (awal <= akhir) {
            posBesar = awal;
            itemBesar = this.getItem(awal);
            for (int i = awal + 1; i < akhir; i++) {
                double nilaiItem = this.getItem(i);
                if (itemBesar < nilaiItem) {
                    itemBesar = nilaiItem;
                    posBesar = i;
                }
            }
        }
        return posBesar;
    }

    public int getPosKecil(int awal, int akhir) {
        int posKecil = -1;
        double itemKecil;
        if (awal <= akhir) {
            posKecil = awal;
            itemKecil = this.getItem(awal);
            for (int i = awal + 1; i < akhir; i++) {
                double nilaiItem = this.getItem(i);
                if (itemKecil > nilaiItem) {
                    itemKecil = nilaiItem;
                    posKecil = i;
                }
            }
        }
        return posKecil;
    }

    public static Larik SelectionSort(Larik lAsal, int status){

        int n = lAsal.getSize();
        Larik lhasil = Larik.copyLarik(0, n, lAsal);
        if (status == 0){// urutkan data dari kecil ke besar
            for (int i=0; i<n; i++){
                int posKecil = lhasil.getPosKecil(i,n);
                double itemKecil = lhasil.getItem(posKecil);
                double itemI = lhasil.getItem(i);
                lhasil.isiItem(i, itemKecil);
                lhasil.isiItem(posKecil, itemI);
            }
        } else { // urutkan data dari besar ke kecil
            for (int i=0; i<n; i++){
                int posBesar = lhasil.getPosBesar(i,n);
                double itemBesar = lhasil.getItem(posBesar);
                double itemI = lhasil.getItem(i);
                lhasil.isiItem(i, itemBesar);
                lhasil.isiItem(posBesar, itemI);
            }
        }
        return lhasil;
    }

    public static double larikKaliLarik(Larik l1, Larik l2){
        double result = 0;
        for (int i=0;i<l1.size;i++){
            result += l1.getItem(i) * l2.getItem(i);
        }
        return result;
    }

}
