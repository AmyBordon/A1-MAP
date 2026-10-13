package org.example;

import org.example.model.IEntity;
import org.example.model.Turtle;
import org.example.model.Fish;
import org.example.repo.IRepo;
import org.example.repo.Repo;
import org.example.controller.Controller;
import org.example.View;


public class Main {
    public static void main(String[] args) {
        IEntity a = new Turtle(1, "John", 2);
        IEntity b = new Fish(2, "Jelly", 3);
        IEntity c = new Turtle(4, "Aria", 5);
        IEntity d = new Fish(3, "Goldy", 1);
        IEntity e = new Turtle(4, "Ziggy", 0);
        IRepo r = new Repo(5);
        r.add(a);
        r.add(b);
        r.add(c);
        r.add(d);
        Controller controller = new Controller(r);
        View view = new View(controller);
        view.start();
    }
}
