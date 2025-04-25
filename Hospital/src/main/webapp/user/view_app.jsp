<%@ page import="java.util.ArrayList"%>
<%@ page import="com.entities.Appointment"%>
<%@ page import="com.database.DBconnect"%>
<%@ page import="com.DAO.appDAO"%>

<jsp:include page="../links.jsp"></jsp:include>
<jsp:include page="navbar.jsp"></jsp:include>

<div class="container mt-5">
	<div class="d-flex justify-content-center">
		<table class="table table-striped table-bordered w-auto">
			<thead class="table-dark">
				<tr>
					<th>Name</th>
					<th>Email</th>
					<th>Specialization Chosen</th>
					<th>Created At</th>
				</tr>
			</thead>
			<tbody>
				<%
				appDAO dao = new appDAO(DBconnect.getConnection());
				String email = (String) session.getAttribute("userMail");
				ArrayList<Appointment> list = (ArrayList) dao.getApp(email);

				for (Appointment ap : list) {
				%>
				<tr>
					<td><%=ap.getName()%></td>
					<td><%=ap.getEmail()%></td>
					<td><%=ap.getSpecsChose()%></td>
					<td><%=ap.getDate()%></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>
</div>
