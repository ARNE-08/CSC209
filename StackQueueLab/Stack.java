public class Stack {
    int[] st;
    int top;

    public Stack(int cap) {
        st = new int[cap];
        top = 0;
    }

    public Stack() {
        this(100);
    }

    public boolean isFull() {
        return top >= st.length;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public int pop() {
        int x = -1;
        if (!isEmpty()) {
            x = st[top - 1];
            top--;
        } else {
            System.out.println("Stack is empty.");
        }
        return x;
    }

    public void push(int newMember) {
        if (!isFull()) {
            st[top] = newMember;
            top++;
        } else {
            System.out.println("Stack is full. It cannot add a new item");
        }
    }

    public int topEl() {
        int x = -1;
        if (!isEmpty()) {
            x = st[top - 1];
        } else {
            System.out.println("Stack is empty.");
        }
        return x;
    }

    public int size() {
        return top;
    }

    public void reverse() {
        int[] temp = new int[st.length];
        for (int i = 0; i < top; i++) {
            temp[i] = st[top - i - 1];
        }
        st = temp;
    }

    public void reverse2() {
        for (int i = 0; i < top / 2; i++) {
            int temp = st[i];
            st[i] = st[top - i - 1];
            st[top - i - 1] = temp;
        }
    }
}
