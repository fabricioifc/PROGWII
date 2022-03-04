<?php

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

$resultado = null;
$erro = null;
$nota1 = null;
$nota2 = null;

// Quando clicar no botão
if (isset($_REQUEST['calcular'])) {
    $nota1 = $_REQUEST['nota1'];
    $nota2 = $_POST['nota2'];

    // Formato brasileiro
    $nota1_f = str_replace(',','.',$nota1);
    $nota2_f = str_replace(',','.',$nota2);

    $erro = validar($nota1_f, $nota2_f);
    if (!$erro) {   
        $resultado = calcularMedia($nota1_f, $nota2_f);
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

        <section>
            <code>
                <h3>Descrição da Tarefa</h3> 
                <dl>
                    <dd>Calcular a média aritmética simples de duas notas para o aluno</dd>
                    <dd>Verificar se o aluno foi aprovado (>= 7), reprovado (< 4) ou em exame (>=4 e < 7)</dd>
                </dl>
            </code>
        </section>
    </div>
</body>

</html>