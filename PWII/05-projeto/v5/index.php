<?php require_once './auth/auth.php' ?>
<?php require_once './partials/_header.php' ?>
<?php require_once './partials/_navbar.php' ?>

<?php

// require_once './utils/FlashMessages.php';

// FlashMessages::setMessage(
//     FlashMessages::SUCCESS, 
//     'Está é a página inicial.'
// );
?>

    
<main>
    <div class="container">
        <?php require_once './partials/_flash.php' ?>

        <h1>Meu primeiro site com PHP e Bootstrap.</h1>
    </div>
</main>

<?php require_once './partials/_footer.php' ?>

<?php // session_destroy(); ?>