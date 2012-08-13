<%@ page import="productes.Producte" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="cistella">
		<g:set var="entityName" value="${message(code: 'producte.label', default: 'Producte')}" />
		<title><g:message code="default.edit.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#edit-producte" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="edit-producte" class="content scaffold-edit contingutGestioProductes" role="main">
			<h1><g:message code="default.edit.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${producteInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${producteInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:uploadForm method="post" >
				<g:hiddenField name="id" value="${producteInstance?.id}" />
				<g:hiddenField name="version" value="${producteInstance?.version}" />
				<fieldset class="form">
					<g:render template="form"/>
                                        <g:if test="${producteInstance?.GetOferta()}">
                                          <div class="fieldcontain">
                                              <label for="ofertes">Oferta activa</label>
                                              <ul class="one-to-many"><li class="add">
                                                <g:link controller="oferta" action="show" id="${producteInstance?.GetOferta().id}">Descompte: ${producteInstance?.GetOferta()?.descompte}% - Del ${producteInstance?.GetOferta()?.DataInicial()} fins <g:if test="${producteInstance?.GetOferta()?.data_fi_oferta}">al ${producteInstance?.GetOferta()?.DataFinal()}</g:if><g:else>(indefinidament)</g:else></g:link>  
                                              </li></ul>
                                          </div>
                                        </g:if>
                                        <div class="fieldcontain ${hasErrors(bean: producteInstance, field: 'ofertes', 'error')} ">
                                                  <label for="ofertes">
                                                          <g:message code="producte.ofertes.label" default="Últimes 5 ofertes" />

                                                  </label>

                                          <ul class="one-to-many">
                                          <% def compt = 0 %>
                                          
                                          <g:each in="${producteInstance?.ofertes}" var="o">
                                            <g:if test="${compt < 5}">
                                              <li class="add">
                                              <g:link controller="oferta" action="show" id="${o.id}">Descompte: ${o?.descompte}% - Del ${o?.DataInicial()} fins <g:if test="${o?.data_fi_oferta}">al ${o?.DataFinal()}</g:if><g:else>(indefinidament)</g:else></g:link>
                                              </li>
                                              <% compt++ %>
                                            </g:if>
                                          </g:each>
                                          <li class="add">
                                            <br>
                                          <g:link controller="oferta" action="create" params="['producte.id': producteInstance?.id]">+ ${message(code: 'default.add.label', args: [message(code: 'oferta.label', default: 'Oferta')])}</g:link>
                                          </li>
                                          </ul>

                                          </div>
				</fieldset>
				<fieldset class="buttons">
                                        <g:link class="list" action="tornar">Tornar (descartar canvis)</g:link>
					<g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" />
				</fieldset>
			</g:uploadForm>
		</div>
	</body>
</html>
