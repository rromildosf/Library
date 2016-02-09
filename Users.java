/**
 * Fornece os métodos necessários para gerenciamento dos usuários.
 * @authors Giuan, Ramon, Romildo
 * @version 1.0
 * @created 04-fev-2016 18:04:59
 * @updated 05-fev-2016
 */

import java.util.HashMap;

public class Users {

	private boolean updated;
	private HashMap<String, User> users;
	// public Management m_Management;

	public Users(){
		users = new HashMap<>();
		updated = false;
	}
	public boolean addUser( User user ){
		if( !users.containsKey( user.getCPF() ) ){
			users.put( user.getCPF(), user );
			updated = true;
			return true;
		}
		return false;
	}
	public boolean removeUser( String cpf ){
		if( users.remove( cpf ) != null ) return true;
		return false;
	}
	// informa se existe um usuário com tal CPF
	public boolean alreadyUser( String cpf ){
		return users.containsKey( cpf );
	}
	public boolean updated(){
		return updated;
	}
	public int size(){
		return users.size();
	}
	public User getUser( String cpf ){
		return users.get( cpf );
	}
	public boolean contains( User u ){
		return contains( u.getCPF() );
	}
	public boolean contains( String cpf ){
		return getUsers().containsKey( cpf );
	}
	public HashMap<String, User>getUsers(){
		return users;
	}
}//end Users
