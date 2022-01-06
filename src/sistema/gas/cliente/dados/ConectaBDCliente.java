package sistema.gas.cliente.dados;

import Dados.ConectaBD;
import Negocios.Cliente;
import Negocios.HistoricoPagamentoCliente;
import java.sql.*;
import java.util.ArrayList;

public class ConectaBDCliente implements IBancoCliente {

    private final ConectaBD bd = new ConectaBD();
    private String consultaSQL;
    private PreparedStatement pstm;
    private ResultSet rs;

    public static ConectaBDCliente getInstance() {
        return ConectaBDClienteHolder.INSTANCE;
    }

    @Override
    public void incluirCliente(Cliente cliente) throws SQLException {
        consultaSQL = "INSERT INTO cliente (nome,apelido,cpf,rg,orgao_rg,cnpj,"
                + "ie,tipo_pessoa,endereco,num_end,comp_end,bairro,cep,cod_municipio,"
                + "municipio,uf,telefone,celular,obs,email,data_nasc ,data_cadastro,"
                + "excluido,id_usuario_insercao, quantidade_dias_visita) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        pstm = bd.getConectacao().prepareStatement(consultaSQL, PreparedStatement.RETURN_GENERATED_KEYS);
        pstm.setString(1, cliente.getNome());
        pstm.setString(2, cliente.getApelido());
        pstm.setString(3, cliente.getCpf());
        pstm.setString(4, cliente.getRg());
        pstm.setString(5, cliente.getOrgao_rg());
        pstm.setString(6, cliente.getCnpj());
        pstm.setString(7, cliente.getIe());
        pstm.setString(8, cliente.getTipo_pessoa());
        pstm.setString(9, cliente.getEndereco());
        pstm.setString(10, cliente.getNum_end());
        pstm.setString(11, cliente.getComp_end());
        pstm.setString(12, cliente.getBairro());
        pstm.setString(13, cliente.getCep());
        pstm.setString(14, cliente.getCod_municipio());
        pstm.setString(15, cliente.getMunicipio());
        pstm.setString(16, cliente.getUf());
        pstm.setString(17, cliente.getTelefone());
        pstm.setString(18, cliente.getCelular());
        pstm.setString(19, cliente.getObs());
        pstm.setString(20, cliente.getEmail());
        if (cliente.getData_nasc() != null) {
            pstm.setDate(21, new Date(cliente.getData_nasc().getTime()));
        } else {
            pstm.setNull(21, java.sql.Types.DATE);
        }
        if (cliente.getData_cadastro() != null) {
            pstm.setTimestamp(22, new Timestamp(cliente.getData_cadastro().getTime()));
        } else {
            pstm.setNull(22, java.sql.Types.DATE);
        }
        pstm.setBoolean(23, cliente.isExcluido());
        pstm.setInt(24, cliente.getId_usuario_insercao());
        pstm.setInt(25, cliente.getQuantidade_dias_visita());
        pstm.executeUpdate();
        rs = pstm.getGeneratedKeys();
        if (rs.next()) {
            cliente.setId(rs.getInt(1));
        }
    }

    @Override
    public ArrayList consultarCliente(String query) throws SQLException {
        ArrayList lista = new ArrayList();
        Cliente cliente;
        try (PreparedStatement st = bd.getConectacao().prepareStatement(query)) {
            rs = st.executeQuery();
            while (rs.next()) {
                cliente = new Cliente();
                cliente.setApelido(rs.getString("apelido"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setCelular(rs.getString("celular"));
                cliente.setCep(rs.getString("cep"));
                cliente.setCod_municipio(rs.getString("cod_municipio"));
                cliente.setComp_end(rs.getString("comp_end"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setData_nasc(rs.getDate("data_nasc"));
                cliente.setData_cadastro(rs.getDate("data_cadastro"));
                cliente.setEmail(rs.getString("email"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setUf(rs.getString("uf"));
                cliente.setId(rs.getInt("id"));
                cliente.setCnpj(rs.getString("cnpj"));
                cliente.setIe(rs.getString("ie"));
                cliente.setMunicipio(rs.getString("municipio"));
                cliente.setNome(rs.getString("nome"));
                cliente.setNum_end(rs.getString("num_end"));
                cliente.setOrgao_rg(rs.getString("orgao_rg"));
                cliente.setObs(rs.getString("obs"));
                cliente.setRg(rs.getString("rg"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setTipo_pessoa(rs.getString("tipo_pessoa"));
                cliente.setExcluido(rs.getBoolean("excluido"));
                cliente.setQuantidade_dias_visita(rs.getInt("quantidade_dias_visita"));
                lista.add(cliente);
            }
        }
        return lista;
    }

    @Override
    public Cliente consultarCliente(int id_cliente) throws SQLException {
        Cliente cliente = null;
        try (PreparedStatement st = bd.getConectacao().prepareStatement("SELECT * FROM CLIENTE WHERE ID = " + id_cliente + "")) {
            rs = st.executeQuery();
            if (rs.next()) {
                cliente = new Cliente();
                cliente.setApelido(rs.getString("apelido"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setCelular(rs.getString("celular"));
                cliente.setCep(rs.getString("cep"));
                cliente.setCod_municipio(rs.getString("cod_municipio"));
                cliente.setComp_end(rs.getString("comp_end"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setData_nasc(rs.getDate("data_nasc"));
                cliente.setData_cadastro(rs.getDate("data_cadastro"));
                cliente.setEmail(rs.getString("email"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setUf(rs.getString("uf"));
                cliente.setId(rs.getInt("id"));
                cliente.setCnpj(rs.getString("cnpj"));
                cliente.setIe(rs.getString("ie"));
                cliente.setMunicipio(rs.getString("municipio"));
                cliente.setNome(rs.getString("nome"));
                cliente.setNum_end(rs.getString("num_end"));
                cliente.setOrgao_rg(rs.getString("orgao_rg"));
                cliente.setObs(rs.getString("obs"));
                cliente.setRg(rs.getString("rg"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setTipo_pessoa(rs.getString("tipo_pessoa"));
                cliente.setExcluido(rs.getBoolean("excluido"));
                cliente.setQuantidade_dias_visita(rs.getInt("quantidade_dias_visita"));
            }
        }
        return cliente;
    }

    @Override
    public ArrayList<Cliente> consultarClienteVisita() throws SQLException {
        ArrayList lista = new ArrayList();
        Cliente cliente;
        String query = "select concat(c.id, '-', c.nome) as cliente, "
                + "concat(c.endereco, '-', c.num_end, '-', c.municipio, '-', c.uf) as endereco from cliente c where c.id in (select max(vc.cliente_id) from venda_cabecalho vc where "
                + "DATEDIFF(now(), date_format(vc.data_venda, '%Y-%m-%d')) >= (c.quantidade_dias_visita - 1) group by vc.cliente_id)";
        try (PreparedStatement st = bd.getConectacao().prepareStatement(query)) {
            rs = st.executeQuery();
            while (rs.next()) {
                cliente = new Cliente();
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setNome(rs.getString("cliente"));
                lista.add(cliente);
            }
        }
        return lista;
    }

    @Override
    public void editarCliente(Cliente cliente) throws SQLException {
        consultaSQL = "update cliente set nome = ?, apelido = ?, cpf = ?, rg = ?, orgao_rg = ?, "
                + "cnpj = ?, ie = ?, tipo_pessoa = ?, endereco = ?, num_end = ?, "
                + "comp_end = ?, bairro = ?, cep = ?, cod_municipio = ?, municipio = ?, "
                + "uf = ?, telefone = ?, celular = ?, obs = ?, email = ?, data_nasc  = ?, "
                + "data_edicao = ?, id_usuario_edicao = ?, quantidade_dias_visita = ? where id = ?";
        pstm = bd.getConectacao().prepareStatement(consultaSQL);
        pstm.setString(1, cliente.getNome());
        pstm.setString(2, cliente.getApelido());
        pstm.setString(3, cliente.getCpf());
        pstm.setString(4, cliente.getRg());
        pstm.setString(5, cliente.getOrgao_rg());
        pstm.setString(6, cliente.getCnpj());
        pstm.setString(7, cliente.getIe());
        pstm.setString(8, cliente.getTipo_pessoa());
        pstm.setString(9, cliente.getEndereco());
        pstm.setString(10, cliente.getNum_end());
        pstm.setString(11, cliente.getComp_end());
        pstm.setString(12, cliente.getBairro());
        pstm.setString(13, cliente.getCep());
        pstm.setString(14, cliente.getCod_municipio());
        pstm.setString(15, cliente.getMunicipio());
        pstm.setString(16, cliente.getUf());
        pstm.setString(17, cliente.getTelefone());
        pstm.setString(18, cliente.getCelular());
        pstm.setString(19, cliente.getObs());
        pstm.setString(20, cliente.getEmail());
        if (cliente.getData_nasc() != null) {
            pstm.setDate(21, new Date(cliente.getData_nasc().getTime()));
        } else {
            pstm.setNull(21, java.sql.Types.DATE);
        }
        pstm.setDate(22, new Date(cliente.getData_edicao().getTime()));
        pstm.setInt(23, cliente.getId_usuario_edicao());
        pstm.setInt(24, cliente.getQuantidade_dias_visita());
        pstm.setInt(25, cliente.getId());
        pstm.executeUpdate();
    }

    @Override
    public void excluirCliente(Cliente cliente) throws SQLException {

        consultaSQL = "UPDATE cliente set excluido = ?, data_exclusao = ?, id_usuario_exclusao = ? where id = ?";
        pstm = bd.getConectacao().prepareStatement(consultaSQL);
        pstm.setBoolean(1, cliente.isExcluido());
        pstm.setDate(2, new Date(new java.util.Date().getTime()));
        pstm.setInt(3, cliente.getId_usuario_exclusao());
        pstm.setInt(4, cliente.getId());
        pstm.executeUpdate();
    }

    @Override
    public ArrayList<HistoricoPagamentoCliente> consultarHistoricoPagamentosClienteJDBC(int id_cliente) throws SQLException {
        ArrayList lista = new ArrayList();
        HistoricoPagamentoCliente historicoPagamentoCliente;
        try (PreparedStatement st = bd.getConectacao().prepareStatement("select c.id_contas_receber as id_conta, p.data_vencimento_parcelas_receber as data_vencimento, "
                + "h.data_recebimento as data_recebimento, h.hora_recebimento as hora_recebimento, c.referente as referente,p.valor as valor, h.valor_recebido as valor_recebido from contas_receber c, parcelas_receber p, "
                + "parcelas_receber_historico_recebimento h where c.id_cliente = " + id_cliente + " and c.id_contas_receber = p.id_contas_receber "
                + "and h.id_parcelas_receber = p.id_parcelas_receber")) {
            rs = st.executeQuery();
            while (rs.next()) {
                historicoPagamentoCliente = new HistoricoPagamentoCliente();
                historicoPagamentoCliente.setData_recebimento(rs.getDate("data_recebimento"));
                historicoPagamentoCliente.setData_vencimento_parcela(rs.getDate("data_vencimento"));
                historicoPagamentoCliente.setHora_recebimento(rs.getString("hora_recebimento"));
                historicoPagamentoCliente.setId_conta(rs.getInt("id_conta"));
                historicoPagamentoCliente.setReferente(rs.getString("referente"));
                historicoPagamentoCliente.setValor_recebido(rs.getBigDecimal("valor_recebido"));
                historicoPagamentoCliente.setValor_total(rs.getBigDecimal("valor"));
                lista.add(historicoPagamentoCliente);
            }
        }
        return lista;
    }

    private static class ConectaBDClienteHolder {

        private static final ConectaBDCliente INSTANCE = new ConectaBDCliente();
    }
}
