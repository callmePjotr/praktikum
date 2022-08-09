import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(name = "RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    private static String encryptpw = null;
    private static Connection con = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet result = null;
    private static String pass = null;
    private static String email = null;
    private static final SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy' 'HH:mm:ss.SSS");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");

// Set standard HTTP/1.0 no-cache header.
        response.setHeader("Pragma", "no-cache");
        getServletContext().getRequestDispatcher("/register.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");

// Set standard HTTP/1.0 no-cache header.
        response.setHeader("Pragma", "no-cache");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(sdf2.format(timestamp) + " " + " " + "Request received");

        //Mit der Datenbank verbinden
        try {
            con = connect.connectToDatabase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        PrintWriter out = response.getWriter();
        //mittels Post die Werte holen
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        System.out.println(sdf2.format(timestamp) + " " + " " + login + " - Content of email form");
        System.out.println(sdf2.format(timestamp) + " " + " " + password +  " - Content of password form ");


        if (login == null || login.length() == 0 || login.equals(" ")){
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Invalid Email adress');");
            out.println("location='register.jsp';");
            out.println("</script>");
            return;
        } else if (login.length()<=6 && !login.contains("@") && !login.contains(".")) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Invalid Email adress');");
            out.println("location='register.jsp';");
            out.println("</script>");
            return;
        }

        if (password == null || password.length() == 0 || password.equals(" ")){
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Invalid password form');");
            out.println("location='register.jsp';");
            out.println("</script>");
            return;
        }

        //Passwort hashen
        try {
            encryptpw = encrypt.send(password);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        System.out.println(sdf2.format(timestamp) + " " + " " + encryptpw);

        //System.out.println(login + " " + password);

        if(login==null || password == null){
            request.setAttribute("error", "you are missing one of the inputs");
            getServletContext().getRequestDispatcher("/register.jsp").forward(request,response);
        }else{
            //dosomeStuff --> Passwort überprüfen

            try {
                String sql = "SELECT password, mail FROM geheimeszeug WHERE mail = ?";
                preparedStatement = con.prepareStatement(sql);
                //System.out.println(login);
                preparedStatement.setString(1,login);
                System.out.println(sdf2.format(timestamp) + " " + " " + sql + " - SQL prepared statement");
                result = preparedStatement.executeQuery();
                //System.out.println("Hello there!");
                while (result.next()){
                    //System.out.println(result.getString("password"));
                    pass = result.getString("password");
                    email = result.getString("mail");
                }
                //System.out.println("Hello there!");

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            //System.out.println(result);
            if(!encryptpw.equals(pass) && !email.equals(login) || encryptpw.equals(pass) && !email.equals(login) || !encryptpw.equals(pass) && email.equals(login)){
                System.out.println(sdf2.format(timestamp) + " " + " " + "pw/mail incorrect");
                getServletContext().getRequestDispatcher("/loginfailed.jsp").forward(request,response);
                request.setAttribute("error","Username or Password incorrect!");
            }else if (encryptpw.equals(pass) || email.equals(login) ){
                System.out.println(sdf2.format(timestamp) + " " + " " + "Login successful");
                getServletContext().getRequestDispatcher("/bonk.jsp").forward(request,response);
            }else{
                System.out.println(sdf2.format(timestamp) + " " + " " + "pw/mail incorrect");
                getServletContext().getRequestDispatcher("/loginfailed.jsp").forward(request,response);
                request.setAttribute("error","Username or Password incorrect!");
            }
        }
    }
}
