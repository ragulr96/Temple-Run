
import java.util.Scanner;
import java.util.ArrayList;

public class TempleRun {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<competitor> competitorArray = new ArrayList<competitor>();

    public static void main(String[] args) {
        TempleRun templerun = new TempleRun();
        templerun.option_menu();
    }

    /**
     * This is method to display the main menu of the program
     */
    private void option_menu() {
        // Welcome Message
        System.out.println("			*** Welcome to Temple Run *** \n");
        // Options
        System.out.println("1.Add Competitor Details");
        System.out.println("2.View all Competitors Details");
        System.out.println("3.View Selected competitor's Details");
        System.out.println("4.View Details of Winners'");
        System.out.println("5.View Selected Winner's Details");
        System.out.println("6.Exit");
        // selecting option
        System.out.println("Select Your Option:");

        // checking whether the input is a numeric value
        while (!sc.hasNextInt()) {
            System.err.println("Please choose a numeric value");
            sc.next();
        }
        int option_input = sc.nextInt();

        switch (option_input) {
            case 1:
                // Getting the inputs from the user
                get_input();
                break;
            case 2:
                // Viewing details of all the competitor
                comp_details();
                break;
            case 3:
                // Viewing details of a selected competitor using his/her comp_num
                sel_comp_details();
                break;
            case 4:
                // Viewing Winners
                // Winners could be viewed if only there are details of competitors
                if (competitorArray.size() >= 1) {
                    highest_score();
                    max_distance();
                    max_coins();
                    option_menu();
                } else {
                    System.err.println("No details found \nReturning to Option menu");
                    option_menu();
                }
                break;
            case 5:
                // Viewing Selected winner's details
                sel_win_details();
                option_menu();
            case 6:
                // exit the program
                System.out.println("Program is quitting ");
                System.exit(0);
            default:
                System.err.println("Invalid option selection\nSelect a valid option\n");
                option_menu();
        }
    }

    /**
     * This is method for getting competitor details from user
     */
    private void get_input() {

        // Setting the limit to 20
        if (competitorArray.size() <= 20) {
            System.out.println("Enter the Competitor Number");
            // checking whether the input value is a numeric value
            while (!sc.hasNextInt()) {
                System.err.println("Please choose a numeric value");
                sc.next();
            }
            int comp_num = sc.nextInt();

            System.out.println("Enter the Competitor Name");
            String name = sc.next();

            System.out.println("Enter the Competitor Age");
            // checking whether the input value is a numeric value
            while (!sc.hasNextInt()) {
                System.err.println("Please enter a valid age value");
                sc.next();
            }
            int age = sc.nextInt();

            System.out.println("Enter the Total number of coins collected");
            // checking whether the input value is a numeric value
            while (!sc.hasNextInt()) {
                System.err.println("Please enter a Numeric value");
                sc.next();
            }
            int tot_coins = sc.nextInt();

            System.out.println("Enter the Score acheived");
            // checking whether the input value is a numeric value
            while (!sc.hasNextInt()) {
                System.err.println("Please enter a Numeric value");
                sc.next();
            }
            int score = sc.nextInt();

            System.out.println("Enter the total Distance reached");
            // checking whether the input value is a numeric value
            while (!sc.hasNextDouble()) {
                System.err.println("Please enter a Numeric value");
                sc.next();
            }
            double distance = sc.nextDouble();

            // Assigning details to the competitor method
            assigningcompetitor(comp_num, name, age, tot_coins, score, distance);
        } else {
            System.err.println("Only details of 20 competitors can be added");
        }
        // returning to menu option
        option_menu();
    }

    /**
     * This is a function which assigns details of competitor to the
     * competitorArray
     *
     * @param comp_num  || Competitor number of the competitor
     * @param name      || Name of the competitor
     * @param age       || Age of the competitor
     * @param tot_coins || Total coins Collected by the competitor
     * @param score     || Final Score achieved by the competitor
     * @param distance  || Distance reached by the competitor
     */
    private static void assigningcompetitor(int comp_num, String name, int age, int tot_coins, int score,
                                            double distance) {
        competitor competitor = new competitor();
        // set competitor details to competitor object
        competitor.setcomp_num(comp_num);
        competitor.setname(name);
        competitor.setage(age);
        competitor.settot_coins(tot_coins);
        competitor.setscore(score);
        competitor.setdistance(distance);

        // assigning competitor details to "competitorArray"
        competitorArray.add(competitor);
        System.out.println("COMPETITOR DETAILS ADDED SUCCESSFULLY \n");

    }

    /**
     * This is a method to view details of all the competitors
     */
    private void comp_details() {
        // checking whether there are any details, if not returning to menu
        // option again
        if (competitorArray.size() >= 1) {

            // Using loops to retrieve all the data stored in the competitor
            // array
            for (int i = 0; i < competitorArray.size(); i++) {

                System.out.println("Competitor Number : " + competitorArray.get(i).getcomp_num());
                System.out.println("Competitor Name : " + competitorArray.get(i).getname());
                System.out.println("Competitor age : " + competitorArray.get(i).getage());
                System.out.println("Coins collected : " + competitorArray.get(i).gettot_coins());
                System.out.println("Score achieved : " + competitorArray.get(i).getscore());
                System.out.println("Distance reached : " + competitorArray.get(i).getdistance());
                System.out.println("------------------------");
            }
        } else {
            System.err.println("No details found \nReturning to Option menu");
        }
        option_menu();
    }

    /**
     * This is a method to view details of a selected competitor
     */
    private void sel_comp_details() {
        // checking whether there are any details, if not returning to menu
        // option again
        if (competitorArray.size() >= 1) {
            // introducing a variable "comp_ID" to assign users input
            int comp_ID;
            System.out.println("Enter competitor number");
            comp_ID = sc.nextInt();

            // checking whether the user's input matches with any of the
            // competitor number
            boolean check = false;
            for (competitor c : competitorArray) {
                if (c.getcomp_num() == comp_ID) {
                    check = true;
                }
            }

            if (check) {
                for (int i = 0; i < competitorArray.size(); i++) {
                    // checking whether caom_ID and the comp_num matches
                    if (comp_ID == competitorArray.get(i).getcomp_num()) {
                        System.out.println("Competitor Number : " + competitorArray.get(i).getcomp_num());
                        System.out.println("Competitor Name : " + competitorArray.get(i).getname());
                        System.out.println("Competitor age : " + competitorArray.get(i).getage());
                        System.out.println("Coins collected : " + competitorArray.get(i).gettot_coins());
                        System.out.println("Score achieved : " + competitorArray.get(i).getscore());
                        System.out.println("Distance reached : " + competitorArray.get(i).getdistance());
                    }
                }
            } else {
                System.err.println("Invalid Competitor number entered");
            }
            System.out.println("Returning to Option Menu \n");
            option_menu();
        } else {
            System.err.println("No details found \nReturning to Option menu");
        }
        option_menu();
    }

    /**
     * This is a method to find the highest score and details of the player who
     * achieved
     */
    private void highest_score() {

        int high_score = 0;
        int h_s_index = 0;

        for (int i = 0; i < competitorArray.size(); i++) {

            // process to find the highest score and highest scorer using an if
            // statement
            if (competitorArray.get(i).getscore() > high_score) {
                high_score = competitorArray.get(i).getscore();
                h_s_index = i;
            }

        }
        System.out.println("Highest score : " + competitorArray.get(h_s_index).getscore());
        System.out.println("|*|*|* Details of Highest Scorer *|*|*|");
        System.out.println("Competitor Number : " + competitorArray.get(h_s_index).getcomp_num());
        System.out.println("Competitor Name : " + competitorArray.get(h_s_index).getname());
        System.out.println("Competitor age : " + competitorArray.get(h_s_index).getage());
        System.out.println("Coins collected : " + competitorArray.get(h_s_index).gettot_coins());
        System.out.println("Score achieved : " + competitorArray.get(h_s_index).getscore());
        System.out.println("Distance reached : " + competitorArray.get(h_s_index).getdistance());
        System.out.println("----------------------------------------------------------------------------------------");
    }

    /**
     * This is a method to find the maximum distance reached and the player who
     * achieved
     */
    private void max_distance() {

        double max_distance = 0;
        int m_d_index = 0;

        for (int i = 0; i < competitorArray.size(); i++) {

            // process to find the max distance reached and the player who
            // achieved using an if statement
            if (competitorArray.get(i).getdistance() > max_distance) {
                max_distance = competitorArray.get(i).getdistance();
                m_d_index = i;
            }
        }
        System.out.println("Maximum Distance reached : " + competitorArray.get(m_d_index).getdistance());
        System.out.println("|*|*|* Details of Competitor who reached the maximum distance *|*|*|\n");
        System.out.println("Competitor Number : " + competitorArray.get(m_d_index).getcomp_num());
        System.out.println("Competitor Name : " + competitorArray.get(m_d_index).getname());
        System.out.println("Competitor age : " + competitorArray.get(m_d_index).getage());
        System.out.println("Coins collected : " + competitorArray.get(m_d_index).gettot_coins());
        System.out.println("Score achieved : " + competitorArray.get(m_d_index).getscore());
        System.out.println("Distance reached : " + competitorArray.get(m_d_index).getdistance());
        System.out.println("----------------------------------------------------------------------------------------");

    }

    /**
     * This is a method to find the maximum coins collected and the player who
     * achieved
     */
    private void max_coins() {

        int max_coins = 0;
        int m_c_index = 0;

        for (int i = 0; i < competitorArray.size(); i++) {

            // process to find the max coins collected and the player who
            // achieved using an if statement
            if (competitorArray.get(i).gettot_coins() > max_coins) {
                max_coins = competitorArray.get(i).gettot_coins();
                m_c_index = i;
            }
        }
        System.out.println("Maximum amount of gold coins collected : " + competitorArray.get(m_c_index).gettot_coins());
        System.out.println("|*|*|* Details of Competitor who collected the maximum amount of gold coins  *|*|*|\n");
        System.out.println("Competitor Number : " + competitorArray.get(m_c_index).getcomp_num());
        System.out.println("Competitor Name : " + competitorArray.get(m_c_index).getname());
        System.out.println("Competitor age : " + competitorArray.get(m_c_index).getage());
        System.out.println("Coins collected : " + competitorArray.get(m_c_index).gettot_coins());
        System.out.println("Score achieved : " + competitorArray.get(m_c_index).getscore());
        System.out.println("Distance reached : " + competitorArray.get(m_c_index).getdistance());
        System.out.println("----------------------------------------------------------------------------------------");

    }

    /**
     * This is a method to view details of selected winners
     */
    private void sel_win_details() {

        // checking whether there are any details, if not returning to menu
        // option again
        if (competitorArray.size() >= 1) {

            // Sub menu is set for each category of awarding
            System.out.println("|*Details of Winners*|");
            System.out.println("1.Highest Scorer");
            System.out.println("2.Competitor who reached the maximum distance");
            System.out.println("3.Competitor who collected the maximum amount of gold coins");

            System.out.println("Select your option");

            // checking whether the option is a numeric value
            while (!sc.hasNextInt()) {
                System.err.println("Please choose a numeric value");
                sc.next();
            }
            int win_choice = sc.nextInt();

            switch (win_choice) {
                case 1:

                    // calling "highest_score()" method to display only the details
                    // of the competitor who won the award
                    highest_score();
                    break;
                case 2:

                    // calling "max_distance()" method to display only the details
                    // of the competitor who won the award
                    max_distance();
                    break;
                case 3:

                    // calling "max_coins()" method to display only the details of
                    // the competitor who won the award
                    max_coins();
                    break;
                default:
                    System.err.println("Invalid Option\nChoose a valid option");
                    sel_win_details();
            }
        } else {
            System.err.println("No details found \nReturning to Option menu");
            option_menu();
        }
    }

}
