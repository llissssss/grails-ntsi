
<%@ page import="productes.Producte" %>
<%@ page import="productes.Oferta" %>
<!doctype html>
<html>
  <head>
    <meta name="layout" content="cistella">
    <title>CISTELLS</title>
  <g:javascript library="jquery"/>
  <!--<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
  <META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">-->
</head>
<body>
<g:if test="${!session.cistella.isEmpty()}">
  <div id="llistaProductes">
    <g:render template="llista"/>
  </div>
</g:if>
<g:else>
  <div class="cistellabuida2">
     <div class="errors">
      La cistella es buida , si vols algun producte continuar comprant
     </div>
  </div>
</g:else>
<g:form controller="Cistella" >
  <g:if test="${!session.cistella.isEmpty()}">
  <fieldset class="buttons">
    <g:link class="delete" value="Eliminar Cistella" update="llistaProductes" action="eliminar" >Eliminar Cistella</g:link>
    <g:link class="exit save" url="[action:'continuarComprant',controller:'cistella']">
      Continuar Comprant
    </g:link>
    <g:link class="exit save" url="/g2012g/cistella/comprar">
      Comprar
    </g:link>
  </fieldset>
  </g:if>
  <g:else>
    <fieldset class="buttons">
    <g:link class="exit save" url="[action:'continuarComprant',controller:'cistella']">
      Continuar Comprant
    </g:link>

  </fieldset>
  </g:else>
</g:form>

</body>
</html>
