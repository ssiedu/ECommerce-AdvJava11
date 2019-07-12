package mypkg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class DetailsHandler extends SimpleTagSupport {
    
    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
    
    

    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        try{
            Connection con=mypkg.Data.connect();
            String sql="select * from products where pcode=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, code);
            ResultSet rs=ps.executeQuery();
            rs.next();
            String s1=rs.getString(1);
            String s2=rs.getString(2);
            String s3=rs.getString(3);
            String s4=rs.getString(4);
            String s5=rs.getString(5);
            out.println("<h3>Product Details</h3>");
            out.println("Code   : "+s1+"<br>");
            out.println("Name   : "+s2+"<br>");
            out.println("Desc   : "+s3+"<br>");
            out.println("Catg   : "+s4+"<br>");
            out.println("Price  : "+s5+"<br>");
            con.close();
        }catch(Exception e){
            
        }
    }
    
}
