import java.util.ArrayList;
import java.time.LocalDate;
/**
 * @author Ramon
 * @version 1.0
 * @created 04-fev-2016 18:04:59
 */
public class User {

	/**
	 * Numero de matricula.
	 */
	private String accessKey;
	private String address;
	private ArrayList<Book> books;
	private String CPF;
	private int MAXBOOKS = 4;
	private String name;
	private String password;

	public User(String accessKey, String address, Book books, String CPF, String name, String password){

		this(name, CPF);

		setAccessKey(accessKey);

		setAddress(address);

		setPassword(password);

	}


	public User(String name, String CPF){
		this();

		setCPF(CPF);

		setName(name);

	}
	public User(){
		books = new ArrayList<Book>();
	}

	@Override
	 public String toString(){

		String description;
		description = "Nome: "+ getName()+"\n";
		description += "CPF: "+ getCPF()+"\n";
		description += "Quantidade de livros: " + books.size() +"\n";
		description += "Endereco: " + ( getAddress() == null? "Nao informado" : getAddress() )+"\n";
		description += "matricula: "+ ( accessKey == null? "Nao informado" : getAccessKey() );


		return description;
	}



	public boolean equals(Object obj){

			return getCPF().equals( (String) obj);
	}

	public void setAccessKey(String accessKey ){
		this.accessKey = accessKey;
	}

	public void setAddress(String address ){
		this.address = address;
	}

	public void setCPF(String CPF ){
		this.CPF = CPF;
	}

	public void setName(String name ){
		this.name = name;
	}

	public void setPassword(String password ){
		this.password = password;
	}

	//gets

	public String getAccessKey(){
		return accessKey;
	}

	public String getAddress(){
		return address;
	}

	public ArrayList<Book> getBooks(){
		return books;
	}

	public String getCPF(){
		return CPF;
	}

	public int getMAXBOOKS(){
		return MAXBOOKS;
	}

	public String getName(){
		return name;
	}

	public String getPassword(){
		return password;
	}

	public void addBook( Book book ){
		if(books.size()<4){
			books.add(book);
		}
	}

	public boolean returnBook(String titleOrISBN){
		for(int i = 0; i<books.size();i++){

			if( books.get(i).getTitle().equals(titleOrISBN) || books.get(i).getISBN().equals(titleOrISBN)){
				books.remove(i);
				return true;
			}

		}
		return false;

	}
	public boolean blockedLoan(){
		return false;
	}
	public boolean blocked(){
		return false;
	}
	public LocalDate getReturnDate( Book b ){
		return LocalDate.now().plusDays( 20 );
	}
	public void returnDate( Book b, LocalDate date ){
		;
	}
	public boolean contains( String isbn ){
		return contains( new Book( "", isbn ) );
	}
	public boolean contains( Book b ){
		return getBooks().contains( b );
	}

	/**
	 *
	 * @param T
	 */

}//end User
