package com.br.loja.controller;

import com.br.loja.dao.ProdutoDAO;
import com.br.loja.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProdutoController {

    @Autowired
    private ProdutoDAO produtoDAO;

    @GetMapping("/")
    public String paginaInicial() {
        return "index";
    }

    @GetMapping("/buscar")
    public String buscarProduto(
            @RequestParam(value = "id", required = false) Long id,
            Model model) {

        if (id == null) {
            model.addAttribute("erro", "Por favor, informe o ID do produto.");
            return "resultado";
        }

        Produto produto = produtoDAO.buscarPorId(id);

        if (produto != null) {
            model.addAttribute("produto", produto);
        } else {
            model.addAttribute("erro", "Produto não encontrado.");
        }
        return "resultado";
    }
}