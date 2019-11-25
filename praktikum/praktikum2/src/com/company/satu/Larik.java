package com.company.satu;

// TUGAS 2.1
public class Larik {
    private int size;
    private int[] itemDt;

    //method
    public void buatLarik(int n) {
        this.size = n;
        this.itemDt = new int[this.size];
    }

    public Larik(int n) {
        buatLarik(n);
    }

    public int getSize() {
        return this.size;
    }

    public Larik(int[] dt) {
        buatLarik(dt.length);
        for (int i = 0; i < dt.length; i++)
            isiItem(i, dt[i]);
    }

    public void isiItem(int id, int dt) {
        this.itemDt[id] = dt;
    }

    public void cetak(String komentar) {
        System.out.println(komentar);
        for (int i = 0; i < this.size; i++) {
            System.out.print(this.itemDt[i] + " ");
            System.out.println();
        }
    }

    public int findBesar() {
        int besar = this.itemDt[0];
        for (int i = 1; i < this.size; i++) {
            if (besar < this.itemDt[i]) {
                besar = this.itemDt[i];
            }
        }
        return besar;
    }

    public int getPosisi(int dtCari){
        int pos = -99;
        boolean ketemu = false;
        int i=0;
        while (!ketemu && i<this.size){
            if (dtCari == this.itemDt[i]){
                ketemu = true;
                pos = i;
            }
            i++;
        }
        return pos;
    }

    private int getPosMax(int id){
        int max = this.itemDt[id];
        int posMax = id;
        for (int i=id+1;i<size; i++){
            if (max <= this.itemDt[i]) {
                max = this.itemDt[i];
                posMax = i;
            }
        }
        return posMax;
    }

    private int getPosMin(int id){
        int min = this.itemDt[id];
        int posMin = id;
        for (int i=id+1;i<size; i++){
            if (min >= this.itemDt[i]) {
                min = this.itemDt[i];
                posMin = i;
            }
        }
        return posMin;
    }

    public int PencarianBiner(int dtCari, int awal, int akhir) {
        int pos = -99;
        int tengah = (awal + akhir) / 2;
        if (dtCari < this.itemDt[tengah])
            return PencarianBiner(dtCari, awal, tengah);
        else if (dtCari > this.itemDt[tengah])
            return PencarianBiner(dtCari, tengah + 1, akhir);
        else if (dtCari == this.itemDt[tengah])
            return tengah;
        else
            return pos;
    }

    public Larik copyLarik(int k, int n){
        Larik lHasil = null;
        if (n <= this.size-k){
            lHasil = new Larik(n);
            int j = 0;
            for (int i=k; i<k+n; i++){
                lHasil.isiItem(j++, this.itemDt[i]);
            }
        }
        return lHasil;
    }

    public Larik SelectionSort(int pilihan){
        Larik lsort = copyLarik(0,size);
        for (int i=0; i<lsort.getSize();i++){
            int posData;
            if (pilihan == 0)
                posData = lsort.getPosMin(i);
            else
                posData = lsort.getPosMax(i);

            int dt1 = lsort.itemDt[i];
            int dt2 = lsort.itemDt[posData];
            lsort.itemDt[i] = dt2;
            lsort.itemDt[posData] = dt1;
        }
        return lsort;
    }

    int[] copyArray(){
        int[] dataCopy = new int[size];
        for (int i=0;i<size-1;i++){
            dataCopy[i] = itemDt[i];
        }
        return dataCopy;
    }

    void findPostKelipatan(int kelipatan, int mulai, int akhir){
        System.out.println("Kelipatan dari " + kelipatan);
        for (int i=mulai; i <= akhir; i++){
            if ((itemDt[i] % kelipatan) == 0){
                System.out.println(i);
            }
        }
    }

    void bubbleSort(int[] data){
        int[] afterBubbleSort = data;
        boolean repeat = true;

        do {
            repeat = false;
            for (int j=0; j<afterBubbleSort.length - 1; j++){
                if (afterBubbleSort[j] > afterBubbleSort[j+1]){
                    int temp = afterBubbleSort[j];
                    afterBubbleSort[j] = afterBubbleSort[j+1];
                    afterBubbleSort[j+1] = temp;
                }
            }
        }while (repeat);

        System.out.println("Hasil Bubble Sort");
        for (int out=0; out < afterBubbleSort.length; out++){
            System.out.println(afterBubbleSort[out]);
        }
    }

    public static void main (String[] args) {
//        System.out.println("Tugas 2.1 : ");
//        int[] A = {2, 34, 5, 7, 10};
//        Larik lA = new Larik(A);
//        lA.findPostKelipatan(2,0,4);
//        System.out.println();
//        lA.bubbleSort(lA.copyArray());
//        System.out.println();
//        lA.cetak("Array Awal");
        for (int i = 0; i < 200; i++) {
            System.out.println(i);
        }
    }
}
