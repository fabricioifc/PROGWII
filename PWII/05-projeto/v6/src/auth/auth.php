<?php // namespace MeuAPP\auth; ?>
<?php // require __DIR__ . '/../../vendor/autoload.php' ?>
<?php
    // require_once './utils/FlashMessages.php';
    use MeuApp\utils\FlashMessages;

    // session_destroy();
    session_start();

    $user_email = $_SESSION['user-email'] ?? null;
    $permitidas = ['/','/index.php', '/login.php'];

    $acesso_permitido = $user_email || in_array($_SERVER['REQUEST_URI'], $permitidas);


    // echo $usuarioLogado;
    if (!$acesso_permitido) {
        FlashMessages::setMessage(
            FlashMessages::ERROR, 
            "Você não tem permissão para acessar essa página. Por favor, faça login."
        );

        // var_dump($_SESSION);
        header("Location: ../../login.php");
        exit; // precisa para não executar o que tiver abaixo disso
    }