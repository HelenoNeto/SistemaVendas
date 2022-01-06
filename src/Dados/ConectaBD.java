package Dados;

import Utilitarios.Dir;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConectaBD {

    Connection con = null;

    public Connection getConectacao() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            if (con != null && !con.isClosed() && con.isValid(1)) {
                return con;
            }

            con = DriverManager.getConnection("jdbc:mysql://" + Dir.KEY_SERVHOST + "/" + Dir.KEY_DATABASE + "?user=" + Dir.KEY_USUARIO + "&password=" + Dir.KEY_SENHA + "");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar o Driver!" + ex.getMessage(), "Aviso do Sistema", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            System.out.println(ex.getErrorCode());
            switch (ex.getErrorCode()) {
                case 1045:
                    JOptionPane.showMessageDialog(null, "ACESSO NEGADO!\n"
                            + "     NH: " + Dir.KEY_SERVHOST + "\n"
                            + "     DB: " + Dir.KEY_DATABASE + "\n"
                            + "     US: " + Dir.KEY_USUARIO + "\n"
                            + "     PW: " + (Dir.KEY_SENHA == null || Dir.KEY_SENHA.isEmpty() ? "NÃO RECONHECIDA" : siglaDaSenha(Dir.KEY_SENHA)) + "\n"
                            + "\n"
                            + " Usuario ou Senha invalida.\n"
                            + "errno:" + ex.getErrorCode(), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                case 1049:
                    JOptionPane.showMessageDialog(null, "ACESSO NEGADO!\n"
                            + "     NH: " + Dir.KEY_SERVHOST + "\n"
                            + "     DB: " + Dir.KEY_DATABASE + "\n"
                            + "     US: " + Dir.KEY_USUARIO + "\n"
                            + "     PW: " + (Dir.KEY_SENHA == null || Dir.KEY_SENHA.isEmpty() ? "NÃO RECONHECIDA" : "***") + "\n"
                            + "\n"
                            + " DATABASE desconhecida.\n"
                            + "errno:" + ex.getErrorCode(), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                case 0:
                    JOptionPane.showMessageDialog(null, "ACESSO NEGADO!\n"
                            + " NH=" + Dir.KEY_SERVHOST + "\n"
                            + "\n"
                            + " Falha na comunicação.\n"
                            + "errno:" + ex.getErrorCode(), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
                    break;
                default:
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco!" + ex.getMessage(), "Aviso do Sistema", JOptionPane.INFORMATION_MESSAGE);
                    break;
            }
        }
        return con;
    }

    private String siglaDaSenha(String pw) {
        switch (pw) {
            case "#g31nf#":
                return "PNN";
            case "#g31nf":
                return "PN";
            case "juniorleao":
                return "PJ";
            case "#g3$t@0#":
                return "PG";
            case "1234":
                return "P1";
            case "root":
                return "PR";
            default:
                return pw;
        }
    }
}
