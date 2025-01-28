package day01_linkedlist.movie_management_system;



// Class representing a node in the doubly linked list
class Movie {
    String title;       // Movie title
    String director;    // Director name
    int year;           // Year of release
    double rating;      // Movie rating
    Movie next;         // Pointer to the next movie
    Movie prev;         // Pointer to the previous movie

    // Constructor to initialize a movie node
    public Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

// Movie management system using a doubly linked list
class MovieManagementSystem {
    private Movie head; // Pointer to the first movie
    private Movie tail; // Pointer to the last movie

    // Add a movie at the beginning
    public void addMovieAtBeginning(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
        System.out.println("Movie added at the beginning: " + title);
    }

    // Add a movie at the end
    public void addMovieAtEnd(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (tail == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
        System.out.println("Movie added at the end: " + title);
    }

    // Add a movie at a specific position
    public void addMovieAtPosition(String title, String director, int year, double rating, int position) {
        if (position <= 0) {
            addMovieAtBeginning(title, director, year, rating);
            return;
        }

        Movie newMovie = new Movie(title, director, year, rating);
        Movie current = head;
        int index = 0;

        while (current != null && index < position - 1) {
            current = current.next;
            index++;
        }

        if (current == null) {
            addMovieAtEnd(title, director, year, rating);
        } else {
            newMovie.next = current.next;
            newMovie.prev = current;
            if (current.next != null) {
                current.next.prev = newMovie;
            } else {
                tail = newMovie;
            }
            current.next = newMovie;
            System.out.println("Movie added at position " + position + ": " + title);
        }
    }

    // Remove a movie by title
    public void removeMovieByTitle(String title) {
        if (head == null) {
            System.out.println("No movies in the system to remove.");
            return;
        }

        Movie current = head;

        while (current != null && !current.title.equalsIgnoreCase(title)) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Movie not found: " + title);
        } else {
            if (current.prev != null) {
                current.prev.next = current.next;
            } else {
                head = current.next;
            }

            if (current.next != null) {
                current.next.prev = current.prev;
            } else {
                tail = current.prev;
            }

            System.out.println("Movie removed: " + title);
        }
    }

    // Search for a movie by director or rating
    public void searchMovie(String director, Double rating) {
        Movie current = head;
        boolean found = false;

        while (current != null) {
            if ((director != null && current.director.equalsIgnoreCase(director)) ||
                    (rating != null && current.rating == rating)) {
                System.out.println("Found movie: " + current.title + ", Director: " + current.director +
                        ", Year: " + current.year + ", Rating: " + current.rating);
                found = true;
            }
            current = current.next;
        }

        if (!found) {
            System.out.println("No movie found matching the criteria.");
        }
    }

    // Update a movie's rating by title
    public void updateMovieRating(String title, double newRating) {
        Movie current = head;

        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                current.rating = newRating;
                System.out.println("Updated rating for " + title + " to " + newRating);
                return;
            }
            current = current.next;
        }

        System.out.println("Movie not found: " + title);
    }

    // Display all movies in forward order
    public void displayMoviesForward() {
        if (head == null) {
            System.out.println("No movies to display.");
            return;
        }

        System.out.println("Movies in forward order:");
        Movie current = head;

        while (current != null) {
            System.out.println(current.title + " (" + current.year + "), Director: " + current.director +
                    ", Rating: " + current.rating);
            current = current.next;
        }
    }

    // Display all movies in reverse order
    public void displayMoviesReverse() {
        if (tail == null) {
            System.out.println("No movies to display.");
            return;
        }

        System.out.println("Movies in reverse order:");
        Movie current = tail;

        while (current != null) {
            System.out.println(current.title + " (" + current.year + "), Director: " + current.director +
                    ", Rating: " + current.rating);
            current = current.prev;
        }
    }
}

// Main class to test the Movie Management System
public class MovieManager {
    public static void main(String[] args) {
        MovieManagementSystem mms = new MovieManagementSystem();

        // Adding movies
        mms.addMovieAtBeginning("Inception", "Christopher Nolan", 2010, 8.8);
        mms.addMovieAtEnd("The Godfather", "Francis Ford Coppola", 1972, 9.2);
        mms.addMovieAtPosition("Interstellar", "Christopher Nolan", 2014, 8.6, 1);

        // Display movies
        mms.displayMoviesForward();

        // Update a movie's rating
        mms.updateMovieRating("Inception", 9.0);

        // Search for a movie by director
        mms.searchMovie("Christopher Nolan", null);

        // Remove a movie
        mms.removeMovieByTitle("Interstellar");

        // Display movies in reverse order
        mms.displayMoviesReverse();
    }
}
