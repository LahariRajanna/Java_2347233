// Superclass representing common properties of books
class Book {
    String title;
    String author;
    int publicationYear;

    // Constructor
    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    // Method to display book information
    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Publication Year: " + publicationYear);
    }
}

// Subclass representing fiction books
class FictionBook extends Book {
    // Additional properties for fiction books can be added here

    // Constructor
    public FictionBook(String title, String author, int publicationYear) {
        super(title, author, publicationYear);
    }
}

// Subclass representing non-fiction books
class NonFictionBook extends Book {
    // Additional properties for non-fiction books can be added here

    // Constructor
    public NonFictionBook(String title, String author, int publicationYear) {
        super(title, author, publicationYear);
    }
}

// Class representing the Library
class Library {
    static int totalBooks = 0;
    int booksBorrowed = 0;

    // Method to borrow a book
    public void borrowBook() {
        if (totalBooks > 0) {
            totalBooks--;
            booksBorrowed++;
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("No books available for borrowing.");
        }
    }

    // Method to return a book
    public void returnBook() {
        if (booksBorrowed > 0) {
            totalBooks++;
            booksBorrowed--;
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("No books currently borrowed.");
        }
    }
}

// Main class to test the library system
public class LibrarySystem {
    public static void main(String[] args) {
        // Create fiction and non-fiction books
        FictionBook fictionBook = new FictionBook("The Lord of the Rings", "J.R.R. Tolkien", 1954);
        NonFictionBook nonFictionBook = new NonFictionBook("The Code Book", "Simon Singh", 1999);

        // Display book information
        fictionBook.displayInfo();
        nonFictionBook.displayInfo();

        // Initialize the library
        Library library = new Library();

        // Borrow and return books
        library.borrowBook();
        library.returnBook();
        library.borrowBook();

        // Display total books and books currently borrowed
        System.out.println("Total Books: " + Library.totalBooks);
        System.out.println("Books Borrowed: " + library.booksBorrowed);
    }
}
