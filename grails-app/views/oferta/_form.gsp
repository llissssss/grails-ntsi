<%@ page import="productes.Oferta" %>

<g:if test="${ofertaInstance?.data_inici_oferta == null || ( ofertaInstance?.data_inici_oferta && ofertaInstance?.data_inici_oferta > new Date())}">
<div class="fieldcontain ${hasErrors(bean: ofertaInstance, field: 'data_inici_oferta', 'error')} required">
	<label for="data_inici_oferta">
		<g:message code="oferta.data_inici_oferta.label" default="Data inici" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="data_inici_oferta" precision="day"  value="${ofertaInstance?.data_inici_oferta}"  />
</div>
</g:if>
<g:else>
<div class="fieldcontain ${hasErrors(bean: ofertaInstance, field: 'data_inici_oferta', 'error')} required">
  <label for="data_inici_oferta">
          <g:message code="oferta.data_inici_oferta.label" default="Data inici" />
          <span class="required-indicator">*</span>
  </label>
  <g:formatDate format="dd/MM/yyyy" value="${ofertaInstance?.data_inici_oferta}"></g:formatDate>
  <g:field type="date" name="data_inici_oferta" precision="day"  value="${ofertaInstance?.data_inici_oferta}" style="visibility:hidden; display:none" />
</div>
</g:else>

<div class="fieldcontain ${hasErrors(bean: ofertaInstance, field: 'descompte', 'error')} required">
	<label for="descompte">
		<g:message code="oferta.descompte.label" default="Descompte" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="descompte" min="0.0" required="" value="${fieldValue(bean: ofertaInstance, field: 'descompte')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: ofertaInstance, field: 'producte', 'error')} ">
	<label for="producte">
		<g:message code="oferta.producte.label" default="Producte" />
		
	</label>
        <input type="text" value="${ofertaInstance?.producte?.nom}" disabled>
</div>
<input type="hidden" name="producte.id" id="producte" value="${ofertaInstance?.producte?.id}" />
<!--
<div class="fieldcontain ${hasErrors(bean: ofertaInstance, field: 'actiu', 'error')} ">
	<label for="actiu">
		<g:message code="oferta.actiu.label" default="Actiu" />
		
	</label>
	
</div>
-->
<div class="fieldcontain ${hasErrors(bean: ofertaInstance, field: 'data_fi_oferta', 'error')} required">
	<label for="data_fi_oferta">
		<g:message code="oferta.data_fi_oferta.label" default="Data fi" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="data_fi_oferta" precision="day" default="none"  value="${ofertaInstance?.data_fi_oferta}"  noSelection="['': '']"  />
</div>

<div class="fieldcontain ${hasErrors(bean: ofertaInstance, field: 'preu_oferta', 'error')} required">
	<!--<label for="preu_oferta">
		<g:message code="oferta.preu_oferta.label" default="Preuoferta" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="preu_oferta" required="" value="${fieldValue(bean: ofertaInstance, field: 'preu_oferta')}"/>-->
        <input type="hidden" name="preu_oferta" value="0">
     
</div>

