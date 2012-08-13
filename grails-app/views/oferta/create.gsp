<%@ page import="productes.Oferta" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="cistella">
		<g:set var="entityName" value="${message(code: 'oferta.label', default: 'Oferta')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#create-oferta" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div id="create-oferta" class="content scaffold-create contingutGestioProductes" role="main">
			<h1><g:message code="default.create.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${ofertaInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${ofertaInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form action="save" >
				<fieldset class="form">
					<g:render template="form"/>
				</fieldset>
				<fieldset class="buttons">
                                        <g:link class="list" controller="producteGestio" action="tornaroferta">Tornar (descartar canvis)</g:link>
					<g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
