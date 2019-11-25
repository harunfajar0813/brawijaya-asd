package com.company;

class NodeCDLL {
    Object data;
    NodeCDLL sebelum;
    NodeCDLL setelah;
}

public class CircularDoubleLinkedList {
    private NodeCDLL pAwal, pAkhir;
    private int jumlah;

    public CircularDoubleLinkedList(){
        pAwal = null;
        pAkhir = null;
        jumlah = -1;
    }

    public void SisipDataDiAwal(Object data){
        NodeCDLL pBaru = new NodeCDLL();
        pBaru.data = data;
        pBaru.sebelum= pBaru;
        pBaru.setelah= pBaru;
        if (pAwal == null){
            pAwal = pBaru;
            pAkhir = pBaru;
        } else {
            pBaru.sebelum = pAkhir;
            pBaru.setelah = pAwal;
            pAwal.sebelum = pBaru;
            pAkhir.setelah = pBaru;
            pAwal = pBaru;
        }
        jumlah++;
    }

    public void SisipDataDiAkhir(Object data){
        NodeCDLL nodeBaru = new NodeCDLL();
        nodeBaru.data = data;
        if (pAkhir == null){
            pAwal = pAkhir = nodeBaru;
        } else {
            pAkhir.setelah = nodeBaru;
            pAkhir.setelah.sebelum = pAkhir;
            pAkhir = pAkhir.setelah;
            pAkhir.setelah = pAwal;
            pAkhir.setelah.sebelum = pAkhir;
        }
        jumlah++;
    }

    public void hapusData(Object dtHapus){
        NodeCDLL temp = pAwal;
        int count = 0;
        while (!temp.data.equals(dtHapus)){
            temp = temp.setelah;
            count++;
            if (count == jumlah + 1){
                System.out.println("Failed" + count);
                break;
            }
        }
        if (jumlah == 0){
            temp = null;
        } else {
            if (temp == pAwal){
                pAwal = pAwal.setelah;
                pAwal.sebelum = pAkhir;
                pAwal.sebelum.setelah = pAwal;
            } else if (temp == pAkhir){
                pAkhir = pAkhir.sebelum;
                pAkhir.setelah = pAwal;
                pAkhir.setelah.sebelum = pAkhir;
            } else {
                temp.sebelum.setelah = temp.setelah;
                temp.setelah.sebelum = temp.sebelum;
            }
            temp = null;
        }
        jumlah--;
    }

    public void cetak(String Komentar){
        System.out.println(Komentar);
        NodeCDLL pCetak;
        pCetak = pAwal;
        int i =-1;
        while((i < jumlah) ){
            System.out.print(pCetak.data+"->");
            pCetak = pCetak.setelah;
            i++;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularDoubleLinkedList cdll = new CircularDoubleLinkedList();
        cdll.SisipDataDiAwal(new Integer(50));
        cdll.SisipDataDiAwal(new Integer(60));
        cdll.SisipDataDiAwal(new Integer(70));
        cdll.SisipDataDiAwal(new Integer(8));
        cdll.SisipDataDiAwal(new Integer(9));
        cdll.SisipDataDiAwal(new Integer(90));
        cdll.SisipDataDiAwal(new Integer(19));
        cdll.SisipDataDiAwal(new Integer(190));
        cdll.cetak("cdll Asal");
    }
}
