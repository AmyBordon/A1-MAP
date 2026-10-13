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

        //return arr;
        return java.util.Arrays.copyOf(arr, size);
    }

    @Override
    public Integer get_size(){
        return this.size;
    }
    @Override
    public Integer get_next_id(){
        int next = 0;
        for(int i=0; i< this.size; i++){
            if(arr[i].getId()>=next)
                next = arr[i].getId() + 1;
        }
        return next;
    }
    @Override
    public int get_pos_by_id(Integer id){
        int pos = -1;
        for(int i=0; i<this.size; i++){
            if(Objects.equals(arr[i].getId(), id))
                return i;
        }
        return pos;

    }
    @Override
    public void add(IEntity e) {
        if(Objects.equals(size, capacity)) {
            int new_cap;
            if (capacity ==0)
                new_cap = 1;
            else new_cap = capacity*2;
            IEntity[] new_arr =  new IEntity[new_cap];
            int i=0;
            for(IEntity entity: this.arr){
                new_arr[i++] = entity;
            }
            this.capacity = new_cap;
            this.arr = new_arr;
        }
        this.arr[this.size++] = e;
    }

    @Override
    public void remove(Integer i) throws IndexOutOfBoundsException {
        Integer pos = this.get_pos_by_id(i);
        if (pos>=this.size || pos<0){
            throw new IndexOutOfBoundsException("Invalid ID!");
        }
        for(int curr = pos; curr < this.size - 1; curr++){
            this.arr[curr] = this.arr[curr+1];
        }
        this.arr[--this.size] = null;
    }

    @Override
    public void update_name(Integer i, String new_name) throws IndexOutOfBoundsException {
        Integer pos = this.get_pos_by_id(i);
        if (pos>=this.size || pos<0){
            throw new IndexOutOfBoundsException("Invalid ID!");
        }
        this.arr[pos].setName(new_name);
    }

    @Override
    public void update_age(Integer i, Integer new_age) throws IndexOutOfBoundsException{
        Integer pos = this.get_pos_by_id(i);
        if (pos>=this.size || pos<0){
            throw new IndexOutOfBoundsException("Invalid ID!");
        }
        this.arr[pos].setAge(new_age);
    }
}
