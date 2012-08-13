<!doctype html>
<html>
  <head>
    <title>Comandes - Opcions</title>
    <meta name="layout" content="cistella">
  </head>
  <body>

    <div id="missatge-error" class="content scaffold-show" role="main">
      <h1>Escull una opcio:</h1>
      <g:if test="${flash.message}">
        <br>
        <div class="message" role="status"><g:message code="${flash.message}" args="${flash.args}"/></div>
        <br>
      </g:if>
      <div class="taulaGestio">
        <g:uploadForm>
          <br clear="all">
          <ul>
            <li>
              <label for="dataIni">Data Inicial</label>
            <g:datePicker name="data_ini" precision="day" value="${new Date()}" years="${1930..2012}" noSelection="['':'-Choose-']"/>
            </li>
            <li>
              <label for="dataFi">Data Final</label>
            <g:datePicker name="data_fi" precision="day" value="${new Date()}" years="${1930..2012}" noSelection="['':'-Choose-']"/>
            </li>
          </ul>
          <fieldset class="buttons">
            <g:actionSubmit name="Finalitzar" value="Generar LListat" controller="administracio" action="list"/>
        </fieldset>
        </g:uploadForm>
      </div>
        
     
    </div>
  </body>
</html>
