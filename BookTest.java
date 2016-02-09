public class BookTest {
    public static void main(String[] args) {
        System.out.println( "Before create book" );
        Book book = new Book( "A vida em marte", "9781234564319" );
        Book book2 = new Book( "A vida em Jupiter", "9781234564319", "Autor desconhecido" );
        System.out.println( "After create book: " + book.getTitle() + " " + book.getISBN() );
        System.out.println( "After create book2: " + book2.getTitle() + " " + book2.getISBN() );

    }
}
