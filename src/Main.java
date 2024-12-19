import labtasks.Movie;

import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 3;
        int addNumber = 0;
        boolean existance =false;
        Movie[] movies = new Movie[n];


        while (true) {
            System.out.println("Menu");
            System.out.println("1.Enter Movie");
            System.out.println("2.Display Movies");
            System.out.println("3.Input More Movies");
            System.out.println("4.Find Statistics");
            System.out.println("5.Search For Movie");
            System.out.println("6.Update Movie Ratings");
            System.out.println("7.Delete Movie");
            System.out.println("8.Sort Movies");
            System.out.println("0.Exit");
            System.out.println("Firstly,press 1 and enter 3 movies");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                for (int i = 0; i < movies.length; i++) {
                    movies[i] = new Movie();
                }
                System.out.println("Enter First Movie Name");
                movies[0].setName(sc.nextLine());
                System.out.println("Enter First Movie Rating");
                movies[0].setRating(sc.nextDouble());
                sc.nextLine();

                System.out.println("Enter Second Movie Name");
                movies[1].setName(sc.nextLine());
                System.out.println("Enter Second Movie Rating");
                movies[1].setRating(sc.nextDouble());
                sc.nextLine();


                System.out.println("Enter Third Movie Name");
                movies[2].setName(sc.nextLine());
                System.out.println("Enter Third Movie Rating");
                movies[2].setRating(sc.nextDouble());
                sc.nextLine();

                System.out.println("Movies Entered Successfully!");
            }
            if (choice == 2) {
                if (movies[0] == null) {
                    System.out.println("There is no book");
                    continue;
                }
                for (int i = 0; i < movies.length; i++) {
                    System.out.println("Movie Name");
                    System.out.println(movies[i].getName());
                    System.out.println("Movie Rating");
                    System.out.println(movies[i].getRating());
                }
            }
            if (choice == 3) {
                System.out.println("Write The Number Of Additional Books Which You Want To Add");
                n+=addNumber;
                addNumber = sc.nextInt();
                sc.nextLine();
                movies = Arrays.copyOf(movies, n + addNumber);
                for (int i = 0; i < addNumber; i++) {
                    movies[n + i] = new Movie();
                    System.out.println("New Book Name");
                    movies[n + i].setName(sc.nextLine());
                    System.out.println("New Book Rating");
                    movies[n + i].setRating(sc.nextDouble());
                    sc.nextLine();
                }
            }

            if (choice == 4) {
                double sumRating=0;
                String movieWithMax= "";
                double movieMaxRating= movies[0] != null ? movies[0].getRating() : 0;
                double movieMinRating= movies[0] != null ? movies[0].getRating() : 0;
                String movieWithMin="";
                for (int i = 0; i < movies.length; i++) {
                    assert movies[i] != null;
                    sumRating+=movies[i].getRating();
                    if (movies[i].getRating()>=movieMaxRating ) {
                        movieWithMax=movies[i].getName();
                        movieMaxRating = movies[i].getRating();
                    } if (movies[i].getRating()<=movieMinRating ) {
                        movieWithMin=movies[i].getName();
                        movieMinRating = movies[i].getRating();
                    }
                }
                System.out.println("Average Rating "+(sumRating/ movies.length));
                System.out.println("Movie with Maximum Rating "+movieWithMax);
                System.out.println("Movie with Minimum Rating "+movieWithMin);

            }
            if (choice == 5) {
                System.out.println("Enter film name which you want search");
                String searchInput = sc.nextLine();
                if (movies[0] == null) {
                    System.out.println("There is no book");
                    continue;
                }
                for (Movie movie : movies) {
                    if (searchInput.equals(movie != null ? movie.getName() : "")) {
                        System.out.println("Searching movie rating: " + movie.getRating());
                        existance=!existance;

                    }
                }
                if (!existance) {
                    System.out.println("Movie Not Found");
                }
            }
            if (choice == 6) {
                System.out.println("Enter film name which you want to update rating");
                String searchInput = sc.nextLine();
                if (movies[0] == null) {
                    System.out.println("There is no book");
                    continue;
                }
                for (Movie movie : movies) {
                    if (searchInput.equals(movie != null ? movie.getName() : "")) {
                        double newRating=sc.nextDouble();
                        movie.setRating(newRating);
                        System.out.println("After updating movie rating: " + movie.getRating());
                        existance= true;

                    }
                }
                if (!existance) {
                    System.out.println("Movie Not Found");
                }
            }

            if (choice == 7) {
                int j = 0;
                System.out.println("Enter film name which you want  to delete");
                String searchInput = sc.nextLine();
                Movie deletedMovie = new Movie();
                Movie[] newMovies = new Movie[movies.length - 1];
                if (movies[0] == null) {
                    System.out.println("There is no book");
                    continue;
                }
                for (int i = 0; i < movies.length; i++) {
                    if (searchInput.equals(movies[i] != null ? movies[i].getName() : "")) {
                        deletedMovie=movies[i];
                    }else{
                        existance=true;
                    }
                    if (!deletedMovie.equals(movies[i])) {
                        newMovies[j]=movies[i];
                        j++;

                    }
                }
                movies = newMovies;
                for (Movie movie : movies) {
                    System.out.println("Movie Name");
                    System.out.println(movie.getName());
                    System.out.println("Movie Rating");
                    System.out.println(movie.getRating());
                }
                System.out.println("Movie deleted successfully.");
                if (!existance) {
                    System.out.println("Movie Not Found");
                }
            }
            if (choice == 8) {
                if (movies[0] == null) {
                    System.out.println("There is no book");
                    continue;
                }
                double[] movieRatings = new double[n+addNumber];
                for (int i = 0; i < movies.length; i++) {
                    movieRatings[i]=movies[i].getRating();
                }
                bubbleSort(movies,movieRatings.length);
                for (Movie movie : movies) {
                    System.out.println("Movie Name");
                    System.out.println(movie.getName());
                    System.out.println("Movie Rating");
                    System.out.println(movie.getRating());
                }
            }
            if (choice == 0) {
                break;
            }
        }

    }
    static void bubbleSort(Movie[] movies, int n){
        int i, j;
        Movie temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (movies[j].getRating() > movies[j + 1].getRating()) {

                    // Swap arr[j] and arr[j+1]
                    temp = movies[j];
                    movies[j] = movies[j + 1];
                    movies[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no two elements were
            // swapped by inner loop, then break
            if (!swapped)
                break;
        }
    }
}