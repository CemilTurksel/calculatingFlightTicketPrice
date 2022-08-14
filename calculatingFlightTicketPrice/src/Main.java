import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int km, age, tripType;
        double perKm = 0.10, normalPrice = 0, discountedPrice, ageDiscount,totalPrice = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter distance as km: ");
        km = scanner.nextInt();
        System.out.println("Enter your age: ");
        age = scanner.nextInt();
        System.out.println("Enter your trip type(1 -> One direction, 2 -> Round-trip)");
        tripType = scanner.nextInt();

        normalPrice = km * perKm;
        double twelveDis = normalPrice - (normalPrice / 2);
        double twelveTwentyFourDis = (normalPrice / 100) * 10;
        double bigger65Dis = (normalPrice / 100) * 30;
        double roundTripDis = (normalPrice / 100) * 20;

        if (km > 0 && age > 0 && (tripType == 1 || tripType == 2)) {

            if (age < 12){
                totalPrice = normalPrice - twelveDis;
                if (tripType == 2){
                    totalPrice = (normalPrice - twelveDis - roundTripDis) * 2;
                }else{
                    totalPrice = normalPrice - twelveDis;
                }
            }
            else if (age > 12 && age < 24){
                totalPrice = normalPrice - twelveTwentyFourDis;
                if(tripType == 2){
                    totalPrice = (normalPrice - twelveTwentyFourDis - roundTripDis) * 2;
                }else{
                    totalPrice = normalPrice - twelveTwentyFourDis;
                }
            }
            else if(age > 65){
                totalPrice = normalPrice - bigger65Dis;
                if(tripType == 2){
                    totalPrice = (normalPrice - bigger65Dis - roundTripDis) * 2;
                }else{
                    totalPrice = normalPrice - bigger65Dis;
                }
            }
            else{
                totalPrice = normalPrice;
                if(tripType == 2){
                    totalPrice = (normalPrice - roundTripDis) * 2;
                }
            }
            System.out.println("Total price is: " + totalPrice);
        }else {
            System.out.println("Wrong entry, please make sure that informations that entered are in a valid form.");
        }
    }
}
