<%@page  import="java.sql.*,java.util.*" %>

<%@include file="info.jsp" %>
<%!
    ArrayList list;
    int y=20;
    int discount(int price){
        if(price>=10000){
            return price*10/100;
        }else{
            return price*5/100;
        }
}
%>    

<%
    int x=10;
    String sql="select * from products";
    Connection con=mypkg.Data.connect();
    PreparedStatement ps=con.prepareStatement(sql);
    ResultSet rs=ps.executeQuery();
%>
<html>
    <body>
        <h4>Products-Details</h4>
        <table border="2">
            <tr>
                <th>Code</th>
                <th>Name</th>
                <th>Desc</th>
                <th>Catg</th>
                <th>Price</th>
            </tr>
            <%
                while(rs.next()){
                    //String s1=rs.getString(1);
                    String s2=rs.getString(2);
                    String s3=rs.getString(3);
                    String s4=rs.getString(4);
                    String s5=rs.getString(5);
            %>
            <tr>
                <td><%=rs.getString(1)%></td>
                <td><%=s2%></td>
                <td><%=s3%></td>                
                <td><%=s4%></td>
                <td><%=s5%></td>
                <td><%=discount(Integer.parseInt(s5))%></td>
            </tr>
            <%
                }
            %>
        </table>
    </body>
</html>
<%
    con.close();
%>