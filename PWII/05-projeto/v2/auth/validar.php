<?php

session_start();

$user_email = 'teste@teste.com';
$user_senha = '123456';

$email = $_REQUEST['email'];
$senha = $_REQUEST['senha'];

$valido = ($user_email == $email && $user_senha = $senha);
// var_dump($valido);

if ($valido) {
    $flash_success = "Seja bem vindo, $email!";
    // header("Location: ../pages/home.php?flash-success=$flash_success");
    
    $_SESSION['user-email'] = $email;
    $_SESSION['flash-success'] = $flash_success;

    header("Location: ../pages/home.php");
} else {
    $flash_error = "Usuário ou Senha Inválido!";
    // header("Location: ../pages/login.php?flash-error=$flash_error");

    unset($_SESSION['user-email']);
    $_SESSION['flash-error'] = $flash_error;

    header("Location: ../pages/login.php");
}

?>