package org.mapsa;

import java.util.List;

public interface FuncRepo<T> {

    void add(T t);

    void add(T[] t);

    public void update(int index, T t);

    public T getByIndex(int index);

    void remove(T t);

    void remove(int index);

    public void removeAll(T element);

    void clear();


    void print();
}
