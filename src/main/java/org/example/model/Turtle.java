package org.example.model;

public class Turtle implements IEntity{
    private Integer id;
    private String name;
    private Integer age;

    public Turtle(Integer id, String name, Integer age){
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(Integer age){
        this.age = age;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public void setAge(int newAge){
        this.age = newAge;
    }

    public String toString(){
        return this.id + " " + this.name + " " + this.age;
    }

    public boolean isOlder(int age){
        return this.age >= age;
    }

}
