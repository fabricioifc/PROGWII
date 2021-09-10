<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Calcular Média</title>

    <link rel="stylesheet" href="estilos.css">
</head>

<body>
    <div class="container">
        <section id="main">
            <fieldset>
                <h2>Calcular a Média Simples</h2>

                <div class="mensagem"></div>

                <form method="post" id="formulario">
                    <label for="nota1">Nota 1: </label>
                    <input type="text" name="nota1" placeholder="Informe a primeira nota" autofocus required>

                    <label for="nota2">Nota 2: </label>
                    <input type="text" name="nota2" placeholder="Informe a segunda nota" required>

                    <input type="submit" value="Calcular Média Simples" name="calcular">
                </form>
                <div class="resultado">
                    <hr>
                    <dl>
                        <dt style="font-weight: bold;">Resultado</dt>
                        <dd>Média: <strong id="media"></strong></dd>
                        <dd>Status: <strong id="status"></strong></dd>
                    </dl>

                </div>
            </fieldset>
        </section>
    </div>

    <script src="main.js"></script>
</body>

</html>