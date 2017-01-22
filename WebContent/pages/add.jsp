<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring-ext"
	uri="http://www.metazoneinfotech.spring-ext/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Student Marks</title>

<link rel="stylesheet" type="text/css"
	href="resources/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="resources/css/pagesCss/add.css" />


<script src="resources/js/jquery.min.js"></script>
<script src="resources/js/pageJs/custom.js"></script>

</head>

<body>
	<div class="main">
		<div class="container">
			<div class="row navigationRow ">
				<div class="col-sm-offset-6 navigation pull-right">
					<ul class="nav nav-pills">
						<li class="active btn-lg"><a href="home"><span
								class="glyphicon glyphicon-plus"></span> Add</a></li>
						<li class="btn-lg"><a href="search"><span
								class="glyphicon glyphicon-search"></span> Search</a></li>
						<li class="btn-lg"><a href="view"><span
								class="glyphicon glyphicon-eye-open"></span> View</a></li>
						<li class="btn-lg"><a href="logout"><span
								class="glyphicon glyphicon-log-out"></span> Logout</a></li>
					</ul>
				</div>
			</div>
		</div>

		<div class="container">
			<div class="row studentForm">
				<form class="form-horizontal" action="addAction" method="post"
					enctype="multipart/form-data">
					<div class="col-sm-offset-1 col-sm-4 imageDiv">
						<div class="row">
							<img id="blah" src="resources/images/avator.jpg" height="150px"
								width="150px" />
						</div>
						<div class="row">
							<span class="btn btn-default btn-file glyphicon glyphicon-upload">
								UPLOAD <input type="file" id="imgInp" name="file">
							</span>
						</div>
						<h6 class="status">${imageStatus}</h6>
						<span class="errorMessage"><spring-ext:errors
								path="student.file" firstErrorOnly="true" /></span>
					</div>

					<div class="col-sm-6">

						<div class="form-group">
							<label class="col-sm-3 control-label">Name</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" name="name"
									placeholder="Name" autofocus="autofocus"> <span
									class="errorMessage"><spring-ext:errors
										path="student.name" firstErrorOnly="true" /></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">Roll No.</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" name="rollNumber"
									placeholder="Roll Number"> <span class="errorMessage"><spring-ext:errors
										path="student.rollNumber" firstErrorOnly="true" /></span> <span
									class="errorMessage">${exception}</span>
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-3 control-label">Physics Marks</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" name="physicsMarks"
									placeholder="Physics Marks"> <span class="errorMessage"><spring-ext:errors
										path="student.physicsMarks" firstErrorOnly="true" /></span>
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-3 control-label">Chemistry Marks</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" name="chemistryMarks"
									placeholder="Chemistry Marks"> <span
									class="errorMessage"><spring-ext:errors
										path="student.chemistryMarks" firstErrorOnly="true" /></span>
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-3 control-label">Maths Marks</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" name="mathsMarks"
									placeholder="Maths Marks"> <span class="errorMessage"><spring-ext:errors
										path="student.mathsMarks" firstErrorOnly="true" /></span>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-3	 col-sm-2">
								<button type="submit" class="btn btn-default">
									<span class="glyphicon glyphicon-plus"></span> Add
								</button>

							</div>
							<h4 class="status">${status }</h4>
						</div>
				</form>
			</div>
		</div>

	<div class="container">
		<div class="row footer">2016 © ADD STUDENT MARKS DETAILS</div>
	</div>

</div>

</body>
</html>