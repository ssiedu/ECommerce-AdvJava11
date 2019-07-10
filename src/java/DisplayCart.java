import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DisplayCart extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        //Display The Shopping Cart of User
        HttpSession session=request.getSession();
        HashSet<String> set=(HashSet<String>) session.getAttribute("cart");
        out.println("<html>");
        out.println("<body>");
        if(set==null){
            out.println("<h4>Your Cart Is Empty</h4>");
            out.println("<h6><a href=ShowCategories>Start-Buying</a></h6>");
        }else{
            out.println("<h4>Your Cart</h4>");
            String sql="SELECT * FROM PRODUCTS WHERE PCODE IN "+set;
            sql=sql.replace('[', '(');
            sql=sql.replace(']', ')');
            try{
            Connection con=mypkg.Data.connect();
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            out.println("<table border=2>");
            out.println("<tr><td>Code</td><td>Name</td><td>Desc</td><td>Catg</td><td>Price</td></tr>");
            int sum=0;
            while(rs.next()){
                String s1=rs.getString(1);
                String s2=rs.getString(2);
                String s3=rs.getString(3);
                String s4=rs.getString(4);
                String s5=rs.getString(5);
                sum=sum+Integer.parseInt(s5);
                out.println("<tr>");
                out.println("<td>"+s1+"</td>");
                out.println("<td>"+s2+"</td>");
                out.println("<td>"+s3+"</td>");
                out.println("<td>"+s4+"</td>");
                out.println("<td align=right>"+s5+"</td>");
                out.println("<td><a href=RemoveItem?code="+s1+">[X]</a></td>");
                out.println("</tr>");
            }
            out.println("<tr>");
            out.println("<td></td><td></td><td></td>");
            out.println("<td>Total</td>");
            out.println("<td>"+sum+"</td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("<h6><a href=ShowCategories>Add-More</a></h6>");
            con.close();
            }catch(Exception e){
                out.println(e);
            }
        }
        out.println("<h6><a href=customerdashboard.jsp>CustomerPage</a></h6>");
        out.println("</html>");
        out.println("</html>");
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
