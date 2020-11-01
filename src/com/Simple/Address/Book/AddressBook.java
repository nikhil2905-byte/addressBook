package com.Simple.Address.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBook implements AddressBookInfo {
	List<Person> book = new ArrayList<>();
    Scanner scan = new Scanner(System.in);

    @Override
    public void add() {
        System.out.println("Enter the Person Firstname: ");
        String firstName = scan.nextLine();
        System.out.println("Enter the Person Lastname: ");
        String lastName = scan.nextLine();

        for( int search = 0; search < book.size(); search++ ) {
            if(book.get(search).getFirstName().equalsIgnoreCase(firstName)) {
                if(book.get(search).getLastName().equalsIgnoreCase(lastName)) {
                    System.out.println("Sorry Name is already exist please update/edit your details with option 2");
                    return;
                }

            }
        }
        System.out.println("Enter the Person Address: ");
        String address = scan.nextLine();
        System.out.println("Enter the Person City: ");
        String city = scan.nextLine();
        System.out.println("Enter the Person State: ");
        String state = scan.nextLine();
        System.out.println("Enter the Person Phone Number: ");
        long phoneNumber = scan.nextLong();
        System.out.println("Enter the Zip code: ");
        scan.nextLine();
        String zip = scan.nextLine();
        Person person = new Person(firstName,lastName,address,city,state,phoneNumber,zip);
        book.add(person);
        System.out.println("Successfully Added!!");
    }

    @Override
    public void edit(String firstName) {
        for( int search = 0; search < book.size(); search++ ) {

            if( book.get(search).getFirstName().equalsIgnoreCase(firstName)) {
                Person person = book.get(search);
                System.out.println("Hi  "+person.getFirstName()+" Please edit your details");
                System.out.println("Hi "+person.getFirstName()+" Please edit your address");
                String address = scan.nextLine();
                person.setAddress(address);
                System.out.println("Hi  "+person.getFirstName()+" Please edit your city");
                String city = scan.nextLine();
                person.setCity(city);
                System.out.println("Hi "+person.getFirstName()+" Please edit your state");
                String state = scan.nextLine();
                person.setState(state);
                System.out.println("Hi "+person.getFirstName()+" Please edit your phone number");
                long phone = scan.nextLong();
                person.setPhoneNumber(phone);
                System.out.println("Hi "+person.getFirstName()+" Please edit your zip");
                String zip = scan.nextLine();
                person.setZip(zip);
                System.out.println("Hi "+person.getFirstName()+" Successfully you have updated your details. ");
            }
        }
    }

    @Override
    public void delete(String firstName) {
        for ( int select = 0; select < book.size(); select++) {
            if(book.get(select).getFirstName().equalsIgnoreCase(firstName)) {
                Person person = book.get(select);
                book.remove(person);
                System.out.println("Successfully Deleted!");
            }
        }

    }

    @Override
    public void sortAlphabetically() {
        book.stream()
                .sorted((p1, p2)->p1.getFirstName().compareToIgnoreCase(p2.getFirstName()))
                .forEach(System.out::println);
         /* Collections.sort(book,(p1, p2)  -> p1.getFirstName().compareTo(p2.getFirstName()));
        System.out.println(book); */
    }

    @Override
    public void sortZip() {
        book.stream()
                .sorted((p1, p2)->p1.getZip().compareTo(p2.getZip()))
                .forEach(System.out::println);
    }

    @Override
    public void sortCity() {
        book.stream()
                .sorted((p1, p2)->p1.getCity().compareToIgnoreCase(p2.getCity()))
                .forEach(System.out::println);
    }

    @Override
    public void sortState() {
        book.stream()
                .sorted((p1, p2)->p1.getState().compareToIgnoreCase(p2.getState()))
                .forEach(System.out::println);
    }

    @Override
    public void viewByCity(String city) {
        List<Person> personList = book.stream().filter(person1 -> person1.getCity().equalsIgnoreCase(city)).collect(Collectors.toList());
        personList.stream().forEach(System.out::println);
    }

    @Override
    public void viewByState(String state) {
        List<Person> personList = book.stream().filter(person1 -> person1.getState().equalsIgnoreCase(state)).collect(Collectors.toList());
        personList.stream().forEach(System.out::println);
    }

    @Override
    public void searchPersonInCity(String firstName) {
        List<Person> personList = book.stream().filter(person1 -> person1.getFirstName().equalsIgnoreCase(firstName)).collect(Collectors.toList());
        personList.stream().forEach(System.out::println);
    }

    @Override
    public void searchPersonInState(String firstName) {
        List<Person> personList = book.stream().filter(person1 -> person1.getFirstName().equalsIgnoreCase(firstName)).collect(Collectors.toList());
        personList.stream().forEach(System.out::println);

    }

    public void display() {
        for( Person person : book )
            System.out.println(person);
    }
}
