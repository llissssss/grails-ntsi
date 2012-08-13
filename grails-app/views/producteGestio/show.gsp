
<%@ page import="productes.Producte" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="cistella">
		<g:set var="entityName" value="${message(code: 'producte.label', default: 'Producte')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-producte" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-producte" class="content scaffold-show contingutGestioProductes" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list producte">
			
                                <g:if test="${producteInstance?.data_alta}">
				<li class="fieldcontain">
					<span id="data_alta-label" class="property-label"><g:message code="producte.data_alta.label" default="Data alta" /></span>
					
						<span class="property-value" aria-labelledby="data_alta-label"><g:formatDate format="dd/MM/yyyy" date="${producteInstance?.data_alta}"  /></span>
					
				</li>
				</g:if>
                          
				<g:if test="${producteInstance?.nom}">
				<li class="fieldcontain">
					<span id="nom-label" class="property-label"><g:message code="producte.nom.label" default="Nom" /></span>
					
						<span class="property-value" aria-labelledby="nom-label"><g:fieldValue bean="${producteInstance}" field="nom"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${producteInstance?.subcategoria}">
				<li class="fieldcontain">
					<span id="subcategoria-label" class="property-label"><g:message code="producte.subcategoria.label" default="Subcategoria" /></span>
					
						<span class="property-value" aria-labelledby="subcategoria-label">${producteInstance?.subcategoria?.encodeAsHTML()}</span>
					
				</li>
				</g:if>
			
				<g:if test="${producteInstance?.descripcio_comercial}">
				<li class="fieldcontain">
					<span id="descripcio_comercial-label" class="property-label"><g:message code="producte.descripcio_comercial.label" default="Descripciocomercial" /></span>
					
						<span class="property-value" aria-labelledby="descripcio_comercial-label"><g:fieldValue bean="${producteInstance}" field="descripcio_comercial"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${producteInstance?.descripcio_detallada}">
				<li class="fieldcontain">
					<span id="descripcio_detallada-label" class="property-label"><g:message code="producte.descripcio_detallada.label" default="Descripciodetallada" /></span>
					
						<span class="property-value" aria-labelledby="descripcio_detallada-label"><g:fieldValue bean="${producteInstance}" field="descripcio_detallada"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${producteInstance?.preu_cataleg}">
				<li class="fieldcontain">
					<span id="preu_cataleg-label" class="property-label"><g:message code="producte.preu_cataleg.label" default="Preucataleg" /></span>
					
						<span class="property-value" aria-labelledby="preu_cataleg-label"><g:fieldValue bean="${producteInstance}" field="preu_cataleg"/>€</span>
					
				</li>
				</g:if>
			
				<g:if test="${producteInstance?.data_baixa}">
				<li class="fieldcontain">
					<span id="data_baixa-label" class="property-label"><g:message code="producte.data_baixa.label" default="Databaixa" /></span>
					
						<span class="property-value" aria-labelledby="data_baixa-label"><g:formatDate format="dd/MM/yyyy" date="${producteInstance?.data_baixa}"  /></span>
					
				</li>
				</g:if>

				<li class="fieldcontain">
                                        <span id="descripcio_detallada-label" class="property-label">Imatge</span>
					<g:if test="${!grailsApplication.mainContext.getResource('images/productes/'+producteInstance.getFitxerUrlImatge()).exists() }"><img src="${resource(dir: 'images/productes/', file: 'non_image.jpg')}" width="300" alt="${producteInstance.nom} no te imatge"/></g:if>
                                        <g:else>
                                          <img src="${resource(dir: 'images/productes/', file: producteInstance.getFitxerUrlImatge())}" width="300" alt="imatge inicial"/>
                                        </g:else>
				</li>
                                <g:if test="${producteInstance?.GetOferta()}">
				<li class="fieldcontain">
                                    <span id="ofactual-label" class="property-label">Oferta actual</span>
                                    <span class="property-value" aria-labelledby="ofertes-label">
                                      <g:link controller="oferta" action="show" id="${producteInstance?.GetOferta().id}">Descompte: ${producteInstance?.GetOferta()?.descompte}% - Del ${producteInstance?.GetOferta()?.DataInicial()} fins <g:if test="${producteInstance?.GetOferta()?.data_fi_oferta}">al ${producteInstance?.GetOferta()?.DataFinal()}</g:if><g:else>(indefinidament)</g:else></g:link>
                                    </span>
				</li>
				</g:if>
				<g:if test="${producteInstance?.ofertes}">
				<li class="fieldcontain">
                                <span id="ofertes-label" class="property-label"><g:message code="producte.ofertes.label" default="Últimes 5 ofertes" /></span>
                                  <% def compt = 0 %>
                                  <g:each in="${producteInstance.ofertes}" var="o">
                                    <g:if test="${compt < 5}">
                                    <span class="property-value" aria-labelledby="ofertes-label">
                                      <g:link controller="oferta" action="show" id="${o.id}">Descompte: ${o?.descompte}% - Del ${o?.DataInicial()} fins <g:if test="${o?.data_fi_oferta}">al ${o?.DataFinal()}</g:if><g:else>(indefinidament)</g:else></g:link>
                                    </span>
                                    <% compt++ %>
                                    </g:if>
                                  </g:each>
                                  <br>
                                  
                                  </li>
                                </g:if>
                                  <li class="fieldcontain">
                                    <span id="ofertes-label" class="property-label"> </span>
                                    <span class="property-value" aria-labelledby="ofertes-label">
                                    <g:link controller="oferta" action="create" params="['producte.id': producteInstance?.id]">+ ${message(code: 'default.add.label', args: [message(code: 'oferta.label', default: 'Oferta')])}</g:link>
                                  </span>
                                  </li>
                
				
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${producteInstance?.id}" />
                                        <g:link class="list" action="tornar">Tornar</g:link>
					<g:link class="edit" action="edit" id="${producteInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:if test="${producteInstance?.data_baixa == null}">
                                          <g:actionSubmit class="delete" action="baixa" value="Donar de baixa amb data:" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                                          <g:datePicker name="data_baixa" precision="day"  value="${new Date()}" default="none" noSelection="['': '']" />
                                        </g:if>
                                </fieldset>
			</g:form>
		</div>
	</body>
</html>
