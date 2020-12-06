package uam.bd.restaurante.BD.Controllers;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import uam.bd.restaurante.BD.DAO.DAO_Foreign;
import uam.bd.restaurante.BD.DAOmysql.EnvioDAOImpl;
import uam.bd.restaurante.BD.Model.Envio;
import uam.bd.restaurante.BD.MysqlConnector.DBConnection;

@RestController
public class EnvioController 
{
	private DAO_Foreign<Envio> envioDAO;
	
	public EnvioController()
	{
		envioDAO = new EnvioDAOImpl(DBConnection.getConnection());
	}
	
	@PostMapping(path="/envios")
	public boolean savePedido(@RequestBody Envio t) 
	{			
		try 
		{
			return envioDAO.save(t) > 0;
		} 
		catch (DataIntegrityViolationException e) 
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Este Envio Ya Existe", e);
		} 
		catch (Exception e) 
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error, Exception ", e);
		}
	}	
	
	@GetMapping("/envios")		
	public List<Envio> get()
	{		
		List<Envio> envios;
		try 
		{
			envios = envioDAO.getAll();
			return envios;
		} 
		catch (Exception e) 
		{			
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error, Exception ", e);
		}		
	}
	
	@DeleteMapping("/envios")
	public boolean deletePedido(@RequestBody Envio t)
	{
		try 
		{
			return envioDAO.delete(t) > 0;
		} 
		catch (Exception e) 
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error, Exception ", e);
		}
	}
	
	@PutMapping("/envios")
	public boolean updatePedido(@RequestBody Envio t)
	{
		try
		{
			return envioDAO.update(t) > 0;
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error, Exception ", e);
		}
	}
}
