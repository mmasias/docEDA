package v000;

import java.util.Arrays;
import java.util.List;

class Book extends Document {
    public Book(String title, List<String> authors, int yearPublication, List<String> keywords) {
        super(title, authors, yearPublication, "Libro", keywords);
    }
    public static void main(String[] args) {
        
        List<String> authors = Arrays.asList("Autor 1", "Autor 2");
        List<String> keywords = Arrays.asList("PalabraClave1", "PalabraClave2");
        Book book = new Book("Título del Libro", authors, 2021, keywords);
        System.out.println(book.toString());

    }    
}

