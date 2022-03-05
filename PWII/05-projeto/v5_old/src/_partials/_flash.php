<?php 

    session_start();

    require_once 'src/utils/FlashMessages.php';

    echo FlashMessages::getMessage(FlashMessages::SUCCESS);
    echo FlashMessages::getMessage(FlashMessages::ERROR);

?>

<?php
    // session_start();

    // $flash_success  = isset($_SESSION['flash-success']) ? $_SESSION['flash-success'] : null;
    // $flash_error    = isset($_SESSION['flash-error'])   ? $_SESSION['flash-error'] : null;
    
    // $show_success   = isset($_SESSION['flash-success']) ? '' : 'd-none';
    // $show_error     = isset($_SESSION['flash-error'])   ? '' : 'd-none';

    // unset($_SESSION['flash-success']);
    // unset($_SESSION['flash-error']);
?>

<!-- <div class="alert alert-success">
    <? // $flash_success ?>
</div>

<div class="alert alert-danger <$show_error?>">
    <? // $flash_error ?>
</div> -->