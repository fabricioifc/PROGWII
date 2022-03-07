<?php namespace MeuAPP\auth; ?>
<?php require __DIR__ . '/../../vendor/autoload.php' ?>
<?php

// require_once '../utils/FlashMessages.php';
use MeuApp\utils\FlashMessages;

// session_start();
unset($_SESSION['user-email']);

$flash_success = "Logout efetuado com sucesso!";
$_SESSION[FlashMessages::SUCCESS] = $flash_success;

header("Location: /");