package org.example.web.app.services;

import org.apache.log4j.Logger;
import org.example.web.app.repo.impl.BookRepository;
import org.example.web.app.repo.abstr.ProjectRepository;
import org.example.web.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {

    private final ProjectRepository<Book> bookRepo;
    private final Logger logger = Logger.getLogger(BookService.class);


    @Autowired
    public BookService(BookRepository<Book> bookRepo) {
        this.bookRepo = bookRepo;
    }


    public List<Book> getAllBooks(){
        return bookRepo.retreiveAll();
    }

    public void saveBook(Book book) {
        bookRepo.store(book);
    }


    public boolean removeBookByRegex(String queryRegex) {
        return bookRepo.removeBookByRegex(queryRegex);
    }

    public boolean removeItemById(String bookIdToRemove){
        return bookRepo.removeItemById(bookIdToRemove);
    }



    private void defaultInit(){
        logger.info("default INIT in book service");
    }

    private void defaultDestroy(){
        logger.info("default DESTROY book service");
    }

}
