package organization;

/**
 * @author Negin Mousavi
 */
public class Unit {
    private int id;
    private String name;
    private String phoneNumber;
    private Employee[] employees = new Employee[100];


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmployees(Employee[] employees) {
        this.employees = employees;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Employee[] getEmployees() {
        return employees;
    }
}
