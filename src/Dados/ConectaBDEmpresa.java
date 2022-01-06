/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import Negocios.Empresa;
import java.sql.*;

/**
 *
 * @author Administrador
 */
public class ConectaBDEmpresa {

    private final ConectaBD bd = new ConectaBD();

    public void incluirEmpresa(Empresa empresa) throws SQLException {
        String consultaSQL = "INSERT INTO empresa (data_cadastro, razao_social, "
                + "nome_fantasia, endereco, num_end, comp_end, bairro, "
                + "cod_municipio, municipio, uf, cep, telefone, pais, cod_pais, "
                + "tipo_documento, cnpj, ie, cpf, rg, email) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement pstm = bd.getConectacao().prepareStatement(consultaSQL, PreparedStatement.RETURN_GENERATED_KEYS);
        pstm.setTimestamp(1, new Timestamp(empresa.getData_cadastro().getTime()));
        pstm.setString(2, empresa.getRazao_social());
        pstm.setString(3, empresa.getNome_fantasia());
        pstm.setString(4, empresa.getEndereco());
        pstm.setString(5, empresa.getNum_end());
        pstm.setString(6, empresa.getComp_end());
        pstm.setString(7, empresa.getBairro());
        pstm.setString(8, empresa.getCod_municipio());
        pstm.setString(9, empresa.getMunicipio());
        pstm.setString(10, empresa.getUf());
        pstm.setString(11, empresa.getCep());
        pstm.setString(12, empresa.getTelefone());
        pstm.setString(13, empresa.getPais());
        pstm.setString(14, empresa.getCod_pais());
        pstm.setString(15, empresa.getTipo_documento());
        pstm.setString(16, empresa.getCnpj());
        pstm.setString(17, empresa.getIe());
        pstm.setString(18, empresa.getCpf());
        pstm.setString(19, empresa.getRg());
        pstm.setString(20, empresa.getEmail());
        pstm.executeUpdate();

        ResultSet rs = pstm.getGeneratedKeys();
        if (rs.next()) {
            empresa.setId(rs.getInt(1));
        }
    }

    public Empresa consultarEmpresa(String query) throws SQLException {
        Empresa e = null;
        try (PreparedStatement st = bd.getConectacao().prepareStatement(query)) {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                e = new Empresa(rs.getInt("id"), rs.getDate("data_cadastro"), rs.getString("Razao_social"), rs.getString("Nome_fantasia"), rs.getString("Endereco"), rs.getString("Num_end"), rs.getString("Comp_end"), rs.getString("bairro"), rs.getString("Cod_municipio"), rs.getString("Municipio"), rs.getString("uf"), rs.getString("cep"), rs.getString("Telefone"), rs.getString("Pais"), rs.getString("Cod_pais"), rs.getString("Tipo_documento"), rs.getString("cnpj"), rs.getString("Ie"), rs.getString("cpf"), rs.getString("rg"), rs.getString("email"));
            }
        }
        return e;
    }

    public void atualizarEmitentesJDBC(Empresa empresa) throws SQLException {
        String consultaSQL = "update empresa set razao_social = ?,  "
                + "nome_fantasia = ?,  endereco = ?,  num_end = ?,  comp_end = ?,  bairro = ?,  "
                + "cod_municipio = ?,  municipio = ?,  uf = ?,  cep = ?,  telefone = ?,  pais = ?,  "
                + "cod_pais = ?,  tipo_documento = ?,  cnpj = ?,  ie = ?,  cpf = ?,  rg = ?,  email = ? where ID = ?";

        PreparedStatement pstm = bd.getConectacao().prepareStatement(consultaSQL);
        pstm.setString(1, empresa.getRazao_social());
        pstm.setString(2, empresa.getNome_fantasia());
        pstm.setString(3, empresa.getEndereco());
        pstm.setString(4, empresa.getNum_end());
        pstm.setString(5, empresa.getComp_end());
        pstm.setString(6, empresa.getBairro());
        pstm.setString(7, empresa.getCod_municipio());
        pstm.setString(8, empresa.getMunicipio());
        pstm.setString(9, empresa.getUf());
        pstm.setString(10, empresa.getCep());
        pstm.setString(11, empresa.getTelefone());
        pstm.setString(12, empresa.getPais());
        pstm.setString(13, empresa.getCod_pais());
        pstm.setString(14, empresa.getTipo_documento());
        pstm.setString(15, empresa.getCnpj());
        pstm.setString(16, empresa.getIe());
        pstm.setString(17, empresa.getCpf());
        pstm.setString(18, empresa.getRg());
        pstm.setString(19, empresa.getEmail());
        pstm.setInt(20, empresa.getId());
        pstm.executeUpdate();
    }
}
