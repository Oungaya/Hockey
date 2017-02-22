<html>
    <head>
        <title>Authentification</title>
         <link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet"/>
    </head>
<body>
	<div class="login-page">
		<div class="form">
			<form class="login-form" method="post" action="LoginExecuteServlet">
						<input type="text" name="name" placeholder="username"/>	
						<input type="password" name="password" placeholder="password"/>
						<button>Connexion</button>
			</form>
		</div>
	</div>
</body>
</html>