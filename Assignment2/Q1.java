package Assignment2;

class Book {

    private String title;
    private String author;
    private double price;

    public void setDetails(String title, String author, double price){
        this.title=title;
        this.author=author;
        this.price=price;
    }

    public void displayDetails(){
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }
}

public class Q1 {
    public static void main(String[] args){
        Book book1 = new Book();
        Book book2 = new Book();

        book1.setDetails("The Art of Thinking Clearly","Rolf Dobelli", 500.00);
        book2.setDetails("I Died Too Early","Sumithra Manda", 250.00);

        book1.displayDetails();
        System.out.println();

        book2.displayDetails();
    }
}
