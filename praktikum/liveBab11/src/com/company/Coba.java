package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.HashSet;
import java.util.Set;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

class Node {
    public final String value;
    public double pathCost;
    public Edge[] adjacencies;
    public Node parent;

    public Node(String val) {

        value = val;

    }

    public String toString() {
        return value;
    }

}

class Edge {
    public final double cost;
    public final Node target;

    public Edge(Node targetNode, double costVal) {
        cost = costVal;
        target = targetNode;
    }
}

public class Coba {
    static int hitungJarak = 0;

    public static void main(String[] args) throws IOException {
        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node E = new Node("E");
        Node F = new Node("F");
        Node G = new Node("G");

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] splitInput = input.readLine().split(" ");
        ArrayList<Node> kumpulan = new ArrayList<Node>();
        kumpulan.add(A);
        kumpulan.add(B);
        kumpulan.add(C);
        kumpulan.add(D);
        kumpulan.add(E);
        kumpulan.add(F);
        kumpulan.add(G);

        Node Sementara1 = A;
        Node Sementara2 = E;
        for (int i = 0; i < kumpulan.size(); i++) {
            if (splitInput[0].equals(kumpulan.get(i).value)) {
                Sementara1 = kumpulan.get(i);
            }
        }

        for (int i = 0; i < kumpulan.size(); i++) {
            if (splitInput[1].equals(kumpulan.get(i).value)) {
                Sementara2 = kumpulan.get(i);
            }
        }

        A.adjacencies = new Edge[]{
                new Edge(B, 80),
                new Edge(G, 80),
                new Edge(F, 70)
        };

        B.adjacencies = new Edge[]{
                new Edge(A, 80),
                new Edge(C, 90),
                new Edge(D, 100),
                new Edge(G, 50),
        };

        C.adjacencies = new Edge[]{
                new Edge(B, 90),
                new Edge(D, 50)
        };

        D.adjacencies = new Edge[]{
                new Edge(B, 100),
                new Edge(C, 50),
                new Edge(E, 60),
                new Edge(F, 90),
        };

        E.adjacencies = new Edge[]{
                new Edge(D, 60),
                new Edge(F, 70)
        };

        F.adjacencies = new Edge[]{
                new Edge(A, 70),
                new Edge(D, 90),
                new Edge(E, 70),
                new Edge(G, 40)
        };

        G.adjacencies = new Edge[]{
                new Edge(A, 80),
                new Edge(B, 50),
                new Edge(F, 40)
        };

        UniformCostSearch(Sementara1, Sementara2);

        List<Node> path = printPath(Sementara2);

        for (Node n : path) {
            System.out.print(n + " -> ");
        }
        System.out.println("finish");

        Node now = Sementara1;
        int ke = 1;
        while (!now.equals(Sementara2)) {
            Node next = new Node("Z");

            for (Edge i : now.adjacencies) {
                if (i.target.equals(path.get(ke))) {
                    next = i.target;
                    hitungJarak += i.cost;
                    break;
                }
            }
            ke++;
            now = next;
        }
        System.out.println(hitungJarak);
    }

    public static void UniformCostSearch(Node source, Node goal) {
        source.pathCost = 0;
        PriorityQueue<Node> queue = new PriorityQueue<Node>(20, new Comparator<Node>() {
            public int compare(Node i, Node j) {
                if (i.pathCost > j.pathCost) {
                    return 1;
                } else if (i.pathCost < j.pathCost) {
                    return -1;
                } else {
                    return 0;

                }
            }
        }
        );
        queue.add(source);
        Set<Node> explored = new HashSet<Node>();
        boolean found = false;
        do {

            Node current = queue.poll();
            explored.add(current);
            if (current.value.equals(goal.value)) {
                found = true;

            }

            for (Edge e : current.adjacencies) {
                Node child = e.target;
                double cost = e.cost;
                if (!explored.contains(child) && !queue.contains(child)) {
                    child.pathCost = current.pathCost + cost;
                    child.parent = current;
                    queue.add(child);

                } else if ((queue.contains(child)) && (child.pathCost > (current.pathCost + cost))) {
                    child.parent = current;
                    child.pathCost = current.pathCost + cost;
                    queue.remove(child);
                    queue.add(child);
                }
            }
        } while (!queue.isEmpty() && (found == false));

    }

    public static List<Node> printPath(Node target) {
        List<Node> path = new ArrayList<Node>();
        for (Node node = target; node != null; node = node.parent) {
            path.add(node);
        }
        Collections.reverse(path);
        return path;
    }
}