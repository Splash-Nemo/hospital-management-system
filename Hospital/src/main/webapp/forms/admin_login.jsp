<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Login Page</title>
<jsp:include page="../links.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="../components/navbar.jsp"></jsp:include>
	<div class="w-100">
		<div class="card mb-3 mx-auto my-5" style="width: 840px;">
			<div class="row g-0">
				<div class="col-md-4">
					<img src="<%=application.getContextPath()%>/images/user.jpg"
						class="img-fluid h-100 rounded-start border" alt="...">
				</div>
				<div class="col-md-8 ">
					<div class="card-body">
						<h5 class="card-title text-center">Admin Login</h5>
						<form action="#" method="post">
							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Email
									address</label> <input type="email" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp">
								<div id="emailHelp" class="form-text">We'll never share
									your email with anyone else.</div>
							</div>
							<div class="mb-3">
								<label for="exampleInputPassword1" class="form-label">Password</label>
								<input type="password" class="form-control"
									id="exampleInputPassword1">
							</div>
							<button type="submit" class="btn btn-primary">Submit</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>