<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="col-sm-1">
	
</div>
<div class="col-sm-10">
	<div class="col-sm-12 widget-container-col ui-sortable">
		<div class="box box-primary">
            <div class="box-header" data-toggle="tooltip" title="Header tooltip">
                <h3 class="box-title">${tema.titulo}</h3>
                <input id="idTema" type="hidden" value="${tema.id}">
            </div>
            <div class="box-body">
                <p>
                    ${tema.contenido}
                </p>
            </div><!-- /.box-body -->
            <div class="box-footer">
                <div id="rating-tema" class="rating inline"></div>
                <small>${tema.votos} votos...</small>
            </div><!-- /.box-footer-->
        </div><!-- /.box -->
	</div>
	<div class="col-sm-12 widget-container-col ui-sortable">
		<div class="box box-primary">
			<div class="box-body">
				<form id="form-comment" class="form-horizontal" method="POST" action="/comentar">
					<fieldset>
						<div class="form-group">
							<div class="col-sm-9">
								<input name="idTemaComment" type="hidden" value="${tema.id}">
								<textarea class="col-sm-12 form-control" id="comentario" name="comentario" placeholder="Comentario..."></textarea>
							</div>
							<div class="col-sm-3">
								<button type="submit" class="btn btn-sm btn-success col-sm-12">
									Comentar
								</button>
							</div>
						</div>
					</fieldset>
				</form>
			</div>
		</div>
		<div class="box box-primary">
			<div class="box-body">
				<ul class="timeline">
				    <!-- timeline item -->
				    <c:forEach items="${comentarios}" var="comentario">
				    <li>
				        <!-- timeline icon -->
				        <i class="timeline-img">
				        	<img src="/imagenes/avatars/avatar1.png" />
				        </i>
				        <div class="timeline-item">
				        	<fmt:formatDate value="${comentario.fecha}" var="formattedDate" 
				        		type="date" pattern="dd/MM/yyyy HH:mm:ss" />
				            <span class="time"><i class="fa fa-clock-o"></i> ${formattedDate}</span>
				            <h3 class="timeline-header"><a href="#">${comentario.comentarioRef.usuarioRef.username}</a> </h3>
				            <div class="timeline-body">
				                ${comentario.comentarioRef.descripcion}
				            </div>
				            <div class='timeline-footer'>
				            </div>
				        </div>
				    </li>
				    </c:forEach>
				    <!-- END timeline item -->
				</ul>
			</div>
		</div>
	</div>
</div>
<div class="col-sm-1">
	
</div>
<script type="text/javascript">
	$(document).ready(function (e) {
		$('#form-comment').validate({
	        rules : {
	            'comentario' : { required : true }
	        },
	        messages : {
				'comentario' : { required : 'Este campo es requerido.' }
	        },
	        debug : true,
	        /*errorElement: 'div',*/
	        //errorContainer: $('#errores').val(),
	        submitHandler : function(form) {
	            form.submit();
	        }
	    });
	});
	$('[data-rel=tooltip]').tooltip();
	$('#rating-tema').raty({
		'cancel' : true,
		'half': true,
		'starType' : 'i',
		'score': '${tema.rate}',
		'click': function(score, evt){
			console.log(score);
			//setRatingColors.call(this);
			var form = document.createElement("form");
			var element1 = document.createElement("input"); 
			var element2 = document.createElement("input");  

			form.method = "POST";
			form.action = "/vote";   

			element1.value = score;
			element1.name = "rating";
			form.appendChild(element1);  

			element2.value = $("#idTema").val();
			element2.name = "idTema";
			form.appendChild(element2);

			document.body.appendChild(form);

			form.submit();
		}/**,
		'mouseover': function() {
			setRatingColors.call(this);
		},
		'mouseout': function() {
			setRatingColors.call(this);
		}*/
	})//.find('i:not(.star-raty)').addClass('grey');
</script>