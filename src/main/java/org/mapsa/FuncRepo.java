package org.mapsa;

import java.io.IOException;
import java.util.List;

public interface FuncRepo<T>  {

    void add(T t);

    void add(T[] t);


    void remove(T t) throws IOException;

    public void removeAll(T element);

    void clear();


    void print();



}
