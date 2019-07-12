<%@taglib  uri="/WEB-INF/tlds/ecomlib.tld" prefix="data" %>
<%@include file="info.jsp" %>

<%
  String uid=(String)session.getAttribute("userid");
  if(uid==null){
      response.sendRedirect("index.jsp");
  }
%>

<html>
    <body>
        <h3>Welcome-<%=uid%></h3>
        <hr>
        <pre>
        <a href="ShowCategories">Explore-Store</a>
        <a href="ShowAllProducts.jsp">View-All-Products</a>
        <a href="PriceList.jsp">View-Price-List</a>
        <a href="">Search-Product</a>
        <a href="DisplayCart">View-Cart</a>
        <a href="">Trace-Order</a>
        <a href="">Logout</a>
        </pre>
        <hr>
    </body>
</html>
<%--<data:pricelist/>--%>
<data:details code="113"/>
<%@include  file="scheme.jsp" %>