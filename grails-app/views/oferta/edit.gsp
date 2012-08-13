<%@ page import="productes.Oferta" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="cistella">
		<g:set var="entityName" value="${message(code: 'oferta.label', default: 'Oferta')}" />
		<title><g:message code="default.edit.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#edit-oferta" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div id="edit-oferta" class="content scaffold-edit contingutGestioProductes" role="main">
			<h1><g:message code="default.edit.label" args="[entityName]" /></h1>
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
			<g:form method="post" >
				<g:hiddenField name="id" value="${ofertaInstance?.id}" />
				<g:hiddenField name="version" value="${ofertaInstance?.version}" />
				<fieldset class="form">
					<g:render template="form"/>
				</fieldset>
				<fieldset class="buttons">
                                        <g:link class="list" controller="producteGestio" action="tornaroferta">Tornar (descartar canvis)</g:link>
					<g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
