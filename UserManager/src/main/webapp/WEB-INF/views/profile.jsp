<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>${user.name} profile</title>
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
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> ${user.email} <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="/usermanager/"><i class="fa fa-fw fa-user"></i> Profile</a>
                            </li>
                            <li>
                                <a href="#"><i class="fa fa-fw fa-envelope"></i> Inbox</a>
                            </li>
                            <li>
                                <a href="#"><i class="fa fa-fw fa-gear"></i> Settings</a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="logout"><i class="fa fa-fw fa-power-off"></i> Log Out</a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>
    
	<div class="wrapper">
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>
      <div class="row">
      <div class="col-md-5  toppad  pull-right col-md-offset-3 ">
           <A data-toggle="modal" href="#editProfile" class="btn btn-primary">Edit Profile</A>

        <A href="logout" class="btn btn-primary">Logout</A>
       <br>
<p class=" text-info">${serverTime}</p>
      </div>
        <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >
   
   
          <div class="panel panel-info">
            <div class="panel-heading">
              <h3 class="panel-title">${user.name}</h3>
            </div>
            <div class="panel-body">
              <div class="row">
                <div class="col-md-3 col-lg-3 " align="center"> 
                	<c:if test="${not empty user.avatar}">
							<img alt="User Pic" src="${user.avata}" class="img-circle"> 
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
                     
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
                 <div class="panel-footer">
                 	<form action="delete" method="POST">
                 		<input type="hidden" class="form-control" name="id" value="${user.id}" />
                        <a data-original-title="Broadcast Message" data-toggle="tooltip" type="button" class="btn btn-sm btn-primary"><i class="glyphicon glyphicon-envelope"></i></a>
                        <span class="pull-right">
                            <button data-toggle="modal" href="#editProfile" data-original-title="Edit this user" data-toggle="tooltip" type="button" class="btn btn-sm btn-warning"><i class="glyphicon glyphicon-edit"></i></button>
                            <button data-original-title="Remove this user" data-toggle="tooltip" type="submit" class="btn btn-sm btn-danger"><i class="glyphicon glyphicon-remove"></i></button>
                        </span>
                    </form>
                 </div>
            
          </div>
        </div>
      </div>
    </div>

<div class="modal" id="editProfile">
<form action="#" method="POST">
	<div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h3 class="modal-title">Profile edit</h3>
          <p class=" text-info">${serverTime}</p>
        </div>
        <div class="modal-body">
          
                  <table class="table table-user-information">
                    <tbody>
                    	<input type="hidden" class="form-control" name="id" value="${user.id}" />
                      <tr>
                        <td>Email:</td>
                        <td><input type="text" class="form-control" name="email" value="${user.email}${user.id}" /></td>
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
        	<a href="/usermanager/" class="btn btn-primary"> exit </a>
        	<button type="submit" class="btn btn-primary">Save</button>
        	
        </div>
      </div>
      </form>
    </div>
    
    
	<!-- jQuery Version 1.11.0 -->
    <script src="/baylennao/js/jquery-1.11.0.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/baylennao/js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
    <script src="/baylennao/js/classie.js"></script>
    <script src="/baylennao/js/cbpAnimatedHeader.js"></script>
    <script>
    $(document).ready(function() {
        var panels = $('.user-infos');
        var panelsButton = $('.dropdown-user');
        panels.hide();

        //Click dropdown
        panelsButton.click(function() {
            //get data-for attribute
            var dataFor = $(this).attr('data-for');
            var idFor = $(dataFor);

            //current button
            var currentButton = $(this);
            idFor.slideToggle(400, function() {
                //Completed slidetoggle
                if(idFor.is(':visible'))
                {
                    currentButton.html('<i class="glyphicon glyphicon-chevron-up text-muted"></i>');
                }
                else
                {
                    currentButton.html('<i class="glyphicon glyphicon-chevron-down text-muted"></i>');
                }
            })
        });


        $('[data-toggle="tooltip"]').tooltip();
    });
	</script> 
</body>
</html>