package org.example.web.app.repo.impl;

import org.apache.log4j.Logger;
import org.example.web.app.repo.abstr.ProjectRepository;
import org.example.web.dto.Poem;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PoemRepository<T> implements ProjectRepository<Poem> {

    private final Logger logger = Logger.getLogger(BookRepository.class);
    private final List<Poem> repo = new ArrayList<>();

    @Override
    public List<Poem> retreiveAll() {
        return new ArrayList<>(repo);
    }


    @Override
    public void store(Poem poem) {

         poem.setId(poem.hashCode());
            logger.info("store new poem: " + poem);
            repo.add(poem);

    }



    @Override
    public boolean removeBookByRegex(String queryRegex) {
        return false;
    }


}
