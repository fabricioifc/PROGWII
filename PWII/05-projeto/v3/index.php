<?php

    session_start();

    $user_email = $_SESSION['user-email'] ?? null;

    $flash_success  = isset($_SESSION['flash-success']) ? $_SESSION['flash-success'] : null;
    $flash_error    = isset($_SESSION['flash-error'])   ? $_SESSION['flash-error'] : null;
    
    $show_success   = isset($_SESSION['flash-success']) ? '' : 'd-none';
    $show_error     = isset($_SESSION['flash-error'])   ? '' : 'd-none';

    unset($_SESSION['flash-success']);
    unset($_SESSION['flash-error']);

?>

<?php require_once './_partials/_header.php' ?>
    
<main>
    <div class="container">

        <div class="alert alert-success <?=$show_success?>">
            <?= $flash_success ?>
        </div>

        <div class="alert alert-danger <?=$show_error?>">
            <?= $flash_error ?>
        </div>

        <h1>Meu primeiro site com PHP e Bootstrap.</h1>
    </div>
</main>


<?php require_once './_partials/_footer.php' ?>