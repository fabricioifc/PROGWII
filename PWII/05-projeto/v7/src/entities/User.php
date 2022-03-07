<?php

namespace MeuApp\entities;
// include_once '../utils/Utils.php';
use MeuApp\utils\Utils;

class User {

    private $email;
    private $senha;

    // const USER_EMAIL = 'teste@teste.com';
    // const USER_SENHA = '123456';
    // const USER_SENHA = '$2y$10$asmd9asd9amd0asmd07b8u6lGohkLPd1ALZ7JV76ndz206iilpdZa';

    public function __construct($email, $senha) {
        $this->email = $email;
        $this->senha = $senha;
        // $this->setSenha($senha);
    }

    public function getEmail() {
        return $this->email;
    }

    public function setEmail($email) {
        $this->email = $email;
    }

    public function getSenha() {
        return $this->senha;
    }

    public function setSenha($senha) {
        // $this->senha = $senha;
        $this->senha = Utils::criptografar($senha);
    }


    // Outros Métodos
    public function __toString() {
        return $this->email;
    }

    public function isValido() {
        // echo $this->senha, '<br />';
        // echo Utils::criptografar(User::USER_SENHA);
        // return $this->email == User::USER_EMAIL && $this->senha == Utils::criptografar(User::USER_SENHA); 
        return $this->email == User::USER_EMAIL &&
                password_verify($this->senha, Utils::criptografar(User::USER_SENHA)); 
    }
    
}
