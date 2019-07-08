import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShowCategories extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //reading userid from session
        //step-1 (fetch the session ojbect)
        HttpSession session=request.getSession();
        //step-2 (read the data from session)
        String uid=(String) session.getAttribute("userid");
        if(uid==null){
            response.sendRedirect("index.jsp");
        }
        
        
        
        PrintWriter out=response.getWriter();
        try{
        //fetch all the categories from database (product)
        Connection con=mypkg.Data.connect();
        String sql="select distinct pcat from products";
        PreparedStatement ps=con.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        //show them in form of hyperlink
        out.println("<html>");
        out.println("<body>");
        out.println("<h3>Welcome "+uid+"</h3>");
        out.println("<h3>Click-Desired-Category</h3>");
        out.println("<hr>");
        while(rs.next()){
            String s=rs.getString(1);
            out.println("<a href=ProductList?pc="+s+">");
            out.println(s);
            out.println("</a>");
            out.println("<br>");
        }
        out.println("<hr>");
        out.println("<h5><a href=customerdashboard.jsp>Customer-Home</a></h5>");
        out.println("</body>");
        out.println("</html>");
        }catch(Exception e){
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
