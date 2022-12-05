<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title> Supermercados TendTudo </title>

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

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
                        </ul>
                    </div>
            </nav>
        </header>
        <!-- Final do cabeçalho e navegação -->
        <!-- Início do Menu -->
        <!-- Início Carousel -->
        <div id="slides-shop" class="cover-slides">
            <ul class="slides-container">
                <li class="text-center">
                    <img src="images/banner-01.jpg" alt="">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-12">
                                <h1 class="m-b-20"><strong>Bem-vindo ao <br> Supermercados TendTudo</strong></h1>
                                <p class="m-b-40">O supermercado que TendTudo que você precisa <br> Com as melhores promoções, produtos e valores para a sua família!</p>
                                <p><a class="btn hvr-hover" href="shop.jsp">Produtos</a></p>
                            </div>
                        </div>
                    </div>
                </li>
                <li class="text-center">
                    <img src="images/banner-02.jpg" alt="">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-12">
                                <h1 class="m-b-20"><strong>Bem-vindo ao <br> Supermercados TendTudo</strong></h1>
                                <p class="m-b-40">O supermercado que TendTudo que você precisa <br> Com as melhores promoções, produtos e valores para a sua família!</p>
                                <p><a class="btn hvr-hover" href="shop.jsp">Produtos</a></p>
                            </div>
                        </div>
                    </div>
                </li>
                <li class="text-center">
                    <img src="images/banner-03.jpg" alt="">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-12">
                                <h1 class="m-b-20"><strong>Bem-vindo ao <br> Supermercados TendTudo</strong></h1>   
                                <p class="m-b-40">O supermercado que TendTudo que você precisa <br> Com as melhores promoções, produtos e valores para a sua família!</p>
                                <p><a class="btn hvr-hover" href="shop.jsp">Produtos</a></p>
                            </div>
                        </div>
                    </div>
                </li>
            </ul>
            <div class="slides-navigation">
                <a href="#" class="next"><i class="fas fa-angle-right" aria-hidden="true"></i></a>
                <a href="#" class="prev"><i class="fa fa-angle-left" aria-hidden="true"></i></a>
            </div>
        </div>
        <!-- Final Carousel -->

        <!-- Start Categories  -->
        <div class="categories-shop">
            <div class="container">
                <div class="row">
                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12"> <!-- segunda -->
                        <div class="shop-cat-box">
                            <img class="img-fluid" src="images/semana-segunda_01.jpg" alt="" />
                            <a class="btn hvr-hover" href="#"></a>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                        <div class="shop-cat-box">
                            <img class="img-fluid" src="images/semana-terca_02.jpg" alt="" /> <!-- terça -->
                            <a class="btn hvr-hover" href="#"></a>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                        <div class="shop-cat-box">
                            <img class="img-fluid" src="images/semana-quarta_04.jpg" alt="" /> <!-- quarta -->
                            <a class="btn hvr-hover" href="#"></a>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                        <div class="shop-cat-box">
                            <img class="img-fluid" src="images/semana-quinta_05.jpg" alt="" /> <!-- quinta -->
                            <a class="btn hvr-hover" href="#"></a>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12"> <!-- sexta -->
                        <div class="shop-cat-box">
                            <img class="img-fluid" src="images/semana-sexta_06.jpg" alt="" />
                            <a class="btn hvr-hover" href="#"></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Final das categorias -->

        <div class="box-add-products">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6 col-md-6 col-sm-12">
                        <div class="offer-box-products">
                            <img class="img-fluid" src="images/promocao_segunda.jpg" alt="" />
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6 col-sm-12">
                        <div class="offer-box-products">
                            <img class="img-fluid" src="images/promocao_fds.jpg" alt="" />
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Start Blog  -->
        <div class="latest-blog">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="title-all text-center">
                            <h1>Ultimas Noticias</h1>
                            <p>Veja as Noticias mais populares sobre o supermercado TendTudo</p>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6 col-lg-4 col-xl-4">
                        <div class="blog-box">
                            <div class="blog-img">
                                <img class="img-fluid" src="images/tendtudotop1.png" alt="" />
                            </div>
                            <div class="blog-content">
                                <div class="title-blog">
                                    <h3>O TendTudo é eleito o melhor supermercado do Brasil</h3>
                                    <p>O supermercado foi eleito essa semana o melhor supermercado do Brasil.</p>
                                </div>
                                <ul class="option-blog">
                                    <li><a href="#"><i class="far fa-heart"></i></a></li>
                                    <li><a href="#"><i class="fas fa-eye"></i></a></li>
                                    <li><a href="#"><i class="far fa-comments"></i></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-4 col-xl-4">
                        <div class="blog-box">
                            <div class="blog-img">
                                <img class="img-fluid" src="images/TendTudo1.png" alt="" />
                            </div>
                            <div class="blog-content">
                                <div class="title-blog">
                                    <h3>TendTudo inaugura a 299° loja</h3>
                                    <p>Apos muitas obras o TendTudo ira estar presente em mais uma região, com preços imperdiveis e muito mais!

                                    </p>
                                </div>
                                <ul class="option-blog">
                                    <li><a href="#"><i class="far fa-heart"></i></a></li>
                                    <li><a href="#"><i class="fas fa-eye"></i></a></li>
                                    <li><a href="#"><i class="far fa-comments"></i></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-4 col-xl-4">
                        <div class="blog-box">
                            <div class="blog-img">
                                <img class="img-fluid" src="images/divulgacao_11.jpg" alt="" />
                            </div>
                            <div class="blog-content">
                                <div class="title-blog">
                                    <h3>TendTudo tem preços mais baratos após a pandemia</h3>
                                    <p>Os preços são 7% menores, se comparados com o preço dos produtos do 2º supermercado mais barato do Brasil!</p>
                                </div>
                                <ul class="option-blog">
                                    <li><a href="#"><i class="far fa-heart"></i></a></li>
                                    <li><a href="#"><i class="fas fa-eye"></i></a></li>
                                    <li><a href="#"><i class="far fa-comments"></i></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End Blog  -->


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
