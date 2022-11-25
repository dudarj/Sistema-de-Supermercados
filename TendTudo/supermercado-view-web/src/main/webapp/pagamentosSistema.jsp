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
        <title>Gerência - TendTudo</title>
        <meta name="keywords" content="">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- Site Icons -->
        <link rel="shortcut icon" href="images/tendtudo.png" >
        <link rel="apple-touch-icon" href="images/apple-touch-icon.png">

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <!-- Site CSS -->
        <link rel="stylesheet" href="css/style.css">
        <!-- Responsive CSS -->
        <link rel="stylesheet" href="css/responsive.css">
        <!-- Custom CSS -->
        <link rel="stylesheet" href="css/custom.css">

        <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>

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
                        <a class="navbar-brand" href="mainGerencia.jsp"><img src="images/tendtudo.png" class="logo" alt="" style="width: 200px; margin-bottom: -30px; margin-top: -40px;"><h2 style="text-align: center">TendTudo - Vendas</h2></a>

                    </div>
                    <!-- End Header Navigation -->

                    <!-- /.navbar-collapse -->
            </nav>
            <!-- End Navigation -->
        </header>
        <!-- End Main Top -->

        <div class="container">
            <table class="table table-fixed">
                <thead>
                    <tr>
                        <th class="col-xs-3">Código</th>
                        <th class="col-xs-3">Cliente</th>
                        <th class="col-xs-6">Valor</th>
                        <th class="col-xs-6">Quantidade Produtos</th>
                        <th class="col-xs-6">Endereço</th>
                        <th class="col-xs-3">Status Cliente</th>
                        <th class="col-xs-3">Tipo Entrega</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <th scope="row">1</th>
                        <td class="col-xs-3">Duda</td>
                        <td class="col-xs-6">R$ 170,00</td>
                        <td class="col-xs-6">30 Unidades</td>
                        <td class="col-xs-6">Rua das Rosas</td>
                        <td class="col-xs-3">Bom</td>
                        <td class="col-xs-3">Entrega Premium</td>
                    </tr>
                </tbody>
            </table>
        </div>
        
        <div class="container">
            <table class="table table-fixed">
                <tbody>
                    <tr>
                        <th scope="row">2</th>
                        <td class="col-xs-3">Enzo</td>
                        <td class="col-xs-6">R$ 50,00</td>
                        <td class="col-xs-6">5 Unidades</td>
                        <td class="col-xs-6">Carlos Prates</td>
                        <td class="col-xs-3">Bom</td>
                        <td class="col-xs-3">Entrega Black Premium</td>
                    </tr>
                </tbody>
            </table>
        </div>



        <footer class="footer navbar-fixed-bottom" style="position: fixed; bottom: 0; width: 100%;">
            <div class="footer-copyright">
                <p class="footer-company">Todos os direitos reservados para Enzo Bambirra, Maria Eduarda e Samuel Pereira &copy; 2022 <a href="#">Supermercados TendTudo</a>
            </div>
        </footer>


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
        <script src="js/table.js"></script>
    </body>

</html>

<!--  <footer class="footer navbar-fixed-bottom" style="position: fixed; bottom: 0; width: 100%;">
            <div class="footer-copyright">
                <p class="footer-company">Todos os direitos reservados para Enzo Bambirra, Maria Eduarda e Samuel Pereira &copy; 2022 <a href="#">Supermercados TendTudo</a>
            </div>
        </footer> -->