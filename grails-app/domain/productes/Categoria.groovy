package productes

class Categoria
{
    String nom;
    static constraints = {
        nom(blank: false, unique:true, maxSize:50)
    }
    static hasMany = [subcategories:Subcategoria]
    
    static mapping = {
        subcategories sort:'nom', order:'asc'
    }

    
    String toString() { nom }
}
