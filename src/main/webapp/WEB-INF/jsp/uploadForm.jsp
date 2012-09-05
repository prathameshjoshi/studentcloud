<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> <meta charset="UTF-8" />
    <title>Login and Registration Form with HTML5 and CSS3</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
    <meta name="description" content="Login and Registration Form with HTML5 and CSS3" />
    <meta name="keywords" content="html5, css3, form, switch, animation, :target, pseudo-class" />
    <meta name="author" content="Codrops" />
<!--     <script src="http://code.jquery.com/jquery-1.6.2.min.js"></script>
    <script src="http://code.jquery.com/mobile/1.0b3/jquery.mobile-1.0b3.min.js"></script> -->
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/demo.css" />" />
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css" />"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/animate-custom.css" />" />
</head>

<body>

<div class="container">
    <!-- Codrops top bar -->
      <h1>&nbsp;</h1>
      <section>       
        <h1>&nbsp;</h1>      
        <div id="container_demo" >
          <div id="wrapper">
            <h1>test4</h1>
            <div id="login" class="animate form">
            <h1>${username}</h1>
            <form:form method="post" enctype="multipart/form-data">
                <h1>File Uploader</h1>          
                
                <p> 
                  <label class="uname"> Select File </label>
                  <input id="file1" name="assetFile" required="required" type="file" />
                </p>
                

                <p class="login button"> 
                  <input type="submit" value="Upload" />
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  <input type= "button" value="Browse Files" ONCLICK="window.location.href='assets'" />
                  
                </p>
                
              </form:form>
              <h1>&nbsp;</h1>
            <p class="login button"> 
              <input type="button" value="LogOut" ONCLICK="window.location.href='<c:url value="/j_spring_security_logout"/>'"/>
               &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </p>
            </div>
          </div>
         </div>  
        </section>
      </div>


</body>
</html>
