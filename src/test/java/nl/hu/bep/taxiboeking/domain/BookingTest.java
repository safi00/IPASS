package nl.hu.bep.taxiboeking.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookingTest {
    private String   today;
    private Client   user1;
    private Client   user3;
    private Employee user5;
    private Booking  taxiRide1;
    private Booking  taxiRide2;
    private Booking  taxiRide3;
    private Booking  taxiRide4;
    private Booking  taxiRide5;

    @BeforeEach
    public void init() {
        today = LocalDateTime.now().getDayOfMonth()+"/"+LocalDateTime.now().getMonth()+"/"+LocalDateTime.now().getYear();

        user1 = new Client( "Client","Blah@hotmail.com",true);
        user3 = new Client( "Client","Blah@hotmail.com",false);
        user5 = new Employee("Employee","england@taxi.com","TheRoyalJewels","The Queen of england","Manager");
        user3.setName("Xarvaine Martina");
        user3.setPassword("password");
        user3.setAge(22);
        user3.setPhoneNumber(555555566);
        taxiRide1 = new Booking(user1, "2017-02-05", "10:15","Vogelenzang 2","2801XD","","padulaan 101","1234VD",1,true);
        taxiRide2 = new Booking(user3, "2017-02-05", "10:15","Vogelenzang 2","2801XD","","padulaan 101","1234VD",3,false);
        taxiRide3 = new Booking(user3, "2017-02-05", "10:15","Vogelenzang 2","2801XD","","padulaan 101","1234VD",-6,true);
        taxiRide4 = new Booking(user3, "2020-06-05", "16:15","Vogelenzang 2","2801XD","PostNL Post Office Nieuwe-Marktpassage 6 2801HV, MacDonalds Nieuwe Gouwe O.Z 19 2803RA","padulaan 101","1234VD",8,false);
        taxiRide5 = new Booking(user3, "2017-02-05", "10:15","Vogelenzang 2","2801XD","","padulaan 101","1234VD",0,true);
    }
    @Test
    public void testAnonBooking(){
        assertEquals("From: Anon Client, Anon. BookDate = " + today + ", Drive Date = 5/FEBRUARY/2017, Drive Time = 10:15, Departure Address = 'Vogelenzang 2', Departure Postcode = '2801XD', Stopovers = '[No Stopovers]', Destination Address = 'padulaan 101', Destination Postcode = '1234VD'  With a total of 1 passengers, Status = 'Pending', SeenBy = 'none'",taxiRide1.toString());
    }
    @Test
    public void testRegisteredBooking(){
        assertEquals("From: Registered Client, Xarvaine Martina. BookDate = " + today + ", Drive Date = 5/FEBRUARY/2017, Drive Time = 10:15, Departure Address = 'Vogelenzang 2', Departure Postcode = '2801XD', Stopovers = '[No Stopovers]', Destination Address = 'padulaan 101', Destination Postcode = '1234VD'  With a total of 3 passengers, Status = 'Pending', SeenBy = 'none'",taxiRide2.toString());
    }
    @Test
    public void testRegisteredBookingWithStops() {
        assertEquals("From: Registered Client, Xarvaine Martina. BookDate = " + today + ", Drive Date = 5/JUNE/2020, Drive Time = 16:15, Departure Address = 'Vogelenzang 2', Departure Postcode = '2801XD', Stopovers = '[PostNL Post Office Nieuwe-Marktpassage 6 2801HV, MacDonalds Nieuwe Gouwe O.Z 19 2803RA]', Destination Address = 'padulaan 101', Destination Postcode = '1234VD'  With a total of 8 passengers, Status = 'Pending', SeenBy = 'none'", taxiRide4.toString());
    }

    //    getter
    @Test
    public void testGETBooker(){
        assertEquals(user3.toString(),taxiRide3.getClient().toString());
    }
    @Test
    public void testGETBookDate(){
        assertEquals(today,"" + taxiRide3.getBookDate().getDayOfMonth() + "/" + taxiRide3.getBookDate().getMonth() + "/" + taxiRide3.getBookDate().getYear());
    }
    @Test
    public void testGETDriveDate(){
        assertEquals("5/FEBRUARY/2017","" + taxiRide3.getDriveDate().getDayOfMonth() + "/" + taxiRide3.getDriveDate().getMonth() + "/" + taxiRide3.getDriveDate().getYear());
    }
    @Test
    public void testGETDriveTime(){
        assertEquals("10:15","" + taxiRide3.getDriveTime().getHour() + ":" + taxiRide3.getDriveTime().getMinute());
    }
    @Test
    public void testGETDepartureAddress(){
        assertEquals("Vogelenzang 2",taxiRide3.getDepartureAddress());
    }
    @Test
    public void testGETDeparturePostcode(){
        assertEquals("2801XD",taxiRide3.getDeparturePostcode());
    }
    @Test
    public void testGETStopOversWithNoStopovers(){
        List<String> stopsTest = new ArrayList<String>();
        stopsTest.add("No Stopovers");
        assertEquals(stopsTest,taxiRide3.getStopovers());
    }
    @Test
    public void testGETStopOversWithStopovers(){
        List<String> stopsTest = new ArrayList<String>();
        stopsTest.add("PostNL Post Office Nieuwe-Marktpassage 6 2801HV");
        stopsTest.add("MacDonalds Nieuwe Gouwe O.Z 19 2803RA");
        assertEquals(stopsTest,taxiRide4.getStopovers());
    }
    @Test
    public void testGETDestinationAddress(){
        assertEquals("padulaan 101",taxiRide3.getDestinationAddress());
    }
    @Test
    public void testGETDestinationPostcode(){
        assertEquals("1234VD",taxiRide3.getDestinationPostcode());
    }
    @Test
    public void testGETStatus(){
        assertEquals("Pending",taxiRide3.getStatus());
    }
    @Test
    public void testGETTotalPass(){
        assertEquals(8,taxiRide4.getTotalPass());
    }
    @Test
    public void testGETTotalPasswithNegative(){
        assertEquals(1,taxiRide3.getTotalPass());
    }
    @Test
    public void testGETTotalPasswithZero(){
        assertEquals(1,taxiRide5.getTotalPass());
    }
    //    set Status
    @Test
    public void testSETStatusReq(){
        taxiRide3.setRequestStatus(user5,"Accepted");
        assertEquals("Accepted",taxiRide3.getStatus());
    }

    @Test
    public void test24hrs(){
        assertFalse(taxiRide2.bookingBefore24Hours(taxiRide2));
    }
}