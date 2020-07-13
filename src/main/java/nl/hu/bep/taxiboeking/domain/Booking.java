package nl.hu.bep.taxiboeking.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Booking {
    private LocalDateTime       bookDate;
    private LocalDate           driveDate;
    private LocalDateTime       driveTime;
    private String              departureAddress;
    private String              departurePostcode;
    private List<String>        stopovers = new ArrayList<String>();
    private String              destinationAddress;
    private String              destinationPostcode;
    private String              status;
    private Client              booker;
    private String              datePlusTime;
    private int                 totalPassengers;
    private String              seenBy;
    private boolean             retour;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public Booking(Client booker, String dDate, String dTime, String depAddress, String depPostcode, String stops, String destAddress, String destPostcode, int totpass, boolean ret){

        datePlusTime = "" + dDate + " " + dTime;

        this.booker             = booker;
        this.bookDate           = LocalDateTime.now();
        this.driveDate          = LocalDate.parse(dDate);
        this.driveTime          = LocalDateTime.parse(datePlusTime,formatter);
        this.departureAddress   = depAddress;
        this.departurePostcode  = depPostcode;
        this.destinationAddress = destAddress;
        this.destinationPostcode= destPostcode;
        this.status             = "Pending";
        this.seenBy             = "none";
        this.retour             = ret;
        this.totalPassengers = Math.max(totpass, 1);

        if (!stops.equals("")) {
            String[] tempArray;
            tempArray = stops.split(", ");
            stopovers.addAll(Arrays.asList(tempArray));
        }else{
            stopovers.add("No Stopovers");
        }
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getBookDate() {
        return bookDate;
    }

    public LocalDate getDriveDate() {
        return driveDate;
    }

    public LocalDateTime getDriveTime() {
        return driveTime;
    }

    public String getDepartureAddress() {
        return departureAddress;
    }

    public String getDeparturePostcode() {
        return departurePostcode;
    }

    public List<String> getStopovers() {
        return stopovers;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public String getDestinationPostcode() {
        return destinationPostcode;
    }

    public void setRequestStatus(Employee employee, String statusType){
        this.status = statusType;
        this.seenBy = employee.getName();
    }

    public int getTotalPass() {
        return totalPassengers;
    }

    //    booker to each Booking
    public Client getClient(){return booker;}
    public String getClientName(){return booker.getName();}
    public int    getClientAge(){return booker.getAge();}
    public String getClientPhoneNumber(){return booker.getPhoneNumber(); }
    public String getClientEmail(){return booker.getUserEmailAddress(); }

    public boolean bookingBefore24Hours(Booking bookdate){
        boolean result = false;
        if(bookdate.getBookDate().isBefore(LocalDateTime.now().minusDays(1))){
            result = true;
        }
        return result;
    }

    public boolean equals (Object obj){
        boolean sameObjects = false;
        if (obj instanceof Booking){
            Booking andereBooking = (Booking) obj;
            if (    this.bookDate.equals(andereBooking.bookDate) &&
                    this.driveDate.equals(andereBooking.driveDate) &&
                    this.driveTime.equals(andereBooking.driveTime) &&
                    this.departureAddress.equals(andereBooking.departureAddress) &&
                    this.departurePostcode.equals(andereBooking.departurePostcode) &&
                    this.stopovers.equals(andereBooking.stopovers) &&
                    this.destinationAddress.equals(andereBooking.destinationAddress) &&
                    this.destinationPostcode.equals(andereBooking.destinationAddress)){
                sameObjects = true;
            }
        }
        return sameObjects;
    }

    public String toString() {
        return "From: " + booker.getClientType() + ", " + getClientName() +
                ". BookDate = " + bookDate.getDayOfMonth() + "/" + bookDate.getMonth() + "/"  + bookDate.getYear() +
                ", Drive Date = " + driveDate.getDayOfMonth() + "/" + driveDate.getMonth() + "/"  + driveDate.getYear() +
                ", Drive Time = " + driveTime.getHour() + ":" + driveTime.getMinute() +
                ", Departure Address = '" + departureAddress + '\'' +
                ", Departure Postcode = '" + departurePostcode + '\'' +
                ", Stopovers = '" + stopovers + '\'' +
                ", Destination Address = '" + destinationAddress + '\'' +
                ", Destination Postcode = '" + destinationPostcode + '\'' +
                "  With a total of " + totalPassengers + " passengers" +
                ", Status = '" + status + '\'' +
                ", SeenBy = '" + seenBy + '\'';
    }
}
