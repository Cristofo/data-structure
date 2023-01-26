package datastructure.list;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TreeSTest {

    public static void main(String[] args) {
        Set<Person> setTest = new HashSet<>();

        Person personTest = new Person("Jhon", "96502457", 15);
        //setTest.add( new Lista.Person("Jhon", "96502457", 15));
        setTest.add( new Person("Mavie", "96502457", 53));
        setTest.add( new Person("Chris", "96502457", 63));
        setTest.add( new Person("Mariah", "96502457", 78));
        setTest.add( new Person("Jess", "96502457", 7));
        setTest.add(personTest);
        setTest.add(personTest);
        setTest.add(personTest);

        System.out.println("print data, with no duplicates");
        setTest.forEach(System.out::println);

        System.out.println("");
        System.out.println("print data sorted");
        TreeSet<Person> collectTreeSet = setTest.stream().sorted().collect(Collectors.toCollection(TreeSet::new));
        collectTreeSet.forEach(System.out::println);
        //Hashtable<> hashtable = new Hashtable<>();

    }


}
