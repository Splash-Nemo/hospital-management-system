<%@ page import="java.util.ArrayList" %>
<%@ page import="com.entities.Doctor" %>
<%@ page import="com.DAO.appDAO" %>
<%@ page import="com.entities.Appointment" %>
<%@ page import="com.entities.User" %>
<%@ page import="com.database.DBconnect" %>

<jsp:include page="../links.jsp"></jsp:include>
<jsp:include page="navbar.jsp"></jsp:include>

<div class="container mt-5">
	<div class="d-flex justify-content-center">
		<table class="table table-striped table-bordered w-auto">
			<thead class="table-dark">
				<tr>
					<th>User ID</th>
					<th>Name</th>
					<th>Email</th>
				</tr>
			</thead>
			<tbody>
				<%
					ArrayList<User> userList = (ArrayList<User>) session.getAttribute("userList");
					
					for(User ap: userList){
				%>
					<tr>
						<td><%=ap.getID()%></td>
						<td><%=ap.getName()%></td>
						<td><%=ap.getMail()%></td>
					</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</div>
</div>
