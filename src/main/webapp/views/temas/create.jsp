<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="col-sm-2">
	
</div>
<div class="col-sm-8">
	<form id="form-create-tema" class="form-horizontal" method="POST">
		<fieldset>
			<legend>Datos de Tema</legend>
			<div class="form-group">
				<label class="col-sm-3 control-label">Título</label>
				<div class="col-sm-9">
					<input class="col-sm-12 form-control" name="titulo" id="titulo">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">Descripción</label>
				<div class="col-sm-9">
					<textarea class="col-sm-12 form-control" name="descripcion" id="descripcion"></textarea>
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
<script type="text/javascript">
	$(document).ready(function (e) {
		$('#form-create-tema').validate({
	        rules : {
	            'titulo' : { required : true },
	            'descripcion' : { required : true }
	        },
	        messages : {
				'titulo' : { required : 'Este campo es requerido.' },
				'descripcion' : { required : 'Este campo es requerido.' }
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
</script>