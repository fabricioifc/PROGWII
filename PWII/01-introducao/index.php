<!-- 
    1. Instalar e configurar:
        - PHP, 
        - VSCODE (PHP Intelephense)
        - testar na linha de comando e no navegador
        - rodar no git bash (php -S localhost:8000)

-->

<?php
// Saída

    echo "Olá Mundo!\n";
    echo 'Olá Mundo!\n';
    echo("Olá Mundo!\n");

    print("Olá Mundo!<br />");
    printf("Olá Mundo! %d", 2+2);
    printf("Olá Mundo! %f", 2+2);
?>

<?= "Olá Mundo!" ?>

<a href="https://www.php.net/manual/pt_BR/language.basic-syntax.php">
    <?php echo "Documentação do PHP" ?>
</a>

<hr>
<?php
// Variáveis
    $nome = "Fabricio";
    $sobrenome = "Bizotto";

    // CamelCase
    $nomeCompleto  = $nome . " " . $sobrenome;
    // snakeCase
    $nome_completo = $nome . " " . $sobrenome;
    // interpolação
    $nomeInterpolado = "$nome $sobrenome";

    echo "<br /><br />";
    echo $nomeCompleto;
    echo "<br />";
    echo $nome_completo;
    echo "<br />";
    echo $nomeInterpolado;
    echo "<br />";

?>

<!-- Padrões recomendados para PHP: https://tableless.com.br/psr-padrao-para-codigo-php/ -->

<hr>
<?php
// Operadores
echo 2 + 2, "<br />";
echo 2 - 2, "<br />";
echo 2 * 2, "<br />";
echo 2 / 2, "<br />";
echo 2 / 0, "<br />";
echo 2 ** 2, "<br />";
echo 2 % 2, "<br />";
$soma = 2 + 2;
echo $soma, "<br />";

?>

<hr>
<?php 
// Vetor
// https://www.php.net/manual/pt_BR/language.types.array.php

$frutas = ['banana', 'maçã', 'uva', 5, false, 18];
echo $frutas, '<br />';
echo $frutas[0], '<br />';
echo sizeof($frutas), '<br />';
var_dump($frutas);
?>

<hr>
<?php
// Hash
$aluno = [
    "nome" => "João",
    "idade" => 15
];

var_dump($aluno);
echo '<br />';
echo $aluno['idade'];

$alunos = [
    0 => [
        "nome" => "João",
        "idade" => 15
    ]
];

echo '<br />';
var_dump($alunos);
echo '<br />';
echo $alunos[0]['nome'];
echo '<br />';
echo gettype($alunos[0]['nome']);
echo '<br />';

?>

<hr>
<?php 
// Condicional
// https://www.w3schools.com/php/php_operators.asp

$x = 10;
$y = '10';

$teste = $x == $y;
// $teste = $x === $y;
// $teste = $x > $y;
echo $teste;
echo '<br />';
echo $x + $y; // soma

echo '<br />';
if ($x > 0 && $x <= 10) {
    echo "X está entre 1 e 10";
} else {
    echo "X não está entre 1 e 10";
}

echo '<br />';
if ($x == 10 || $y == '10') {
    echo 'x ou y são iguais a 10';
}

echo '<br />';
// IF ternário
$x = 10;
echo $x % 2 == 0 ? 'X é par' : 'X é ímpar';


?>

<hr>
<?php
// loop - While

    echo '<br />';
    $contador = 10;   
    while ($contador > 0) {
        echo "loop => $contador", '<br />';
        $contador--;
    }

// loop - for

echo '<br />';
for ($i=0; $i < 10; $i++) { 
    echo "loop => $i", '<br />';
}
// for com sizeof ou count

?>

<hr>
<!-- soma texto -->
<?= 10 + "x" ?>
<?= '<br />' ?>
<?= 10 + "2x" ?>

<hr>
<?php

    // tipagem/cast

    $x = '10';
    $cast = (int) $x;

    var_dump($x);
    echo "<br />";
    var_dump($cast);
?>

<hr>

<!-- 01 - Calcular a média das notas de um aluno -->
<?php
    $n1 = 7;
    $n2 = 4.8;

    $media = ($n1 + $n2) / 2;

    echo "A média do aluno é $media";

?>

<hr>

<!-- 02 - Calcular a média das notas de um aluno -->
<?php
    $n1 = 7;
    $n2 = 4.8;

    function calcularMedia($n1, $n2){
        $media = ($n1 + $n2) / 2;
        return $media;
    }
   

    printf("A média do aluno é %s", calcularMedia($n1, $n2));

?>

<hr>

<!-- 03 - Calcular a média das notas de um aluno -->
<?php
    $notas = [7, 4.8, 8.1, 7.4];

    function calcularMediaNotas($notas){
        $soma = 0;
        foreach ($notas as $key => $value) {
            $soma += $value;
        }
        // $soma = array_sum($notas);
        return $soma / sizeof($notas);
    }
   

    printf("A média do aluno é %.2f", calcularMediaNotas($notas));

?>