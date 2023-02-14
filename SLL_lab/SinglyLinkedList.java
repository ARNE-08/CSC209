public class SinglyLinkedList {
    SLLNode head, tail;

    public SinglyLinkedList() {
        head = tail = null;
    } // empty list that we create

    public boolean isEmpty() {
        return head == null;
    }

    public void addToTail(int newValue) {
        if (head == null) { // when the list is empty
            head = tail = new SLLNode(newValue);
        } else {
            tail.next = new SLLNode(newValue);
            tail = tail.next;
        }
    }

    public void addToHead(int newValue) {
        if (isEmpty()) {
            head = tail = new SLLNode(newValue, head);
        } else {
            head = new SLLNode(newValue, head); // new node point to the head and move head to new node
        }
    }

    public int deleteFromHead() {
        int firstInfo = head.info;
        if (head == tail) { // = have one node or no node
            head = tail = null;
        } else {
            head = head.next;
        }
        return firstInfo;
    }

    public void printAllNode() {
        int count = 0;
        for (SLLNode ptr = head; ptr != null; ptr = ptr.next) {
            System.out.println(count + " node: " + ptr.info);
            count++;
        }
        System.out.println("end at null");
    }

    public int deleteFromTail() {
        if (head == null) {
            return -1;

        } else if (head == tail) {
            int lastInfo = tail.info;
            head = tail = null;
            return lastInfo;
        } else {
            int lastInfo = tail.info;
            SLLNode ptr;
            for (ptr = head; ptr.next != tail; ptr = ptr.next) {
            }
            tail = ptr;
            ptr.next = null;
            return lastInfo;
        }
    }

    // homework
    public int deleteIthNode(int i) {
        if (head == tail || head == null) {
            return deleteFromTail();
        } else if (i == 0) {
            return deleteFromHead();
        } else {
            int info = tail.info;
            SLLNode ptr;
            int count = 0;
            for (ptr = head; ptr != null; ptr = ptr.next) {
                count++;
            }
            SLLNode temp = head;
            for (int j = 1; j <= count; j++) {
                if (j == i) {
                    temp.next = temp.next.next;
                    return info;
                }
                temp = temp.next;
            }
            return info;
        }
    }

    public void insertNodeAtIthInMiddle(int i, int newValue) {
        SLLNode ptr;
        int count = 0;
        for (ptr = head; ptr != null; ptr = ptr.next) {
            count++;
        }
        if (isEmpty()) {
            head = tail = new SLLNode(newValue);
        } else if (i == 0) {
            addToHead(newValue);
        } else if (i == count) {
            addToTail(newValue);
        } else {
            SLLNode temp = head;
            for (int j = 1; j <= count; j++) {
                if (j == i) {
                    temp.next = new SLLNode(newValue, temp.next);
                }
                temp = temp.next;
            }
        }
    }
}
