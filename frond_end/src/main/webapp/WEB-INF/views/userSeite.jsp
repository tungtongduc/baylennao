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

    <title>${user.name} seite</title>

    <!-- Bootstrap Core CSS -->
    <link href="/baylennao/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/baylennao/css/sb-admin.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="/baylennao/css/plugins/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/baylennao/font-awesome-4.1.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <link href="/baylennao/css/custome.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/baylennao/css/agency.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/baylennao/">baylennao</a>
            </div>
            <!-- Top Menu Items -->
            <ul class="nav navbar-right top-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> John Smith <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="#"><i class="fa fa-fw fa-user"></i> Profile</a>
                        </li>
                        <li>
                            <a data-toggle="modal" href="#changePassword">
                                <i class="fa fa-fw fa-gear"></i> 
                                Change pw
                            </a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-fw fa-gear"></i> Settings</a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#"><i class="fa fa-fw fa-power-off"></i> Log Out</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                    <li class="active">
                        <a class="page-scroll" href="#profile"><i class="fa fa-fw fa-user"></i> Profile</a>
                    </li>
                    <li>
                        <a class="collapsed" href="javascript:;" data-toggle="collapse" data-target="#demo"><i class="fa fa-fw fa-arrows-v"></i> event manager <i class="fa fa-fw fa-caret-down"></i></a>
                        <ul style="height: 0px;" id="demo" class="collapse">
                            <li>
                                <a href="#createdEvent"><i class="fa fa-fw fa-flag"></i> created Event</a>
                            </li>
                            <li>
                                <a href="#invitedEvent"><i class="fa fa-fw fa-bookmark"></i> invited Event</a>
                            </li>
                            <li>
                                <a href="#enteredEvent"><i class="fa fa-fw fa-star"></i> entered Event</a>
                            </li>
                            <li>
                                <a href="#newEvent"><i class="fa fa-fw fa-upload"></i> new Event</a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </nav>

        <div id="page-wrapper">

            <!-- <div class="container-fluid"> -->
<!-- profile Section -->
<section id="profile">

    <!-- ***** info modal dialog ***** -->
    <div class="modal" id="infoDialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <div class="row">
                        <div class="col-xs-3">
                            <i class="fa fa-pencil fa-5x"></i>
                        </div>
                        <div class="col-xs-9 text-right">
                            <div class="huge">Info</div>
                            <div>Doi bay xin thong bao:</div>
                        </div>
                    </div>
                </div>
                <div class="modal-body">
                  <!-- content hier -->
                    <br/><br/>

                    <c:if test="${param.infoMessage eq 'profileUpdateSuccess'}">
                        <div class="alert alert-success">You've been changged your profile successfully.
                        </div>
                    </c:if>

                    <c:if test="${param.infoMessage eq 'changePasswordSuccess'}">
                        <div class="alert alert-success">You've been changged your password successfully.
                        </div>
                    </c:if>

                    <c:if test="${param.infoMessage eq 'changePasswordFailure'}">
                        <div class="alert alert-danger">Change password is not successfully.
                        </div>
                    </c:if>
                    <br/><br/>
                </div>
                <div class="modal-footer">
                    <a data-dismiss="modal" class="btn btn-success"> exit </a>
                </div>
            </div>
        </div>
    </div>

    <!-- change Password -->
     <div class="modal" id="changePassword">
     <form role="form" action="/baylennao/profile/changepassword" method='POST'>
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <div class="row">
                        <div class="col-xs-3">
                            <i class="fa fa-user fa-5x"></i>
                        </div>
                        <div class="col-xs-9 text-right">
                            <div class="huge">Change</div>
                            <div>Password</div>
                        </div>
                    </div>
                </div>
                <div class="modal-body">
                  <!-- content hier -->
                    <div class="row  pad-top">
                        <div class="col-l-4 col-l-offset-4 col-l-6 col-l-offset-3 col-xs-10 col-xs-offset-1">
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
                            <br /><br />
                            
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <a data-dismiss="modal" class="btn btn-success"> exit </a>
                    <button class="btn btn-success " type="submit">Save</button>
                </div>
            </div>
        </div>
    </form>
    </div>
    <div class="modal" id="editProfile">
        <form action="/baylennao/profile/update" method="POST">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                      <div class="row">
                            <div class="col-xs-3">
                                <i class="fa fa-user fa-5x"></i>
                            </div>
                            <div class="col-xs-9 text-right">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                <div class="huge">${user.name}</div>
                                <div>Profile</div>
                            </div>
                        </div>
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
                          <a data-dismiss="modal" class="btn btn-success"> exit </a>
                          <button type="submit" class="btn btn-success">Save</button>
                    </div>
                </div>
            </div>
        </form>
    </div>
    <div class="row">
        <div class="col-lg-8 col-centered">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-xs-3">
                            <i class="fa fa-user fa-5x"></i>
                        </div>
                        <div class="col-xs-9 text-right">
                            <div class="huge">${user.name}</div>
                            <div>Profile</div>
                        </div>
                    </div>
                </div>
                <div class="panel-body">
                    <p class=" text-info">${serverTime}</p> 
                    <div class="row">
                        <div class="col-md-3 col-lg-3 " align="center"> 
                            <c:if test="${not empty user.avatar}">
                                <img alt="" src="${user.avatar}" width="150" height="150" class="img-circle"> 
                            </c:if>
                            <c:if test="${empty user.avatar}">
                                <img alt="" src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=100" class="img-circle"> 
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
                        <span class="pull-right">
                            <button data-toggle="modal" href="#editProfile" data-original-title="Edit this user" data-toggle="tooltip" type="button" class="btn btn-sm btn-warning">
                                <i class="glyphicon glyphicon-edit"></i>
                                Edit
                            </button>
                        </span>
                    </div>
                </div>
            </div> <!-- ./panel default -->
        </div> <!-- ./col-sm-6  -->
    </div> <!-- ./row -->
</section>

<!-- Portfolio Grid Section -->
<section id="createdEvent" class="bg-light-gray eventManagerStyle">
    <div class="row">
        <div class="col-lg-12 text-center">
            <h2 class="section-heading">Created Event</h2>
            <h3 class="section-subheading text-muted">process of establishing and operating.</h3>
        </div>
    </div>
    <div class="row">


        <!-- bat dau 1 block event -->
        <div class="col-md-3 col-sm-5 portfolio-item">
            <div class="portfolio-hover">
                <div class="portfolio-hover-content">
                    <a data-toggle="modal" href="#editEventID" ><i class="fa fa-edit fa-3x"></i>edit</a>
                </div>
            </div>
            <a href="#createdEventId" class="portfolio-link" data-toggle="modal">
                <img src="/baylennao/img/portfolio/startup-framework.png" class="img-responsive" alt="">
            </a>
            <div class="portfolio-caption">
                <h4>Event name</h4>
                <p class="text-muted">event content</p>
            </div>
        </div>
        <div class="modal" id="editEventID">
            <form action="/baylennao/profile/update" method="POST">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                           <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-tasks fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">edit Event:</div>
                                    <div>edit Tasks!</div>
                                </div>
                            </div>
                        </div>
                        
                        <div class="modal-body">
                            <table class="table table-user-information">
                                <tbody>
                                    <tr>
                                        <td>Event Name:</td>
                                        <td><input name="eventName" type="text" class="form-control" value="Baylennao"></td>
                                    </tr>
                                    <tr>
                                        <td>Event Beschreibung:</td>
                                        <td><input name="eventContent" type="text" class="form-control" value="Cung bay cung vui cung tan huong"></td>
                                    </tr>
                                    <tr>
                                        <td>Event Datum:</td>
                                        <td><input name="eventDate" type="text" class="form-control" value="23:00 09-08-2014"></td>
                                    </tr>
                                    <tr>
                                        <td>Event localtion:</td>
                                        <td><input name="eventLocation" type="text" class="form-control" value="E4 club"></td>
                                    </tr>
                                    <tr>
                                        <td>Event avatarURL:</td>
                                        <td><input name="eventIcon" type="text" class="form-control" value="http://www.baylennao/image/icon.img"></td>
                                    </tr>
                                    <tr>
                                        <td></td>
                                        <td>
                                            <br/>
                                            
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="modal-footer">
                              <a data-dismiss="modal" class="btn btn-success"> exit </a>
                              <button type="submit" class="btn btn-success">update event</button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
        <div class="modal" id="createdEventId">
            <form action="/baylennao/profile/update" method="POST">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                           <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-tasks fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">Event:</div>
                                    <div>edit Tasks!</div>
                                </div>
                            </div>
                        </div>
                        
                        <div class="modal-body">
                            <div class="row">
                                <div class="col-sm-12">
                                    <div class="col-xs-12 col-sm-8">
                                        <h2>Event Name</h2>
                                        <p><strong>Location: </strong> Berlin E4</p>
                                        <p><strong>Time: </strong></p>
                                        <p><strong>Content: </strong> Read, out with friends, listen to music, draw and learn new things. </p>
                                    </div>             
                                    <div class="col-xs-12 col-sm-4 text-center">
                                        <figure>
                                            <img src="/baylennao/img/portfolio/startup-framework.png" class="img-responsive" alt="">
                                            <figcaption class="ratings">
                                                <p>Ratings
                                                <a href="#">
                                                    <span class="fa fa-star"></span>
                                                </a>
                                                <a href="#">
                                                    <span class="fa fa-star"></span>
                                                </a>
                                                <a href="#">
                                                    <span class="fa fa-star"></span>
                                                </a>
                                                <a href="#">
                                                    <span class="fa fa-star"></span>
                                                </a>
                                                <a href="#">
                                                     <span class="fa fa-star-o"></span>
                                                </a> 
                                                </p>
                                            </figcaption>
                                        </figure>
                                    </div>
                                </div>            
                                <div class="col-xs-12 divider text-center">
                                    <div class="col-xs-12 col-sm-4 emphasis">
                                        <h2><strong> 2000 </strong></h2>                  
                                        <p><small>invites</small></p>
                                    </div>
                                    <div class="col-xs-12 col-sm-4 emphasis">
                                        <h2><strong>1500</strong></h2>                    
                                        <p><small>teilnehmer</small></p>
                                    </div>
                                    <div class="col-xs-12 col-sm-4 emphasis">
                                        <h2><strong>500</strong></h2>                    
                                        <p><small>vielleicht</small></p>
                                    </div>
                                </div>
                            </div>             
                        </div>
                        <div class="modal-footer">
                              <a data-dismiss="modal" class="btn btn-success"> exit </a>
                        </div>
                    </div>
                </div>
            </form>
        </div> 
        <!-- ket thuc 1 block event -->


        <div class="col-md-3 col-sm-5 portfolio-item">
            <a href="#portfolioModal3" class="portfolio-link" data-toggle="modal">
                <div class="portfolio-hover">
                    <div class="portfolio-hover-content">
                        <i class="fa fa-edit fa-3x"></i>edit
                    </div>
                </div>
                <img src="/baylennao/img/portfolio/treehouse.png" class="img-responsive" alt="">
            </a>
            <div class="portfolio-caption">
                <h4>Treehouse</h4>
                <p class="text-muted">Website Design</p>
            </div>
        </div>
        <div class="col-md-3 col-sm-5 portfolio-item">
            <a href="#portfolioModal1" class="portfolio-link" data-toggle="modal">
                <div class="portfolio-hover">
                    <div class="portfolio-hover-content">
                        <i class="fa fa-edit fa-3x"></i>edit
                    </div>
                </div>
                <img src="/baylennao/img/portfolio/roundicons.png" class="img-responsive" alt="">
            </a>
            <div class="portfolio-caption">
                <h4>Round Icons</h4>
                <p class="text-muted">Graphic Design</p>
            </div>
        </div>
        <div class="col-md-3 col-sm-5 portfolio-item">
            <a href="#portfolioModal4" class="portfolio-link" data-toggle="modal">
                <div class="portfolio-hover">
                    <div class="portfolio-hover-content">
                        <i class="fa fa-edit fa-3x"></i>edit
                    </div>
                </div>
                <img src="/baylennao/img/portfolio/golden.png" class="img-responsive" alt="">
            </a>
            <div class="portfolio-caption">
                <h4>Golden</h4>
                <p class="text-muted">Website Design</p>
            </div>
        </div>
        <div class="col-md-3 col-sm-5 portfolio-item">
            <a href="#portfolioModal5" class="portfolio-link" data-toggle="modal">
                <div class="portfolio-hover">
                    <div class="portfolio-hover-content">
                        <i class="fa fa-edit fa-3x"></i>edit
                    </div>
                </div>
                <img src="/baylennao/img/portfolio/escape.png" class="img-responsive" alt="">
            </a>
            <div class="portfolio-caption">
                <h4>Escape</h4>
                <p class="text-muted">Website Design</p>
            </div>
        </div>
        <div class="col-md-3 col-sm-5 portfolio-item">
            <a href="#portfolioModal6" class="portfolio-link" data-toggle="modal">
                <div class="portfolio-hover">
                    <div class="portfolio-hover-content">
                        <i class="fa fa-edit fa-3x"></i>edit
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
</section>


<!-- Portfolio Grid Section -->
<section id="invitedEvent" class="bg-light-gray eventManagerStyle">
    <div class="row">
        <div class="col-lg-12 text-center">
            <h2 class="section-heading">Inveted Event</h2>
            <h3 class="section-subheading text-muted">process of establishing and operating.</h3>
        </div>
    </div>
    <div class="row">
        <div class="col-md-3 col-sm-5 portfolio-item">
            <a href="#portfolioModal3" class="portfolio-link" data-toggle="modal">
                <div class="portfolio-hover">
                    <div class="portfolio-hover-content">
                        <a data-toggle="modal" href="#editEventID" ><i class="fa fa-edit fa-3x"></i>edit</a>
                    </div>
                </div>
                <img src="/baylennao/img/portfolio/treehouse.png" class="img-responsive" alt="">
            </a>
            <div class="portfolio-caption">
                <h4>Treehouse</h4>
                <p class="text-muted">Website Design</p>
            </div>
        </div>
        <div class="col-md-3 col-sm-5 portfolio-item">
            <a href="#portfolioModal1" class="portfolio-link" data-toggle="modal">
                <div class="portfolio-hover">
                    <div class="portfolio-hover-content">
                        <i class="fa fa-edit fa-3x"></i>edit
                    </div>
                </div>
                <img src="/baylennao/img/portfolio/roundicons.png" class="img-responsive" alt="">
            </a>
            <div class="portfolio-caption">
                <h4>Round Icons</h4>
                <p class="text-muted">Graphic Design</p>
            </div>
        </div>
        <div class="col-md-3 col-sm-5 portfolio-item">
            <a href="#portfolioModal2" class="portfolio-link" data-toggle="modal">
                <div class="portfolio-hover">
                    <div class="portfolio-hover-content">
                        <i class="fa fa-edit fa-3x"></i>edit
                    </div>
                </div>
                <img src="/baylennao/img/portfolio/startup-framework.png" class="img-responsive" alt="">
            </a>
            <div class="portfolio-caption">
                <h4>Startup Framework</h4>
                <p class="text-muted">Website Design</p>
            </div>
        </div>
        <div class="col-md-3 col-sm-5 portfolio-item">
            <a href="#portfolioModal3" class="portfolio-link" data-toggle="modal">
                <div class="portfolio-hover">
                    <div class="portfolio-hover-content">
                        <i class="fa fa-edit fa-3x"></i>edit
                    </div>
                </div>
                <img src="/baylennao/img/portfolio/treehouse.png" class="img-responsive" alt="">
            </a>
            <div class="portfolio-caption">
                <h4>Treehouse</h4>
                <p class="text-muted">Website Design</p>
            </div>
        </div>
        <div class="col-md-3 col-sm-5 portfolio-item">
            <a href="#portfolioModal4" class="portfolio-link" data-toggle="modal">
                <div class="portfolio-hover">
                    <div class="portfolio-hover-content">
                        <i class="fa fa-edit fa-3x"></i>edit
                    </div>
                </div>
                <img src="/baylennao/img/portfolio/golden.png" class="img-responsive" alt="">
            </a>
            <div class="portfolio-caption">
                <h4>Golden</h4>
                <p class="text-muted">Website Design</p>
            </div>
        </div>
        <div class="col-md-3 col-sm-5 portfolio-item">
            <a href="#portfolioModal5" class="portfolio-link" data-toggle="modal">
                <div class="portfolio-hover">
                    <div class="portfolio-hover-content">
                        <i class="fa fa-edit fa-3x"></i>edit
                    </div>
                </div>
                <img src="/baylennao/img/portfolio/escape.png" class="img-responsive" alt="">
            </a>
            <div class="portfolio-caption">
                <h4>Escape</h4>
                <p class="text-muted">Website Design</p>
            </div>
        </div>
        <div class="col-md-3 col-sm-5 portfolio-item">
            <a href="#portfolioModal6" class="portfolio-link" data-toggle="modal">
                <div class="portfolio-hover">
                    <div class="portfolio-hover-content">
                        <i class="fa fa-edit fa-3x"></i>edit
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
</section>


<!-- Portfolio Grid Section -->
<section id="enteredEvent" class="bg-light-gray eventManagerStyle">
    <div class="row">
        <div class="col-lg-12 text-center">
            <h2 class="section-heading">Entered Event</h2>
            <h3 class="section-subheading text-muted">process of establishing and operating.</h3>
        </div>
    </div>
    <div class="row">

        <!-- Bat dau 1 event dc goi den -->
        <div class="col-md-3 col-sm-5 portfolio-item">
            <a href="#inviteEventID" class="portfolio-link" data-toggle="modal">
                <img src="/baylennao/img/portfolio/roundicons.png" class="img-responsive" alt="">
            </a>
            <div class="portfolio-caption">
                <h4>Round Icons</h4>
                <p class="text-muted">Graphic Design</p>
            </div>
        </div>
        <div class="modal" id="inviteEventID">
            <form action="/baylennao/profile/update" method="POST">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                           <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-tasks fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">Event:</div>
                                    <div>edit Tasks!</div>
                                </div>
                            </div>
                        </div>
                        
                        <div class="modal-body">
                            <div class="row">
                                <div class="col-sm-12">
                                    <div class="col-xs-12 col-sm-8">
                                        <h2>Event Name</h2>
                                        <p><strong>Location: </strong> Berlin E4</p>
                                        <p><strong>Time: </strong></p>
                                        <p><strong>Content: </strong> Read, out with friends, listen to music, draw and learn new things. </p>
                                    </div>             
                                    <div class="col-xs-12 col-sm-4 text-center">
                                        <figure>
                                            <img src="/baylennao/img/portfolio/roundicons.png" class="img-responsive" alt="">
                                            <figcaption class="ratings">
                                                <p>Ratings
                                                <a href="#">
                                                    <span class="fa fa-star"></span>
                                                </a>
                                                <a href="#">
                                                    <span class="fa fa-star"></span>
                                                </a>
                                                <a href="#">
                                                    <span class="fa fa-star"></span>
                                                </a>
                                                <a href="#">
                                                    <span class="fa fa-star"></span>
                                                </a>
                                                <a href="#">
                                                     <span class="fa fa-star-o"></span>
                                                </a> 
                                                </p>
                                            </figcaption>
                                        </figure>
                                    </div>
                                </div>            
                                <div class="col-xs-12 divider text-center">
                                    <div class="col-xs-12 col-sm-4 emphasis">
                                        <h2><strong> 2000 </strong></h2>                    
                                        <p><small>invites</small></p>
                                        <button class="btn btn-success btn-block"><span class="glyphicon glyphicon-ok"></span> accept </button>
                                    </div>
                                    <div class="col-xs-12 col-sm-4 emphasis">
                                        <h2><strong>1500</strong></h2>                    
                                        <p><small>teilnehmer</small></p>
                                        <button class="btn btn-info btn-block"><span class="glyphicon glyphicon-remove"></span> not accept </button>
                                    </div>
                                    <div class="col-xs-12 col-sm-4 emphasis">
                                        <h2><strong>500</strong></h2>                    
                                        <p><small>vielleicht</small></p>
                                          <button type="button" class="btn btn-primary"><span class="glyphicon glyphicon-trash"></span> delete </button>
                                    </div>
                                </div>
                            </div>             
                        </div>
                        <div class="modal-footer">
                              <a data-dismiss="modal" class="btn btn-success"> exit </a>
                        </div>
                    </div>
                </div>
            </form>
        </div> 
        <!-- ket thuc 1 event dc goi den -->


        <div class="col-md-3 col-sm-5 portfolio-item">
            <a href="#portfolioModal2" class="portfolio-link" data-toggle="modal">
                <img src="/baylennao/img/portfolio/startup-framework.png" class="img-responsive" alt="">
            </a>
            <div class="portfolio-caption">
                <h4>Startup Framework</h4>
                <p class="text-muted">Website Design</p>
            </div>
        </div>
        <div class="col-md-3 col-sm-5 portfolio-item">
            <a href="#portfolioModal3" class="portfolio-link" data-toggle="modal">
                <img src="/baylennao/img/portfolio/treehouse.png" class="img-responsive" alt="">
            </a>
            <div class="portfolio-caption">
                <h4>Treehouse</h4>
                <p class="text-muted">Website Design</p>
            </div>
        </div>
        <div class="col-md-3 col-sm-5 portfolio-item">
            <a href="#portfolioModal4" class="portfolio-link" data-toggle="modal">
                <div class="portfolio-hover">
                    <div class="portfolio-hover-content">
                        <i class="fa fa-edit fa-3x"></i>edit
                    </div>
                </div>
                <img src="/baylennao/img/portfolio/golden.png" class="img-responsive" alt="">
            </a>
            <div class="portfolio-caption">
                <h4>Golden</h4>
                <p class="text-muted">Website Design</p>
            </div>
        </div>
        <div class="col-md-3 col-sm-5 portfolio-item">
            <a href="#portfolioModal5" class="portfolio-link" data-toggle="modal">
                <div class="portfolio-hover">
                    <div class="portfolio-hover-content">
                        <i class="fa fa-edit fa-3x"></i>edit
                    </div>
                </div>
                <img src="/baylennao/img/portfolio/escape.png" class="img-responsive" alt="">
            </a>
            <div class="portfolio-caption">
                <h4>Escape</h4>
                <p class="text-muted">Website Design</p>
            </div>
        </div>
        <div class="col-md-3 col-sm-5 portfolio-item">
            <a href="#portfolioModal6" class="portfolio-link" data-toggle="modal">
                <div class="portfolio-hover">
                    <div class="portfolio-hover-content">
                        <i class="fa fa-edit fa-3x"></i>edit
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

</section>


<!-- event Section -->
<section id="newEvent">
    <div class="row">
        <div class="col-lg-8 text-center col-centered">
            <div class="panel panel-info">
                <div class="panel-heading">
                    <div class="panel-heading">
                        <div class="row">
                            <div class="col-xs-3">
                                <i class="fa fa-tasks fa-5x"></i>
                            </div>
                            <div class="col-xs-9 text-right">
                                <div class="huge">New Event:</div>
                                <div>New Tasks!</div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="panel-body">
                    <br/>
                    <form action="#" method="POST">
                        <table class="table table-user-information">
                            <tbody>
                                <tr>
                                    <td>Event Name:</td>
                                    <td><input name="eventName" type="text" class="form-control" placeholder="Bay len nao"></td>
                                </tr>
                                <tr>
                                    <td>Event Beschreibung:</td>
                                    <td><input name="eventContent" type="text" class="form-control" placeholder="Cung bay cung vui cung tan huong"></td>
                                </tr>
                                <tr>
                                    <td>Event Datum:</td>
                                    <td><input name="eventDate" type="text" class="form-control" placeholder="23:00 09-08-2014"></td>
                                </tr>
                                <tr>
                                    <td>Event localtion:</td>
                                    <td><input name="eventLocation" type="text" class="form-control" placeholder="E4 club"></td>
                                </tr>
                                <tr>
                                    <td>Event avatarURL:</td>
                                    <td><input name="eventIcon" type="text" class="form-control" placeholder="http://www.baylennao/image/icon.img"></td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td>
                                        <br/>
                                        <button type="submit" class="btn btn-success">Create event</button>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </form>
                    <br/>
                    <br/>
                </div>
            </div>
        </div>
    </div>
</section> <!-- /.event Section -->


            <!-- </div> --> <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery Version 1.11.0 -->
    <script src="/baylennao/js/jquery-1.11.0.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/baylennao/js/bootstrap.min.js"></script>

    <!-- Morris Charts JavaScript -->
    <script src="/baylennao/js/plugins/morris/raphael.min.js"></script>
    <script src="/baylennao/js/plugins/morris/morris.min.js"></script>
    <script src="/baylennao/js/plugins/morris/morris-data.js"></script>

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

</body>

</html>
