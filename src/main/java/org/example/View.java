package org.example;
import org.example.controller.Controller;
import org.example.model.Fish;
import org.example.model.IEntity;
import org.example.model.Turtle;
import org.w3c.dom.ls.LSResourceResolver;

import java.util.Objects;
import java.util.Scanner;

public class View {
    private Controller controller;
    private final Scanner scanner = new Scanner(System.in);

    public View(Controller c) {
        this.controller = c;
    }

    public void menu(){
        System.out.print("___________aquarium__________\n");
        System.out.print("1. Add a new fish\n");
        System.out.print("2. Add a new turtle\n");
        System.out.print("3. Remove an animal\n");
        System.out.print("4. Update the name\n");
        System.out.print("5. Update the age\n");
        System.out.print("6. Show animals older than 1\n");
        System.out.print("7. Exit\n");
        System.out.print("_____________________________\n");
    }

    public Integer read_id() {
        while (true) {
            System.out.print("Enter the id: ");
            String input = scanner.nextLine();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter an integer.");
            }
        }
    }

    public Integer read_age() {
        while (true) {
            System.out.print("Enter the age: ");
            String input = scanner.nextLine();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter an integer.");
            }
        }
    }

    public void add_fish(){

        System.out.print("Enter the name: ");
        String name = scanner.nextLine();

        Integer age =  read_age();

        controller.add(new Fish(controller.get_next_id(), name, age));
    }

    public void add_turtle(){
        System.out.print("Enter the name: ");
        String name = scanner.nextLine();

        Integer age = read_age();

        controller.add(new Turtle(controller.get_next_id(), name, age));
    }

    public void remove(){
        int id = read_id();
        try {
            controller.remove(id);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid ID!");
        }
    }

    public void update_name() {
        int id = read_id();

        System.out.print("Enter the new name: ");
        String new_name = scanner.nextLine();

        try {
            controller.update_name(id, new_name);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid ID! No animal with this ID exists.");
        }
    }

    public void update_age() {
        int id = read_id();
        Integer new_age = read_age();

        try {
            controller.update_age(id, new_age);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid ID! No animal with this ID exists.");
        }
    }

    public void print_older(){
        System.out.print(".....................\n");
        for (IEntity e :controller.get_older()){
            System.out.print(e.toString() + "\n");
        }
        System.out.print(".....................\n");
    }

    public void start(){

        while(true){
            menu();
            System.out.print(">");
            String input = scanner.nextLine();

            if(Objects.equals(input, "1")){
                add_fish();
            }else if (Objects.equals(input, "2")){
                add_turtle();
            }else if (Objects.equals(input, "3")){
                remove();
            }else if (Objects.equals(input, "4")){
                update_name();
            }else if (Objects.equals(input, "5")){
                update_age();
            }else if (Objects.equals(input, "6")){
                print_older();
            }else if (Objects.equals(input, "7")){
                System.out.print("Goodbye!");
                break;

            }else
                System.out.print("The input is not valid!\n");

        }
    }
}
