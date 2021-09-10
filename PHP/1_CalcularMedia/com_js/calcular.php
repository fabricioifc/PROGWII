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