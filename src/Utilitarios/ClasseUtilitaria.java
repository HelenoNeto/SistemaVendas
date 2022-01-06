package Utilitarios;

import SUPORTE.exceptions.DadoInvalidoException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.net.MalformedURLException;
import java.text.DecimalFormat;
import javax.sound.sampled.*;
import javax.swing.JTextField;
import java.text.SimpleDateFormat;

public class ClasseUtilitaria {

    public static final SimpleDateFormat fmtDataHoraUS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final SimpleDateFormat fmtDataHoraBR = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    public static final SimpleDateFormat fmtDataUS = new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat fmtDataBR = new SimpleDateFormat("dd/MM/yyyy");
    public static final SimpleDateFormat fmtDataMES = new SimpleDateFormat("MMMMM");
    public static final SimpleDateFormat fmtHora24 = new SimpleDateFormat("HH:mm:ss");
    public static final SimpleDateFormat fmtHora12 = new SimpleDateFormat("hh:mm:ss");
    public static final BigDecimal _100 = new BigDecimal("100");

    public File estrairArquivo(String arquivo_interno_do_jar, String diretorio_destino_extraido) {
        try {
            InputStream input = getClass().getResourceAsStream(arquivo_interno_do_jar);
            File outPutFile = new File(diretorio_destino_extraido + arquivo_interno_do_jar);
            File pasta = new File(outPutFile.getParent());
            if (!pasta.exists()) {
                pasta.mkdirs();
            }
            OutputStream output = new FileOutputStream(outPutFile);

            byte[] buf = new byte[1024];
            int size;

            while ((size = input.read(buf)) > 0) {
                output.write(buf, 0, size);
            }

            output.close();
            input.close();

            System.out.println("    =mensagem: arquivo extraido para: \"" + outPutFile.getAbsolutePath() + "\"");
            return outPutFile;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("    =mensagem: ERRO ao extrair para: \"" + diretorio_destino_extraido + "\\" + arquivo_interno_do_jar);
            return null;
        }
    }

    /**
     *
     * @param obj que pode ser String,Double ou Integer.
     * @return um BigDecimal na Scale(4, RoundingMode.HALF_DOWN)
     * @throws NumberFormatException
     */
    public static BigDecimal parseToBig(Object obj) throws NumberFormatException {
        return parseToBig(obj, Dir.SCL);
    }

    public static BigDecimal parseToBig(Object obj, int scl) throws NumberFormatException {
        scl = Dir.SCL;
        String str;
        if (obj == null) {
            obj = BigDecimal.ZERO;
        }

        if (obj.getClass() == BigDecimal.class) {
            return ((BigDecimal) obj).setScale(scl, RoundingMode.HALF_DOWN);
        } else if (obj.getClass() == String.class) {
            str = (String) obj;
        } else if (obj.getClass() == Double.class) {
            str = ((Double) obj).toString();
        } else if (obj.getClass() == Integer.class) {
            str = ((Integer) obj).toString();
        } else if (obj.getClass() == BigInteger.class) {
            str = ((BigInteger) obj).toString();
        } else if (obj.getClass() == Float.class) {
            str = ((Float) obj).toString();
        } else if (obj.getClass() == JTextField.class) {
            return parseToBig(((JTextField) obj).getText());
        } else {
            throw new NumberFormatException("Tipo de dado inválido.");
        }

        if (str.isEmpty()) {
            str = BigDecimal.ZERO.toString();
        }
        str = (str.contains(",") ? str.replace(".", "").replace(",", ".") : str);
        return new BigDecimal(str).setScale(scl, RoundingMode.HALF_DOWN);
    }

    /**
     *
     * @param big Valor a ser formatado
     * @param qtd_casas_decimais Quantidade de casas decimais da string
     * retornada
     * @return Valor formatado(String)
     */
    public static String fmtBig(Object big, int qtd_casas_decimais) {
        return fmtBig(parseToBig(big), qtd_casas_decimais);
    }

    public static String fmtBig(BigDecimal big, int qtd_casas_decimais) {
        if (big == null) {
            big = BigDecimal.ZERO;
        }

        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(qtd_casas_decimais);
        df.setMinimumFractionDigits(qtd_casas_decimais);
        df.setGroupingUsed(true);

        return df.format(big.setScale(qtd_casas_decimais, RoundingMode.HALF_UP));
    }

    /**
     *
     * @param string recebe uma string qualquer
     * @return Retorna uma string válida para NFe
     * @throws SUPORTE.exceptions.DadoInvalidoException
     */
    public static String decompose(String string) throws DadoInvalidoException {
        if (string == null) {
            throw new DadoInvalidoException(""
                    + "Valor informado inválido!\n"
                    + " valor: [" + string + "]");
        }
        string = java.text.Normalizer.normalize(string, java.text.Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");//remover caracteres especiais
        string = string.replaceAll("°|º|ª|¹|²|³|`|´|^|¨|§", "");//caracteres que o (InCombiningDiacriticalMarks) não remove
        string = string.replaceAll("\\s+", " ").trim();//remover excesso de espaços( internos e nos extremos da string)
        string = string.toUpperCase();//tudo pra maiusculo
        return string;
    }
}
