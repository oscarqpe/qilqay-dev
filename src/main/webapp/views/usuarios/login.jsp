<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="/css/estilos.css">
	<link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">

	<link rel="stylesheet" type="text/css" href="/css/ace.css">
	<link rel="stylesheet" type="text/css" href="/css/font-awesome-4.3.0/css/font-awesome.min.css">
</head>	

	<body class="login-layout light-login">
		<div class="main-container">
			<div class="main-content">
				<div class="row">
					<div class="col-sm-10 col-sm-offset-1">
						<div class="login-container">
							<div class="center">
								<h1>
									<i class="ace-icon fa fa-leaf green"></i>
									<span class="red">Qilqay - AQP</span>
									<span class="white" id="id-text2"></span>
								</h1>
								<h4 class="blue" id="id-company-text">&copy; Os Company</h4>
							</div>

							<div class="space-6"></div>

							<div class="position-relative">
								<div id="login-box" class="login-box visible widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header blue lighter bigger">
												<i class="ace-icon fa fa-coffee green"></i>
												Ingrese su información
											</h4>

											<div class="space-6"></div>

											<form action="/login" method="POST">
												<fieldset>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" class="form-control" placeholder="Nombre de usuario" name="username" />
															<i class="ace-icon fa fa-user"></i>
														</span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" class="form-control" placeholder="Contraseña" name="password" />
															<i class="ace-icon fa fa-lock"></i>
														</span>
													</label>

													<div class="space"></div>

													<div class="clearfix">
														<label class="inline">
															<input type="checkbox" class="ace" name="rememberme" />
															<span class="lbl"> No cerrar sesión</span>
														</label>

														<button type="submit" class="width-35 pull-right btn btn-sm btn-primary">
															<i class="ace-icon fa fa-key"></i>
															<span class="bigger-110">Ingresar</span>
														</button>
													</div>

													<div class="space-4"></div>
												</fieldset>
											</form>

											<div class="social-or-login center">
												<span class="bigger-110">Iniciar con:</span>
											</div>

											<div class="space-6"></div>

											<div class="social-login center">
												<!--a class="btn btn-primary">
													<i class="ace-icon fa fa-facebook" style="margin-top: 10px;"></i>
												</a>

												<a class="btn btn-info">
													<i class="ace-icon fa fa-twitter" style="margin-top: 10px;"></i>
												</a-->

												<a href="/googleapi/connect" class="btn btn-danger">
													<i class="ace-icon fa fa-google-plus" style="margin-top: 10px;"></i>
												</a>
											</div>
										</div><!-- /.widget-main -->

										<div class="toolbar clearfix">
											<div>
												<a href="/retrieve" data-target="/retrieve" class="forgot-password-link">
													<i class="ace-icon fa fa-arrow-left"></i>
													Olvide mi contraseña
												</a>
											</div>

											<div>
												<a href="/register" data-target="/register" class="user-signup-link">
													Registrarse
													<i class="ace-icon fa fa-arrow-right"></i>
												</a>
											</div>
										</div>
									</div><!-- /.widget-body -->
								</div><!-- /.login-box -->
							</div><!-- /.position-relative -->
						</div>
					</div><!-- /.col -->
				</div><!-- /.row -->
			</div><!-- /.main-content -->
		</div><!-- /.main-container -->

	</body>
</html>
