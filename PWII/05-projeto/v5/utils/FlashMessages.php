<?php 

class FlashMessages {

    const SUCCESS = 'success';
    const ERROR = 'danger';
    
    public static function getMessage($tipo) {
        $mensagem = $_SESSION[$tipo] ?? null;
        // $color = $tipo == 'error' ? 'danger' : $tipo;
        unset($_SESSION[$tipo]);

        if ($mensagem) {
            return "<div class='alert alert-{$tipo}'>{$mensagem}</div>";
        }
        return;
        
        
        // $flash_success  = isset($_SESSION['flash-success']) ? $_SESSION['flash-success'] : null;
        // $flash_error    = isset($_SESSION['flash-error'])   ? $_SESSION['flash-error'] : null;
        
        // $show_success   = isset($_SESSION['flash-success']) ? '' : 'd-none';
        // $show_error     = isset($_SESSION['flash-error'])   ? '' : 'd-none';
    
        // unset($_SESSION['flash-success']);
        // unset($_SESSION['flash-error']);

    }

    public static function setMessage($tipo, $mensagem) {
        $_SESSION[$tipo] = $mensagem;
    }
}
?>