<?php

$user_email = 'teste@teste.com';
$user_senha = '123456';

$email = $_REQUEST['email'];
$senha = $_REQUEST['senha'];

$valido = ($user_email == $email && $user_senha = $senha);

// var_dump($valido);

if ($valido) {
    header('Location: ../pages/home.php');
} else {
    header('Location: ../pages/login.php');
}

?>