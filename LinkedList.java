public class LinkList implements IList {
    private static Node head = null;
    private static Node temp;

    static class Node {
        Node next = null;
        Object data;
        private Node() {}
        private Node(Object data) {
            this.data = data;
        }
        private Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LinkList link = new LinkList();
        link.add(1);
        link.add(2);
        link.add(3);
        link.add(4);
        link.display(head);
        link.get(2);
        link.indexOf(3);
        link.remove(0);
        link.display(head);
        System.out.println(link.length());
        link.insert(0,1);
        link.display(head);
    }

    @Override
    public void add(int data) {
        Node p = new Node(data);
        if (head == null) {
            head = p;
            temp = head;
        }else {
            temp.next = p;
            temp = temp.next;
        }
    }

    @Override
    public void clear() {
        head.data = null;
        while (head != null) {
            head = head.next;
            head = null;
        }
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int length() {
        int length = 1;
        if (null == head) {
            return 0;
        }
        Node p = head;
        while (p.next != null) {
            p = p.next;
            length++;
        }
        return length;
    }

    @Override
    public Object get(int i) {
        Node p = head;
        if (i < 0 || i > length()-1) {
            System.out.println("Exception");
        }else {
            for (int j = 0; j < i; j++) {
                p = p.next;
            }
        }
        System.out.println(p.data);
        return p.data;
    }

    @Override
    public void insert(int i, Object x) {
        Node p = head;
        Node n = new Node(x);
        if (0 == i) {
            n.next = head;
            head = n;
        }else {
            for (int j = 0; j < i; j++) {
                n.next = p.next;
                p.next = n;
            }
            for (int k = i; k < length(); k++) {
                p = p.next;
            }
        }
    }

    @Override
    public void remove(int i) {
        if (0 == i) {
            head = head.next;
        }else {
            Node p = head;
            for (int j = 0; j < i - 1; j++) {
                p = p.next;
            }
            p.next = p.next.next;
            for (int k = i; k < length(); k++) {
                p = p.next;
            }
        }
    }

    @Override
    public void display(Node temp) {
        if (temp == null) {
            System.out.println("null");
        }else {
            System.out.print(temp.data+"->");
            Node p = temp.next;
            display(p);
        }
    }

    @Override
    public void indexOf(Object x) {
        Node p = head;
        for (int i = 0; i < length(); i++) {
            if (p.data == x) {
                System.out.println(i);
                break;
            }
            p = p.next;
        }
        if (p == null) {
            System.out.println("not found");
        }
    }
}
