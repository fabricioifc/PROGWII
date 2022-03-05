<?php

class Utils {

    public static function criptografar($senha) {
        // Criptografia com bcrypt
        $options['salt'] = 'asmd9asd9amd0asmd07b82'; // precisa de 22 caracteres
        // SALT: se não informado, bcrypt gera randomicamente
        return password_hash($senha, PASSWORD_BCRYPT, $options);
    }


}