package TDAs;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList<E> implements Iterable<E> {

    // --- Clase Nodo ---
    private static class Node<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;

        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }

        public E getElement() { return element; }
        public Node<E> getPrev() { return prev; }
        public Node<E> getNext() { return next; }

        public void setPrev(Node<E> prev) { this.prev = prev; }
        public void setNext(Node<E> next) { this.next = next; }
    }

    // --- Atributos ---
    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;

    // --- Constructor ---
    public DoublyLinkedList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }

    // --- Métodos Básicos ---
    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    public E first() {
        if (isEmpty()) return null;
        return header.getNext().getElement();
    }

    public E last() {
        if (isEmpty()) return null;
        return trailer.getPrev().getElement();
    }

    // --- Métodos de Inserción ---
    public void addFirst(E e) {
        addBetween(e, header, header.getNext());
    }

    public void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer);
    }

    private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }

    // --- Métodos de Eliminación ---
    public E removeFirst() {
        if (isEmpty()) return null;
        return remove(header.getNext());
    }

    public E removeLast() {
        if (isEmpty()) return null;
        return remove(trailer.getPrev());
    }

    public boolean remove(E e) {
        Node<E> actual = header.getNext();
        while (actual != trailer) {
            if (actual.getElement().equals(e)) {
                remove(actual);
                return true;
            }
            actual = actual.getNext();
        }
        return false;
    }

    private E remove(Node<E> node) {
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }

    // --- Métodos de Búsqueda ---
    public int findIndex(E e) {
        Node<E> actual = header.getNext();
        int index = 0;

        while (actual != trailer) {
            if (actual.getElement().equals(e)) {
                return index;
            }
            actual = actual.getNext();
            index++;
        }
        return -1;
    }

    // --- Implementación Iterable ---
    @Override
    public Iterator<E> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<E> {
        private Node<E> current = header.getNext();

        @Override
        public boolean hasNext() {
            return current != trailer;
        }

        @Override
        public E next() {
            if (!hasNext()) throw new NoSuchElementException();
            E element = current.getElement();
            current = current.getNext();
            return element;
        }
    }

    public void bubbleSort(){
        this.bubbleSort(new DefaultComparator<E>());
    }

    public void bubbleSort(java.util.Comparator<E> comp){
        if (size <= 1){return;}

        boolean swapped;

        Node <E> rightLimit = trailer;

        do{
            swapped = false;
            Node <E> current = header.getNext();

            while(current.getNext() != rightLimit){
                Node<E> nextNode = current.getNext();

                if(comp.compare(current.element, nextNode.element) > 0){

                    E temp = current.element;
                    current.element = nextNode.element;
                    nextNode.element = temp;

                    swapped = true;
                }

                current = current.getNext();
            }

            rightLimit = current;

        }while(swapped);
    }

    public void insertionSort(){
        this.insertionSort(new DefaultComparator<E>());
    }

    public void insertionSort(java.util.Comparator<E> comp){
        if (size <= 1){ return; }

        Node<E> current = header.getNext().getNext();

        while(current != trailer){
            Node<E> walk = current;

            while(walk.getPrev() != header &&
                  comp.compare(walk.getPrev().element, walk.element) > 0){

                E temp = walk.element;
                walk.element = walk.getPrev().element;
                walk.getPrev().element = temp;

                walk = walk.getPrev();
            }

            current = current.getNext();
        }
    }

    public void mergeSort(){
        this.mergeSort(new DefaultComparator<E>());
    }

    public void mergeSort(java.util.Comparator<E> comp){
        if (size <= 1) { return; }
        if (comp == null) { comp = new DefaultComparator<E>(); }

        Node<E> firstNode = header.getNext();
        Node<E> lastNode = trailer.getPrev();

        firstNode.setPrev(null);
        lastNode.setNext(null);

        Node<E> sortedHead = mergeSortNodes(firstNode, comp);

        header.setNext(sortedHead);

        Node<E> previous = header;
        Node<E> current = sortedHead;

        while (current != null) {
            current.setPrev(previous);
            previous = current;
            current = current.getNext();
        }

        previous.setNext(trailer);
        trailer.setPrev(previous);
    }

    private Node<E> mergeSortNodes(Node<E> head, java.util.Comparator<E> comp){
        if (head == null || head.getNext() == null) {
            return head;
        }

        Node<E> secondHalf = splitInHalf(head);

        Node<E> left = mergeSortNodes(head, comp);
        Node<E> right = mergeSortNodes(secondHalf, comp);

        return mergeNodes(left, right, comp);
    }

    private Node<E> splitInHalf(Node<E> head){
        Node<E> slow = head;
        Node<E> fast = head;

        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        Node<E> secondHalf = slow.getNext();
        slow.setNext(null);
        if (secondHalf != null) {
            secondHalf.setPrev(null);
        }

        return secondHalf;
    }

    private Node<E> mergeNodes(Node<E> left, Node<E> right, java.util.Comparator<E> comp){
        Node<E> dummy = new Node<>(null, null, null);
        Node<E> tail = dummy;

        while (left != null && right != null) {
            if (comp.compare(left.getElement(), right.getElement()) <= 0) {
                Node<E> next = left.getNext();
                tail.setNext(left);
                left.setPrev(tail);
                tail = left;
                left = next;
            } else {
                Node<E> next = right.getNext();
                tail.setNext(right);
                right.setPrev(tail);
                tail = right;
                right = next;
            }
        }

        Node<E> remaining = (left != null) ? left : right;
        while (remaining != null) {
            Node<E> next = remaining.getNext();
            tail.setNext(remaining);
            remaining.setPrev(tail);
            tail = remaining;
            remaining = next;
        }

        Node<E> mergedHead = dummy.getNext();
        if (mergedHead != null) {
            mergedHead.setPrev(null);
        }
        tail.setNext(null);

        return mergedHead;
    }
}
