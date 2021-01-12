<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

  
 <%@include file="../resources/header.jsp" %>
	<div class="container col-md-8 col-md-offset-3" style="overflow: auto">
		<h1>Register Form</h1>
		<form action="<%=request.getContextPath()%>/register" method="post">

			<div class="form-group">
				<label for="uname">Full name</label> <input type="text"
					class="form-control" id="fullname" placeholder="Enter your full name"
					name="fullname" required>
			</div>
			
			<div class="form-group">
				<label for="uname">Username</label> <input type="text"
					class="form-control" id="username" placeholder="Enter your username"
					name="username" required>
			</div>
			

			<div class="form-group">
				<label for="uname">Password</label> <input type="password"
					class="form-control" id="password" placeholder="Enter your password"
					name="password" required>
			</div>
			
			<div class="form-group">
				<label for="uname">Password"</label> <input type="password"
					class="form-control" id="passwordconfirm" placeholder="Confirm your password"
					name="passwordconfirm" required>
			</div>
			
			<div class="form-group">
				<label for="uname">Email</label> <input type="text"
					class="form-control" id="email" placeholder="Enter your email"
					name="email" required>
			</div>
			
			<div class="form-group">
				<label for="uname">Phone number</label> <input type="text"
					class="form-control" id="email" placeholder="Enter your phone number"
					name="contactno" required>
			</div>


			<button type="submit" class="btn btn-primary">Register</button>
		</form>
	</div>
 <%@include file="../resources/footer.jsp" %>
</body>
</body>
</html>