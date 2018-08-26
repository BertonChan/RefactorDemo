package form_template_method;

abstract class Price {
    abstract int getPriceCode();
    abstract double getCharge(int daysRented);
    int getFrequentRentalPoints(int dayRented) {
        return 1;
//        if ((getPriceCode() == Movie.NEW_RELEASE) && dayRented > 1) {
//            return 2;
//        } else {
//            return 1;
//        }
    }
//    public double getCharge(int daysRented) {
//        double result = 0;
//        switch (getPriceCode()) {
//            case Movie.REGULAR:
//                result += 2;
//                if (daysRented > 2) {
//                    result += (daysRented - 2) * 1.5;
//                }
//                break;
//            case Movie.NEW_RELEASE:
//                result += daysRented * 3;
//                break;
//            case Movie.CHILDRENS:
//                result += 1.5;
//                if (daysRented > 3) {
//                    result += (daysRented - 3) * 1.5;
//                }
//                break;
//        }
//        return result;
//    }
}

class ChildrensPrice extends Price{
    int getPriceCode(){
        return Movie.CHILDRENS;
    }
    @Override
    public double getCharge(int daysRented) {
        double result = 1.5;
        if (daysRented > 3) {
            result += (daysRented - 3) * 1.5;
        }
        return result;
    }
}

class NewReleasePrice extends Price{
    int getPriceCode() {
        return Movie.NEW_RELEASE;
    }
    @Override
    public double getCharge(int daysRented) {
        return daysRented * 3;
    }
    @Override
    int getFrequentRentalPoints(int dayRented) {
       return (dayRented>1)?2:1;
    }
}

class RegularPrice extends Price{
    int getPriceCode(){
        return Movie.REGULAR;
    }
    @Override
    public double getCharge(int daysRented) {
        double result = 2;
        if (daysRented > 2) {
            result += (daysRented - 2) * 1.5;
        }
        return result;
    }
}
