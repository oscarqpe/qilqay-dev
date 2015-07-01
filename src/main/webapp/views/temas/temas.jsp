<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <h4 class="page-header">
    Temas de Discusión
    <small>Small boxes are used for viewing statistics. To create a small box use the class.</small>
</h4>
<div class="row">
	<c:forEach items="${temas}" var="tema" varStatus="theCount">
	<div class="col-md-4">
        <!-- Primary box -->
        <div class="box box-solid box-primary">
            <div class="box-header">
                <h3 class="box-title"><a href="/foro?_key=${tema.id}">${tema.titulo}</a></h3>
            </div>
            <div class="box-body">
                <p>
                	${fn:substring(tema.contenido, 0, 150)} ...
                </p>
            </div><!-- /.box-body -->
            <div class="box-footer">
            	<div id="rating-tema${theCount.count}" class="rating inline"></div>
            	<div style="float: right; padding: 5px;">
	            	<a href="/foro?_key=${tema.id}" class="small-box-footer">
	                    Ver mas <i class="fa fa-arrow-circle-right"></i>
	                </a>
                </div>
            	<script type="text/javascript">
            		$('#rating-tema${theCount.count}').raty({
						'cancel' : true,
						'half': true,
						'starType' : 'i',
						'score': '${tema.rate}',
						readOnly: function() {
						    return 'xd' == 'xd';
						}
					})//.find('i:not(.star-raty)').addClass('grey');
            	</script>
            </div>
       	</div>
	</div>
	</c:forEach>
</div>