import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Fornece os m�todos necess�rios para gerenciamento dos livros dispon�veis na
 * biblioteca.
 * @author Giuan, Ramon, Romildo
 * @version 1.0
 * @created 04-fev-2016 18:04:59
 */

public class Books {

	private HashMap<String,Book> books;
	private boolean updates;

	public Books(){
		books = new HashMap<>();
	}
	public boolean contains( Book b ){
		return contains( b.getISBN() );
	}
	public boolean contains( String ISBN ){
		return ( books.get( ISBN ) != null );
	}

	public boolean alreadyExists(String name){
		return false;
	}
	public boolean removeBook( String ISBN ){
		return ( books.remove( ISBN ) != null );
	}
	public Book searchBook( String info ){
		Book b;
		b = books.get( info ); // busca pelo isbn
		if ( b != null ) return b;
		Iterator i = getBooks().values().iterator();
		while( i.hasNext() ){
			b = (Book)i.next();
			if( b.getTitle().equals( info ) ) break;
		}


		return b;
	}

	public boolean addBook( Book b ){
		if( books.containsKey( b.getISBN() ) ) return false;
		books.put( b.getISBN(), b );
		return true;
	}
	public Book removeBook( Book b ){
		return books.remove( b.getISBN() );
	}
	public ArrayList<Book> searchBooks( String author ){
		ArrayList<Book> bks = new ArrayList<>();
		Iterator i = getBooks().values().iterator();
		while( i.hasNext() ){
			Book b = (Book)i.next();
			if( b.getAuthor().equals( author ) )
				bks.add( b );
		}
		return bks; // books
	}
	public Book getBook( String isbn ){
		return books.get( isbn );
	}
	public HashMap<String, Book> getBooks(){
		return books;
	}
}//end Books
