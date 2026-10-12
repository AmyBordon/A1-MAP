package org.example;


import org.example.model.IEntity;
import org.example.model.Turtle;
import org.example.model.Fish;
import org.example.repo.IRepo;
import org.example.repo.Repo;

public class Main {
    public static void main(String[] args) {
        IEntity a = new Turtle(1, "John", 2);
        IEntity b = new Fish(2, "Jelly", 3);
        IRepo r = new Repo(3);

    }
}
//public class Mammal extends Animal

//super(id);
//return super.toString()


//--in main--
//Animal a = new Animal(1);
//Animal  = new Mammal(1, "Max");
//ArrayList<Animal> animals = new ArrayList<>[];
//animals.add(a);
//animals.add(b);
//for(Animal an in animals){
  //  System.out.print(an);
//}


//the diff between an interface & abstract class
//abstract class = can be used in inheritance (strong binding) +
//                 might have some implemented methods
//               - can inherit only one
//interfaces = we have to implement everything all over again
//           - multiple can be used
/**
 *      Animal
 * I1    |     I2
 *   \   |    /
 *     Mammal
 **/
