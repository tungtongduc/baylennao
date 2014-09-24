<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Bay len nao !!!</title>

    <!-- Bootstrap Core CSS -->
    <link href="/baylennao/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap Core CSS -->
    <link href="/baylennao/css/custome.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/baylennao/css/agency.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/baylennao/font-awesome-4.1.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href='http://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
</head>

<body id="page-top" class="index">

<!-- Navigation -->
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header page-scroll">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand page-scroll" href="#page-top">Bay Len Nao</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li class="hidden">
                    <a href="#page-top"></a>
                </li>
                <li>
                    <a class="page-scroll" href="#events">Events</a>
                </li>
                <li>
                    <a class="page-scroll" href="#portfolio">Fotogallery</a>
                </li>
                <li>
                    <a class="page-scroll" href="#about">About</a>
                </li>
                <li>
                    <a class="page-scroll" href="#team">Team</a>
                </li>
                <li>
                    <a class="page-scroll" href="#contact">Contact</a>
                </li>
                <c:if test="${pageContext.request.userPrincipal.name != null}">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <i class="fa fa-user"></i> 
                        ${pageContext.request.userPrincipal.name}<b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li>
                            <a data-toggle="modal" href="#profile">
                                <i class="fa fa-fw fa-user"></i>  
                                Profile
                            </a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-fw fa-plus"></i> Create event</a>
                        </li>
                        <li>
                            <a data-toggle="modal" href="#changePassword">
                                <i class="fa fa-fw fa-gear"></i> 
                                Change Password
                            </a>
                        </li>
                        <li class="divider">
                        </li>
                        <li>
                            <a href="logout"><i class="fa fa-fw fa-power-off"></i> Log Out</a>
                        </li>
                    </ul>
                </li>
                </c:if>

                <c:if test="${pageContext.request.userPrincipal.name == null}">
                    <li class="dropdown">
                        <a data-toggle="modal" href="#login">
                            <i class="glyphicon glyphicon-user"></i>
                        </a>
                    </li>
                </c:if>
            </ul>
        </div>
    <!-- /.navbar-collapse -->
    </div>
<!-- /.container-fluid -->
</nav>

<!-- Header -->
<header>
    <div class="container" style="background-color: rgba(0,0,0, 0.2);">
        <div class="intro-text">
            <div class="intro-lead-in">Welcome To Bay Len Nao Group!</div>
            <div class="intro-heading">It's Nice To Meet You</div>
            <a href="#about" class="page-scroll btn btn-xl">Tell Me More</a>
        </div>
    </div>
    <c:if test="${pageContext.request.userPrincipal.name == null}">
    <!-- ***** login form ******** -->
    <div class="modal" id="login">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                  <h4 class="modal-title">Chuan bi bay</h4>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-l-6 col-l-4 col-l-offset-4">
                            <div class="account-wall">
                                <img class="profile-img" src="http://cache.desktopnexus.com/thumbnails/50970-bigthumbnail.jpg"
                                alt="">
                                <c:if test="${param.loginInfo eq 'loginFailue'}">
                                    <div class="error">Invalid username or password!
                                    </div>
                                </c:if>
                                <c:if test="${param.loginInfo eq 'registerSuceess'}">
                                    <div class="msg">You have registed successful! You can log in now!
                                    </div>
                                </c:if>
                                <form class="form-signin" action="/baylennao/j_spring_security_check" method='POST'>
                                    <input type="email" name="j_username" class="form-control" placeholder="Email" required min="3" max="15" autofocus />
                                    <input type="password" name="j_password" class="form-control" placeholder="Password" required min="6" max="20" />
                                    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
                                    <label class="checkbox pull-left">
                                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                        <input type="checkbox" name="_spring_security_remember_me" value="remember-me-parameter" />Remember me
                                    </label>
                                    <a href="#" class="pull-right need-help">Need help? </a><span class="clearfix"></span>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <h4><a href="#register" data-toggle="modal" data-dismiss="modal" class="text-center new-account">Create an account 
                    </a></h4>
                </div>
            </div>
        </div>
    </div>

    <!-- ***** register form ******** -->
    <div class="modal" id="register">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                  <h4 class="modal-title">Hay tham gia cung chung toi:</h4>
                </div>
                <div class="modal-body">
                    <c:if test="${param.registerInfo eq 'userExist'}">
                        <div class="error">User Email has been used! Choose another email!
                        </div>
                    </c:if>
                    <c:if test="${param.registerInfo eq 'errorRegister'}">
                        <div class="error">Invalid register data!!! Check data before senden!
                        </div>
                    </c:if>
                    <div class="row  pad-top">
                        <div class="col-l-4 col-l-offset-4 col-l-6 col-l-offset-3 col-xs-10 col-xs-offset-1">
                            <form role="form" action="/baylennao/register/add" method='POST'>
                                <br/>
                                <div class="form-group input-group">
                                    <span class="input-group-addon"><i class="fa fa-circle-o-notch"  ></i></span>
                                    <input type="text" name="name" class="form-control" placeholder="Your Name" />
                                </div>
                                <div class="form-group input-group">
                                    <span class="input-group-addon">@</span>
                                    <input type="email" name="email" class="form-control" placeholder="Your Email" required min="3" max="15" autofocus/>
                                </div>
                                <div class="form-group input-group">
                                    <span class="input-group-addon"><i class="fa fa-lock"  ></i></span>
                                    <input type="password" name="password" class="form-control" placeholder="Enter Password" required min="6" max="20" autofocus/>
                                </div>
                                <div class="form-group input-group">
                                    <span class="input-group-addon"><i class="fa fa-lock"  ></i></span>
                                    <input type="password" name="rePassword" class="form-control" placeholder="Retype Password" required min="6" max="20" autofocus/>
                                </div>

                                <button class="btn btn-success " type="submit">Register Me</button>
                                <br /><br />
                            </form>
                        </div>
                    </div> 
                </div>
                <div class="modal-footer">Already Registered ?  
                  <a data-toggle="modal" href="#login" data-dismiss="modal">Login here</a>
                </div>
            </div>
        </div>
    </div>
    <!-- ***** register form ******** -->
    </c:if>
    <c:if test="${pageContext.request.userPrincipal.name != null}">
    <!-- **** profile for User ***** -->
    <div class="modal" id="editProfile">
        <form action="/baylennao/profile/update" method="POST">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                      <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                      <h4 class="modal-title">${user.name} edit profile</h4>
                    </div>
                    
                    <div class="modal-body">
                        <p class="text-info">${serverTime}</p>
                        <table class="table table-user-information">
                            <tbody>
                                <input type="hidden" class="form-control" name="id" value="${user.id}" />
                                <tr>
                                    <td>Email:</td>
                                    <td>${user.email}</td>
                                    <input type="hidden" name="email" value=${user.email}>
                                </tr>
                                <tr>
                                    <td>Username:</td>
                                    <td><input type="text" class="form-control" name="name" value="${user.name}" /></td>
                                </tr>
                                <tr>
                                    <td>Phone:</td>
                                    <td><input type="text" class="form-control" name="phone" value="${user.phone}" /></td>
                                </tr>
                                <tr>
                                    <td>Birthday</td>
                                    <td><input type="text" class="form-control" name="birthday" value="${user.birthday}" /></td>
                                </tr>
                                <tr>
                                    <td>Adress</td>
                                    <td><input type="text" class="form-control" name="address" value="${user.address}" /></td>
                                </tr>
                                <tr>
                                    <td>Gender</td>
                                    <td><input type="text" class="form-control" name="gender" value="${user.gender}" /></td>
                                </tr>

                                <tr>
                                    <td>Icon-URL</td>
                                    <td><input type="text" class="form-control" name="avatar" value="${user.avatar}" /></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="modal-footer">
                          <a data-toggle="modal" data-dismiss="modal" href="#profile" class="btn btn-primary"> exit </a>
                          <button type="submit" class="btn btn-primary">Save</button>
                    </div>
                </div>
            </div>
        </form>
    </div>

    <div class="modal" id="profile">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                  <h4 class="modal-title">${user.name} profile</h4>
                </div>
                <div class="modal-body">
                    <p class=" text-info">${serverTime}</p>    
                    <div class="row">
                        <div class="col-md-3 col-lg-3 " align="center"> 
                            <c:if test="${not empty user.avatar}">
                                <img alt="User Pic" src="${user.avatar}" width="150" height="150" class="img-circle"> 
                            </c:if>
                            <c:if test="${empty user.avatar}">
                                <img alt="User Pic" src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=100" class="img-circle"> 
                            </c:if>
                        </div>

                        <div class=" col-md-9 col-lg-9 "> 
                            <table class="table table-user-information">
                                <tbody>
                                    <tr>
                                        <td>Email:</td>
                                        <td>${user.email}</td>
                                    </tr>
                                    <tr>
                                        <td>Username:</td>
                                        <td>${user.name}</td>
                                    </tr>
                                    <tr>
                                        <td>Phone:</td>
                                        <td>${user.phone}</td>
                                    </tr>
                                    <tr>
                                        <td>Birthday</td>
                                        <td>${user.birthday}</td>
                                    </tr>
                                    <tr>
                                        <td>Adress</td>
                                        <td>${user.address}</td>
                                    </tr>
                                    <tr>
                                        <td>Gender</td>
                                        <td>${user.gender}</td>
                                    </tr>
                                    <tr>
                                        <td>Created in:</td>
                                        <td>${user.createdOnDate}</td>
                                    </tr>
                                    <tr>
                                        <td>Last updated:</td>
                                        <td>${user.updatedOnDate}</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <span class="pull-right">
                        <button data-toggle="modal" data-dismiss="modal" href="#editProfile" data-original-title="Edit this user" data-toggle="tooltip" type="button" class="btn btn-sm btn-warning">
                            <i class="glyphicon glyphicon-edit"></i>
                            Edit
                        </button>
                    </span>
                </div>
            </div>
        </div>
    </div>
    <!-- change Password -->
    <div class="modal" id="changePassword"><div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
              <h4 class="modal-title">Change Password</h4>
            </div>
            <div class="modal-body">
                <div class="row  pad-top">
                    <div class="col-l-4 col-l-offset-4 col-l-6 col-l-offset-3 col-xs-10 col-xs-offset-1">
                        <form role="form" action="/baylennao/profile/changepassword" method='POST'>
                            <br/>
                            <div class="form-group input-group">
                                <span class="input-group-addon"><i class="fa fa-lock"  ></i></span>
                                <input type="password" name="old_password" class="form-control" placeholder="Old Password" required min="8" max="20" autofocus/>
                            </div>

                            <div class="form-group input-group">
                                <span class="input-group-addon"><i class="fa fa-lock"  ></i></span>
                                <input type="password" name="new_password" class="form-control" placeholder="New Password" required min="8" max="20" autofocus/>
                            </div>

                            <div class="form-group input-group">
                                <span class="input-group-addon"><i class="fa fa-lock"  ></i></span>
                                <input type="password" name="re_password" class="form-control" placeholder="Retype Password" required min="8" max="20" autofocus/>
                            </div>

                            <button class="btn btn-success " type="submit">Save</button>
                            <br /><br />
                        </form>
                    </div>
                </div> 
            </div>
        <!-- <form action="/baylennao/profile/changepassword" method="POST">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                        <h4 class="modal-title">Change your password</h4>
                    </div>
                    <div class="modal-body">
                        <div class="row">
                            <div class="col-l-6 col-l-4 col-l-offset-4">
                                <div class="account-wall">
                                    <img class="profile-img" src= "${user.avatar}" alt="user avatar">
                                    <c:if test="${not empty loginFalue}">
                                        <div class="error">Invalid username or password!
                                        </div>
                                    </c:if>
                                    Old Password: 
                                    <input type="password" class="form-control" required min="3" max="15" name="old_password" placeholder="your old password">
                                    New Password: 
                                    <input type="password" class="form-control" required min="3" max="15" name="new_password" placeholder="your new password">
                                    Repassword: 
                                    <input type="password" class="form-control" required min="3" max="15" name="re_password" placeholder="repeat your new password">
                                            
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <span class="pull-right">
                            <button type="submit" data-loading-text="Changing Password...">
                                <i class="glyphicon glyphicon-floppy-disk"></i>
                                Save
                            </button>
                        </span>
                    </div>
                </div>
            </div>
        </form> -->
    </div>
    </c:if>

    <!-- ***** info modal dialog ***** -->
    <div class="modal" id="infoDialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h4 class="modal-title">Bay group xin thong bao</h4>
                </div>
                <div class="modal-body">
                  <!-- content hier -->
                    <br/><br/>
                    <c:if test="${param.infoMessage eq 'logoutSuccess'}">
                        <div class="msg">You've been logged out successfully.
                        </div>
                    </c:if>

                    <c:if test="${param.infoMessage eq 'profileUpdateSuccess'}">
                        <div class="msg">You've been changged your profile successfully.
                        </div>
                    </c:if>

                    <c:if test="${param.infoMessage eq 'changePasswordSuccess'}">
                        <div class="msg">You've been changged your password successfully.
                        </div>
                    </c:if>

                    <c:if test="${param.infoMessage eq 'changePasswordFailure'}">
                        <div class="error">Change password is not successfully.
                        </div>
                    </c:if>
                    <br/><br/>
                </div>
            </div>
        </div>
    </div>
</header>

<!-- event Section -->
    <section id="events">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h1 class="section-heading" style="margin-top: 0px; margin-bottom: 100px;">our events</h1>
                </div>
            </div>
            <div class="row">
                <div class="col-md-4 col-sm-6 portfolio-item">
                    <a href="#portfolioModal1" class="portfolio-link" data-toggle="modal">
                        <img src="img/portfolio/roundicons.png" class="img-responsive" alt="">
                    </a>
                    <div class="portfolio-caption">
                        <h4>Round Icons</h4>
                        <p class="text-muted">Graphic Design</p>
                    </div>
                </div>
                <div class="col-md-4 col-sm-6 portfolio-item">
                    <a href="#portfolioModal2" class="portfolio-link" data-toggle="modal">
                        <img src="img/portfolio/startup-framework.png" class="img-responsive" alt="">
                    </a>
                    <div class="portfolio-caption">
                        <h4>Startup Framework</h4>
                        <p class="text-muted">Website Design</p>
                    </div>
                </div>
                <div class="col-md-4 col-sm-6 portfolio-item">
                    <a href="#portfolioModal3" class="portfolio-link" data-toggle="modal">
                        <img src="img/portfolio/treehouse.png" class="img-responsive" alt="">
                    </a>
                    <div class="portfolio-caption">
                        <h4>Treehouse</h4>
                        <p class="text-muted">Website Design</p>
                    </div>
                </div>
                <div class="col-md-4 col-sm-6 portfolio-item">
                    <a href="#portfolioModal4" class="portfolio-link" data-toggle="modal">
                        <img src="img/portfolio/golden.png" class="img-responsive" alt="">
                    </a>
                    <div class="portfolio-caption">
                        <h4>Golden</h4>
                        <p class="text-muted">Website Design</p>
                    </div>
                </div>
                <div class="col-md-4 col-sm-6 portfolio-item">
                    <a href="#portfolioModal5" class="portfolio-link" data-toggle="modal">
                        <img src="img/portfolio/escape.png" class="img-responsive" alt="">
                    </a>
                    <div class="portfolio-caption">
                        <h4>Escape</h4>
                        <p class="text-muted">Website Design</p>
                    </div>
                </div>
                <div class="col-md-4 col-sm-6 portfolio-item">
                    <a href="#portfolioModal6" class="portfolio-link" data-toggle="modal">
                        <img src="img/portfolio/dreams.png" class="img-responsive" alt="">
                    </a>
                    <div class="portfolio-caption">
                        <h4>Dreams</h4>
                        <p class="text-muted">Website Design</p>
                    </div>
                </div>
            </div>
        </div>
    </section>

<!-- Portfolio Grid Section -->
<section id="portfolio" class="bg-light-gray">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <h2 class="section-heading">Fotogallery</h2>
                <h3 class="section-subheading text-muted">All of BayGroups Albums.</h3>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4 col-sm-6 portfolio-item">
                <a href="#portfolioModal1" class="portfolio-link" data-toggle="modal">
                    <div class="portfolio-hover">
                        <div class="portfolio-hover-content">
                            <i class="fa fa-plus fa-3x"></i>
                        </div>
                    </div>
                    <img src="/baylennao/img/portfolio/roundicons.png" class="img-responsive" alt="">
                </a>
                <div class="portfolio-caption">
                    <h4>Round Icons</h4>
                    <p class="text-muted">Graphic Design</p>
                </div>
            </div>
            <div class="col-md-4 col-sm-6 portfolio-item">
                <a href="#portfolioModal2" class="portfolio-link" data-toggle="modal">
                    <div class="portfolio-hover">
                        <div class="portfolio-hover-content">
                            <i class="fa fa-plus fa-3x"></i>
                        </div>
                    </div>
                    <img src="/baylennao/img/portfolio/startup-framework.png" class="img-responsive" alt="">
                </a>
                <div class="portfolio-caption">
                    <h4>Startup Framework</h4>
                    <p class="text-muted">Website Design</p>
                </div>
            </div>
            <div class="col-md-4 col-sm-6 portfolio-item">
                <a href="#portfolioModal3" class="portfolio-link" data-toggle="modal">
                    <div class="portfolio-hover">
                        <div class="portfolio-hover-content">
                            <i class="fa fa-plus fa-3x"></i>
                        </div>
                    </div>
                    <img src="/baylennao/img/portfolio/treehouse.png" class="img-responsive" alt="">
                </a>
                <div class="portfolio-caption">
                    <h4>Treehouse</h4>
                    <p class="text-muted">Website Design</p>
                </div>
            </div>
            <div class="col-md-4 col-sm-6 portfolio-item">
                <a href="#portfolioModal4" class="portfolio-link" data-toggle="modal">
                    <div class="portfolio-hover">
                        <div class="portfolio-hover-content">
                            <i class="fa fa-plus fa-3x"></i>
                        </div>
                    </div>
                    <img src="/baylennao/img/portfolio/golden.png" class="img-responsive" alt="">
                </a>
                <div class="portfolio-caption">
                    <h4>Golden</h4>
                    <p class="text-muted">Website Design</p>
                </div>
            </div>
            <div class="col-md-4 col-sm-6 portfolio-item">
                <a href="#portfolioModal5" class="portfolio-link" data-toggle="modal">
                    <div class="portfolio-hover">
                        <div class="portfolio-hover-content">
                            <i class="fa fa-plus fa-3x"></i>
                        </div>
                    </div>
                    <img src="/baylennao/img/portfolio/escape.png" class="img-responsive" alt="">
                </a>
                <div class="portfolio-caption">
                    <h4>Escape</h4>
                    <p class="text-muted">Website Design</p>
                </div>
            </div>
            <div class="col-md-4 col-sm-6 portfolio-item">
                <a href="#portfolioModal6" class="portfolio-link" data-toggle="modal">
                    <div class="portfolio-hover">
                        <div class="portfolio-hover-content">
                            <i class="fa fa-plus fa-3x"></i>
                        </div>
                    </div>
                    <img src="/baylennao/img/portfolio/dreams.png" class="img-responsive" alt="">
                </a>
                <div class="portfolio-caption">
                    <h4>Dreams</h4>
                    <p class="text-muted">Website Design</p>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- About Section -->
<section id="about">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <h2 class="section-heading">About</h2>
                <h3 class="section-subheading text-muted">process of establishing and operating.</h3>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <ul class="timeline">
                    <li>
                        <div class="timeline-image">
                            <img class="img-circle img-responsive" src="/baylennao/img/about/1.jpg" alt="">
                        </div>
                        <div class="timeline-panel">
                            <div class="timeline-heading">
                                <h4>Begin 2011</h4>
                                <h4 class="subheading">Our BayGroups Beginning</h4>
                            </div>
                            <div class="timeline-body">
                                <p class="text-muted">Berlin nhung dem mua cung nhu nang, sau nhung buoi bay khong hen ma gap, anh em trong Bay Group cam thay rat yeu thuong va muon thong dit nhau nen da cung nhau lap ra to bay de luon gan bo voi nhau trong nhung lan bay den ... gay canh!</p>
                            </div>
                        </div>
                    </li>
                    <li class="timeline-inverted">
                        <div class="timeline-image">
                            <img class="img-circle img-responsive" src="/baylennao/img/about/2.jpg" alt="">
                        </div>
                        <div class="timeline-panel">
                            <div class="timeline-heading">
                                <h4>2011-2013</h4>
                                <h4 class="subheading">Our Process</h4>
                            </div>
                            <div class="timeline-body">
                                <p class="text-muted">Trong thoi ky khai son lap dia, anh em trong BayGroup luon luon o ben nhau va san sang thong dit het minh neu nhu thanh vien co nhu cau, that dang tiec mot vai thanh vien da thay doi quan diem va di theo to bay khac nhung co anh thi ca lang vui, vang anh thi ca lang ... van vui!</p>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="timeline-image">
                            <img class="img-circle img-responsive" src="/baylennao/img/about/3.png" style="background-color:white;" alt="">
                        </div>
                        <div class="timeline-panel">
                            <div class="timeline-heading">
                                <h4>July 2014</h4>
                                <h4 class="subheading">Official Website is Born</h4>
                            </div>
                            <div class="timeline-body">
                                <p class="text-muted">Voi muc dich cao ca la gan ket dan bay va nang canh cho nhung ban chuan bi vao con duong bay nhay, ban quan tri BayGroup da quyet dinh dua trang Web vao thu nghiem!</p>
                            </div>
                        </div>
                    </li>
                    <li class="timeline-inverted">
                        <div class="timeline-image">
                            <h4>Be Part
                                <br>Of Our
                                <br>Story!</h4>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
</section>

<!-- Team Section -->
<section id="team" class="bg-light-gray">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <h2 class="section-heading">Our Amazing Team</h2>
                <h3 class="section-subheading text-muted">Learn hard! Work hard! Play hard!</h3>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-4">
                <div class="team-member">
                    <img src="/baylennao/img/team/long.jpg" class="img-responsive img-circle" alt="">
                    <h4>Duc Long Pham</h4>
                    <p class="text-muted">Lead Marketer</p>
                    <ul class="list-inline social-buttons">
                        <li><a href="#"><i class="fa fa-twitter"></i></a>
                        </li>
                        <li><a href="#"><i class="fa fa-facebook"></i></a>
                        </li>
                        <li><a href="#"><i class="fa fa-linkedin"></i></a>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="team-member">
                    <img src="/baylennao/img/team/xanh.jpg" class="img-responsive img-circle" alt="">
                    <h4>Xuan Anh Nguyen</h4>
                    <p class="text-muted">Database Designer</p>
                    <ul class="list-inline social-buttons">
                        <li><a href="#"><i class="fa fa-twitter"></i></a>
                        </li>
                        <li><a href="#"><i class="fa fa-facebook"></i></a>
                        </li>
                        <li><a href="#"><i class="fa fa-linkedin"></i></a>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="team-member">
                    <img src="/baylennao/img/team/tony.jpg" class="img-responsive img-circle" alt="">
                    <h4>Tony Tong</h4>
                    <p class="text-muted">Interface Designer</p>
                    <ul class="list-inline social-buttons">
                        <li><a href="#"><i class="fa fa-twitter"></i></a>
                        </li>
                        <li><a href="#"><i class="fa fa-facebook"></i></a>
                        </li>
                        <li><a href="#"><i class="fa fa-linkedin"></i></a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2 text-center">
                <p class="large text-muted">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aut eaque, laboriosam veritatis, quos non quis ad perspiciatis, totam corporis ea, alias ut unde.</p>
            </div>
        </div>
    </div>
</section>

<section id="contact">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <h2 class="section-heading">Contact Us</h2>
                <h3 class="section-subheading text-muted">Your Feedback is so important and will help us to develop this Website better.</h3>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <form name="sentMessage" id="contactForm" novalidate>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Your Name *" id="name" required data-validation-required-message="Please enter your name.">
                                <p class="help-block text-danger"></p>
                            </div>
                            <div class="form-group">
                                <input type="email" class="form-control" placeholder="Your Email *" id="email" required data-validation-required-message="Please enter your email address.">
                                <p class="help-block text-danger"></p>
                            </div>
                            <div class="form-group">
                                <input type="tel" class="form-control" placeholder="Your Phone *" id="phone" required data-validation-required-message="Please enter your phone number.">
                                <p class="help-block text-danger"></p>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <textarea class="form-control" placeholder="Your Message *" id="message" required data-validation-required-message="Please enter a message."></textarea>
                                <p class="help-block text-danger"></p>
                            </div>
                        </div>
                        <div class="clearfix"></div>
                        <div class="col-lg-12 text-center">
                            <div id="success"></div>
                            <button type="submit" class="btn btn-xl">Send Message</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>

<footer>
    <div class="container">
        <div class="row">
            <div class="col-md-4">
                <span class="copyright">Copyright &copy; Bay Group Website 2014</span>
            </div>
            <div class="col-md-4">
                <ul class="list-inline social-buttons">
                    <li><a href="#"><i class="fa fa-twitter"></i></a>
                    </li>
                    <li><a href="#"><i class="fa fa-facebook"></i></a>
                    </li>
                    <li><a href="#"><i class="fa fa-linkedin"></i></a>
                    </li>
                </ul>
            </div>
            <div class="col-md-4">
                <ul class="list-inline quicklinks">
                    <li><a href="#">Privacy Policy</a>
                    </li>
                    <li><a href="#">Terms of Use</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</footer>

<!-- Portfolio Modals -->
<!-- Use the modals below to showcase details about your portfolio projects! -->

<!-- Portfolio Modal 1 -->
<div class="portfolio-modal modal fade" id="portfolioModal1" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-content">
        <div class="close-modal" data-dismiss="modal">
            <div class="lr">
                <div class="rl">
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2">
                    <div class="modal-body">
                        <!-- Project Details Go Here -->
                        <h2>Project Name</h2>
                        <p class="item-intro text-muted">Lorem ipsum dolor sit amet consectetur.</p>
                        <img class="img-responsive" src="/baylennao/img/portfolio/roundicons-free.png" alt="">
                        <p>Use this area to describe your project. Lorem ipsum dolor sit amet, consectetur adipisicing elit. Est blanditiis dolorem culpa incidunt minus dignissimos deserunt repellat aperiam quasi sunt officia expedita beatae cupiditate, maiores repudiandae, nostrum, reiciendis facere nemo!</p>
                        <p>
                            <strong>Want these icons in this portfolio item sample?</strong>You can download 60 of them for free, courtesy of <a href="https://getdpd.com/cart/hoplink/18076?referrer=bvbo4kax5k8ogc">RoundIcons.com</a>, or you can purchase the 1500 icon set <a href="https://getdpd.com/cart/hoplink/18076?referrer=bvbo4kax5k8ogc">here</a>.</p>
                            <ul class="list-inline">
                                <li>Date: July 2014</li>
                                <li>Client: Round Icons</li>
                                <li>Category: Graphic Design</li>
                            </ul>
                            <button type="button" class="btn btn-primary" data-dismiss="modal"><i class="fa fa-times"></i> Close Project</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Portfolio Modal 2 -->
    <div class="portfolio-modal modal fade" id="portfolioModal2" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-content">
            <div class="close-modal" data-dismiss="modal">
                <div class="lr">
                    <div class="rl">
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 col-lg-offset-2">
                        <div class="modal-body">
                            <h2>Project Heading</h2>
                            <p class="item-intro text-muted">Lorem ipsum dolor sit amet consectetur.</p>
                            <img class="img-responsive img-centered" src="/baylennao/img/portfolio/startup-framework-preview.png" alt="">
                            <p><a href="http://designmodo.com/startup/?u=787">Startup Framework</a> is a website builder for professionals. Startup Framework contains components and complex blocks (PSD+HTML Bootstrap themes and templates) which can easily be integrated into almost any design. All of these components are made in the same style, and can easily be integrated into projects, allowing you to create hundreds of solutions for your future projects.</p>
                            <p>You can preview Startup Framework <a href="http://designmodo.com/startup/?u=787">here</a>.</p>
                            <button type="button" class="btn btn-primary" data-dismiss="modal"><i class="fa fa-times"></i> Close Project</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Portfolio Modal 3 -->
    <div class="portfolio-modal modal fade" id="portfolioModal3" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-content">
            <div class="close-modal" data-dismiss="modal">
                <div class="lr">
                    <div class="rl">
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 col-lg-offset-2">
                        <div class="modal-body">
                            <!-- Project Details Go Here -->
                            <h2>Project Name</h2>
                            <p class="item-intro text-muted">Lorem ipsum dolor sit amet consectetur.</p>
                            <img class="img-responsive img-centered" src="/baylennao/img/portfolio/treehouse-preview.png" alt="">
                            <p>Treehouse is a free PSD web template built by <a href="https://www.behance.net/MathavanJaya">Mathavan Jaya</a>. This is bright and spacious design perfect for people or startup companies looking to showcase their apps or other projects.</p>
                            <p>You can download the PSD template in this portfolio sample item at <a href="http://freebiesxpress.com/gallery/treehouse-free-psd-web-template/">FreebiesXpress.com</a>.</p>
                            <button type="button" class="btn btn-primary" data-dismiss="modal"><i class="fa fa-times"></i> Close Project</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Portfolio Modal 4 -->
    <div class="portfolio-modal modal fade" id="portfolioModal4" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-content">
            <div class="close-modal" data-dismiss="modal">
                <div class="lr">
                    <div class="rl">
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 col-lg-offset-2">
                        <div class="modal-body">
                            <!-- Project Details Go Here -->
                            <h2>Project Name</h2>
                            <p class="item-intro text-muted">Lorem ipsum dolor sit amet consectetur.</p>
                            <img class="img-responsive img-centered" src="/baylennao/img/portfolio/golden-preview.png" alt="">
                            <p>Start Bootstrap's Agency theme is based on Golden, a free PSD website template built by <a href="https://www.behance.net/MathavanJaya">Mathavan Jaya</a>. Golden is a modern and clean one page web template that was made exclusively for Best PSD Freebies. This template has a great portfolio, timeline, and meet your team sections that can be easily modified to fit your needs.</p>
                            <p>You can download the PSD template in this portfolio sample item at <a href="http://freebiesxpress.com/gallery/golden-free-one-page-web-template/">FreebiesXpress.com</a>.</p>
                            <button type="button" class="btn btn-primary" data-dismiss="modal"><i class="fa fa-times"></i> Close Project</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Portfolio Modal 5 -->
    <div class="portfolio-modal modal fade" id="portfolioModal5" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-content">
            <div class="close-modal" data-dismiss="modal">
                <div class="lr">
                    <div class="rl">
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 col-lg-offset-2">
                        <div class="modal-body">
                            <!-- Project Details Go Here -->
                            <h2>Project Name</h2>
                            <p class="item-intro text-muted">Lorem ipsum dolor sit amet consectetur.</p>
                            <img class="img-responsive img-centered" src="/baylennao/img/portfolio/escape-preview.png" alt="">
                            <p>Escape is a free PSD web template built by <a href="https://www.behance.net/MathavanJaya">Mathavan Jaya</a>. Escape is a one page web template that was designed with agencies in mind. This template is ideal for those looking for a simple one page solution to describe your business and offer your services.</p>
                            <p>You can download the PSD template in this portfolio sample item at <a href="http://freebiesxpress.com/gallery/escape-one-page-psd-web-template/">FreebiesXpress.com</a>.</p>
                            <button type="button" class="btn btn-primary" data-dismiss="modal"><i class="fa fa-times"></i> Close Project</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Portfolio Modal 6 -->
    <div class="portfolio-modal modal fade" id="portfolioModal6" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-content">
            <div class="close-modal" data-dismiss="modal">
                <div class="lr">
                    <div class="rl">
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 col-lg-offset-2">
                        <div class="modal-body">
                            <!-- Project Details Go Here -->
                            <h2>Project Name</h2>
                            <p class="item-intro text-muted">Lorem ipsum dolor sit amet consectetur.</p>
                            <img class="img-responsive img-centered" src="/baylennao/img/portfolio/dreams-preview.png" alt="">
                            <p>Dreams is a free PSD web template built by <a href="https://www.behance.net/MathavanJaya">Mathavan Jaya</a>. Dreams is a modern one page web template designed for almost any purpose. It’s a beautiful template that’s designed with the Bootstrap framework in mind.</p>
                            <p>You can download the PSD template in this portfolio sample item at <a href="http://freebiesxpress.com/gallery/dreams-free-one-page-web-template/">FreebiesXpress.com</a>.</p>
                            <button type="button" class="btn btn-primary" data-dismiss="modal"><i class="fa fa-times"></i> Close Project</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- jQuery Version 1.11.0 -->
    <script src="/baylennao/js/jquery-1.11.0.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/baylennao/js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
    <script src="/baylennao/js/classie.js"></script>
    <script src="/baylennao/js/cbpAnimatedHeader.js"></script>

    <!-- Contact Form JavaScript -->
    <!--      <script src="/baylennao/js/jqBootstrapValidation.js"></script>
    <script src="/baylennao/js/contact_me.js"></script> -->

    <!-- Custom Theme JavaScript -->
    <script src="/baylennao/js/agency.js"></script>

    <c:if test="${not empty param.infoMessage}">

        <script>
            $(window).load(function(){
                $('#infoDialog').modal('show');
            });
        </script>

    </c:if>

    <c:if test="${not empty param.loginInfo}">
        <script >
            $(window).load(function(){
                $('#login').modal('show');
            });
        </script>
    </c:if>

    <c:if test="${not empty param.registerInfo}">
        <script >
            $(window).load(function(){
                $('#register').modal('show');
            });
        </script>
    </c:if>
</body>
</html>
