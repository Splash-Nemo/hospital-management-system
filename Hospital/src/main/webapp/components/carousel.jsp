<style>
.carousel-item img {
	height: 500px;
	object-fit: cover;
	filter: blur(5px) brightness(70%);
}

.carousel-caption h5 {
	text-decoration: underline;
	text-decoration-color: red;
	text-decoration-thickness: 3px;
	text-underline-offset: 5px;
}
</style>

<div id="carouselExampleCaptions" class="carousel slide"
	data-bs-ride="carousel">
	<div class="carousel-indicators">
		<button type="button" data-bs-target="#carouselExampleCaptions"
			data-bs-slide-to="0" class="active" aria-current="true"
			aria-label="Slide 1"></button>
		<button type="button" data-bs-target="#carouselExampleCaptions"
			data-bs-slide-to="1" aria-label="Slide 2"></button>
		<button type="button" data-bs-target="#carouselExampleCaptions"
			data-bs-slide-to="2" aria-label="Slide 3"></button>
	</div>
	<div class="carousel-inner">
		<div class="carousel-item active">
			<img src="<%=application.getContextPath()%>/images/img-5.jpg"
				class="d-block w-100" alt="...">
			<div class="carousel-caption d-none d-md-block text-start">
				<h5 class="fs-3 fw-bolder my-3">Revolutionizing Cancer
					Treatment: CAR T Cell Therapy</h5>
				<p>CAR T cell therapy has demonstrated remarkable success,
					particularly in treating certain types of blood cancers. Clinical
					trials have shown unprecedented response rates in patients with
					leukemia and lymphoma, leading to some individuals achieving
					complete remission. The results have been so promising that CAR T
					cell therapy has received approval for the treatment of specific
					types of leukemia and lymphoma by regulatory agencies such as the
					U.S. Food and Drug Administration (FDA).</p>
			</div>
		</div>
		<div class="carousel-item text-start">
			<img src="<%=application.getContextPath()%>/images/img-3.jpg"
				class="d-block w-100" alt="...">
			<div class="carousel-caption d-none d-md-block text-start">
				<h5 class="fs-3 fw-bolder my-3">Revolutionizing Cancer
					Treatment: CAR T Cell Therapy</h5>
				<p>CAR T cell therapy has demonstrated remarkable success,
					particularly in treating certain types of blood cancers. Clinical
					trials have shown unprecedented response rates in patients with
					leukemia and lymphoma, leading to some individuals achieving
					complete remission. The results have been so promising that CAR T
					cell therapy has received approval for the treatment of specific
					types of leukemia and lymphoma by regulatory agencies such as the
					U.S. Food and Drug Administration (FDA).</p>
			</div>
		</div>
		<div class="carousel-item text-start">
			<img src="<%=application.getContextPath()%>/images/img-4.jpg"
				class="d-block w-100" alt="...">
			<div class="carousel-caption d-none d-md-block text-start">
				<h5 class="fs-3 fw-bolder my-3">Revolutionizing Cancer
					Treatment: CAR T Cell Therapy</h5>
				<p>CAR T cell therapy has demonstrated remarkable success,
					particularly in treating certain types of blood cancers. Clinical
					trials have shown unprecedented response rates in patients with
					leukemia and lymphoma, leading to some individuals achieving
					complete remission. The results have been so promising that CAR T
					cell therapy has received approval for the treatment of specific
					types of leukemia and lymphoma by regulatory agencies such as the
					U.S. Food and Drug Administration (FDA).</p>
			</div>
		</div>
	</div>
	<button class="carousel-control-prev" type="button"
		data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
		<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
			class="visually-hidden">Previous</span>
	</button>
	<button class="carousel-control-next" type="button"
		data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
		<span class="carousel-control-next-icon" aria-hidden="true"></span> <span
			class="visually-hidden">Next</span>
	</button>
</div>
