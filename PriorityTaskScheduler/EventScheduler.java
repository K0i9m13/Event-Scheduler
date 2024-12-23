public class EventScheduler {
    private LinkedBinarySearchTree<Event> eventBST;
    private ArrayPriorityQueue<Event> eventPriorityQueue;

    public EventScheduler() {
        eventBST = new LinkedBinarySearchTree<>();
        eventPriorityQueue = new ArrayPriorityQueue<>();
    }

    public void addEvent(Event event) {
        eventBST.insert(event);
        eventPriorityQueue.insert(event);
    }

    public void cancelNonUrgentEvents() {
        ArrayPriorityQueue<Event> tempQueue = new ArrayPriorityQueue<>();
    
        while (!eventPriorityQueue.isEmpty()) {
            Event currentEvent = eventPriorityQueue.removeMax();
            boolean shouldInsert = true;
    
            for (Event existingEvent : tempQueue.toArray(new Event[tempQueue.size()])) {
                if (existingEvent != null && existingEvent.getPriority().equals("urgent")) {
                    if (doEventsOverlap(existingEvent, currentEvent)) {
                       
                        shouldInsert = false;
                        break;
                    }
                }
            }
    
            for (Event earlierEvent : eventPriorityQueue.toArray(new Event[eventPriorityQueue.size()])) {
                if (earlierEvent != null && earlierEvent.getPriority().equals("urgent")) {
                    if (doEventsOverlap(earlierEvent, currentEvent)) {
                        shouldInsert = false;
                        break;
                    }
                }
            }
    
            if (shouldInsert) {
                tempQueue.insert(currentEvent);
            }
        }
    
        eventPriorityQueue = tempQueue;
    }
    
    private boolean doEventsOverlap(Event event1, Event event2) {
        int startTime1 = convertToMinutes(event1.getStartTime());
        int endTime1 = convertToMinutes(event1.getEndTime());
        int startTime2 = convertToMinutes(event2.getStartTime());
        int endTime2 = convertToMinutes(event2.getEndTime());
    
        return (startTime1 < endTime2 && startTime2 < endTime1);
    }
    private int convertToMinutes(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }

    public String listEvents() {
        StringBuilder sb = new StringBuilder();

        sb.append("Events in Order:\n");
        sb.append(eventBST.toStringInOrder()).append("\n");

        sb.append("Events after reorganizing:\n");
        Event[] eventsArray = eventPriorityQueue.toArray(new Event[eventPriorityQueue.size()]);
        for (Event event : eventsArray) {
            sb.append(event).append("\n");
        }

        return sb.toString();
    }
}