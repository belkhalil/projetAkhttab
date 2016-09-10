<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestion Compliance</title>
<link rel="stylesheet" href="bootstrap-3.3.6-dist/css/bootstrap.min.css">
</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top topnav"
		role="navigation">
	<div class="container topnav">

		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
			<a class="navbar-brand topnav" href="#">Ask For Satisfaction</a>
		</div>

		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right">
				<li><a class="navbar-brand topnav" href="landigPage.html">Home</a>
				</li>
			</ul>
		</div>
	</div>

	</nav>
	<div class="generic-container">
		<div class="panel panel-default">
			<div class="panel-heading col-lg-12">
				<span class="lead">Ask For Satisfaction </span>
			</div>
			<!-- <div class="formcontainer col-lg-6"> -->
			<br>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-1 control-lable" for=""></label>
					<div class="col-md-7">
						<div class="panel-title">
							<span class="lead">Healthcare Provider </span>
						</div>
					</div>
				</div>
			</div>
			<form name="myForm" class="form-horizontal"
				action="ServeletController" method="post">

				<input type="hidden" />
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-2 control-lable" for=""></label>
						<div class="col-md-7">
							<input type="text" name="nom" id=" "
								class="form-control input-sm" placeholder="Nom" />
						</div>
					</div>
				</div>

				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-2 control-lable" for=""></label>
						<div class="col-md-7">
							<input type="text" name="location" id=" "
								class="form-control input-sm" placeholder="location" />
						</div>
					</div>
				</div>

				<div class="row">
					<div class="form-group col-md-12">
						<div class="col-md-2 control-lable"></div>
						<div class="col-md-7">
							<textarea placeholder="insert your privacy policy here"
								name="privacyP" id="nom" class="form-control input-sm"
								placeholder="privacy policy"></textarea>
						</div>
					</div>
				</div>

				<!-- </div> -->

				<br>

				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-1 control-lable" for=""></label>
						<div class="col-md-7">
							<div class="panel-title">
								<span class="lead">patient </span>
							</div>
						</div>
					</div>
				</div>

				<input type="hidden" />
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-2 control-lable" for=""></label>
						<div class="col-md-7">
							<input type="text" id=" " name="nomPatient"
								class="form-control input-sm" placeholder="Name of Patient" />
						</div>
					</div>
				</div>

				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-2 control-lable" for=""></label>
						<div class="col-md-7">
							<input type="text" id=" " name="pays"
								class="form-control input-sm" placeholder="Pays" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-2 control-lable" for=""></label>
						<div class="col-md-7">
							<input type="text" id=" " name="locationP"
								class="form-control input-sm" placeholder="Location" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-2 control-lable" for=""></label>
						<div class="col-md-7">
							<!-- <input type="text" id=" " placeholder="Privacy Group"/> -->
							<select name="privacyGroup" class="form-control input-sm">
								<option value="fundamentalist">fundamentalist</option>
								<option value="pragmatic">pragmatic</option>
								<option value="unconcerned">unconcerned</option>
								<option value="should-be-protected">should-be-protected</option>
							</select>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="form-group col-md-12">
						<div class="col-md-2 control-lable"></div>
						<div class="col-md-7">
							<textarea placeholder="insert your user preference here" id=" "
								name="userPreference" class="form-control input-sm"></textarea>
						</div>
					</div>
				</div>


				<div class="panel-footer col-lg-12">
					<div class="row">
						<div class="form-group col-md-12">
							<div class="col-md-5 control-lable"></div>
							<div class="col-md-7">
								<!-- <input type="button" ng-click="ctrl.update()" value="update" class="btn btn-primary btn-sm" > -->
								<input type="submit" name="btn" value="Validate"
									class="btn btn-primary btnddlg">
								<button type="submit" onclick="" class="btn btn-warning btnddlg">Cancel</button>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>


</body>
</html>