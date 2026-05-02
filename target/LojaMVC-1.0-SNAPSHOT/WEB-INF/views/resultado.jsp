<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"   uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Resultado da Busca</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .caixa {
            background-color: #ffffff;
            padding: 40px;
            border-radius: 8px;
            box-shadow: 0 2px 8px rgba(0,0,0,0.2);
            width: 400px;
        }

        h1 {
            font-size: 20px;
            color: #333333;
            margin-bottom: 24px;
            text-align: center;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        td {
            padding: 10px;
            border-bottom: 1px solid #eeeeee;
            font-size: 15px;
        }

        td:first-child {
            font-weight: bold;
            color: #555555;
            width: 100px;
        }

        .preco {
            color: #1a73e8;
            font-weight: bold;
            font-size: 17px;
        }

        .erro {
            text-align: center;
            color: #cc0000;
            font-size: 16px;
            margin-bottom: 20px;
        }

        .voltar {
            display: block;
            text-align: center;
            margin-top: 24px;
            color: #1a73e8;
            text-decoration: none;
            font-size: 14px;
        }

        .voltar:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

    <div class="caixa">
        <h1>Resultado da Busca</h1>

        <c:choose>

            <%-- Produto encontrado --%>
            <c:when test="${not empty produto}">
                <table>
                    <tr>
                        <td>ID</td>
                        <td>${produto.id}</td>
                    </tr>
                    <tr>
                        <td>Nome</td>
                        <td>${produto.nome}</td>
                    </tr>
                    <tr>
                        <td>Descricao</td>
                        <td>${produto.descricao}</td>
                    </tr>
                    <tr>
                        <td>Preco</td>
                        <td class="preco">
                            R$ <fmt:formatNumber value="${produto.preco}"
                                                 minFractionDigits="2"
                                                 maxFractionDigits="2"/>
                        </td>
                    </tr>
                </table>
            </c:when>

            <%-- Produto nao encontrado --%>
            <c:otherwise>
                <p class="erro">${erro}</p>
            </c:otherwise>

        </c:choose>

        <a class="voltar" href="${pageContext.request.contextPath}/">
            &larr; Voltar e fazer nova busca
        </a>

    </div>

</body>
</html>
