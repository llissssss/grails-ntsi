
<%@ page import="productes.Producte" %>
<!doctype html>
<html>
  <head>
    <meta name="layout" content="comprar">
    <title>CISTELLS</title>
  <g:javascript library="jquery"/>
</head>
<body>
  <h1 class="titolLogin">Dades Enviament</h1>
<g:hasErrors bean="${session.dadesEnvia}">
  <ul class="errors" role="alert">
    <g:eachError bean="${session.dadesEnvia}" var="error">
      <li ${error in org.springframework.validation.FieldError?'data-field-id="'+error.field+'"':''}><g:message error="${error}"/></li>
    </g:eachError>
  </ul>
</g:hasErrors>
<g:form controller="Cistella">
  <div class="EnviamentComanda">
    <div class="fieldcontain ${hasErrors(bean: session.dadesEnvia, field: 'nom', 'error')} required">
      <label for="nom">Nom<span class="required-indicator">*</span></label>
      <g:textField name="nom" maxlength="30" required="" value="${session.dadesEnvia?.nom}"/>
    </div>
    <div class="fieldcontain ${hasErrors(bean: session.dadesEnvia, field: 'cognom', 'error')} required">
      <label for="cognom">Cognom<span class="required-indicator">*</span></label>
      <g:textField name="cognom" maxlength="30" required="" value="${session.dadesEnvia?.cognom}"/>
    </div>
    <div class="fieldcontain ${hasErrors(bean: session.dadesEnvia, field: 'ardeca', 'error')} required">
      <label for="adreca">Adreça<span class="required-indicator">*</span></label>
      <g:textField name="adreca" maxlength="200" required="" value="${session.dadesEnvia?.adreca}"/>
    </div>
    <div class="fieldcontain ${hasErrors(bean: session.dadesEnvia, field: 'poblacio', 'error')} required">
      <label for="poblacio">Poblacio Enviament<span class="required-indicator">*</span></label>
      <g:textField name="poblacio" maxlength="200" required="" value="${session.dadesEnvia?.poblacio}"/>
    </div>
    <div class="fieldcontain ${hasErrors(bean: session.dadesEnvia, field: 'metodeEnviament', 'error')} required">
            <label for="metodeEnviament">Metode Enviament<span class="required-indicator">*</span></label>
            <g:select name="metodeEnviament" from="${['UPS','FedEX']}" value="${session.dadesEnvia?.metodeEnviament}"/>
    </div>
  </div>

  <fieldset class="buttons">
    <g:submitButton name="back" value="Back Cistella" />
    <g:submitButton name="seguirComanda" value="Continuar" />
  </fieldset>
</g:form>

</body>
</html>
