<%@   include file="../common/header.jspf"%>
<%@   include file="../common/navbar.jspf"%>

<div class="container">
	<h2 class="text-center">Welcome ${name}</h2>
</div>

<div class="container">
	<h3>Your Todo's are:</h3>
	<table class="table table-striped">
		<thead class="thead-dark">
			<tr>
				<th scope="col">Description</th>
				<th>Category</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<d:forEach items="${todos }" var="todo">
				<tr>
					<td>${todo.name}</td>
					<td>${todo.category}</td>
					<td><a class="btn btn-danger"
						href="/delete-todo.do?todo=${todo.name}&category=${todo.category}">delete</a>
					</td>
				</tr>
			</d:forEach>
		</tbody>
	</table>
	<a class="btn btn-success" href="/add-todo.do">Add Todos</a>
</div>

<%@include file="../common/footer.jspf"%>