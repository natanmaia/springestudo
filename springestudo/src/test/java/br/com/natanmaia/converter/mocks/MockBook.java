package br.com.natanmaia.converter.mocks;

import br.com.natanmaia.data.models.Books;
import br.com.natanmaia.data.vo.BookVO;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MockBook {

    public Books mockEntity() {
        return mockEntity(0);
    }

    public BookVO mockVO() {
        return mockVO(0);
    }

    public List<Books> mockEntityList() {
        List<Books> books = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            books.add(mockEntity(i));
        }
        return books;
    }

    public List<BookVO> mockVOList() {
        List<BookVO> bookVOs = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            bookVOs.add(mockVO(i));
        }
        return bookVOs;
    }

    private Books mockEntity(Integer number) {
        Books book = new Books();
        book.setAuthor("Author teste" + number);
        book.setLaunch_date(Date.from(Instant.now()));
        book.setPrice((number * 10.7));
        book.setTitle("title teste" + number);
        book.setId(number.longValue());
        return book;
    }

    private BookVO mockVO(Integer number) {
        BookVO book = new BookVO();
        book.setAuthor("Author teste" + number);
        book.setLaunch_date(Date.from(Instant.now()));
        book.setPrice((number * 10.7));
        book.setTitle("Title teste" + number);
        book.setKey(number.longValue());
        return book;
    }
}
