package org.launchcode.summerbucketlist;

public class Activity {

    private int id;
    private String name;
    private Boolean completed = false;

    public Activity(int id, String name, Boolean completed) {
        this.id = id;
        this.name = name;
        this.completed = completed;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }


}
