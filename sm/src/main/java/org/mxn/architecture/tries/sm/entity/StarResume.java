package org.mxn.architecture.tries.sm.entity;

import java.util.List;

public class StarResume {
    private Integer id;
    private String name;

    private List<Champion> champions;

    private List<Girl> girls;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Champion> getChampions() {
        return champions;
    }

    public void setChampions(List<Champion> champions) {
        this.champions = champions;
    }

    public List<Girl> getGirls() {
        return girls;
    }

    public void setGirls(List<Girl> girls) {
        this.girls = girls;
    }

    @Override
    public String toString() {
        return "StarResume{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", champions=" + champions +
                ", girls=" + girls +
                '}';
    }
}
