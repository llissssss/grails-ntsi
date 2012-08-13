package gestio
import Compres.*
import java.sql.Timestamp
import java.io.*

class AdministracioController {

    def index() {
        session.prova=""
        redirect(action: "formulariEscull")
    }
    def formulariEscull(){
        
    }
    def list(){
        def dataIni
        def dataFi
        if(params.data_ini){
            dataIni=params.data_ini
            session.AdminDataIni=dataIni
        }else{
            dataIni=session.AdminDataIni
        }
        if(params.data_fi){
            dataFi=params.data_fi
            session.AdminDataFi=dataFi
        }else{
            dataFi=session.AdminDataFi
        }
        if(dataIni<dataFi){
            params.max = Math.min(params.max ? params.int('max') : 10, 100)
            def p=[:]
            def ppp=params
            p.put('max',params.max)
            if(ppp.offset){
                def off=Integer.parseInt(ppp.get('offset'))
                p.put('offset',off)
            }
            def dI=Integer.toString((session.AdminDataIni.getYear()+1900))+"-"+Integer.toString(session.AdminDataIni.getMonth()+1)+"-"+Integer.toString(session.AdminDataIni.getDate())
            def dF=Integer.toString((session.AdminDataFi.getYear()+1900))+"-"+Integer.toString(session.AdminDataFi.getMonth()+1)+"-"+Integer.toString(session.AdminDataFi.getDate())
            def llista1=Comanda.findAll("from Comanda as c WHERE c.data BETWEEN '"+dI+"' AND '"+dF+"' ORDER BY usuari")
            def total=llista1.size()
            def llista=Comanda.findAll("from Comanda as c WHERE c.data BETWEEN '"+dI+"' AND '"+dF+"' ORDER BY usuari", p)
            session.llistaComandaDates=llista1
            [llistaComandes:llista, data_ini:dataIni, data_fi:dataFi,comandaInstanceTotal:total]
        }else{
            flash.message="La data Inicial ha de ser menor que data Final"
            redirect(action:"formulariEscull")
        }

    }
    def generarCSV(){

        String imagepath =
        grailsAttributes.getApplicationContext().getResource("arxius/").getFile().toString()
        //grailsAttributes.getApplicationContext().getResource("images/productes/").getFile().toString() + File.separatorChar + "${producteInstance.id}.png"
        String rutaArxiu=imagepath+"\\llistatFacturacio.csv"

        File file = new File(rutaArxiu)
        
        if(!file.exists()){
            file.createNewFile()
    	}
        def d=file.getParent()
        FileWriter fw = new FileWriter(file.getPath())
    	BufferedWriter bw = new BufferedWriter(fw)
        bw.write("Data exportació: "+new Date())
        bw.newLine()
        bw.write("Usuari: "+session.usuari.nom+" "+session.usuari.cognom)
        bw.newLine()
        bw.write("Data inici: "+(session.AdminDataIni.getYear()+1900)+"/"+session.AdminDataIni.getMonth()+"/"+session.AdminDataIni.getDate())
        bw.newLine()
        bw.write("Data final: "+(session.AdminDataFi.getYear()+1900)+"/"+session.AdminDataFi.getMonth()+"/"+session.AdminDataFi.getDate())
        bw.newLine()
        bw.newLine()
        bw.write("Client;NIF;idComanda;data;Total")
        bw.newLine()
        Iterator iter = session.llistaComandaDates.iterator();
        while (iter.hasNext()){
            def com=iter.next()
            bw.write(com.usuari.nom+";"+com.usuari.nif+";"+com.id+";")
            bw.write(com.data.getYear()+1900+"/"+com.data.getMonth()+"/"+com.data.getDate()+";")
            bw.write(com.preu_total+";")
            bw.newLine()
        }
        bw.close();

        redirect(uri: "/arxius/llistatFacturacio.csv")
       /* String sourceFile="/Users/jordisabria/Documents/g2012g/llistatFacturacio.csv"
        File inFile = new File(sourceFile);
        File outFile = new File(rutaArxiu);

        FileInputStream ini = new FileInputStream(inFile);
        FileOutputStream out = new FileOutputStream(outFile);

        int c;
        while ((c = ini.read()) != -1)
        out.write(c);

        ini.close();
        out.close();

        File file2 = new File(sourceFile);
        if (file2.exists()) {
            file2.delete();
        }*/
        
        
        /*
        def f = request.getFile('foto')
        if (f.empty) {
        flash.message = 'file cannot be empty'
        render(view: 'create')
        return
        }
        
        def a = servletContext.getRealPath(producteInstance.dirUrlImatge+"/"+producteInstance.fitxerUrlImatge)
        f.transferTo(new File(a))
        
        ------------------------------
        def getDirUrlImatge() {
        return 'images/productes'
        }

        def getFitxerUrlImatge() {
        return this.id + '.jpg'
        }

        -----------------
        <img src="${resource(dir: producteInstance.dirUrlImatge, file: producteInstance.fitxerUrlImatge)}" class="fotoGaleria">
         */
    }
}

