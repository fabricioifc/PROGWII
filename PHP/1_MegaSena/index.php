<?php 

    function gerarNumeros() {
        $lista = [];
        while (sizeof($lista) < 6) {
            $numero = rand(1,60);
            if (!in_array($numero, $lista)) {
                array_push($lista, $numero);
            }
        }
        return $lista;
    }

    if (isset($_GET['enviar'])) {
        $numeros = gerarNumeros();
        sort($numeros);
        $numeros = implode(' - ', $numeros);
    }

?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mega-Sena</title>

    <link rel="stylesheet" href="estilos.css">
</head>

<body>
    <div class="container">

        <fieldset style="text-align: center;">
            <h2>Gerador de Números para a Mega-Sena</h2>
            <form action="index.php" method="get" name="formulario">
                <input type="submit" value="Gerar Números" name="enviar">
            </form>

            <div class="resultado">
                <?php if(isset($numeros)) { ?>
                <h3><?php echo $numeros ?></h3>
                <?php } ?>
            </div>
        </fieldset>


    </div>
</body>

</html>