package org.example.model;

public interface IEntity{
    public Integer getId();
    public String getName();
    public int getAge();

    public void setName(String newName);
    public void setAge(int newAge);
    public String toString();
    public boolean isOlder(int age);

}