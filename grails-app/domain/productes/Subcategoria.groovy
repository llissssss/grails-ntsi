package productes

class Subcategoria
{
    String nom;
    Categoria categoria;
    static constraints = {
        nom(blank: false, unique:true, maxSize:50)
    }
    
    String toString() { nom }
    
}
