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
        <title>Forget Password</title>
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
        <style>
            .pt{
                padding-top: 5rem;
                padding-bottom: 5rem;
            }
            a{
            text-decoration:none;
            }
            .forget-password-section{
            background-color: #f3f5f9;
            height: 655px;
            }
            .forget-password-section .forget-password-form{
            background: #fff;
            padding: 2rem;
            color: #0F3D3E;
            border: 3px solid #fff;
            border-radius: 17px;
            box-shadow: rgb(99 99 99 / 20%) 0px 2px 8px 0px;
            }
            .forget-password-section .forget-password-form i{
            text-align: center;
            font-size: 45px;
            display: block;
            margin-bottom: 2rem;
            }
            .forget-password-section .forget-password-form input{
            padding: 0.7rem;
            }
            .forget-password-section .forget-password-form h1{
            text-align: center;
            margin-bottom: 2rem;
            font-weight: 600;
            }
            .forget-password-section .forget-password-form p{
            text-align: center;
            }
            .forget-password-section .forget-password-form button{
            width: 100%;
            background-color: #0F3D3E;
            border: #0F3D3E;
            color: #fff;
            font-size: 21px;
            margin-top: 1rem;
            }
            .forget-password-section .forget-password-form button:hover{
            background-color: #fff;
            color: #0F3D3E;
            border: 1px solid #0F3D3E;
            }
            .forget-password-section .forget-password-form .back{
            margin-top: 2rem;
            font-weight: 600;
            color: red;
            }
        </style>

        <script src="js/jquery.min.js"></script>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">

    </head>

    <body>
        <!-- header section start -->
        <div class="header_section">
            <div class="container-fluid">
                <nav class="navbar navbar-expand-lg navbar-light">
                    <div class="logo"><a href="/"
                            style="font-size: 24px; font-weight: 600; color: #202020; font-family: Poppins; line-height: 1.80857;">ABC
                            Jobs Pte
                            Ltd</a></div>
                    <button class="navbar-toggler" type="button" data-toggle="collapse"
                        data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                        aria-expanded="false" aria-label="Toggle navigation">
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
        <section class="forget-password-section pt" style="height: 800px;">
            <div class="container" style="margin-top: 50px;">
                <div class="row">
                    <div class="col-md-6 offset-md-3">
                        <div class="forget-password-form">
                            <i class="fa-solid fa-key"></i>
                            <p>
                                <b style="font-weight: 600;">${response}</b>
                            </p>
                            <h1>Forget Password ?</h1>
                            <p>No worry's we will send you reset instruction</p>
                            <form action="/forget" method="POST">
                                <div class="mb-3">
                                    <input type="email" class="form-control" name="email" placeholder="Email Address" autocomplete="off" required>
                                </div>
                                <button type="submit" class="btn">Reset Password</button>
                            </form>
                            <a href="login.html">
                                <p class="back">Back to Login</p>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        
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
                </div>
                <div style="display: flex; justify-content: center; padding: 20px 0; color: #202020;">
                    <a href="/sitemap">Sitemap</a>
                </div>
            </div>
            <!-- copyright section end -->
            <!-- Javascript files-->

    </body>

    </html>