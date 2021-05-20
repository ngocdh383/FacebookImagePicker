package com.ngocdh.facebookimagepicker;

public class Album {
    private String title;
    private int count = 0;

    public Album(String title, int count) {
        this.title = title;
        this.count = count;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Album{" +
                "title='" + title + '\'' +
                ", count=" + count +
                '}';
    }
}
