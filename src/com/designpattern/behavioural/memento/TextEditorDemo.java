package com.designpattern.behavioural.memento;

import java.util.ArrayList;
import java.util.List;

class TextEditorMemento {
    private final String text;

    TextEditorMemento(String text) {
        this.text = text;
    }
    public String getText() {
        return text;
    }
}
class TextEditor {

    private String text;


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public TextEditorMemento save() {
        return new TextEditorMemento(text);
    }

    public void restore(TextEditorMemento textEditorMemento) {
        this.text = textEditorMemento.getText();
    }
}

class Caretaker {
    private List<TextEditorMemento> mementos = new ArrayList<>();

    public void addMemento(TextEditorMemento memento) {
        mementos.add(memento);
    }
    public TextEditorMemento getMemento(int index) {
        return mementos.get(index);
    }
}

public class TextEditorDemo {

    public static void main(String[] args) {

        TextEditor textEditor = new TextEditor();
        Caretaker caretaker = new Caretaker();
        textEditor.setText("version 1");
        caretaker.addMemento(textEditor.save());

        textEditor.setText("version 2");
        caretaker.addMemento(textEditor.save());

        textEditor.setText("version 3");
        caretaker.addMemento(textEditor.save());

        System.out.println(textEditor.getText());

        textEditor.restore(caretaker.getMemento(1));
        System.out.println(textEditor.getText());

        textEditor.restore(caretaker.getMemento(0));
        System.out.println(textEditor.getText());
    }
}
