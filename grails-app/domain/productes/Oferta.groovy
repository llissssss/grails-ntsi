package productes

class Oferta
{
    BigDecimal descompte;
    Date data_fi_oferta;
    Date data_inici_oferta;
    Producte producte;
    BigDecimal preu_oferta;
    static constraints =
    {
        descompte(min:0.0)
        producte(nullable:true)
        data_fi_oferta(nullable:true)
    }
    
    BigDecimal CalcularPreuOferta()
    {
        //return producte.preu_cataleg - (producte.preu_cataleg * (descompte / 100));
        return preu_oferta;
    }
    
    String DataFinal()
    {
        if(data_fi_oferta) return data_fi_oferta.format("dd/MM/yyyy");
        else return "";
    }
    
    String DataInicial()
    {
         if(data_inici_oferta) return data_inici_oferta.format("dd/MM/yyyy");
        else return "";
    }
}
