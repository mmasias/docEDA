package v000;

import java.util.ArrayList;
import java.util.List;

public abstract class Document {
    protected String title;
    protected List<String> authors;
    protected int yearPublication;
    protected String type;
    protected List<String> keywords;

    public Document(String title, List<String> authors, int yearPublication, String type, List<String> keywords) {
        this.title = title;
        this.authors = new ArrayList<>(authors);
        this.yearPublication = yearPublication;
        this.type = type;
        this.keywords = new ArrayList<>(keywords);
    }

    public String getTitle() {
        return title;
    }

    public List<String> getAuthors() {
        return new ArrayList<>(authors);
    }

    public int getYearPublication() {
        return yearPublication;
    }

    public String getType() {
        return type;
    }

    public List<String> getKeywords() {
        return new ArrayList<>(keywords); 
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthors(List<String> authors) {
        this.authors = new ArrayList<>(authors); 
    }

    public void setYearPublication(int yearPublication) {
        this.yearPublication = yearPublication;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = new ArrayList<>(keywords);
    }

    @Override
    public String toString() {
        return "Documento {" +
                "titulo='" + title + '\'' +
                ", autores=" + authors +
                ", año de Publicacion=" + yearPublication +
                ", tipo='" + type + '\'' +
                ", palabrasClave=" + keywords +
                '}';
    }
}
