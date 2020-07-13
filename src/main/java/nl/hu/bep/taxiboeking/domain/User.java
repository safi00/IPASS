package nl.hu.bep.taxiboeking.domain;

public abstract class User {
    private String type;
    private String eMailAddress;

    public User(String tp, String eMail){
        this.type = tp;
        this.eMailAddress = eMail;
    }

    public void seteMailAddress(String eMailAddress) {
            this.eMailAddress = eMailAddress;
    }

    public String getUserEmailAddress() {
        return eMailAddress;
    }

    public String getUserType() {
        return type;
    }

    public boolean equals (Object otherObject){
        boolean sameObjects = false;
        if (otherObject instanceof User){
            User otherUser = (User) otherObject;
            if (this.type.equals(otherUser.type)&&
                    this.eMailAddress.equals(otherUser.eMailAddress)){
                sameObjects = true;
            }
        }
        return sameObjects;
    }

    public String toString() {
        return "User Type: " + type + " met de email : " + eMailAddress;
    }
}
