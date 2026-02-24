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
            System.out.println("1 - Register new natural person. ");
            System.out.println("2 - Register new legal person ");
            System.out.println("3 - Edit user registration. ");
            System.out.println("4 - Delete user. ");
            System.out.println("5 - Display all users. ");
            System.out.println("6 - Exit. ");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    while (true) {
                        try {
                            System.out.println("Enter your id: ");
                            String idInput = sc.nextLine();
                            int id = Integer.parseInt(idInput);
                            if (idExists(people,id)) {
                                System.out.println("ID alredy exist.");
                                continue;
                            }
                            System.out.println("Enter your name: ");
                            String name = sc.nextLine();

                            System.out.println("Enter your age: ");
                            String ageInput = sc.nextLine();
                            int age = Integer.parseInt(ageInput);

                            System.out.println("Enter your address: ");
                            String address = sc.nextLine();

                            LocalDateTime createdAt = LocalDateTime.now();
                            people.add(new NaturalPerson(id, address, createdAt, name, age));
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid ID. It must be a numeric value.");
                        }
                        catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case 2:
                    while (true) {
                        try {
                            System.out.println("Enter your id: ");
                            String idInput = sc.nextLine();
                            int id = Integer.parseInt(idInput);
                            if (idExists(people,id)) {
                                System.out.println("ID alredy exist.");
                                continue;
                            }
                            System.out.println("Enter your legal name: ");
                            String legalName = sc.nextLine();

                            System.out.println("Enter your address: ");
                            String address = sc.nextLine();

                            LocalDateTime createdAt = LocalDateTime.now();
                            people.add(new LegalPerson(id, address, createdAt, legalName));
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid ID. It must be a numeric value.");
                        }
                        catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case 3:
                    boolean updated = false;

                    System.out.println("Enter the id to search: ");
                    String idUpdateInput = sc.nextLine();
                    int idUpdate = Integer.parseInt(idUpdateInput);
                    for (int i = 0; i < people.size(); i++) {
                        Integer idPerson = people.get(i).getId();
                        if (idPerson != null && idPerson.equals(idUpdate)) {
                            if (people.get(i) instanceof NaturalPerson) {
                                System.out.println("Enter your new name: ");
                                String newName = sc.nextLine();

                                System.out.println("Enter your new age: ");
                                String newAgeInput = sc.nextLine();
                                int newAge = Integer.parseInt(newAgeInput);

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
                case 4:
                    boolean removed = false;

                    System.out.println("Enter the Id to remove: ");
                    String idRemoveInput = sc.nextLine();
                    int idRemove = Integer.parseInt(idRemoveInput);
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
                case 5 :
                    for (Person p : people) {
                        System.out.println(p);
                    }
                    break;
                case 6 :
                    System.out.println("Exiting");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }while (option != 6);

        sc.close();

    }
    private static boolean idExists(List<Person> people, int id) {
        for (Person p : people) {
            if (p.getId() == id) {
                return true;
            }
        }
        return false;

    }

}
