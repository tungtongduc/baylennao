<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Chuan bi cat canh nao!</title>
<style>
</style>

 <!-- Bootstrap Core CSS -->
    <link href="/baylennao/css/bootstrap.min.css" rel="stylesheet">
 <!-- Bootstrap Core CSS -->
    <link href="/baylennao/css/custome.css" rel="stylesheet">
    
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
<body>

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
                <a class="navbar-brand page-scroll" href="baylennao">Bay Len Nao</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="hidden">
                        <a href="#page-top"></a>
                    </li>


                    <li><a href="/usermanager/register">Sign Up</a></li>
                  	<li class="divider-vertical"></li>
					<li class="dropdown">
						<a class="dropdown-toggle" href="#" data-toggle="dropdown">Sign In <strong class="caret"></strong></a>
						<div class="dropdown-menu" style="padding: 15px; padding-bottom: 0px;">
							<form action="/usermanager/j_spring_security_check" method='POST' accept-charset="UTF-8">
								<input style="margin-bottom: 15px;" type="text" placeholder="Username" id="username" name="j_username" required>
								<input style="margin-bottom: 15px;" type="password" placeholder="Password" id="password" name="j_password" required>
								<input style="float: left; margin-right: 10px;" type="checkbox" name="_spring_security_remember_me" id="remember-me" value="1">
								<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
								<label class="string optional" for="user_remember_me"> Remember me</label>
								<input class="btn btn-primary btn-block" type="submit" id="sign-in" value="Sign In">
							</form>
						</div>
					</li>


                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>
    
	<div class="wrapper">
	    <div class="row">
	        <div class="col-sm-6 col-md-4 col-md-offset-4">
	            <div class="account-wall">
	                <img class="profile-img" src="http://cache.desktopnexus.com/thumbnails/50970-bigthumbnail.jpg"
	                    alt="">
	                <form class="form-signin" action="/usermanager/j_spring_security_check" method='POST'>
	                	<c:if test="${not empty error}">
							<div class="error">${error}</div>
						</c:if>
						<c:if test="${not empty msg}">
							<div class="msg">${msg}</div>
						</c:if>
		                <input type="email" name="j_username" class="form-control" placeholder="Email" required min="3" max="15" autofocus />
		                <input type="password" name="j_password" class="form-control" placeholder="Password" required min="6" max="20" />
		                <button class="btn btn-lg btn-primary btn-block" type="submit">
		                    Sign in</button>
		                <label class="checkbox pull-left">
		                	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		                    <input type="checkbox" name="_spring_security_remember_me" value="remember-me" />
		                    Remember me
		                </label>
		                <a href="#" class="pull-right need-help">Need help? </a><span class="clearfix"></span>
	                </form>
	            </div>
	            <a href="register" class="text-center new-account">Create an account </a>
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
</body>
</html>