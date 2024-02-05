<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
   <head>
      <!-- basic -->
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <!-- mobile metas -->
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <meta name="viewport" content="initial-scale=1, maximum-scale=1">
      <!-- site metas -->
      <title>Sitemap</title>
      <meta name="keywords" content="">
      <meta name="description" content="">
      <meta name="author" content="">
      <!-- bootstrap css -->
      <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
      <!-- style css -->
      <link rel="stylesheet" type="text/css" href="css/style.css">
      <!-- Responsive-->
      <link rel="stylesheet" href="css/responsive.css">
      <!-- fevicon -->
      <link rel="icon" href="images/fevicon.png" type="image/gif" />
      <!-- Scrollbar Custom CSS -->
      <link rel="stylesheet" href="css/jquery.mCustomScrollbar.min.css">

   </head>
   <body style="display: flex; flex-direction: column; min-height: 100vh;">
      <!-- header section start -->
      <div class="header_section">
         <div class="container-fluid">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
               <div class="logo"><a href="/" style="font-size: 24px; font-weight: 600; color: #202020;">ABC Jobs Pte Ltd</a></div>
               <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
               <span class="navbar-toggler-icon"></span>
               </button>
               <div class="collapse navbar-collapse" id="navbarSupportedContent">
                  <ul class="navbar-nav mr-auto">
                     <!-- <li class="nav-item">
                        <a class="nav-link" href="index.html">Home</a>
                     </li> -->
                     <!-- <li class="nav-item">
                        <a class="nav-link" href="services.html">services</a>
                     </li>
                     <li class="nav-item">
                        <a class="nav-link" href="about.html">About</a>
                     </li>
                     <li class="nav-item">
                        <a class="nav-link" href="shop.html">Shop</a>
                     </li>
                     <li class="nav-item">
                        <a class="nav-link" href="contact.html">Contact</a>
                     </li> -->
                  </ul>
                  <div class="search_icon">
                     <ul>
                        <li><a href="/login">LOGIN</a></li>
                     </ul>
                  </div>
               </div>
            </nav>
         </div>
      </div>
    <div class="" style="flex: auto 1;display: flex; flex-direction: column; align-items: center; padding: 10px 0; gap: 10px;">
        <h2 style="font-weight: 600; font-size: 24px; padding: 14px;">Sitemap</h2>
        <c:choose>
            <c:when test="${auth == true}">
                <div style="font-weight: 600; font-size: 18px; width: 200px;">
                    <a href="/" style="color: #202020;">Home</a>
                </div>
                <div style="font-weight: 600; font-size: 18px; width: 200px;">
                    <a href="/login" style="color: #202020;">Login</a>
                </div>
                <div style="font-weight: 600; font-size: 18px; width: 200px;">
                    <a href="/register" style="color: #202020;">Register</a>
                </div>
                <div style="font-weight: 600; font-size: 18px; width: 200px;">
                    <a href="/forget" style="color: #202020;">Password Recovery</a>
                </div>
            </c:when>
            <c:otherwise>
                <div style="font-weight: 600; font-size: 18px; width: 200px;">
                    <a href="/home" style="color: #202020;">Home</a>
                </div>
                <ul class="nav flex-column" style="margin-left: 25px; width: 200px;">
                    <li class="nav-item"><a href="/search?s=firstname&v=" class="nav-link p-0 text-muted">Search Users</a></li>
                    <li class="nav-item"><a href="/profile" class="nav-link p-0 text-muted">Profile</a></li>
                </ul>
                <div style="font-weight: 600; font-size: 18px; width: 200px;">
                    <a href="/login" style="color: #202020;">Login</a>
                </div>
                <div style="font-weight: 600; font-size: 18px; width: 200px;">
                    <a href="/register" style="color: #202020;">Register</a>
                </div>
                <div style="font-weight: 600; font-size: 18px; width: 200px;">
                    <a href="/forget" style="color: #202020;">Password Recovery</a>
                </div>
            </c:otherwise>
        </c:choose>

    </div>
     
      <!--  footer section end -->
      <!-- copyright section start -->
      <div class="copyright_section">
      <div class="container">
         <div class="social_icon">
            <ul>
               <li><a href="#"><img src="images/fb-icon.png"></a></li>
               <li><a href="#"><img src="images/twitter-icon.png"></a></li>
               <li><a href="#"><img src="images/instagram-icon.png"></a></li>
               <li><a href="#"><img src="images/linkedin-icon.png"></a></li>
            </ul>
            <div style="display: flex; justify-content: center; padding: 20px 0; color: #202020;">
                <a href="/sitemap">Sitemap</a>
            </div>
         </div>

      </div>
      <!-- copyright section end -->
      <!-- Javascript files-->

   </body>
</html>