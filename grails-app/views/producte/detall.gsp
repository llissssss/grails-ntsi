<!doctype html>
<html>
<head>
        <meta name="layout" content="main"/>
        <title>${producte.nom}</title>
</head>
<body>
<div id="contingutDret">
    <h1>${producte.nom}</h1>
    <% detallOferta = producte.GetOferta(); %>
    <div id="detallProductes">
      <span class="breadcrump_producte">Estàs a: &raquo; ${producte.subcategoria.categoria.nom} &raquo; ${producte.subcategoria.nom} &raquo; ${producte.nom}</span><br clear='all'><br clear='all'> 
      <g:if test="${!grailsApplication.mainContext.getResource('images/productes/'+producte.getFitxerUrlImatge()).exists() }"><img src="${resource(dir: 'images/productes/', file: 'non_image.jpg')}" width="300" alt="${producte.nom} no te imatge"/></g:if>
      <g:else>
        <img src="${resource(dir: 'images/productes/', file: producte.getFitxerUrlImatge())}" width="300" alt="imatge inicial"/>
      </g:else>
      <b>Descripció comercial: </b><br>
      ${producte.descripcio_comercial}<br><br>
      <b>Descripció detallada:</b><br>
      ${producte.descripcio_detallada}<br><br>
      <div class="preuDetall">
        <g:if test="${detallOferta}">
          <strike>PVP: ${producte.getPreuCataleg()}€</strike><br>
          <b>Oferta: ${producte.getPreu()}€ (${detallOferta.descompte}% dte!)</b>
          <g:if test="${detallOferta.data_fi_oferta}"><br>Fins al ${detallOferta.DataFinal()}</g:if>
        </g:if>
        <g:else>
          PVP: <b>${producte.getPreu()}€</b>
        </g:else>
        <br>
        <g:if test="${session.usuari?.rol!='comercial'}">
          <g:link controller="cistella" action="afegirProducte" params="[idProducte: producte.id, quantitat: 1]">&raquo;Afegir a la cistella!&laquo;</g:link>
        </g:if>
        <g:else>
          <g:link controller="producteGestio" action="show" params="[id: producte.id]">&raquo;Veure i editar&laquo;</g:link>
        </g:else>
      </div>
      <br clear="all">
      <g:link controller="producte" action="tornar">&laquo; tornar</g:link>
    </div>
</div>
</body>
</html>
