<%@ include file="layout/header.jsp" %>
	<div class="container">
		<div class="row">
			<div class="col-10">
			<form method="post" action="/edit">
					<fieldset>
						<legend>Edit Your Car Listing</legend>
						<input type="hidden" name = "id" value="${car.id}">
						<div class="form-group">
							<label for="make">Make</label> <input type="text" name="make" value="${car.make}"
								class="form-control" >
						</div>
						<div class="form-group">
							<label for="model">Model</label> <input type="text"
								name="model" value="${car.model}" class="form-control">
						</div>

						<div class="form-group">
							<label for="colour">Colour</label> <input type="text" name="colour" value="${car.colour}"
								class="form-control">
						</div>
						<div class="form-group">
							<label for="mileage">Mileage</label> <input type="text" name="mileage" value="${car.mileage}"
								class="form-control">
						</div>
						<div class="form-group">
							<label for="price">Price</label> <input type="text" name="price" value="${car.price}"
								class="form-control">
						</div>
						<div class="form-group">
							<label for="numplate">Numplate</label> <input type="text" name="numplate" value="${car.numplate}"
								class="form-control">
						</div>
						<button type="submit" class="btn btn-primary">Submit</button>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
<%@ include file="layout/footer.jsp" %>