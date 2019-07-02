<html>
    <body>
        <h3>ECommerce-App</h3>
        <hr>
        <h5>Login-Form</h5>
        <form action="VerifyUser" method="get">
            <pre>
            Email       <input type="text" name="email"/>
            Password    <input type="password" name="password"/>
            Usertype    <select name="usertype"><option>admin</option><option>customer</option></select>
            SavePwd     <input type="checkbox" name="save"/>
                        <input type="submit" value="Login"/>
            </pre>
        </form>
        <hr>
        <a href="registration.jsp">New-User</a>
    </body>
</html>
