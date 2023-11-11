public class Main {
    public static void main(String[] args) {
        DoublyLinkedListCustom list = new DoublyLinkedListCustom();
        list.addFirst(1);
        list.addLast(3);
        list.addAtIndex(1, 2);

        list.updateValueAt(1, 5);

        list.printList();

        list.printListBackwards();

        System.out.println("Size of list: " + list.getSize());

        System.out.println("Element at index 1: " + list.get(1));

        Node firstNode = list.removeFirst();
        if (firstNode != null) {
            System.out.println("Removed first element: " + firstNode.getValue());
        }

        Node removedNode = list.removeAtIndex(1);
        if (removedNode != null) {
            System.out.println("Removed element at index 1: " + removedNode.getValue());
        }

        Node lastNode = list.removeLast();
        if (lastNode != null) {
            System.out.println("Removed last element: " + lastNode.getValue());
        }

        list.printList();
        System.out.println("Is list empty? " + list.isEmpty());

        list.clear();
        System.out.println("Size of list after clearing: " + list.getSize());
        System.out.println("Is list empty after clearing? " + list.isEmpty());
    }
}