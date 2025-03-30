package com.designpattern.creational.prototype;

class Document implements Cloneable {

    private String title;
    private String content;
    private String formatting;

    public Document(String title, String content, String formatting) {
        this.title = title;
        this.content = content;
        this.formatting = formatting;
    }

    @Override
    public Document clone() {
        try {
            return (Document) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone Not Supported", e);
        }
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void display() {
        System.out.println(String.format("Title: %s, Content: %s, Formatting: %s", title, content, formatting));
    }
}

public class CloneObjectDemo {
    public static void main(String[] args) {
        Document d1 = new Document("Report", "This is a report", "Bold");
        Document d2 = d1.clone();
        d2.setTitle("Report Summary");
        d1.display();
        d2.display();
    }
}
