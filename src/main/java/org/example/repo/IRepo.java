package org.example.repo;

import org.example.model.IEntity;

public interface IRepo {
    public IEntity[] getAll();
    public Integer get_size();
    public Integer get_next_id();
    public void add(IEntity e);
    public void remove(Integer i) throws IndexOutOfBoundsException;
    public void update_name(Integer i, String new_name) throws IndexOutOfBoundsException;
    public void update_age(Integer i, Integer new_age) throws IndexOutOfBoundsException;
    public int get_pos_by_id(Integer id);
}
