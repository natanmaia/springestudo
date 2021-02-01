package br.com.natanmaia.data.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "books")
public class Books implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String author;

    @Temporal(TemporalType.DATE)
    private Date launch_date;

    @Column(nullable = false)
    private Double   price;

    @Column(length = 10)
    private String title;

    public Books(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getLaunch_date() {
        return launch_date;
    }

    public void setLaunch_date(Date launch_date) {
        this.launch_date = launch_date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Books)) return false;

        Books books = (Books) o;

        if (!getId().equals(books.getId())) return false;
        if (!getAuthor().equals(books.getAuthor())) return false;
        if (!getLaunch_date().equals(books.getLaunch_date())) return false;
        if (!getPrice().equals(books.getPrice())) return false;
        return getTitle().equals(books.getTitle());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getAuthor().hashCode();
        result = 31 * result + getLaunch_date().hashCode();
        result = 31 * result + getPrice().hashCode();
        result = 31 * result + getTitle().hashCode();
        return result;
    }
}
