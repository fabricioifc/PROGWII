<?php

session_start();
unset($_SESSION['user-email']);

$flash_success = "Logout efetuado com sucesso!";
$_SESSION['flash-success'] = $flash_success;

header("Location: /");