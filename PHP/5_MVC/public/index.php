<?php 
defined('APPLICATION_PATH') || define('APPLICATION_PATH', realpath(dirname(__FILE__) . '/../app'));
require APPLICATION_PATH . DIRECTORY_SEPARATOR . 'config' . DIRECTORY_SEPARATOR . 'config.php';

// <pre> print_r($config) </pre>

//index.php?page=home
$page       = get('page', 'home');
$model      = $config['MODEL_PATH'] . $page . '.php';
$view       = $config['VIEW_PATH'] . $page . '.php';
$not_found  = $config['VIEW_PATH'] .'404.php';

if (file_exists($model)) {
    require $model;
}

if (file_exists($model)) {
    require $view;
} else {
    require $not_found;
}