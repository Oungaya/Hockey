<html>
    <head>
        <title>Hockey | Authentification</title>
         <link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet"/>
    </head>
<body>
	<div class="login-page">
		<div class="form">
			<form class="login-form" method="post" action="http://localhost:8080/ProjectHockeyWeb/LoginExecuteServlet">
						<input type="text" name="name" placeholder="username"/>	
						<input type="password" name="password" placeholder="password"/>
						<input type="hidden" name="web" value="true"/>
						<button>Connexion</button>
			</form>
		</div>
	</div>
</body>
</html>