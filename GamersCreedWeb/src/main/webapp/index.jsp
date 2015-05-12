<!DOCTYPE html>
<html ng-app="gamersCreedApp">

<head>
	<title>Gamer's creed protoype</title>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="css/bootstrap/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="css/jquery-ui.css" />	
	<link href="css/style.css" rel="stylesheet" type="text/css"/>
	<!--<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>-->
	<!-- Angular-->
	<script src="js/frameWorks/angular/angular.min.js" type="text/javascript" xml:space="preserve"></script>
	<script src="js/frameWorks/angular/i18n/angular-locale_es-es.js" type="text/javascript" xml:space="preserve"></script>
	<script src="js/frameWorks/angular/ng-currency.js" type="text/javascript" xml:space="preserve"></script>
	<script src="js/frameWorks/angular/angular-file-upload.js" type="text/javascript" xml:space="preserve"></script>
	
	<!-- jQuery-->
	<script src="js/frameWorks/jQuery/jQuery.js" type="text/javascript" xml:space="preserve"></script>

	<!-- Datepicker-->
	<script src="js/frameWorks/jQuery/jquery.min.js" type = "text/javascript"></script>
	<script src="js/frameWorks/jQuery/jquery-ui.min.js" type = "text/javascript"></script>
		
	<!-- jQuery Cookies management-->
	<script src="js/frameWorks/jQuery/jquery-cookie/jquery.cookie.js" type="text/javascript" xml:space="preserve"></script>

	<!-- Other JS scripts -->			
	<script type="text/javascript" src="js/model/post.js"></script>
	<script type="text/javascript" src="js/model/user.js"></script>
	<script type="text/javascript" src="js/control/index.js"></script>
</head>

<body ng-controller="gamersCreedController as gCreedCtrl" ng-init="appAction=0">
	<header>
		<h1>Gamer's creed</h1>

		<ul>
			<li><a href="" ng-click="appAction=0">Principal</a></li>
			<li><a href="" ng-click="appAction=2">Perfil</a></li>
			<li><a href="" ng-click="appAction=3">Foro</a></li>
			<li><a href="" id="loginButton" ng-click="appAction=1">Login</a></li>
		</ul>
		
	</header>

	<div class="mainDiv contentSections">
		<wall-view ng-show="appAction==0"></wall-view>
		<login-form ng-show="appAction==1"></login-form>
		<user-modify-form ng-show="appAction==2"></user-modify-form>
		<forum-view ng-show="appAction==3"></forum-view>
		<user-entry-form ng-show="appAction==4"></user-entry-form>
	</div>	
	
	<aside class="advDiv contentSections">
		Publicidad terceros
	</aside>
	
	<footer class="contentSections">
		<p>Pie</p>
	</footer>

</body>

</html>