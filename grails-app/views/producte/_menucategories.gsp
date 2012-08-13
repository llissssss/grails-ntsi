<%@ page import="productes.*" %>
<script type="text/javascript">
function ShowFills(jsonn, perdefecte)
{
  // TODO show spinnern
  var categoria = jsonn[0].categoria.id;
  if($('#subcat'+categoria).html().trim() != "")
  {
     $('#subcat'+categoria).html("");
  }
  else
  {
    for(var i = 0; i < jsonn.length; i++)
    {
      if(jsonn[i].id == perdefecte)
        $('#subcat'+categoria).append("<li class='seleccionada'>&raquo; <a href='${createLink(uri: '/producte/list')}?subcat=" + jsonn[i].id + "'>"+jsonn[i].nom+"</a></li>");
      else
        $('#subcat'+categoria).append("<li>&raquo; <a href='${createLink(uri: '/producte/list')}?subcat=" + jsonn[i].id + "'>"+jsonn[i].nom+"</a></li>");
    }
  }
  
}
</script>
<div id="blocEsquerra">
  <div id="menuEsquerra">
    <div id="itemMenuEsquerra">
      <div class="titolMenu">Categories</div><br clear='all'>
      <div>
        <ul class="llistaCategoria">
        <g:each in="${Categoria.list(sort:"nom")}" var="categoriaActualList">
          <li><g:remoteLink controller="categoria" update="[success: 'results']" onSuccess="ShowFills(data)" action="subcategories" id="${categoriaActualList.id}">${categoriaActualList.nom}</g:remoteLink></li>
          <ul class="llistaSubcategoria" id="subcat${categoriaActualList.id}"></ul>
          <g:if test="${params.subcat && categoriaActualList.id == Subcategoria.get(params.subcat).categoria.id}">
            <script type="text/javascript">
           $(document).ready(function() {
            ${remoteFunction(action: 'subcategories', controller: 'categoria', update: [success: 'results'],id: categoriaActualList.id, onSuccess:'ShowFills(data,'+params.subcat+')')}
          })</script>
          </g:if>
        </g:each>
        </ul>
      </div>
    </div>
    <br clear="all">
    <div id="itemMenuEsquerra">
      <div class="titolMenu">Cercar productes</div><br clear='all'>
      <div id="contingutItemMenuEsquerra">
        <g:form controller="producte" action="list" method="get">
          Nom<br>
          <input type="text" name="nom_producte" value="${params?.nom_producte}"><br><br>
          Preu entre <input type="text" class="smallinput" name="preu_min" value="${params?.preu_min}">€ i <input type="text" class="smallinput" name="preu_max" value="${params?.preu_max}">€<br><br>
          Categoria general<br>
          <g:select name="categoria" multiple="true" from="${Categoria.list()}" optionKey="id" value="${categoria*.id}" /><br><br>
          Categoria específica<br>
          <g:select name="subcategoria" multiple="true" from="${Subcategoria.list()}" optionKey="id" value="${subcategoria*.id}" /><br><br>
          <input type="submit" class="botoweb" name="cercarr" value="Cercar" />
        </g:form>
        <br clear="all">
      </div>
    </div>
    <br clear="all">
    <div id="itemMenuEsquerra">
      <div class="titolMenu">Cistella</div><br clear='all'>
      <div id="contingutItemMenuEsquerra">
        <g:link controller="cistella" action="veure"><img src="${resource(dir: 'images/', file: 'carrito.png')}" alt="imatge cistella" /></g:link>
        <u><b>Resum</b></u><br>
        <g:if test="${session.cistella}">
          <i>Tens ${session.cistella.size()} productes.</i>
          <br><br>
          <b>Total: </b>${session.cistellaTotal}€<br><br>
          <g:link controller="cistella" action="comprar"> <img src="${resource(dir: 'images/', file: 'ok.png')}" alt="confirmar cistella" align="absmiddle" />&nbsp;&nbsp;Finalitzar compra</g:link><br clear="all">
          <g:link controller="cistella" action="eliminar"> <img src="${resource(dir: 'images/', file: 'delete2.png')}" alt="esborrar cistella" align="absmiddle" />&nbsp;&nbsp;Eliminar cistella</g:link><br>
        </g:if>
        <g:else>
          <br>
          <i>(cistella buida)</i>
        </g:else>
        <br clear="all">
      </div>
    </div>
  </div>
</div>