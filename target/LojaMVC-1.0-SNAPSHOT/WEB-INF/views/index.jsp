<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Consulta de Produtos</title>
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
            text-align: center;
            width: 350px;
        }

        h1 {
            font-size: 22px;
            color: #333333;
            margin-bottom: 24px;
        }

        label {
            display: block;
            text-align: left;
            margin-bottom: 6px;
            font-size: 14px;
            color: #555555;
        }

        input[type="number"] {
            width: 100%;
            padding: 10px;
            font-size: 15px;
            border: 1px solid #cccccc;
            border-radius: 4px;
            box-sizing: border-box;
            margin-bottom: 16px;
        }

        button {
            width: 100%;
            padding: 12px;
            background-color: #1a73e8;
            color: white;
            font-size: 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        button:hover {
            background-color: #1558b0;
        }
    </style>
</head>
<body>

    <div class="caixa">
        <h1>Consulta de Produtos</h1>

        <form action="${pageContext.request.contextPath}/buscar" method="get">

            <label for="id">Codigo do Produto (ID):</label>

            <input type="number" id="id" name="id" min="1" placeholder="Ex: 1, 2, 3..." required />

            <button type="submit">Buscar</button>

        </form>
    </div>

</body>
</html>
