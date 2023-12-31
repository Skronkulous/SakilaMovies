package com.pluralsight;

import java.sql.SQLException;
import static com.pluralsight.MainApp.*;

public class DataManager {
    public static void searchDB() throws SQLException {
        try{
            String query;
            int temp = 1;
            System.out.print("\nPlease enter the last name of an actor you like (Ex: DiCaprio): ");
            String nameChoice = scan.nextLine().trim();
            query = "SELECT a.first_name, a.last_name FROM actor AS a WHERE a.last_name = \"" + nameChoice + "\"ORDER BY a.first_name";
            prepState = conn.prepareStatement(query);
            rSet = prepState.executeQuery();
            System.out.println("\nList of all actors with the last name '" + nameChoice + "': ");
            while(rSet.next()){
                String actorName = temp + ") " + rSet.getString("first_name") + " " + rSet.getString("last_name");
                System.out.println(actorName);
                temp++;
            }
            temp = 0;
            System.out.print("\nPlease enter the first AND last name of the actor you would like to view movies from: (Ex: Brad Pitt): ");
            nameChoice = scan.nextLine().trim();
            String[] nameSplit = nameChoice.split(" ");
            query = "SELECT f.title, f.description " +
                    "FROM film AS f INNER JOIN film_actor AS fa ON fa.film_id = f.film_id " +
                    "INNER JOIN actor AS a ON a.actor_id = fa.actor_id " +
                    "WHERE a.first_name = \"" + nameSplit[0] + "\" AND a.last_name = \"" + nameSplit[1] +
                    "\" ORDER BY title";
            prepState = conn.prepareStatement(query);
            rSet = prepState.executeQuery();
            System.out.println("\nList of all movies starring '" + nameChoice + "': ");
            while(rSet.next()){
                String movieInfo = temp + ") " + rSet.getString("title") + " - Description: " + rSet.getString("description");
                System.out.println(movieInfo);
                temp++;
            }
        }
        catch(Exception searchError){
            System.out.println("SEARCH ERROR");
            searchError.printStackTrace();
        }
        finally{
            conn.close();
            rSet.close();
            prepState.close();
            scan.close();
        }
    }
}
