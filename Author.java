package guru.springframework.webapp.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.lang.*;
import java.util.Set;

@Entity
//Errors-Warnings-typos
public class Author {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>();

    public Author(){}//constructor with no argument
    //create a constructor with three arguments fn, ln, and bk
    public Author(String firstName, String lastName,Set<Book> books ){
        this.firstName = firstName;
        this.lastName = lastName;
        this.books = books;
    }//end constructor

    //create getters
    //get firstName
    public long getId(){
        return id == null ? 0 : id;
    }
    public String getFirstName(){
        return firstName;
    }
    //get lastName
    public String getLastName(){
        return lastName;
    }
    //get books
    public Set<Book> getBooks(){
        return books;
    }//end getISBN

    //create setters
    public void setId(long id){
        this.id = id;
    }
    //set firstName
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }//end setFirstName
    //setLastName
    public void setLastName(String lastName){
        this.lastName = lastName;
    }//end setLastName
    //setISBN
    public void setBooks(Set<Book> books){
        this.books = books;
    }

    @Override
    public String toString(){
        return "Authors {" +
              "ID: "+getId()+
                "First Name: "+getFirstName()+"\n" +
                "Last Name: "+getLastName()+"\n" +
              "Books: "+ getBooks()+
                "}";
    }//end toString()

    @Override
    public boolean equals(Object o){
        if(this.hashCode() == (o.hashCode())) {
            return true;
        }
        else {
            return false;
        }

   }//end equals()

}//end class Author
