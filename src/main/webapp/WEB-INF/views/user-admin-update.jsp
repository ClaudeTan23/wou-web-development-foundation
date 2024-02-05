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
        <title>Profile</title>
        <meta name="keywords" content="">
        <meta name="description" content="">
        <meta name="author" content="">
        <!-- bootstrap css -->
        <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
        <!-- style css -->
        <link rel="stylesheet" type="text/css" href="/css/style.css">
        <!-- Responsive-->
        <link rel="stylesheet" href="/css/responsive.css">
        <!-- fevicon -->
        <link rel="icon" href="/images/fevicon.png" type="image/gif" />
        <!-- Scrollbar Custom CSS -->
        <link rel="stylesheet" href="/css/jquery.mCustomScrollbar.min.css">
        <script src="/js/bootstrap.bundles.min.js"></script>
    </head>

    <body style="display: flex; flex-direction: column; height: 100vh;">
        <!-- header section start -->
        <div class="header_section">
            <div class="container-fluid">
                <nav class="navbar navbar-expand-lg navbar-light bg-light">
                    <div class="logo"><a href="/home" style="font-size: 24px; font-weight: 600; color: #202020;">ABC
                            Jobs
                            Pte Ltd</a></div>
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
                        <div class="search_icon" style="width: 300px;">
                            <ul>
                                <li style="position: relative; width: 70px; display: flex; height: 20px;">
                                    <a href="/profile">
                                        <svg id="graph" width="60" height="60" style="position: absolute; top: -5px">

                                            <defs>
                                                <pattern id="image" x="0%" y="0%" height="100%" width="100%"
                                                    viewBox="0 0 512 512">
                                                    <image x="0%" y="0%" width="512" height="512"
                                                        xlink:href="/images/${auth.getImage()}"></image>
                                                </pattern>
                                            </defs>

                                            <circle id="sd" class="medium" cx="30" cy="20" r="20" fill="url(#image)"
                                                stroke="lightblue" stroke-width="1%" />
                                        </svg>
                                    </a>
                                </li>
                                <li><a href="/logout">LOGOUT</a></li>
                            </ul>
                        </div>
                    </div>
                </nav>
            </div>
        </div>

        <c:choose>
            <c:when test="${user == null}">
                <div style="display: flex; flex: auto 1; justify-content: center; align-items: center;">
                    <div class="row" style="display: flex; justify-content: center;">
                        <div style="min-width: 400px; padding: 20px;">
                            <div class="card card-margin" style="padding: 20px; text-align: center;">
                                <b>404 user not found...</b>
                            </div>
                        </div>
                    </div>
                </div>
            </c:when>
            <c:otherwise>
                <div class="container">
                    <div class="main-body">
                        <div class="row gutters-sm p-5">
                            <div class="col-md-4 mb-3">
                                <div class="card">
                                    <div class="card-body">
                                        <div style="display: flex; justify-content: right;" id="cancel-img">
                                            <!-- <button id="imgCancel" class="btn btn-close">Cancel</button> -->
                                        </div>
                                        <div class="d-flex flex-column align-items-center text-center">
                                            <label for="profileImage">
                                                <img src="/images/${user.image}" id="profileIcon" alt="" class="rounded-circle"
                                                    style="cursor: pointer; width: 150px; height: 150px;">
                                            </label>
                                            <div class="mt-3">
                                                <h4>${user.lastname} ${user.firstname}</h4>
                                                <!-- <p class="text-secondary mb-1">Full Stack Developer</p> -->
                                                <!-- <p class="text-muted font-size-sm">Bay Area, San Francisco, CA</p> -->
                                                <!-- <button class="btn btn-primary">Follow</button>
                                                        <button class="btn btn-outline-primary">Message</button> -->
                                            </div>
                                        </div>
                                    </div>
                                </div>
                
                            </div>
                            <div class="col-md-8">
                                <c:if test="${result != null}">
                                    <div style="display: flex; justify-content: center; font-weight: 600; padding: 5px 0;"
                                        class="text-secondary">
                                        ${result}
                                    </div>
                                </c:if>
                                <div class="card mb-3">
                                    <form action="/modify" method="post" enctype="multipart/form-data">
                                        <input type="file" accept="image/*" id="profileImage" name="profileImage" hidden>
                                        <input type="text" name="id" value="${user.getId()}" hidden>
                                        <div class="card-body">
                                            <div class="row">
                                                <div class="col-sm-3">
                                                    <h6 class="mb-0">User Name</h6>
                                                </div>
                                                <div class="col-sm-9 text-secondary">
                                                    ${user.username}
                                                </div>
                                            </div>
                                            <hr>
                                            <div class="row">
                                                <div class="col-sm-3">
                                                    <h6 class="mb-0">Password</h6>
                                                </div>
                                                <div class="col-sm-9 text-secondary"
                                                    style="display: flex; justify-content: space-between; flex-wrap: wrap;"
                                                    id="password">
                                                    <div style="width: 60%;">
                                                        <span>*******</span>
                                                        <input type="password" name="cPassword" placeholder="Confirm password"
                                                            class="text-secondary"
                                                            style="border-radius: 4px; width: 100%; border: 1px solid #6c757d; padding: 2px 6px;"
                                                            hidden readonly>
                                                        <!-- <input type="text" class="text-secondary" style="border-radius: 4px; width: 100%; border: 1px solid #6c757d; padding: 2px 6px;" required>
                                                            <input type="text" class="text-secondary" style="border-radius: 4px; width: 100%; border: 1px solid #6c757d; padding: 2px 6px;" required> -->
                                                    </div>
                                                    <button class="btn btn-base" id="changepw" type="button">Change</button>
                                                </div>
                                            </div>
                                            <hr>
                                            <div class="row">
                                                <div class="col-sm-3">
                                                    <h6 class="mb-0">First Name</h6>
                                                </div>
                                                <div class="col-sm-9 text-secondary">
                                                    <input type="text" class="text-secondary" name="firstname" value="${user.firstname}"
                                                        style="border-radius: 4px; width: 100%; border: 1px solid #6c757d; padding: 2px 6px;"
                                                        required>
                                                </div>
                                            </div>
                                            <hr>
                                            <div class="row">
                                                <div class="col-sm-3">
                                                    <h6 class="mb-0">Last Name</h6>
                                                </div>
                                                <div class="col-sm-9 text-secondary">
                                                    <input type="text" class="text-secondary" name="lastname" value="${user.lastname}"
                                                        style="border-radius: 4px; width: 100%; border: 1px solid #6c757d; padding: 4px 6px;"
                                                        required>
                                                </div>
                                            </div>
                                            <hr>
                                            <div class="row">
                                                <div class="col-sm-3">
                                                    <h6 class="mb-0">Email</h6>
                                                </div>
                                                <div class="col-sm-9 text-secondary">
                                                    <input type="text" class="text-secondary" name="email" value="${user.email}"
                                                        style="border-radius: 4px; width: 100%; border: 1px solid #6c757d; padding:4px 6px;"
                                                        required>
                                                </div>
                                            </div>
                                            <hr>
                                            <div class="row">
                                                <div class="col-sm-3">
                                                    <h6 class="mb-0">City/Country</h6>
                                                </div>
                                                <div class="col-sm-9 text-secondary">
                                                    <input type="text" class="text-secondary" name="city" value="${user.city}"
                                                        style="border-radius: 4px; width: 100%; border: 1px solid #6c757d; padding: 4px 6px;">
                                                    <!-- <c:if test="${user.city == null}">
                                                            No Set
                                                        </c:if>
                                                        ${user.city} -->
                                                </div>
                                            </div>
                                            <hr>
                                            <div class="row">
                                                <div class="col-sm-3">
                                                    <h6 class="mb-0">Company Name</h6>
                                                </div>
                                                <div class="col-sm-9 text-secondary">
                                                    <!-- <c:if test="${user.company_name == null}">
                                                            No Set
                                                        </c:if>
                                                        ${user.company_name} -->
                                                    <input type="text" class="text-secondary" name="company_name"
                                                        value="${user.company_name}"
                                                        style="border-radius: 4px; width: 100%; border: 1px solid #6c757d; padding: 4px 6px;">
                                                </div>
                                            </div>
                                            <hr>
                                            <div class="row">
                                                <div class="col-sm-12">
                                                    <button class="btn btn-secondary" type="submit">Edit</button>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                
                
                            </div>
                        </div>
                
                    </div>
                </div>
            </c:otherwise>
        </c:choose>

        <!--  footer section end -->
        <!-- copyright section start -->
        <div class="copyright_section">
            <div class="container">
                <div class="social_icon">
                    <ul>
                        <li><a href="#"><img src="/images/fb-icon.png"></a></li>
                        <li><a href="#"><img src="/images/twitter-icon.png"></a></li>
                        <li><a href="#"><img src="/images/instagram-icon.png"></a></li>
                        <li><a href="#"><img src="/images/linkedin-icon.png"></a></li>
                    </ul>
                </div>
                <div style="display: flex; justify-content: center; padding: 20px 0; color: #202020;">
                    <a href="/sitemap">Sitemap</a>
                </div>
            </div>
            <!-- copyright section end -->
            <!-- Javascript files-->
            <script src="/js/updateProfile.js"></script>
    </body>

    </html>