<!-- Aprendendo o conceito de grade -->
<!-- Frameworks: Bootstrap, fondation, https://simplegrid.io -->

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Grade</title>

    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/estilos.css">
</head>

<body>
    
    <header>
        <div class="container">
            <div class="col-2">
                <h1>IF Pizzaria</h1>
            </div>

            <div class="col-10 ultimo-bloco">
                <nav>
                    <ul>
                        <li><a href="#">Início</a></li>
                        <li><a href="#">Pizzas</a></li>
                        <li><a href="#">Contato</a></li>
                        <li><a href="#">Login</a></li>
                    </ul>
                </nav>
            </div>
        </div>
    </header>

    <section>
        <div class="container">
            <div class="col-3" style="background-color: red;">
                <p>col-3</p>
            </div>
            <div class="col-3" style="background-color: green;">
                <p>col-3</p>
            </div>
            <div class="col-6 ultimo-bloco" style="background-color: blue;">
                <p>col-6</p>
            </div>
       </div>
    </section>

</body>

</html>