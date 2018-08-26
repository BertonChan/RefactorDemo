package form_template_method;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String title;
    //private int priceCode;
    Price price;

    public Movie(String title, int priceCode) {
        this.title = title;
        //this.priceCode = priceCode;
        setPriceCode(priceCode);
    }

    public int getPriceCode() {
//        return priceCode;
        return price.getPriceCode();
    }

    public void setPriceCode(int arg){ //int priceCode) {
        //this.priceCode = priceCode;
        switch (arg){
            case REGULAR:
                price = new RegularPrice();
                break;
            case CHILDRENS:
                price = new ChildrensPrice();
                break;
            case NEW_RELEASE:
                price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code");
        }
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

    public double getCharge(int daysRented) {
        double result = 0;
        switch (getPriceCode()) {
            case Movie.REGULAR:
                result += 2;
                if (daysRented > 2) {
                    result += (daysRented - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                result += daysRented * 3;
                break;
            case Movie.CHILDRENS:
                result += 1.5;
                if (daysRented > 3) {
                    result += (daysRented - 3) * 1.5;
                }
                break;
        }
        return result;
    }
}
