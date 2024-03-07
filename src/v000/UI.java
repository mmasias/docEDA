package v000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UI {
    private final DocumentManager documentManager;
    private final Scanner scanner;

    public UI() {
        this.documentManager = new DocumentManager();
        this.scanner = new Scanner(System.in);
    }

    public void showMainMenu() {
        boolean isWorking = true;
        while (isWorking) {
            System.out.println("\nBiblioteca Digital");
            System.out.println("1. Gestionar Libros");
            System.out.println("2. Buscar Libros");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            int userOption = scanner.nextInt();
            scanner.nextLine();

            switch (userOption) {
                case 1:
                    manageBooks();
                    break;
                case 2:
                    searchBooks();
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    isWorking = !isWorking;
                    default:
                    System.out.println("Opción no válida, por favor intente de nuevo.");
                }
            }
    }

    private void manageBooks() {
        boolean isWorking = true;
        while (isWorking) {
            System.out.println("\nGestión de Libros");
            System.out.println("1. Agregar Libro");
            System.out.println("2. Mostrar Todos los Libros");
            System.out.println("3. Buscar y Mostrar Libro por Título");
            System.out.println("4. Actualizar Libro por Título");
            System.out.println("5. Eliminar Libro por Título");
            System.out.println("6. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");

            int userOption = scanner.nextInt();
            scanner.nextLine();

            switch (userOption) {
                case 1:
                    addBook();
                    break;
                case 2:
                    showBooks();
                    break;
                case 3:
                    showByTitle();
                    break;
                case 4:
                    updateByTitle();
                    break;
                case 5:
                    deleteByTitle();
                    break;
                case 6:
                    isWorking = !isWorking;
                    break;
                default:
                System.out.println("Opción no válida, por favor intente de nuevo.");
            }
        }
    }

    private void addBook() {
        
        System.out.print("Ingrese título del libro: ");
        String title = scanner.nextLine();
        
        System.out.print("Ingrese año de publicación: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        
        List<String> authors = new ArrayList<>();
        System.out.print("Ingrese autores (separados por coma): ");
        String[] authorsArray = scanner.nextLine().split(",");
        for (String author : authorsArray) {
            authors.add(author.trim());
        }

        List<String> keywords = new ArrayList<>();
        System.out.print("Ingrese palabras clave (separadas por coma): ");
        String[] keywordsArray = scanner.nextLine().split(",");
        for (String word : keywordsArray) {
            keywords.add(word.trim());
        }

        Book newBook = new Book(title, authors, year, keywords);
        documentManager.addDocument(newBook);

        System.out.println("Libro agregado exitosamente.");
    }

    private void showBooks() {
        System.out.println("Lista de todos los libros:");
        documentManager.showDocuments();
    }

    private void showByTitle() {
        System.out.print("Ingrese el título del libro a buscar: ");
        String title = scanner.nextLine();

        List<Document> results = documentManager.searchForTitle(title);

        if (!results.isEmpty()) {
            System.out.println("Libro(s) encontrado(s):");
            results.forEach(System.out::println);
        } else {
            System.out.println("No se encontró un libro con ese título.");
        }
    }

    private void updateByTitle() {
        System.out.print("Ingrese el título del libro a actualizar: ");
        String oldTitle = scanner.nextLine();

        System.out.print("Ingrese el nuevo título del libro: ");
        String newTitle = scanner.nextLine();
        
        System.out.print("Ingrese el nuevo año de publicación: ");
        int newYear = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Ingrese los nuevos autores (separados por coma): ");
        List<String> newAuthors = Arrays.asList(scanner.nextLine().split(","));
        
        System.out.print("Ingrese las nuevas palabras clave (separadas por coma): ");
        List<String> newKeywords = Arrays.asList(scanner.nextLine().split(","));

        Book updatedBook = new Book(newTitle, newAuthors, newYear, newKeywords);

        if (documentManager.updateBookForTitle(oldTitle, updatedBook)) {
            System.out.println("Libro actualizado exitosamente.");
        } else {
            System.out.println("No se encontró un libro con el título proporcionado para actualizar.");
        }
    }

    private void deleteByTitle() {
        System.out.print("Ingrese el título del libro a eliminar: ");
        String title = scanner.nextLine();
        if (documentManager.deleteDocument(title)) {
            System.out.println("Libro eliminado exitosamente.");
        } else {
            System.out.println("No se encontró un libro con ese título.");
        }
    }

    private void searchBooks() {
        System.out.println("Buscar Libros");
        System.out.println("1. Por Autor");
        System.out.println("2. Por Palabra Clave");
        System.out.print("Seleccione una opción de búsqueda: ");

        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                searchByAuthor();
                break;
            case 2:
                searchByKeyword();
                break;
            default:
                System.out.println("Opción no válida, por favor intente de nuevo.");
        }
    }

    private void searchByAuthor() {
        System.out.print("Ingrese el nombre del autor: ");
        String author = scanner.nextLine();
        List<Document> answers = documentManager.searchForAuthor(author);
        answers.forEach(System.out::println);
    }

    private void searchByKeyword() {
        System.out.print("Ingrese la palabra clave: ");
        String keywords = scanner.nextLine();
        List<Document> results = documentManager.searchForKeyword(keywords);
        results.forEach(System.out::println);
    }

}
