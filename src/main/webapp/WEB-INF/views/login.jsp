<%@   include file="../common/header.jspf"%>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a href="/" class="navbar-brand">Brand</a>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="#">Home</a></li>
				<li class="nav-item"><a class="nav-link" href="/list-todos.do">Todos</a></li>
				<li class="nav-item"><a class="nav-link"
					href="http://www.in28minutes.com">In28Minutes</a></li>
			</ul>

			<ul class="navbar-nav ml-auto">
				<li><a href="/login.do">Login</a></li>
			</ul>
		</div>
	</nav>

	<div class="container">
		<!-- Valid User -> Welcome.jsp -->
		<!-- Invalid User -> Return back to login.jsp -->
		<div style="color: red;">${errorMessage}</div>
		<form action="/login.do" method="POST">
			<div class="form-group">
				<label>Name:</label><input class="form-control" type="text"
					name="name">
			</div>
			<div class="form-group">
				<label>Password:</label><input class="form-control" type="password"
					name="password">
			</div>
			<input class="btn btn-primary" type="submit" value="Login">
		</form>


	</div>
	<footer class="footer">
		<p>footer content</p>
	</footer>

	<script type="text/javascript" src="webjars/jquery/3.0.0/jquery.min.js"></script>
	<script type="text/javascript"
		src="webjars/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>
