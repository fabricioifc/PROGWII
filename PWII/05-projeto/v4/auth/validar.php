<?php

session_start();

function criptografar($senha) {
    // Criptografia com bcrypt
    $options['salt'] = 'asmd9asd9amd0asmd07b82'; // precisa de 22 caracteres
    // SALT: se não informado, bcrypt gera randomicamente
    return password_hash($senha, PASSWORD_BCRYPT, $options);
}

$user_email = 'teste@teste.com';
$email = $_REQUEST['email'];

// $user_senha = '123456';
$user_senha = criptografar('123456');
$senha = criptografar($_REQUEST['senha']);

// print_r($user_senha);
// echo '<br />';
// print_r($senha);
// exit;

$valido = ($user_email == $email && $user_senha == $senha);
// var_dump($valido);

if ($valido) {
    $flash_success = "Seja bem vindo, $email!";
    // header("Location: ../home.php?flash-success=$flash_success");
    
    $_SESSION['user-email'] = $email;
    $_SESSION['flash-success'] = $flash_success;

    header("Location: ../home.php");
} else {
    $flash_error = "Usuário ou Senha Inválido!";
    // header("Location: ../login.php?flash-error=$flash_error");

    unset($_SESSION['user-email']);
    $_SESSION['flash-error'] = $flash_error;

    header("Location: ../login.php");
}

?>