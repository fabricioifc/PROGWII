<?php

namespace MeuApp\utils;

use \PDO;

class Database {

    private static $host = 'localhost';
    private static $db = 'meuappdb';
    private static $user = 'root';
    private static $password = 'coringa';

    private static $connection = null;

    public static function getConnection() {
        $host = Database::$host;
        $db = Database::$db;

        if (Database::$connection == null) {
            Database::$connection = new PDO(
                "mysql:host=$host;dbname=$db",
                Database::$user,
                Database::$password
            );
        }

        return Database::$connection;
    }

}