<nav class="navbar navbar-expand-lg  bg-light fs-6">
  <div class="container-fluid">
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav me-auto">
        <li class="nav-item">
          <a class="nav-link" aria-current="page" href="../index.jsp"><i class="fa-solid fa-square-h mx-1"></i> MediC</a>
        </li>
      </ul>
      <ul class="navbar-nav ms-auto">
        <li class="nav-item">
          <a class="nav-link" href="<%= application.getContextPath()%>/forms/admin_login.jsp"><i class="fa-solid fa-right-to-bracket mx-2"></i> Admin Login</a>
        </li>
        <li class="nav-item mx-2">
          <a class="nav-link" href="<%= application.getContextPath()%>/forms/user_login.jsp">User Login</a>
        </li>
      </ul>
    </div>
  </div>
</nav>