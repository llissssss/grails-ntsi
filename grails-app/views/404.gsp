<!doctype html>
<html>
  <head>
    <title>Contactes - Error 403</title>
    <meta name="layout" content="cistella">
  </head>
  <body>
    
    <div id="missatge-error" class="content scaffold-show" role="main">
      <h1>Error 403</h1>
      <div class="cistellabuida3">
          <ul class="errors">
             <g:if test="${flash.message}">
               <div class="message" role="status"><li>${flash.message}</li></div>
             </g:if>
          </ul>

      </div>
      <fieldset class="buttons">
              <g:link class="exit save" url="[action:'ofertes',controller:'producte']">
                Continuar Comprant
              </g:link>
          </fieldset>
    </div>
  </body>
</html>
