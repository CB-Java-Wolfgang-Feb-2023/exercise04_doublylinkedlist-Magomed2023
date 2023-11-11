public class DoublyLinkedListCustom implements MyListInterface {
    private Node head;
    private Node tail;
    private int size;

    @Override
    public void addFirst(int item) {
        Node node = new Node(item);
        if (head == null) {
            head = tail = node;
        } else {
            node.setNext(head);
            head.setPrevious(node);
            head = node;
        }
        size++;
    }

    @Override
    public void addLast(int item) {
        Node node = new Node(item);
        if (head == null) {
            head = tail = node;
        } else {
            node.setPrevious(tail);
            tail.setNext(node);
            tail = node;
        }
        size++;
    }

    @Override
    public void addAtIndex(int index, int item) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Index out of bounds");
        }
        if (index == 0) {
            addFirst(item);
        } else if (index == size) {
            addLast(item);
        } else {
            Node node = new Node(item);
            Node current = head;

            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }

            node.setNext(current.getNext());
            node.setPrevious(current);
            current.getNext().setPrevious(node);
            current.setNext(node);

            size++;
        }
    }

    @Override
    public Node removeFirst() {
        if (head == null) {
            return null;
        }

        Node removedNode = head;
        head = head.getNext();

        if (head != null) {
            head.setPrevious(null);
        } else {
            tail = null;
        }

        size--;
        return removedNode;
    }

    @Override
    public Node removeLast() {
        if (tail == null) {
            return null;
        }

        Node removedNode = tail;
        tail = tail.getPrevious();

        if (tail != null) {
            tail.setNext(null);
        } else {
            head = null;
        }

        size--;
        return removedNode;
    }

    @Override
    public Node removeAtIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index out of bounds");
        }
        if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        } else {
            Node current = head;

            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }

            Node removedNode = current.getNext();
            current.setNext(removedNode.getNext());

            if (removedNode.getNext() != null) {
                removedNode.getNext().setPrevious(current);
            }

            size--;
            return removedNode;
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.getValue() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

    @Override
    public void printListBackwards() {
        Node current = tail;
        while (current != null) {
            System.out.print(current.getValue() + " ");
            current = current.getPrevious();
        }
        System.out.println();
    }

    @Override
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index out of bounds");
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getValue();
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public void updateValueAt(int index, int newValue) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index out of bounds");
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        current.setValue(newValue);
    }
}
