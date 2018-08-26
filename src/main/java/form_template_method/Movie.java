package form_template_method;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String title;
    private int priceCode;

    public Movie(String title, int priceCode) {
        this.title = title;
        //this.priceCode = priceCode;
        setPriceCode(priceCode);
    }

    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int priceCode) {
        this.priceCode = priceCode;
    }

    public String getTitle() {
        return title;
    }

    int getFrequentRentalPoints(int dayRented) {
        if ((getPriceCode() == Movie.NEW_RELEASE) && dayRented > 1) {
            return 2;
        } else {
            return 1;
        }
    }
}
