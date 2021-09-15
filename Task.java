package com.example.lib;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

public class Task {
    String name;
    String description;
    Duration estimatedDuration;
    LocalDateTime deadline;

    public Task(String name, String description, Duration estimatedDuration, LocalDateTime deadline) {
        this.name = name;
        this.description = description;
        this.estimatedDuration = estimatedDuration;
        this.deadline = deadline;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Duration getEstimatedDuration() {
        return estimatedDuration;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public String toString() {
        return  "Task: " + name + ", description: " + description + ", estimatedDuration: " + estimatedDuration + ", deadline: " + deadline + '.';
    }

    // Function to convert task object to XML
    public String taskToXML(){
        return "<?xml version = \"1.0\" encoding = \"UTF-8\" ?>" + "\n"
                + "<task>" + "\n"
                + "    <name>" + getName() + "</name>" + "\n"
                + "    <description>" + getDescription() + "</description>" + "\n"
                + "    <duration>" + getEstimatedDuration() + "</duration>"+ "\n"
                + "    <deadline>" + getDeadline() + "</deadline>" + "\n"
                + "</task>";
    }

    public static void main(String[] args) throws IOException {
        //Sample task
        Task t1 = new Task("Task 1", "Task 1 description", Duration.ofHours(5), LocalDateTime.of(2000, 8, 31, 7, 30));
//        System.out.println(t1.toString());

        // Turn Task object to xml file
        String xmlStr = t1.taskToXML();
        java.io.FileWriter fw = new FileWriter("task.xml");
        fw.write(xmlStr);
        fw.close();
    }
}