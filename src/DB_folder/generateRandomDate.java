package DB_folder;
import java.sql.Date;

public class generateRandomDate {
    public static void main(String[] args) {
        for(int i = 0; i < 36; i++){
            long startMillis = Date.valueOf("2020-01-01").getTime();
            long endMillis = Date.valueOf("2024-6-14").getTime();
            long randomMillis = startMillis + (long) (Math.random() * (endMillis - startMillis));
            System.out.println(new Date(randomMillis));
        }
    }
}
