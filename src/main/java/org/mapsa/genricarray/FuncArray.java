package org.mapsa.genricarray;

public interface FuncArray<T> {


    void remove(int index);

    public T getByIndex(int index);

    public void update(int index, T t);

    default T SelectByIndex(int index) {

        return getByIndex(index);
    }
}
