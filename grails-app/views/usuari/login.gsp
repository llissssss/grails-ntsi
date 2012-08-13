<%@ page import="Usuaris.Usuari" %>
<!doctype html>
<html>
  <head>
    <meta name="layout" content="main" />
    <title>Login</title>
  </head>
  <body>
<div id="formLogin">
    <h1 class="titolLogin">Login Usuari</h1>
  <g:hasErrors bean="${dades}">
    <ul class="errors" role="alert">
      <g:eachError bean="${dades}" var="error">
        <li ${error in org.springframework.validation.FieldError?'data-field-id="'+error.field+'"':''}><g:message error="${error}"/></li>
      </g:eachError>
    </ul>
  </g:hasErrors>
  <g:form controller="usuari" action="login">
    <div class="form">
      <div class="fieldcontain ${hasErrors(bean: dades, field: 'login', 'error')} required">
        <label for="login">Login<span class="required-indicator">*</span></label>
        <g:textField name="login" maxlength="10" required="" value="${dades?.login}"/>
      </div>
      <div class="fieldcontain ${hasErrors(bean: dades, field: 'password', 'error')} required">
        <label for="password">Password<span class="required-indicator">*</span></label>
        <g:passwordField name="password" maxlength="10" required="" value=""/>          </div>
    </div>
    <div id="botoLogin">
      <g:submitButton name="entrar" class="save botoweb" value="Entrar" />
    </div>
  </g:form>
</div>

</body>
</html>
