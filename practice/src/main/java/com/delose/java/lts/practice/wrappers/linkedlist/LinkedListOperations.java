package com.delose.java.lts.practice.wrappers.linkedlist;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;

public class LinkedListOperations<T> {

    private LinkedList<T> linkedList;

    public LinkedListOperations() {
        linkedList = new LinkedList<>();
    }

    /**
     * Add an item to the list
     */
    public boolean add(T item) {
        return this.linkedList.add(item);
    }

    /**
     * Add a collection of items to the list
     */
    public boolean addAll(Collection<T> items) {
        return this.linkedList.addAll(items);
    }

    /**
     * Adds an item to the beginning of the list
     */
    public void addFirst(T item) {
        this.linkedList.addFirst(item);
    }

    /**
     * Adds an item to the end of the list
     */
    public void addLast(T item) {
        this.linkedList.addLast(item);
    }

    /**
     * Remove all items from the list
     */
    public void clear() {
        this.linkedList.clear();
    }

    /**
     * Create a copy of the LinkedList
     */
    @SuppressWarnings("unchecked")
    public LinkedList<T> clone() {
        return (LinkedList<T>) this.linkedList.clone();
    }

    /**
     * Checks whether an item exist in the list
     */
    public boolean contains(T item) {
        return this.linkedList.contains(item);
    }

    /**
     * Returns an iterator to loop through the items of the list in reverse order
     */
    public java.util.Iterator<T> descendingIterator() {
        return this.linkedList.descendingIterator();
    }

    /**
     * Retrieves the first item in the list
     * Similar to getFirst()
     */
    public T element() {
        return this.linkedList.element();
    }

    /**
     * Perform an action on every item in the list
     */
    public void forEach(java.util.function.Consumer<? super T> action) {
        this.linkedList.forEach(action);
    }

    /**
     * Return the item at a specific position in the list
     */
    public T get(int index) {
        return this.linkedList.get(index);
    }

    /**
     * Returns the first item in the list
     */
    public T getFirst() {
        return this.linkedList.getFirst();
    }

    /**
     * Returns the last item in the list
     */
    public T getLast() {
        return this.linkedList.getLast();
    }

    /**
     * Return the position of the first occurrence of an item in the list
     */
    public int indexOf(T item) {
        return this.linkedList.indexOf(item);
    }

    /**
     * Checks whether the list is empty
     */
    public boolean isEmpty() {
        return this.linkedList.isEmpty();
    }

    /**
     * Return an Iterator object for the LinkedList
     */
    public Iterator<T> iterator() {
        return this.linkedList.iterator();
    }

    /**
     * Return the position of the last occurrence of an item in the list
     */
    public int lastIndexOf(T item) {
        return this.linkedList.lastIndexOf(item);
    }

    /**
     * Return a ListIterator object for the LinkedList
     */
    public ListIterator<T> listIterator() {
        return this.linkedList.listIterator();
    }

    /**
     * Adds an item at the end of the list
     */
    public boolean offer(T item) {
        return this.linkedList.offer(item);
    }

    /**
     * Adds an item at the beginning of the list
     */
    public boolean offerFirst(T item) {
        return this.linkedList.offerFirst(item);
    }

    /**
     * Adds an item at the end of the list
     */
    public boolean offerLast(T item) {
        return this.linkedList.offerLast(item);
    }

    /**
     * Retrieves the first item in the list
     * Similar to getFirst()
     */
    public T peek() {
        return this.linkedList.peek();
    }

    /**
     * Retrieves the first item in the list.
     * Similar to peek()
     */
    public T peekFirst() {
        return this.linkedList.peekFirst();
    }

    /**
     * Retrieves the last item in the list
     */
    public T peekLast() {
        return this.linkedList.peekLast();
    }

    /**
     * Retrieves and removes the first item in the list.
     */
    public T poll() {
        return this.linkedList.poll();
    }

    /**
     * Retrieves and removes the first item in the list.
     * Similar to poll()
     */
    public T pollFirst() {
        return this.linkedList.pollFirst();
    }

    /**
     * Retrieves and removes the last item in the list.
     */
    public T pollLast() {
        return this.linkedList.pollLast();
    }

    /**
     * Returns the first element in the list.
     * Similar to removeFirst()
     */
    public T pop() {
        return this.linkedList.pop();
    }

    /**
     * Adds an item to the beginning of the list.
     * Similar to addFirst()
     */
    public void push(T item) {
        this.linkedList.push(item);
    }

    /**
     * Remove an item from the list
     */
    public boolean remove(T item) {
        return this.linkedList.remove(item);
    }

    /**
     * Remove a collection of items from the list
     */
    public boolean removeAll(Collection<T> items) {
        return this.linkedList.removeAll(items);
    }

    /**
     * Removes the first item in the list
     */
    public T removeFirst() {
        return this.linkedList.removeFirst();
    }

    /**
     * Removes the first occurrence of a specified item in the list
     */
    public boolean removeFirstOccurence(T item) {
        return this.linkedList.removeFirstOccurrence(item);
    }

    /**
     * Remove all items from the list which meet a specified condition
     */
    public boolean removeIf(java.util.function.Predicate<? super T> filter) {
        return this.linkedList.removeIf(filter);
    }

    /**
     * Removes the last item in the list
     */
    public T removeLast() {
        return this.linkedList.removeLast();
    }

    /**
     * Removes the last occurrence of a specified item in the list
     */
    public boolean removeLastOccurence(T item) {
        return this.linkedList.removeLastOccurrence(item);
    }

    /**
     * Replace each item in the list with the result of an operation on that item
     */
    public void replaceAll(java.util.function.UnaryOperator<T> operator) {
        this.linkedList.replaceAll(operator);
    }

    /**
     * Remove all elements from the list which do not belong to a specified collection
     */
    public boolean retainAll(Collection<T> items) {
        return this.linkedList.retainAll(items);
    }

    /**
     * Replace an item at a specified position in the list
     */
    public T set(int index, T item) {
        return this.linkedList.set(index, item);
    }

    /**
     * Return the number of items in the list
     */
    public int size() {
        return this.linkedList.size();
    }

    /**
     * Sort the list
     */
    public void sort(java.util.Comparator<? super T> comparator) {
        this.linkedList.sort(comparator);
    }

    /**
     * Return a Spliterator object for the LinkedList
     */
    public Spliterator<T> spliterator() {
        return this.linkedList.spliterator();
    }

    /**
     * Return a sublist which provides access to a range of this list's items
     */
    public List<T> subList(int fromIndex, int toIndex) {
        return this.linkedList.subList(fromIndex, toIndex);
    }

    /**
     * Return an array containing the list's items
     */
    public Object[] toArray() {
        return this.linkedList.toArray();
    }

}
