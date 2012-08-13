
<%@ page import="productes.Producte" %>
<!doctype html>
<html>
  <head>
    <meta name="layout" content="cistella">
    <title>Servir Comanda</title>
  <g:javascript library="jquery"/>

</head>
<body>
  <script type="text/javascript">
      function Prova()
      {
      //alert("dins");
        var valor = $('#estat').val();
        if(valor!='pendent de stock') $('#hola').slideUp(); else  $('#hola').slideDown();
      }
  </script>
  <div class="servirComanda">
    <h1 class="titolLogin3">Servir Comanda</h1>
    <g:form controller="comanda" >
      <div class="FormDadesEnviament">
        <div class="titolsmostrarCom">
          <legend>Dades Enviament</legend>
        </div>
        <div class="fieldcontain ${hasErrors(bean: comandaSelection, field: 'nom_env', 'error')} required">
          <label for="nom">Nom<span class="required-indicator">*</span></label>
          <g:textField name="nom_env" readonly="readonly" maxlength="100" required="" value="${comandaSelection.nom_env}"/>
        </div>
        <div class="fieldcontain ${hasErrors(bean: comandaSelection, field: 'cognom_env', 'error')} required">
          <label>Cognom<span class="required-indicator">*</span></label>
          <g:textField name="cognom_env" readonly="readonly" maxlength="100" required="" value="${comandaSelection.cognom_env}"/>
        </div>
        <div class="fieldcontain ${hasErrors(bean: comandaSelection, field: 'ardeca', 'error')} required">
          <label>Adreça<span class="required-indicator">*</span></label>
          <g:textField name="adreca" readonly="readonly" maxlength="200" required="" value="${comandaSelection.adreca}"/>
        </div>
        <div class="fieldcontain ${hasErrors(bean: comandaSelection, field: 'poblacio_env', 'error')} required">
          <label>Poblacio<span class="required-indicator">*</span></label>
          <g:textField name="poblacio_env" readonly="readonly" maxlength="200" required="" value="${comandaSelection.poblacio_env}"/>
        </div>
        <div class="fieldcontain ${hasErrors(bean: comandaSelection, field: 'metodeEnviament', 'error')} required">
          <label>Enviament<span class="required-indicator">*</span></label>
          <g:textField name="metodeEnviament" readonly="readonly" maxlength="200" required="" value="${comandaSelection.metodeEnviament}"/>
        </div>
      </div>
      <br>
      <div class="titolsmostrarCom3">
        <h1>Llista de productes</h1>
      </div>
      <g:if test="${flash.message}">
        <div class="message" role="status"><g:message code="${flash.message}" args="${flash.args}"/></div>
      </g:if>



      <table class="taulaComandesPendent">

        <tr>
          <td class="categProd2">IdProducte</td>
          <td class="categProd2">Producte</td>
          <td class="categProd2">Quantitat</td>
        </tr>


        <tbody>
        <g:each in="${comandaSelection.linies_comanda}" status="i" var="producteInstance">
          <tr>
            <td class="categProd2">${producteInstance.idProducte}</td>
            <td class="categProd2">${producteInstance.producte}</td>
            <td class="categProd2">${producteInstance.quantitat}</td>
          </tr>
        </g:each>
        </tbody>
      </table>


  </div>
  <div class="pagination">
    <g:paginate total="${10}" />
  </div>

  <div class="fieldcontain ${hasErrors(bean: comandaSelection, field: 'estat', 'error')} required">
    <div class="lblestatComanda">
      <label for="estat">Estat Comanda<span class="required-indicator">*</span></label>
      <g:select name="estat" onchange="javascript:Prova();" from="${['en proces','pendent de stock','servida']}" value="${comandaSelection.estat}"/>
    </div>
  </div>
  <div id="hola">
    <div class="lblestatComanda">
      <label for="data">Data</label>
      <g:datePicker name="data_recepcio" precision="day" value="${new Date()}" years="${1930..2012}" noSelection="['':'-Choose-']"/>
      <div>
        <label for="lliure">Camp lliure<span class="required-indicator">*</span></label>
        <g:textField name="lliure" maxlength="200" value="${comandaSelection.lliure}" />
        <br><br>
      </div>
    </div>
  </div>
  <fieldset class="buttons">
    <g:actionSubmit name="Finalitzar" value="Finalitzar" controller="Comanda" action="finalitzarServir"/>
  </fieldset>
</g:form>
    <script>
      Prova();
    </script>
</body>
</html>
