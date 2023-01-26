package org.mapsa.GenericFile;

import org.mapsa.FuncRepo;
import org.mapsa.person.Person;

import java.io.*;
import java.io.BufferedReader;
import java.net.URI;
import java.nio.file.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RepositoryServiceWithFile<T extends Person> implements FuncRepo<T> , FileFunc<T> {


    List<String> result = new ArrayList<>();
    private File file = new File("myFile.txt");
    private File tempFile = new File("temp.txt");

    FileWriter fileWriter;
    FileReader fileReader;
    private BufferedWriter bfw;

    private BufferedReader bfr;

    public RepositoryServiceWithFile() throws IOException {


        fileWriter = new FileWriter(file);
        fileReader = new FileReader(file);

        bfw = new BufferedWriter(fileWriter);
        bfr = new BufferedReader(fileReader);


    }


    @Override
    public void add(T t) {


        try {
            bfw.write(t.toString() + "\n");
            bfw.flush();
//            bfw.close(); // ==> ???????????????????
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void add(T[] t) {

        for (Person p : t) {

            add((T) p);
        }

    }

    @Override
    public void update(T oldElment, T newElment) {
        fileToList();
        for (int i = 0; i < result.size(); i++) {

            if (result.get(i).equals(oldElment.toString())) {

                result.set(i, newElment.toString());
            }
        }

        write();
    }

    @Override
    public void remove(T t) {
        fileToList();
        result.remove(t.toString());
        write();
    }


    @Override
    public void removeAll(T element) {

        fileToList();
        List<String> removeElement = new ArrayList<>();

        for (String str : result) {

            if (str.equals(element.toString())) {
                removeElement.add(element.toString());
            }
        }
        result.removeAll(removeElement);
        write();

    }

    @Override
    public void clear() {

        try {
            bfw = new BufferedWriter(new FileWriter(file));
            bfw.write("");
            bfw.flush();
            bfw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void print() {

        fileToList();

        for (String str : result) {

            System.out.println(str);
        }
    }

    private void fileToList() {


        String line;

        try {
            while ((line = bfr.readLine()) != null) {

                result.add(line);

            }
//            bfr.close(); ==> ????

        } catch (IOException e) {

            e.printStackTrace();
        }


    }

    private void write() {

        try {
            bfw = new BufferedWriter(new FileWriter(file));
            for (String str : result) {

                bfw.write(str + "\n");

            }
            bfw.flush();
            bfw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
