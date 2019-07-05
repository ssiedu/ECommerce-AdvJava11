import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductDetails extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String code = request.getParameter("code");
        String sql = "select * from products where pcode=?";
        try {
            Connection con = mypkg.Data.connect();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(code));
            ResultSet rs = ps.executeQuery();
            rs.next();
            String pcode=rs.getString("pcode");
            String pdesc=rs.getString("pdesc");
            String pname=rs.getString("pname");
            String pcat=rs.getString("pcat");
            String price=rs.getString("price");
            
            
            out.println("<html>");
            out.println("<body>");
            out.println("<h3>Product-Details</h3>");
            out.println("<hr>");
            out.println("<table border=2>");
            out.println("<tr>");
            out.println("<td>PCode</td>");
            out.println("<td>"+pcode+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>PName</td>");
            out.println("<td>"+pname+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>PDesc</td>");
            out.println("<td>"+pdesc+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>PCat</td>");
            out.println("<td>"+pcat+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Price</td>");
            out.println("<td>"+price+"</td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("<hr>");
            out.println("<a href=CartManager?code="+pcode+">Buy</a><br>");
            out.println("<a href=ShowCategories>Category-Page</a><br>");
            out.println("<a href=customerdashboard.jsp>Customer-Home</a><br>");
            out.println("</body>");
            out.println("</html>");
            con.close();
        } catch (Exception e) {
            out.println(e);
        }

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
