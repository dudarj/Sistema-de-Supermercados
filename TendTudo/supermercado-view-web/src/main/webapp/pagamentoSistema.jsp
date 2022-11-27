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
        <!-- CSS Janela Modal -->
        <link rel="stylesheet" href="css/modal.css">
        <!-- CSS Formulário-->
        <link rel="stylesheet" href="css/styles.css">

        <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
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
                        <a class="navbar-brand" href="mainGerencia.jsp"><img src="images/tendtudo.png" class="logo" alt="" style="width: 200px; margin-bottom: -30px; margin-top: -40px;"><h2 style="text-align: center">TendTudo - Pagamentos</h2></a>

                    </div>
                    <!-- End Header Navigation -->
                    <a onclick="document.getElementById('modal_1').classList.toggle('visivel')" id="add_produto" class="ml-auto btn hvr-hover">Adicionar Pagamento</a>
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
                        <th class="col-xs-6">Data Pagamento</th>
                        <th class="col-xs-6">Endereço</th>
                        <th class="col-xs-3">Met de Pagamento</th>
                        <th class="col-xs-3">Tipo Entrega</th>
                        <th class="col-xs-3">Total</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <th scope="row">1</th>
                        <td class="col-xs-3">Duda</td>
                        <td class="col-xs-6">R$ 170,00</td>
                        <td class="col-xs-6">22/11/22</td>
                        <td class="col-xs-6">Rua das Rosas</td>
                        <td class="col-xs-3">Cartão de Crédito</td>
                        <td class="col-xs-3">Entrega Premium R$ 10,00</td>
                        <td class="col-xs-3">R$ 180,00</td>
                    </tr>
                </tbody>
                <tbody>
                    <tr>
                        <th scope="row">2</th>
                        <td class="col-xs-3">Enzo</td>
                        <td class="col-xs-6">R$ 50,00</td>
                        <td class="col-xs-6">27/11/22</td>
                        <td class="col-xs-6">Carlos Prates</td>
                        <td class="col-xs-3">Dinheiro</td>
                        <td class="col-xs-3">Entrega Black Premium R$ 20,00</td>
                        <td class="col-xs-3">R$ 70,00</td>
                    </tr>
                    <tr>
                        <th scope="row">3</th>
                        <td class="col-xs-3">Samuel</td>
                        <td class="col-xs-6">R$ 80,00</td>
                        <td class="col-xs-6">24/11/22</td>
                        <td class="col-xs-6">Confins</td>
                        <td class="col-xs-3">Pix</td>
                        <td class="col-xs-3">Entrega Normal</td>
                        <td class="col-xs-3">R$ 80,00</td>
                    </tr>
                </tbody>
            </table>
        </div>

        <div class="div1">
        <!-- INICIO JANELA MODAL --> 
    <div id="modal_1" class="modal">
        <div class="modal__content form">
            <h2 class="modal__title">Adicione o Pagamento</h2>
            <p class="modal__description">
                Essa página está destinada para o cadastro de produtos, por favor preencha os campos!
            </p>
            <!-- FORMULARIO -->  
            <div class="container_1 form>"
                <div class="headerzao">
                  <h2>Adicione Pagamento</h2>
                </div>
          
                <div class="form-control">
                    <label for="email">Código Pagamento</label>
                    <input type="text" id="email" placeholder="Digite o código do pagamento..." />
                    <i class="fas fa-exclamation-circle"></i>
                    <i class="fas fa-check-circle"></i>
                    <small>Mensagem de erro</small>
                  </div>
                
                <div class="col-md-4 mb-3">
                    <label for="state">Tipo Pagamento</label>
                    <select class="wide w-100" id="state">
                        <option data-display="Select">Escolha.  ..</option>
                        <option value="Acre">Pix</option>
                        <option value="Alagoas">Cartão Crédito</option>
                        <option value="Amapá">Cartão Débito</option>
                        <option value="Amapá">Paypal</option>
                        <option value="Amapá">Dinheiro</option>
                    </select>
                  </div>
          
                  <div class="form-control">
                    <label for="password">Descrição Pagamento</label>
                    <input
                      type="text"
                      id="password"
                      placeholder="Digite a descrição do pagamento..."
                    />
                    <i class="fas fa-exclamation-circle"></i>
                    <i class="fas fa-check-circle"></i>
                    <small>Mensagem de erro</small>
                  </div>
          
                  <button type="submit">Adicionar Pagamento</button>
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