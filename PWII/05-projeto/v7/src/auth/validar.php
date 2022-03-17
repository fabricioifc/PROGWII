<?php // namespace MeuAPP\auth; ?>
<?php require __DIR__ . '/../../vendor/autoload.php' ?>
<?php

// Não usaremos mais require
// require_once '../entity/User.php';
// require_once '../utils/FlashMessages.php';
use MeuApp\entities\User;
use MeuApp\utils\FlashMessages;
use MeuApp\dao\UserDao;

session_start();


// $user = new User($_REQUEST['email'], Utils::criptografar($_REQUEST['senha']));
$user = new User($_REQUEST['email'], $_REQUEST['senha']);
// $valido = (  $user_email == $email && $user_senha == $senha);

// var_dump($user->isValido());
// exit;

$dao = new UserDao();
// $dao->salvar($user);

if ($dao->isValido($user)) {
    $flash_success = "Seja bem vindo, {$user->getEmail()}";
    // header("Location: ../pages/home.php?flash-success=$flash_success");
    
    $_SESSION['user-email'] = $user->getEmail();
    // $_SESSION[FlashMessages::SUCCESS] = $flash_success;
    FlashMessages::setMessage(FlashMessages::SUCCESS, $flash_success);

    header("Location: ../../home.php");
    exit;
} else {
    $flash_error = "Usuário ou Senha Inválido!";
    // header("Location: ../pages/login.php?flash-error=$flash_error");

    unset($_SESSION['user-email']);
    $_SESSION[FlashMessages::ERROR] = $flash_error;

    header("Location: ../../login.php");
    exit;
}

?>