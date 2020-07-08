




Design

Taxi Booking Application















Datum
:
14-05-’20


Version
:
1.2


Author
:
Xarvaine Martina





Date
Version
Description
14-05-’20
1.0
Initial document.
15-05-’20
1.1
Implemented the feedback.
16-05-’20
1.2
Class Diagram
Table of contents
1	Introduction	3
1.1	Optional sections:	3
2	Overview	3
3	Uses cases	3
3.1	Actors	3
3.2	Use case templates	3
3.3	Wireframes	3
4	Domain model	3
5	Technologies	4
6	User/Installation manual	4
7	References	4




    1 Introduction 
I explained to my mother what my assignment was, that I would need a client and that I should try to create a web application based on her suggestion. She wanted a website since she started driving taxis, so of course she suggested me create a website based on her work where the customer could book taxi rides with her. I explained before we start what it should look like,  I needed to know exactly how it should work. The assignment she suggested was a bit too simple so I had to add more roles to make it more complex and get the job done.
The web application is intended for tourists or anyone who needs transport and wants to book it in advance.
    2 Overview 
So the whole system is based on one thing: getting customers to book a taxi ride. That's easy. The customer must always go through the login and choose whether you want to register an account or remain anonymous and then fill in the details of the taxi ride in the form. The customer will receive an email confirming that the web application has received his booking request. an employee is notified of this booking request and confirms or refuses the request. either answer should send an email back to the user informing them of their status of their request.
    3 Uses cases


Booking Form:
In this subsystem, the customer(s) fill in the details to send a booking request.

Adjusting Booking Form:
In this subsystem the employee(s) or manager(s) can change certain options in the booking forms, which the customers can see and choose from the form when filling out.

Accepting Taxi Ride Request:
In this subsystem the employee(s) or manager(s) can see a list of all pending requests and from that list they can accept or decline the request.

Changing user info:
In this subsystem the customer(s) is going to change his account details. Customers can also go here to delete their accounts.

Adding / Removing users:
In this subsystem the manager(s) will create and delete any type of user.

Here you can see the use case that shows which roles have access to what systems in the web application. I believe the “login”,”register” and “logout” systems are self explanatory. 
When the client access Booking Taxi Ride they get directed to a page with a form. In that form they would need to fill in the date, time, place where the taxi would pick the client up and where it would be dropping the client off, all of this information is wrapped into a request and sent to the employees to accept or deny.
The adjusting booking form is the system where you adjust what options the clients can and not see and what recommended tours are visible to the clients.
Editing Account detailed is only for users that have more than just their emails saved saved. So anonymous clients are not able to access this system. Here you can change your name, email , password.
On adding users you would need to add every detail on them the type the name and etc. When removing a user you just get a list with all the users and there you just select one and delete.

        3.1 Actors (N.V.T)
        3.2 Use case templates (N.V.T)
        3.3 Wire-frames (N.V.T)
    4 Domain model
Entity
Description
User {abstract}
This class is what user classes are based on. both customers and employees are users.
Client
This class is where the type of customer is identified. There are 2 types; employees and managers.  The difference is that an anonymous user only has his email stored, a registered user has more info stored.
Employees
This class is where the type of employees is identified. There are 2 types; employees and managers.  The difference is that a manager has the ability to add / remove users.
Booking
This class is where the booking request is made. A booking request needs a customer. Here the customer can request the booking by filling in the form on the booking taxi ride page.
    5 Technologies
UML & JAVA

    6 Error: Reference source not found
As a customer
You would have to log in to submit a request. On the login screen, you would need to enter your email address and then check whether you want to remain anonymous or log in as a user. If so, just continue with your email. If not, you either need to register an account or enter your password to continue. After logging in, you should be directed to the booking page. There you would need to fill out the form. To ensure that the program received your request after filling out the form, you will receive an email. Confirming whether or not your request has been sent to the application. After that, as a registered user, you can change your account details, by filling out the form there.

As an employee
you should also log in, after logging in you would see multiple tabs that you can access.
Change account details, booking requests, customize the booking form and if you are a manager you can also see the user creation and deletion tabs.
Changing account information is where you would change your email address and password.
Booking Request is where you can see a list of all pending pending booking requests and then select one and accept or decline the request.
By customizing the booking form, employees can add and remove recommended taxi rides and destinations.
Creating users is where the employees fill out a form and create a user based on the information and deleting users is where the employees get a list of all users and select one to delete.
    7 References
Hogeschool Utrecht. (2019).   MOD.   Consulted from https://www.hu.nl/
Hogeschool Utrecht. (2020a). OOP.    Consulted from https://www.hu.nl/
Hogeschool Utrecht. (2020b). OOAD. Consulted from https://www.hu.nl/
