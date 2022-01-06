package Utilitarios;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;

public class Biblioteca {

    private static String convertToHex(byte[] data) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
            int halfbyte = (data[i] >>> 4) & 0x0F;
            int two_halfs = 0;
            do {
                if ((0 <= halfbyte) && (halfbyte <= 9)) {
                    buf.append((char) ('0' + halfbyte));
                } else {
                    buf.append((char) ('a' + (halfbyte - 10)));
                }
                halfbyte = data[i] & 0x0F;
            } while (two_halfs++ < 1);
        }
        return buf.toString();
    }

    public static String formatoDecimal(String tipo, double valor) {

        String mascara = "0.";
        if (tipo.equals("Q")) {
            for (int i = 0; i < 3; i++) {
                mascara += "0";
            }
        } else if (tipo.equals("V")) {
            for (int i = 0; i < 2; i++) {
                mascara += "0";
            }
        }
        DecimalFormat formato = new DecimalFormat(mascara);
        return formato.format(valor);
    }

    public static String MD5String(String text)
            throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md;
        md = MessageDigest.getInstance("MD5");
        md.update(text.getBytes("iso-8859-1"), 0, text.length());
        return convertToHex(md.digest());
    }
//TODO : HASH_TRIPA dos produtos e do registro R01    
//     String tripa;
//     tripa = produto.getGTIN()
//                    + produto.getDescricao()
//                    + produto.getDescricaoPDV()
//                    + Biblioteca.formatoDecimal("Q", produto.getQuantidadeEstoque())
//                    + formatoData.format(produto.getDataEstoque())
//                    + produto.getSituacaoTributaria()
//                    + Biblioteca.formatoDecimal("V", produto.getTaxaICMS())
//                    + Biblioteca.formatoDecimal("V", produto.getValorVenda())
//                    + "0";
//     produto.setHashTripa(Biblioteca.MD5String(tripa));
//     produto.setHashIncremento(-1);
//      
//     String tripaR01;
//     tripaR01 = serieECF + cnpjEmpresa + "0";
}
