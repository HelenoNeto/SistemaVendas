package SUPORTE.exceptions;

import java.sql.SQLException;


/**
 * Exceção responsável por tratar os erros internos do sistema.
 */
public class ItemJaExisteException extends SQLException {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 2L;

    /**
     * Creates a new ErroInternoException object.
     */
    public ItemJaExisteException() {
        super();
    }


    /**
     * Creates a new ErroInternoException object.
     *
     * @param mensagem de erro
     */
    public ItemJaExisteException(String message) {
        super(message);
    }
       
    /**
     * @param message
     * @param cause
     */
    public ItemJaExisteException(String message, Throwable cause) {
        super(message, cause);
    }
}