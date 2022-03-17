### Projeto PHP

## Autoloader

    Importação de classes
    https://www.php-fig.org/psr/psr-4/
     - Verificar o exemplo nesse link, mas não vamos utiliza-lo


Faremos o Autoloader utilizando uma biblioteca, que será instalada com Composer

[https://getcomposer.org/download/](https://getcomposer.org/download/)
    
<hr>

Nos computadores do IF, o composer já está instalado.

### Extensões

Desabilitar openssl
 - `composer config -g -- disable-tls true`
 - `composer config -g secure-http false`

Em `C:\php\php.ini-development`, habilitar algumas extensões que usaremos mais tarde.

    - [ ] ;extension=openssl
    - [ ] extension=pdo_mysql
    - [ ] extension=bz2
    - [ ] extension=curl
    - [ ] extension=mbstring

Precisamos também habilitar `extension_dir` (pasta com as extensões/bibliotecas)

    ```
    ; Directory in which the loadable extensions (modules) reside.
    ; http://php.net/extension-dir
    ;extension_dir = "./"
    ; On windows:
    extension_dir = "ext"
    ```

Para verificar se deu certo, veja no `<?php phpinfo() ?>`

Vamos para a documentação básica do composer
https://getcomposer.org/doc/01-basic-usage.md

### Configurando o composer no nosso projeto

    composer.json

    {
        "require": {

        },
        "autoload": {
            "psr-4": {"MeuAPP\\": "src/"}
        }
    }


Instalar: `composer install`

<hr>

### Configurações no projeto

 - Criar namespace em todos os arquivos PHP da pasta `src`
    `<?php namespace App\foo\bar; ?>`
 - Importar o autoloading em todos os arquivos PHP
    `require __DIR__ . './vendor/autoload.php'`
 - Lembrar de ingnorar (gitignore) a pasta vendor