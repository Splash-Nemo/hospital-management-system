<%@ page import="java.util.ArrayList"%>
<%@ page import="com.entities.Doctor"%>
<%@ page import="com.database.DBconnect"%>
<%@ page import="com.DAO.DoctorDAO"%>
<jsp:include page="../links.jsp"></jsp:include>
<jsp:include page="navbar.jsp"></jsp:include>

<div class="container mt-5">
	<div class="card shadow-sm">
		<div class="card-header text-center">
			<h4>Set Appointment</h4>
		</div>
		<div class="card-body">
			<form action="<%=application.getContextPath()%>/setApp" method="post">
				<div class="row mb-3">
					<div class="col-md-6">
						<label class="form-label">Full Name</label> <input type="text"
							name="name" class="form-control" required>
					</div>
					<div class="col-md-6">
						<label class="form-label">Email</label> <input type="email"
							name="email" class="form-control" required>
					</div>
				</div>

				<div class="row mb-3">
					<div class="col-md-6">
						<label class="form-label">Date of Birth</label> <input type="date"
							name="dob" class="form-control" required>
					</div>
					<div class="col-md-6">
						<label class="form-label">Gender</label> <select name="gender"
							class="form-select" required>
							<option selected disabled>-- Select Gender --</option>
							<option>Male</option>
							<option>Female</option>
							<option>Other</option>
						</select>
					</div>
				</div>

				<div class="mb-3">
					<label class="form-label">Specialist</label> <select
						name="specialist" class="form-select" required>
						<option selected disabled>-- Select Specialist --</option>
						<%
            	DoctorDAO dao = new DoctorDAO(DBconnect.getConnection());
            	ArrayList<Doctor> list= dao.getAll();
            	
            	for(Doctor doc: list){
            		%>
						<option value="<%=doc.getName()%> (<%=doc.getSpecs()%>)">
							<%=doc.getName()%> (<%=doc.getSpecs()%>)
						</option>

						<%
            	}
            %>
					</select>
				</div>

				<div class="mb-3">
					<label class="form-label">Address</label>
					<textarea name="address" class="form-control" rows="3" required></textarea>
				</div>

				<div class="mb-3">
					<label class="form-label">Phone Number</label> <input type="tel"
						name="phone" class="form-control" required pattern="[0-9]{10}">
				</div>

				<div class="text-center">
					<button type="submit" class="btn btn-primary">Add Appointment</button>
				</div>
			</form>
			
			<%
				String msg= (String) session.getAttribute("succ-msg");
				if(msg!=null){
				%>
				<p class="text-center"><%=msg %></p>
				<%
				}
				msg= null;
			%>
		</div>
	</div>
</div>