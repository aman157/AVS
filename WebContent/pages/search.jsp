<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring-ext"
	uri="http://www.metazoneinfotech.spring-ext/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Student Details</title>

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
						<li class="btn-lg"><a href="home"><span
								class="glyphicon glyphicon-plus"></span> Add</a></li>
						<li class="active btn-lg"><a href="search"><span
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
				<form:errors path="student.*" cssStyle="color:red;" />

				<div class="col-sm-4">
					<img class="searchImage" src="resources/images/search.png"
						height="300px" width="300px" />
				</div>

				<div class=" col-sm-8">
					<form class="form-horizontal" action="searchAction">
						<div class="form-group">
							<label class="col-sm-3 control-label">Name </label>
							<div class="col-sm-9">
								<input type="text" class="form-control" name="name"
									placeholder="Name" autofocus="autofocus"> <span
									class="errorMessage"><spring-ext:errors
										path="student.name" firstErrorOnly="true" /></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">Roll No. </label>
							<div class="col-sm-9">
								<input type="text" class="form-control" name="rollNumber"
									placeholder="Roll Number"> <span class="errorMessage"><spring-ext:errors
										path="student.rollNumber" firstErrorOnly="true" /></span>
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-3 control-label">Physics Marks</label>
							<div class="col-sm-3">
								<input type="text" class="form-control" name="physicsMarks"
									placeholder="Physics Marks"> <span class="errorMessage"><spring-ext:errors
										path="student.physicsMarks" firstErrorOnly="true" /></span>
							</div>

							<div class="col-sm-3">
								<select id="physicsDrp" class="form-control"
									name="physicsOperator">
									<option value="<"><</option>
									<option value=">">></option>
									<option value="<="><=</option>
									<option value=">=">>=</option>
									<option value="=">==</option>
									<option value="between">between</option>
								</select>
							</div>

							<div class="col-sm-3">
								<input type="text" id="physicsBtw" class=" form-control"
									name="physicsMarks2" placeholder="value"> <span
									class="errorMessage"><spring-ext:errors
										path="student.physicsMarks2" firstErrorOnly="true" /></span>
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-3 control-label">Chemistry Marks </label>
							<div class="col-sm-3">
								<input type="text" class="form-control" name="chemistryMarks"
									placeholder="Chemistry Marks"> <span
									class="errorMessage"><spring-ext:errors
										path="student.chemistryMarks" firstErrorOnly="true" /></span>
							</div>

							<div class="col-sm-3">
								<select id="chemistryDrp" class="form-control"
									name="chemistryOperator">
									<option value="<"><</option>
									<option value=">">></option>
									<option value="<="><=</option>
									<option value=">=">>=</option>
									<option value="=">==</option>
									<option value="between">between</option>
								</select>
							</div>

							<div class="col-sm-3">
								<input type="text" id="chemistryBtw" class="form-control"
									name="chemistryMarks2" placeholder="Value"> <span
									class="errorMessage"><spring-ext:errors
										path="student.chemistryMarks2" firstErrorOnly="true" /></span>
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-3 control-label">Maths Marks </label>
							<div class="col-sm-3">
								<input type="text" class="form-control" name="mathsMarks"
									placeholder="Maths Marks"> <span class="errorMessage"><spring-ext:errors
										path="student.mathsMarks" firstErrorOnly="true" /></span>
							</div>

							<div class="col-sm-3">
								<select id="mathsDrp" class="form-control" name="mathsOperator">
									<option value="<"><</option>
									<option value=">">></option>
									<option value="<="><=</option>
									<option value=">=">>=</option>
									<option value="=">==</option>
									<option value="between">between</option>
								</select>
							</div>

							<div class="col-sm-3">
								<input type="text" id="mathsBtw" class="form-control"
									name="mathMarks2" placeholder="Value"> <span
									class="errorMessage"><spring-ext:errors
										path="student.mathMarks2" firstErrorOnly="true" /></span>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-3	 col-sm-10">
								<button type="submit" class="btn btn-default">
									<span class="glyphicon glyphicon-search"></span> Search
								</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>

		<div class="container">
			<div class="row footer">2016 © SEARCH STUDENT MARKS DETAILS</div>
		</div>

	</div>


</body>
</html>
