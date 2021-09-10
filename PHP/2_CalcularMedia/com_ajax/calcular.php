<?php
header('Content-Type: application/json');

if($_SERVER['REQUEST_METHOD'] === 'POST') {

    $nota1 = $_POST['nota1'];
    $nota2 = $_POST['nota2'];
    $resultado = null;

    // Formato brasileiro
    $nota1 = str_replace(',','.',$nota1);
    $nota2 = str_replace(',','.',$nota2);

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
            return array('Reprovado','#800000');
        } elseif ($media >= 7) {
            return array('Aprovado', 'darkgreen'); 
        }
        return array('Em Exame', '#ff8c00');
    }

    $erro = validar($nota1, $nota2);
    if (!$erro) {   
        $resultado = calcularMedia($nota1, $nota2);
        $status = verificarStatus($resultado);
    }

    echo json_encode(
        array(
            "form" => $_POST,
            "media" => $resultado,
            "status" => $status,
            "erro" => $erro
        )
    );
}