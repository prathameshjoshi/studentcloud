<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en" class="no-js"> <!--<![endif]-->
  <head>
    <meta charset="UTF-8" />
    <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
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
            
      <section>				
            
        <div id="container_demo" >
          <div id="wrapper">
            <div id="login" class="animate form">
              <form  action="../../j_spring_security_check" method="post" autocomplete="on"> 
                <h1>Log in</h1> 
                <p> 
                  <label for="username" class="uname" data-icon="u" > Your username </label>
                  <input id="j_username" name="j_username" required="required" type="text" placeholder="myusername or mymail@mail.com"/>
                </p>
                <p> 
                  <label for="password" class="youpasswd" data-icon="p"> Your password </label>
                  <input id="j_password" name="j_password" required="required" type="password" placeholder="eg. X8df!90EO" /> 
                </p>

                <p class="login button"> 
                  <input type="submit" value="Login" /> 
								</p>
                                
              </form>
            </div>

          </div>
         </div>  
        </section>
      </div>
  </body>
</html>
