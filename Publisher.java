package guru.springframework.webapp.domain;

import guru.springframework.webapp.domain.Book;
import guru.springframework.webapp.domain.Author;
import javax.persistence.Entity;
import org.hibernate.annotations.ValueGenerationType;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;
import java.lang.*;
import java.util.Set;
import java.util.HashSet;

@Entity
public class Publisher {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;
    @Column
    private String address;
    @Column
    private String city;
    @Column
    private String state;
    @Column
    private String zip;

    @OneToMany(cascade = {CascadeType.ALL})
    private Set<Author> authors = new HashSet<Author>();

    @OneToMany(cascade = {CascadeType.ALL})
    private Set<Book> books = new HashSet<Book>();

    public Publisher(){}
    public Publisher(String name,String address, String city,String state,String zip ){
        this.name = name;
     // this.books = books;
     // this.authors = authors;
        this.address = address;
        this. city = city ;
        this.state = state;
        this.zip = zip;
    }


    public String getName() {
          return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToMany(cascade = {CascadeType.ALL})
    public Set<Book> getBooks(){
        return books;
    }
    public void setBooks(Set<Book> books){
        this.books = books;
    }

    @OneToMany(cascade = {CascadeType.ALL})
    public Set<Author> getAuthors(){
        return authors;
    }
    public void setAuthors(Set<Author> authors){
        this.authors = authors;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public long HashCode(){
        return  id != null? id.hashCode(): 0;
 }
    @Override
    public String toString() {
        return "Publishers{" +
  //              "ID='" + getId() + '\'' +
                "name='" + getName() + '\'' +
                 "Address='" + getAddress() + '\'' +
                "City='" + getCity() + '\'' +
                "State='" + getState() + '\'' +
                "Zip='" + getZip() + '\'' +
                '}';
    }
}
