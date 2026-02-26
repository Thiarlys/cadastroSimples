package program;

import entities.LegalPerson;
import entities.NaturalPerson;
import entities.Person;

import java.time.LocalDateTime;
import java.util.*;

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
                    NaturalPerson naturalPersonTest = new NaturalPerson();
                    int idNaturalPerson;
                    String name;
                    int age;
                    while (true) {
                        try {
                            System.out.println("Enter your id: ");
                            String idInput = sc.nextLine();
                            idNaturalPerson = Integer.parseInt(idInput);
                            if (idExists(people, idNaturalPerson)) {
                                System.out.println("ID alredy exist.");
                            } else {
                                break;
                            }
                        }
                        catch (NumberFormatException e) {
                            System.out.println("Invalid id. Please enter a number.");
                        }
                    }
                    while (true) {
                        System.out.println("Enter your name: ");
                        name = sc.nextLine();
                        try {
                            naturalPersonTest.validateName(name);
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    while (true) {
                        System.out.println("Enter your age: ");
                        String ageInput = sc.nextLine();
                        try {
                            age = Integer.parseInt(ageInput);
                            naturalPersonTest.validateAge(age);
                            break;
                        }catch (NumberFormatException e) {
                            System.out.println("Age must be a number. Try again.");
                        }
                        catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    System.out.println("Enter your address: ");
                    String addressNaturalPerson = sc.nextLine();

                    LocalDateTime createdAtNaturalPerson = LocalDateTime.now();
                    people.add(new NaturalPerson(idNaturalPerson, addressNaturalPerson, createdAtNaturalPerson, name, age));
                    break;
                case 2:
                    LegalPerson legalPersonTest = new LegalPerson();
                    int idLegalPerson;
                    String legalName;
                    while (true) {
                        try {
                            System.out.println("Enter your id: ");
                            String idInput = sc.nextLine();
                            idLegalPerson = Integer.parseInt(idInput);
                            if (idExists(people, idLegalPerson)) {
                                System.out.println("ID alredy exist.");
                            } else {
                                break;
                            }
                        }catch (NumberFormatException e) {
                            System.out.println("Invalid id. Please enter a number.");
                        }
                    }
                    while (true) {
                        System.out.println("Enter your legal name: ");
                        legalName = sc.nextLine();
                        try {
                            legalPersonTest.validateLegalName(legalName);
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    System.out.println("Enter your address: ");
                    String addressLegalPerson = sc.nextLine();

                    LocalDateTime createdAtLegalPerson = LocalDateTime.now();
                    people.add(new LegalPerson(idLegalPerson, addressLegalPerson, createdAtLegalPerson, legalName));
                    break;
                case 3:
                    Person personToUpdate = null;
                    while (true) {
                        try {
                            System.out.println("Enter the id to search: ");
                            String idString = sc.nextLine();
                            int idSearch = Integer.parseInt(idString);
                            for (Person person : people) {
                                if (person.getId() != null && person.getId().equals(idSearch)) {
                                    personToUpdate = person;
                                    break;
                                }
                            }
                            if (personToUpdate != null) {
                                break;
                            } else {
                                System.out.println("Id not found, try again.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid id. Please enter a number.");
                        }
                    }
                    if (personToUpdate instanceof NaturalPerson) {
                        String newName;
                        int newAge;
                        while (true) {
                            System.out.println("Enter your new name: ");
                            newName = sc.nextLine();
                            try {
                                ((NaturalPerson) personToUpdate).validateName(newName);
                                break;
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        while (true){
                            System.out.println("Enter your new age: ");
                            String ageString = sc.nextLine();
                            try {
                                newAge = Integer.parseInt(ageString);
                                ((NaturalPerson) personToUpdate).validateAge(newAge);
                                break;
                            }catch (NumberFormatException e) {
                                System.out.println("Invalid age. Please enter a number.");
                            }
                            catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            }
                        }

                        System.out.println("Enter your new address: ");
                        String newAddress = sc.nextLine();

                        ((NaturalPerson)personToUpdate).update(newName,newAge,newAddress);
                    } else if (personToUpdate instanceof LegalPerson) {
                        String newLegalName;
                        while (true) {
                            System.out.println("Enter your new legal name: ");
                            newLegalName = sc.nextLine();
                            try {
                                ((LegalPerson) personToUpdate).validateLegalName(newLegalName);
                                break;
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        System.out.println("Enter your new address: ");
                        String newAddress = sc.nextLine();

                        ((LegalPerson) personToUpdate).update(newLegalName,newAddress);
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
