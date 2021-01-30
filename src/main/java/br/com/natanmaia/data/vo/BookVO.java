package br.com.natanmaia.data.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;
import org.springframework.hateoas.ResourceSupport;

import java.io.Serializable;
import java.util.Date;

@JsonPropertyOrder({"id", "author", "launch_date", "price", "title"})
public class BookVO extends ResourceSupport implements Serializable {

    private static final long serialVersionUID = 1L;

    @Mapping("id")
    @JsonProperty("id")
    private Long key;

    private String author;

    private Date launch_date;

    private Float price;

    private String title;

    public BookVO (){

    }

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
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
        if (!(o instanceof BookVO)) return false;
        if (!super.equals(o)) return false;

        BookVO bookVO = (BookVO) o;

        if (!getKey().equals(bookVO.getKey())) return false;
        if (!getAuthor().equals(bookVO.getAuthor())) return false;
        if (!getLaunch_date().equals(bookVO.getLaunch_date())) return false;
        if (!getPrice().equals(bookVO.getPrice())) return false;
        return getTitle().equals(bookVO.getTitle());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getKey().hashCode();
        result = 31 * result + getAuthor().hashCode();
        result = 31 * result + getLaunch_date().hashCode();
        result = 31 * result + getPrice().hashCode();
        result = 31 * result + getTitle().hashCode();
        return result;
    }
}
