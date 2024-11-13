public class LinkedList {
    private Node head;

    static class Node {
        int data;
        Node nextNode;

        Node(int value) {
            data = value;
            nextNode = null;
        }
    }

    public static void main(String[] args) {
        LinkedList l = new LinkedList();
    }

    public static void AddNode(LinkedList l, int i) {
        Node newNode = new Node(i);
        if (l.head == null) {
            l.head = newNode;
        } else {
            Node current = l.head;
            while (current.nextNode != null) {
                current = current.nextNode;
            }
            current.nextNode = newNode;
        }
    }

    public static int Nth(LinkedList l, int n) {
        if (Length(l) >= n) {
            Node current = l.head;
            for (int i = n; i > 1; i--) {
                current = current.nextNode;
            }
            return current.data;
        }
        else {return -99999999;}
    }

    public static int RetrieveHead(LinkedList l) {
        return l.head.data;
    }

    public static int Length(LinkedList l) {
        int length = 0;
        Node current = l.head;
        while (current != null) {
            length++;
            current = current.nextNode;
        }
        return length;
    }

    public static void Remove(LinkedList l, int n) {
        Node prev = l.head;
        Node current = l.head.nextNode;
        for (int i = n; i > 2; i--) {
            current = current.nextNode;
            prev = prev.nextNode;
        }
        prev.nextNode = current.nextNode;;
    }

    public static boolean CheckForCycle(LinkedList l) {
        if (l.head == null) {
            return false;
        }
        Node slow = l.head;
        Node fast = l.head.nextNode;
        while (slow != fast) {
            if (fast.nextNode == null || fast.nextNode.nextNode == null) {
                return false;
            } else {
                fast = fast.nextNode.nextNode;
                slow = slow.nextNode;
            }
        }
        return true;
    }

}
