<html>
    <body>
        <h3>ECommerce-App</h3>
        <h5>Product-Entry-Form</h5>
        <hr>
        <form action="SaveProduct" method="get">
            <pre>
            PCode       <input type="text" name="pcode"/>
            PName       <input type="text" name="pname"/>
            PDesc       <input type="text" name="pdesc"/>
            Category    <select name="pcat">
                            <option>auto</option>
                            <option>books</option>
                            <option>computer</option>
                            <option>electronics</option>
                            <option>furniture</option>
                            <option>others</option>
                        </select>
            Price       <input type="text" name="price"/>      
                        <input type="submit" value="Save"/>
            </pre>
        </form>
        <hr>
        <a href="admindashboard.jsp">Admin-Home</a>
    </body>
</html>
