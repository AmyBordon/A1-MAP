package org.example.repo;

import org.example.model.IEntity;

public interface IRepo {
    public IEntity[] getAll();
    public void add(IEntity e) throws IndexOutOfBoundsException, Exception; //+ resize!!!!
    public void remove(Integer i);
    public void update();
}
