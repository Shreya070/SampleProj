package collections;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

class MovieDetails {
    private String movieName;
    private String actor;
    private String actress;
    private String genre;
	public MovieDetails(String movieName, String actor, String actress, String genre) {
		super();
		this.movieName = movieName;
		this.actor = actor;
		this.actress = actress;
		this.genre = genre;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getActress() {
		return actress;
	}
	public void setActress(String actress) {
		this.actress = actress;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	@Override
	public String toString() {
		return "MovieDetails [movieName=" + movieName + ", actor=" + actor + ", actress=" + actress + ", genre=" + genre
				+ "]";
	}
    
}
public class Assignment3Q10 {
	static Assignment3Q10 a=new Assignment3Q10();
	public static ArrayList<MovieDetails> md = new ArrayList<MovieDetails>();
	
	public static void main(String[] args) {
		MovieDetails m1 = new MovieDetails("Titanic","Leonardo","Rose","History");
    	MovieDetails m2 = new MovieDetails("The Hobbit","Bilbo baggins","Emo","Fantasy");
    	MovieDetails m3 = new MovieDetails("Upside Down","Jim","Kristen","Fantasy");
    	MovieDetails m4 = new MovieDetails("Iron-man","Robert","Evadki tesulu","Sci-Fi");
    	MovieDetails m5 = new MovieDetails("SpiderMan","Tobey Marguire","Kristen","Fantasy");
    	MovieDetails m6 = new MovieDetails("Superbad","Jonah Hill","Emma Stone","Comedy");
    	MovieDetails m7 = new MovieDetails("Wrong Turn","Desmond","Eliza","History");
    	md.add(m1);
    	md.add(m2);
    	md.add(m3);
    	md.add(m4);
    	md.add(m5);
    	md.add(m6);
    	md.add(m7);
    
         System.out.println("All movies");
    	printSortedMovieList(md);
    	md.remove(m1);
    	md.remove(m2);
    	md.remove(m3);
    	System.out.println("after removing some movie");
    	printSortedMovieList(md);
    	md.removeAll(md);
    	System.out.println("after deletion all");
    	printSortedMovieList(md);
    	md.add(m4);
    	md.add(m5);
    	md.add(m6);
    	md.add(m7);
    	System.out.println("Adding some movies");
    	printSortedMovieList(md);
    	System.out.println("searching movie by name");
    	System.out.println(a.find_movie_By_mov_Name("Wrong Turn"));
    	System.out.println("searching movie by genre");
    	System.out.println(a.find_movie_By_Genre("Comedy"));
   	
	}

    public static void sort(ArrayList<MovieDetails> movieDetails,Comparator<MovieDetails> movieDetailsComparator){
    	md.sort(movieDetailsComparator);
    }

    public static void printSortedMovieList(ArrayList<MovieDetails> movieDetails){
    	Comparator<MovieDetails> com = new Comparator<MovieDetails>() {
            public int compare(MovieDetails a, MovieDetails b) { return a.getMovieName().compareTo(b.getMovieName());}
        };
        
        sort(movieDetails,com);
    
    	for(MovieDetails details:movieDetails) {
    		System.out.println(details);
    	}
    }
    public void addMovie(MovieDetails movie) {
    	md.add(movie);
    }

    public void removeMovies(String movieName) {
    	Iterator<MovieDetails> it = md.iterator();
    	MovieDetails rmObj = null;
    	while(it.hasNext()) {
    		rmObj = it.next();
    		String Name = rmObj.getMovieName();
    		if(Name.equals(movieName)) {
    			break; 
    		}
    	}
    	if(rmObj != null)
    	    md.remove(rmObj);
    }
    public void removeAllMovies(List<MovieDetails> movies) {
    	md.removeAll(movies);
    }
    public MovieDetails  find_movie_By_mov_Name(String movieName) {
    	Iterator<MovieDetails> it= md.iterator();
    	MovieDetails findmovie=null;
    	while(it.hasNext()) {
    		findmovie=it.next();
    		String moviename=findmovie.getMovieName();
    		if(movieName.equals(moviename)) {
    			break;
    		}
    	}
		return findmovie;
    }

    public List<MovieDetails> find_movie_By_Genre(String genre) {
    	List<MovieDetails> genreBase = new ArrayList<>();
    	Iterator<MovieDetails> it= md.iterator();
    	MovieDetails findmovie=null;
    	while(it.hasNext()) {
    		findmovie=it.next();
    		String genree=findmovie.getGenre();
    		if(genre.equals(genree)) {
    			genreBase.add(findmovie);
    		}
    	}
		return genreBase;	
    }
    public static Comparator<MovieDetails> sortAccordingly(String sortBy) {
    	 Comparator<MovieDetails> movieDetailsComparator = new Comparator<MovieDetails>() {
             @Override
             public int compare(MovieDetails o1, MovieDetails o2) {
            	 return o1.getMovieName().compareTo(sortBy);
             }
         };
         return movieDetailsComparator;
    	
    }
}