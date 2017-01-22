<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring-ext"
	uri="http://www.metazoneinfotech.spring-ext/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index Login</title>


<link rel="stylesheet" type="text/css"
	href="resources/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="resources/css/pagesCss/index.css" />

<script src="resources/js/jquery.min.js"></script>
<script src="resources/js/pageJs/custom.js"></script>

</head>

<body>
	<div class="main">
		<div class="container">
			<div class="row loginRow">
				<div class="col-sm-6 imgRow">
					<img src="resources/images/lock.png" height="400px" width="400px" />
				</div>


				<div class="col-sm-6 authenticate">
					<form class="form-horizontal" action="loginAction" method="post">
						<div class="form-group">
							<label class="col-sm-2 control-label">Username</label>
							<div class="col-sm-10">
								<input type="email" class="form-control" name="username"
									placeholder="UserName" value="aman157_saini@yahoo.com"
									autofocus="autofocus"> <span class="errorMessage"><spring-ext:errors
										path="login.username" firstErrorOnly="true" /></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">Password</label>
							<div class="col-sm-10">
								<input type="password" class="form-control" name="password"
									value="admin" placeholder="Password"> <span
									class="errorMessage"><spring-ext:errors
										path="login.password" firstErrorOnly="true" /></span>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="submit" class="btn btn-default">
									<span class="glyphicon glyphicon-log-in"></span> LOGIN
								</button>
							</div>
						</div>
					</form>
				</div>

			</div>
		</div>
	</div>

</body>
</html>

