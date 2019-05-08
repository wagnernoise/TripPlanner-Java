import java.util.Scanner;
public class TripPlanner {
    public static void main(String[] args) {
        Welcome();
        Budget();
        Time();
        Distance();
    }

    public static void Welcome() {   //Starts the welcome
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the vacation planner!");
        System.out.println("What is your name?");
        String name = input.nextLine(); // Computes the person's name
        System.out.println("Nice to meet you " + name +", where are you travelling to?");
        String country = input.nextLine(); // Where to travel
        System.out.println("Great! " + country + " sounds like a great trip");
        System.out.println("****************");
        System.out.println();
    }

    public static void Budget() {
        Scanner userBudget = new Scanner(System.in);
        System.out.println("How many days are you going to spend travelling?");
        int day = userBudget.nextInt();
        System.out.println("How much money, in USD, are you planning to spend on your trip?");
        int money = userBudget.nextInt();
        System.out.println("What is the three letter currency symbol for your trip destination?");
        String currency = userBudget.next();
        System.out.println("How many " + currency + " are there in 1 USD?");
        double currencyToUSD = userBudget.nextDouble(); // Always use "," for double in the input console
        System.out.println("");
        int travelHours = day * 24; // Days to hours travelled
        int travelMinutes = day * 24 * 60; // Days to minutes travelled
        double USDperDay = money/day; // USD per day conversion
        double rate = money * currencyToUSD; // Currency conversion
        double CurrencyDaily1 = rate / day; // New currency budget per day
        int CurrencyDaily2 = (int) (CurrencyDaily1 * 100); // Converting to  an integer multiplying by 100
        double CurrencyDaily = CurrencyDaily2 / 100.0; // Reconvert to a double by dividing by 100.0 (then we get 2 digits after the comma)
        System.out.println("If you are travelling for " + day + " days that is the same as " + travelHours +  " hours or " + travelMinutes + " minutes");
        System.out.println("If you are going to spend $" + money + " USD that means per day you will spend up to $" + USDperDay + " USD");
        System.out.println("Your total budget in " + currency + " is " + rate + " " + currency + ", which per day is " + CurrencyDaily + " " + currency);
        System.out.println("****************");
        System.out.println();
    }

    public static void Time() {
        Scanner timeZone = new Scanner(System.in);
        System.out.println("What is the difference, in hours, between your home and your destination?");
        int timeDifference = timeZone.nextInt();
        int TimeMidnightDest = (24 + timeDifference) % 24;
        int TimeNoonDest = (12 + timeDifference) % 24;
        System.out.println("That means that when is midnight at home it will be " + TimeMidnightDest + ":00 in your travel destination \nand when it is noon at home it will be " + TimeNoonDest + ":00");
        System.out.println("****************");
        System.out.println();
    }

    public static void Distance() {
        Scanner userDistance = new Scanner(System.in);
        System.out.println("What is the square area of your destination country in km2?");
        int Km2 = userDistance.nextInt();
        double Km2ToMi2 = Km2 * 0.386102; // Converting to miles squared
        System.out.println("In miles2 that is " + Km2ToMi2);
        System.out.println("What is the latitude of your home?");
        double phi1 = userDistance.nextDouble();
        System.out.println("What is the longitude of your home?");
        double lambda1 = userDistance.nextDouble();
        System.out.println("What is the latitude of your destination?");
        double phi2 = userDistance.nextDouble();
        System.out.println("What is the longitude of your destination?");
        double lambda2 = userDistance.nextDouble();
        double sin1 = Math.sin((Math.toRadians(phi2) - Math.toRadians(phi1))/2); // Calculates the first sine in radians (standard in java)
        double sin2 = Math.sin((Math.toRadians(lambda2) - Math.toRadians(lambda1))/2); // Calculates the first sine in radians (standard in java)

        /* In this section, we calculate the distance between home and destination using the Harvesine formula found at:
        https://en.wikipedia.org/wiki/Haversine_formula
        As the Earth radius, we have assumed the value of 6378.1
         */

        double HomeToDest = 2 * 6378.1 * Math.asin(Math.sqrt(Math.pow(sin1, 2.0) + Math.cos(Math.toRadians(phi1))*Math.cos(Math.toRadians(phi2))*Math.pow(sin2, 2.0)));
        System.out.println("The distance from your home to your destination is " + HomeToDest + " km or " + HomeToDest * 0.621371 + " in mi.");
    }
}