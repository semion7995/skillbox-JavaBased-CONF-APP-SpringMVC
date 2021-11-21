package org.example.web.app.repo.abstr;


import java.util.List;

public interface ProjectRepository<T> {
    List<T> retreiveAll();
    void store(T type);

    boolean removeBookByRegex(String queryRegex);
}
