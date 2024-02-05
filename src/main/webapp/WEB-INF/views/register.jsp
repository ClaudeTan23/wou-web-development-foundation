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
        <title>Register</title>
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
        <style type="text/css">
            * {
                color: #202020;
            }
            p {
                font-weight: 600;
            }
            .body {
                background: #9FCCDA;
                transition: all .5s;
                padding: 1px;
                min-height: 100vh;
                display: flex;
                align-items: center;
                justify-content: center;
            }
        
            .veen {
                width: 70%;
                margin: 100px auto;
                background: rgba(255, 255, 255, .5);
                min-height: 400px;
                display: table;
                position: relative;
                box-shadow: 0 0 4px rgba(0, 0, 0, .14), 0 4px 8px rgba(0, 0, 0, .28);
            }
        
            .veen>div {
                display: table-cell;
                vertical-align: middle;
                text-align: center;
                color: #fff;
            }
        
            .veen button {
                background: transparent;
                display: inline-block;
                padding: 10px 30px;
                border: 3px solid #fff;
                border-radius: 50px;
                background-clip: padding-box;
                position: relative;
                color: #FFF;
                transition: all .25s;
                font-weight: 600;
            }
        
            .veen button.dark {
                border-color: #9FCCDA;
                background: #9FCCDA;
            }
        
            .veen .move button.dark {
                border-color: #A08CD3;
                background: #A08CD3;
            }
        
            .veen .splits p {
                font-size: 18px;
            }
        
            .veen button:active {
                box-shadow: none;
            }
        
            .veen button:focus {
                outline: none;
            }
        
            .veen>.wrapper {
                position: absolute;
                width: 40%;
                height: 120%;
                top: -10%;
                left: 5%;
                background: #fff;
                box-shadow: 0 0 4px rgba(0, 0, 0, .14), 0 4px 8px rgba(0, 0, 0, .28);
                transition: all .5s;
                color: #303030;
                overflow: hidden;
            }
        
            .veen .wrapper>form {
                padding: 15px 30px 30px;
                width: 100%;
                transition: all .5s;
                background: #fff;
                width: 100%;
            }
        
            .veen .wrapper>form:focus {
                outline: none;
            }
        
            .veen .wrapper #login {
                padding-top: 20%;
                visibility: visible;
            }
        
            .veen .wrapper #register {
                transform: translateY(-80%) translateX(100%);
                visibility: hidden;
            }
        
            .veen .wrapper.move #register {
                transform: translateY(-80%) translateX(0%);
                visibility: visible;
            }
        
            .veen .wrapper.move #login {
                transform: translateX(-100%);
                visibility: hidden;
            }
        
            .veen .wrapper>form>div {
                position: relative;
                margin-bottom: 15px;
            }
        
            .veen .wrapper label {
                position: absolute;
                top: -7px;
                font-size: 12px;
                white-space: nowrap;
                background: #fff;
                text-align: left;
                left: 15px;
                padding: 0 5px;
                color: #999;
                pointer-events: none;
            }
        
            .veen .wrapper h3 {
                margin-bottom: 25px;
            }
        
            .veen .wrapper input {
                height: 40px;
                padding: 5px 15px;
                width: 100%;
                border: solid 1px #999;
            }
        
            .veen .wrapper input {
                height: 40px;
                padding: 5px 15px;
                width: 100%;
                border: solid 1px #999;
            }
        
            .veen .wrapper input:focus {
                outline: none;
                border-color: #9FCCDA;
            }
        
            .veen>.wrapper.move {
                left: 45%;
            }
        
            .veen>.wrapper.move input:focus {
                border-color: #A08CD3;
            }
        
            @media (max-width: 767px) {
                .veen {
                    padding: 5px;
                    margin: 0;
                    width: 100%;
                    display: block;
                }
        
                .veen>.wrapper {
                    position: relative;
                    height: auto;
                    top: 0;
                    left: 0;
                    width: 100%;
                }
        
                .veen>div {
                    display: inline-block;
                }
        
                .splits {
                    width: 50%;
                    background: #fff;
                    float: left;
                }
        
                .splits button {
                    width: 100%;
                    border-radius: 0;
                    background: #505050;
                    border: 0;
                    opacity: .7;
                }
        
                .splits button.active {
                    opacity: 1;
                }
        
                .splits button.active {
                    opacity: 1;
                    background: #9FCCDA;
                }
        
                .splits.rgstr-btn button.active {
                    background: #A08CD3;
                }
        
                .splits p {
                    display: none;
                }
        
                .veen>.wrapper.move {
                    left: 0%;
                }
            }
        
            input:-webkit-autofill,
            textarea:-webkit-autofill,
            select:-webkit-autofill {
                box-shadow: inset 0 0 0 50px #fff
            }
        
            .site-link {
                padding: 5px 15px;
                position: fixed;
                z-index: 99999;
                background: #fff;
                box-shadow: 0 0 4px rgba(0, 0, 0, .14), 0 4px 8px rgba(0, 0, 0, .28);
                right: 30px;
                bottom: 30px;
                border-radius: 10px;
            }
        
            .site-link img {
                width: 30px;
                height: 30px;
            }
        
            button:hover {
                cursor: pointer;
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
                    <div class="logo"><a href="/" style="font-size: 24px; font-weight: 600; color: #202020; font-family: Poppins; line-height: 1.80857;">ABC Jobs Pte
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
        <!-- header section end -->
        <!-- banner section start -->
       <div class="body" style="background: #A08CD3;">
        <div class="veen">
            <div class="login-btn splits">
                <p>Already an user?</p>
                <button class="active">Login</button>
            </div>
            <div class="rgstr-btn splits">
                <p>Don't have an account?</p>
                <button>Register</button>
            </div>
            <div class="wrapper active move">
                <form id="login" tabindex="500" action="/login" method="POST">
                    <c:if test="${!empty param}">
                        <b style="color: tomato;">Invalid username or password</b>
                    </c:if>
                    <h3>Login</h3>
                    <div class="mail">
                        <input type="text" name="username">
                        <label>Username</label>
                    </div>
                    <div class="passwd">
                        <input type="password" name="password">
                        <label>Password</label>
                    </div>
                    <div class="mail" style="text-align: left; font-size: 14px;">
                        <a href="/forget" style="color: #808080">Forget Password?</a>
                    </div>
                    <div class="submit">
                        <button class="dark active">Login</button>
                    </div>
                </form>
                <form id="register" tabindex="502" action="/register" method="POST">
                    <c:if test="${result != ''}">
                        <b style="color: tomato;">${result}</b>
                    </c:if>
                    <h3>Register</h3>
                    <div class="uid">
                        <input type="text" name="username" autocomplete="off" required>
                        <label>User Name</label>
                    </div>
                    <div class="passwd">
                        <input type="password" name="password" required>
                        <label>Password</label>
                    </div>
                    <div class="name">
                        <input type="text" name="firstname" autocomplete="off" required>
                        <label>First Name</label>
                    </div>
                    <div class="name">
                        <input type="text" name="lastname" autocomplete="off" required>
                        <label>Last Name</label>
                    </div>
                    <div class="mail">
                        <input type="email" name="email" autocomplete="off" required>
                        <label>Email</label>
                    </div>
                    <div class="submit">
                        <button class="dark">Register</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <script>
        $(document).ready(function () {
            $(".veen .rgstr-btn button").click(function () {
                $('.veen .wrapper').addClass('move');
                $('.body').css('background', '#A08CD3');
                $(".veen .login-btn button").removeClass('active');
                $(this).addClass('active');

            });
            $(".veen .login-btn button").click(function () {
                $('.veen .wrapper').removeClass('move');
                $('.body').css('background', '#9FCCDA');
                $(".veen .rgstr-btn button").removeClass('active');
                $(this).addClass('active');
            });
        });
    </script>
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