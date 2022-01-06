package GUI;

import Negocios.Empresa;
import Negocios.Fachada;
import Negocios.Funcionario;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import org.jdesktop.swingx.JXLoginPane;
import org.jdesktop.swingx.auth.LoginAdapter;
import org.jdesktop.swingx.auth.LoginEvent;
import org.jdesktop.swingx.auth.LoginListener;
import org.jdesktop.swingx.auth.LoginService;
import static sistema.gas.SISTEMA_GAS._EMPRESA_LOGADA;
import static sistema.gas.SISTEMA_GAS._FuncionarioLogado;

public class AutenticacaoDialog {

    private JFrame frame;
    private String userName;
    private int failedAttemptsCount = 0;

    public void showLoginDialog() {

        frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setAlwaysOnTop(true);

        final JXLoginPane loginPane = new JXLoginPane();

        LoginListener loginListener = new LoginAdapter() {
            @Override
            public void loginFailed(LoginEvent source) {
                failedAttemptsCount++;
                String message;
                switch (failedAttemptsCount) {
                    case 1:
                        message = "Uma tentativa falha!";
                        break;
                    case 2:
                        message = "Você terá apenas mais uma tentativa!";
                        break;
                    case 3:
                        message = "Última tentativa!";
                        break;
                    default:
                        message = "Acalme-se e tente lembrar de sua senha!";
                }
                loginPane.setErrorMessage(message);
            }

            @Override
            public void loginSucceeded(LoginEvent source) {
                AutenticacaoDialog.this.userName = loginPane.getUserName();
                new Janela_Principal().setVisible(true);
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        };

        LoginService loginService = new LoginService() {
            @Override
            public boolean authenticate(String name, char[] password, String server) throws Exception {
                return logar(name, String.valueOf(password));
            }
        };

        loginService.addLoginListener(loginListener);
        loginPane.setLoginService(loginService);

        JXLoginPane.JXLoginDialog dialog = new JXLoginPane.JXLoginDialog(frame, loginPane);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);

        // if loginPane was cancelled or closed then its status is CANCELLED
        // and still need to dispose main JFrame to exiting application
        if (loginPane.getStatus() == JXLoginPane.Status.CANCELLED) {
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        }
        if (loginPane.getStatus() == JXLoginPane.Status.NOT_STARTED) {
            System.exit(0);
        }
    }

    private boolean logar(String userName, String passWord) {
        try {
            ArrayList<Funcionario> lista = Fachada.getInstancia().consultarFuncionario("select * from funcionario where login like '" + userName + "' and senha like '" + passWord + "' and not excluido");
            if (!lista.isEmpty()) {
                _FuncionarioLogado = lista.get(0);
                Empresa empresa = Fachada.getInstancia().consultarEmpresa("select * from empresa where id = (select max(id) from empresa)");
                _EMPRESA_LOGADA = empresa;
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AutenticacaoDialog.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
