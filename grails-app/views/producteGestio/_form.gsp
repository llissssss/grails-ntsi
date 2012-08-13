<%@ page import="productes.Producte" %>


<div class="fieldcontain ${hasErrors(bean: producteInstance, field: 'nom', 'error')} required">
	<label for="nom">
		<g:message code="producte.nom.label" default="Nom" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nom" maxlength="50" required="" value="${producteInstance?.nom}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: producteInstance, field: 'subcategoria', 'error')} required">
	<label for="subcategoria">
		<g:message code="producte.subcategoria.label" default="Subcategoria" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="subcategoria" name="subcategoria.id" from="${productes.Subcategoria.list()}" optionKey="id" required="" value="${producteInstance?.subcategoria?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: producteInstance, field: 'descripcio_comercial', 'error')} ">
	<label for="descripcio_comercial">
		<g:message code="producte.descripcio_comercial.label" default="Descripciocomercial" />
		
	</label>
	<g:textArea name="descripcio_comercial" cols="40" rows="5" maxlength="1000" value="${producteInstance?.descripcio_comercial}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: producteInstance, field: 'descripcio_detallada', 'error')} ">
	<label for="descripcio_detallada">
		<g:message code="producte.descripcio_detallada.label" default="Descripciodetallada" />
		
	</label>
	<g:textArea name="descripcio_detallada" cols="40" rows="5" maxlength="1000" value="${producteInstance?.descripcio_detallada}"/>
</div>
<g:if test="${producteInstance?.preu_cataleg}">
  <input type="hidden" name="preu_cataleg" min="0.0" required="" value="${fieldValue(bean: producteInstance, field: 'preu_cataleg')}"/>
</g:if>
<g:else>
  <div class="fieldcontain ${hasErrors(bean: producteInstance, field: 'preu_cataleg', 'error')} required">
	<label for="preu_cataleg">
		<g:message code="producte.preu_cataleg.label" default="Preucataleg" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="preu_cataleg" min="0.0" required="" value="${fieldValue(bean: producteInstance, field: 'preu_cataleg')}"/>
</div>
</g:else>
<g:if test="${producteInstance?.data_baixa && producteInstance?.data_baixa > new Date()}">
<div class="fieldcontain ${hasErrors(bean: producteInstance, field: 'data_baixa', 'error')} ">
	<label for="data_baixa">
		<g:message code="producte.data_baixa.label" default="Databaixa" />
		
	</label>
	<g:datePicker name="data_baixa" precision="day"  value="${producteInstance?.data_baixa}" default="none" noSelection="['': '']" />
</div>
</g:if>
<div class="fieldcontain">
	<label for="imatge">
		<g:message code="producte.imatge.label" default="Imatge" />
		
	</label>
  <input type="file" name="imatge"  />
</div>