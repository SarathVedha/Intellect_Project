<%@page
	import="org.intellect.base.Base, org.intellect.pom.PageObjectManager"%>
<%!PageObjectManager pom = new PageObjectManager();%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<title>Intellect</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" type="text/css" href="welcomestyle.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet"
	href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
<style>
body, h1, h2, h3, h4, h5 {
	font-family: "Raleway", sans-serif
}
</style>
<body class="w3-light-grey">

	<div class="w3-content" style="max-width: 1400px">

		<header class="w3-container w3-center w3-padding-32">
			<h1>
				<b>INTELLECT DESIGN ARENA</b>
			</h1>
			<p>
				Welcome to the Intellect <span class="w3-tag"> 
				<%
 				request.getSession();
 				Base.getSession(request);
 				if (Base.getSessionAttribute(pom.getUsername()) != null) {
 					out.print(Base.getSessionAttribute(pom.getUsername()));
 				}
 				%></span>
			</p>
		</header>

		<%
		Base.getSession(request);
		if (Base.getSessionAttribute(pom.getSigninuseremail()) == null) {
			Base.sendRedirect(response, pom.getIndexpage());
		}
		Base.setHeader(response);
		%>
		
		<form action="LogoutServlet">
			<button> Logout </button>
		</form>
		
		<div class="w3-row">

			<div class="w3-col l8 s12">
				<div class="w3-card-4 w3-margin w3-white">
					<iframe width="901" height="500"
						src="https://www.youtube.com/embed/Wh4W1t2K8hA"
						title="YouTube video player" frameborder="0"
						allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
						allowfullscreen></iframe>
					<div class="w3-container">
						<h3>
							<b>INTELLECT #1</b>
						</h3>
						<h5>
							Global IBS Sales League, <span class="w3-opacity">2021</span>
						</h5>
					</div>

					<div class="w3-container">
						<p>Intellect Design Arena creates financial technologies that
							help banks lead businesses on the path to growth and success. Our
							solutions help move the banking world forward; because that’s
							what happens when the world knows it has financial institutions
							they can rely on. This is the philosophy that we, at Intellect
							follow, and is our commitment to our customers’ success.</p>
						<div class="w3-row">
							<div class="w3-col m8 s12">
								<p>
									<button class="w3-button w3-padding-large w3-white w3-border">
										<b>READ MORE »</b>
									</button>
								</p>
							</div>
							<div class="w3-col m4 w3-hide-small">
								<p>
									<span class="w3-padding-large w3-right"><b>Comments
											 </b> <span class="w3-tag">0</span></span>
								</p>
							</div>
						</div>
					</div>
				</div>
				<hr>

				<div class="w3-card-4 w3-margin w3-white">
					<iframe width="901" height="500"
						src="https://www.youtube.com/embed/FOPMnf5nf-k"
						title="YouTube video player" frameborder="0"
						allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
						allowfullscreen></iframe>
					<div class="w3-container">
						<h3>
							<b>Incredible Intellect</b>
						</h3>
						<h5>
							Incredible Intellect, <span class="w3-opacity">2021</span>
						</h5>
					</div>

					<div class="w3-container">
						<p>Intellect Design Arena Limited is a global leader in
							Financial Technology for Banking, Insurance and other Financial
							Services. With a rich suite of products across the organisation,
							we are an authority on vertical and integrated products that
							enable institutions to meet their ambition to be the principal
							service provider to their customers.</p>
						<div class="w3-row">
							<div class="w3-col m8 s12">
								<p>
									<button class="w3-button w3-padding-large w3-white w3-border">
										<b>READ MORE »</b>
									</button>
								</p>
							</div>
							<div class="w3-col m4 w3-hide-small">
								<p>
									<span class="w3-padding-large w3-right"><b>Comments
											 </b> <span class="w3-badge">2</span></span>
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="w3-col l4">
				<div class="w3-card w3-margin w3-margin-top">
					
					<div class="w3-container w3-white">
						<h4>
							<b> 
							<%
 							request.getSession();
 							Base.getSession(request);
 							if (Base.getSessionAttribute(pom.getUsername()) != null) {
 								out.print(Base.getSessionAttribute(pom.getUsername()));
 							}
 							%> ,
							</b>
						</h4>
						<p>We are proud of the recognition and awards we have
							received, and it only encourages us to achieve more, as we work
							to take the banking industry into the future and resolve
							tomorrow’s business needs, today!</p>
					</div>
				</div>
				<hr>

				<div class="w3-card w3-margin">
					<div class="w3-container w3-padding">
						<h4>Popular Posts</h4>
					</div>
					<ul class="w3-ul w3-hoverable w3-white">
						<li class="w3-padding-16">
							<span class="w3-large">Intellect</span><br> 
							<span>Feast</span></li>
						<li class="w3-padding-16">
							<span class="w3-large">Intellect</span><br> 
							<span>Culture</span></li>
						<li class="w3-padding-16">
							<span class="w3-large">Intellect</span><br> 
							<span>Environment</span></li>
						<li class="w3-padding-16 w3-hide-medium w3-hide-small"> 
						<span class="w3-large">Intellect</span><br> 
						<span>Day</span></li>
					</ul>
				</div>
				<hr>

			</div>

		</div>
		<br>

	</div>

</body>
</html>