
<%@include file="/bootstrap/header.jsp" %>

<body>

<h2>hello world</h2>
<div class="main">
<form action="save" method="post">
<div>
<label for="email" class="form-label" >email</label>
<input type="email" name="email" class="form-control" placeholder="enter email">
</div>
<div>
<label for="password" class="form-label" >password</label>
<input type="password" name="password" class="form-control" placeholder="enter password">
</div>
<div>

<label for="confirmPassword" class="form-label" >confirmPassword</label>
<input type="text" name="confirmPassword" class="form-control" placeholder="re enter your pasword">

</div>
<div>

<label for="dateOfBirth" class="form-label" >DateOfBirth</label>
<input type="text" name="dateOfBirth" class="form-control" placeholder="enter Date Of Birth">
</div>
<div>

<label for="country" class="form-label" >country</label>
<input type="text" name="country" class="form-control" placeholder="enter country">
</div>


<div>
<input type="submit" value="save" class="btn btn-primary">

</div>
</form>





</div>

</body>
</html>