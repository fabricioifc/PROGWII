<?php //require '../auth/auth.php' ?>
<?php require_once './partials/_header.php' ?>
<?php require_once './partials/_navbar.php' ?>
    
<main>
    <div class="container">
        <?php require_once './partials/_flash.php' ?>

        <form action="./auth/validar.php">
            <div class="row">
                <div class="col">
                    <div class="mb-3">
                        <label for="email" class="form-label">E-mail</label>
                        <input type="email" class="form-control" name="email" id="email" placeholder="teste@teste.com" autofocus>
                    </div>
                    <div class="mb-3">
                        <label for="senha" class="form-label">Senha</label>
                        <input type="password" class="form-control" name="senha" id="senha" placeholder="*******"></input>
                    </div>

                    <div class="mb-3">
                        <input type="submit" class="btn btn-success" value="Login"></input>
                    </div>
                </div>
            </div>
        </form>
    </div>
</main>

<?php  require_once './partials/_footer.php' ?>