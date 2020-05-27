<%-- 
    Document   : Results
    Created on : Mar 13, 2020, 11:28:39 AM
    Author     : Chris
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
          <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="css/poll.css">


        <title>Results</title>
    </head>
    <body class="fullpage">
        <div class="container h-100">
            <div class="row h-100 justify-content-center align-items-center ">
            <div class="text-center col-12">
       <h1>Welcome Candidate</h1>

       </div>
       <div class="col-12">

       <table class="table table-dark table-hover">
        <tr>

                <td>User First Name</td>
                <td>User Last Name</td>
                                <td>Rating</td>
      
            </tr>
       
       <c:forEach items="${allvoters}" var="can">
                  

                <tr>


                    <td>


                        ${can.voterid.uname}
                    </td>
                    <td>
                        ${can.voterid.username}

                        
                    </td>
                    <td>
                    
            
                       ${can.rating}


                    
             

                        </td>
                </tr>


            </c:forEach>
       
       </table>

       <div class="m-4">
        <button class="btn btn-lg btn-danger">

            <a class="text-white nolink" href="/">Home Page</a>
            </button>
         </div>

       </div>
       </div>
       </div>
    </body>
</html>

