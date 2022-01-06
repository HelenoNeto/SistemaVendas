package SUPORTE.exceptions;

public class GrupoInexistenteException extends Exception {

    public GrupoInexistenteException() {
        super("Grupo de Produtos inexistente.");
    }

    public GrupoInexistenteException(String msg) {
        super(msg);
    }
}
