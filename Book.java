package guru.springframework.webapp.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

    @Entity
public class Book {
    @Id
    @Column
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String isbn;
    private String genre;
 // @ManyToOne(cascade = {CascadeType.ALL})

    @ManyToMany
    @JoinTable(name ="author_book", joinColumns = @JoinColumn(name ="bid"),
    inverseJoinColumns = @JoinColumn(name = "aid"))
    private Set<Author> authors = new HashSet<>();

    public Book(){}//create empty constructor
    //three arguments constructor
    public Book(String title, String isbn, Set<Author> authors){
        this.title = title;
        this.isbn = isbn;
        this.authors =  authors;
    }//end three arguments constructor

    //create getters and setters
    //create getter
    public long getId(){return id == null ? 0 : id;}
    //getTitle
    public String getTitle(){
        return title;
    }
    public String getISBN(){
        return isbn;
    }
    public Set<Author> getAuthors(){
        return authors;
    }
    public String getGenre(){
        return genre;
    }

    //set Setters
    public void setId(long id){
        this.id = id;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setISBN(String isbn){
        this.isbn = isbn;
    }
    public void setAuthor(Set<Author> authors){
        this.authors = authors;
    }
    public void setGenre(String genre){
        this.genre = genre;
    }
    @Override
    public String toString(){
        return "Books{" +
                "Title: "+getTitle()+"\n" +
                "Number: "+getISBN()+"\n" +
                "Author: "+getAuthors()+
                "Genre: "+getGenre()+
              "}";
    }
    @Override
    public boolean equals(Object o){
            if(this.isbn.equals(o)) {
                return true;
            }
        else {
                return false;
            }
    }
 //   @Override
/*    public int hashCode(){
        return id != null? id.hashCode():0;
    }
*/
}
