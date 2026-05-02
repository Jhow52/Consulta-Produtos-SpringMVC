package com.br.loja.dao;

import com.br.loja.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ProdutoDAO - Camada de Acesso a Dados
 *
 * Responsavel por se comunicar com o banco de dados.
 * O Controller nao acessa o banco diretamente, ele chama o DAO.
 *
 * @Repository -> avisa o Spring que essa classe acessa o banco de dados.
 *                O Spring vai gerencia-la automaticamente.
 */
@Repository
public class ProdutoDAO {

    /**
     * JdbcTemplate e a ferramenta do Spring para executar SQL.
     * 
     * @Autowired -> o Spring injeta automaticamente o JdbcTemplate
     *              que foi configurado no dispatcher-servlet.xml.
     *              Nao precisamos usar "new JdbcTemplate()" manualmente.
     */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Busca um produto no banco pelo ID informado.
     *
     * @param id - o ID digitado pelo atendente na tela
     * @return o objeto Produto preenchido, ou null se nao encontrar
     */
    public Produto buscarPorId(Long id) {

        // Comando SQL que sera executado no banco
        // O "?" sera substituido pelo valor do id
        String sql = "SELECT id, nome, descricao, preco FROM produto WHERE id = ?";

        try {
            // queryForObject executa o SQL e converte o resultado em um objeto Produto
            // usando o RowMapper definido abaixo
            return jdbcTemplate.queryForObject(sql, new RowMapper<Produto>() {

                @Override
                public Produto mapRow(ResultSet rs, int rowNum) throws SQLException {
                    // Aqui pegamos cada coluna do banco e colocamos no objeto Produto
                    Produto p = new Produto();
                    p.setId(rs.getLong("id"));
                    p.setNome(rs.getString("nome"));
                    p.setDescricao(rs.getString("descricao"));
                    p.setPreco(rs.getBigDecimal("preco"));
                    return p;
                }
            }, id);

        } catch (EmptyResultDataAccessException e) {
            // Se nao encontrar nenhum produto com esse ID,
            // retorna null para o Controller tratar
            return null;
        }
    }
}