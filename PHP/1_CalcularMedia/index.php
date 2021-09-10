<?php

$nota1 = $_POST['nota1'];
$nota2 = $_POST['nota2'];
$acao = $_POST['calcular'];
$resultado = null;

function validar($nota1, $nota2) {
    if (!is_numeric($nota1) || !is_numeric($nota2)) {
        return 'As notas não são válidas';
    }

    return null;
}

function calcularMedia($nota1, $nota2) {    
    return ($nota1 + $nota2) / 2;
}

function verificarStatus($media) {
    if ($media < 4) {
        return 'Reprovado';
    } elseif ($media >= 7) {
        return 'Aprovado'; 
    }
    return 'Em Exame';
}

// Quando clicar no botão
if (isset($acao)) {
    $erro = validar($nota1, $nota2);
    if (!$erro) {   
        $resultado = calcularMedia($nota1, $nota2);
        $status = verificarStatus($resultado);
    }
}
?>

<!DOCTYPE html>
<html lang="en">

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

                <div class="mensagem">
                    <p><?php echo $erro?></p>
                </div>

                <form action="index.php" method="post">
                    <label for="nota1">Nota 1: </label>
                    <input type="text" name="nota1" value="<?php echo $nota1; ?>" placeholder="Informe a primeira nota"
                        autofocus required>

                    <label for="nota2">Nota 2: </label>
                    <input type="text" name="nota2" value="<?php echo $nota2; ?>" placeholder="Informe a segunda nota"
                        required>

                    <input type="submit" value="Calcular Média Simples" name="calcular">
                </form>
                <div class="resultado">
                    <?php if ($resultado) { ?>
                    <hr>
                    <dl>
                        <dt style="font-weight: bold;">Resultado</dt>
                        <dd>Média: <strong><?php echo $resultado; ?></strong></dd>
                        <dd>Status: <strong><?php echo $status; ?></strong></dd>
                    </dl>

                    <?php } ?>

                </div>
            </fieldset>
        </section>
    </div>
</body>

</html>