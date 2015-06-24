<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<meta http-equiv="refresh" content="0; url=/temas" />
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
						<div class="col-sm-12 widget-container-col ui-sortable">
							<div class="widget-box transparent ui-sortable-handle">
								<div class="widget-header">
									<h4 class="widget-title lighter">Title</h4>
								</div>

								<div class="widget-body">
									<div class="widget-main padding-12 no-padding-left no-padding-right">
										<div class="tab-content padding-4">
											<div id="home2" class="tab-pane in active">
												<!-- #section:custom/scrollbar.horizontal -->
												<div class="scrollable-horizontal ace-scroll" data-size="800" style="position: relative; padding-top: 12px;">
													<div class="scroll-content" style="max-width: 800px;">
														<div style="width: 800px;">
															Lorem ipsum dolor sit amet, consectetur 
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
						<div class="col-xs-12 col-sm-10 col-sm-offset-1">
							<div class="timeline-container">

								<div class="timeline-items">
									<!-- #section:pages/timeline.item -->
									<c:forEach items="${personas}" var="persona">
									<div class="timeline-item clearfix">
										<!-- #section:pages/timeline.info -->
										<div class="timeline-info">
											<img alt="Avatar" src="/imagenes/avatars/avatar1.png">
											<span class="label label-info label-sm">16:22</span>
										</div>

										<!-- /section:pages/timeline.info -->
										<div class="widget-box transparent">
											<div class="widget-header widget-header-small">
												<h5 class="widget-title smaller">
													<a href="#" class="blue">${persona}</a>
													<span class="grey">reviewed a product</span>
												</h5>

												<span class="widget-toolbar no-border">
													<i class="ace-icon fa fa-clock-o bigger-110"></i>
													16:22
												</span>

												<span class="widget-toolbar">
													<a href="#" data-action="reload">
														<i class="ace-icon fa fa-refresh"></i>
													</a>

													<a href="#" data-action="collapse">
														<i class="ace-icon fa fa-chevron-up"></i>
													</a>
												</span>
											</div>

											<div class="widget-body">
												<div class="widget-main">
													Anim pariatur cliche reprehenderit, enim eiusmod
													<span class="red">high life</span>

													<div class="space-6"></div>

													<div class="widget-toolbox clearfix">
														<div class="pull-left">
															<i class="ace-icon fa fa-hand-o-right grey bigger-125"></i>
														</div>
														<!-- #section:custom/extra.action-buttons -->
														<div class="pull-right action-buttons">
															<a href="#">
																<i class="ace-icon fa fa-pencil blue bigger-125"></i>
															</a>
															<a href="#">
																<i class="ace-icon fa fa-times red bigger-125"></i>
															</a>
														</div>

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
