package org.example.repo;

import org.example.model.IEntity;

import java.nio.charset.IllegalCharsetNameException;
import java.util.Objects;

public class Repo implements IRepo {
    private IEntity[] arr;
    private Integer size;
    private Integer current_pos;

    public Repo(int size){
        this.arr = new IEntity[size];
        this.size = size;
        current_pos = 0;
    }

    @Override
    public IEntity[] getAll() {
        return arr;
    }

    @Override
    public void add(IEntity e) throws IndexOutOfBoundsException, Exception{
        if(Objects.equals(current_pos, size)) {
            //double the size
            //duplicate the array
        }
        try {
            this.arr[this.current_pos++] = e;

        }catch (IndexOutOfBoundsException ex){
            ex.printStackTrace();
            //blocking it without stoping the execution
        }catch (Exception ex1){ //other exceptions
            ex1.printStackTrace();
        }
    }

    @Override
    public void remove(Integer i) {

    }

    @Override
    public void update() {

    }
}
