<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <!-- Basic -->

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <!-- Mobile Metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>

        <!-- Site Metas -->
        <title>Supermercados TendTudo</title>
        <meta name="keywords" content="">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- Site Icons -->
        <link rel="shortcut icon" href="images/tendtudo.png" >
        <link rel="apple-touch-icon" href="images/apple-touch-icon.png">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <!-- Site CSS -->
        <link rel="stylesheet" href="css/style.css">
        <!-- Responsive CSS -->
        <link rel="stylesheet" href="css/responsive.css">
        <!-- Custom CSS -->
        <link rel="stylesheet" href="css/custom.css">

        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

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

        <!-- Start Top Search -->
        <div class="top-search">
            <div class="container">
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-search"></i></span>
                    <input type="text" class="form-control" placeholder="Search">
                    <span class="input-group-addon close-search"><i class="fa fa-times"></i></span>
                </div>
            </div>
        </div>
        <!-- End Top Search -->

        <!-- Start All Title Box -->
        <div class="all-title-box">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <h2>Carrinho</h2>
                        <ul class="breadcrumb">
                            <li class="breadcrumb-item"><a href="#">Shop</a></li>
                            <li class="breadcrumb-item active">Carrinho</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <!-- End All Title Box -->

        <!-- Start Cart  -->
        <div class="cart-box-main">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="table-main table-responsive">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th>Imagem</th>
                                        <th>Nome do Produto</th>
                                        <th>Preço</th>
                                        <th>Quantidade</th>
                                        <th>Total</th>
                                        <th>Remover</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td class="thumbnail-img">
                                            <a href="#">
                                                <img class="img-fluid" src="images/img-pro-01.jpg" alt="" />
                                            </a>
                                        </td>
                                        <td class="name-pr">
                                            <a href="#">
                                                Lorem ipsum dolor sit amet
                                            </a>
                                        </td>
                                        <td class="price-pr">
                                            <p>$ 80.0</p>
                                        </td>
                                        <td class="quantity-box"><input type="number" size="4" value="1" min="0" step="1" class="c-input-text qty text"></td>
                                        <td class="total-pr">
                                            <p>$ 80.0</p>
                                        </td>
                                        <td class="remove-pr">
                                            <a href="#">
                                                <i class="fas fa-times"></i>
                                            </a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="thumbnail-img">
                                            <a href="#">
                                                <img class="img-fluid" src="images/img-pro-02.jpg" alt="" />
                                            </a>
                                        </td>
                                        <td class="name-pr">
                                            <a href="#">
                                                Lorem ipsum dolor sit amet
                                            </a>
                                        </td>
                                        <td class="price-pr">
                                            <p>$ 60.0</p>
                                        </td>
                                        <td class="quantity-box"><input type="number" size="4" value="1" min="0" step="1" class="c-input-text qty text"></td>
                                        <td class="total-pr">
                                            <p>$ 80.0</p>
                                        </td>
                                        <td class="remove-pr">
                                            <a href="#">
                                                <i class="fas fa-times"></i>
                                            </a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="thumbnail-img">
                                            <a href="#">
                                                <img class="img-fluid" src="images/img-pro-03.jpg" alt="" />
                                            </a>
                                        </td>
                                        <td class="name-pr">
                                            <a href="#">
                                                Lorem ipsum dolor sit amet
                                            </a>
                                        </td>
                                        <td class="price-pr">
                                            <p>$ 30.0</p>
                                        </td>
                                        <td class="quantity-box"><input type="number" size="4" value="1" min="0" step="1" class="c-input-text qty text"></td>
                                        <td class="total-pr">
                                            <p>$ 80.0</p>
                                        </td>
                                        <td class="remove-pr">
                                            <a href="#">
                                                <i class="fas fa-times"></i>
                                            </a>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

                <div class="row my-5">
                    <div class="col-lg-6 col-sm-6">
                        <div class="update-box">
                            <input value="Atualizar Carrinho" type="submit">
                        </div>
                    </div>
                </div>

                <div class="row my-5">
                    <div class="col-lg-8 col-sm-12"></div>
                    <div class="col-lg-4 col-sm-12">
                        <div class="order-box">
                            <h3>Order summary</h3>
                            <div class="d-flex">
                                <h4>Sub Total</h4>
                                <div class="ml-auto font-weight-bold"> $ 130 </div>
                            </div>
                            <div class="d-flex">
                                <h4>Discount</h4>
                                <div class="ml-auto font-weight-bold"> $ 40 </div>
                            </div>
                            <hr class="my-1">
                            <div class="d-flex">
                                <h4>Coupon Discount</h4>
                                <div class="ml-auto font-weight-bold"> $ 10 </div>
                            </div>
                            <div class="d-flex">
                                <h4>Tax</h4>
                                <div class="ml-auto font-weight-bold"> $ 2 </div>
                            </div>
                            <div class="d-flex">
                                <h4>Shipping Cost</h4>
                                <div class="ml-auto font-weight-bold"> Free </div>
                            </div>
                            <hr>
                            <div class="d-flex gr-total">
                                <h5>Grand Total</h5>
                                <div class="ml-auto h5"> $ 388 </div>
                            </div>
                            <hr> </div>
                    </div>
                    <div class="col-12 d-flex shopping-box"><a href="checkout.jsp" class="ml-auto btn hvr-hover">Finalizar Compra</a> </div>
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