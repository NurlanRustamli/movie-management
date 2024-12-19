package labtasks;

public class Movie {
   private String name ;
   private double rating ;
    public Movie(){
        name="";
        rating=0.0;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
