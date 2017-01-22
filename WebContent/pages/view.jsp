<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Student Details</title>

<script src="resources/js/jquery.min.js"></script>

<link rel="stylesheet" href="resources/css/bootstrap.css">
<link rel="stylesheet" href="resources/css/theme.bootstrap_2.css">
<script src="resources/js/jquery.tablesorter.js"></script>
<script src="resources/js/jquery.tablesorter.widgets.js"></script>


<link rel="stylesheet" href="resources/css/jquery.tablesorter.pager.css">
<script src="resources/js/jquery.tablesorter.pager.js"></script>
<script src="resources/js/sorterScript.js"></script>

<link rel="stylesheet" type="text/css"
	href="resources/css/pagesCss/add.css" />
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
						<li class="btn-lg"><a href="search"><span
								class="glyphicon glyphicon-search"></span> Search</a></li>
						<li class="active  btn-lg"><a href="view"><span
								class="glyphicon glyphicon-eye-open"></span> View</a></li>
						<li class="btn-lg"><a href="logout"><span
								class="glyphicon glyphicon-log-out"></span> Logout</a></li>
					</ul>
				</div>
			</div>
		</div>
		
		
		<div class="container">
			<div class="row">
			<H1 class="deleteStatus"><span class="glyphicon glyphicon-ok"></span>Row Deleted</h1>
			</div>
			
		</div>

		<div class="container">
			<div class="row studentForm">
				<table class="sorted-table">
					<!-- bootstrap classes added by the uitheme widget -->
					<thead>
						<tr>
							<th>Roll No.</th>
							<th>Name</th>
							<th>Physics Marks</th>
							<th>Chemistry Marks</th>
							<th>Maths Marks</th>
							<th>Student Pic</th>
							<th>Change Image</th>
							<th>Edit</th>
							<th>Delete</th>
					</thead>
					<tfoot>
						<tr>
							<th>Roll No.</th>
							<th>Name</th>
							<th>Physics Marks</th>
							<th>Chemistry Marks</th>
							<th>Maths Marks</th>
							<th>Student Pic</th>
							<th>Change Image</th>
							<th>Edit</th>
							<th>Delete</th>
						</tr>
						<tr>
							<th colspan="7" class="ts-pager form-horizontal">
								<button type="button" class="btn first">
									<i class="icon-step-backward glyphicon glyphicon-step-backward"></i>
								</button>
								<button type="button" class="btn prev">
									<i class="icon-arrow-left glyphicon glyphicon-backward"></i>
								</button> <span class="pagedisplay"></span> <!-- this can be any element, including an input -->
								<button type="button" class="btn next">
									<i class="icon-arrow-right glyphicon glyphicon-forward"></i>
								</button>
								<button type="button" class="btn last">
									<i class="icon-step-forward glyphicon glyphicon-step-forward"></i>
								</button> <select class="pagesize input-mini" title="Select page size">
									<option selected="selected" value="10">10</option>
									<option value="20">20</option>
									<option value="30">30</option>
									<option value="40">40</option>
							</select> <select class="pagenum input-mini" title="Select page number"></select>
							</th>
						</tr>
					</tfoot>
					<tbody>
						<c:forEach var="details" items="${listofStudent}"
							varStatus="status">
							<tr>
								<td><textarea rows="1" cols="5" id="rollNumber" class="editTextField rollNumber form-control" readonly="readonly">${details.rollNumber}</textarea></td>
									
								<td><textarea rows="1" cols="15" id="name" class="editTextField name form-control" readonly="readonly">${details.name}</textarea><span class="nameErr"></span></td>
									
								<td><textarea rows="1" cols="5" id="physicsMarks" class="editTextField physicsMarks form-control" readonly="readonly">${details.physicsMarks}</textarea><span
									class="physicsMarksErr"></span></td>
									
								<td><textarea rows="1" cols="5" id="chemistryMarks" class="editTextField chemistryMarks form-control" readonly="readonly">${details.chemistryMarks}</textarea><span
									class="chemistryMarksErr"></span></td>	
								
								<td><textarea rows="1" cols="5" id="mathsMarks" class="editTextField mathsMarks form-control" readonly="readonly">${details.mathsMarks}</textarea><span
									class="mathsMarksErr"></span></td>

								<td><img id="previewImage"
									src="resources/images/userPic/${details.rollNumber}.jpg"
									height="100px" width="100px"></td>

								<td><span
									class="uploadSpanImage btn btn-primary btn-file glyphicon glyphicon-upload">
										UPLOAD <input type="file" class="upload btn btn-primary"
										id="updateViewImage" name="userPic">
								</span><span class="uploadPicErr"></span></td>

								<td><button type="Submit" id="${details.rollNumber}"
										class="edit btn btn-primary" value="Edit">
										<span class="editGlyp glyphicon glyphicon-edit"></span> EDIT
									</button><span class="savingStatus"></span></td>
								<td><button type="Submit" class="delete btn btn-primary">
										<span class="glyphicon glyphicon-trash" value="Delete"></span>
										DELETE
									</button></td>

							</tr>
						</c:forEach>

					</tbody>
				</table>


			</div>
		</div>

		<div class="container">
			<div class="row footer">2016 © VIEW STUDENT MARKS DETAILS</div>
		</div>
	</div>




</body>
</html>