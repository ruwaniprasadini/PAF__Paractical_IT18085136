<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.Hospital"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doctor Details</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/Hospital.js"></script>
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-6">

				<h1>Doctor Details</h1>
				<form id="formHospital">
					Doctor Name: <input id="DoctorName" name="DoctorName" type="text"
						placeholder="Enter your Name" class="form-control form-control-sm">
					<br> Email: <input id="Email" name="Email" type="email"
						placeholder="Enter your Email "
						class="form-control form-control-sm"> <br>
					Specialization: <input id="Specialization" name="Specialization"
						type="text" placeholder="Enter your Specialization"
						class="form-control form-control-sm"> <br>Password :

					<input id="Password" name="Password" type="text"
						placeholder="Enter your Password"
						class="form-control form-control-sm"> <br> <input
						id="btnSave" name="btnSave" type="button" value="Save"
						class="btn btn-primary"> <input type="hidden"
						id="hidDoctorIDSave" name="hidDoctorIDSave" value="">
				</form>


				<div id="alertSuccess" class="alert alert-success"></div>
				<div id="alertError" class="alert alert-danger"></div>

				<br>
				<div id="divHospitalGrid">
					<%
						Hospital hospitalobj = new Hospital();
						out.print(hospitalobj.readDoctor());
					%>
				</div>

			</div>
		</div>
	</div>


</body>
</html>