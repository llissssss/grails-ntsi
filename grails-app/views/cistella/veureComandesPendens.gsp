
<%@ page import="productes.Producte" %>
<%@ page import="productes.Oferta" %>
<!doctype html>
<html>
  <head>
    <meta name="layout" content="cistella">
    <title>Comandes Pendents</title>
  <g:javascript library="jquery"/>
  <!--<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
  <META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">-->
</head>
<body>
  <div class="cistellabuida2">
    <div class="message" style="font-size:16px; width: 900px; margin-left: 10px;">
      La seva comanda s'ha realitzat correctament, s'hi vol veure el seu estat vagi a comandes Pendents     
    </div>
  </div>

  
<g:form controller="Cistella" >
 <fieldset class="buttons"> 
    <g:link class="exit save" url="[action:'continuarComprant',controller:'cistella']">
      Continuar Comprant
    </g:link>
    <g:link class="exit save" url="[action:'veure',controller:'comandes']">
      comandes Pendents
    </g:link>
  </fieldset>
</g:form>

</body>
</html>
