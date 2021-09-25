import organization.Employee;
import organization.Unit;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author Negin Mousavi
 */
public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        AccessToDB accessToDB = new AccessToDB();

        choices:
        do {
            System.out.print("Hi ^_^\n1)Add new Employee\n2)Add new Unit\n3)update first name and last name of employee\n" +
                    "4)update name of unit\n5)show all units\n6)show employees in specific unit\n7)exit\nyour choice is: ");
            int userChoice = scanner.nextByte();

            switch (userChoice) {
                case 1:
                    scanner.nextLine();
                    System.out.print("Enter first name: ");
                    String fName = scanner.nextLine();
                    System.out.print("Enter last name: ");
                    String lName = scanner.nextLine();
                    System.out.print("Enter birth date: ");
                    String birthDate = scanner.nextLine();
                    System.out.print("Enter personal id: ");
                    String personalId = scanner.nextLine();
                    System.out.print("Enter unit id: ");
                    int unitId = scanner.nextInt();
                    Employee newEmp = new Employee(fName, lName, personalId, birthDate, unitId);
                    System.out.println("add employee(s): " + accessToDB.addNewEmployee(newEmp));
                    printStar();
                    break;

                case 2:
                    scanner.nextLine();
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    Unit newUnit = new Unit(name, phoneNumber);
                    System.out.println("add unit(s): " + accessToDB.addNewUnit(newUnit));
                    printStar();
                    break;

                case 3:
                    System.out.print("Enter id of employee: ");
                    int id = scanner.nextInt();
                    if (!accessToDB.isEmployeeExists(id)) {
                        System.out.println("we have n't employee with this id...");
                        printStar();
                        break;
                    }
                    scanner.nextLine();
                    System.out.print("Enter new first name: ");
                    String newFName = scanner.nextLine();
                    System.out.print("Enter new last name: ");
                    String newLName = scanner.nextLine();
                    System.out.println("update employee(s): " + accessToDB.updateEmployee(id, newFName, newLName));
                    printStar();
                    break;

                case 4:
                    System.out.print("Enter id of unit: ");
                    id = scanner.nextInt();
                    if (!accessToDB.isUnitExists(id)) {
                        System.out.println("we have n't unit with this id...");
                        printStar();
                        break;
                    }
                    scanner.nextLine();
                    System.out.print("Enter new unit name: ");
                    fName = scanner.nextLine();
                    System.out.println("update unit(s): " + accessToDB.updateUnit(id, fName));
                    printStar();
                    break;

                case 5:
                    accessToDB.showUnits();
                    printStar();
                    break;

                case 6:
                    break;

                case 7:
                    System.out.println("bye bye");
                    printStar();
                    break choices;

                default:
                    printInvalidInput();
                    printStar();
            }

        } while (true);
    }

    public static void printInvalidInput() {
        System.out.println("invalid input");
    }

    public static void printStar() {
        System.out.println("**********************************************************");
    }
}
