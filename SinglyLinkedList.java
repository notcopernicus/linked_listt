public class SinglyLinkedList<T> {
    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public SinglyLinkedList() {
        head = tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addLast(T value) {
        Node<T> node = new Node<>(value);
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public T removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        T value = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return value;
    }

    public boolean remove(T value) {
        if (isEmpty()) return false;

        if (value == null ? head.value == null : value.equals(head.value)) {
            removeFirst();
            return true;
        }

        Node<T> prev = head;
        Node<T> curr = head.next;

        while (curr != null) {
            if (value == null ? curr.value == null : value.equals(curr.value)) {
                prev.next = curr.next;
                if (curr == tail) tail = prev;
                size--;
                return true;
            }
            prev = curr;
            curr = curr.next;
        }
        return false;
    }

    public boolean contains(T value) {
        Node<T> curr = head;
        while (curr != null) {
            if (value == null ? curr.value == null : value.equals(curr.value)) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    public T[] toArray() {
        Object[] arr = new Object[size];
        int i = 0;
        Node<T> curr = head;
        while (curr != null) {
            arr[i++] = curr.value;
            curr = curr.next;
        }
        return (T[]) arr;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder("[");
        Node<T> curr = head;
        while (curr != null) {
            sb.append(curr.value);
            if (curr.next != null) sb.append(", ");
            curr = curr.next;
        }
        sb.append("]");
        return sb.toString();
    }
}