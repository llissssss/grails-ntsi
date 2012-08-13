
<%@ page import="productes.Oferta" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="cistella">
		<g:set var="entityName" value="${message(code: 'oferta.label', default: 'Oferta')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-oferta" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div id="show-oferta" class="content scaffold-show contingutGestioProductes" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list oferta">
                                
                                <g:if test="${ofertaInstance?.data_inici_oferta}">
				<li class="fieldcontain">
					<span id="data_inici_oferta-label" class="property-label"><g:message code="oferta.data_inici_oferta.label" default="Data inici" /></span>
					
						<span class="property-value" aria-labelledby="data_inici_oferta-label"><g:formatDate format="dd/MM/yyyy" date="${ofertaInstance?.data_inici_oferta}" /></span>
					
				</li>
				</g:if>
                          
				<g:if test="${ofertaInstance?.descompte}">
				<li class="fieldcontain">
					<span id="descompte-label" class="property-label"><g:message code="oferta.descompte.label" default="Descompte" /></span>
					
						<span class="property-value" aria-labelledby="descompte-label"><g:fieldValue bean="${ofertaInstance}" field="descompte"/>%</span>
					
				</li>
				</g:if>
			
				<g:if test="${ofertaInstance?.producte}">
				<li class="fieldcontain">
					<span id="producte-label" class="property-label"><g:message code="oferta.producte.label" default="Producte" /></span>
					
						<span class="property-value" aria-labelledby="producte-label"><g:link controller="producteGestio" action="show" id="${ofertaInstance?.producte?.id}">${ofertaInstance?.producte?.nom}</g:link></span>
					
				</li>
				</g:if>
			
				<li class="fieldcontain">
					<span id="data_fi_oferta-label" class="property-label"><g:message code="oferta.data_fi_oferta.label" default="Data fi" /></span>
					<span class="property-value" aria-labelledby="data_fi_oferta-label">
                                          <g:if test="${ofertaInstance?.data_fi_oferta}"><g:formatDate format="dd/MM/yyyy" date="${ofertaInstance?.data_fi_oferta}" /></g:if>
                                          <g:else>Indefinida</g:else>
                                        </span>
					
				</li>
			
				<g:if test="${ofertaInstance?.preu_oferta}">
				<li class="fieldcontain">
					<span id="preu_oferta-label" class="property-label"><g:message code="oferta.preu_oferta.label" default="Preu amb oferta" /></span>
					
						<span class="property-value" aria-labelledby="preu_oferta-label"><g:fieldValue bean="${ofertaInstance}" field="preu_oferta"/>€</span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${ofertaInstance?.id}" />
                                        <g:link class="list" controller="producteGestio" action="tornaroferta" id="${ofertaInstance?.producte.id}">Tornar</g:link>
					<g:link class="edit" action="edit" id="${ofertaInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
