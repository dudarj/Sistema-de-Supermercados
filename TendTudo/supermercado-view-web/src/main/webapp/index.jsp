<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TendTudo</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <script src="js/mascaras.js"></script>
        <link rel="stylesheet" href="css/index.css"/>

        <script src="js/index.js"></script>


        <link rel="shortcut icon" href="imgs/tendtudo.png" >

    </head>
    <body>
        <div id="logoDiv" style="background-color: red;padding: 52px;margin-top: -91px;"></div><div id="logoDiv" style="background-color: red;padding: 52px;margin-top: -100px;"> </div>
        <img src="images/tendtudo.png" class="logo" alt="" style="width: 277px;margin-bottom: -1px;margin-top: -138px;margin-left: 40%;">       
        <div class="container">



            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                    <div class="panel panel-login">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-6">
                                    <a href="#" class="active" id="login-form-link" style="color: red">Login</a>
                                </div>
                                <div class="col-xs-6">
                                    <a href="#" id="register-form-link" style="color: red">Cadastrar</a>
                                </div>
                            </div>
                            <hr>
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-12">
                                    <form id="login-form" action="MainViewController" method="post" role="form" style="display: block;">
                                        <div class="form-group">
                                            <input type="text" name="usuario" id="username" tabindex="1" class="form-control" placeholder="Usu??rio" value="">
                                        </div>
                                        <div class="form-group">
                                            <input type="password" name="senhaL" id="password" tabindex="2" class="form-control" placeholder="Senha">
                                        </div>
                                        <div>
                                            <h6>${Mensagem}</h6>
                                        </div>
                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col-sm-6 col-sm-offset-3">
                                                    <input type="submit" name="login-submit" id="login-submit" tabindex="4" class="form-control btn btn-login" value="Logar">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col-lg-12">
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                    <form id="register-form" action="CadastroViewController" method="post" role="form" style="display: none;">
                                        <div class="form-group">
                                            <input type="text" name="nome" id="nome" tabindex="1" class="form-control" placeholder="Nome" value="">
                                        </div>
                                        <div class="form-group">
                                            <input type="text" name="telefone" id="telefone" tabindex="1" class="form-control" placeholder="Telefone" value="" maxlength="15">
                                        </div>
                                        <div class="form-group">
                                            <input type="text" name="endereco" id="endereco" tabindex="1" class="form-control" placeholder="Endere??o: rua, n??mero, bairro" value="">
                                        </div>
                                        <div class="form-group">
                                            <input oninput="mascara(this)" type="text" name="Cpf" id="Cpf" tabindex="1" class="form-control" placeholder="CPF" value="">
                                        </div>
                                        <div class="form-group">
                                            <input type="email" name="email" id="email" tabindex="1" class="form-control" placeholder="exemplo@exemplo.com.br" value="">
                                        </div>
                                        <div class="form-group">
                                            <input type="text" name="login" id="username" tabindex="1" class="form-control" placeholder="Usu??rio" value="">
                                        </div>
                                        <div class="form-group">
                                            <input type="password" name="senha" id="password" tabindex="2" class="form-control" placeholder="Senha">
                                        </div>
                                        <div class="form-group">
                                            <input type="password" name="confirm-password" id="confirm-password" tabindex="2" class="form-control" placeholder="Confirmar Senha">
                                        </div>
                                        <h6>${MensagemC}</h6>
                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col-sm-6 col-sm-offset-3">
                                                    <input type="submit" name="register-submit" id="register-submit" tabindex="4" class="form-control btn btn-register" value="Cadastrar">
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>