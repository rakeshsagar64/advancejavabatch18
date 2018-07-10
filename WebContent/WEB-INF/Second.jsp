<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page session="false" %>
<!DOCTYPE html>
<html lang="en">
<head>

  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Document</title>
  <link rel="stylesheet" href="style.css">

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=BioRhyme+Expanded" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.css" />
</head>
<body id="body">

  <!-- #navigation.navbar>img+ul.nav.navbar-nav.navbar-right>li*5>a{item $} -->
  <div id="navigation" class="navbar">
   
    <ul class="nav navbar-nav navbar-right">
      <li><a href="#">Welcome, ${username}</a></li>
      <li><a href="index.jsp">Home</a></li>
       <li><a href="Logout">Logout</a></li>
      <li><a href="">item 4</a></li>
      <li><a href="">item 5</a></li>
    </ul>
  </div>


  <table class="table">
    <tr>
      <td>JobId</td>
      <td>Company Name</td>
      <td>Job Role</td>
      <td>Experience</td>
      <td>Salary</td>
      <td>Work Location</td>
    </tr>
    
    <c:forEach var="temp" items="${sampleList}">
    	
    	<tr>
      <td>${temp.id}</td>
      <td>${temp.companyName}</td>
      <td>${temp.role}</td>
      <td>${temp.expRequired} Years</td>
      <td>${temp.salary}</td>
      <td>${temp.workLocation}</td>
    </tr>
    	
    </c:forEach>
 
     
  </table>






</body>
</html>
