package org.example.motivation.entity;

public class Motivation {
    int id;
    String content;
    String source;

    public Motivation(int id, String content, String source) {
        this.id = id;
        this.content = content;
        this.source = source;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "Motivation{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", source='" + source + '\'' +
                '}';
    }
}
