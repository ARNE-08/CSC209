public class SLLNode {
    int info;
    SLLNode next; // can use as pointer because an object store an address

    public SLLNode(int i, SLLNode n) {
        info = i;
        next = n;
    }

    public SLLNode(int i) {
        this(i, null);
    }

    public int getInfo() {
        return info;
    }

    public SLLNode getNext() {
        return next;
    }

    public void setInfo(int i) {
        info = i;
    }

    public void setNext(SLLNode n) {
        next = n;
    }
}
