package ru.job4j.tracker;

public class Item {
    public String id;
    public String name;
    public String desc;
    public long created;
    public String[] comments;

    public Item() {

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public long getCreated() {
        return created;
    }

    public String[] getComments() {
        return comments;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) { this.name = name; }
    public void setDesc(String desc) { this.desc = desc; };
}
