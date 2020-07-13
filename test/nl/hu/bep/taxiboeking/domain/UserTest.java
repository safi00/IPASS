package nl.hu.bep.taxiboeking.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private Client user1;
    private Client user2;
    private Client user3;
    private Employee user10;
    private Employee user20;
    @BeforeEach
    public void init() {
        user1  = new Client( "Client","Blah@hotmail.com",true);
        user2  = new Client( "Client","Blah@hotmail.com",false);
        user3  = new Client( "Client","Blah@hotmail.com",false);
        user10 = new Employee("Employee","blah@taxi.com","moeilijkepassword","James Bond","Employee");
        user20 = new Employee("Employee","england@taxi.com","TheRoyalJewels","The Queen of england","Manager");
        user3.setName("Xarvaine Martina");
        user3.setPassword("password");
        user3.setAge(22);
        user3.setPhoneNumber(12346789);
    }
    //    testing the boolean parameter for method isClientTypeAnon
    @Test
    public void testClientTypeAnon(){
        Client testuser = new Client( "Client","Test@hotmail.com",true);
        assertEquals("User Type = Client, clientType = 'Anon Client', email = 'Test@hotmail.com'",testuser.toString());
    }
    @Test
    public void testClientTypeRegis(){
        Client testuser = new Client( "Client","Test@hotmail.com",false);
        assertEquals("User Type = Client, clientType = 'Registered Client', email = 'Test@hotmail.com', name = 'null', age = '0', phonenumber = 'null', Address = 'null', password = 'null'",testuser.toString());
    }

    // i'm starting by testing the anon clients
    @Test
    public void testGETAnonToString(){
        assertEquals("User Type = Client, clientType = 'Anon Client', email = 'Blah@hotmail.com'",user1.toString());
    }
    @Test
    public void testGETAnonUserType(){
        assertEquals("Client",user1.getUserType());
    }
    @Test
    public void testGETAnonClientType(){
        assertEquals("Anon Client",user1.getClientType());
    }
    @Test
    public void testGETAnonEmail(){
        assertEquals("Blah@hotmail.com",user1.getUserEmailAddress());
    }
    @Test
    public void testGETAnonName(){
        assertEquals("Anon",user1.getName());
    }
    @Test
    public void testGETAnonAge(){
        assertEquals(0,user1.getAge());
    }
    @Test
    public void testGETAnonAddress(){
        assertEquals("No Address",user1.getAddress());
    }
    @Test
    public void testGETAnonPhoneNumber(){
        assertEquals("No Phonenumber",user1.getPhoneNumber());
    }
    @Test
    public void testGETAnonPassword(){
        assertNull(null,user1.getPassword());
    }

    //Anon clients are not allowed to change anything in their user details
    @Test
    public void testSETAnonToString(){
        user1.seteMailAddress("Anon@Anon.Anon");
        assertEquals("User Type = Client, clientType = 'Anon Client', email = 'Blah@hotmail.com'",user1.toString());
    }
    @Test
    public void testSETAnonEmail(){
        user1.seteMailAddress("Anon@Anon.Anon");
        assertEquals("Blah@hotmail.com",user1.getUserEmailAddress());
    }
    @Test
    public void testSETAnonName(){
        user1.setName("Ricardo");
        assertEquals("Anon",user1.getName());
    }
    @Test
    public void testSETAnonAge(){
        user1.setAge(18);
        assertEquals(0,user1.getAge());
    }
    @Test
    public void testSETAnonPassword(){
        user1.setPassword("99!@#$%2");
        assertNull(null,user1.getPassword());
    }

    //    Now to test the registered clients
    @Test
    public void testregisteredWithouttails(){
        assertEquals("User Type = Client, clientType = 'Registered Client', email = 'Blah@hotmail.com', name = 'null', age = '0', phonenumber = 'null', Address = 'null', password = 'null'",user2.toString());
    }
    @Test
    public void testregisteredWithouttailsSetsDetails(){
        user2.seteMailAddress("Edgy@hotmail.com");
        user2.setName("Elize-Marie");
        user2.setAge(27);
        user2.setAddress("vogelenzang 55 2801XD");
        user2.setPhoneNumber(87555999);
        user2.setPassword("9233452");
        assertEquals("User Type = Client, clientType = 'Registered Client', email = 'Edgy@hotmail.com', name = 'Elize-Marie', age = '27', phonenumber = '+31 6 87555999', Address = 'vogelenzang 55 2801XD', password = '9233452'",user2.toString());
    }
    @Test
    public void testregisteredWithdetails(){
        assertEquals("User Type = Client, clientType = 'Registered Client', email = 'Blah@hotmail.com', name = 'Xarvaine Martina', age = '22', phonenumber = '+31 6 12346789', Address = 'null', password = 'password'",user3.toString());
    }

    @Test
    public void testGETRegisteredUserType(){
        assertEquals("Client",user3.getUserType());
    }
    @Test
    public void testGETRegisteredClientType(){
        assertEquals("Registered Client",user3.getClientType());
    }
    @Test
    public void testGETRegisteredEmail(){
        assertEquals("Blah@hotmail.com",user3.getUserEmailAddress());
    }
    @Test
    public void testGETRegisteredName(){
        assertEquals("Xarvaine Martina",user3.getName());
    }
    @Test
    public void testGETRegisteredAge(){
        assertEquals(22,user3.getAge());
    }
    @Test
    public void testGETRegisteredPhoneNumber(){
        assertEquals("+31 6 12346789",user3.getPhoneNumber());
    }
    @Test
    public void testGETRegisteredPassword(){
        assertEquals("password",user3.getPassword());
    }

    //Only Anon clients are not allowed to change anything, registered clients are allowed
    @Test
    public void testSETRegisteredToString(){
        user3.seteMailAddress("This.Is.a.Different.Email@hotmail.com");
        user3.setName("Ricardo");
        user3.setAge(18);
        user3.setPhoneNumber(67445989);
        user3.setPassword("99!@#$%2");
        assertEquals("User Type = Client, clientType = 'Registered Client', email = 'This.Is.a.Different.Email@hotmail.com', name = 'Ricardo', age = '18', phonenumber = '+31 6 67445989', Address = 'null', password = '99!@#$%2'",user3.toString());
    }
    @Test
    public void testSETRegisteredEmail(){
        user3.seteMailAddress("This.Is.a.Different.Email@hotmail.com");
        assertEquals("This.Is.a.Different.Email@hotmail.com",user3.getUserEmailAddress());
    }
    @Test
    public void testSETRegisteredName(){
        user3.setName("Ricardo");
        assertEquals("Ricardo",user3.getName());
    }
    @Test
    public void testSETRegisteredAge(){
        user3.setAge(18);
        assertEquals(18,user3.getAge());
    }
    @Test
    public void testSETRegisteredPassword(){
        user3.setPassword("99!@#$%2");
        assertEquals("99!@#$%2",user3.getPassword());
    }

    //  Time to test the Employee users
    @Test
    public void testEmployeemed(){
        assertEquals("User Type = Employee, employeeType = 'Employee', email = 'blah@taxi.com', name = 'James Bond', password = 'moeilijkepassword'",user10.toString());
    }
    @Test
    public void testEmployeeman(){
        assertEquals("User Type = Employee, employeeType = 'Manager', email = 'england@taxi.com', name = 'The Queen of england', password = 'TheRoyalJewels'",user20.toString());
    }

    @Test
    public void testGETEmployeeUserType(){
        assertEquals("Employee",user20.getUserType());
    }
    @Test
    public void testGETEmployeeClientType(){
        assertEquals("Manager",user20.getEmployeeType());
    }
    @Test
    public void testGETEmployeeEmail(){
        assertEquals("england@taxi.com",user20.getUserEmailAddress());
    }
    @Test
    public void testGETEmployeeName(){
        assertEquals("The Queen of england",user20.getName());
    }
    @Test
    public void testGETEmployeePassword(){
        assertEquals("TheRoyalJewels",user20.getPassword());
    }

    //Only Anon clients are not allowed to change anything, Employee clients are allowed
    @Test
    public void testSETEmployeeToString(){
        user20.seteMailAddress("This.Is.a.Different.Email@hotmail.com");
        user20.setName("Ricardo");
        user20.setPassword("99!@#$%2");
        assertEquals("User Type = Employee, employeeType = 'Manager', email = 'This.Is.a.Different.Email@hotmail.com', name = 'Ricardo', password = '99!@#$%2'",user20.toString());
    }
    @Test
    public void testSETEmployeeEmail(){
        user20.seteMailAddress("This.Is.a.Different.Email@hotmail.com");
        assertEquals("This.Is.a.Different.Email@hotmail.com",user20.getUserEmailAddress());
    }
    @Test
    public void testSETEmployeeName(){
        user20.setName("Ricardo");
        assertEquals("Ricardo",user20.getName());
    }
    @Test
    public void testSETEmployeePassword(){
        user20.setPassword("99!@#$%2");
        assertEquals("99!@#$%2",user20.getPassword());
    }
}