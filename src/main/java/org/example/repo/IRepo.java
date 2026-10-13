package org.example.repo;

import org.example.model.IEntity;

public interface IRepo {
    public IEntity[] getAll();
    public void add(IEntity e) throws IndexOutOfBoundsException, Exception; //+ resize!!!!
    public void remove(Integer i) throws IndexOutOfBoundsException;
    public void update_name(Integer i, String new_name) throws IndexOutOfBoundsException;
    public void update_age(Integer i, Integer new_age) throws IndexOutOfBoundsException;
}
