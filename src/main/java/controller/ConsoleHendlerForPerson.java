package controller;

import java.util.Scanner;
import lib.Inject;
import model.Person;
import persondao.PersonDaoBase;

public class ConsoleHendlerForPerson {
    @Inject
    PersonDaoBase personDaoBase;

    public void handle() {
        Scanner scanner = new Scanner(System.in);
        String comand = scanner.nextLine();

        Person person = null;
        try {
            String[] personData = comand.split(" ");
            String name = personData[0];
            String surname = personData[1];
            person = new Person(name,surname);

        } catch (NumberFormatException e) {
            System.out.println("Введiть коректні данні");
        }
        personDaoBase.add(person);
        System.out.println(personDaoBase.getAll().toString());
    }
}


