/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.servicos;

import java.util.List;

import model.DAO.DAOFactory;
import model.DAO.ItemDAO;
import model.DTO.Item;
import model.DTO.Produto;
import model.DTO.Venda;

/**
 *
 * @author Maria Eduarda 
 */
public class ItemServico implements ItemDAO{

	private ItemDAO dao = DAOFactory.createItemDao();
	
	@Override
	public void insert(Item obj, Produto p, Venda v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Item obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Item findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> ListarItens() {
		// TODO Auto-generated method stub
		return null;
	}

	public void salvar(Item obj, Venda venda , Produto produto) {
		dao.salvar(obj, venda.getCodigo(), produto.getCodigo());	
	}

	@Override
	public void salvar(Item obj, Long id_venda, Long id_produto) {
		// TODO Auto-generated method stub	
	}

       
}
