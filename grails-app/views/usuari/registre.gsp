<%@ page import="Usuaris.Usuari" %>
<!doctype html>
<html>
  <head>
    <meta name="layout" content="main" />
    <title>Registre nou usuari</title>
  </head>
  <body>
   <div id="formUser">
      <h1 class="titolLogin">Registre nou usuari</h1>
      <g:hasErrors bean="${usuari}">
        <ul class="errors" role="alert">
          <g:eachError bean="${usuari}" var="error">
            <li ${error in org.springframework.validation.FieldError?'data-field-id="'+error.field+'"':''}><g:message error="${error}"/></li>
          </g:eachError>
        </ul>
      </g:hasErrors>
     
      <g:form controller="usuari" action="registre">

          <div class="fieldcontain ${hasErrors(bean: usuari, field: 'nom', 'error')} required">
            <label for="nom">Nom<span class="required-indicator">*</span></label>
            <g:textField name="nom" maxlength="30" required="" value="${usuari?.nom}"/>
          </div>
          <div class="fieldcontain ${hasErrors(bean: usuari, field: 'cognom', 'error')} required">
            <label for="cognom">Cognom<span class="required-indicator">*</span></label>
            <g:textField name="cognom" maxlength="30" required="" value="${usuari?.cognom}"/>
          </div>
          <div class="fieldcontain ${hasErrors(bean: usuari, field: 'nif', 'error')} required">
            <label for="nif">Nif<span class="required-indicator">*</span></label>
            <g:textField name="nif" maxlength="9" required="" value="${usuari?.nif}"/>
          </div>
          <div class="fieldcontain ${hasErrors(bean: usuari, field: 'ardeca', 'error')} required">
            <label for="adreca">Adreça<span class="required-indicator">*</span></label>
            <g:textField name="adreca" maxlength="200" required="" value="${usuari?.adreca}"/>
          </div>
          <div class="fieldcontain ${hasErrors(bean: usuari, field: 'poblacio', 'error')} required">
            <label for="poblacio">Poblacio<span class="required-indicator">*</span></label>
            <g:textField name="poblacio" maxlength="200" required="" value="${usuari?.poblacio}"/>
          </div>
          <div class="fieldcontain ${hasErrors(bean: usuari, field: 'data_naixement', 'error')} required">
            <label for="data_naixement">Data Naixement<span class="required-indicator">*</span></label>
            <g:datePicker name="data_naixement" maxlength="10" required="" precision="day" years="${1930..2012}" value="${usuari?.data_naixement}"/>
          </div>
          <div class="fieldcontain ${hasErrors(bean: usuari, field: 'sexe', 'error')} required">
            <label for="sexe">Sexe</label>
            
            <g:select name="sexe" from="${['H','D']}" value="${usuari?.sexe}"/>
            
          </div>
          <div class="fieldcontain ${hasErrors(bean: usuari, field: 'email', 'error')} required">
            <label for="email">email</label><span class="required-indicator">*</span>
            <g:textField name="email" maxlength="50" required="" value="${usuari?.email}"/>
          </div>
          <div class="fieldcontain ${hasErrors(bean: usuari, field: 'login', 'error')} required">
            <label for="login">login<span class="required-indicator">*</span></label>
            <g:textField name="login" maxlength="10" required="" value="${usuari?.login}"/>
          </div>
          <div class="fieldcontain ${hasErrors(bean: usuari, field: 'password', 'error')} required">
            <label for="password">password<span class="required-indicator">*</span></label>
            <g:passwordField name="password" maxlength="10" required="" value=""/>
          </div>
          <div class="fieldcontain ${hasErrors(bean: usuari, field: 'password2', 'error')} required">
            <label for="password2">Confirmar pass<span class="required-indicator">*</span></label>
            <g:passwordField name="password2" maxlength="10" required="" value=""/>
          </div><br>
        <div id="botoRegistre">
          <g:submitButton name="registre" value="Registrar" class="botoRegistre botoweb"/>
        </div>
      </g:form>
    </div>
   
  </body>
</html>
