import java.time.LocalDate;
import java.util.PriorityQueue;
public class Book {

    private String title; // Title of the Book
    private String ISBN;
    private String author;
    private String description; // description of book
    private String others; // others authors
    private int pages; // Number of pages
    private int year; // year of publication;
    private int edition; // book edition
    private String publishing; // publishing house;

    // Data reference of Library
    private LocalDate registerDate; // date of register in the library
    private double price; // price of acquisition of book
    private int copies; // quantity of copies
    private String notes;  // notes about the book;
    private int allLoans; // number of lending of the book GERAL
    private int loans; // actual
    private int reserves;// quatity of reserves for this book;

    private PriorityQueue<User>revervedForUsers;
    
    public Book (){

    }

    public Book( String title, String isbn ){
        this();
        setTitle( title );
        setISBN ( isbn );
        setCopies( 1 );
        configDate();
    }
    public Book( String title, String isbn, String author ){
        this( title, isbn );
        setAuthor( author );
    }
    public Book( String title, String isbn, int copies ){
        this( title, isbn );
        setCopies( copies );
    }
    public Book( String title, String isbn, String author, int copies ){
        this( title, isbn, copies );
        setAuthor( author );
    }
    public Book( String title, String isbn,String author,
    String publishing, int pages, int copies ){
        this( title, isbn, author, copies);
        setPages( pages );
        setCopies( copies );
        setPublishing( publishing );
    }

    // Configura a data de cadastro;
    private void configDate(){
        registerDate = LocalDate.now();
    }
    public void setDate( LocalDate date ){
        this.registerDate = date;
    }
    public void setTitle( String title ){
        this.title = ( title.equals( "" ) ? "Unknown" : title );
    }
    public void setYear( int year ){
        year = ( year > 0 || year < 2200 ? year : 0 );
    }
    public void setAuthor( String name ){
        if( name.matches( "[0-9]" ) ) author = name;
        else author = "Unknown";
    }
    public void setISBN( String isbn ){
        ISBN = ( isbn.length() == 13 ? isbn : "0000000000000" );
    }
    public void setPublishing( String p ){
        publishing = ( p.length() > 0 ? p : "Unknown" );
    }
    public void setPages( int pages ){
        this.pages = pages > 0 ? pages : 1;
    }
    public void setOthers( String ot ){
        others = ot;
    }
    public void setCopies( int copies ){
        this.copies = copies >= 1 ? copies : 1;
    }
    public void setNotes( String note ){
        notes = note;
    }
    public void setEdition( int ed ){
        edition = ed;
    }
    public void setDescription( String desc ){
        description = desc;
    }
    public void returns(){
        loans--;
        if( loans < 0 )
            new Exception( "Foi devolvido mais exemplares de " +
            getTitle() + ", " + getISBN() + " do que emprestado. :)" );
    }
    public Book loan(){
        allLoans++;
        loans++;
        return this;
    }
    public int getAvaliableCopies(){
        int cps = ( getCopies() - getLoans() - getReserves()-1 );
        return ( cps > 0 ? cps : 0 );
    }
    public String getTitle()        { return title; }
    public String getOthers()       { return others; }
    public String getAuthor()       { return author; }
    public String getNotes()        { return notes; }
    public String getISBN()         { return ISBN; }
    public String getDescription()  { return description; }
    public int getYear()            { return year; }
    public int getPages()           { return pages; }
    public int getCopies()          { return copies; }
    public boolean avaliable()      { return getAvaliableCopies() > 0; }
    public int getLoans()           { return loans; }
    public void reserveFor( User u ){
        revervedForUsers.add( u );
        reserves++;
    }
    public PriorityQueue<User> getUsersReserve(){
        return revervedForUsers;
    }
    public int getReserves(){ return reserves; }
    @Override public boolean equals( Object o ){
        return this.getISBN().equals( ((Book)o).getISBN() );
    }
    @Override
    public String toString(){
        return
        String.format( "Título: %s\nAutor: %s\nISBN: %s\n", getTitle(),
            getAuthor()!= null? getAuthor() : "Unknown", getISBN() );
    }

    /*
    *@constructor: Book( String title, String ISBN )
    *@constructor: Book( String title, String ISBN, String author )
    *@constructor: Book( String title, String ISBN, int copies )
    *@constructor: Book( String title, String ISBN, String publishing, int pages, int copies )
    *
    *
    *
    */
}
