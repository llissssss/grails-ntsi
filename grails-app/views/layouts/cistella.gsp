<!doctype html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html lang="en" class="no-js"><!--<![endif]-->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title><g:layoutTitle default="Grails"/></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon">
		<link rel="apple-touch-icon" href="${resource(dir: 'images', file: 'apple-touch-icon.png')}">
		<link rel="apple-touch-icon" sizes="114x114" href="${resource(dir: 'images', file: 'apple-touch-icon-retina.png')}">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'main.css')}" type="text/css">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'mobile.css')}" type="text/css">
		<g:layoutHead/>
        <r:layoutResources />
	</head>
	<body>
		<div id="grailsLogo" role="banner">
                    <a href="${createLink(uri: '/')}"><img src="${resource(dir: 'images', file: 'logo.png')}" alt="Grails"/></a>
                    <!--<div id="cistella" role="banner">
                         <a href="${createLink(uri: '/cistella/veure')}"><img src="${resource(dir: 'images', file: 'cistella_petita.png')}" alt="Cistella"/></a>
                    </div>-->
                </div>
                <div id="menuSuperior">
                  <div style="float:left">
                    <div class="itemMenuSuperior"><a href="${createLink(uri: '/')}">Home</a></div>
                    <div class="itemMenuSuperior"><a href="${createLink(uri: '/producte/list')}">Catàleg de productes</a></div>
                    <g:if test="${!session.usuari}"><div class="itemMenuSuperior"><a href="${createLink(uri: '/usuari/registre')}">Registrar</a></div></g:if>
                  </div>
                  <div style="float:right">
                           <g:if test="${session.usuari}">
                              <div class="itemMenuSuperiorAdmin">
                                Connectat com: ${session.usuari?.nom} ${session.usuari?.cognom}&nbsp;&nbsp;&nbsp;
                              </div>
                              <g:if test="${session.usuari.rol=="client"}">
                                <div class="itemMenuSuperiorAdmin"><g:link controller="comandes" action="veure" img="">Comandes pendents</g:link></div>
                              </g:if>
                              <g:if test="${session.usuari.rol=="magatzem"}">
                                <div class="itemMenuSuperiorAdmin"><g:link controller="comanda" >Gestio de comandes</g:link></div>
                              </g:if>
                              <g:if test="${session.usuari.rol=="comercial"}">
                                <div class="itemMenuSuperiorAdmin"><g:link controller="producteGestio" >Gestio de productes</g:link></div>
                              </g:if>
                              <g:if test="${session.usuari.rol=="administracio"}">
                                <div class="itemMenuSuperiorAdmin"><g:link controller="administracio" >Llistats facturacio</g:link></div>
                              </g:if>
                              <div class="itemMenuSuperiorAdmin">
                                <g:link controller="usuari" action="logout">logout</g:link>
                              </div>
                           </g:if>
                           <g:else>
                              <g:form controller="usuari" action="login">
                                <div class="loginMenuSuperior">
                                  <label for="login">Login</label>
                                  <g:textField name="login" maxlength="10" size="12" value="${usuari?.login}"/>
                                </div>
                                <div class="loginMenuSuperior">
                                  <label for="password">Password</label>
                                  <g:passwordField name="password" maxlength="10" size="12" value=""/>
                                </div>
                                <div class="loginMenuSuperior">
                                  <g:submitButton name="entrar" class="save botoweb" value="Entrar" />
                                </div>
                               </g:form>
                           </g:else>
                  </div>
                </div>
                <div style="clear:both;"></div>
                <g:layoutBody/>
               
		<div class="footer" role="contentinfo"><a href="${createLink(controller:'documentacio')}">Link a documentació</a></div>
		<div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt" default="Loading&hellip;"/></div>
		<g:javascript library="application"/>
        <r:layoutResources />
	</body>
</html>