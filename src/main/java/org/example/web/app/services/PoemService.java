package org.example.web.app.services;


import org.example.web.app.repo.abstr.ProjectRepository;
import org.example.web.app.repo.impl.PoemRepository;
import org.example.web.dto.Book;
import org.example.web.dto.Poem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoemService {

    private ProjectRepository<Poem> poemRepo;

    @Autowired
    public PoemService(PoemRepository<Poem> poemRepo) {
        this.poemRepo = poemRepo;
    }

    public List<Poem> getAllBooks(){
        return poemRepo.retreiveAll();
    }

    public void savePoem(Poem poem) {
        poemRepo.store(poem);
    }
}
