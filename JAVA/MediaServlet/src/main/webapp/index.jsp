<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css" />
        <script src="resources/js/jquery.min.js"></script>
        <script src="resources/bootstrap/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <form method="POST" action="calcularMedia" class="form-horizontal">
                <fieldset>
                    <legend>Calcular a média do aluno</legend>
                    <div class="form-group">
                        <label for="nome" class="col-md-2 control-label">Nome</label>
                        <div class="col-md-10">
                            <input type="text" value="" name="nome" id="nome" required="true" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="nome" class="col-md-2 control-label">Nota 1</label>
                        <div class="col-md-10">
                            <input type="text" value="" name="n1" id="n1" required="true" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="nome" class="col-md-2 control-label">Nota 2</label>
                        <div class="col-md-10">
                            <input type="text" value="" name="n2" id="n2" required="true" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="nome" class="col-md-2 control-label">Nota 3</label>
                        <div class="col-md-10">
                            <input type="text" value="" name="n3" id="n3" required="true" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="nome" class="col-md-2 control-label">Nota 4</label>
                        <div class="col-md-10">
                            <input type="text" value="" name="n4" id="n4" required="true" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">
                        <input type="submit" value="Calcular" name="acao" id="acao" class="btn btn-primary" />
                    </div>
                </fieldset>
            </form>
        </div>
    </body>
</html>
