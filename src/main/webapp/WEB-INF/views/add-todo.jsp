<%@   include file="../common/header.jspf"%>
<%@   include file="../common/navbar.jspf"%>

<div class="container">
	<h2>Your New Action Item:</h2>
	<form action="add-todo.do" method="POST">
		<div class="form-group">
			<label for="staticEmail" class="col-form-label"><b>Add
					new Todo:</b></label>
			<div>
				<label>Description:</label> <input class="form-control" type="text"
					name="todo" />
			</div>
			<div>
				<label>Category</label> <input class="form-control" type="text"
					name="category" />
			</div>
			<input style="margin-top: 20px;" class="btn btn-primary"
				type="submit" value="add" />
		</div>
	</form>
</div>
<%@   include file="../common/footer.jspf"%>
