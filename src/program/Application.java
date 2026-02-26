package program;

import model.entities.LegalPerson;
import model.entities.NaturalPerson;
import model.entities.Person;

import java.time.LocalDateTime;
import java.util.*;

import static model.entities.LegalPerson.validateLegalName;
import static model.entities.NaturalPerson.validateAge;
import static model.entities.NaturalPerson.validateName;

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
                    people.add(registerNaturalPerson(sc,people));
                    break;
                case 2:
                    people.add(registerLegalPerson(sc,people));
                    break;
                case 3:
                    Person personToUpdate;
                    personToUpdate = idSearch(sc,people);
                    if (personToUpdate instanceof NaturalPerson) {
                        String newName;
                        int newAge;
                        while (true) {
                            System.out.println("Enter your new name: ");
                            newName = sc.nextLine();
                            try {
                                validateName(newName);
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
                                validateAge(newAge);
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
                                validateLegalName(newLegalName);
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
                    Person personRemove = idSearch(sc,people);
                    people.remove(personRemove);
                    System.out.println("Accound deleted.");
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
            if (p.getId() != null && p.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
    private static Person registerNaturalPerson(Scanner sc, List<Person> people) {
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
                validateName(name);
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
                validateAge(age);
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
        return new NaturalPerson(idNaturalPerson,addressNaturalPerson, createdAtNaturalPerson, name, age);
    }
    private static Person registerLegalPerson(Scanner sc, List<Person> people) {
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
                validateLegalName(legalName);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Enter your address: ");
        String addressLegalPerson = sc.nextLine();

        LocalDateTime createdAtLegalPerson = LocalDateTime.now();
        return new LegalPerson(idLegalPerson, addressLegalPerson, createdAtLegalPerson, legalName);
    }
    private static Person idSearch(Scanner sc, List<Person> people) {
        Person personSearch = null;
        while (true) {
            try {
                System.out.println("Enter the id to search: ");
                String idString = sc.nextLine();
                int idSearch = Integer.parseInt(idString);
                for (Person p : people) {
                    if (p.getId() == idSearch) {
                        personSearch = p;
                    }
                }
                if (personSearch != null) {
                    return personSearch;
                }else {
                    System.out.println("Id not found. Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid id. Please enter a number.");
            }
        }
    }

}
