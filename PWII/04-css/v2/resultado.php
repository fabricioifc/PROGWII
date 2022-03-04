<?php 

$op = $_REQUEST['op'];
$n1 = $_REQUEST['n1'];
$n2 = $_REQUEST['n2'];

if ($n1 == "" || $n2 == "") {
    $resposta = "Informe os valores!";
} else {

    switch ($op) {
        case 'soma':
            $valor = $n1 + $n2;
            $resposta = "O resultado da $op entre $n1 e $n2 é $valor.";
            break;
        case 'sub':
            $valor = $n1 - $n2;
            $resposta = "O resultado da $op entre $n1 e $n2 é $valor.";
            break;
        case 'mult':
            $valor = $n1 * $n2;
            $resposta = "O resultado da $op entre $n1 e $n2 é $valor.";
            break;
        case 'div':
            if ($n2 == 0) {
                $resposta = "Não pode dividir por zero!";
                break;
            }
            $valor = $n1 / $n2;
            $resposta = "O resultado da $op entre $n1 e $n2 é $valor.";
            break;
                    
        default:
            $resposta = 'Operação Inválida!';
            break;
    }
}
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Resultado</title>
</head>
<body>
    <main>
        <p><?= $resposta ?></p>
        <p><a href="javascript:history.back()">Voltar</a></p>
    </main>
</body>
</html>