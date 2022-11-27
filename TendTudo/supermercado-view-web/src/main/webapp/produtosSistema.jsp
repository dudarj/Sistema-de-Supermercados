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
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <th scope="row">1</th>
                        <td class="col-xs-6">Batata Palha Vilma</td>
                        <td class="col-xs-6">R$ 4.29</td>
                        <td class="col-xs-6">(No Estoque)</td>
                        <td class="col-xs-3">(Link Imagem)</td>
                    </tr>
                </tbody>
                <tbody>
                    <tr>
                        <th scope="row">2</th>
                        <td class="col-xs-6">Cereal Matinal Duo, NESCAU</td>
                        <td class="col-xs-6">R$7.99</td>
                        <td class="col-xs-6">(No Estoque)</td>
                        <td class="col-xs-3">(Link Imagem)</td>
                    </tr>
                    <tr>
                        <th scope="row">3</th>
                        <td class="col-xs-6">Picanha Prata Swift</td>
                        <td class="col-xs-6">R$79.99</td>
                        <td class="col-xs-6">(No Estoque)</td>
                        <td class="col-xs-3">(Link Imagem)</td>
                    </tr>
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
            <h2 class="modal__title">Adicione o Produto</h2>
            <p class="modal__description">
                Essa página está destinada para o cadastro de produtos, por favor preencha os campos!
            </p>
            <!-- FORMULARIO -->  
            <div class="container_1 form">
                <div class="headerzao">
                  <h2>Adicionar Produto</h2>
                </div>
          
                <form id="form" class="form" action="CadastrarProdutoViewController" method="post">
                  <div class="form-control">
                    <label for="username">Código do Produto</label>
                    <input placeholder="" disabled/>
                    <i class="fas fa-exclamation-circle"></i>
                    <i class="fas fa-check-circle"></i>
                    <small>Mensagem de erro</small>
                  </div>
          
                  <div class="form-control">
                    <label for="email">Descrição do Produto</label>
                    <input type="text" id="email" placeholder="Digite a descrição do produto..." />
                    <i class="fas fa-exclamation-circle"></i>
                    <i class="fas fa-check-circle"></i>
                    <small>Mensagem de erro</small>
                  </div>
          
                  <div class="form-control">
                    <label for="password">Preço do Produto</label>
                    <input
                      type="text"
                      id="password"
                      placeholder="Digite o Preço do Produto..."
                    />
                    <i class="fas fa-exclamation-circle"></i>
                    <i class="fas fa-check-circle"></i>
                    <small>Mensagem de erro</small>
                  </div>
          
                  <div class="form-control">
                    <label for="password-confirmation">Unidades no Estoque</label>
                    <input
                      type="number"
                      id="password-confirmation"
                      placeholder="Digite quantas unidades tem no Estoque..."
                    />
                    <i class="fas fa-exclamation-circle"></i>
                    <i class="fas fa-check-circle"></i>
                    <small>Mensagem de erro</small>
                  </div>

                  <div class="form-control">
                    <label for="password">Imagem do Produto</label>
                    <input
                      type="url"
                      id="link"
                      placeholder="Cole o link da imagem do produto..."
                    />
                    <i class="fas fa-exclamation-circle"></i>
                    <i class="fas fa-check-circle"></i>
                    <small>Mensagem de erro</small>
                  </div>
          
                    <input type="submit" value="Submit">
                  <button id="fechamento" onclick="document.getElementById('modal_1').classList.toggle('visivel')" type="submit">Cancelar</button>

                </form>
              </div>
        </div>
    </div>
    <div id="modal_2" class="modal modal--2">
        <div class="modal__content">
            <h2 class="modal__title">Meu primeiro modal</h2>
            <p class="modal__description">
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Perferendis id error accusamus pariatur quasi
                est amet maiores tempore, eum beatae expedita fugiat modi, ipsum commodi laborum voluptatem, assumenda
                et quod?
            </p>
            <a href="produtosSistema.jsp" class="modal__link">OK</a>
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
        <script src="https://plentz.github.io/jquery-maskmoney/javascripts/jquery.maskMoney.min.js" type="text/javascript"></script>
        <script>
            jQuery(function() {
                
                jQuery("#password").maskMoney({
                prefix:'R$ ', 
                thousands:'.', 
                decimal:','
            })
            });
            function teste() {
                document.getElementById('modal_1').classList.toggle('visivel');
            }
            </script>              
    </body>
</html>