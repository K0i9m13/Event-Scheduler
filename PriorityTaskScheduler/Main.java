public class Main {
    public static void main(String[] args) {
        // Create an instance of the EventScheduler
        EventScheduler eventScheduler = new EventScheduler();

        // Adding sample events
        eventScheduler.addEvent(new Event("2024-04-25", "Rizz meeting", "10:00", "11:30", "urgent"));
        eventScheduler.addEvent(new Event("2024-04-25", "Lunch", "11:20", "12:30", "leisure"));
        eventScheduler.addEvent(new Event("2024-04-25", "Lunch", "11:45", "12:30", "leisure"));

        eventScheduler.cancelNonUrgentEvents();

        // List all events
        System.out.println("All Events:");
        System.out.println(eventScheduler.listEvents());
    }
}