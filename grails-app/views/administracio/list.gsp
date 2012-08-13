
<%@ page import="productes.Producte" %>
<!doctype html>
<html>
  <head>
    <meta name="layout" content="cistella">
    <title>CISTELLS</title>
  <g:javascript library="jquery"/>
</head>
<body>

  <div class="cistellafinal">
  <h1 class="titolLogin2">Llistat de Facturacio</h1>
  <g:if test="${flash.message}">
      <div class="message" role="status"><g:message code="${flash.message}" args="${flash.args}"/></div>
  </g:if>
  <div class="EnviamentComanda2">
    <div class="titolsmostrarCom5">
    <legend>Període Seleccionat</legend>
    </div>
    <div>
      <label for="data_ini">Data Inici:<span class="required-indicator">*</span></label>
      <g:formatDate format="dd-MM-yyyy" date="${data_ini}"/>
    </div>
    <div>
      <label for="data_fi">Data Final:<span class="required-indicator">*</span></label>
      <g:formatDate format="dd-MM-yyyy" date="${data_fi}"/>
    </div>   
  </div>
  <br>
    <g:if test="${flash.message}">
      <div class="message" role="status"><g:message code="${flash.message}" args="${flash.args}"/></div>
    </g:if>
<g:form controller="administracio" >     
    <div class="taulacistella3">
    <table>
      
        <tr>
          <td class="categProd">Nom Client</td>
          <td class="categProd">NIF Client</td>
          <td class="categProd">id Comanda</td>
          <td class="categProd">Data</td>
          <td class="categProd">Total </td>
        </tr>
    
    
          <tbody>
              <g:each in="${llistaComandes}" status="i" var="comandaInstance">
          
              
                  <tr>
                    <td class="categProd2">${comandaInstance.usuari.nom}</td>
                    <td class="categProd2">${comandaInstance.usuari.nif}</td>
                    <td class="categProd2">${comandaInstance.id}</td>
                    <td class="categProd2"><g:formatDate format="dd-MM-yyyy" date="${comandaInstance.data}"/></td>
                    <td class="categProd2">${comandaInstance.preu_total} €</td>
                  </tr>
              </g:each>
            </tbody>
          </table>
     
    </div>
  </div>
    <div class="pagination">
      <g:paginate action="list" total="${comandaInstanceTotal}"/>
    </div>
  
  <fieldset class="buttons">
    <g:actionSubmit value="Retornar" action="formulariEscull" />
    <a href="${createLink(uri: '/administracio/generarCSV')}" target="_blank">Crear Arxiu CSV</a>
  </fieldset>
</g:form>

</body>
</html>
