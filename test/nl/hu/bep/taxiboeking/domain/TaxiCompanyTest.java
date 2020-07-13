package nl.hu.bep.taxiboeking.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaxiCompanyTest {
    private Client         user1;
    private Client         user3;
    private Employee       user5;
    private TaxiCompany    newTaxiCompany;
    private List<User>     testUserlist    = new ArrayList<User>();
    private List<Booking>  testRequestlist = new ArrayList<Booking>();
    private String         actual;
    private String         expected;
    private Booking        booking1;
    private Booking        booking2;
    private Booking        booking3;

    @BeforeEach
    public void init() {
        newTaxiCompany = new TaxiCompany("MagicTaxi");
        user1 = new Client( "Client","Blah@hotmail.com",true);
        user3 = new Client( "Client","Blah@hotmail.com",false);
        user5 = new Employee("Employee","england@taxi.com","TheRoyalJewels","The Queen of england","Manager");
        user3.setName("Xarvaine Martina");
        user3.setPassword("password");
        user3.setAddress("password straat 553");
        user3.setAge(22);
        user3.setPhoneNumber(555555566);
        booking1 = new Booking(user1, "2017-02-05", "10:15","Vogelenzang 2","2801XD","","padulaan 101","1234VD",1,true);
        booking2 = new Booking(user3, "2020-06-05", "16:15","Vogelenzang 2","2801XD","PostNL Post Office Nieuwe-Marktpassage 6 2801HV, MacDonalds Nieuwe Gouwe O.Z 19 2803RA","padulaan 101","1234VD",8,true);
        booking3 = new Booking(user1, "2017-02-05", "10:15","Vogelenzang 55","2805XD","","berglaan 101","1255VD",1,false);

        booking2.setRequestStatus(user5,"Accepted");
        booking3.setRequestStatus(user5,"Denied");

        newTaxiCompany.addUsers(user1);
        newTaxiCompany.addUsers(user3);
        newTaxiCompany.addUsers(user5);

        newTaxiCompany.addRequest(booking1);
        newTaxiCompany.addRequest(booking2);
        newTaxiCompany.addRequest(booking3);

        TaxiCompany.setTaxiCompany(newTaxiCompany);
    }
    @Test
    public void testgetTaxiCompany(){
        assertEquals("The booking requests from MagicTaxi:\n" +
                "\tClient : Anon Age : 0 Requested for a Taxi ride for : 1 total passengers 2017-02-05 at 2017-02-05T10:15 extra stops : 0 From : Vogelenzang 2 2801XD To (extra stops) : [No Stopovers] To : padulaan 101 1234VD can be Reached at : No Phonenumber or Blah@hotmail.com\n" +
                "\tClient : Xarvaine Martina Age : 22 Requested for a Taxi ride for : 8 total passengers 2020-06-05 at 2020-06-05T16:15 extra stops : 1 From : Vogelenzang 2 2801XD To (extra stops) : [PostNL Post Office Nieuwe-Marktpassage 6 2801HV, MacDonalds Nieuwe Gouwe O.Z 19 2803RA] To : padulaan 101 1234VD can be Reached at : +31 6 555555566 or Blah@hotmail.com\n" +
                "\tClient : Anon Age : 0 Requested for a Taxi ride for : 1 total passengers 2017-02-05 at 2017-02-05T10:15 extra stops : 0 From : Vogelenzang 55 2805XD To (extra stops) : [No Stopovers] To : berglaan 101 1255VD can be Reached at : No Phonenumber or Blah@hotmail.com",TaxiCompany.getTaxiCompany().toString());
    }
    @Test
    public void testTaxiCompanyName(){
        assertEquals("MagicTaxi",newTaxiCompany.getTaxiCompanyName());
    }
    @Test
    public void testgetAllUsers(){

        testUserlist.add(user1);
        testUserlist.add(user3);
        testUserlist.add(user5);

        actual   = "" + newTaxiCompany.getEveryUser();
        expected = "" + testUserlist;
        assertEquals(expected,actual);
    }
    @Test
    public void testgetAllClients(){

        testUserlist.add(user1);
        testUserlist.add(user3);

        actual   = "" + newTaxiCompany.getEveryClient();
        expected = "" + testUserlist;
        assertEquals(expected,actual);
    }
    @Test
    public void testgetAllEmployees(){

        testUserlist.add(user5);

        actual   = "" + newTaxiCompany.getEveryEmployee();
        expected = "" + testUserlist;
        assertEquals(expected,actual);
    }

    @Test
    public void testToString(){
        assertEquals("The booking requests from MagicTaxi:\n" +
                "\tClient : Anon Age : 0 Requested for a Taxi ride for : 1 total passengers 2017-02-05 at 2017-02-05T10:15 extra stops : 0 From : Vogelenzang 2 2801XD To (extra stops) : [No Stopovers] To : padulaan 101 1234VD can be Reached at : No Phonenumber or Blah@hotmail.com\n" +
                "\tClient : Xarvaine Martina Age : 22 Requested for a Taxi ride for : 8 total passengers 2020-06-05 at 2020-06-05T16:15 extra stops : 1 From : Vogelenzang 2 2801XD To (extra stops) : [PostNL Post Office Nieuwe-Marktpassage 6 2801HV, MacDonalds Nieuwe Gouwe O.Z 19 2803RA] To : padulaan 101 1234VD can be Reached at : +31 6 555555566 or Blah@hotmail.com\n" +
                "\tClient : Anon Age : 0 Requested for a Taxi ride for : 1 total passengers 2017-02-05 at 2017-02-05T10:15 extra stops : 0 From : Vogelenzang 55 2805XD To (extra stops) : [No Stopovers] To : berglaan 101 1255VD can be Reached at : No Phonenumber or Blah@hotmail.com",newTaxiCompany.toString());
    }

    @Test
    public void testgetEveryBookingReq(){
//        to test if the contents are the same

        testRequestlist.add(booking1);
        testRequestlist.add(booking2);
        testRequestlist.add(booking3);

        actual   = "" + newTaxiCompany.getEveryBookingRequest();
        expected = "" + testRequestlist;

        assertEquals(expected,actual);
    }
    @Test
    public void testgetEveryAcceptedBookingRequest(){
//        to test if the contents are the same

        testRequestlist.add(booking2);

        actual   = "" + newTaxiCompany.getEveryAcceptedBookingRequest();
        expected = "" + testRequestlist;

        assertEquals(expected,actual);
    }
    @Test
    public void testgetEveryPendingBookingRequest(){
//        to test if the contents are the same

        testRequestlist.add(booking1);

        actual   = "" + newTaxiCompany.getEveryPendingBookingRequest();
        expected = "" + testRequestlist;

        assertEquals(expected,actual);
    }
    @Test
    public void testgetEveryDeniedBookingRequest(){
//        to test if the contents are the same

        testRequestlist.add(booking3);

        actual   = "" + newTaxiCompany.getEveryDeniedBookingRequest();
        expected = "" + testRequestlist;

        assertEquals(expected,actual);
    }
    @Test
    public void testgetEveryUser3BookingRequest(){
//        to test if the contents are the same

        testRequestlist.add(booking2);

        actual   = "" + newTaxiCompany.getEveryBookingRequestFromAClient(user3);
        expected = "" + testRequestlist;
        assertEquals(expected,actual);
    }
    @Test
    public void testgetEveryUser1BookingRequest(){
//        to test if the contents are the same

        testRequestlist.add(booking1);
        testRequestlist.add(booking3);

        actual   = "" + newTaxiCompany.getEveryBookingRequestFromAClient(user1);
        expected = "" + testRequestlist;

        assertEquals(expected,actual);
    }
}
