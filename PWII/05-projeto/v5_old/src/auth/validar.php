<?php

require_once '../entity/User.php';
// include_once '../utils/utils.php';
require_once '../utils/FlashMessages.php';

session_start();


// $user = new User($_REQUEST['email'], Utils::criptografar($_REQUEST['senha']));
$user = new User($_REQUEST['email'], $_REQUEST['senha']);
// $valido = (  $user_email == $email && $user_senha == $senha);

if ($user->isValido()) {
    $flash_success = "Seja bem vindo, {$user->getEmail()}";
    // header("Location: ../pages/home.php?flash-success=$flash_success");
    
    $_SESSION['user-email'] = $user->getEmail();
    // $_SESSION[FlashMessages::SUCCESS] = $flash_success;
    FlashMessages::setMessage(FlashMessages::SUCCESS, $flash_success);

    header("Location: ../../home.php");
} else {
    $flash_error = "Usuário ou Senha Inválido!";
    // header("Location: ../pages/login.php?flash-error=$flash_error");

    unset($_SESSION['user-email']);
    $_SESSION[FlashMessages::ERROR] = $flash_error;

    header("Location: ../../login.php");
}

?>