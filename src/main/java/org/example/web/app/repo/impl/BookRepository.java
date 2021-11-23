package org.example.web.app.repo.impl;

import org.apache.log4j.Logger;
import org.example.web.app.repo.abstr.ProjectRepository;
import org.example.web.app.services.IdProvider;
import org.example.web.dto.Book;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository<T> implements ProjectRepository<Book>, ApplicationContextAware {

    private final Logger logger = Logger.getLogger(BookRepository.class);
    private final List<Book> repo = new ArrayList<>();
    private boolean flag = false;
    private ApplicationContext context;


    @Override
    public List<Book> retreiveAll() {
        return new ArrayList<>(repo);
    }

    @Override
    public void store(Book book) {

        if (!book.getAuthor().isEmpty() || !book.getTitle().isEmpty() || book.getSize() != null) {
            book.setId(context.getBean(IdProvider.class).providerId(book));
            logger.info("store new book: " + book);
            repo.add(book);
        }
    }

    @Override
    public boolean removeItemById(String bookIdToRemove) {
        for (Book book : retreiveAll()) {
            if (book.getId().equals(bookIdToRemove)) {
                logger.info("remove book completed: " + book);
                return repo.remove(book);
            }
        }
        return false;
    }


    @Override
    public boolean removeBookByRegex(String queryRegex) {

        for (Book book :retreiveAll()) {
            if (queryRegex instanceof String){
                if (book.getTitle().equals(queryRegex)){
                    logger.info("remove a book: " + book);
                    flag = repo.remove(book);
                }
                if (book.getAuthor().equals(queryRegex)){
                    logger.info("remove a book: " + book);
                    flag = repo.remove(book);
                }
                if (book.getId().equals(queryRegex)){
                    logger.info("remove a book: " + book);
                    flag = repo.remove(book);
                }
            }
            else {
                try {
                    int number = Integer.parseInt(queryRegex);
                    if (book.getSize().equals(number)){
                        logger.info("remove a book: " + book);
                        flag = repo.remove(book);
                    }
                } catch (NumberFormatException ex){
                    ex.printStackTrace();
                }
            }
        }
        return flag;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    private void defaultInit(){
        logger.info("default INIT in book repo bean");
    }

    private void defaultDestroy(){
        logger.info("default DESTROY in book repo bean");
    }

}
