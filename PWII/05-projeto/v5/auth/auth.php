<?php
    // session_start();

    // $user_email = $_SESSION['user-email'] ?? null;

    // $flash_success  = isset($_SESSION['flash-success']) ? $_SESSION['flash-success'] : null;
    // $flash_error    = isset($_SESSION['flash-error'])   ? $_SESSION['flash-error'] : null;
    
    // $show_success   = isset($_SESSION['flash-success']) ? '' : 'd-none';
    // $show_error     = isset($_SESSION['flash-error'])   ? '' : 'd-none';

    // unset($_SESSION['flash-success']);
    // unset($_SESSION['flash-error']);

    require_once '../utils/FlashMessages.php';

    // session_destroy();
    session_start();

    $user_email = $_SESSION['user-email'] ?? null;
    // echo $usuarioLogado;
    if (!$user_email) {
        FlashMessages::setMessage(
            FlashMessages::ERROR, 
            'Você não tem permissão para acessar essa página. Por favor, faça login.'
        );
        header("Location: ../pages/login.php");
        exit; // precisa para não executar o que tiver abaixo disso
    }