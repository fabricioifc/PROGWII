<?php

$user_email = 'teste@teste.com';
$user_senha = '123456';

$email = $_REQUEST['email'];
$senha = $_REQUEST['senha'];

$valido = ($user_email == $email && $user_senha == $senha);

// var_dump($valido);

if ($valido) {
    header('Location: ../home.php');
} else {
    header('Location: ../login.php');
}

?>