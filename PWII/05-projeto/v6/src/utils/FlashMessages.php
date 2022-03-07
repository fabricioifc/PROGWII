<?php 
namespace MeuApp\utils;

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
        
    }

    public static function setMessage($tipo, $mensagem) {
        $_SESSION[$tipo] = $mensagem;
    }
}
?>