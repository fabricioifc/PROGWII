<?php 

    function gerarNumerosAleatoriamente($quantidade) {
        $numbers = range(1, 60);
        shuffle($numbers);
        $numeros = array_slice($numbers, 0, $quantidade);
        sort($numeros);
        return $numeros;
    }

    if (isset($_REQUEST['enviar'])) {
        $quantidade = $_REQUEST['q'];
        $numeros = gerarNumerosAleatoriamente($quantidade);
        $numeros = implode(' - ', $numeros);
    }

?>

<!DOCTYPE html>
<html lang="pt-BR">

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
            <form action="index.php" method="GET" name="formulario">
        
                <div>
                    <input type="hidden" name="q" value="6">
                    <input type="submit" value="Gerar Números" name="enviar">
                </div>

                <div class="resultado">
                    <?php if(isset($numeros)) { ?>
                    <h3><?php echo $numeros ?></h3>
                    <?php } ?>
                </div>
            </form>
            
        </fieldset>
        


    </div>
</body>

</html>