<?php 

$op = $_REQUEST['op'];
$n1 = $_REQUEST['n1'];
$n2 = $_REQUEST['n2'];

$resposta = null;

switch ($op) {
    case 'soma':
        $resposta = $n1 + $n2;
        break;
    case 'sub':
        $resposta = $n1 - $n2;
        break;
    case 'mult':
        $resposta = $n1 * $n2;
        break;
    case 'div':
        $resposta = $n1 / $n2;
        break;
                
    default:
        $resposta = 'Operação Inválida!';
        break;
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
        <p><?= "O resultado da $op entre $n1 e $n2 é $resposta." ?></p>
        <p><a href="javascript:history.back()">Voltar</a></p>
    </main>
</body>
</html>