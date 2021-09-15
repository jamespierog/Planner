package com.example.lib;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

public class Planner {
    String name;
    String description;
    LocalDateTime deadline;

    public Planner(String name, String description, LocalDateTime deadline) {
        this.name = name;
        this.description = description;
        this.deadline = deadline;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public String toString() {
        return  "Project: " + name + ", description: " + description + ", deadline: " + deadline + '.';
    }

    // Function to convert project object to XML
    public String plannerToXML(){
        return "<?xml version = \"1.0\" encoding = \"UTF-8\" ?>" + "\n"
                + "<project>" + "\n"
                + "    <name>" + getName() + "</name>" + "\n"
                + "    <description>" + getDescription() + "</description>" + "\n"
                + "    <deadline>" + getDeadline() + "</deadline>" + "\n"
                + "</project>";
    }

    public static void main(String[] args) throws IOException {
        //Sample project
        Project p1 = new Planner("Project 1", "Project 1 description", Duration.ofHours(5), LocalDateTime.of(2000, 8, 31, 7, 30));
//        System.out.println(t1.toString());

        // Turn Project object to xml file
        String xmlStr = t1.projectToXML();
        java.io.FileWriter fw = new FileWriter("project.xml");
        fw.write(xmlStr);
        fw.close();
    }
}
