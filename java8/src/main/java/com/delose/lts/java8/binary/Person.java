package com.delose.lts.java8.binary;

import java.io.*;
import java.util.Objects;

public final class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String name;
    private final int age;
    private final transient String password;

    public Person(String name, int age, String password) {
        this.name = Objects.requireNonNull(name, "name must not be null");
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
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
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
            System.out.println("Deserialized person: " + deserializedPerson);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
