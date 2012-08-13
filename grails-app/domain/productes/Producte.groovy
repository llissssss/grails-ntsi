package productes
import java.math.*;
class Producte
{
    String nom;
    Subcategoria subcategoria;
    String descripcio_comercial;
    String descripcio_detallada;
    BigDecimal preu_cataleg;
    Date data_alta;
    Date data_baixa;
    static hasMany = [ofertes:Oferta]
    static constraints = {
        nom(blank: false, maxSize:50)
        subcategoria(nullable: false)
        descripcio_comercial(maxSize:1000)
        descripcio_detallada(maxSize:1000)
        preu_cataleg(min:0.0)
        data_baixa(nullable:true)
    }

    def ara = new Date()
    
    Oferta GetOferta()
    {
        Iterator itr = ofertes.iterator();
        boolean trobat = false;
        Oferta of = null;
        while(itr.hasNext() && (of == null))
        {
            Oferta of2 = itr.next();
            if(of2.data_inici_oferta <= ara && (of2.data_fi_oferta >= ara || of2.data_fi_oferta == null)) of = of2;
        }
        return of;
    }
    
    BigDecimal getPreu()
    {
        Oferta o = this.GetOferta();
        if(o == null)
        {
	    return getPreuCataleg();
        }
        else
        {
            return round(o.CalcularPreuOferta(), 2, BigDecimal.ROUND_HALF_UP);
        }
    }

    BigDecimal getPreuCataleg()
    {
        //return preu_cataleg.round(new MathContext(2));
        return round(preu_cataleg, 2, BigDecimal.ROUND_HALF_UP);
    }

    public static BigDecimal round(double unrounded, int precision, int roundingMode)
    {
        BigDecimal bd = new BigDecimal(unrounded);
        BigDecimal rounded = bd.setScale(precision, roundingMode);
        return rounded;
    }
    @Override
    String toString() {
        return nom
    }
    
    static mapping = {
        ofertes sort:'data_inici_oferta', order:'desc'
    }

    def getFitxerUrlImatge() {
        return this.id + '.jpg'
    }
}
