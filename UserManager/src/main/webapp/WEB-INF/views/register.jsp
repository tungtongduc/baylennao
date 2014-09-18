<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <!--[if IE]>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <![endif]-->
    <title>Hay la 1 phan cua chung toi!</title>
    <!-- BOOTSTRAP CORE STYLE CSS -->
    <link href="/baylennao/css/bootstrap.css" rel="stylesheet" />
    <!-- FONTAWESOME STYLE CSS -->
    <link href="/baylennao/font-awesome-4.1.0/css/font-awesome.min.css" rel="stylesheet" />
     <!-- Bootstrap Core CSS -->
    <link href="/baylennao/css/custome.css" rel="stylesheet">   
    <!-- GOOGLE FONT -->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />

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
                <a class="navbar-brand page-scroll" href="/baylennao">Bay Len Nao</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="hidden">
                        <a href="#page-top"></a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#news">News</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#portfolio">Fotogallery</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>
    
    
    <div class="wrapper">
         <div class="row  pad-top">
               
                <div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                        		<strong>   Register Form </strong>  
                            </div>
                            <div class="panel-body">
                                <form role="form" action="register/add" method='POST'>
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
                                    <hr />
                                    Already Registered ?  <a href="login" >Login here</a>
                            	</form>
                            </div>
                           
                        </div>
                    </div> 
        </div>
	</div>

    <!-- JAVASCRIPT FILES PLACED AT THE BOTTOM TO REDUCE THE LOADING TIME  -->
	<!-- jQuery Version 1.11.0 -->
    <script src="/baylennao/js/jquery-1.11.0.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/baylennao/js/bootstrap.js"></script>
    
        <!-- Plugin JavaScript -->
    <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
    <script src="/baylennao/js/classie.js"></script>
    <script src="/baylennao/js/cbpAnimatedHeader.js"></script>
</body>
</html>
