package shop


import productes.*
import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(CistellaController)
@Mock([Producte,Categoria,Subcategoria,Oferta])
class CistellaControllerTests {

    private void inicialitzacio() {
        // categories
                def c1 = new Categoria(nom:'Futbol').save()
                def c2 = new Categoria(nom:'Running').save()

                // subcategories
                def sc1 = new Subcategoria(nom:'Pilotes', categoria:c1).save()
                def sc2 = new Subcategoria(nom:'Samarretes equips', categoria:c1).save()

                def sc3 = new Subcategoria(nom:'Sabates', categoria:c2).save()
                def sc4 = new Subcategoria(nom:'Mitjons', categoria:c2).save()

                def sc5 = new Subcategoria(nom:'Sin nada', categoria:c1).save()
                def sc6 = new Subcategoria(nom:'Malles', categoria:c2).save()

                c1.addToSubcategories(sc1);
                c1.addToSubcategories(sc2);
                c1.addToSubcategories(sc5);

                c2.addToSubcategories(sc3);
                c2.addToSubcategories(sc4);
                c2.addToSubcategories(sc6);
                // productes i ofertes

                def of1 = new Oferta(descompte:10.0,data_inici_oferta:Date.parse('dd/MM/yyyy','04/05/2012'),data_fi_oferta:Date.parse('dd/MM/yyyy','09/06/2012'),actiu:true,preu_oferta:54.0).save()
                def of2 = new Oferta(descompte:15.0,data_inici_oferta:Date.parse('dd/MM/yyyy','09/05/2012'),data_fi_oferta:Date.parse('dd/MM/yyyy','22/06/2012'),actiu:true,preu_oferta:42.5).save()
                def of3 = new Oferta(descompte:10.0,data_inici_oferta:Date.parse('dd/MM/yyyy','29/05/2012'),data_fi_oferta:null,actiu:true,preu_oferta:102.6).save()
                def of4 = new Oferta(descompte:11.0,data_inici_oferta:Date.parse('dd/MM/yyyy','19/05/2012'),data_fi_oferta:Date.parse('dd/MM/yyyy','30/06/2012'),actiu:true,preu_oferta:6.57).save()
                def of5 = new Oferta(descompte:12.0,data_inici_oferta:Date.parse('dd/MM/yyyy','27/06/2012'),data_fi_oferta:Date.parse('dd/MM/yyyy','30/06/2012'),actiu:true,preu_oferta:42.5).save()

                def p1 = new Producte(nom:'Samarreta Barça 2012',
                                        subcategoria:sc2,
                                        descripcio_comercial:'El sistema mostra els productes de la cistella de lusuari. Els productes es presentenamb tota la ruta de categories a la que pertany, una foto, el nom, ladescripció comercial i el preu actual indicant lestalvi individual de cada producte,la quantitat del producte a la cistella i el preu total (quantitat per preu).Al final de la llista de productes de la cistella i trobem limport acumulat delpreu total i de lestalvi total per la cistella. Quan lusuari prem continuar compranttornem a la llista de productes don es provenia, encara que hagués passatper una fitxa de producte. A la llista es torna amb els filtres actius que hipogués haver i a la pàgina don provenia.',
                                        descripcio_detallada:'Lusuari escull un producte duna llista de productes. El sistema mostra tota la informació disponible del producte: el nom, la foto a màxima visualització, la descripció comercial, la descripció detallada, el preu de catàleg, el preu doferta i la finalització de la mateixa. Lusuari té la opció de tornar al llistat o de afegirel producte a la cistella sempre i quan es tracti dun visitant.',
                                        preu_cataleg:60.0,
                                        data_alta:Date.parse('dd/MM/yyyy','01/06/2012'),
                                        data_baixa:null)
                                        .addToOfertes(of1)
                                        .save(failOnError:true);
               def p2 =  new Producte(nom:'Samarreta Milan 2012',
                                        subcategoria:sc2,
                                        descripcio_comercial:'El personal de comercial gestionarà (altes, baixes i modificacions) el catàleg de productes i realitzarà les ofertes dels productes indicant-ne la durada, ampliantla o reduint-la quan calgui. Un mateix producte podrà tenir planificadesdiverses ofertes que no es poden solapar en el temps.El personal administració disposarà de la possibilitat de obtenir llistats defacturació sobre períodes variables, es podrà escollir el període que es vulgui.Un cop es visualitzi el llistat es podrà exportar el mateix en mode text amb les columnes separades per punt i comes. El llistat de facturació és un llistat acumulatper client de les comandes en el període indicat.De la mateixa manera, el personal de comercial, podrà treure llistats acumulats per categories o productes venuts entre dues dates indicades.',
                                        descripcio_detallada:'El sistema mostra un formulari de cerca on lsuari pot introduir el nom, una o varies categories de qualsevol nivell i/o el preu mínim i màxim dels productes que vol cercar. Lusuari pot introduir, si vol, dos paraules per el nom i el preu màxim. El sistema cerca al catàleg de productes aquells productes que tenen alnom les dues paraules de la cerca (en qualsevol ordre) i el preu actual de venda (el doferta o de catàleg) i mostra la llista dels productes. Luari pot avançar i retrocedir per totes les pàgines dels productes cercats. Els productes estaran ordenats tant per cent de descompte, data finalització oferta (primer aquells que caduca primer) i per nom. A totes les pàgines es mostra el formulari decerca omplert amb les dades que ha omplert lusuari.',
                                        preu_cataleg:50.0,
                                        data_alta:Date.parse('dd/MM/yyyy','01/06/2012'),
                                        data_baixa:null)
                                        .addToOfertes(of2)
                                        .addToOfertes(of5)
                                        .save(failOnError:true);

                def p3 = new Producte(nom:'Pilota Nike 2012',
                                        subcategoria:sc1,
                                        descripcio_comercial:'Aquesta pilota es la ostia neng. Els productes es presentenamb tota la ruta de categories a la que pertany, una foto, el nom, ladescripció comercial i el preu actual indicant lestalvi individual de cada producte,la quantitat del producte a la cistella i el preu total (quantitat per preu).Al final de la llista de productes de la cistella i trobem limport acumulat delpreu total i de lestalvi total per la cistella. Quan lusuari prem continuar compranttornem a la llista de productes don es provenia, encara que hagués passatper una fitxa de producte. A la llista es torna amb els filtres actius que hipogués haver i a la pàgina don provenia.',
                                        descripcio_detallada:'Pero la ostia en patinet. El sistema mostra tota la informació disponible del producte: el nom, la foto a màxima visualització, la descripció comercial, la descripció detallada, el preu de catàleg, el preu doferta i la finalització de la mateixa. Lusuari té la opció de tornar al llistat o de afegirel producte a la cistella sempre i quan es tracti dun visitant.',
                                        preu_cataleg:24.0,
                                        data_alta:Date.parse('dd/MM/yyyy','01/06/2012'),
                                        data_baixa:null)
                                        .save(failOnError:true);

                def p4 = new Producte(nom:'Asics Trabuco Gel',
                                        subcategoria:sc3,
                                        descripcio_comercial:'Aquesta pilota es la ostia neng. Els productes es presentenamb tota la ruta de categories a la que pertany, una foto, el nom, ladescripció comercial i el preu actual indicant lestalvi individual de cada producte,la quantitat del producte a la cistella i el preu total (quantitat per preu).Al final de la llista de productes de la cistella i trobem limport acumulat delpreu total i de lestalvi total per la cistella. Quan lusuari prem continuar compranttornem a la llista de productes don es provenia, encara que hagués passatper una fitxa de producte. A la llista es torna amb els filtres actius que hipogués haver i a la pàgina don provenia.',
                                        descripcio_detallada:'Pero la ostia en patinet. El sistema mostra tota la informació disponible del producte: el nom, la foto a màxima visualització, la descripció comercial, la descripció detallada, el preu de catàleg, el preu doferta i la finalització de la mateixa. Lusuari té la opció de tornar al llistat o de afegirel producte a la cistella sempre i quan es tracti dun visitant.',
                                        preu_cataleg:124.0,
                                        data_alta:Date.parse('dd/MM/yyyy','01/06/2012'),
                                        data_baixa:null)
                                        .save(failOnError:true);

                def p5 = new Producte(nom:'Mizuno wave',
                                        subcategoria:sc3,
                                        descripcio_comercial:'Aquesta pilota es la ostia neng. Els productes es presentenamb tota la ruta de categories a la que pertany, una foto, el nom, ladescripció comercial i el preu actual indicant lestalvi individual de cada producte,la quantitat del producte a la cistella i el preu total (quantitat per preu).Al final de la llista de productes de la cistella i trobem limport acumulat delpreu total i de lestalvi total per la cistella. Quan lusuari prem continuar compranttornem a la llista de productes don es provenia, encara que hagués passatper una fitxa de producte. A la llista es torna amb els filtres actius que hipogués haver i a la pàgina don provenia.',
                                        descripcio_detallada:'Pero la ostia en patinet. El sistema mostra tota la informació disponible del producte: el nom, la foto a màxima visualització, la descripció comercial, la descripció detallada, el preu de catàleg, el preu doferta i la finalització de la mateixa. Lusuari té la opció de tornar al llistat o de afegirel producte a la cistella sempre i quan es tracti dun visitant.',
                                        preu_cataleg:114.0,
                                        data_alta:Date.parse('dd/MM/yyyy','01/06/2012'),
                                        data_baixa:null)
                                        .addToOfertes(of3)
                                        .save(failOnError:true);

                def p6 = new Producte(nom:'Salomon compressor',
                                        subcategoria:sc6,
                                        descripcio_comercial:'Aquesta pilota es la ostia neng. Els productes es presentenamb tota la ruta de categories a la que pertany, una foto, el nom, ladescripció comercial i el preu actual indicant lestalvi individual de cada producte,la quantitat del producte a la cistella i el preu total (quantitat per preu).Al final de la llista de productes de la cistella i trobem limport acumulat delpreu total i de lestalvi total per la cistella. Quan lusuari prem continuar compranttornem a la llista de productes don es provenia, encara que hagués passatper una fitxa de producte. A la llista es torna amb els filtres actius que hipogués haver i a la pàgina don provenia.',
                                        descripcio_detallada:'Pero la ostia en patinet. El sistema mostra tota la informació disponible del producte: el nom, la foto a màxima visualització, la descripció comercial, la descripció detallada, el preu de catàleg, el preu doferta i la finalització de la mateixa. Lusuari té la opció de tornar al llistat o de afegirel producte a la cistella sempre i quan es tracti dun visitant.',
                                        preu_cataleg:26.0,
                                        data_alta:Date.parse('dd/MM/yyyy','01/06/2012'),
                                        data_baixa:null)
                                        .save(failOnError:true);

                def p7 = new Producte(nom:'Domyos socks',
                                        subcategoria:sc4,
                                        descripcio_comercial:'Aquesta pilota es la ostia neng. Els productes es presentenamb tota la ruta de categories a la que pertany, una foto, el nom, ladescripció comercial i el preu actual indicant lestalvi individual de cada producte,la quantitat del producte a la cistella i el preu total (quantitat per preu).Al final de la llista de productes de la cistella i trobem limport acumulat delpreu total i de lestalvi total per la cistella. Quan lusuari prem continuar compranttornem a la llista de productes don es provenia, encara que hagués passatper una fitxa de producte. A la llista es torna amb els filtres actius que hipogués haver i a la pàgina don provenia.',
                                        descripcio_detallada:'Pero la ostia en patinet. El sistema mostra tota la informació disponible del producte: el nom, la foto a màxima visualització, la descripció comercial, la descripció detallada, el preu de catàleg, el preu doferta i la finalització de la mateixa. Lusuari té la opció de tornar al llistat o de afegirel producte a la cistella sempre i quan es tracti dun visitant.',
                                        preu_cataleg:7.3,
                                        data_alta:Date.parse('dd/MM/yyyy','01/06/2012'),
                                        data_baixa:null)
                                        .addToOfertes(of4)
                                        .save(failOnError:true);

                def p8 =  new Producte(nom:'Samarreta R Madrid 2011',
                                        subcategoria:sc2,
                                        descripcio_comercial:'El personal de comercial gestionarà (altes, baixes i modificacions) el catàleg de productes i realitzarà les ofertes dels productes indicant-ne la durada, ampliantla o reduint-la quan calgui. Un mateix producte podrà tenir planificadesdiverses ofertes que no es poden solapar en el temps.El personal administració disposarà de la possibilitat de obtenir llistats defacturació sobre períodes variables, es podrà escollir el període que es vulgui.Un cop es visualitzi el llistat es podrà exportar el mateix en mode text amb les columnes separades per punt i comes. El llistat de facturació és un llistat acumulatper client de les comandes en el període indicat.De la mateixa manera, el personal de comercial, podrà treure llistats acumulats per categories o productes venuts entre dues dates indicades.',
                                        descripcio_detallada:'El sistema mostra un formulari de cerca on lsuari pot introduir el nom, una o varies categories de qualsevol nivell i/o el preu mínim i màxim dels productes que vol cercar. Lusuari pot introduir, si vol, dos paraules per el nom i el preu màxim. El sistema cerca al catàleg de productes aquells productes que tenen alnom les dues paraules de la cerca (en qualsevol ordre) i el preu actual de venda (el doferta o de catàleg) i mostra la llista dels productes. Luari pot avançar i retrocedir per totes les pàgines dels productes cercats. Els productes estaran ordenats tant per cent de descompte, data finalització oferta (primer aquells que caduca primer) i per nom. A totes les pàgines es mostra el formulari decerca omplert amb les dades que ha omplert lusuari.',
                                        preu_cataleg:1.0,
                                        data_alta:Date.parse('dd/MM/yyyy','01/06/2012'),
                                        data_baixa:null)
                                        .save(failOnError:true);

                def p9 =  new Producte(nom:'Samarreta Chelsea 2011',
                                        subcategoria:sc2,
                                        descripcio_comercial:'El personal de comercial gestionarà (altes, baixes i modificacions) el catàleg de productes i realitzarà les ofertes dels productes indicant-ne la durada, ampliantla o reduint-la quan calgui. Un mateix producte podrà tenir planificadesdiverses ofertes que no es poden solapar en el temps.El personal administració disposarà de la possibilitat de obtenir llistats defacturació sobre períodes variables, es podrà escollir el període que es vulgui.Un cop es visualitzi el llistat es podrà exportar el mateix en mode text amb les columnes separades per punt i comes. El llistat de facturació és un llistat acumulatper client de les comandes en el període indicat.De la mateixa manera, el personal de comercial, podrà treure llistats acumulats per categories o productes venuts entre dues dates indicades.',
                                        descripcio_detallada:'El sistema mostra un formulari de cerca on lsuari pot introduir el nom, una o varies categories de qualsevol nivell i/o el preu mínim i màxim dels productes que vol cercar. Lusuari pot introduir, si vol, dos paraules per el nom i el preu màxim. El sistema cerca al catàleg de productes aquells productes que tenen alnom les dues paraules de la cerca (en qualsevol ordre) i el preu actual de venda (el doferta o de catàleg) i mostra la llista dels productes. Luari pot avançar i retrocedir per totes les pàgines dels productes cercats. Els productes estaran ordenats tant per cent de descompte, data finalització oferta (primer aquells que caduca primer) i per nom. A totes les pàgines es mostra el formulari decerca omplert amb les dades que ha omplert lusuari.',
                                        preu_cataleg:104.0,
                                        data_alta:Date.parse('dd/MM/yyyy','01/06/2012'),
                                        data_baixa:null)
                                        .save(failOnError:true);

                def p10 =  new Producte(nom:'Samarreta Málaga 2011',
                                        subcategoria:sc2,
                                        descripcio_comercial:'El personal de comercial gestionarà (altes, baixes i modificacions) el catàleg de productes i realitzarà les ofertes dels productes indicant-ne la durada, ampliantla o reduint-la quan calgui. Un mateix producte podrà tenir planificadesdiverses ofertes que no es poden solapar en el temps.El personal administració disposarà de la possibilitat de obtenir llistats defacturació sobre períodes variables, es podrà escollir el període que es vulgui.Un cop es visualitzi el llistat es podrà exportar el mateix en mode text amb les columnes separades per punt i comes. El llistat de facturació és un llistat acumulatper client de les comandes en el període indicat.De la mateixa manera, el personal de comercial, podrà treure llistats acumulats per categories o productes venuts entre dues dates indicades.',
                                        descripcio_detallada:'El sistema mostra un formulari de cerca on lsuari pot introduir el nom, una o varies categories de qualsevol nivell i/o el preu mínim i màxim dels productes que vol cercar. Lusuari pot introduir, si vol, dos paraules per el nom i el preu màxim. El sistema cerca al catàleg de productes aquells productes que tenen alnom les dues paraules de la cerca (en qualsevol ordre) i el preu actual de venda (el doferta o de catàleg) i mostra la llista dels productes. Luari pot avançar i retrocedir per totes les pàgines dels productes cercats. Els productes estaran ordenats tant per cent de descompte, data finalització oferta (primer aquells que caduca primer) i per nom. A totes les pàgines es mostra el formulari decerca omplert amb les dades que ha omplert lusuari.',
                                        preu_cataleg:85.0,
                                        data_alta:Date.parse('dd/MM/yyyy','01/06/2012'),
                                        data_baixa:null)
                                        .save(failOnError:true);

                def p11 =  new Producte(nom:'Samarreta Sel·lecció Alemanya Eurocopa 2012',
                                        subcategoria:sc2,
                                        descripcio_comercial:'El personal de comercial gestionarà (altes, baixes i modificacions) el catàleg de productes i realitzarà les ofertes dels productes indicant-ne la durada, ampliantla o reduint-la quan calgui. Un mateix producte podrà tenir planificadesdiverses ofertes que no es poden solapar en el temps.El personal administració disposarà de la possibilitat de obtenir llistats defacturació sobre períodes variables, es podrà escollir el període que es vulgui.Un cop es visualitzi el llistat es podrà exportar el mateix en mode text amb les columnes separades per punt i comes. El llistat de facturació és un llistat acumulatper client de les comandes en el període indicat.De la mateixa manera, el personal de comercial, podrà treure llistats acumulats per categories o productes venuts entre dues dates indicades.',
                                        descripcio_detallada:'El sistema mostra un formulari de cerca on lsuari pot introduir el nom, una o varies categories de qualsevol nivell i/o el preu mínim i màxim dels productes que vol cercar. Lusuari pot introduir, si vol, dos paraules per el nom i el preu màxim. El sistema cerca al catàleg de productes aquells productes que tenen alnom les dues paraules de la cerca (en qualsevol ordre) i el preu actual de venda (el doferta o de catàleg) i mostra la llista dels productes. Luari pot avançar i retrocedir per totes les pàgines dels productes cercats. Els productes estaran ordenats tant per cent de descompte, data finalització oferta (primer aquells que caduca primer) i per nom. A totes les pàgines es mostra el formulari decerca omplert amb les dades que ha omplert lusuari.',
                                        preu_cataleg:48.0,
                                        data_alta:Date.parse('dd/MM/yyyy','01/06/2012'),
                                        data_baixa:null)
                                        .save(failOnError:true);

                def p12 =  new Producte(nom:'Samarreta Sel·lecció Espanyola Eurocopa 2012',
                                        subcategoria:sc2,
                                        descripcio_comercial:'El personal de comercial gestionarà (altes, baixes i modificacions) el catàleg de productes i realitzarà les ofertes dels productes indicant-ne la durada, ampliantla o reduint-la quan calgui. Un mateix producte podrà tenir planificadesdiverses ofertes que no es poden solapar en el temps.El personal administració disposarà de la possibilitat de obtenir llistats defacturació sobre períodes variables, es podrà escollir el període que es vulgui.Un cop es visualitzi el llistat es podrà exportar el mateix en mode text amb les columnes separades per punt i comes. El llistat de facturació és un llistat acumulatper client de les comandes en el període indicat.De la mateixa manera, el personal de comercial, podrà treure llistats acumulats per categories o productes venuts entre dues dates indicades.',
                                        descripcio_detallada:'El sistema mostra un formulari de cerca on lsuari pot introduir el nom, una o varies categories de qualsevol nivell i/o el preu mínim i màxim dels productes que vol cercar. Lusuari pot introduir, si vol, dos paraules per el nom i el preu màxim. El sistema cerca al catàleg de productes aquells productes que tenen alnom les dues paraules de la cerca (en qualsevol ordre) i el preu actual de venda (el doferta o de catàleg) i mostra la llista dels productes. Luari pot avançar i retrocedir per totes les pàgines dels productes cercats. Els productes estaran ordenats tant per cent de descompte, data finalització oferta (primer aquells que caduca primer) i per nom. A totes les pàgines es mostra el formulari decerca omplert amb les dades que ha omplert lusuari.',
                                        preu_cataleg:0.5,
                                        data_alta:Date.parse('dd/MM/yyyy','01/06/2012'),
                                        data_baixa:null)
                                        .save(failOnError:true);
               def p13 = new Producte(nom:'Pilota Adidas 2011',
                                        subcategoria:sc1,
                                        descripcio_comercial:'Aquesta pilota es la ostia neng. Els productes es presentenamb tota la ruta de categories a la que pertany, una foto, el nom, ladescripció comercial i el preu actual indicant lestalvi individual de cada producte,la quantitat del producte a la cistella i el preu total (quantitat per preu).Al final de la llista de productes de la cistella i trobem limport acumulat delpreu total i de lestalvi total per la cistella. Quan lusuari prem continuar compranttornem a la llista de productes don es provenia, encara que hagués passatper una fitxa de producte. A la llista es torna amb els filtres actius que hipogués haver i a la pàgina don provenia.',
                                        descripcio_detallada:'Pero la ostia en patinet. El sistema mostra tota la informació disponible del producte: el nom, la foto a màxima visualització, la descripció comercial, la descripció detallada, el preu de catàleg, el preu doferta i la finalització de la mateixa. Lusuari té la opció de tornar al llistat o de afegirel producte a la cistella sempre i quan es tracti dun visitant.',
                                        preu_cataleg:17.0,
                                        data_alta:Date.parse('dd/MM/yyyy','01/06/2012'),
                                        data_baixa:null)
                                        .save(failOnError:true);

                def p14 = new Producte(nom:'Mitjons de mercat',
                                        subcategoria:sc4,
                                        descripcio_comercial:'Aquesta pilota es la ostia neng. Els productes es presentenamb tota la ruta de categories a la que pertany, una foto, el nom, ladescripció comercial i el preu actual indicant lestalvi individual de cada producte,la quantitat del producte a la cistella i el preu total (quantitat per preu).Al final de la llista de productes de la cistella i trobem limport acumulat delpreu total i de lestalvi total per la cistella. Quan lusuari prem continuar compranttornem a la llista de productes don es provenia, encara que hagués passatper una fitxa de producte. A la llista es torna amb els filtres actius que hipogués haver i a la pàgina don provenia.',
                                        descripcio_detallada:'Pero la ostia en patinet. El sistema mostra tota la informació disponible del producte: el nom, la foto a màxima visualització, la descripció comercial, la descripció detallada, el preu de catàleg, el preu doferta i la finalització de la mateixa. Lusuari té la opció de tornar al llistat o de afegirel producte a la cistella sempre i quan es tracti dun visitant.',
                                        preu_cataleg:500.0,
                                        data_alta:Date.parse('dd/MM/yyyy','09/06/2011'),
                                        data_baixa:null)
                                        .save(failOnError:true);
    }

    void testAfegirProducteNoExisteix(){
        this.inicialitzacio()
        // el producte no existeix
        params.idProducte=30
        params.quantitat=10
        controller.afegirProducte()
        assert flash.message=='producte.message.noexisteix'
    }
    void testAfegirProducteNoHiEsAlaCistella(){
        this.inicialitzacio()
        // afegir producte que no existeix en la cistella
        params.idProducte="1"
        params.quantitat="10"
        controller.afegirProducte()
        assert session.cistella[Long.parseLong(params.idProducte)]==Integer.parseInt(params.quantitat)
    }
    void testAfegirProducteJaHiEsAlaCistella(){
        this.inicialitzacio()
        // afegir producte que ja existeix en la cistella
        params.idProducte="1"
        session.cistella=[:]
        session.cistellaTotal=0
        session.cistella[Long.parseLong(params.idProducte)]=Integer.parseInt("10")
        def total="11"
        controller.afegirProducte()
        assert session.cistella[Long.parseLong(params.idProducte)]==Integer.parseInt(total)
    }
    void testTreureProducte(){
        this.inicialitzacio()
        params.idProducte="1"
        params.quantitat="10"
        session.cistella=[:]
        session.cistellaTotal=0
        session.cistella[Long.parseLong(params.idProducte)]=Integer.parseInt("10")
        params.id="1"
        controller.treureProducte()
        assert session.cistella[Long.parseLong(params.idProducte)]==null
    }
    void testEliminar(){
        controller.eliminar()
        assert session.cistella==null
    }
    void testUpQuantitat(){
        this.inicialitzacio()
        params.idProducte="1"
        params.quantitat="10"
        session.cistella=[:]
        session.cistellaTotal=0
        session.totalDescompte=0
        session.cistella[Long.parseLong(params.idProducte)]=Integer.parseInt("10")
        params.id="1"
        controller.upQuantitat()
        assert session.cistella[Long.parseLong(params.idProducte)]==Integer.parseInt("11")
    }
    void testDownQuantitat(){
        this.inicialitzacio()
        params.idProducte="1"
        params.quantitat="10"
        session.cistella=[:]
        session.cistellaTotal=0
        session.totalDescompte=0
        session.cistella[Long.parseLong(params.idProducte)]=Integer.parseInt("10")
        params.id="1"
        controller.downQuantitat()
        assert session.cistella[Long.parseLong(params.idProducte)]==Integer.parseInt("9")
    }
    
    
}
