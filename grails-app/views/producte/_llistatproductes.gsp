<g:if test="${flash.message}">
<div class="message" role="status"><g:message code="${flash.message}" args="${flash.args}"/></div>
</g:if>
<%@ page import="productes.*" %>
<g:if test="${productesInstance.size()}">
<g:each in="${productesInstance}" var="producteActual">
  <% detallOferta = producteActual.GetOferta(); %>
  <div id="itemProducte">
    <div id="imgLlistat">
      <g:link controller="producte" action="detall" id="${producteActual.id}">
      <g:if test="${!grailsApplication.mainContext.getResource('images/productes/'+producteActual.getFitxerUrlImatge()).exists() }"><img src="${resource(dir: 'images/productes/', file: 'non_image.jpg')}" width="180" height="120" alt="${producteActual.nom} no te imatge"/></g:if>
      <g:else>
        <img src="${resource(dir: 'images/productes/', file: producteActual.getFitxerUrlImatge())}" width="180" height="120" alt="imatge inicial"/>
      </g:else>
      </g:link>
    </div>
    <div id="textLlistat">
      <span class="nomProducteLlistat">${producteActual.nom}</span><br>
      A: <span class="nomCategoriaLlistat">${producteActual.subcategoria.categoria.nom} > <g:link controller="producte" action="list" params="[subcat: producteActual.subcategoria.id]">${producteActual.subcategoria.nom}</g:link>.</span><br>
      <g:if test="${detallOferta}">
        <strike>PVP: ${producteActual.getPreuCataleg()}€</strike><br>
        <b>Oferta: ${producteActual.getPreu()}€ (${detallOferta.descompte}% dte!)</b>
        <g:if test="${detallOferta.data_fi_oferta}"><br>Fins al ${detallOferta.DataFinal()}</g:if>
      </g:if>
      <g:else>
        PVP: <b>${producteActual.getPreu()}€</b>
      </g:else>
      <br>${producteActual.descripcio_comercial}
    </div>
    <div id="botoComprarLlistat">
      <g:if test="${session.usuari?.rol!='comercial'}">
        <g:link controller="cistella" action="afegirProducte" params="[idProducte: producteActual.id, quantitat: 1]">&raquo;Afegir a la cistella!&laquo;</g:link>
      </g:if>
      <g:else>
        <g:link controller="producteGestio" action="show" params="[id: producteActual.id]">&raquo;Veure i editar&laquo;</g:link>
      </g:else>
    </div>
  </div>
</g:each>
<br clear="all">
<div class="pagination">
        <g:paginate total="${producteInstanceTotal}" params="${params}" />
</div>
</g:if>
<g:else>
  <em>No hi ha cap producte que concordi amb aquests paràmetres</em>
</g:else>