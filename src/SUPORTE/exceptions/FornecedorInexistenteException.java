package SUPORTE.exceptions;

public class FornecedorInexistenteException extends Exception {

    public FornecedorInexistenteException() {
        super("Fornecedor inexistente.");
    }

    public FornecedorInexistenteException(String msg) {
        super(msg);
    }
}
