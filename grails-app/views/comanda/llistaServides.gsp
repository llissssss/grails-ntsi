
<%@ page import="Compres.Comanda" %>
<!doctype html>
<html>
  <head>
    <meta name="layout" content="cistella">
  <g:set var="entityName" value="${message(code: 'comanda.label', default: 'Comanda')}" />
  <title>Comandes Servides</title>
</head>
<body>
  <a href="#llistaServides-comanda" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>

  <div id="list-comanda" class="content scaffold-list" role="main">
    <h1>Comandes Servides</h1>
    <g:if test="${flash.message}">
      <div class="message" role="status">${flash.message}</div>
    </g:if>
    <table class="taulacistella2 taulaGestio">
      <thead>
        <tr>
      <g:sortableColumn property="id" title="${message(code: 'comanda.id.label', default: 'Id')}" />

      <g:sortableColumn property="data" title="${message(code: 'comanda.date.label', default: 'Data')}" />

      <g:sortableColumn property="poblacio_env" title="${message(code: 'comanda.poblacio_env.label', default: 'Destinacio')}" />

      <g:sortableColumn property="metodeEnviament" title="${message(code: 'comanda.metodeEnviament.label', default: 'Metode Enviament')}" />

      <g:sortableColumn property="estat" title="${message(code: 'comanda.estat.label', default: 'Estat')}" />

      <th class="sortable">Comanda Lliurada</th>

      </tr>
      </thead>
      <tbody>
      <g:each in="${comandaInstanceList}" status="i" var="comandaInstance">
        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

          <td>${fieldValue(bean: comandaInstance, field: "id")}</td>

          <td><g:formatDate format="dd-MM-yyyy" date="${comandaInstance.data}" /></td>

          <td>${fieldValue(bean: comandaInstance, field: "poblacio_env")}</td>

          <td>${fieldValue(bean: comandaInstance, field: "metodeEnviament")}</td>

          <td>${fieldValue(bean: comandaInstance, field: "estat")}</td>

          <td><g:link action="lliurada" id="${comandaInstance.id}"><g:img uri="/images/fragoneta.gif"/></g:link></td>

        </tr>
      </g:each>
      </tbody>
    </table>
    <div class="pagination">
      <g:paginate controller="controller" action="llistaServides" total="${comandaInstanceTotal}" />
    </div>
  </div>
</body>
</html>
