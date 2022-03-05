<?php require_once 'src/auth/auth.php' ?>
<?php

    // // session_destroy();
    // session_start();

    // $usuarioLogado = isset($_SESSION['user-email']);
    // // echo $usuarioLogado;
    // if (! $usuarioLogado) {
    //     $_SESSION['flash-error'] = 'Você não tem permissão para acessar essa página. Por favor, faça login.';
    //     header('Location: ./login.php');
    // }
?>


<?php require_once 'src/_partials/_header.php' ?>
<?php require_once 'src/_partials/_navbar.php' ?>

    
<main>
    <div class="container">
        <?php require_once 'src/_partials/_flash.php' ?>

        <h1>Inicio - Página Inicial</h1>
    </div>
</main>

<?php  require_once 'src/_partials/_footer.php' ?>