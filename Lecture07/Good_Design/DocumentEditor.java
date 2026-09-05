package Lecture07.Good_Design;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

interface DocumentElement{
    public String render();
}

class TextElement implements DocumentElement{
    private String text;
    public TextElement(String text){
        this.text=text;
    }
    @Override
    public String render(){
        return text;
    }
}
class ImageElement implements DocumentElement{
    private String imagePath;
    public ImageElement(String imagePath){
        this.imagePath=imagePath;
    }
    @Override
    public String render(){
       return "[Image: "+imagePath+"]";
    }
}
class TabElement implements DocumentElement{
    @Override
    public String render(){
        return "\t";
    }
}
class NewLineElement implements DocumentElement{
    @Override
    public String render(){
        return "\n";
    }
}
class Document {
    private List<DocumentElement> elements=new ArrayList<>();
    
    public void addElement(DocumentElement element){
        elements.add(element);
    }
    
    public String renderDocument() {
        StringBuilder result = new StringBuilder();
        for(DocumentElement element:elements){
            result.append(element.render().toString());
        }
        return result.toString();
    }
}
interface PersistenceManager{
    public void save(String content);
}
class FilePersistenceManager implements PersistenceManager{
    @Override
    public void save(String content){
        try{
            FileWriter writer = new FileWriter("document.txt");
            writer.write(content);
            writer.close();
            System.out.println("Document saved to document.txt");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

class  DbPersistenceManager implements PersistenceManager{
    @Override
    public void save(String content){
        System.out.println("Document saved to database");
    }
}
class DocumentService{
    private Document document;
    private PersistenceManager persistenceManager;
    private String renderdContent="";
    public DocumentService(Document document,PersistenceManager persistenceManager){
        this.document=document;
        this.persistenceManager=persistenceManager;
    }
    public void addText(String textString){
        document.addElement(new TextElement(textString));
    }
    public void addImage(String imagePath){
        document.addElement(new ImageElement(imagePath));
    }
    public void addSpace(){
        document.addElement(new TabElement());
    }
    public void addNewLine(){
        document.addElement(new NewLineElement());
    }

    public String renderDocument(){
        if(renderdContent.isEmpty()){
            renderdContent=document.renderDocument();
        }
        return renderdContent;
    }
    public void saveDocument(){
        persistenceManager.save((renderDocument()));
    }
}
public class DocumentEditor {
    public static void main(String[] args){
            DocumentService documentService=new DocumentService(new Document(),new FilePersistenceManager());
            documentService.addText("This is a sample document.");
            documentService.addImage("image1.jpg");
            documentService.addNewLine();
            documentService.addText("This is another paragraph.");
            documentService.saveDocument();
            documentService.renderDocument();

    }
}
