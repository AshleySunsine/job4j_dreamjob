package ru.job4j.dream.model;

import java.util.List;
import java.util.Objects;

public class HRofficer {
    private String name;
    private int id;
    private List<Vacancy> vacancyList;

    public HRofficer(String name, int id, List<Vacancy> vacancyList) {
        this.name = name;
        this.id = id;
        this.vacancyList = vacancyList;
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

    public List<Vacancy> getVacancyList() {
        return vacancyList;
    }

    public void setVacancyList(List<Vacancy> vacancyList) {
        this.vacancyList = vacancyList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        HRofficer hRofficer = (HRofficer) o;
        return id == hRofficer.id && Objects.equals(name, hRofficer.name) && Objects.equals(vacancyList, hRofficer.vacancyList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, vacancyList);
    }
}
