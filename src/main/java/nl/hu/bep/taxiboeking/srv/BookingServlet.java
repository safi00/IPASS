package nl.hu.bep.taxiboeking.srv;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/BookingTaxiRide")
public class BookingServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // read form fields
        String tours = request.getParameter("tours");
        String drivedate = request.getParameter("drivedate");
        String drivetime = request.getParameter("drivetime");
        String departureAddress = request.getParameter("departureAddress");
        String departurePostcode = request.getParameter("departurePostcode");
        String stopoversList = request.getParameter("stopovers");
        String destinationAddress = request.getParameter("destinationAddress");
        String destinationPostcode = request.getParameter("destinationPostcode");
        String rountrip = request.getParameter("rountrip");

        String[] stopovers = stopoversList.split(",");

        System.out.println("tours: " + tours);
        System.out.println("drivedate: " + drivedate);
        System.out.println("drivetime: " + drivetime);
        System.out.println("depad: " + departureAddress);
        System.out.println("depPos: " + departurePostcode);
        System.out.println("stop: " + Arrays.toString(stopovers));
        System.out.println("destad: " + destinationAddress);
        System.out.println("destPos: " + destinationPostcode);
        System.out.println("rountrip: " + rountrip);
        // do some processing here...

        // get response writer
        PrintWriter writer = new PrintWriter(response.getWriter());

        // build HTML code
        String htmlRespone = "<html>";
        htmlRespone += "<h2>Your chosen tour is: " + tours + "<br/>";
        htmlRespone += "Your chosen drivedate is: " + drivedate + "<br/>";
        htmlRespone += "Your chosen drivetime is: " + drivetime + "<br/>";
        htmlRespone += "Your chosen departureAddress is: " + departureAddress + "<br/>";
        htmlRespone += "Your chosen departurePostcode is: " + departurePostcode + "<br/>";
        htmlRespone += "Your chosen stopovers is: " + Arrays.toString(stopovers) + "<br/>";
        htmlRespone += "Your chosen destinationAddress is: " + destinationAddress + "<br/>";
        htmlRespone += "Your chosen destinationPostcode is: " + destinationPostcode + "<br/>";
        htmlRespone += "Your chosen tour is: " + rountrip + "</h2>";
        htmlRespone += "</html>";

        // return response
        writer.println(htmlRespone);
    }
}

