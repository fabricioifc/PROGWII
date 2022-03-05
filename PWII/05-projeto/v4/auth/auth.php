<?php
    session_start();

    $user_email = $_SESSION['user-email'] ?? null;

    $flash_success  = isset($_SESSION['flash-success']) ? $_SESSION['flash-success'] : null;
    $flash_error    = isset($_SESSION['flash-error'])   ? $_SESSION['flash-error'] : null;
    
    $show_success   = isset($_SESSION['flash-success']) ? '' : 'd-none';
    $show_error     = isset($_SESSION['flash-error'])   ? '' : 'd-none';

    unset($_SESSION['flash-success']);
    unset($_SESSION['flash-error']);