<%@ page session="false" %>
<!DOCTYPE html>
	<head>
		<link rel="stylesheet" href="style.css">
		 <!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link href="https://fonts.googleapis.com/css?family=BioRhyme+Expanded" rel="stylesheet">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.css" />
	<script>
		$(document).ready(function(){
			var flag=0;
			$("#loginWindow").hide();
			$("#registerWindow").hide();
			$("input").blur(function(){
				let ip=$(this).val();
				console.log(ip);
				if(ip==""){
					$(this).addClass("animated wobble");
					$(this).css("background-color", "red");	
				}
				else{
					
					$(this).css("background-color", "white");
					
				}
				
				
				
			});
			$("#login").click(function(){
				$("#registerWindow").hide();

				$("#loginWindow").slideDown(1000);
			});
			$("#register").click(function(){
				$("#loginWindow").hide();
					$("#registerWindow").slideDown(1000);


			});
		});



	</script>
	</head>
	<body class="container-fluid"id="body">

		<div class="navbar " id="navigation">
			<img src="images/logo.png" alt"site logo">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="">About Us</a></li>
				<li><a href="">Contact Us</a></li>
				<li><a href="">Home</a></li>
				
				<li id="login" class="${icon}"><a href="#">Login</a></li>
				<li id="register"><a href="#">Register</a></li>

			</ul>
		</div>
		<div class="row">
			<div class="col-xs-3 animated slideInLeft " id="center">
			<h1>We think outside the box</h1>
			</div>
			<div id="loginWindow" class="col-xs-offset-2 col-xs-5">
				<form action="LoginController" method="post">
				<h2>Login</h2>
				<h2 class="label-danger ${icon}">${message}</h2>
				<table class="table">
					<tr>
					<td>Username</td>
					<td>
					<input type="text" name="username">
					</td>
					</tr>
					<tr>
					<td>
						Enter Password
					</td>
				<td>
					<input type="password" name="password">
					</td>
				</tr>
					<tr>
					<td><input type="submit" value="Send"></td>
					</tr>
				</table>
				</form>
			</div>


			<!-- registration -->

			<div id="registerWindow" class="col-xs-offset-2 col-xs-5">
							<form action="RegisterController" method="post">
							<h2>Register</h2>
							<table class="table">
								<tr>
								<td>Username</td>
								<td>
								<input type="text" name="username" value="${cusername}">
								</td>
								<td>
								<p style="color:red">${errors['username']}</p>
								</td>
								</tr>
								
								<tr>
								<td>Mobile Number</td>
								<td>
								<input type="number" name="mobile" value="${cmobile }">
								</td>
								<td>
										<p style="color:red">${errors['mobile']}</p>
						
								</td>
								</tr>
								
								
								
								<tr>
								<td>Enter Email</td>
								<td>
								<input type="email" name="emailId" value="${cemail}">
								</td>
								<td>
									<p style="color:red">${errors['email']}</p>
						
								</td>
								</tr>
								<tr>
								<td>
									Enter Password
								</td>
							<td>
								<input type="password" name="password">
								</td>
								<td>
										<p style="color:red">${errors['password']}</p>
						
								</td>
							</tr>

									<tr>
											<td>
													Confirm Password
															</td>
														<td>
															<input type="password" name="cpassword">
															</td>
														</tr>

								<tr>
								<td><input type="submit" value="Send"></td>
								</tr>
							</table>
							</form>
			</div>



		</div>

	</body>
</html>
