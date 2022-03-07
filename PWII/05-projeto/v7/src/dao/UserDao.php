<?php

namespace MeuApp\dao;

use MeuApp\dao\IUserDao;
use MeuApp\utils\Database;

class UserDao implements IUserDao {

    public function isValido($user) {
        // echo "Validando o usuário {$user->getEmail()}";

        $db = Database::getConnection();
        
        $stmt = $db->prepare("SELECT * FROM users WHERE email = :email");

        $stmt->execute(array(
            ':email' => $user->getEmail()
        ));

        $row = $stmt->fetch();

        if (password_verify($user->getSenha(), $row['senha'])) {
            return true;
        } else {
            return false;
        }
    }
}