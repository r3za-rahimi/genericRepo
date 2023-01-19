package org.mapsa;

import org.mapsa.person.Person;
import org.mapsa.person.Student;
import org.mapsa.person.Teacher;

public class Main {
    public static void main(String[] args) {

        RepositoryService<Person> personRepo = new RepositoryService<>();

        Student st1 = new Student("reza0", "Johonson", 10);
        personRepo.add(st1);
        personRepo.add(st1);
        personRepo.add(st1);
        personRepo.add(new Teacher("john1", "lobok", 150));
        personRepo.add(new Teacher("john2", "lobok", 151));
        personRepo.add(new Teacher("john3", "lobok", 152));
        personRepo.add(new Teacher("john4", "lobok", 153));
        personRepo.add(new Teacher("john5", "lobok", 154));

        personRepo.print();

//        personRepo.remove(st1);

        System.out.println("AFTER REMOVE ");
        personRepo.print();

        personRepo.add(new Teacher("john6", "lobok", 1650));
        System.out.println("AFTER add Again ");
        personRepo.print();


        System.out.println("add array of elements ");
        Person[] psns = new Person[]{new Student("a", "b", 10), new Student("c", "d", 20), new Student("e", "f", 30)};
        personRepo.add(psns);
        personRepo.print();


        System.out.println("remove all od one obj");
        personRepo.removeAll(st1);
        personRepo.print();


        System.out.println("get with index");
        System.out.println(personRepo.getByIndex(3));


        System.out.println("clear");
        personRepo.clear();
        personRepo.print();


    }
}