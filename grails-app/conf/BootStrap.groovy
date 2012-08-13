import grails.util.Environment
import productes.*
import Usuaris.*
import Compres.*

class BootStrap {

    def init = { servletContext ->
       environments {
           development
           //test
           {

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
                /* def u2 = new Usuari(nom:'Ramon',cognoms:'Puig Pujol', login: 'rpuig', password: 'secret').save()

                // P4

                def p1 = new Producte(nom:'Andreu',cognoms:'Marimon Ribas',login: 'amarimon', password: 'secret', rol:'admin').save()

                def u2 = new Usuari(nom:'Ramon',cognoms:'Puig Pujol', login: 'rpuig', password: 'secret').save()
                */

                // creem uns quants usuaris
                def u = new Usuari()
                u.nom="Jordi"
                u.cognom="Sabria"
                u.nif="7737279a"
                u.adreca="c/novadelli, 27 17257"
                u.poblacio="Torroella de Montgri"
                Date d=new Date(1980,10,2)
                u.data_naixement=d
                u.Sexe="H"
                u.email="jsp@jsp.com"
                u.login="client"
                u.password="secret"
                u.password2="secret"
                u.rol="client"
                u.save(failOnError:true)

                def u1 = new Usuari()
                u1.nom="Dani"
                u1.cognom="Capell"
                u1.nif="564544a"
                u1.adreca="c/novadelli, 42 17200"
                u1.poblacio="Girona"
                Date d2=new Date(1984,10,2)
                u1.data_naixement=d2
                u1.Sexe="H"
                u1.email="dcp@dcp.com"
                u1.login="magatzem"
                u1.password="secret"
                u1.password2="secret"
                u1.rol="magatzem"
                u1.save(failOnError:true)

                def u2 = new Usuari()
                u2.nom="Albert"
                u2.cognom="Casadesus"
                u2.nif="78787b"
                u2.adreca="c/lluny, 42 17200"
                u2.poblacio="Molt_lluny"
                Date d3=new Date(1986,10,8)
                u2.data_naixement=d3
                u2.Sexe="H"
                u2.email="acc@acc.com"
                u2.login="comercial"
                u2.password="secret"
                u2.password2="secret"
                u2.rol="comercial"
                u2.save(failOnError:true)

                def u3 = new Usuari()
                u3.nom="Xevi"
                u3.cognom="Riu"
                u3.nif="888777b"
                u3.adreca="c/aprop, 42 17200"
                u3.poblacio="Girona"
                Date d4=new Date(1986,10,8)
                u3.data_naixement=d4
                u3.Sexe="H"
                u3.email="xr@xr.com"
                u3.login="admin"
                u3.password="secret"
                u3.password2="secret"
                u3.rol="administracio"
                u3.save(failOnError:true)
                

                
                // creem una comanda amb una linea comanda
                // nomes es una prova
                def avui=new Date()
                avui.setYear(111)
                def com=new Comanda()
                com.usuari=u
                com.data= avui
                com.nom_env= "jordi"
                com.cognom_env= "sabria"
                com.adreca= "session.dadesEnvia.adreca"
                com.poblacio_env="girona"
                com.nom_fact= "session.usuari.nom"
                com.cognom_fact= "session.usuari.cognom"
                com.nif_fact= "addfakdfaf"
                com.adreca_fact= "session.usuari.adreca"
                com.poblacio_fact="Girona"
                com.metodeEnviament= "UPS"
                com.preu_total=(BigDecimal) 20
                com.estat='en proces'

                def lc=new LiniesComanda(
                    idProducte: "1",
                    producte: "Samarreta Barça 2012",
                    quantitat: 2,
                    preu: (BigDecimal) 60
                ).save()
                com.addToLinies_comanda(lc)

                def lc2=new LiniesComanda(
                    idProducte: "2",
                    producte: "Samarreta Milan 2011",
                    quantitat: 2,
                    preu: (BigDecimal) 50
                ).save()
                com.addToLinies_comanda(lc2)

                com.save(failOnError:true)
                
                // Insertem varies comandes mes
                def avui2=new Date()
                avui2.setDate(2)
                avui2.setYear(111)
                def com2=new Comanda()
                com2.usuari=u
                com2.data= avui2
                com2.nom_env= "jordi"
                com2.cognom_env= "sabria"
                com2.adreca= "session.dadesEnvia.adreca"
                com2.poblacio_env="girona"
                com2.nom_fact= "session.usuari.nom"
                com2.cognom_fact= "session.usuari.cognom"
                com2.nif_fact= "addfakdfaf"
                com2.adreca_fact= "session.usuari.adreca"
                com2.poblacio_fact="Girona"
                com2.metodeEnviament= "UPS"
                com2.preu_total=(BigDecimal) 40
                com2.estat='en proces'
                com2.save(failOnError:true)

                def lc3=new LiniesComanda(
                    idProducte: "1",
                    producte: "Samarreta Barça 2012",
                    quantitat: 2,
                    preu: (BigDecimal) 60
                ).save()
                com2.addToLinies_comanda(lc3)

                def lc4=new LiniesComanda(
                    idProducte: "2",
                    producte: "Samarreta Milan 2011",
                    quantitat: 2,
                    preu: (BigDecimal) 50
                ).save()
                com2.addToLinies_comanda(lc4)
                
                def avui3=new Date()
                avui3.setDate(14)
                avui3.setYear(111)
                def com3=new Comanda()
                com3.usuari=u
                com3.data= avui3
                com3.nom_env= "jordi"
                com3.cognom_env= "sabria"
                com3.adreca= "session.dadesEnvia.adreca"
                com3.poblacio_env="girona"
                com3.nom_fact= "session.usuari.nom"
                com3.cognom_fact= "session.usuari.cognom"
                com3.nif_fact= "addfakdfaf"
                com3.adreca_fact= "session.usuari.adreca"
                com3.poblacio_fact="Girona"
                com3.metodeEnviament= "UPS"
                com3.preu_total=(BigDecimal) 40
                com3.estat='en proces'
                com3.save(failOnError:true)

                def lc5=new LiniesComanda(
                    idProducte: "1",
                    producte: "Samarreta Barça 2012",
                    quantitat: 2,
                    preu: (BigDecimal) 60
                ).save()
                com3.addToLinies_comanda(lc5)

                
                def avui4=new Date()
                avui4.setDate(9)
                avui4.setYear(111)
                def com4=new Comanda()
                com4.usuari=u
                com4.data= avui4
                com4.nom_env= "jordi"
                com4.cognom_env= "sabria"
                com4.adreca= "session.dadesEnvia.adreca"
                com4.poblacio_env="girona"
                com4.nom_fact= "session.usuari.nom"
                com4.cognom_fact= "session.usuari.cognom"
                com4.nif_fact= "addfakdfaf"
                com4.adreca_fact= "session.usuari.adreca"
                com4.poblacio_fact="Girona"
                com4.metodeEnviament= "UPS"
                com4.preu_total=(BigDecimal) 40
                com4.estat='en proces'
                com4.save(failOnError:true)

                def lc6=new LiniesComanda(
                    idProducte: "2",
                    producte: "Samarreta Milan 2011",
                    quantitat: 2,
                    preu: (BigDecimal) 50
                ).save()
                com4.addToLinies_comanda(lc6)
                
                def avui5=new Date()
                avui5.setDate(30)
                avui5.setYear(111)
                def com5=new Comanda()
                com5.usuari=u
                com5.data= avui5
                com5.nom_env= "jordi"
                com5.cognom_env= "sabria"
                com5.adreca= "session.dadesEnvia.adreca"
                com5.poblacio_env="girona"
                com5.nom_fact= "session.usuari.nom"
                com5.cognom_fact= "session.usuari.cognom"
                com5.nif_fact= "addfakdfaf"
                com5.adreca_fact= "session.usuari.adreca"
                com5.poblacio_fact="Girona"
                com5.metodeEnviament= "UPS"
                com5.preu_total=(BigDecimal) 40
                com5.estat='en proces'
                com5.save(failOnError:true)

                 def lc7=new LiniesComanda(
                    idProducte: "1",
                    producte: "Samarreta Barça 2012",
                    quantitat: 2,
                    preu: (BigDecimal) 60
                ).save()
                com5.addToLinies_comanda(lc7)

                def lc8=new LiniesComanda(
                    idProducte: "2",
                    producte: "Samarreta Milan 2011",
                    quantitat: 2,
                    preu: (BigDecimal) 50
                ).save()
                com5.addToLinies_comanda(lc8)
                
                
                def avui6=new Date()
                avui6.setDate(1)
                def com6=new Comanda()
                com6.usuari=u
                com6.data= avui6
                com6.nom_env= "jordi"
                com6.cognom_env= "sabria"
                com6.adreca= "session.dadesEnvia.adreca"
                com6.poblacio_env="girona"
                com6.nom_fact= "session.usuari.nom"
                com6.cognom_fact= "session.usuari.cognom"
                com6.nif_fact= "addfakdfaf"
                com6.adreca_fact= "session.usuari.adreca"
                com6.poblacio_fact="Girona"
                com6.metodeEnviament= "UPS"
                com6.preu_total=(BigDecimal) 40
                com6.estat='en proces'
                com6.save(failOnError:true)
                
                def avui7=new Date()
                avui7.setDate(17)
                def com7=new Comanda()
                com7.usuari=u
                com7.data= avui7
                com7.nom_env= "jordi"
                com7.cognom_env= "sabria"
                com7.adreca= "session.dadesEnvia.adreca"
                com7.poblacio_env="girona"
                com7.nom_fact= "session.usuari.nom"
                com7.cognom_fact= "session.usuari.cognom"
                com7.nif_fact= "addfakdfaf"
                com7.adreca_fact= "session.usuari.adreca"
                com7.poblacio_fact="Girona"
                com7.metodeEnviament= "UPS"
                com7.preu_total=(BigDecimal) 40
                com7.estat='en proces'
                com7.save(failOnError:true)
                
                def avui8=new Date()
                avui8.setDate(25)
                def com8=new Comanda()
                com8.usuari=u
                com8.data= avui8
                com8.nom_env= "jordi"
                com8.cognom_env= "sabria"
                com8.adreca= "session.dadesEnvia.adreca"
                com8.poblacio_env="girona"
                com8.nom_fact= "session.usuari.nom"
                com8.cognom_fact= "session.usuari.cognom"
                com8.nif_fact= "addfakdfaf"
                com8.adreca_fact= "session.usuari.adreca"
                com8.poblacio_fact="Girona"
                com8.metodeEnviament= "UPS"
                com8.preu_total=(BigDecimal) 40
                com8.estat='en proces'
                com8.save(failOnError:true)
                
                def avui9=new Date()
                avui9.setDate(20)
                def com9=new Comanda()
                com9.usuari=u
                com9.data= avui9
                com9.nom_env= "jordi"
                com9.cognom_env= "sabria"
                com9.adreca= "session.dadesEnvia.adreca"
                com9.poblacio_env="girona"
                com9.nom_fact= "session.usuari.nom"
                com9.cognom_fact= "session.usuari.cognom"
                com9.nif_fact= "addfakdfaf"
                com9.adreca_fact= "session.usuari.adreca"
                com9.poblacio_fact="Girona"
                com9.metodeEnviament= "UPS"
                com9.preu_total=(BigDecimal) 40
                com9.estat='en proces'
                com9.save(failOnError:true)
                
                def avui10=new Date()
                avui10.setDate(16)
                def com10=new Comanda()
                com10.usuari=u
                com10.data= avui10
                com10.nom_env= "jordi"
                com10.cognom_env= "sabria"
                com10.adreca= "session.dadesEnvia.adreca"
                com10.poblacio_env="girona"
                com10.nom_fact= "session.usuari.nom"
                com10.cognom_fact= "session.usuari.cognom"
                com10.nif_fact= "addfakdfaf"
                com10.adreca_fact= "session.usuari.adreca"
                com10.poblacio_fact="Girona"
                com10.metodeEnviament= "UPS"
                com10.preu_total=(BigDecimal) 40
                com10.estat='en proces'
                com10.save(failOnError:true)
                
                def avui11=new Date()
                avui11.setDate(18)
                def com11=new Comanda()
                com11.usuari=u
                com11.data= avui11
                com11.nom_env= "jordi"
                com11.cognom_env= "sabria"
                com11.adreca= "session.dadesEnvia.adreca"
                com11.poblacio_env="girona"
                com11.nom_fact= "session.usuari.nom"
                com11.cognom_fact= "session.usuari.cognom"
                com11.nif_fact= "addfakdfaf"
                com11.adreca_fact= "session.usuari.adreca"
                com11.poblacio_fact="Girona"
                com11.metodeEnviament= "UPS"
                com11.preu_total=(BigDecimal) 40
                com11.estat='en proces'
                com11.save(failOnError:true)
                
                def avui12=new Date()
                avui12.setDate(22)
                def com12=new Comanda()
                com12.usuari=u
                com12.data= avui12
                com12.nom_env= "jordi"
                com12.cognom_env= "sabria"
                com12.adreca= "session.dadesEnvia.adreca"
                com12.poblacio_env="girona"
                com12.nom_fact= "session.usuari.nom"
                com12.cognom_fact= "session.usuari.cognom"
                com12.nif_fact= "addfakdfaf"
                com12.adreca_fact= "session.usuari.adreca"
                com12.poblacio_fact="Girona"
                com12.metodeEnviament= "UPS"
                com12.preu_total=(BigDecimal) 40
                com12.estat='en proces'
                com12.save(failOnError:true)
                
           }
       }
    }
    def destroy = {
    }
}
