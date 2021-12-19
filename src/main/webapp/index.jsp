<!DOCTYPE html>
<%@page import="org.intellect.pom.PageObjectManager"%>
<%@page import="org.intellect.base.Base"%>
<%!PageObjectManager pom = new PageObjectManager();%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Intellect Design Arena</title>
<link rel="stylesheet" type="text/css" href="style.css">
<link rel="stylesheet"
	href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
</head>
<body>
	<h2>Welcome To Intellect Design Arena</h2>
	<h3>
		<%
		request.getSession();
		Base.getSession(request);
		if (Base.getSessionAttribute(pom.getValidateError()) != null) {
			out.print(pom.getValidateErrorValue());
			Base.removeSessionAttribute(pom.getValidateError());
		} else if (Base.getSessionAttribute(pom.getError()) != null) {
			out.print(pom.getNotauser());
			Base.removeSessionAttribute(pom.getError());
		} else if (Base.getSessionAttribute(pom.getAdduser()) != null) {
			out.print(pom.getAdduservalue());
			Base.removeSessionAttribute(pom.getAdduser());
		} else if (Base.getSessionAttribute(pom.getUserexist()) != null) {
			out.print(pom.getUserexistvalue());
			Base.removeSessionAttribute(pom.getUserexist());
		}
		%>
	</h3>
	<div class="container" id="container">
		<div class="form-container sign-up-container">
			<form action="SignUpServlet" method="post">
				<h1>Create Account</h1>
				<div class="social-container">
					<a href="https://www.facebook.com/" class="social"><i
						class="uil uil-facebook-f"></i></a> <a
						href="https://www.instagram.com/" class="social"><i
						class="uil uil-instagram"></i></a> <a
						href="https://twitter.com/?lang=en" class="social"><i
						class="uil uil-twitter-alt"></i></a>
				</div>
				<span>or use your email for registration</span> <input type="text"
					placeholder="Name" id="singupname" name="signupusername" /> <input type="email"
					placeholder="Email" id="signupemail" name="signupuseremail" /> <input
					type="password" placeholder="Password" id="signuppasswd" name="signupuserpassword" />
				<button>Sign Up</button>
			</form>
		</div>
		<div class="form-container sign-in-container">
			<form action="SignInServlet" method="post">
				<h1>Sign in</h1>
				<div class="social-container">
					<a href="https://www.facebook.com/" class="social"><i
						class="uil uil-facebook-f"></i></a> <a
						href="https://www.instagram.com/" class="social"><i
						class="uil uil-instagram"></i></a> <a
						href="https://twitter.com/?lang=en" class="social"><i
						class="uil uil-twitter-alt"></i></a>
				</div>
				<span>or use your account</span> <input type="email"
					placeholder="Email" id="signinemail" name="signinuseremail" /> <input
					type="password" placeholder="Password" id="sininpasswd" name="signinuserpassword" />
				<a href="#">Forgot your password?</a>
				<button>Sign In</button>
			</form>
		</div>
		<div class="overlay-container">
			<div class="overlay">
				<div class="overlay-panel overlay-left">
					<h1>Welcome Back!</h1>
					<p>To keep connected with us please login with your personal
						info</p>
					<button class="ghost" id="signIn">Sign In</button>
				</div>
				<div class="overlay-panel overlay-right">
					<h1>Hello, Friend!</h1>
					<p>Enter your personal details and start journey with us</p>
					<button class="ghost" id="signUp">Sign Up</button>
				</div>
			</div>
		</div>
	</div>
	<script src="main.js"></script>
</body>
</html>