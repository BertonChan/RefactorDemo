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
       return price.getFrequentRentalPoints(dayRented);
    }

//    int getFrequentRentalPoints(int dayRented) {
//        if ((getPriceCode() == Movie.NEW_RELEASE) && dayRented > 1) {
//            return 2;
//        } else {
//            return 1;
//        }
//    }

    double getCharge(int daysRented) {
        return price.getCharge(daysRented);
    }


}
