
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
  <div class="cistellabuida2">
      No hi ha comandes pendents de servir.
  </div>
</g:if>
<g:else>
  <div class="llistaComandes">
      
  <table border="1">
    <thead>
      <tr>
        <th>Id</th>
        <th>Data</th>
        <th>Poblacio</th>
        <th>Metode Enviament</th>
      </tr>
    </thead>
    <tbody>
      <g:each in="${comandes}" status="i" var="comandaInstance">
      <tr>
        <td>${comandaInstance.id}</td>
        <td>${comandaInstance.data.getDate()}/${comandaInstance.data.getMonth()+1}/${comandaInstance.data.getYear()+1900}</td>
        <td>${comandaInstance.poblacio_env} €</td>
        <td>${comandaInstance.metodeEnviament}</td>
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
