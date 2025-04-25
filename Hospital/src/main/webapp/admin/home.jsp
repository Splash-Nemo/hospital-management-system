<%@ page import="java.util.ArrayList" %>
<%@ page import="com.entities.Doctor" %>
<%@ page import="com.DAO.appDAO" %>
<%@ page import="com.entities.Appointment" %>
<%@ page import="com.entities.User" %>
<style>

.card {
	height: 350px;
	overflow: hidden;
}

.card-img-top {
	height: 80%;
	object-fit: cover;
}
</style>

<jsp:include page="../links.jsp"></jsp:include>

<div>
	<h3 class="fw-bold text-center m-5">Admin DashBoard</h3>
</div>

<div class="row row-cols-1 row-cols-md-3 g-4 mx-5 mb-5">
	<div class="col">
		<div class="card h-70">
			<img src="<%=application.getContextPath()%>/images/doctor-icon.jpg"
				class="card-img-top border-bottom"
				alt="<%=application.getContextPath()%>/images/user.jpg">
			<div class="card-body">
				<a href="<%= application.getContextPath() %>/doctorRegister"><h5 class="card-title">Doctors</h5></a>
				<p class="card-text">
					<%
						ArrayList<Doctor> list = (ArrayList<Doctor>) session.getAttribute("docList");
						%>
							<%=list.size() %>
						<%
					%>
				</p>
			</div>
		</div>
	</div>
	<div class="col">
		<div class="card h-70">
			<img src="<%=application.getContextPath()%>/images/user.jpg"
				class="card-img-top border-bottom"
				alt="<%=application.getContextPath()%>/images/user.jpg">
			<div class="card-body">
				<a href="<%=application.getContextPath()%>/admin/patients.jsp"><h5 class="card-title">Patient</h5></a>
				<p class="card-text">
					<%
						ArrayList<User> userList = (ArrayList<User>) session.getAttribute("userList");
						%>
							<%=userList.size() %>
						<%
					%>
				</p>
			</div>
		</div>
	</div>
	<div class="col">
		<div class="card h-70">
			<img src="<%=application.getContextPath()%>/images/appointments.jpg"
				class="card-img-top border-bottom"
				alt="<%=application.getContextPath()%>/images/user.jpg">
			<div class="card-body">
				<a href="<%=application.getContextPath()%>/admin/appointments.jsp"><h5 class="card-title">View Appointments</h5></a>
				<p class="card-text">
					<%
						ArrayList<Appointment> appList = (ArrayList<Appointment>) session.getAttribute("appList");
						%>
							<%=appList.size() %>
						<%
					%>
				</p>
			</div>
		</div>
	</div>
</div>
