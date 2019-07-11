<%@include file="info.jsp" %>

<%
    String v1="",v2="";
    //step-1 (fetch all cookies)
    Cookie ck[]=request.getCookies();
    //step-2 (search the desired one)
    if(ck!=null){
        
    
        for(Cookie c:ck){
            String name=c.getName();
            if(name.equals("email")){
                v1=c.getValue();
            }else if(name.equals("password")){
                v2=c.getValue();
            }
        }
    }
%>    


<html>
    <body>
        <h5>Login-Form</h5>
        <form action="VerifyUser" method="get">
            <pre>
            Email       <input type="text" name="email" value="<%=v1%>" />
            Password    <input type="password" name="password" value="<%=v2%>"/>
            Usertype    <select name="usertype"><option>admin</option><option>customer</option></select>
            SavePwd     <input type="checkbox" name="save"/>
                        <input type="submit" value="Login"/>
            </pre>
        </form>
        <hr>
        <a href="registration.jsp">New-User</a>
    </body>
</html>
<%@include file="scheme.jsp" %>