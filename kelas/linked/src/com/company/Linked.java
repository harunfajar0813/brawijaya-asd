package com.company;

public class Linked {
    Node head;
    static int volume = 0;

    static class Node{
        Student person;
        Node next;
        Node(Student person){
            this.person = person;
            next = null;
        }
    }

    static class Student{
        String id;
        String name;

        Student(String id, String name) {
            this.id = id;
            this.name = name;
            volume++;
        }

        @Override
        public String toString() {
            return String.format("\nID : " + id +
                    "\nName : " + name +
                    "\n");
        }
    }

    // insert
    void push(Student new_person){
        Node new_node = new Node(new_person);
        new_node.next = head;
        head = new_node;
        return;
    }

    void insertAfter(Node previous_node, Student new_person){
        if (previous_node == null){
            System.out.println("Failed");
        }

        Node new_node = new Node(new_person);
        new_node.next = previous_node.next;
        previous_node.next = new_node;
        return;
    }

    void append(Student new_person){
        Node new_node = new Node(new_person);

        if (head == null){
            head = new Node(new_person);
            return;
        }

        new_node.next = null;
        Node last = head;
        while (last.next != null)
            last = last.next;

        last.next = new_node;
        return;
    }

    // Delete
    void deleteFirst(){
        Node temp = head;

        if (temp == null)
            return;

        head = head.next;
        volume--;
        return;
    }

    void deleteNode(int target){
        if (head == null)
            return;

        Node temp = head;

        if (target == 0){
            head = temp.next;
            return;
        }

        for (int i=0; temp!=null && i < target-1; i++)
            temp = temp.next;

        if (temp == null || temp.next == null)
            return;

        Node next = temp.next.next;

        temp.next = next;
    }

    void deleteLast(){
        Node temp = head;

        if (temp == null) return;
        if (temp.next == null) return;

        Node second_last = head;
        while (second_last.next.next != null)
            second_last = second_last.next;

        second_last.next = null;
        volume--;
        return;
    }

    void show(){
        Node node = head;
        while (node != null){
            System.out.print(node.person);
            node = node.next;
        }
        return;
    }

    public static void main(String[] args) {
        Linked school = new Linked();
        Node[] nodes = {
                new Node(new Student("185", "Harun")),
                new Node(new Student("186", "Ulum")),
                new Node(new Student("187", "Fajar")),
                new Node(new Student("188", "Reza")),
                new Node(new Student("189", "Phil"))
        };

        for (int index=0;index < nodes.length; index++){
            if (school.head == null) {
                school.head = nodes[index];
                school.head.next = nodes[index+1];
            } else {
                if (index == (nodes.length - 1))
                    break;
                else
                    nodes[index].next = nodes[index+1];
            }
        }

        school.push(new Student("189", "Phil"));
        school.append(new Student("189", "Lianto"));
        school.show();
        System.out.print("\nVolume : " + volume);
    }
}
