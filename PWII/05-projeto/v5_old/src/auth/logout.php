<?php

require_once '../utils/FlashMessages.php';

session_start();
unset($_SESSION['user-email']);

$flash_success = "Logout efetuado com sucesso!";
$_SESSION[FlashMessages::SUCCESS] = $flash_success;

header("Location: ../../");