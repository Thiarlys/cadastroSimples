package program;

import entities.LegalPerson;
import entities.NaturalPerson;
import entities.Person;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Person> people = new ArrayList<>();

        int option;

        do {
            System.out.println("---------------");
            System.out.println("Pick on option: ");
            System.out.println("1 - Register new user. ");
            System.out.println("2 - Edit user registration. ");
            System.out.println("3 - Delete user. ");
            System.out.println("4 - Display all users. ");
            System.out.println("5 - Exit. ");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Enter 1 to register natural person or 2 to register legal person: ");
                    int n = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter your id: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter your address: ");
                    String address = sc.nextLine();
                    LocalDateTime createdAt = LocalDateTime.now();
                    if (n == 1) {
                        System.out.println("Enter your name: ");
                        String name = sc.nextLine();
                        System.out.println("Enter your age: ");
                        int age = sc.nextInt();
                        sc.nextLine();
                        people.add(new NaturalPerson(id,address, createdAt,name,age));
                    }else {
                        System.out.println("Enter your legal name: ");
                        String legalName = sc.nextLine();
                        people.add(new LegalPerson(id,address, createdAt,legalName));
                    }

                    break;
                case 2:
                    boolean updated = false;

                    System.out.println("Enter the id to search: ");
                    int idUpdate = sc.nextInt();
                    sc.nextLine();
                    for (int i = 0; i < people.size(); i++) {
                        Integer idPerson = people.get(i).getId();
                        if (idPerson != null && idPerson.equals(idUpdate)) {
                            if (people.get(i) instanceof NaturalPerson) {
                                System.out.println("Enter your new name: ");
                                String newName = sc.nextLine();

                                System.out.println("Enter your new age: ");
                                int newAge = sc.nextInt();
                                sc.nextLine();

                                System.out.println("Enter your new address: ");
                                String newAddress = sc.nextLine();
                                ((NaturalPerson) people.get(i)).update(newName,newAge,newAddress);
                                updated = true;
                            } else if (people.get(i) instanceof LegalPerson) {
                                System.out.println("Enter your new legal name: ");
                                String newLegalName = sc.nextLine();
                                System.out.println("Enter your new address: ");
                                String newAddress = sc.nextLine();
                                ((LegalPerson) people.get(i)).update(newLegalName,newAddress);
                                updated = true;
                            }
                            break;
                        }
                    }
                    if (updated) {
                        System.out.println("Update sucess.");
                    }else {
                        System.out.println("Id not found.");
                    }
                    break;
                case 3:
                    boolean removed = false;

                    System.out.println("Enter the Id to remove: ");
                    int idRemove = sc.nextInt();
                    for (int i = 0; i < people.size(); i++) {
                        Integer idPerson = people.get(i).getId();
                        if (idPerson != null && idPerson.equals(idRemove)) {
                            people.remove(i);
                            removed = true;
                            break;
                        }
                    }
                    if (removed) {
                        System.out.println("User removed.");
                    }else {
                        System.out.println("Id not found.");
                    }
                    break;
                case 4 :
                    for (Person p : people) {
                        System.out.println(p);
                    }
                    break;
                case 5 :
                    System.out.println("Exiting");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }while (option != 5);

        sc.close();

    }
}
