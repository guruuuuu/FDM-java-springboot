<%@ include file = "layout/header.jsp"  %>
	<div class="container">
		<div class="row">
			<div class="col-10">
				<form method="post" action="/list">
					<fieldset>
						<legend>List Your Car</legend>
						<div class="form-group">
							<label for="make">Make</label> <input type="text" name="make"
								class="form-control" placeholder="Enter Make">
						</div>
						<div class="form-group">
							<label for="model">Model</label> <input type="text"
								name="model" class="form-control" placeholder="Enter Model">
						</div>

						<div class="form-group">
							<label for="colour">Colour</label> <input type="text" name="colour"
								class="form-control" placeholder="Enter Colour">
						</div>
						<div class="form-group">
							<label for="mileage">Mileage</label> <input type="text" name="mileage"
								class="form-control" placeholder="Enter Mileage">
						</div>
						<div class="form-group">
							<label for="price">Price</label> <input type="text" name="price"
								class="form-control" placeholder="Enter Price">
						</div>
						<div class="form-group">
							<label for="numplate">Numplate</label> <input type="text" name="numplate"
								class="form-control" placeholder="Enter Number Plate">
						</div>
						<button type="submit" class="btn btn-primary">Submit</button>
					</fieldset>
				</form>
			</div>
		</div>

	</div>
<%@ include file = "layout/footer.jsp"  %>