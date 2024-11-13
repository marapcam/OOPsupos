public class Stack {

    private Item head;

    static class Item {
        int data;
        Stack.Item nextInStack;

        Item(int value) {
            data = value;
            nextInStack = null;
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
    }

    public static int Pop(Stack s) {
        int value = s.head.data;
        s.head = s.head.nextInStack;
        return value;
    }

    public static void Push(Stack s, int i) {
        Item newItem = new Stack.Item(i);
        newItem.nextInStack = s.head;
        s.head = newItem;
    }

}
