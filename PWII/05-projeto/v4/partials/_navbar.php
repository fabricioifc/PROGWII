<section>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
        <a class="navbar-brand" href="/">Pizzaaaaa</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="../pages/home.php">Home</a>
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
                            <a class="nav-link danger" aria-current="page" href="../auth/logout.php">
                                Sair
                            </a>
                        </li>
                    <?php } else { ?>
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="../pages/login.php">Login</a>
                        </li>
                    <?php }  ?>
                </ul>
            </div>
        </div>
    </nav>
</section>