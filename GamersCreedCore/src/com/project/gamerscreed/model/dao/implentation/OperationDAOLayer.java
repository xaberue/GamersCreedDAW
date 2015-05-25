package com.project.gamerscreed.model.dao.implentation;

import java.util.List;

import javax.persistence.TypedQuery;

import com.project.gamerscreed.model.dao.GenericDAOLayer;
import com.project.gamerscreed.model.dao.OperationDAO;
import com.project.gamerscreed.model.dto.Operation;
import com.project.gamerscreed.model.dto.User;
import com.project.gamerscreed.model.dto.Videogame;

public class OperationDAOLayer extends GenericDAOLayer implements OperationDAO {

	@Override
	public boolean create(Operation anOperation) {
		try{
			this.beginTransaction();
			
			anOperation.setUserReceived(this.entityManager.getReference(User.class, anOperation.getUserReceived().getId()));
			anOperation.setUserSender(this.entityManager.getReference(User.class, anOperation.getUserSender().getId()));
			anOperation.setVideogameReceived(this.entityManager.getReference(Videogame.class, anOperation.getVideogameReceived().getId()));
			//Just in case of a trade between two games
			if(anOperation.getVideogameSended() != null)
				anOperation.setVideogameSended(this.entityManager.getReference(Videogame.class, anOperation.getVideogameSended().getId()));
			
			this.entityManager.persist(anOperation);
			
			anOperation.getUserReceived().addOperationsReceived(anOperation);
			anOperation.getUserSender().addOperationsSended(anOperation);
			anOperation.getVideogameSended().addOperationsSended(anOperation);
			anOperation.getVideogameReceived().addOperationsReceived(anOperation);
			
			this.entityManager.merge(anOperation.getUserReceived());
			this.entityManager.merge(anOperation.getUserSender());
			this.entityManager.merge(anOperation.getVideogameSended());
			this.entityManager.merge(anOperation.getVideogameReceived());
			
			this.commitTransaction();
			this.closeTransaction();
			
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean modify(Operation anObject) {
		//Will not be implemented. NOT NEEDED
		return false;
	}

	@Override
	public boolean remove(Operation anObject) {
		try{
			Operation tmpOperation = (Operation) anObject;
			
			this.beginTransaction();
			this.entityManager.remove(tmpOperation);
			this.commitTransaction();
			this.closeTransaction();
			
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}	
	}

	@Override
	public List<Operation> getAll() {
		TypedQuery<Operation> query = this.entityManager.createNamedQuery("Operation.findAll", Operation.class);
		List<Operation> result = query.getResultList();
		
		return result;
	}

	@Override
	public boolean acceptOperation(int anId) {
		//TODO Accept operation
		return false;
	}

	@Override
	public boolean rejectOperation(int anId) {
		try{
			TypedQuery<Operation> query = this.entityManager.createNamedQuery("Operation.rejectOperation", Operation.class);
			query.setParameter("id", anId);
			int tmpResult = query.executeUpdate();
			
			if(tmpResult > 0)
				return true;
			else
				return false;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}	

}