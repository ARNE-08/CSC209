public class SLL_lab {
    public static void main(String[] args) {
        // try to create a list manually
        System.out.println("What we do on Tuesday lab");
        SLLNode node1 = new SLLNode(30);
        System.out.println(node1.info + " " + node1.next);
        // System.out.println(node1.next.info); will give error
        SLLNode node2 = new SLLNode(40, node1);
        System.out.println(node2.info + " " + node2.next.info); // node2 is pointing to node 1

        SinglyLinkedList list1 = new SinglyLinkedList();
        System.out.println(list1.head);
        list1.addToTail(66);
        System.out.println(list1.head.info + " " + list1.tail.info);
        list1.addToTail(79);
        System.out.println(list1.head.info + " " + list1.head.next.info);
        list1.addToHead(34); // 34 -> 66 -> 79
        System.out.println(list1.head.info + " " + list1.head.next.info + " " + list1.head.next.next.info);
        System.out.println(list1.tail.info);
        list1.addToHead(71); // 71 -> 34 -> 66 -> 79
        // System.out.println("1st: " + list1.head.info + " 2nd: " +
        // list1.head.next.info + " 3rd: "
        // + list1.head.next.next.info + " 4th: " + list1.head.next.next.next.info);
        list1.printAllNode();
        System.out.println("-----------------------");
        list1.deleteFromHead();
        // System.out.println("1st: " + list1.head.info + " 2nd: " +
        // list1.head.next.info + " 3rd: "
        // + list1.head.next.next.info);

        list1.printAllNode();
        list1.addToHead(61);
        list1.addToHead(40);
        list1.addToTail(59);
        list1.addToHead(80);
        System.out.println("-----------------------");
        list1.printAllNode();

        list1.deleteFromTail();
        System.out.println("-----------------------");
        list1.printAllNode();

        list1.deleteFromTail();
        System.out.println("-----------------------");
        list1.printAllNode();

        SinglyLinkedList list2 = new SinglyLinkedList();
        list2.addToHead(10);
        System.out.println("-----------------------");
        list2.printAllNode();
        // list2.deleteFromTail();
        // System.out.println("-----------------------");
        // list2.printAllNode();

        System.out.println("\n##### Homework tester #####\n================================\n");
        System.out.println("Delete Ith from normal list");
        System.out.println("before");
        list1.printAllNode();
        int i = 2;
        list1.deleteIthNode(i);
        System.out.println("-----------------------");
        System.out.println("Delete " + i + " node");
        list1.printAllNode();

        // System.out.println("-----------------------");
        // list2.printAllNode();
        // System.out.println("-----------------------");
        // list2.deleteIthNode(0);
        // list2.printAllNode();

        // empty list
        SinglyLinkedList list3 = new SinglyLinkedList();
        list3.deleteIthNode(0);
        System.out.println("-----------------------");
        System.out.println("Delete Ith from empty list");
        list3.printAllNode();

        System.out.println("-----------------------");
        System.out.println("Add to Ith in normal list");
        System.out.println("before");
        list1.printAllNode();
        System.out.println("-----------------------");
        System.out.println("Add 99 to second node");
        list1.insertNodeAtIthInMiddle(2, 99);
        list1.printAllNode();

        // add Ith to empty list
        System.out.println("-----------------------");
        System.out.println("Add to Ith in empty list");
        SinglyLinkedList list4 = new SinglyLinkedList();
        list4.insertNodeAtIthInMiddle(0, 11);
        list4.printAllNode();
    }
}
