<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title> Supermercados TendTudo </title>

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"/>
        <script src="js/mascaras.js"></script>

        <!-- Icones do site -->
        <link rel="shortcut icon" href="images/tendtudo.png" >
        <link rel="apple-touch-icon" href="images/apple-touch-icon.png">

        <!-- CSS Bootstrap  -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <!-- CSS do site -->
        <link rel="stylesheet" href="css/style.css">
        <!-- CSS para site responsive -->
        <link rel="stylesheet" href="css/responsive.css">
        <!-- CSS Personalizado -->
        <link rel="stylesheet" href="css/custom.css">

        <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
        <!-- Página pronta -->
    </head>

    <body>

        <!-- Início Cabeçalho -->
        <!-- Início Navegação -->
        <header class="main-header">
            <nav class="navbar navbar-expand-lg navbar-light bg-light navbar-default bootsnav">
                <div class="container">
                    <!-- Início Cabeçalho Navegação -->
                    <div class="navbar-header">
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar-menu" aria-controls="navbars-rs-food" aria-expanded="false" aria-label="Toggle navigation">
                            <i class="fa fa-bars"></i><!-- i bootstrap -->
                        </button>
                        <a class="navbar-brand" href="mainCliente.jsp"><img src="images/tendtudo.png" class="logo" alt="" style="width: 200px; margin-bottom: -30px; margin-top: -40px;"></a>
                    </div>
                    <!-- Links das outras páginas html, pesquisa, e o carrinho do cliente -->
                    <div class="collapse navbar-collapse" id="navbar-menu">
                        <ul class="nav navbar-nav ml-auto" data-in="fadeInDown" data-out="fadeOutUp">
                            <li class="nav-item active"><a class="nav-link" href="mainCliente.jsp">Home</a></li>
                            <li class="nav-item"><a class="nav-link" href="about.jsp">Sobre nós</a></li>
                            <li class="dropdown">
                                <a href="#" class="nav-link dropdown-toggle arrow" data-toggle="dropdown">Produtos</a>
                                <ul class="dropdown-menu">
                                    <li><a href="shop.jsp" id="produtos">Produtos</a></li>
                                    <li><a href="cart.jsp">Carrinho</a></li>
                                </ul>
                            </li>
                            <li class="nav-item"><a class="nav-link" href="gallery.jsp">Espaço</a></li>
                            <li class="nav-item"><a class="nav-link" href="contact-us.jsp">Fale Conosco</a></li>
                            <div>
                                <a href="minhaConta.jsp" class="user"><i class="far fa-user-circle" style='font-size:37px;justify-content: center;display: flex;margin-top: 3px;cursor:pointer' aria-hidden="true"></i></a>
                                <p form action="ContaClienteViewController" method="post" name="nome" style="text-align: center;"><%=session.getAttribute("nome")%></p>
                            </div>
                        </ul>
                    </div>
            </nav>
        </header>
        <div class="container rounded bg-white mt-5 mb-5">
            <div class="row" style="background-color: bisque">
                <div class="col-md-3 border-right">
                    <div class="d-flex flex-column align-items-center text-center p-3 py-5"><img class="rounded-circle mt-5" width="150px"  style="border-radius: 18%!important;" src="https://img.freepik.com/vetores-premium/icone-de-avatar-masculino-pessoa-desconhecida-ou-anonima-icone-de-perfil-de-avatar-padrao-usuario-de-midia-social-homem-de-negocios-silhueta-de-perfil-de-homem-isolada-no-fundo-branco-ilustracao-vetorial_735449-120.jpg?w=740"></div>
                </div>
                <div class="col-md-5 border-right">
                    <form action="EditarClienteViewController" method="POST">
                        <div class="p-3 py-5">
                            <div class="d-flex justify-content-between align-items-center mb-3">
                                <h4 class="text-right" style="font-size: 26px;">Minha Conta</h4>
                            </div>
                            <div class="row mt-2">
                                <div class="col-md-6"><label class="labels">Nome</label><input type="text" class="form-control" name="nome" placeholder="" value="<%=session.getAttribute("nome")%>"></div>
                                <div class="col-md-6"><label class="labels">CPF</label><input type="text" oninput="mascara(this)" name="cpf" class="form-control" value="<%=session.getAttribute("cpf")%>" placeholder=""></div>
                            </div>
                            <div class="row mt-3">
                                <div class="col-md-12"><label class="labels">Telefone</label><input type="text" class="form-control"  name="telefone" id="telefone" maxlength="15" placeholder="" value="<%=session.getAttribute("telefone")%>"></div>
                                <div class="col-md-12"><label class="labels">Endereço</label><input type="text" class="form-control" name="endereco" placeholder="" value="<%=session.getAttribute("endereco")%>"></div>
                                <div class="col-md-12"><label class="labels">E-mail</label><input type="email" class="form-control" name="email" placeholder="" value="<%=session.getAttribute("email")%>"></div>
                            </div>
                            <div class="mt-5 text-center">
                                <button class="btn btn-primary profile-button" type="submit" style="background-color:#ff0000; margin-right: 59px">Editar Conta</button>
                                <a href="DeletarClienteViewController?cpf=<%=session.getAttribute("cpf")%>"  class="btn btn-primary profile-button" type="button" style="background-color:#ff0000;" role="button">Excluir Conta</a>
                                <%--<button class="btn btn-primary profile-button" type="button" style="background-color:#ff0000;">Excluir Conta</button>--%>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>





        <!-- Start copyright  -->
        <div class="footer-copyright">
            <p class="footer-company">Todos os direitos reservados para Enzo Bambirra, Maria Eduarda e Samuel Pereira &copy; 2022 <a href="#">Supermercados TendTudo</a>
        </div>
        <!-- End copyright  -->

        <a href="#" id="back-to-top" title="Back to top" style="display: none;">&uarr;</a>





        <!-- ALL JS FILES -->
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <!-- ALL PLUGINS -->
        <script src="js/jquery.superslides.min.js"></script>
        <script src="js/bootstrap-select.js"></script>
        <script src="js/inewsticker.js"></script>
        <script src="js/bootsnav.js."></script>
        <script src="js/images-loded.min.js"></script>
        <script src="js/isotope.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/baguetteBox.min.js"></script>
        <script src="js/form-validator.min.js"></script>
        <script src="js/contact-form-script.js"></script>
        <script src="js/custom.js"></script>


    </body>
</html>
