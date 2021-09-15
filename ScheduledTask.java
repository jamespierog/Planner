package com.example.lib;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

public class ScheduledTask extends Task implements Schedulable {
    Duration expectedDuration;
    LocalDateTime expectedStartingTime;
    boolean scheduled;

    public ScheduledTask(String name, String description, Duration estimatedDuration, LocalDateTime deadline){
        super(name, description, estimatedDuration, deadline);
    }

    public void schedule(Duration expectedDuration, LocalDateTime expectedStartingTime){
        try {
            if (this.scheduled){
                throw new Exception("This task is already scheduled.");
            } else {
                this.expectedDuration = expectedDuration;
                this.expectedStartingTime = expectedStartingTime;
                this.scheduled = true;
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void unschedule(){
        try {
            if (!this.scheduled){
                throw new Exception("This task has been unscheduled.");
            } else {
                this.scheduled = false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Duration getExpectedDuration() {
        return expectedDuration;
    }

    public LocalDateTime getExpectedStartingTime() {
        return expectedStartingTime;
    }

    public String toString() {
        if (this.scheduled){
            return  "ScheduledTask: " + super.getName() + ", description: " + super.getDescription() + ", expectedStartingTime: " + expectedStartingTime + ", expectedDuration: " + expectedDuration + '.';
        } else {
            return super.toString();
        }

    }

    // Function to turn scheduledTask object to XML file
    public String scheduledTaskToXML(){
        return "<?xml version = \"1.0\" encoding = \"UTF-8\" ?>" + "\n"
                + "<task>" + "\n"
                + "    <name>" + getName() + "</name>" + "\n"
                + "    <description>" + getDescription() + "</description>" + "\n"
                + "    <expectedDuration>" + getExpectedDuration() + "</expectedDuration>"+ "\n"
                + "    <expectedStartingTime>" + getExpectedStartingTime() + "</expectedStartingTime>" + "\n"
                + "</task>";
    }

    public static void main(String[] args) throws IOException {
        // Creating two tasks
        System.out.println("SCHEDULING TWO TASKS:");
        ScheduledTask t1 = new ScheduledTask("Task 1", "Task 1 description", Duration.ofHours(5), LocalDateTime.of(2000, 8, 31, 7, 30));
        ScheduledTask t2 = new ScheduledTask("Task 2", "Task 2 description", Duration.ofHours(2), LocalDateTime.of(1999, 7, 30, 6, 25));
        System.out.println(t1.toString());
        System.out.println(t2.toString());
        System.out.println();

        // Scheduling two tasks
        System.out.println("SCHEDULING ONE TASK:");
        t1.schedule(Duration.ofHours(4), LocalDateTime.of(2021, 8, 31, 5,20));
        System.out.println(t1.toString());
        t2.schedule(Duration.ofHours(3), LocalDateTime.of(2020, 7, 21, 4,20));
        System.out.println(t2.toString());
        System.out.println();

        // Scheduling a task that's already scheduled
        System.out.println("SCHEDULING A TASK THAT'S ALREADY SCHEDULED:");
        t1.schedule(Duration.ofHours(4), LocalDateTime.of(2021, 8, 31, 5,20));
        System.out.println();

        // Unscheduling a task
        System.out.println("UNSCHEDULING A TASK:");
        t1.unschedule();
        System.out.println(t1.toString());
        System.out.println();

        // Unscheduling a task that has been unscheduled
        System.out.println("UNSCHEDULING A TASK THAT HAS BEEN UNSCHEDULED:");
        t1.unschedule();
        System.out.println();

        // Turn scheduledTask object to xml file
        String xmlStr = t2.scheduledTaskToXML();
        java.io.FileWriter fw = new FileWriter("scheduledTask.xml");
        fw.write(xmlStr);
        fw.close();
    }

}
