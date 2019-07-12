package mypkg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
public class PriceListHandler extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        try{
            Connection con=mypkg.Data.connect();
            String sql="select pname,price from products";
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            out.println("<table border=2>");
            out.println("<tr><td>PName</td><td>Price</td></tr>");
            while(rs.next()){
                String s1=rs.getString(1);
                String s2=rs.getString(2);
                out.println("<tr>");
                out.println("<td>"+s1+"</td>");
                out.println("<td>"+s2+"</td>");
                out.println("</tr>");
            }
            out.println("</table>");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
