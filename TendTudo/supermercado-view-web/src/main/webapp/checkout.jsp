<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <!-- Basic -->

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <!-- Mobile Metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Site Metas -->
        <title>Supermercados TendTudo</title>
        <meta name="keywords" content="">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- Site Icons -->
        <link rel="shortcut icon" href="images/tendtudo.png" >
        <link rel="apple-touch-icon" href="images/apple-touch-icon.png">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <!-- Site CSS -->
        <link rel="stylesheet" href="css/style.css">
        <!-- Responsive CSS -->
        <link rel="stylesheet" href="css/responsive.css">
        <!-- Custom CSS -->
        <link rel="stylesheet" href="css/custom.css">

    </head>

    <body>

        <!-- Start Main Top -->
        <header class="main-header">
            <!-- Start Navigation -->
            <nav class="navbar navbar-expand-lg navbar-light bg-light navbar-default bootsnav">
                <div class="container">
                    <!-- Start Header Navigation -->
                    <div class="navbar-header">
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar-menu" aria-controls="navbars-rs-food" aria-expanded="false" aria-label="Toggle navigation">
                            <i class="fa fa-bars"></i>
                        </button>
                        <a class="navbar-brand" href="mainCliente.jsp"><img src="images/tendtudo.png" class="logo" alt="" style="width: 200px; margin-bottom: -30px; margin-top: -40px;"></a>
                    </div>
                    <!-- End Header Navigation -->

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="navbar-menu">
                        <ul class="nav navbar-nav ml-auto" data-in="fadeInDown" data-out="fadeOutUp">
                            <li class="nav-item active"><a class="nav-link" href="mainCliente.jsp">Home</a></li>
                            <li class="nav-item"><a class="nav-link" href="about.jsp">Sobre nós</a></li>
                            <li class="dropdown">
                                <a href="#" class="nav-link dropdown-toggle arrow" data-toggle="dropdown">PRODUTOS</a>
                                <ul class="dropdown-menu">
                                    <li><a href="shop.jsp">Produtos</a></li>
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
                    <!-- /.navbar-collapse -->


                </div>
                <!-- Start Side Menu -->
                <div class="side">
                    <a href="#" class="close-side"><i class="fa fa-times"></i></a>
                    <li class="cart-box">
                        <ul class="cart-list">
                            <li>
                                <a href="#" class="photo"><img src="images/img-pro-01.jpg" class="cart-thumb" alt="" /></a>
                                <h6><a href="#">Delica omtantur </a></h6>
                                <p>1x - <span class="price">$80.00</span></p>
                            </li>
                            <li>
                                <a href="#" class="photo"><img src="images/img-pro-02.jpg" class="cart-thumb" alt="" /></a>
                                <h6><a href="#">Omnes ocurreret</a></h6>
                                <p>1x - <span class="price">$60.00</span></p>
                            </li>
                            <li>
                                <a href="#" class="photo"><img src="images/img-pro-03.jpg" class="cart-thumb" alt="" /></a>
                                <h6><a href="#">Agam facilisis</a></h6>
                                <p>1x - <span class="price">$40.00</span></p>
                            </li>
                            <li class="total">
                                <a href="#" class="btn btn-default hvr-hover btn-cart">VIEW CART</a>
                                <span class="float-right"><strong>Total</strong>: $180.00</span>
                            </li>
                        </ul>
                    </li>
                </div>
                <!-- End Side Menu -->
            </nav>
            <!-- End Navigation -->
        </header>
        <!-- End Main Top -->

        <!-- Start Cart  -->
        <div class="cart-box-main">
            <div class="container">
                <div class="row new-account-login">
                    <div class="col-sm-6 col-lg-6 mb-3">
                        <div class="title-left">
                            <h3>Entrar</h3>
                        </div>
                        <h5><a data-toggle="collapse" href="#formLogin" role="button" aria-expanded="false">Clique para entrar em sua conta</a></h5>
                        <form class="mt-3 collapse review-form-box" id="formLogin">
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="InputEmail" class="mb-0">Endereço de Email</label>
                                    <input type="email" class="form-control" id="InputEmail" placeholder="Seu Email"> </div>
                                <div class="form-group col-md-6">
                                    <label for="InputPassword" class="mb-0">Senha</label>
                                    <input type="password" class="form-control" id="InputPassword" placeholder="Sua Senha"> </div>
                            </div>
                            <button type="submit" class="btn hvr-hover">Login</button>
                        </form>
                    </div>
                    <div class="col-sm-6 col-lg-6 mb-3">
                        <div class="title-left">
                            <h3> Crie Uma Nova Conta</h3>
                        </div>
                        <h5><a data-toggle="collapse" href="#formRegister" role="button" aria-expanded="false">Clique para se registrar</a></h5>
                        <form class="mt-3 collapse review-form-box" id="formRegister">
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="InputName" class="mb-0">Primeiro nome</label>
                                    <input type="text" class="form-control" id="InputName" placeholder="Seu Primeiro Nome"> </div>
                                <div class="form-group col-md-6">
                                    <label for="InputLastname" class="mb-0">Último nome</label>
                                    <input type="text" class="form-control" id="InputLastname" placeholder="Seu Último Nome"> </div>
                                <div class="form-group col-md-6">
                                    <label for="InputEmail1" class="mb-0">Endereço de Email</label>
                                    <input type="email" class="form-control" id="InputEmail1" placeholder="Seu Email"> </div>
                                <div class="form-group col-md-6">
                                    <label for="InputPassword1" class="mb-0">Senha</label>
                                    <input type="password" class="form-control" id="InputPassword1" placeholder="Sua Senha"> </div>
                            </div>
                            <button type="submit" class="btn hvr-hover">Registrar</button>
                        </form>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-6 col-lg-6 mb-3">
                        <div class="checkout-address">
                            <div class="title-left">
                                <h3>Adicione seus dados</h3>
                            </div>
                            <form class="needs-validation" novalidate>
                                <div class="row">
                                    <div class="col-md-6 mb-3">
                                        <label for="firstName">Primeiro nome *</label>
                                        <input type="text" class="form-control" id="firstName" placeholder="" value="" required>
                                        <div class="invalid-feedback"> Valid first name is required. </div>
                                    </div>
                                    <div class="col-md-6 mb-3">
                                        <label for="lastName">Ultimo nome *</label>
                                        <input type="text" class="form-control" id="lastName" placeholder="" value="" required>
                                        <div class="invalid-feedback"> Valid last name is required. </div>
                                    </div>
                                </div>
                                <div class="mb-3">
                                    <label for="username">Login *</label>
                                    <div class="input-group">
                                        <input type="text" class="form-control" id="username" placeholder="" required>
                                        <div class="invalid-feedback" style="width: 100%;"> Your username is required. </div>
                                    </div>
                                </div>
                                <div class="mb-3">
                                    <label for="email">E-mail *</label>
                                    <input type="email" class="form-control" id="email" placeholder="">
                                    <div class="invalid-feedback"> Please enter a valid email address for shipping updates. </div>
                                    <div class="col-md-4 mb-3">
                                        <label for="state">Estado *</label>
                                        <select class="wide w-100" id="state">
                                            <option data-display="Select">Escolha.  ..</option>
                                            <option value="Acre">Acre</option>
                                            <option value="Alagoas">Alagoas</option>
                                            <option value="Amapá">Amapá</option>
                                            <option value="Amazonas">Amazonas</option>
                                            <option value="Bahia">Bahia</option>
                                            <option value="Ceará">Ceará</option>
                                            <option value="Distrito Federal">Distrito Federal</option>
                                            <option value="Espírito Santo">Espírito Santo</option>
                                            <option value="Goiás">Goiás</option>
                                            <option value="Maranhão">Maranhão</option>
                                            <option value="Mato Grosso">Mato Grosso</option>
                                            <option value="Mato Grosso do Sul">Mato Grosso do Sul</option>
                                            <option value="Minas Gerais">Minas Gerais</option>
                                            <option value="Pará">Pará</option>
                                            <option value="Paraíba">Paraíba</option>
                                            <option value="Paraná">Paraná</option>
                                            <option value="Pernambuco">Pernambuco</option>
                                            <option value="Piauí">Piauí</option>
                                            <option value="Rio de Janeiro">Rio de Janeiro</option>
                                            <option value="Rio Grande do Norte">Rio Grande do Norte</option>
                                            <option value="Rio Grande do Sul">Rio Grande do Sul</option>
                                            <option value="Rondônia">Rondônia</option>
                                            <option value="Roraima">Roraima</option>
                                            <option value="Santa Catarina">Santa Catarina</option>
                                            <option value="São Paulo">São Paulo</option>
                                            <option value="Sergipe">Sergipe</option>
                                            <option value="Tocantins">Tocantins</option>
                                        </select>
                                        <div class="invalid-feedback"> Please provide a valid state. </div>
                                    </div>
                                </div>
                                <hr class="mb-4">
                                <div class="custom-control custom-checkbox">
                                    <input type="checkbox" class="custom-control-input" id="same-address">
                                    <label class="custom-control-label" for="same-address">O endereço de entrega é o mesmo do meu endereço de cobrança</label>
                                </div>
                                <hr class="mb-4">
                                <div class="title"> <span>Pagamento</span> </div>
                                <div class="d-block my-3">
                                    <div class="custom-control custom-radio">
                                        <input id="credit" name="paymentMethod" type="radio" class="custom-control-input" checked required>
                                        <label class="custom-control-label" for="credit">Cartão de Crédito</label>
                                    </div>
                                    <div class="custom-control custom-radio">
                                        <input id="debit" name="paymentMethod" type="radio" class="custom-control-input" required>
                                        <label class="custom-control-label" for="debit">Cartão de Débito</label>
                                    </div>
                                    <div class="custom-control custom-radio">
                                        <input id="paypal" name="paymentMethod" type="radio" class="custom-control-input" required>
                                        <label class="custom-control-label" for="paypal">Paypal</label>
                                    </div>
                                    <div class="custom-control custom-radio">
                                        <input id="pix" name="paymentMethod" type="radio" class="custom-control-input" required>
                                        <label class="custom-control-label" for="pix">Pix</label>
                                    </div>
                                    <div class="custom-control custom-radio">
                                        <input id="boleto" name="paymentMethod" type="radio" class="custom-control-input" required>
                                        <label class="custom-control-label" for="boleto">Boleto</label>
                                    </div>
                                    <div class="custom-control custom-radio">
                                        <input id="Dinheiro" name="paymentMethod" type="radio" class="custom-control-input" required>
                                        <label class="custom-control-label" for="Dinheiro">Dinheiro</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6 mb-3">
                                        <label for="cc-name">Nome do Cartão</label>
                                        <input type="text" class="form-control" id="cc-name" placeholder="" required> <small class="text-muted">Coloque todo o número do seu cartão</small>
                                        <div class="invalid-feedback"> O nome no cartão é obrigatório </div>
                                    </div>
                                    <div class="col-md-6 mb-3">
                                        <label for="cc-number">Número do cartão de crédito</label>
                                        <input type="text" class="form-control" id="cc-number" placeholder="" required>
                                        <div class="invalid-feedback"> Número do cartão de crédito é obrigatório </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-3 mb-3">
                                        <label for="cc-expiration">Data de Expiração</label>
                                        <input type="text" class="form-control" id="cc-expiration" placeholder="" required>
                                        <div class="invalid-feedback"> A data de expiramento é obrigatória </div>
                                    </div>
                                    <div class="col-md-3 mb-3">
                                        <label for="cc-expiration">CVV</label>
                                        <input type="text" class="form-control" id="cc-cvv" placeholder="" required>
                                        <div class="invalid-feedback"> Código de segurança é obrigatório </div>
                                    </div>
                                    <div class="col-md-6 mb-3">
                                        <div class="payment-icon">
                                            <ul>
                                                <li><img class="img-fluid" src="images/payment-icon/1.png" alt=""></li>
                                                <li><img class="img-fluid" src="images/payment-icon/2.png" alt=""></li>
                                                <li><img class="img-fluid" src="images/payment-icon/3.png" alt=""></li>
                                                <li><img class="img-fluid" src="images/payment-icon/5.png" alt=""></li>
                                                <li><img class="img-fluid" src="images/payment-icon/7.png" alt=""></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                                <hr class="mb-1"> </form>
                        </div>
                    </div>
                    <div class="col-sm-6 col-lg-6 mb-3">
                        <div class="row">
                            <div class="col-md-12 col-lg-12">
                                <div class="shipping-method-box">
                                    <div class="title-left">
                                        <h3>Método Envio</h3>
                                    </div>
                                    <div class="mb-4">
                                        <div class="custom-control custom-radio">
                                            <input id="shippingOption1" name="shipping-option" class="custom-control-input" checked="checked" type="radio">
                                            <label class="custom-control-label" for="shippingOption1">Entrega Normal</label> <span class="float-right font-weight-bold">Grátis</span> </div>
                                        <div class="ml-4 mb-2 small">(Chegada prevista em 1h)</div>
                                        <div class="custom-control custom-radio">
                                            <input id="shippingOption2" name="shipping-option" class="custom-control-input" type="radio">
                                            <label class="custom-control-label" for="shippingOption2">Entrega Premium</label> <span class="float-right font-weight-bold">R$ 10,00</span> </div>
                                        <div class="ml-4 mb-2 small">(Chegada prevista em 30min)</div>
                                        <div class="custom-control custom-radio">
                                            <input id="shippingOption3" name="shipping-option" class="custom-control-input" type="radio">
                                            <label class="custom-control-label" for="shippingOption3">Entrega Black Premium</label> <span class="float-right font-weight-bold">R$ 20,00</span></div>
                                        <div class="ml-4 mb-2 small">(Chegada prevista em 30min - com mais de 5 caixas)</div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-12 col-lg-12">
                                <div class="odr-box">
                                    <div class="title-left">
                                        <h3>Carrinho de Compras</h3>
                                    </div>
                                    <div class="rounded p-2 bg-light">
                                        <div class="media mb-2 border-bottom">
                                            <div class="media-body"> <a href="detail.html"> Produto </a>
                                                <div class="small text-muted">Preço: R$ 80,00 <span class="mx-2">|</span> Quantidade: 1 <span class="mx-2">|</span> Subtotal: R$ 80,00</div>
                                            </div>
                                        </div>
                                        <div class="media mb-2 border-bottom">
                                            <div class="media-body"> <a href="detail.html"> Produto </a>
                                                <div class="small text-muted">Preço: R$ 60,00 <span class="mx-2">|</span> Quantidade: 1 <span class="mx-2">|</span> Subtotal: R$ 60,00</div>
                                            </div>
                                        </div>
                                        <div class="media mb-2">
                                            <div class="media-body"> <a href="detail.html"> Produto </a>
                                                <div class="small text-muted">Preço: R$ 40,00 <span class="mx-2">|</span> Quantidade: 1 <span class="mx-2">|</span> Subtotal: R$ 40,00</div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-12 col-lg-12">
                                <div class="order-box">
                                    <div class="title-left">
                                        <h3>Valor</h3>
                                    </div>
                                    <div class="d-flex">
                                        <div class="font-weight-bold">Produtos</div>
                                        <div class="ml-auto font-weight-bold">Total</div>
                                    </div>
                                    <hr class="my-1">
                                    <div class="d-flex">
                                        <h4>Total</h4>
                                        <div class="ml-auto font-weight-bold"> $$$ </div>
                                    </div>
                                    <div class="d-flex">
                                        <h4>Desconto</h4>
                                        <div class="ml-auto font-weight-bold"> $$$ </div>
                                    </div>
                                    <hr class="my-1">
                                    <div class="d-flex">
                                        <h4>Cupom de Desconto</h4>
                                        <div class="ml-auto font-weight-bold"> $$$ </div>
                                    </div>
                                    <div class="d-flex">
                                        <h4>Taxa</h4>
                                        <div class="ml-auto font-weight-bold"> $$$ </div>
                                    </div>
                                    <div class="d-flex">
                                        <h4>Frete</h4>
                                        <div class="ml-auto font-weight-bold"> Free </div>
                                    </div>
                                    <hr>
                                    <div class="d-flex gr-total">
                                        <h5>Total da Compra</h5>
                                        <div class="ml-auto h5"> $$$ </div>
                                    </div>
                                    <hr> </div>
                            </div>
                            <div class="col-12 d-flex shopping-box"> <a href="checkout.html" class="ml-auto btn hvr-hover">Finalizar Compra</a> </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
        <!-- End Cart -->


        <!-- Início Feed Instagram  -->
        <div class="instagram-box">
            <div class="main-instagram owl-carousel owl-theme">
                <div class="item">
                    <div class="ins-inner-box">
                        <img src="images/divulgacao_1.jpg" alt="" />
                        <div class="hov-in">
                            <a href="#"><i class="fab fa-instagram"></i></a>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <div class="ins-inner-box">
                        <img src="images/divulgacao_2.jpg" alt="" />
                        <div class="hov-in">
                            <a href="#"><i class="fab fa-instagram"></i></a>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <div class="ins-inner-box">
                        <img src="images/divulgacao_3.jpg" alt="" />
                        <div class="hov-in">
                            <a href="#"><i class="fab fa-instagram"></i></a>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <div class="ins-inner-box">
                        <img src="images/divulgacao_4.jpg" alt="" />
                        <div class="hov-in">
                            <a href="#"><i class="fab fa-instagram"></i></a>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <div class="ins-inner-box">
                        <img src="images/divulgacao_5.jpg" alt="" />
                        <div class="hov-in">
                            <a href="#"><i class="fab fa-instagram"></i></a>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <div class="ins-inner-box">
                        <img src="images/divulgacao_6.jpg" alt="" />
                        <div class="hov-in">
                            <a href="#"><i class="fab fa-instagram"></i></a>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <div class="ins-inner-box">
                        <img src="images/divulgacao_7.jpg" alt="" />
                        <div class="hov-in">
                            <a href="#"><i class="fab fa-instagram"></i></a>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <div class="ins-inner-box">
                        <img src="images/divulgacao_8.jpg" alt="" />
                        <div class="hov-in">
                            <a href="#"><i class="fab fa-instagram"></i></a>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <div class="ins-inner-box">
                        <img src="images/divulgacao_9.jpg" alt="" />
                        <div class="hov-in">
                            <a href="#"><i class="fab fa-instagram"></i></a>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <div class="ins-inner-box">
                        <img src="images/divulgacao_10.jpg" alt="" />
                        <div class="hov-in">
                            <a href="#"><i class="fab fa-instagram"></i></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Final Instagram Feed  -->
        <!-- Start copyright  -->
        <div class="footer-copyright">
            <p class="footer-company">Todos os direitos reservados para Enzo Bambirra, Maria Eduarda e Samuel Pereira &copy; 2022 <a href="#">Supermercados TendTudo</a>
        </div>
        <!-- End copyright  -->

        <a href="#" id="back-to-top" title="Back to top" style="display: none;">&uarr;</a>

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