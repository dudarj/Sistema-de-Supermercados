<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
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

        <!-- Página pronta -->
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
                        <h2>Sobre Nós</h2>
                        <ul class="breadcrumb">
                            <li class="breadcrumb-item"><a href="mainCliente.jsp">Home</a></li>
                            <li class="breadcrumb-item active">Sobre Nós</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <!-- End All Title Box -->

        <!-- Start About Page  -->
        <div class="about-box-main">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6">
                        <div class="banner-frame"> <img class="img-fluid" src="images/TendTudo.jpg" alt="" />
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <h2 class="noo-sh-title-top">Site desenvolvido por alunos do curso de tecnico de informática do 2º Ano de 2022</h2>
                        <p>A tecnologia permite administrar a frente de caixa e o estoque, gerenciar toda operação, além de automatizar tarefas do backoffice. O sistema possui controle de estoque, controle de vendas, controle de acessos de usuário e relatórios.

                            Ao automatizar, ou seja, confiar o máximo de tarefas aos sistemas informáticos e não aos recursos humanos, o objetivo é melhorar a produtividade, reduzir custos e permitir que as equipes liberem tempo para se concentrar em tarefas de valor agregado, como melhorar o relacionamento com clientes ou monitoramento de projetos.                        
                        </p>
                    </div>
                </div>
                <div class="row my-5">
                    <div class="col-sm-6 col-lg-4">
                        <div class="service-block-inner">
                            <h3>Samuel</h3>
                        </div>
                    </div>
                    <div class="col-sm-6 col-lg-4">
                        <div class="service-block-inner">
                            <h3>Maria Eduarda</h3>
                        </div>
                    </div>
                    <div class="col-sm-6 col-lg-4">
                        <div class="service-block-inner">
                            <h3>Enzo</h3>
                        </div>
                    </div>
                </div>
                <div class="row my-4">
                    <div class="col-12">
                        <h2 class="noo-sh-title">Informações sobre nós</h2>
                    </div>
                    <div class="col-sm-6 col-lg-3">
                        <div class="hover-team">
                            <div class="our-team"> <div><img id="img_samuel" src="images/about/FotoSamuel.jpg" alt="" /></div>
                                <div class="team-content">
                                    <h3 class="title">Samuel</h3> <span class="post">Dev Java e Web / JSP - Servlets</span>
                                    <div class="team-description">
                                        <p>Programador Web, Java Developer e criador das servelts, Moro no município de Confins desde que nasci, gosto de ouvir musica, jogar videogame, editar e produzir videos, programar e dentre outras coisas. </p>
                                    </div>
                                </div>
                                <ul class="social">
                                    <li>
                                        <a href="#" class="fab fa-facebook"></a>
                                    </li>
                                    <li>
                                        <a href="https://twitter.com/SAMUEL12958758" class="fab fa-twitter"></a>
                                    </li>
                                    <li>
                                        <a href="#" class="fab fa-youtube"></a>
                                    </li>
                                </ul>
                            </div>

                            <hr class="my-0"> </div>
                    </div>
                    <div class="col-sm-6 col-lg-3">
                        <div class="hover-team">
                            <div class="our-team"> <img id="img_duda" src="images/about/FotoDuda.jpeg" alt="" />
                                <div class="team-content">
                                    <h3 class="title">Maria Eduarda</h3> <span class="post">Dev Java e Web / Banco de Dados</span>
                                    <div class="team-description">
                                        <p>Programadora Web, Java Developer e interface desktop Estudande do curso de informática. Gosto muito de programar enquanto escuto músicas.</p>
                                    </div>
                                </div>
                                <ul class="social">
                                    <li>
                                        <a href="#" class="fab fa-facebook"></a>
                                    </li>
                                    <li>
                                        <a href="https://twitter.com/rezendz0" class="fab fa-twitter"></a>
                                    </li>
                                    <li>
                                        <a href="#" class="fab fa-youtube"></a>
                                    </li>
                                </ul>

                            </div>

                            <hr class="my-0"> </div>
                    </div>
                    <div class="col-sm-6 col-lg-3">
                        <div class="hover-team">
                            <div class="our-team"> <img id="img_enzo" src="images/about/FotoEnzao.jpg" alt="" />
                                <div class="team-content">
                                    <h3 class="title">Enzo</h3> <span class="post">Designer / Dev Java e Web </span> 
                                    <div class="team-description">
                                        <p>Programador Web, designer e Java Developer, Estudande do curso de informática, gosto de programar e faço alguns templates para sites.</p>
                                    </div>
                                </div>
                                <ul class="social">
                                    <li>
                                        <a href="#" class="fab fa-facebook"></a>
                                    </li>
                                    <li>
                                        <a href="https://twitter.com/enzxo__" class="fab fa-twitter"></a>
                                    </li>
                                    <li>
                                        <a href="#" class="fab fa-youtube"></a>
                                    </li>
                                </ul>

                            </div>

                            <hr class="my-0"> </div>
                    </div>

                </div>
            </div>
            <!-- End About Page -->

            <!-- Start Instagram Feed  -->
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
            <!-- End Instagram Feed  -->
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