package nl.hu.bep.taxiboeking.domain;

public class Employee extends User {
    private String password;
    private String name;
    private String employeeType;

    public Employee(String tp, String eMail, String password, String name, String medtype) {
        super(tp, eMail);
        this.password = password;
        this.name = name;
        this.employeeType = medtype;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void seteMailAddress(String eMailAddress) {
        super.seteMailAddress(eMailAddress);
    }

    @Override
    public String getUserEmailAddress() {
        return super.getUserEmailAddress();
    }

    @Override
    public String getUserType() {
        return super.getUserType();
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public boolean equals(Object obj) {
        boolean sameObjects = false;
        if (obj instanceof Employee){
            Employee andereEmployee = (Employee) obj;
            if (super.equals(andereEmployee) &&
                    this.password.equals(andereEmployee.password) &&
                    this.name.equals(andereEmployee.name) &&
                    this.employeeType.equals(andereEmployee.employeeType)
            ){
                sameObjects = true;
            }
        }
        return sameObjects;
    }
    
    public String toString() {
        return "User Type = " + getUserType() +
                ", employeeType = '" + employeeType + '\''+
                ", email = '" + getUserEmailAddress() + '\'' +
                ", name = '" + name + '\'' +
                ", password = '" + password + '\'';
    }
}
