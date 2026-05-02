package com.br.loja.dao;

import com.br.loja.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class ProdutoDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Produto buscarPorId(Long id) {

        String sql = "SELECT id, nome, descricao, preco FROM produto WHERE id = ?";

        try {
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
            return null;
        }
    }
}