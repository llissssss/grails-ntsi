/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package productes

/**
 *
 * @author albert
 */
class CategoriaController
{
    def index() { }
    
    def subcategories()
    {
        if (params.id)
        {
            def cat = Categoria.get(params.id)
            if (cat)
            {
                def sc = cat.subcategories;
                render(contentType:"text/json")
                {
                    sc
                }
            }
            else
            {
                response.sendError(403)
            }
        }
        else
        {
            response.sendError(403)
        }
    }
}

