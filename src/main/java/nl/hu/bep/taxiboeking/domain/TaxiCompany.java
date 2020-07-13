package nl.hu.bep.taxiboeking.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TaxiCompany {

    private static TaxiCompany theCompany;

    public static void setTaxiCompany(TaxiCompany company) {
        theCompany = company;
    }
    public static TaxiCompany getTaxiCompany() {
        return theCompany;
    }

    private String name;

    private List<Booking> everyBookingRequest             = new ArrayList<Booking>();
    private List<Booking> everyAcceptedBookingRequest     = new ArrayList<Booking>();
    private List<Booking> everyDeniedBookingRequest       = new ArrayList<Booking>();
    private List<Booking> everyPendingBookingRequest      = new ArrayList<Booking>();
    private List<Booking> everyBookingRequestFromAClient  = new ArrayList<Booking>();
    private List<User>    everyUser                       = new ArrayList<User>();
    private List<User>    everyClient                     = new ArrayList<User>();
    private List<User>    everyEmployee                   = new ArrayList<User>();

    public TaxiCompany(String name) {
        this.name = name;
    }

    public String getTaxiCompanyName() {
        return name;
    }

    public List<Booking> getEveryBookingRequest() {
        return Collections.unmodifiableList(everyBookingRequest);
    }

    public List<Booking> getEveryAcceptedBookingRequest() {
        for (Booking status: getEveryBookingRequest()){
            if (status.getStatus().equals("Accepted")){
                everyAcceptedBookingRequest.add(status);
            }
        }
        return Collections.unmodifiableList(everyAcceptedBookingRequest);
    }

    public List<Booking> getEveryDeniedBookingRequest() {
        for (Booking status: getEveryBookingRequest()){
            if (status.getStatus().equals("Denied")){
                everyDeniedBookingRequest.add(status);
            }
        }
        return Collections.unmodifiableList(everyDeniedBookingRequest);
    }

    public List<Booking> getEveryPendingBookingRequest() {
        for (Booking status: getEveryBookingRequest()){
            if (status.getStatus().equals("Pending")){
                everyPendingBookingRequest.add(status);
            }
        }
        return Collections.unmodifiableList(everyPendingBookingRequest);
    }
    public List<Booking> getEveryBookingRequestFromAClient(User client) {
        for (Booking status: getEveryBookingRequest()){
            if (status.getClient().equals(client)){
                everyBookingRequestFromAClient.add(status);
            }
        }
        return Collections.unmodifiableList(everyBookingRequestFromAClient);
    }

    public void addRequest(Booking booking) {
        everyBookingRequest.add(booking);
    }

    public void addUsers(User user){
        everyUser.add(user);
    }

    public List<User> getEveryUser() {
        return Collections.unmodifiableList(everyUser);
    }

    public List<User> getEveryEmployee() {
        for (User status: getEveryUser()){
            if (status.getUserType().equals("Employee")){
                everyEmployee.add(status);
            }
        }
        return Collections.unmodifiableList(everyEmployee);
    }

    public List<User> getEveryClient() {
        for (User status: getEveryUser()){
            if (status.getUserType().equals("Client")){
                everyClient.add(status);
            }
        }
        return Collections.unmodifiableList(everyClient);
    }

    public String toString() {
        StringBuilder result = new StringBuilder("The booking requests from " + name + ":");
        everyBookingRequest.forEach(booking -> result.append("\n\t" + "Client : ").append(booking.getClientName()).append(" Age : ").append(booking.getClientAge()).append(" Requested for a Taxi ride for : ").append(booking.getTotalPass()).append(" total passengers ").append(booking.getDriveDate()).append(" at ").append(booking.getDriveTime()).append(" extra stops : ").append(booking.getStopovers().size() - 1).append(" From : ").append(booking.getDepartureAddress()).append(" ").append(booking.getDeparturePostcode()).append(" To (extra stops) : ").append(booking.getStopovers()).append(" To : ").append(booking.getDestinationAddress()).append(" ").append(booking.getDestinationPostcode()).append(" can be Reached at : ").append(booking.getClientPhoneNumber()).append(" or ").append(booking.getClientEmail()));
        return result.toString();
    }
}