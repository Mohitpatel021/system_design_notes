package Lecture07.Bad_Design;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

class Document {
    List<String>elements=new ArrayList<>();
    String renderedContent="";

    public void addText(String text){
        elements.add(text);
    }
    public void addImage(String imagePath){
        elements.add(imagePath);
    }
   public void saveToFile(){
       try{
                FileWriter writer = new FileWriter("document.txt");
                writer.write(renderDocument());
                writer.close();
                System.out.println("Document saved to document.txt");
       }catch(Exception e){
           e.printStackTrace();
       }
    }
    public String renderDocument() {
        if (renderedContent.isEmpty()) {
            StringBuilder result = new StringBuilder();
            for (String element : elements) {
                if (element.length() > 4 && 
                   (element.endsWith(".jpg") || element.endsWith(".png"))) {
                    result.append("[Image: ").append(element).append("]\n");
                } else {
                    result.append(element).append("\n");
                }
            }
            renderedContent = result.toString();
        }
        return renderedContent;
    }
}

public class DocumentEditor {
    public static void main(String[] args){
        Document document = new Document();
        document.addText("This is a sample document.");
        document.addImage("image1.jpg");
        document.addText("This is another paragraph.");
        document.saveToFile();
        document.renderDocument();
    }
}
