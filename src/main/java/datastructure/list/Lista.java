package datastructure.list;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;


public class Lista {

    public static void main(String[] args) {

      /* List lista = Arrays.asList("apple", "tangerine", "avocado", "orange", "pear", "watermelon", "lemon");

       System.out.println("alphabet order with sorted");
       Stream sorted = lista.stream().sorted();
       sorted.forEach(System.out::println);
        System.out.println("");
       System.out.println("Reverse alphabet order");
       Stream sorted2 = lista.stream().sorted(Comparator.reverseOrder());
       sorted2.forEach(System.out::println);
        System.out.println("");*/


        List<Person> personList = new ArrayList<>();

        personList.add( new Person("Jhon", "96502457", 15));
        personList.add( new Person("Mavie", "96502457", 53));
        personList.add( new Person("Chris", "96502457", 63));
        personList.add( new Person("Mariah", "96502457", 78));
        personList.add( new Person("Jess", "96502457", 7));

        System.out.println("Person Init");
        personList.forEach(System.out::println);
        System.out.println("");
        System.out.println("Person order by age");
        personList.sort(Comparator.comparing(Person::getAge));
        personList.forEach(System.out::println);

        System.out.println("");
        System.out.println("Person order by age reverse");
        personList.sort(Comparator.comparing(Person::getAge, Comparator.reverseOrder()));
        personList.forEach(System.out::println);

        System.out.println("");
        System.out.println("Person order by name reverse");
        personList.sort(Comparator.comparing(Person::getName, Comparator.reverseOrder()));
        personList.forEach(System.out::println);

        System.out.println("");
        System.out.println("Person order by name ");
        personList.sort(Comparator.comparing(Person::getName));
        personList.forEach(System.out::println);


    }




    public static class Person {
        String name;
        String phone;
        int age;

        public Person(String name, String phone, int age) {
            this.name = name;
            this.phone = phone;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", phone='" + phone + '\'' +
                    ", age=" + age +
                    '}';
        }
    }



}
