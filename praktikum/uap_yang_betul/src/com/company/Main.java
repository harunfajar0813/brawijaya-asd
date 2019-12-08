package com.company;
import java.util.*;

class Node {
    private String name;
    private HashMap<String, Node> relations;

    public Node(String name) {
        this.name = name;
        this.relations = new HashMap<String, Node>();
    }

    public String getName() {
        return this.name;
    }

    public void addRelation(String relation, Node subject) {
        this.relations.put(relation, subject);
    }

    public Node findNodeByRelation(String relation) {
        return this.relations.get(relation);
    }
}

class FamilyGraph {
    private ArrayList<Node> listFamilyMember;
    public FamilyGraph(ArrayList<String> listName, ArrayList<String> listRelation) {
        this.listFamilyMember = new ArrayList<Node>();
        initializeGraph(listName, listRelation);
    }

    private void initializeGraph(ArrayList<String> listName, ArrayList<String> listRelation) {
        listName.forEach(name -> {
            Node newNode = new Node(name);
            listFamilyMember.add(newNode);
        });

        listRelation.forEach(relation -> {
            addRelation(relation);
        });
    }

    public void addRelation(String relation) {
        String rel[] = relation.split(" ");
        for(int i = 0; i < listFamilyMember.size(); i++) {
            Node n = listFamilyMember.get(i);
            if (n.getName().equals(rel[2])) {
                boolean go = true;
                int jml = 0;
                while (go) {
                    if (n.findNodeByRelation(rel[1] + Integer.toString(jml)) == null) {
                        break;
                    }
                    jml++;
                }

                n.addRelation(rel[1] + Integer.toString(jml), new Node(rel[0]));
            }
        }
    }

    public String executeQuery(String query) {
        String q[] = query.split(" ");
        String r = "";
        for(int i = 0; i < listFamilyMember.size(); i++) {
            Node n = listFamilyMember.get(i);
            if (n.getName().equals(q[1])) {
                boolean go = true;
                int jml = 0;
                while (go) {
                    if (n.findNodeByRelation(q[0] + Integer.toString(jml)) == null) {
                        break;
                    } else {
                        r += n.findNodeByRelation(q[0] + Integer.toString(jml)).getName() + " ";
                        jml++;
                    }
                }
            }
        }

        return r;
    }

}

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> listName = new ArrayList<String>();
        ArrayList<String> listRelation = new ArrayList<String>();
        ArrayList<String> listQuery = new ArrayList<String>();

        while (true) {
            String line = scanner.nextLine();

            if (line.equals("EXIT")) {
                break;
            } else {
                String command = line.split(" -> ")[0];
                String param = line.split(" -> ")[1];

                switch (command) {
                    case "ADD":
                        listName.add(param);
                        break;
                    case "RELATION":
                        listRelation.add(param);
                        break;
                    case "QUERY":
                        listQuery.add(param);
                        break;
                }
            }
        }

        FamilyGraph familyGraph = new FamilyGraph(listName, listRelation);

        listQuery.forEach(query -> {
            System.out.println(familyGraph.executeQuery(query));
        });
    }
}
