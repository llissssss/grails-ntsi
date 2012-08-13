
<%@ page import="Compres.Comanda" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="cistella">
		<g:set var="entityName" value="${message(code: 'comanda.label', default: 'Comanda')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-comanda" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-comanda" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list comanda">
			
				<g:if test="${comandaInstance?.usuari}">
				<li class="fieldcontain">
					<span id="usuari-label" class="property-label"><g:message code="comanda.usuari.label" default="Usuari" /></span>
					
						<span class="property-value" aria-labelledby="usuari-label"><g:link controller="usuari" action="show" id="${comandaInstance?.usuari?.id}">${comandaInstance?.usuari?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${comandaInstance?.data}">
				<li class="fieldcontain">
					<span id="data-label" class="property-label"><g:message code="comanda.data.label" default="Data" /></span>
					
						<span class="property-value" aria-labelledby="data-label"><g:formatDate date="${comandaInstance?.data}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${comandaInstance?.metodeEnviament}">
				<li class="fieldcontain">
					<span id="metodeEnviament-label" class="property-label"><g:message code="comanda.metodeEnviament.label" default="Metode Enviament" /></span>
					
						<span class="property-value" aria-labelledby="metodeEnviament-label"><g:fieldValue bean="${comandaInstance}" field="metodeEnviament"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${comandaInstance?.adreca}">
				<li class="fieldcontain">
					<span id="adreca-label" class="property-label"><g:message code="comanda.adreca.label" default="Adreca" /></span>
					
						<span class="property-value" aria-labelledby="adreca-label"><g:fieldValue bean="${comandaInstance}" field="adreca"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${comandaInstance?.estat}">
				<li class="fieldcontain">
					<span id="estat-label" class="property-label"><g:message code="comanda.estat.label" default="Estat" /></span>
					
						<span class="property-value" aria-labelledby="estat-label"><g:fieldValue bean="${comandaInstance}" field="estat"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${comandaInstance?.adreca_fact}">
				<li class="fieldcontain">
					<span id="adreca_fact-label" class="property-label"><g:message code="comanda.adreca_fact.label" default="Adrecafact" /></span>
					
						<span class="property-value" aria-labelledby="adreca_fact-label"><g:fieldValue bean="${comandaInstance}" field="adreca_fact"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${comandaInstance?.cognom_env}">
				<li class="fieldcontain">
					<span id="cognom_env-label" class="property-label"><g:message code="comanda.cognom_env.label" default="Cognomenv" /></span>
					
						<span class="property-value" aria-labelledby="cognom_env-label"><g:fieldValue bean="${comandaInstance}" field="cognom_env"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${comandaInstance?.cognom_fact}">
				<li class="fieldcontain">
					<span id="cognom_fact-label" class="property-label"><g:message code="comanda.cognom_fact.label" default="Cognomfact" /></span>
					
						<span class="property-value" aria-labelledby="cognom_fact-label"><g:fieldValue bean="${comandaInstance}" field="cognom_fact"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${comandaInstance?.linies_comanda}">
				<li class="fieldcontain">
					<span id="linies_comanda-label" class="property-label"><g:message code="comanda.linies_comanda.label" default="Liniescomanda" /></span>
					
						<g:each in="${comandaInstance.linies_comanda}" var="l">
						<span class="property-value" aria-labelledby="linies_comanda-label"><g:link controller="liniesComanda" action="show" id="${l.id}">${l?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${comandaInstance?.nif_fact}">
				<li class="fieldcontain">
					<span id="nif_fact-label" class="property-label"><g:message code="comanda.nif_fact.label" default="Niffact" /></span>
					
						<span class="property-value" aria-labelledby="nif_fact-label"><g:fieldValue bean="${comandaInstance}" field="nif_fact"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${comandaInstance?.nom_env}">
				<li class="fieldcontain">
					<span id="nom_env-label" class="property-label"><g:message code="comanda.nom_env.label" default="Nomenv" /></span>
					
						<span class="property-value" aria-labelledby="nom_env-label"><g:fieldValue bean="${comandaInstance}" field="nom_env"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${comandaInstance?.nom_fact}">
				<li class="fieldcontain">
					<span id="nom_fact-label" class="property-label"><g:message code="comanda.nom_fact.label" default="Nomfact" /></span>
					
						<span class="property-value" aria-labelledby="nom_fact-label"><g:fieldValue bean="${comandaInstance}" field="nom_fact"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${comandaInstance?.poblacio_env}">
				<li class="fieldcontain">
					<span id="poblacio_env-label" class="property-label"><g:message code="comanda.poblacio_env.label" default="Poblacioenv" /></span>
					
						<span class="property-value" aria-labelledby="poblacio_env-label"><g:fieldValue bean="${comandaInstance}" field="poblacio_env"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${comandaInstance?.poblacio_fact}">
				<li class="fieldcontain">
					<span id="poblacio_fact-label" class="property-label"><g:message code="comanda.poblacio_fact.label" default="Poblaciofact" /></span>
					
						<span class="property-value" aria-labelledby="poblacio_fact-label"><g:fieldValue bean="${comandaInstance}" field="poblacio_fact"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${comandaInstance?.preu_total}">
				<li class="fieldcontain">
					<span id="preu_total-label" class="property-label"><g:message code="comanda.preu_total.label" default="Preutotal" /></span>
					
						<span class="property-value" aria-labelledby="preu_total-label"><g:fieldValue bean="${comandaInstance}" field="preu_total"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${comandaInstance?.id}" />
					<g:link class="edit" action="edit" id="${comandaInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
