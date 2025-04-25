<%@ page session="true" %>
<nav class="navbar navbar-expand-lg  bg-light fs-6 px-5">
	<div class="container-fluid">
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav me-auto">
				<li class="nav-item"><a class="nav-link" aria-current="page"
					href="index.jsp"><i class="fa-solid fa-square-h mx-1"></i>
						MediC</a></li>
			</ul>
			<ul class="navbar-nav ms-auto">
				<li class="nav-item"><a class="nav-link"
					href="set_app.jsp">Set Appointment</a></li>
				<li class="nav-item mx-2"><a class="nav-link"
					href="view_app.jsp">View Appointments</a></li>
			</ul>
		</div>
	</div>

	<div class="dropdown">
		<button class="btn btn-secondary dropdown-toggle" type="button"
			data-bs-toggle="dropdown" aria-expanded="false">${userObj.getMail() }</button>
		<ul class="dropdown-menu">
			<li><a class="dropdown-item" href="#">${userObj.getName() }</a></li>
			<li><a class="dropdown-item" href="<%= application.getContextPath() %>
			/userLogout">Logout</a></li>
		</ul>
	</div>
</nav>