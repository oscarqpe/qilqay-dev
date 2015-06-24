<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="/css/estilos.css">
	<link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">

	<link rel="stylesheet" type="text/css" href="/css/ace.css">
	<link rel="stylesheet" type="text/css" href="/css/font-awesome-4.3.0/css/font-awesome.min.css">
</head>	
<body>
	<div id="navbar" class="navbar navbar-default">
			<script type="text/javascript">
				try{ace.settings.check('navbar' , 'fixed')}catch(e){}
			</script>

			<div class="navbar-container" id="navbar-container">
				<!-- #section:basics/sidebar.mobile.toggle -->
				<button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler" data-target="#sidebar">
					<span class="sr-only">Toggle sidebar</span>

					<span class="icon-bar"></span>

					<span class="icon-bar"></span>

					<span class="icon-bar"></span>
				</button>

				<!-- /section:basics/sidebar.mobile.toggle -->
				<div class="navbar-header pull-left">
					<!-- #section:basics/navbar.layout.brand -->
					<a href="#" class="navbar-brand">
						<small>
							<i class="fa fa-leaf"></i>
							Foro Tia María
						</small>
					</a>

					<!-- /section:basics/navbar.layout.brand -->

					<!-- #section:basics/navbar.toggle -->

					<!-- /section:basics/navbar.toggle -->
				</div>

				<!-- -->

				<!-- /section:basics/navbar.dropdown -->
			</div><!-- /.navbar-container -->
		</div>
		<div class="main-container">
			<div class="main-content">
				<div class="main-content-inner">
					<div class="row">
						<div class="col-sm-2">
							
						</div>
						<div class="col-sm-8">
							<form class="form-horizontal" method="POST">
								<fieldset>
									<legend>Datos de Tema</legend>
									<div class="form-group">
										<label class="col-sm-3 control-label">Título</label>
										<div class="col-sm-9">
											<input class="col-sm-12 form-control" name="titulo">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label">Descripción</label>
										<div class="col-sm-9">
											<textarea class="col-sm-12 form-control" name="descripcion"></textarea>
										</div>
									</div>
									<div class="form-group">
										<button type="submit" class="btn btn-success col-sm-12">
											Registrar
										</button>
									</div>
								</fieldset>
							</form>
						</div>
						<div class="col-sm-2">
							
						</div>
					</div>
				</div>
			</div>
		</div>
	
<script type="text/javascript" src="/js/scripts.js"></script>
</body>
</html>
