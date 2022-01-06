package SUPORTE.exceptions;

import SUPORTE.log;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Exceção responsável por tratar os erros internos do sistema.
 */
public class ErroInternoException extends Exception {

    /**
     * Comment for
     * <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 2L;

    /**
     * @param classeDoErro onde ocorreu o erro
     * @param exGeradora a generica que impulsionou esta
     * @param throwableGeradora o trowable da geradora
     */
    public ErroInternoException(Class classeDoErro, Exception exGeradora) {
        super(
                "ERRO INTERNO! \n"
                + " erro= " + exGeradora.getMessage() + "\n"
                + "local= " + classeDoErro.getName(), exGeradora);
        log.execute(classeDoErro.getName(), exGeradora);

        Logger.getLogger(classeDoErro.getName()).log(Level.SEVERE, null, exGeradora);
    }
}