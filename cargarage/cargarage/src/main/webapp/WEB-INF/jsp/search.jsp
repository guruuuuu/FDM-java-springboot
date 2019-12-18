<%@ include file="layout/header.jsp" %>
	<div class="container">
		<div class="row">
			<div class="col-10">
				<c:forEach items="${cars}" var="car">
					<div class="card my-2 bg-info text-white">
						<div class="card-header">${car.make} ${car.model}<a href="/delete?numplate=${car.numplate}"><i
								class="fa fa-window-close float-right" aria-hidden="true"></i></a><a href="/edit?numplate=${car.numplate}"><i class="fa fa-pencil float-right mx-1" aria-hidden="true"></i></a>
						</div>
						<div class="card-body">
							<ul class="list-group text-dark">
								<li class="list-group-item">NumPlate: ${car.numplate}</li>
								<li class="list-group-item">Colour: ${car.colour}</li>
								<li class="list-group-item">Mileage(M): ${car.mileage} Miles</li>
								<li class="list-group-item">Price: £${car.price}</li>
								<li class="list-group-item">Listed At: ${car.listedAt}</li>
							</ul>
						</div>
					</div>
				</c:forEach>

			</div>
		</div>
	</div>
<%@ include file="layout/footer.jsp" %>