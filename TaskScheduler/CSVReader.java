import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    // Static method to read events from CSV file
    public static List<Event> readEventsFromCSV(String filename) throws IOException {
        List<Event> events = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 4) {
                    String name = parts[0];
                    String startTime = parts[1];
                    String endTime = parts[2];
                    String type = parts[3];
                    events.add(new Event(name, startTime, endTime, type));
                }
            }
        }
        return events;
    }
}
