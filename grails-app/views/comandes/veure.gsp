
<%@ page import="productes.Producte" %>
<%@ page import="productes.Oferta" %>
<!doctype html>
<html>
  <head>
    <meta name="layout" content="cistella">
    <title>COMANDES</title>
  <g:javascript library="jquery"/>
  <!--<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
  <META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">-->
</head>
<body>
  <br><br><br>
<g:if test="${teComandes==false}">
    <div class="cistellabuida3">
      No tens comandes pendents de servir.</div>
    <fieldset class="buttons">
      <g:link class="exit save" url="[action:'ofertes',controller:'producte']">
        Continuar Comprant
      </g:link>
    </fieldset>
  
</g:if>
<g:else>
  <div class="llistaComandes">
      
  <table class="taulaComandesPendent">
    
      <tr>
        <th>Id</th>
        <th>Data</th>
        <th>Total</th>
        <th>Estat</th>
        <th>Data recepcio</th>
      </tr>
    
    <tbody>
      <g:each in="${comandes}" status="i" var="comandaInstance">
      <tr>
        <td class="categProd2">${comandaInstance.id}</td>
        <td class="categProd2"><g:formatDate format="dd-MM-yyyy" date="${comandaInstance.data}" /></td>
        <td class="categProd2">${comandaInstance.preu_total} €</td>
        <td class="categProd2">${comandaInstance.estat}</td>
        <td class="categProd2"><g:formatDate format="dd-MM-yyyy" date="${comandaInstance.data_recepcio}" /></td>
      </tr>
      </g:each>
    </tbody>
  </table>
  </div>
  <br><br><br>
  <fieldset class="buttons">
    <g:link class="exit save" url="[action:'ofertes',controller:'producte']">
      Continuar Comprant
    </g:link>
  </fieldset>
</g:else>

</body>
</html>
