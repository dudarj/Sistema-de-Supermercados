module SupermercadoNegocio{
    requires java.sql;
       
    exports conexao;
    exports model.DAO;
    exports model.DAO.impl;
    exports model.DTO;
    exports model.servicos;
    exports model.exceptions;
    exports listeners;
}
