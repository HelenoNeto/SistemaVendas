/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package splashscreen;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sidnei
 */
public class SplashText {
     private SplashFrame splashFrame;

    /** Creates new form AplicationFrame */
    public SplashText(SplashFrame splashFrame) {
        this.splashFrame = splashFrame;
        //ahora empiezo a setear el porcentaje, 0 al iniciar el constructor
        //todas las acciones en teoria se cargan en el constructor
        //y son esas acciones las que hacen que una aplicacion tarde en cargarse
        setProgress(0, "Cargando componentes.");
        setProgress(2, "Cargando componentes..");
        setProgress(4, "Cargando componentes...");
        setProgress(6, "Preparando Ambiente.");
        setProgress(8, "Preparando Ambiente..");
        setProgress(10, "Salvando Estrutura.");
        setProgress(12, "Salvando Estrutura..");
        setProgress(14, "Salvando Dados.");
        setProgress(16, "Salvando Dados..");
        setProgress(18, "Salvando Dados...");
        setProgress(20, "Salvando Dados./Empresa");
        setProgress(22, "Salvando Dados./Empresa");
        setProgress(24, "Salvando Dados./Usuarios");
        setProgress(29, "Salvando Dados./Produtos");
        setProgress(35, "Salvando Dados./Produtos");
        setProgress(40, "Salvando Dados./Produtos");
        setProgress(45, "Salvando Dados./Fornecedores");
        setProgress(50, "Salvando Dados./Configurações");
        setProgress(55, "Salvando Dados./Configurações");
        setProgress(60, "Salvando Dados./Configurações");
        setProgress(65, "Salvando Dados./CFOP");
        setProgress(70, "Salvando Dados./CFOP");
        setProgress(75, "Salvando Dados./NCM");
        setProgress(80, "Salvando Dados./ICM");
        setProgress(85, "Salvando Dados./Parametros");
        setProgress(90, "Fechando Banco de Dados!!!");
        setProgress(95, "Fechando Banco de Dados!!!");
        setProgress(100, "Fechando Banco de Dados!!!");
        setProgress(105, "Salvando Arquivo..");
        setProgress(110, "Salvando Arquivo..");
        setProgress(115, "Salvando Arquivo..");
        setProgress(120, "Salvando Arquivo..");
        setProgress(125, "Salvando Arquivo..");
        setProgress(130, "Salvando Arquivo..");
        setProgress(135, "Salvando Arquivo..");
        setProgress(140, "Salvando Arquivo..");
        setProgress(145, "Salvando Arquivo..");
        setProgress(160, "Salvando Arquivo..");
        setProgress(170, "Salvando Arquivo..");
        setProgress(180, "Salvando Arquivo..");
        setProgress(200, "Salvando Arquivo..");
        splashFrame.getProgressBar().setIndeterminate(true);
        
        //los porcentajes los calculo segun las acciones que se ejecuten
    }

    private void setProgress(int percent, String information){
        splashFrame.getLabel().setText(information);
        splashFrame.getProgressBar().setValue(percent);
        
        /*
         este Thread.sleep es solamente para que el Thread se duerma un momento
         * cada vez que ingresamos un nuevo porcentaje al SplashScreen, de lo contrario
         * la barra avanzaria demasiado rapido y no la veriamos, en una
         * aplicacion real, esto no seria nesesario, ya que la aplicacion
         * en verdad se tardaria al cargar acciones y metodos
         */
        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            Logger.getLogger(SplashText.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
