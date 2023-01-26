package org.mapsa;

import org.mapsa.GenericFile.RepositoryServiceWithFile;
import org.mapsa.person.Person;
import org.mapsa.person.Student;

import java.io.IOException;

public class FileMain {

    public static void main(String[] args) throws IOException {


        RepositoryServiceWithFile<Person> fileService = new RepositoryServiceWithFile<>();

        Student st1 = new Student("jaki1", "brown", 100);
        Student st2 = new Student("jaki2", "brown", 110);
        Student st3 = new Student("jaki3", "brown", 120);
        Student st4 = new Student("jaki4", "brown", 170);
        Student st5 = new Student("walter", "white", 200);

        fileService.add(st1);

        Person[] ps = new Person[]{st1, st2, st3, st4};
        fileService.add(ps);


//      fileService.remove(st4);
        fileService.removeAll(st1);

//      fileService.clear();

        fileService.update(st4, st5);

        fileService.print();
    }
}
