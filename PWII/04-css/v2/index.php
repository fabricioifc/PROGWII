<!-- Resolvendo o exercício da calculadora, com css -->
<!-- Elementos HTML: inline vs block -> https://developer.mozilla.org/pt-BR/docs/Web/HTML/Block-level_elements -->

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Minha Calculadora</title>

    <link rel="stylesheet" href="estilos.css">
</head>

<body>
    
    <form action="resultado.php" method="get">
        <legend><h2>Minha Calculadora</h2></legend>
        <hr>
        <div>
            <label for="n1">Número 1</label>
            <input type="number" name="n1" id="n1" autofocus>
        </div>

        <div>
            <label for="n2">Número 2</label>
            <input type="number" name="n2" id="n2">
        </div>

        <div>
            <input type="radio" name="op" id="soma" value="soma" checked>
            <label for="soma">Soma</label>
            <input type="radio" name="op" id="sub" value="sub">
            <label for="sub">Subtração</label>
            <input type="radio" name="op" id="mult" value="mult">
            <label for="mult">Multiplicação</label>
            <input type="radio" name="op" id="div" value="div">
            <label for="div">Divisão</label>
        </div>

        <div>
            <input type="submit" value="Calcular">
        </div>
    </form>
</body>

</html>