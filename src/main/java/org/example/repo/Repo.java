package org.example.repo;

import org.example.model.IEntity;

import java.util.Objects;

public class Repo implements IRepo {
    private IEntity[] arr;
    private Integer capacity;
    private Integer size;

    public Repo(int cap){
        this.arr = new IEntity[cap];
        this.capacity = cap;
        this.size = 0;
    }

    @Override
    public IEntity[] getAll() {
        return arr;
    }

    @Override
    public void add(IEntity e) throws IndexOutOfBoundsException, Exception{
        if(Objects.equals(size, capacity)) {

            IEntity[] new_arr =  new IEntity[capacity*2];
            int i=0;
            for(IEntity entity: this.arr){
                new_arr[i++] = entity;
            }
            if (this.capacity !=0)
                this.capacity *= 2;
            else this.capacity++;
            this.arr = new_arr;
        }
        try {
            this.arr[this.size++] = e;

        }catch (IndexOutOfBoundsException ex){
            ex.printStackTrace();
            //blocking it without stoping the execution
        }catch (Exception ex1){ //other exceptions
            ex1.printStackTrace();
        }
    }

    @Override
    public void remove(Integer i) throws IndexOutOfBoundsException { //remove from pos i
        if (i>=this.size || i<0){
            throw new IndexOutOfBoundsException();
        }
        for(int curr = i; curr < this.size - 1; curr++){
            this.arr[curr] = this.arr[curr+1];
        }
        this.arr[--this.size] = null;
    }

    @Override
    public void update_name(Integer i, String new_name) throws IndexOutOfBoundsException {
        if (i>=this.size || i<0){
            throw new IndexOutOfBoundsException();
        }
        this.arr[i].setName(new_name);
    }

    @Override
    public void update_age(Integer i, Integer new_age) throws IndexOutOfBoundsException{
        if (i>=this.size || i<0){
            throw new IndexOutOfBoundsException();
        }
        this.arr[i].setAge(new_age);
    }
}
