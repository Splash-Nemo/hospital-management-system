<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.entities.Doctor" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Doctors Page</title>
<jsp:include page="../links.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<div class="container my-5">
    <div class="row">
        <div class="col-md-5">
            <div class="card mb-3">
                <div class="card-body">
                    <h5 class="card-title text-center">Add new Doctor</h5>
                    <form action="<%=application.getContextPath()%>/doctorRegister" method="post">
                        <div class="mb-3">
                            <label class="form-label">Enter Name</label>
                            <input type="text" class="form-control" name="name">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Email address</label>
                            <input type="email" name="email" class="form-control">
                            <div class="form-text">We'll never share your email with anyone else.</div>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Enter Qualification</label>
                            <input type="text" class="form-control" name="quals">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Enter Specialization</label>
                            <input type="text" class="form-control" name="specs">
                        </div>
                        <button type="submit" class="btn btn-primary">Add</button>
                    </form>
                </div>
            </div>
            <% String msg = (String) session.getAttribute("added-msg");
               if (msg != null) { %>
                <p class="text-center text-success"><%= msg %></p>
            <% session.removeAttribute("added-msg"); } %>
        </div>

        <div class="col-md-7">
            <table class="table table-striped table-bordered">
                <thead class="table-dark">
                    <tr>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Qualifications</th>
                        <th>Specialization</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        ArrayList<Doctor> list = (ArrayList<Doctor>) session.getAttribute("docList");
                        if (list != null) {
                            for (Doctor d : list) {
                    %>
                    <tr>
                        <td><%= d.getName() %></td>
                        <td><%= d.getEmail() %></td>
                        <td><%= d.getQuals() %></td>
                        <td><%= d.getSpecs() %></td>
                    </tr>
                    <% } } %>
                </tbody>
            </table>
        </div>
    </div>
</div>


</body>
</html>