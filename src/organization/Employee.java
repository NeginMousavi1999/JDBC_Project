package organization;

/**
 * @author Negin Mousavi
 */
public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private String personalId;
    private String birthDate;
    private int unitId;

    public Employee(String firstName, String lastName, String personalId, String birthDate, int unitId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalId = personalId;
        this.birthDate = birthDate;
        this.unitId = unitId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPersonalId(String personalId) {
        this.personalId = personalId;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPersonalId() {
        return personalId;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public int getUnitId() {
        return unitId;
    }
}
