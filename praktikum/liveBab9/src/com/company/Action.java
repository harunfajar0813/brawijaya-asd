package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Action {
    static class Node {
        int data;
        Node left;
        Node right;
        String nama;

        public Node(int data, String nama) {
            this.data = data;
            this.nama = nama;
            left = right = null;
        }

        public void sisipDt(int dtSisip, String dtNama) {
            if (dtSisip < data) {
                if (left == null) left = new Node(dtSisip, dtNama);
                else left.sisipDt(dtSisip, dtNama);
            } else if (dtSisip > data) {
                if (right == null) right = new Node(dtSisip, dtNama);
                else right.sisipDt(dtSisip, dtNama);
            }
        }
    }

    static class Tree {
        private Node root, temp;
        private int result;

        public Tree() {
            root = null;
        }

        public Node getTemp() {
            return temp;
        }

        public int getResult() {
            return result;
        }

        public void sisipDtNode(int dtSisip, String dtNama) {
            if (root == null) root = new Node(dtSisip, dtNama);
            else root.sisipDt(dtSisip, dtNama);
        }

        public void cariLewatPreorder(String nama) {
            lewatPreorder(root, nama);
        }

        private void lewatPreorder(Node node, String nama) {
            if (node == null) return;

            if (node.nama.equalsIgnoreCase(nama)) temp = node;
            lewatPreorder(node.left, nama);
            lewatPreorder(node.right, nama);
        }

        public void hitungPreorderResult(Node node) {
            if (result != 0) result = 0;
            preorderResult(node);
            result -= (node.data * 2);
        }

        private void preorderResult(Node node) {
            if (node == null) return;

            result += node.data;
            preorderResult(node.left);
            preorderResult(node.right);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int batas = Integer.parseInt(input.readLine());
        Tree tree = new Tree();

        for (int i = 0; i < batas; i++) {
            String perintah = input.readLine();
            String split[] = perintah.split(" ");
            tree.sisipDtNode(Integer.parseInt(split[1]), split[0]);
        }

        String[] nama = input.readLine().split(" ");
        tree.cariLewatPreorder(nama[0]);
        tree.hitungPreorderResult(tree.getTemp());
        System.out.println(tree.getResult());
    }
}