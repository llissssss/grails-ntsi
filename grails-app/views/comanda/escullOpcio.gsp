<!doctype html>
<html>
  <head>
    <title>Comandes - Opcions</title>
    <meta name="layout" content="cistella">
  </head>
  <body>
    
    <div id="missatge-error" class="content scaffold-show" role="main">
      <h1>Escull una opcio:</h1>
      <div class="taulaGestio">
        <br clear="all">
        <ul>
          <li><g:link class="exit save" url="[action:'list',controller:'comanda']"><g:img uri="/images/gestion_pedidos_01.png" align="absmiddle"/>
              Comandes en Proces/Pendents
            </g:link></li>
        <li><g:link class="exit save" url="[action:'llistaServides',controller:'comanda']"><g:img uri="/images/fragoneta.gif" align="absmiddle"/>
              Comandes Servides
            </g:link></li>
        </ul>
      </div>
    </div>
  </body>
</html>
