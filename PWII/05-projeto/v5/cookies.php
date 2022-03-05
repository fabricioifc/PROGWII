<?php

// setcookie('lembrar_de_mim', true);
setcookie('username', 'pikachu', time() + 10); //Expira em 10 segundos

?>

<?php require '../auth/auth.php' ?>
<?php require_once '../partials/_header.php' ?>
<?php require_once '../partials/_navbar.php' ?>

<main>
    <div class="container">
        <hr>
        <code>
            <pre><?php print_r($_SESSION) ?></pre>
            <pre><?php print_r($_COOKIE) ?></pre>
            <pre><?php print_r($_SERVER) ?></pre>
        </code>
    </div>
</main>

<?php  require_once '../partials/_footer.php' ?>