import javafx.beans.property.StringProperty;
public class Management {
    private int LOAN_PERIODY = 20;
    private StringProperty errorNote; // note of events errors;
    private Users users;
    private Books books;
    private Books loanBooks; // livros emprestados
    private Books reservedBooks; // lista de livros reservados;

    public Management(){}
    public Management( StringProperty strp ){
        errorNote = strp;
    }

    public boolean registerUser( User u ){
        if( !getUsers().contains( u ) ){
            users.addUser( u );
            return true;
        }
        errorNote.set( "O usuário já está cadastrado no sistema!" );
        return false;
    }
    public boolean registerBook( Book b ){
        if( !getBooks().contains( b ) ){
            getBooks().addBook( b );
            return true;
        }
        errorNote.set( "O Livro já encontra-se cadastrado!" );
        return false;
    }
    public boolean bookLoan( User u, Book b ){
        // se o usuário não estiver bloqueado, e o livro disponível ou não,
        // mas que o usuário seja o primeiro da lista de espera
        if( !u.blockedLoan() && ( b.avaliable() || b.getUsersReserve().peek().equals( u ) ) ){
            u.addBook( b.loan() );
            loanBooks.addBook( b ); // adiciona na "estande de eprestados"
            if(  b.getUsersReserve().peek().equals( u ) )
                 b.getUsersReserve().poll();// remove o usuário da lista de espera do livro
            return true;
        }
        else{
            if( !b.avaliable() ){
                errorNote.set( "Livro não disponível para emsprestímo, sem exemplares." );
            }
            else if( u.blockedLoan() )
                errorNote.set( "Usuário com a quantidade máxima de livros." );
            else if( u.blocked() )
                errorNote.set( "Usuário bloqueado na biblioteca, não pode realizar emprestímos." );
            return false;
        }
    }
    public boolean renewLoan( User u, Book b ){
        // verifica se o usuário pode pegar o livro(por causa de pendência) e se o
        // livro tá dispoínivel;
        if( !u.blocked() && !reservedBooks.contains( b ) && b.avaliable() ){
            // se tudo ok, muda a data de devolução
            u.returnDate( b, u.getReturnDate(b).plusDays( LOAN_PERIODY ) ); // obj LocalDate
            return true;
        }
        else{
            if( u.blocked() ){
                errorNote.set( "Usuário bloqueado, não pode renovar o livro." );
            }
            else{
                errorNote.set( "Livro na fila de reservas." );
            }
            return false;
        }
    }
    public StringProperty errorNoteProperty(){
        return errorNote;
    }

    public Users getUsers(){
        return users;
    }
    public Books getBooks(){
        return books;
    }
}
