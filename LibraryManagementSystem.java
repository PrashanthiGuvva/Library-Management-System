package in.puppy;
import java.util.Scanner;

    class Book {
        String title;
        String author;
        int id;

        Book(String title, String author, int id) {
            this.title = title;
            this.author = author;
            this.id = id;
        }

        void displayBook() {
            System.out.println("ID: " + id + ", Title: " + title + ", Author: " + author);
        }
    }

    public class LibraryManagementSystem {
        static final int MAX_BOOKS = 100;
        static Book[] books = new Book[MAX_BOOKS];
        static int count = 0;

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int choice;

            do {
                System.out.println("\n===== Library Menu =====");
                System.out.println("1. Add Book");
                System.out.println("2. Display All Books");
                System.out.println("3. Search Book by Title");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                sc.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        if (count < MAX_BOOKS) {
                            System.out.print("Enter book title: ");
                            String title = sc.nextLine();
                            System.out.print("Enter author name: ");
                            String author = sc.nextLine();
                            System.out.print("Enter book ID: ");
                            int id = sc.nextInt();
                            books[count++] = new Book(title, author, id);
                            System.out.println("Book added successfully.");
                        } else {
                            System.out.println("Library is full. Cannot add more books.");
                        }
                        break;

                    case 2:
                        if (count == 0) {
                            System.out.println("No books in the library.");
                        } else {
                            System.out.println("Books in the library:");
                            for (int i = 0; i < count; i++) {
                                books[i].displayBook();
                            }
                        }
                        break;

                    case 3:
                        System.out.print("Enter title to search: ");
                        String searchTitle = sc.nextLine();
                        boolean found = false;
                        for (int i = 0; i < count; i++) {
                            if (books[i].title.equalsIgnoreCase(searchTitle)) {
                                books[i].displayBook();
                                found = true;
                            }
                        }
                        if (!found) {
                            System.out.println("Book not found.");
                        }
                        break;

                    case 4:
                        System.out.println("Exiting program.");
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }
            } while (choice != 4);

            sc.close();
        }
    }
