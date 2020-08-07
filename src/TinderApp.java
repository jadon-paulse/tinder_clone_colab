import java.util.*;

public class TinderApp {
    public static void main(String[] args) {
        System.out.println("Welcome To Tinder!\n");

        Scanner sc = new Scanner(System.in);
        
        System.out.println("Please enter your preference. f for female, m for male, n for no preference");
        String preference = sc.nextLine();

        System.out.println("We will be showing your chosen preference: " + preference);

        TinderSwipe ts = new TinderSwipe();

        ArrayList<Profile> displayProfiles = ts.getProfilesByPreference(preference);

        Iterator<Profile> iterator = displayProfiles.iterator();

        String userInput;
        while(iterator.hasNext()) {
            Profile nextProfile = iterator.next();
            System.out.println(nextProfile);
            System.out.print("\nSwipe (r) right or (l) left. Press q to quit app\n");
            userInput = sc.nextLine();
            if(userInput.toUpperCase().equals("R")) {
                System.out.println("You swiped right\n");
                ts.submitProfileToDB(nextProfile);
            }

            if(userInput.toUpperCase().equals("L")) {
                System.out.println("You swiped left\n");
            }

            if(userInput.toUpperCase().equals("Q")) {
                System.out.println("\nThank you Tinder. Hope you enjoyed the experience");
                break;
            }
        }

        System.out.println("\nNo more potential matches.");
        ts.closeConnectionToDB();
    }
}
