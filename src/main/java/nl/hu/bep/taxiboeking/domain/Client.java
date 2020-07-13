package nl.hu.bep.taxiboeking.domain;

public class Client extends User {
    private String password;
    private String name;
    private int age;
    private String address;
    private String clientType;
    private String phoneNumber;

    public Client(String tp, String eMail, boolean isAnon) {
        super(tp, eMail);
        this.clientType = isClientTypeAnon(isAnon);
        if (isClientTypeAnon(isAnon).equals("Anon Client")){
            this.name         = "Anon";
            this.age          = 0;
            this.address      = "No Address";
            this.phoneNumber  = "No Phonenumber";
            this.password     = "No Password";
        }
    }

    public void setPassword(String password) {
        if (!clientType.equals("Anon Client")) {
            this.password = password;
        }
    }

    public void setName(String name) {
        if (!clientType.equals("Anon Client")) {
            this.name = name;
        }
    }

    public void setAge(int age) {
        if (!clientType.equals("Anon Client")) {
            this.age = age;
        }
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(int phone) {
        if (!clientType.equals("Anon Client")) {
            this.phoneNumber = "+31 6 " + phone;
        }
    }

    @Override
    public void seteMailAddress(String email) {
        if (!clientType.equals("Anon Client")) {
            super.seteMailAddress(email);
        }
    }

    @Override
    public String getUserType() {
        return super.getUserType();
    }

    @Override
    public String getUserEmailAddress() {
        return super.getUserEmailAddress();
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        String result = "No Phonenumber";
        if (!phoneNumber.isEmpty()){
            result = phoneNumber;
        }
        return result;
    }

    public String getClientType() {
        return clientType;
    }

    public boolean equals(Object obj) {
        boolean sameObjects = false;
        if (obj instanceof Client){
            Client otherClient = (Client) obj;
            if (super.equals(otherClient) &&
                    this.password.equals(otherClient.password) &&
                    this.age == (otherClient.age) &&
                    this.name.equals(otherClient.name) &&
                    this.address.equals(otherClient.address) &&
                    this.phoneNumber.equals(((Client) obj).phoneNumber) &&
                    this.clientType.equals(otherClient.clientType)
            ){
                sameObjects = true;
            }
        }
        return sameObjects;
    }

    public String isClientTypeAnon(boolean button){
        String result = "Anon Client";
        if (!button){
            result = "Registered Client";
        }
        return result;
    }
    public String toString() {
        String result = "User Type = " + getUserType() +
                ", clientType = '" + clientType + '\''+
                ", email = '" + getUserEmailAddress() + '\'';
        if (clientType.equals("Registered Client")){
           result = result +", name = '" + name + '\'' + ", age = '" + age + '\'' + ", phonenumber = '" + phoneNumber + '\'' + ", Address = '" + address + '\''+ ", password = '" + password + '\'';
        }
        return result;
    }
}

