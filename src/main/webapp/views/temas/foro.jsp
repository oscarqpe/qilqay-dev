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
							Foro
						</small>
					</a>
				</div>
				<!-- /section:basics/navbar.layout.brand -->
				<!-- #section:basics/navbar.toggle -->
				<div class="navbar-buttons navbar-header pull-right" role="navigation">
					<ul class="nav ace-nav" style="max-height: 45px;">
						<li class="green">
							<a data-toggle="dropdown" class="dropdown-toggle" href="/nuevo-tema" title="Nuevo Tema">
								<i class="ace-icon fa fa-plus-circle"></i>
								<span class="badge badge-green">-</span>
							</a>
						</li>
					</ul>
				</div>
				<!-- /section:basics/navbar.toggle -->
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
							<div class="col-sm-12 widget-container-col ui-sortable">
								<div class="widget-box transparent ui-sortable-handle">
									<div class="widget-header">
										<h4 class="widget-title lighter">${tema.titulo}</h4>
									</div>

									<div class="widget-body">
										<div class="widget-main padding-12 no-padding-left no-padding-right">
											<div class="tab-content padding-4">
												<div id="home2" class="tab-pane in active">
													<!-- #section:custom/scrollbar.horizontal -->
													<div class="scrollable-horizontal ace-scroll" data-size="800" style="position: relative; padding-top: 12px;">
														<div class="scroll-content" style="max-width: 800px;">
															<div style="width: 800px;">
																${tema.contenido}
															</div>
														</div>
													</div>

													<!-- /section:custom/scrollbar.horizontal -->
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<hr />
							<div class="col-xs-12 col-sm-10 col-sm-offset-1">
								<form class="form-horizontal" method="POST" action="/comentar">
									<fieldset>
										<div class="form-group">
											<div class="col-sm-12">
												<input type="hidden" class="col-sm-12 form-control" name="idTema" value="${tema.id}">
												<input class="col-sm-12 form-control" name="nombres" placeholder="Nombres">
											</div>
										</div>
										<div class="form-group">
											<div class="col-sm-12">
												<textarea class="col-sm-12 form-control" name="comentario" placeholder="Comentario..."></textarea>
											</div>
										</div>
										<div class="form-group">
											<div class="col-sm-9">

											</div>
											<div class="col-sm-3">
												<button type="submit" class="btn btn-sm btn-success col-sm-12">
													Comentar
												</button>
											</div>
										</div>
									</fieldset>
								</form>
								<div class="timeline-container">
									<div class="timeline-items">
										<!-- #section:pages/timeline.item -->
										<c:forEach items="${comentarios}" var="comentario">
										<div class="timeline-item clearfix">
											<!-- #section:pages/timeline.info -->
											<div class="timeline-info">
												<img alt="Avatar" src="/imagenes/avatars/avatar1.png">
												<span class="label label-info label-sm">${comentario.fecha}</span>
											</div>

											<!-- /section:pages/timeline.info -->
											<div class="widget-box transparent">
												<div class="widget-header widget-header-small">
													<h5 class="widget-title smaller">
														<a href="#" class="blue">${comentario.comentarioRef.usuarioRef.username}</a>
														<span class="grey"></span>
													</h5>

													<span class="widget-toolbar no-border">
														<i class="ace-icon fa fa-clock-o bigger-110"></i>
														${comentario.fecha}
													</span>

													<span class="widget-toolbar">
													</span>
												</div>

												<div class="widget-body">
													<div class="widget-main">
														${comentario.comentarioRef.descripcion}

														<div class="widget-toolbox clearfix">
															<!-- /section:custom/extra.action-buttons -->
														</div>
													</div>
												</div>
											</div>
										</div>
										</c:forEach>
									</div>
								</div>
							</div>
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
