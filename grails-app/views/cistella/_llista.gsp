
  <div id="list-contacte" class="content scaffold-list" role="main">

    <h1>Llista de productes</h1>
      <g:if test="${flash.message}">
        <div class="message" role="status"><g:message code="${flash.message}" args="${flash.args}"/></div>
      </g:if>
          
              <table class="taulallistat">
                  <tr>
                    <td class="categProd">Imatge</td>
                    <td class="categProd">Categoria</td>
                    <td class="categProd">SubCategoria</td>
                    <td class="categProd">Nom</td>
                    <td class="categProd">Descripcio</td>
                    <td class="categProd">Preu Cataleg</td>
                    <td class="categProd">Oferta</td>
                    <td class="categProd">Preu Oferta</td>
                    <td class="categProd">Quantitat</td>
                    <td class="categProd">Preu Total</td>
                    <td class="categProd">Detall</td>
                  </tr>

            <tbody>
            <g:each in="${cistellaProductes}" status="i" var="producteInstance">

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
                        <td class="categProd2">${producteInstance['producte'].descripcio_comercial.substring(0,100)}</td>
                        <td class="categProd2">${producteInstance['producte'].preu_cataleg}</td>
                        <g:if test="${producteInstance['producte'].GetOferta()==null}">
                          <td class="categProd2">0%</td>
                        </g:if>
                        <g:else>
                          <td class="categProd2">${producteInstance['producte'].GetOferta()?.descompte}%</td>
                        </g:else>
                        <td class="categProd2">${producteInstance['producte'].getPreu()}</td>
                        <td class="categProd2">${producteInstance['quantitat']}
                        <g:form controller="Cistella" >
                          <div class="updown">
                            <g:submitToRemote class="buttons" value="+" update="llistaProductes" action="upQuantitat" id="${producteInstance['producte'].id}"/>
                            <g:if test="${cistellaProductes.size()==1 && producteInstance['quantitat']==1}">
                              <g:hiddenField name="id" value="${producteInstance['producte'].id}"/>
                              <g:actionSubmit value="- " action="downQuantitat"/>
                            </g:if>
                            <g:else>
                              <g:submitToRemote class="buttons" value="- " update="llistaProductes" action="downQuantitat" id="${producteInstance['producte'].id}"/>
                            </g:else>
                          </div>
                        </g:form>
                        </td>
                        <td class="categProd2">${producteInstance['quantitat']*producteInstance['producte'].getPreu()}</td>
                        <td class="categProd2"><g:link update="llistaProductes" controller="producte" action="detall" id="${producteInstance['producte'].id}">detall</g:link></td>
                        <td class="categProd2">
                          <g:form controller="Cistella" >
                            <g:if test="${cistellaProductes.size()==1}">
                              <g:hiddenField name="id" value="${producteInstance['producte'].id}"/>
                              <g:actionSubmit value="Borrar" action="treureProducte"/>
                            </g:if>
                            <g:else>
                              <g:submitToRemote class="delete botoweb" value="Borrar" update="llistaProductes" action="treureProducte" id="${producteInstance['producte'].id}"/>
                            </g:else>
                          </g:form>
                        </td>
                      </tr>
                </g:each>
              </tbody>
             </table>
            
         

    </div>
      
 
<div class="totalCompra">
  <p>Total de descompte: ${totalDescompte} €</p>
  <p>Total de la compra: ${totalCistella} €</p>
</div>
<br clear="all">
    <div class="pagination">
     <g:paginate total="${10}" />
    </div>