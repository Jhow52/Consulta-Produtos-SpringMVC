package com.br.loja.controller;

import com.br.loja.dao.ProdutoDAO;
import com.br.loja.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * ProdutoController - Camada Controller (C do MVC)
 *
 * Recebe as requisicoes do navegador, chama o DAO
 * e decide qual pagina JSP sera exibida.
 *
 * @Controller -> avisa o Spring que essa classe e um Controller.
 *               O DispatcherServlet vai encaminhar as requisicoes para ela.
 */
@Controller
public class ProdutoController {

    /**
     * O Spring injeta o ProdutoDAO automaticamente aqui.
     * Nao precisamos criar com "new ProdutoDAO()".
     */
    @Autowired
    private ProdutoDAO produtoDAO;

    /**
     * Abre a pagina inicial com o formulario de busca.
     *
     * @GetMapping("/") -> responde quando o usuario acessa a URL raiz
     *                     por exemplo: http://localhost:8080/LojaMVC/
     */
    @GetMapping("/")
    public String paginaInicial() {
        // Retorna o nome da view -> WEB-INF/views/index.jsp
        return "index";
    }

    /**
     * Recebe o ID digitado pelo atendente e busca o produto.
     *
     * @GetMapping("/buscar") -> responde quando o formulario e enviado
     *                           por exemplo: http://localhost:8080/LojaMVC/buscar?id=1
     *
     * @RequestParam -> captura o valor do campo "id" do formulario
     * Model         -> usado para enviar dados para a pagina JSP
     */
    @GetMapping("/buscar")
    public String buscarProduto(
            @RequestParam(value = "id", required = false) Long id,
            Model model) {

        // Verifica se o ID foi informado
        if (id == null) {
            model.addAttribute("erro", "Por favor, informe o ID do produto.");
            return "resultado";
        }

        // Chama o DAO para buscar o produto no banco de dados
        Produto produto = produtoDAO.buscarPorId(id);

        if (produto != null) {
            // Produto encontrado: envia o objeto para a pagina JSP
            // Na JSP podemos usar ${produto.nome}, ${produto.preco}, etc.
            model.addAttribute("produto", produto);
        } else {
            // Produto nao encontrado: envia mensagem de erro para a JSP
            model.addAttribute("erro", "Produto não encontrado.");
        }

        // Retorna o nome da view -> WEB-INF/views/resultado.jsp
        return "resultado";
    }
}