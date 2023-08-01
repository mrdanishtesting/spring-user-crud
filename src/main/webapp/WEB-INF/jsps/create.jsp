
<%@include file="/bootstrap/header.jsp"%>

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Registration Form</title>
</head>
<body>
    <h1>User Registration</h1>
    <form action="#" th:action="@{/save}" th:object="${user}" method="post">
        <label>Email:</label>
        <input type="email" th:field="*{email}" required><br>
        
        <label>Password:</label>
        <input type="password" th:field="*{password}" required><br>
        
        <label>Confirm Password:</label>
        <input type="password" th:field="*{confirmPassword}" required><br>
        
        <label>Date of Birth:</label>
        <input type="date" th:field="*{dateOfBirth}" required><br>
        
        <label>Country:</label>
        <select th:field="*{country}" required>
            <option value="">Select Country</option>
            <option value="USA">United States</option>
            <option value="UK">United Kingdom</option>
            <option value="Canada">Canada</option>
            <!-- Add more options here -->
        </select><br>
        
        <input type="submit" value="Register">
    </form>
</body>
</html>













<!-- <body> -->

<!-- 	<div class="container"> -->
<!-- 		<div class="row"> -->
<!-- 			<div class="col-md-4 offset-md-3"> -->
<!-- 				<form action="save" method="post"> -->
<!-- 					<h2 class="text-center">Register</h2> -->
<!-- 					<div class="row"> -->
<!-- 						<label for="email" class="form-label">email</label> -->
<!-- 						<div class="mb-3"> -->
<!-- 							<input type="email" name="email" class="form-control" -->
<!-- 								placeholder="enter email"> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div> -->
<!-- 						<label for="password" class="form-label">password</label> -->
<!-- 						<div class="mb-3"> -->
<!-- 							<input type="password" name="password" class="form-control" -->
<!-- 								placeholder="enter password"> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div> -->

<!-- 						<label for="confirmPassword" class="form-label">confirmPassword</label> -->
<!-- 						<div class="mb-3"> -->
<!-- 							<input type="text" name="confirmPassword" class="form-control" -->
<!-- 								placeholder="re enter your pasword"> -->
<!-- 						</div> -->

<!-- 					</div> -->
<!-- 					<div> -->
<!-- 						<label for="dateOfBirth" class="form-label">DateOfBirth</label> -->
<!-- 						<div class="mb-3"> -->
<!-- 							<input type="text" name="dateOfBirth" class="form-control" -->
<!-- 								placeholder="enter Date Of Birth"> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div> -->

<!-- 						<label for="country" class="form-label">country</label> -->
<!-- 						<div class="mb-3"> -->
<!-- 							<input type="text" name="country" class="form-control" -->
<!-- 								placeholder="enter country"> -->
<!-- 						</div> -->
<!-- 					</div> -->


<!-- 					<div> -->
<!-- 						<input type="submit" value="save" class="btn btn-primary"> -->

<!-- 					</div> -->
<!-- 				</form> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</div> -->


<!-- </body> -->
</html>