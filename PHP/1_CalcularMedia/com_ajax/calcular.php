<?php
header('Content-Type: application/json');

if($_SERVER['REQUEST_METHOD'] === 'POST') {

    $nota1 = json_decode($_POST['nota1']);
    $nota2 = json_decode($_POST['nota2']);
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

    $erro = validar($nota1, $nota2);
    if (!$erro) {   
        $resultado = calcularMedia($nota1, $nota2);
        $status = verificarStatus($resultado);
    }

    echo json_encode(
        array(
            "media" => $resultado,
            "status" => $status,
            "erro" => $erro
        )
    );
}