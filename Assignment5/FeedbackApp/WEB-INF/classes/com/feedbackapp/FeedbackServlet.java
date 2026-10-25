package com.feedbackapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FeedbackServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        // Read the values submitted through the HTML form
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String type = request.getParameter("type");
        String comments = request.getParameter("comments");

        // Get the current date and time
        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        String dateTime = now.format(formatter);

        // Set the response content type
        response.setContentType("text/html;charset=UTF-8");

        // Get the writer to display HTML output
        PrintWriter out = response.getWriter();

        // Display the feedback details
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Feedback Response</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h2>Thank you, " + name
                + " for your feedback!</h2>");

        out.println("<p><b>Email:</b> " + email + "</p>");

        out.println("<p><b>Feedback Type:</b> "
                + type + "</p>");

        out.println("<p><b>Comments:</b> "
                + comments + "</p>");

        out.println("<p><b>Date and Time:</b> "
                + dateTime + "</p>");

        out.println("</body>");
        out.println("</html>");

        out.close();
    }
}
