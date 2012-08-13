<%@ page import="productes.Producte" %>
<!doctype html>
<html>
<head>
        <meta name="layout" content="cistella">
        <g:set var="entityName" value="${message(code: 'producte.label', default: 'Producte')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
<a href="#list-producte" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation">
<ul>
        <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
</ul>
</div>
<div id="list-producte" class="content scaffold-list " role="main">
        <h1><g:message code="default.list.label" args="[entityName]" /></h1>
        <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
        </g:if>
        <div class="taulacistella2 taulaGestio">
        <table>
                <thead>
                        <tr>
                                <g:sortableColumn property="id" title="Codi" />
                                <g:sortableColumn property="data_alta" title="Data alta" />
                                <g:sortableColumn property="nom" title="${message(code: 'producte.nom.label', default: 'Nom')}" />

                                <th><g:message code="producte.subcategoria.label" default="Subcategoria" /></th>

                                <g:sortableColumn property="preu_cataleg" title="${message(code: 'producte.preu_cataleg.label', default: 'Preucataleg')}" />
                                <th><g:message code="producte.dteactual.label" default="Dte actual" /></th>
                                <th><g:message code="producte.fioferta.label" default="Fi oferta" /></th>
                                <g:sortableColumn property="data_baixa" title="${message(code: 'producte.data_baixa.label', default: 'Databaixa')}" />

                        </tr>
                </thead>
                <tbody>
                <g:each in="${producteInstanceList}" status="i" var="producteInstance">
                        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                
                                <td>${fieldValue(bean: producteInstance, field: "id")}</td>
                                <td><g:formatDate date="${producteInstance.data_alta}" format="dd/MM/yyyy" /></td>
                          
                                <td><g:link action="show" id="${producteInstance.id}">${fieldValue(bean: producteInstance, field: "nom")}</g:link></td>

                                <td>${fieldValue(bean: producteInstance, field: "subcategoria")}</td>

 
                                <td>${fieldValue(bean: producteInstance, field: "preu_cataleg")}€</td>
                                <% detallOferta = producteInstance.GetOferta(); %>
                                <g:if test="${detallOferta}">
                                  <td>${detallOferta.descompte}%</td>
                                  <td><g:if test="${detallOferta?.data_fi_oferta}">${detallOferta?.DataFinal()}</g:if><g:else>Indefinida</g:else></td>
                                </g:if>
                                <g:else>
                                  <td> </td>
                                  <td> </td>
                                </g:else>

                                <td><g:formatDate date="${producteInstance.data_baixa}" format="dd/MM/yyyy" /></td>

                        </tr>
                </g:each>
                </tbody>
        </table>
        </div>
        <div class="pagination">
                <g:paginate total="${producteInstanceTotal}" />
        </div>
</div>
</body>
</html>
