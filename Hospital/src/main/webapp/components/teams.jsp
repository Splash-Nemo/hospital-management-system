<style>
div h3 {
	text-decoration: underline;
	text-decoration-color: red;
	text-decoration-thickness: 3px;
	text-underline-offset: 5px;
}
</style>

<div>
	<h3 class="fw-bold text-center m-5">Our Team</h3>
</div>

<div class="row row-cols-1 row-cols-md-3 g-4 mx-5 mb-5">
	<div class="col">
		<div class="card h-100">
			<img src="<%=application.getContextPath()%>/images/user.jpg"
				class="card-img-top border-bottom"
				alt="<%=application.getContextPath()%>/images/user.jpg">
			<div class="card-body">
				<h5 class="card-title">Team Member-1</h5>
				<p class="card-text">(Specialization)</p>
			</div>
		</div>
	</div>
	<div class="col">
		<div class="card h-100">
			<img src="<%=application.getContextPath()%>/images/user.jpg"
				class="card-img-top border-bottom"
				alt="<%=application.getContextPath()%>/images/user.jpg">
			<div class="card-body">
				<h5 class="card-title">Team Member-2</h5>
				<p class="card-text">(Specialization)</p>
			</div>
		</div>
	</div>
	<div class="col">
		<div class="card h-100">
			<img src="<%=application.getContextPath()%>/images/user.jpg"
				class="card-img-top border-bottom"
				alt="<%=application.getContextPath()%>/images/user.jpg">
			<div class="card-body">
				<h5 class="card-title">Team Member-3</h5>
				<p class="card-text">(Specialization)</p>
			</div>
		</div>
	</div>
</div>
