
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author Izu
 */
@WebServlet(urlPatterns = {"/OurServlet"})
public class OurServlet extends HttpServlet {

    /**
     * Author: 
     * Program Title: 
     * Description: Write a Java program to make a simple Servlet with 5 input
     * Date: 
     * Version Number: 1
     * 
     */
    
        
    //process "post" request from client
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html");
        ServletOutputStream objServletOutputStream = response.getOutputStream();
        String yourname = show(request.getParameterValues("name")[0], "Welcome Form");
        String youric = showIC(request.getParameterValues("ic")[0]);
        String yourMatID = showMatID(request.getParameterValues("matrixID")[0]);
        String yourClass = showClass(request.getParameterValues("className")[0]);
        String yourLect = showLect(request.getParameterValues("lecName")[0]);
        
        objServletOutputStream.write(yourname.getBytes());
        objServletOutputStream.write(youric.getBytes());
        objServletOutputStream.write(yourMatID.getBytes());
        objServletOutputStream.write(yourClass.getBytes());
        objServletOutputStream.write(yourLect.getBytes());
        objServletOutputStream.flush();
    }
    
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        
        res.setContentType("text/html");
        ServletOutputStream objServletOutputStream = res.getOutputStream();
        String outputAtTitleBar = FormToInputData("Welcome Form");
        
        objServletOutputStream.write(outputAtTitleBar.getBytes());
        objServletOutputStream.flush();
    }

    private String FormToInputData(String title) {
        
        return
                "<html><head><title>" + title +
                "</title></head>" +
                "<body>" +
                "<form METHOD=\"POST\">" +
                "<table border = 3 cellpadding = 3>" +
                "<tr>" +
                "<td>Name: </td>" +
                "<td><INPUT TYPE=\"text\" name=\"name\" size=30></td>" +
                "</tr>" +
                "<tr>" +
                "<td>IC: </td>" +
                "<td><INPUT TYPE=\"text\" name=\"ic\" size=30></td>" +
                "</tr>" +
                "<tr>" +
                "<td>Matrix ID: </td>" +
                "<td><INPUT TYPE=\"text\" name=\"matrixID\" size=30></td>" +
                "</tr>" +
                "<tr>" +
                "<td>Class: </td>" +
                "<td><INPUT TYPE=\"text\" name=\"className\" size=30></td>" +
                "</tr>" +
                "<tr>" +
                "<td>Lecturer Name: </td>" +
                "<td><INPUT TYPE=\"text\" name=\"lecName\" size=30></td>" +
                "</tr>" +
                "<tr>" +
                "<td> </td>" +
                "<td><INPUT TYPE=\"submit\" name=\"submitButton\" value=\"SUBMIT\"></td>" +
                "</tr>" +
                "</table>" +
                "</form></body></html>";
                            
    }
    
    private String show(String name, String title) {
        
        return
                "<html><title>" + title + "</title>" +
                "<body>" +
                "Welcome " + name +
                "<br />";
    }
    
    private String showIC(String ic) {
        
        return
                "Your IC is " + ic +
                "<br />";
    }
    
    private String showMatID(String matrixID) {
        
        return
                "Your Matrix ID is " + matrixID +
                "<br />";
    }
    
    private String showClass(String className) {
        
        return
                "Your class is " + className +
                "<br />";
    }
    
    private String showLect(String lecName) {
        
        return
                "Your lecturer is " + lecName +
                "<br />" + 
                "</body></html>";
    }

}
