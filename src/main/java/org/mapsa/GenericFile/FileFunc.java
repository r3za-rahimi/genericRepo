package org.mapsa.GenericFile;

public interface FileFunc<T> {

    public void update(T oldElment, T newElment);
}
