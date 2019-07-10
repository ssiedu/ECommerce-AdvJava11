<%
    String sql="select * from products";
    java.sql.Connection con=mypkg.Data.connect();
    java.sql.PreparedStatement ps=con.prepareStatement(sql);
    java.sql.ResultSet rs=ps.executeQuery();
%>
<html>
    <body>
        <h4>Product-List</h4>
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
                    String s1=rs.getString(1);
                    String s2=rs.getString(2);
                    String s3=rs.getString(3);
                    String s4=rs.getString(4);
                    String s5=rs.getString(5);
            %>
            <tr>
                <td>
                    <% out.println(s1); %>
                </td>
                <td>
                    <% out.println(s2); %>
                </td>
                <td>
                    <% out.println(s3); %>
                </td>                
                <td>
                    <% out.println(s4); %>
                </td>
                <td>
                    <% out.println(s5); %>
                </td>
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