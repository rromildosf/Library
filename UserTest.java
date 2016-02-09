public class UserTest {
    public static void main(String[] args) {
        User u = new User( "User 1", "00912234899" );
        u.setAddress( "Rua Severino Maia" );
        u.setAccessKey( "17837264" );
        u.addBook( new Book("A arte da criação", "9600854565465" ) );
        System.out.println( u );
        System.out.println( "User have: " + u.contains( "9600854565465" ) );
        System.out.println( "Returning: " + u.returnBook( "9600854565465" ) );

        for( Book b : u.getBooks() ){
            System.out.println( "Livro: " + b );
        }
    }
}
