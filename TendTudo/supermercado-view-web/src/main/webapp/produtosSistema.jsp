<!DOCTYPE html>
<html lang="pt-br">
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
        <!-- CSS Janela Modal -->
        <link rel="stylesheet" href="css/modal.css">
        <!-- CSS Formulï¿½rio-->
        <link rel="stylesheet" href="css/styles.css">

        <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>

        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

        <style>
            @media (max-width: 1440px) {
                .modal__content{
                    padding: 0!important;
                }

                .form-control{
                    margin-bottom: 0!important;
                    width: 50%;
                }

                .form{
                    padding: 0!important;
                }

                .headerzao{
                    padding-bottom: 0!important;
                }

                .info{
                    display: none!important;
                }

                .form button{
                    margin-top: 1rem;
                    margin-bottom: 1rem;
                }

                #form-wrap{
                    display: flex;
                    flex-wrap: wrap;
                }


            }
        </style>

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

                        <a class="navbar-brand" href="mainGerencia.jsp"><img src="images/tendtudo.png" class="logo" alt="" style="width: 200px; margin-bottom: -30px; margin-top: -40px;"><h2 style="text-align: center">TendTudo - Produtos</h2></a>
                    </div>
                    <a onclick="teste()" id="add_produto" class="ml-auto btn hvr-hover">Adicionar Produto</a>
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
                        <th class="col-xs-6">Produto</th>
                        <th class="col-xs-6">Valor Produto</th>
                        <th class="col-xs-6">Quantidade</th>
                        <th class="col-xs-3">Foto Produto</th>
                        <th class="col-xs-3"></th>
                        <th class="col-xs-3"></th>
                    </tr>
                </thead>
                <tbody>
                    
                    ${tabelaProduto0}
                    ${tabelaProduto1}
                    ${tabelaProduto2}
                    ${tabelaProduto3}
                    ${tabelaProduto4}
                    ${tabelaProduto5}
                    ${tabelaProduto6}
                    ${tabelaProduto7}
                    ${tabelaProduto8}
                    ${tabelaProduto9}
                    ${tabelaProduto10}
                    ${tabelaProduto11}
                    ${tabelaProduto12}
                    ${tabelaProduto13}
                    ${tabelaProduto14}
                    ${tabelaProduto15}
                    ${tabelaProduto16}
                    ${tabelaProduto17}
                    ${tabelaProduto18}
                    ${tabelaProduto19}
                    ${tabelaProduto20}
                    ${tabelaProduto21}
                    ${tabelaProduto22}
                    ${tabelaProduto23}
                    ${tabelaProduto24}
                    ${tabelaProduto25}
                    ${tabelaProduto26}
                    ${tabelaProduto27}
                    ${tabelaProduto28}
                    ${tabelaProduto29}
                    ${tabelaProduto30}
                    ${tabelaProduto31}
                    ${tabelaProduto32}
                    ${tabelaProduto33}
                    ${tabelaProduto34}
                    ${tabelaProduto35}
                    ${tabelaProduto36}
                    ${tabelaProduto37}
                    ${tabelaProduto38}
                    ${tabelaProduto39}
                    ${tabelaProduto40}
                    ${tabelaProduto41}
                    ${tabelaProduto42}
                    ${tabelaProduto43}
                    ${tabelaProduto44}
                    ${tabelaProduto45}
                    ${tabelaProduto46}
                    ${tabelaProduto47}
                    ${tabelaProduto48}
                    ${tabelaProduto49}
                    ${tabelaProduto50}
                    ${tabelaProduto51}
                    ${tabelaProduto52}
                    ${tabelaProduto53}
                    ${tabelaProduto54}
                    ${tabelaProduto55}
                    ${tabelaProduto56}


                </tbody>
            </table>
        </div>
        <div class="div1">
            <!-- JANELA MODAL -->  
            <div id="modal_1" class="modal">
                <div class="modal__content">
                    <div class="info">
                        <h2 class="modal__title">Adicione o Produto</h2>
                        <p class="modal__description">
                            Essa página é destinada para o cadastro de produtos, por favor preencha os campos!
                        </p></div>
                    <!-- FORMULARIO -->  
                    <div class="container_1 form">
                        <div class="headerzao">
                            <h2>Adicionar Produto</h2>
                        </div>

                        <form action="CadastrarProdutoViewController" method="post" class="form" id="cadastrarProduto" style="margin-bottom: -25px;">
                            <div id="form-wrap">
                                <div class="form-control">
                                    <label>Código do Produto</label>
                                    <input placeholder="" disabled/>
                                    <i class="fas fa-exclamation-circle"></i>
                                    <i class="fas fa-check-circle"></i>
                                </div>

                                <div class="form-control">
                                    <label>Descrição do Produto</label>
                                    <input 
                                        type="text" 
                                        placeholder="Digite a descrição do produto..." 
                                        name="descricao"
                                        />
                                    <i class="fas fa-exclamation-circle"></i>
                                    <i class="fas fa-check-circle"></i>
                                </div>

                                <div class="form-control">
                                    <label>Preço do Produto</label>
                                    <input
                                        type="text"
                                        class="preco"
                                        placeholder="Digite o Preço do Produto..."
                                        name="preco"
                                        />
                                    <i class="fas fa-exclamation-circle"></i>
                                    <i class="fas fa-check-circle"></i>
                                </div>

                                <div class="form-control">
                                    <label>Unidades no Estoque</label>
                                    <input
                                        type="number"
                                        id="password-confirmation"
                                        placeholder="Digite quantas unidades tem no Estoque..."
                                        name="unidades"
                                        />
                                    <i class="fas fa-exclamation-circle"></i>
                                    <i class="fas fa-check-circle"></i>
                                </div>

                                <div class="form-control" style="width: 100%!important;">
                                    <label>Imagem do Produto</label>
                                    <input
                                        type="url"
                                        id="link"
                                        placeholder="Cole o link da imagem do produto..."
                                        name="imgUrl"
                                        />
                                    <i class="fas fa-exclamation-circle"></i>
                                    <i class="fas fa-check-circle"></i>
                                </div>
                            </div>
                            <button type="submit">Adicionar Produto</button>
                        </form>
                        <button id="fechamento" onclick="document.getElementById('modal_1').classList.toggle('visivel')" style="position: relative;left: 52%;
                                margin-bottom: -20px;top: -58px;">Cancelar</button>


                    </div>
                </div>
            </div>
        </div>



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
        <script src="https://kit.fontawesome.com/f9e19193d6.js" crossorigin="anonymous"></script>
        <script src="js/form.js"></script>
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js" type="text/javascript"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
        <script src="https://plentz.github.io/jquery-maskmoney/javascripts/jquery.maskMoney.min.js" type="text/javascript"></script>
        <script>
                            jQuery(function () {

                                jQuery(".preco").maskMoney({
                                    prefix: 'R$ ',
                                    thousands: '.',
                                    decimal: '.'
                                });
                            });
                            function teste() {
                                document.getElementById('modal_1').classList.toggle('visivel');
                            }
                            function modal2() {
                                document.getElementById('modal_2').classList.toggle('visivel');

                            }
        </script>

        <script type="text/javascript">
            $('#modal_2').on('show.bs.modal', function (event) {
                var button = $(event.relatedTarget);
                ;
                var desc = button.data('desc');
                var prec = button.data('pre');
                var uni = button.data('uni');
                var img = button.data('img');
                var modal = $(this);
                modal.find('#descricaoM').val(desc);
                modal.find('#precoM').val(prec);
                modal.find('#unidadesM').val(uni);
                modal.find('#imagemM').val(img);
            });


        </script>


    </body>
</html>