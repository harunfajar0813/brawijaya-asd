package com.company;class NodeCSLL {
    Object data;
    NodeCSLL setelah;
}

public class CircularSingleLinkedList{
    private NodeCSLL pAwal, pAkhir;
    private int jumlah;

    public CircularSingleLinkedList(){
        pAwal = null;
        pAkhir = null;
        jumlah = -1;
    }

    public void SisipDataDiAwal(Object data){
        NodeCSLL pBaru = new NodeCSLL();
        pBaru.data = data;
        pBaru.setelah= pBaru;
        if (pAwal == null){
            pAwal = pBaru;
            pAkhir = pBaru;
            jumlah = 0;
        } else {
            pBaru.setelah= pAwal;
            pAkhir.setelah = pBaru;
            pAwal = pBaru;
            jumlah++;
        }
    }

    public void SisipDataDiAkhir(Object data){
        NodeCSLL nodeBaru = new NodeCSLL();
        nodeBaru.data = data;
        nodeBaru.setelah = null;
        nodeBaru.setelah = nodeBaru;
        if (pAkhir == null){
            pAwal = nodeBaru;
            pAkhir = nodeBaru;
            jumlah = 0;
        } else {
            pAkhir.setelah = nodeBaru;
            nodeBaru.setelah = pAwal;
            pAkhir = nodeBaru;
            jumlah++;
        }
    }

    public void hapusData(Object dtHapus){
        if(pAwal != null) {
            NodeCSLL pSbl, pKini,pHapus;
            pSbl = null; pKini = pAwal;
            boolean ketemu = false;
            int i = 0;
            while(!ketemu && (i <= jumlah)){
                if (pKini.data.equals(dtHapus)) {
                    ketemu = true;
                }
                else {
                    pSbl = pKini;
                    pKini = pKini.setelah;
                }
                i++;
            }
            if (ketemu){
                if(pSbl == null) {
                    pHapus = pAwal;
                    pAwal = pKini.setelah;
                    pAkhir.setelah = pAwal;
                    pHapus = null;
                } else {
                    if (pAkhir == pKini) {
                        pAkhir = pSbl;
                    }
                    pSbl.setelah= pKini.setelah;
                    pHapus = pKini;
                    pHapus = null;
                }
                jumlah--;
            }
        }
    }

    public void hapusSatuDataDiAwal(){
        if (pAkhir == pAwal){
            pAkhir = pAwal = null;
            pAkhir.setelah = null;
            jumlah = 0;
        } else {
            pAwal = pAwal.setelah;
            pAkhir.setelah = pAwal;
            jumlah--;
        }
    }

    public void hapusSatuDataDiAkhir(){
        NodeCSLL temp = pAwal;
        if (pAkhir == pAwal){
            pAkhir = pAwal = null;
            pAkhir.setelah = null;
            jumlah = 0;
        } else {
            while (temp.setelah != pAkhir){
                temp = temp.setelah;
            }
            System.out.println(temp.data);
            pAkhir = temp;
            pAkhir.setelah = pAwal;
            jumlah--;
        }
    }

    public void cetak(String Komentar){
        System.out.println(Komentar);
        NodeCSLL pCetak;
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
        CircularSingleLinkedList csll = new CircularSingleLinkedList();
        csll.SisipDataDiAwal(new Integer(50));
        csll.SisipDataDiAwal(new Integer(60));
        csll.SisipDataDiAwal(new Integer(70));
        csll.SisipDataDiAwal(new Integer(8));
        csll.SisipDataDiAwal(new Integer(9));
        csll.SisipDataDiAwal(new Integer(90));
        csll.SisipDataDiAwal(new Integer(19));
        csll.cetak("csll Asal");
        csll.hapusData(8);
        csll.cetak("csll Setelah 8 dihapus");
        csll.hapusData(90);
        csll.cetak("csll Setelah 90 dihapus");
    }
}
