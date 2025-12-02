package com.delose.lts.java8.binary;

import java.io.*;
import java.util.Objects;

public class Person implements Serializable {

    static void main() {
        Person originalPerson = new Person("Eugene", 38, "secret123");
        String fileName = "person.ser";

        try (FileOutputStream fileOut = new FileOutputStream(fileName)) {
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            out.writeObject(originalPerson);
            System.out.println("Person object has been serialized to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Person deserializedPerson = null;

        try (FileInputStream fileIn = new FileInputStream(fileName);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            deserializedPerson = (Person) in.readObject();
            System.out.println("Person object deserialized from " + fileName);
            System.out.println("Deserialized person from " + deserializedPerson);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Person class not found");
            c.printStackTrace();
        }
    }

    private static final long serialVersionUID = 1L;

    private String name;
    private int age;
    private transient String password;

    public Person(String name, int age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name) && Objects.equals(password, person.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, password);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                '}';
    }
}
