<%@ page import="Compres.Comanda" %>



<div class="fieldcontain ${hasErrors(bean: comandaInstance, field: 'usuari', 'error')} required">
	<label for="usuari">
		<g:message code="comanda.usuari.label" default="Usuari" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="usuari" name="usuari.id" from="${Usuaris.Usuari.list()}" optionKey="id" required="" value="${comandaInstance?.usuari?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: comandaInstance, field: 'data', 'error')} required">
	<label for="data">
		<g:message code="comanda.data.label" default="Data" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="data" precision="day"  value="${comandaInstance?.data}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: comandaInstance, field: 'metodeEnviament', 'error')} required">
	<label for="metodeEnviament">
		<g:message code="comanda.metodeEnviament.label" default="Metode Enviament" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="metodeEnviament" maxlength="50" required="" value="${comandaInstance?.metodeEnviament}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: comandaInstance, field: 'adreca', 'error')} required">
	<label for="adreca">
		<g:message code="comanda.adreca.label" default="Adreca" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="adreca" maxlength="200" required="" value="${comandaInstance?.adreca}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: comandaInstance, field: 'estat', 'error')} required">
	<label for="estat">
		<g:message code="comanda.estat.label" default="Estat" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="estat" required="" value="${comandaInstance?.estat}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: comandaInstance, field: 'adreca_fact', 'error')} ">
	<label for="adreca_fact">
		<g:message code="comanda.adreca_fact.label" default="Adrecafact" />
		
	</label>
	<g:textField name="adreca_fact" value="${comandaInstance?.adreca_fact}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: comandaInstance, field: 'cognom_env', 'error')} ">
	<label for="cognom_env">
		<g:message code="comanda.cognom_env.label" default="Cognomenv" />
		
	</label>
	<g:textField name="cognom_env" value="${comandaInstance?.cognom_env}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: comandaInstance, field: 'cognom_fact', 'error')} ">
	<label for="cognom_fact">
		<g:message code="comanda.cognom_fact.label" default="Cognomfact" />
		
	</label>
	<g:textField name="cognom_fact" value="${comandaInstance?.cognom_fact}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: comandaInstance, field: 'linies_comanda', 'error')} ">
	<label for="linies_comanda">
		<g:message code="comanda.linies_comanda.label" default="Liniescomanda" />
		
	</label>
	<g:select name="linies_comanda" from="${Compres.LiniesComanda.list()}" multiple="multiple" optionKey="id" size="5" value="${comandaInstance?.linies_comanda*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: comandaInstance, field: 'nif_fact', 'error')} ">
	<label for="nif_fact">
		<g:message code="comanda.nif_fact.label" default="Niffact" />
		
	</label>
	<g:textField name="nif_fact" value="${comandaInstance?.nif_fact}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: comandaInstance, field: 'nom_env', 'error')} ">
	<label for="nom_env">
		<g:message code="comanda.nom_env.label" default="Nomenv" />
		
	</label>
	<g:textField name="nom_env" value="${comandaInstance?.nom_env}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: comandaInstance, field: 'nom_fact', 'error')} ">
	<label for="nom_fact">
		<g:message code="comanda.nom_fact.label" default="Nomfact" />
		
	</label>
	<g:textField name="nom_fact" value="${comandaInstance?.nom_fact}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: comandaInstance, field: 'poblacio_env', 'error')} ">
	<label for="poblacio_env">
		<g:message code="comanda.poblacio_env.label" default="Poblacioenv" />
		
	</label>
	<g:textField name="poblacio_env" value="${comandaInstance?.poblacio_env}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: comandaInstance, field: 'poblacio_fact', 'error')} ">
	<label for="poblacio_fact">
		<g:message code="comanda.poblacio_fact.label" default="Poblaciofact" />
		
	</label>
	<g:textField name="poblacio_fact" value="${comandaInstance?.poblacio_fact}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: comandaInstance, field: 'preu_total', 'error')} required">
	<label for="preu_total">
		<g:message code="comanda.preu_total.label" default="Preutotal" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="preu_total" required="" value="${fieldValue(bean: comandaInstance, field: 'preu_total')}"/>
</div>

