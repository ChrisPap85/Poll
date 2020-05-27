<%-- 
    Document   : voterpage
    Created on : Mar 6, 2020, 12:33:29 PM
    Author     : Chris
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
  <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="css/poll.css">

        <title>Voter Page</title>
    </head>
    <body class="fullpage">
        <div class="container h-100">
            <div class="row h-100 justify-content-center align-items-center ">
            <div class="text-center col-12">
       <h1>Welcome Voter</h1>

       </div>
       <div class="col-12">
        <form:form method="POST" action="/vote" 
                   modelAttribute="polluser">
       <table class="table table-dark table-hover">
        <tr>

                <td>Candidate First Name</td>
                <td>Candidate Last Name</td>
                                <td>Select to vote</td>

           
            </tr>
       
       <c:forEach items="${allcandidates}" var="op">

                <tr>


                    <td>


                        ${op.username}
                    </td>
                    <td>
                        ${op.uname}

                        
                    </td>
                    <td>
                    
            
               

                    
        <div class="starrr" id="star1" >
                        <a href="vote/${op.uid}/1" class="fa fa-star fa" value="1"></a>
                        <a href="vote/${op.uid}/2" class="fa-star fa" value="2"></a>
                        <a href="vote/${op.uid}/3" class="fa-star fa" value="3"></a>
                        <a href="vote/${op.uid}/4" class="fa-star fa" value="4"></a>
                        <a href="vote/${op.uid}/5" class="fa-star fa" value="5"></a>
                    </div>
                        

                        </td>
                </tr>


            </c:forEach>
                
       </table>

        </form:form>
        </div>
    </div>
        </div>
             <script async="" src="//www.google-analytics.com/analytics.js"></script>
             <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/1.11.1/jquery.js"></script>
  <script src="javascript/poll.js"></script>

    </body>
</html>