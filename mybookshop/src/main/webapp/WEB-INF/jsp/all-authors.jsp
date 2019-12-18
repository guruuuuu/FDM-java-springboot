<%@ include file="layout/header.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-10">
				<c:forEach items="${authors}" var="author">
					<div class="card my-2 bg-info text-white">
						<div class="card-header">${author.name}<a href="/deleteauthor?email=${author.email}"><i class="fa fa-window-close float-right" aria-hidden="true"></i></a><a href="/editauthor?email=${author.email}"><i class="fa fa-pencil float-right mx-1" aria-hidden="true"></i></a>
						</div>
						<div class="card-body">
							<ul class="list-group text-dark">
								<li class="list-group-item">Name: ${author.email}</li>
								<li class="list-group-item">Phone Number: ${author.phone}</li>
							</ul>
						</div>
					</div>
				</c:forEach>

			</div>
		</div>
	</div>
<%@ include file="layout/footer.jsp"%>