package v000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DocumentManager {
    private List<Document> document;

    public DocumentManager() {
        this.document = new ArrayList<>();
    }

    public void addDocument(Document document) {
        this.document.add(document);
    }

    public void showDocuments() {
        document.forEach(document -> System.out.println(document));
    }

    public List<Document> searchForAuthor(String autor) {
        return document.stream()
                .filter(doc -> doc.getAuthors().contains(autor))
                .collect(Collectors.toList());
    }

    public List<Document> searchForKeyword(String keyword) {
        return document.stream()
                .filter(doc -> doc.getKeywords().contains(keyword))
                .collect(Collectors.toList());
    }

    public boolean deleteDocument(String title) {
        return document.removeIf(doc -> doc.getTitle().equals(title));
    }

    public List<Document> searchForTitle(String title) {
        return document.stream()
                .filter(doc -> doc.getTitle().equalsIgnoreCase(title) && doc instanceof Book)
                .collect(Collectors.toList());
    }

    public boolean updateBookForTitle(String oldTitle, Book updatedBook) {

        int bookIndex = -1;
        for (int i = 0; i < document.size(); i++) {
            Document doc = document.get(i);
            if (doc instanceof Book && doc.getTitle().equalsIgnoreCase(oldTitle)) {
                bookIndex = i;
                break;
            }
        }
    
        if (bookIndex != -1) {
            document.set(bookIndex, updatedBook);
            return true; 
        }

        return false;
    }
    
    public static void main(String[] args) {
        
        DocumentManager documentManager = new DocumentManager();

        List<String> authorsBook1 = Arrays.asList("Autor 1", "Autor 2");
        List<String> keywordsBook1 = Arrays.asList("Java", "Programación");
        Book book1 = new Book("Programando en Java", authorsBook1, 2020, keywordsBook1);
        documentManager.addDocument(book1);

        List<String> authorsBook2 = Arrays.asList("Autor 3", "Autor 4");
        List<String> keywordsBook2 = Arrays.asList("Python", "Programación");
        Book book2 = new Book("Aprendiendo Python", authorsBook2, 2021, keywordsBook2);
        documentManager.addDocument(book2);

        System.out.println("Documentos en el gestor:");
        documentManager.showDocuments();

        System.out.println("\nBuscando libros del autor 'Autor 1':");
        List<Document> results = documentManager.searchForAuthor("Autor 1");
        results.forEach(System.out::println);
    }    

}
