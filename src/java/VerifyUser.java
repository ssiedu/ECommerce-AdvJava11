import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VerifyUser extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        String usertype=request.getParameter("usertype");
        
        if(usertype.equals("admin")){
            if(email.equals("admin@ssi.com") && password.equals("ssi")){
                //out.println("Welcome Admin");
                response.sendRedirect("admindashboard.jsp");
            }else{
                out.println("Invalid Admin Account");
            }
        }else if(usertype.equals("customer")){
            String sql="select * from users where email=? and password=?";
            try{
            Connection con=mypkg.Data.connect();
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs=ps.executeQuery();
            boolean success=rs.next();
            if(success){
                //out.println("Welcome Customer");
                response.sendRedirect("customerdashboard.jsp");
            }else{
                out.println("Invalid Customer Account");
            }
            con.close();
            }catch(Exception e){
                out.println(e);
            }
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
