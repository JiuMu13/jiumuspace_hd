package org.example.jiumuspace.entity;

public class IndexList {
    private String name;
    private Index2[] children;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Index2[] getChildren() {
        return children;
    }

    public void setChildren(Index2[] children) {
        this.children = children;
    }
}
