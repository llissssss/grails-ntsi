
<%@ page import="productes.Producte" %>
<!doctype html>
<html>
  <head>
    <meta name="layout" content="comprar">
    <title>CISTELLS</title>
  <g:javascript library="jquery"/>
</head>
<body>

  <div class="cistellafinal">
  <h1 class="titolLogin2">COMANDA</h1>
<g:form controller="Cistella" >  
  <div class="EnviamentComanda2">
    <div class="titolsmostrarCom">
    <legend>Dades Enviament</legend>
    </div>
    <div class="fieldcontain ${hasErrors(bean: session.dadesEnvia, field: 'nom', 'error')} required">
      <label for="nom">Nom<span class="required-indicator">*</span></label>
      <g:textField name="nom" readonly="readonly" maxlength="30" required="" value="${session.dadesEnvia?.nom}"/>
    </div>
    <div class="fieldcontain ${hasErrors(bean: session.dadesEnvia, field: 'cognom', 'error')} required">
      <label for="cognom">Cognom<span class="required-indicator">*</span></label>
      <g:textField name="cognom" readonly="readonly" maxlength="30" required="" value="${session.dadesEnvia?.cognom}"/>
    </div>
    <div class="fieldcontain ${hasErrors(bean: session.dadesEnvia, field: 'ardeca', 'error')} required">
      <label for="adreca">Adreça<span class="required-indicator">*</span></label>
      <g:textField name="adreca" readonly="readonly" maxlength="200" required="" value="${session.dadesEnvia?.adreca}"/>
    </div>
    <div class="fieldcontain ${hasErrors(bean: session.dadesEnvia, field: 'poblacio', 'error')} required">
      <label for="poblacio">Poblacio<span class="required-indicator">*</span></label>
      <g:textField name="poblacio" readonly="readonly" maxlength="200" required="" value="${session.dadesEnvia?.poblacio}"/>
    </div>
     <div class="fieldcontain ${hasErrors(bean: session.dadesEnvia, field: 'metodeEnviament', 'error')} required">
      <label for="metodeEnviament">Enviament<span class="required-indicator">*</span></label>
      <g:textField name="metodeEnviament" readonly="readonly" maxlength="200" required="" value="${session.dadesEnvia?.metodeEnviament}"/>
    </div> 
  </div>
  <br>
  <div class="facturacioComanda2">
    <div class="titolsmostrarCom">
    <legend>Dades Facturacio</legend>
    </div>
    <div class="fieldcontain ${hasErrors(bean: session.usuari, field: 'nom', 'error')} required">
      <label for="nom">Nom<span class="required-indicator">*</span></label>
      <g:textField name="nom" readonly="readonly" maxlength="30" required="" value="${session.usuari?.nom}"/>
    </div>
    <div class="fieldcontain ${hasErrors(bean: session.usuari, field: 'cognom', 'error')} required">
      <label for="cognom">Cognom<span class="required-indicator">*</span></label>
      <g:textField name="cognom" readonly="readonly" maxlength="30" required="" value="${session.usuari?.cognom}"/>
    </div>
    <div class="fieldcontain ${hasErrors(bean: session.usuari, field: 'nif', 'error')} required">
      <label for="nif">Nif<span class="required-indicator">*</span></label>
      <g:textField name="nif" readonly="readonly" maxlength="9" required="" value="${session.usuari?.nif}"/>
    </div>
    <div class="fieldcontain ${hasErrors(bean: session.usuari, field: 'ardeca', 'error')} required">
      <label for="adreca">Ad. fiscal<span class="required-indicator">*</span></label>
      <g:textField name="adreca" readonly="readonly" maxlength="200" required="" value="${session.usuari?.adreca}"/>
    </div>
     <div class="fieldcontain ${hasErrors(bean: session.usuari, field: 'poblacio', 'error')} required">
      <label for="poblacio">Poblacio<span class="required-indicator">*</span></label>
      <g:textField name="poblacio" readonly="readonly" maxlength="200" required="" value="${session.usuari?.poblacio}"/>
    </div>
  </div>
   <div class="titolsmostrarCom2">
    <h1>Llista de productes</h1>
   </div>
    <g:if test="${flash.message}">
      <div class="message" role="status"><g:message code="${flash.message}" args="${flash.args}"/></div>
    </g:if>

    
    <div class="taulacistella2">
    <table>
      
        <tr>
          <td class="categProd">Imatge</td>
          <td class="categProd">Categoria</td>
          <td class="categProd">SubCategoria</td>
          <td class="categProd">Nom</td>
          <td class="categProd">Desc.Comercial</td>
          <td class="categProd">Preu</td>
          <td class="categProd">Oferta</td>
          <td class="categProd">Preu Oferta</td>
          <td class="categProd">Quantitat</td>
          <td class="categProd">Preu Total</td>
        </tr>
    
    
          <tbody>
              <g:each in="${session.llistaProductes}" status="i" var="producteInstance">
          
              
                  <tr>
                    <td class="categProd2">
                      <g:if test="${!grailsApplication.mainContext.getResource('images/productes/'+producteInstance['producte'].getFitxerUrlImatge()).exists() }"><img src="${resource(dir: 'images/productes/', file: 'non_image.jpg')}" width="100" height="66" alt="${producteInstance['producte'].nom} no te imatge"/></g:if>
                      <g:else>
                        <img src="${resource(dir: 'images/productes/', file: producteInstance['producte'].getFitxerUrlImatge())}" width="100" height="66" alt="imatge inicial"/>
                      </g:else>
                    </td>
                    <td class="categProd2">${producteInstance['producte'].subcategoria.categoria}</td>
                    <td class="categProd2">${producteInstance['producte'].subcategoria}</td>
                    <td class="categProd2">${producteInstance['producte'].nom}</td>
                    <td class="categProd2">${producteInstance['producte'].descripcio_comercial.substring(0,250)}</td>
                    <td class="categProd2">${producteInstance['producte'].preu_cataleg}</td>
                    <td class="categProd2">${producteInstance['producte'].GetOferta()?.descompte}%</td>
                    <td class="categProd2">${producteInstance['producte'].getPreu()}</td>
                    <td class="categProd2">${producteInstance['quantitat']}</td>
                    <td class="categProd2">${producteInstance['quantitat']*producteInstance['producte'].getPreu()}</td>
                  </tr>
              </g:each>
            </tbody>
          </table>
     
    </div>
  </div>
    <div class="totalCompra2">
    <p>Total de la compra: ${session.cistellaTotal} €</p>
    </div>
    <div class="pagination">
      <g:paginate total="${10}" />
    </div>
  
  
  <fieldset class="buttons">
    <g:submitButton name="back" value="Back Dades Facturacio" />
    <g:submitButton name="comprar" value="COMPRAR" />
  </fieldset>
</g:form>

</body>
</html>
