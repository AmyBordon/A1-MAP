package org.example.controller;
import org.example.model.IEntity;
import org.example.repo.IRepo;

public class Controller {
    private IRepo repo;

    public Controller(IRepo repo) {
        this.repo = repo;
    }

    public void add(IEntity e) {
        repo.add(e);
    }

    public void remove(Integer i){
        repo.remove(i);
    }

    public void update_name(Integer i, String new_name){
        repo.update_name(i, new_name);
    }

    public void update_age(Integer i, Integer new_age){
        repo.update_age(i, new_age);
    }

    public Integer get_next_id(){
        return repo.get_next_id();
    }

    public IEntity[] get_older() {
        int count = 0;

        for (IEntity e : repo.getAll()) {
            if (e.isOlder(1)) {
                count++;
            }
        }

        IEntity[] older = new IEntity[count];
        int i = 0;

        for (IEntity e : repo.getAll()) {
            if (e.isOlder(1)) {
                older[i++] = e;
            }
        }

        return older;
    }


}
