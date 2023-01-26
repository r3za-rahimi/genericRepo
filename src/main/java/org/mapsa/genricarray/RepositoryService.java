package org.mapsa.genricarray;

import org.mapsa.FuncRepo;
import org.mapsa.person.Person;

public class RepositoryService<T extends Person> implements FuncRepo<T>, FuncArray<T> {

    private Person[] elements;

    private int emptyIndex = 0;

    public RepositoryService() {
        this.elements = new Person[3];
    }

    public RepositoryService(T[] t) {

        elements = t;
    }


    @Override
    public void add(T t) {


        elements[emptyIndex] = t;
        calculateEmptyIndex();

    }

    @Override
    public void add(T[] t) {

        for (T p : t) {

            add(p);
        }

    }

    @Override
    public void remove(int index) {


        elements[index] = null;


        calculateEmptyIndex();

    }


    @Override
    public void update(int i, T t) {

        elements[i] = t;


    }


    @Override
    public T getByIndex(int index) {

        if (elements[index] == null) {

            return null;
        }

        return (T) elements[index];
    }

    @Override
    public void remove(T t) {

        int i = findFirst(t);
        if (i == -1) {
            return;
        }
        remove(i);


    }

    @Override
    public void removeAll(T t) {


        /** first solution */


        for (Person p : elements) {

            if (p != null && p.equals(t)) {

                remove((T) p);
            }

        }
        /** second solution */

//        for (int i = 0; i < elements.length; i++) {
//
//            if (findFirst(t) != -1) {
//
//                remove(i);
//            }
//        }

    }

    @Override
    public void clear() {
//elements=null;

        for (Person p : elements) {

            if (p != null) {

                remove((T) p);
            }

        }


    }


    public T[] subElements(int from, int to) {
        if (from < 0 || from > to || to >= elements.length) {
            return null;
        }
        Person[] subElements = new Person[to - from + 1];
        int index = 0;
        for (int i = from; i <= to; i++) {
            subElements[index++] = elements[i];
        }

        return (T[]) subElements;
    }

    private int findFirst(T element) {
        if (element == null) {
            return -1;
        }
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != null && elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    private void calculateEmptyIndex() {

        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == null) {

                emptyIndex = i;
                break;

            } else if (i == elements.length - 1) {

                extendedElements();
            }

        }

    }

    private void extendedElements() {

        Person[] newElements = new Person[(elements.length) * 2];
        for (int i = 0; i < elements.length; i++) {

            newElements[i] = elements[i];
        }
        elements = newElements;
    }


    /**
     * راه خوبی برای استفاده از این متد پیدا نکردم
     */
//    private void isIndexInvalid(int index) {
//
//
//
//        return index < 0 || index >= elements.length;
//        throw new RuntimeException();
//    }


    @Override
    public void print() {

        for (Person t : elements) {
            if (t != null) {
                System.out.println(t.toString());
            }

        }
    }
}
