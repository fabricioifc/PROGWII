<?php
    session_start();

    $user_email = $_SESSION['user-email'] ?? null;
    // echo $user_email;

    // if (!$user_email) {
    //     header('Location: index.php?flash-error=Você não tem permissão para acessar essa página.');
    // }
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Projeto</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>

    <section>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
            <a class="navbar-brand" href="../index.php">Pizzaaaaa</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="home.php">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Link</a>
                        </li>
                    </ul>

                    <ul class="navbar-nav ms-auto">
                        <?php if (isset($user_email)) { ?>
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="#">
                                    <?= $user_email ?>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link danger" aria-current="page" href="./auth/logout.php">
                                    Sair
                                </a>
                            </li>
                        <?php } else { ?>
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="login.php">Login</a>
                            </li>
                        <?php }  ?>
                    </ul>
                </div>
            </div>
        </nav>
    </section>
    
    <main>
        <div class="container">

            <?php // if (isset($_REQUEST['flash-success'])) {?>
            <?php if (isset($_SESSION['flash-success'])) {?>
                <div class="alert alert-success">
                    <?= $_SESSION['flash-success'] ?>
                    <?php unset($_SESSION['flash-success']) ?>
                </div>
            <?php } ?>
            <?php // if (isset($_REQUEST['flash-error'])) {?>
            <?php if (isset($_SESSION['flash-error'])) {?>
                <div class="alert alert-danger">
                    <?= $_SESSION['flash-error'] ?>
                    <?php unset($_SESSION['flash-error']) ?>
                </div>
            <?php } ?>

           <h1>Inicio - Página Inicial</h1>
        </div>
    </main>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>