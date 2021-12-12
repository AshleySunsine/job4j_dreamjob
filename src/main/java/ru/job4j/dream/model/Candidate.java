package ru.job4j.dream.model;

import java.util.List;
import java.util.Objects;

public class Candidate {
    private String name;
    private int id;
    private List<Resume> resumeList;

    public Candidate(String name, int id, List<Resume> resumeList) {
        this.name = name;
        this.id = id;
        this.resumeList = resumeList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Resume> getResumeList() {
        return resumeList;
    }

    public void setResumeList(List<Resume> resumeList) {
        this.resumeList = resumeList;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Candidate candidate = (Candidate) o;
        return id == candidate.id && Objects.equals(name, candidate.name) && Objects.equals(resumeList, candidate.resumeList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, resumeList);
    }
}
