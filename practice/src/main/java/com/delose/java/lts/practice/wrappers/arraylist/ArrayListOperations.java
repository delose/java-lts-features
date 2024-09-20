package com.delose.java.lts.practice.wrappers.arraylist;

import java.util.ArrayList;
import java.util.List;

public class ArrayListOperations<T> {

    ArrayList<T> arrayList;

    public ArrayListOperations() {
        arrayList = new ArrayList<>();
    }

    public ArrayListOperations(List<T> list) {
        this.arrayList = new ArrayList<>(list);
    }

    /**
     * Add an item to the list
     */
    public boolean add(T item) {
        return arrayList.add(item);
    }

    /**
     * Add a collection of items to the list
     */
    public boolean addAll(List<T> items) {
        return arrayList.addAll(items);
    }

    /**
     * Remove all items from the list
     */
    public void clear() {
        this.arrayList.clear();
    }

    /**
     * Create a copy of the ArrayList
     */
    @SuppressWarnings("unchecked")
    public ArrayList<T> clone() {
        return (ArrayList<T>) this.arrayList.clone();
    }

    /**
     * Checks whether an item exist in the list
     */
    public boolean contains(T item) {
        return arrayList.contains(item);
    }

    /**
     * Increase the capacity of the list to be able to fit a specified number of items
     */
    public void ensureCapacity(int minCapacity) {
        this.arrayList.ensureCapacity(minCapacity);
    }

    /**
     * Perform an action on every item in the list
     */
    public void forEach(java.util.function.Consumer<? super T> action) {
        this.arrayList.forEach(action);
    }

    /**
     * Return the item at a specific position in the list
     */
    public T get(int index) {
        return this.arrayList.get(index);
    }

    /**
     * Return the position of the first occurrence of an item in the list
     */
    public int indexOf(T item) {
        return this.arrayList.indexOf(item);
    }

    /**
     * Checks whether the list is empty
     */
    public boolean isEmpty() {
        return this.arrayList.isEmpty();
    }

    /**
     * Return an Iterator object for the ArrayList
     */
    public java.util.Iterator<T> iterator() {
        return this.arrayList.iterator();
    }

    /**
     * Return the position of the last occurrence of an item in the list
     */
    public int lastIndexOf(T item) {
        return this.arrayList.lastIndexOf(item);
    }

    /**
     * Return a ListIterator object for the ArrayList
     * @apiNote The key difference is ListIterator is specific to lists,
     * offering bidirectional traversal and modification,
     * while iterators generally traverse elements one by one in a forward direction from any iterable.
     */
    public java.util.ListIterator<T> listIterator() {
        return this.arrayList.listIterator();
    }

    /**
     * Remove an item from the list
     */
    public boolean remote(T item) {
        return this.arrayList.remove(item);
    }

    /**
     * Remove a collection of items from the list
     */
    public boolean removeAll(List<T> items) {
        return this.arrayList.removeAll(items);
    }

    /**
     * Remove all items from the list which meet a specified condition
     */
    public boolean removeIf(java.util.function.Predicate<? super T> filter) {
        return this.arrayList.removeIf(filter);
    }

    /**
     * Replace each item in the list with the result of an operation on that item
     */
    public void replaceAll(java.util.function.UnaryOperator<T> operator) {
        this.arrayList.replaceAll(operator);
    }

    /**
     * Remove all elements from the list which do not belong to a specified collection
     */
    public boolean retainAll(List<T> items) {
        return this.arrayList.retainAll(items);
    }

    /**
     * Replace an item at a specified position in the list
     */
    public T set(int index, T item) {
        return this.arrayList.set(index, item);
    }

    /**
     * Return the number of items in the list
     */
    public int size() {
        return this.arrayList.size();
    }

    /**
     * Sort the list
     */
    public void sort(java.util.Comparator<? super T> c) {
        this.arrayList.sort(c);
    }

    /**
     * Return a Spliterator object for the ArrayList
     */
    public java.util.Spliterator<T> spliterator() {
        return this.arrayList.spliterator();
    }

    /**
     * Return a sublist which provides access to a range of this list's items
     */
    public List<T> subList(int fromIndex, int toIndex) {
        return this.arrayList.subList(fromIndex, toIndex);
    }

    /**
     * Return an array containing the list's items
     */
    @SuppressWarnings("unchecked")
    public T[] toArray() {
        return (T[]) this.arrayList.toArray();
    }

    /**
     * Reduce the capacity of the list to match the number of items if necessary
     */
    public void trimToSize() {
        this.arrayList.trimToSize();
    }

}
