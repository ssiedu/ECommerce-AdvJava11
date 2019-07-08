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
        <a href="">Search-Product</a>
        <a href="">View-Cart</a>
        <a href="">Trace-Order</a>
        <a href="">Logout</a>
        </pre>
        <hr>
    </body>
</html>
