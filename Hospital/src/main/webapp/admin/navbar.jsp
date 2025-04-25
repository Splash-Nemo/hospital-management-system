<jsp:include page="../links.jsp"></jsp:include>
<nav class="navbar navbar-expand-lg  bg-light fs-6 px-3">
	<div class="container-fluid">
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav me-auto">
				<li class="nav-item"><i class="fa-solid fa-square-h mx-1"></i>
						MediC</li>
			</ul>
			<ul class="navbar-nav ms-auto">
				<li class="nav-item"><a class="nav-link"
					href="<%=application.getContextPath() %>/admin/index.jsp">Home</a></li>
				<li class="nav-item mx-2"><a class="nav-link"
					href="<%=application.getContextPath() %>/admin/doctors.jsp">Doctor</a></li>
				<li class="nav-item mx-2"><a class="nav-link"
					href="<%=application.getContextPath() %>/admin/patients.jsp">Patient</a></li>
			</ul>
		</div>
	</div>

	<div class="dropdown">
		<button class="btn btn-secondary dropdown-toggle" type="button"
			data-bs-toggle="dropdown" aria-expanded="false">${adminObj.getMail()}</button>
		<ul class="dropdown-menu">
			<li><a class="dropdown-item" href="#">${adminObj.getName() }</a></li>
			<li><a class="dropdown-item" href="<%= application.getContextPath() %>
			/adminLogout">Logout</a></li>
		</ul>
	</div>
</nav>