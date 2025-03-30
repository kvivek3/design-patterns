package com.designpattern.behavioural.templateMethod;

abstract class DataProcessor {

    //template method
    public final void process() {
        loadData();
        processData();
        saveData();
    }

    protected abstract void loadData();
    protected abstract void processData();
    protected abstract void saveData();

}
class CSVDataProcessor extends DataProcessor {

    @Override
    protected void loadData() {
        System.out.println("Loading CSV Data");
    }

    @Override
    protected void processData() {
        System.out.println("Processing CSV Data");
    }

    @Override
    protected void saveData() {
        System.out.println("Saving CSV Data");
    }
}
class XMLDataProcessor extends DataProcessor {

    @Override
    protected void loadData() {
        System.out.println("Loading XML Data");
    }

    @Override
    protected void processData() {
        System.out.println("Processing XML Data");
    }

    @Override
    protected void saveData() {
        System.out.println("Saving XML Data");
    }
}

public class TemplateMethodDemo {
    public static void main(String[] args) {
        DataProcessor csvProcessor = new CSVDataProcessor();
        DataProcessor xmlProcessor = new XMLDataProcessor();
        csvProcessor.process();
        xmlProcessor.process();
    }
}
