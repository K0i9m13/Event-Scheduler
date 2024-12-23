public class Event implements Comparable<Event>{
    private String date;
    private String name;
    private String startTime;
    private String endTime;
    private String priority;

    public Event(String date, String name, String startTime, String endTime, String priority) {
        this.date = date;
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.priority = priority;
    }

    public String getDate(){
        return date;
    }

    public String getName() {
        return name;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getPriority() {
        return priority;
    }

  public String toString() {
        return 
                "{" + name + " " + startTime + "->" + endTime + "}";
    }

    public int compareTo(Event otherEvent) {
        return this.startTime.compareTo(otherEvent.startTime);
    }

}