public interface MyListInterface {
    void addFirst(int item);

    void addLast(int item);

    void addAtIndex(int index, int item);

    Node removeFirst();

    Node removeLast();

    Node removeAtIndex(int index);

    int getSize();

    boolean isEmpty();

    void printList();

    void printListBackwards();

    int get(int index);

    void clear();

    void updateValueAt(int index, int newValue);
}
