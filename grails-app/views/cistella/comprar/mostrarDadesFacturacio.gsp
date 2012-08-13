
<%@ page import="productes.Producte" %>
<!doctype html>
<html>
  <head>
    <meta name="layout" content="comprar">
    <title>CISTELLS</title>
  <g:javascript library="jquery"/>
</head>
<body>
  <h1 class="titolLogin">Dades Facturacio</h1>
<g:hasErrors bean="${session.usuari}">
  <ul class="errors" role="alert">
    <g:eachError bean="${session.usuari}" var="error">
      <li ${error in org.springframework.validation.FieldError?'data-field-id="'+error.field+'"':''}><g:message error="${error}"/></li>
    </g:eachError>
  </ul>
</g:hasErrors>
<g:form controller="Cistella">
  <div class="facturacioComanda">
    <div class="fieldcontain ${hasErrors(bean: session.usuari, field: 'nom', 'error')} required">
      <label for="nom">Nom<span class="required-indicator">*</span></label>
      <g:textField name="nom" maxlength="30" required="" value="${session.usuari?.nom}"/>
    </div>
    <div class="fieldcontain ${hasErrors(bean: session.usuari, field: 'cognom', 'error')} required">
      <label for="cognom">Cognom<span class="required-indicator">*</span></label>
      <g:textField name="cognom" maxlength="30" required="" value="${session.usuari?.cognom}"/>
    </div>
    <div class="fieldcontain ${hasErrors(bean: session.usuari, field: 'nif', 'error')} required">
      <label for="nif">Nif<span class="required-indicator">*</span></label>
      <g:textField name="nif" maxlength="9" required="" value="${session.usuari?.nif}"/>
    </div>
    <div class="fieldcontain ${hasErrors(bean: session.usuari, field: 'ardeca', 'error')} required">
      <label for="adreca">Adreça fiscal<span class="required-indicator">*</span></label>
      <g:textField name="adreca" maxlength="200" required="" value="${session.usuari?.adreca}"/>
    </div>
    <div class="fieldcontain ${hasErrors(bean: session.usuari, field: 'poblacio', 'error')} required">
      <label for="poblacio">Poblacio factura<span class="required-indicator">*</span></label>
      <g:textField name="poblacio" maxlength="200" required="" value="${session.usuari?.poblacio}"/>
    </div>
  </div>

  <fieldset class="buttons">
    <g:submitButton name="back" value="Back Dades Enviament" />
    <g:submitButton name="seguirComanda" value="Continuar" />
  </fieldset>
</g:form>

</body>
</html>
