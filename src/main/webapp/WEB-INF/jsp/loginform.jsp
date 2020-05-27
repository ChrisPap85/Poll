<%-- 
    Document   : startpage
    Created on : Feb 28, 2020, 6:40:50 PM
    Author     : Chris
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="css/poll.css">

        <title>Log in!</title>
    </head>
    <body class="fullpage">
        <div class="container h-100">
            
            <div class="row h-100 justify-content-center align-items-center ">
                <div class="col-6">
        <h1> Login Info: </h1>
             
            
         <form:form method="POST" action="/loginuser" 
                   modelAttribute="finduser" class="was-validated">
                   <div class="form-group">
            <form:label path="uloginname">Username &nbsp;</form:label>
            <form:input path="uloginname" class="form-control"  required="required"/>
        </div>

 <div class="form-group">
            <form:label path="upassword1">Password&nbsp;</form:label>
            <form:input path="upassword1" class="form-control" required="required"/>
        </div>
    
   
 
   
    
 <input type="submit" value="Submit" class="btn btn-primary">
 <a href="/" class="btn btn-danger">Back</a>
          
        </form:form>   
         
    </div>
    </div>
    </div>
    
    </body>
</html>
