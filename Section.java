package com.example.lib;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

public class Section implements ISection{
    String name;
    Set<Task> tasks = new TreeSet<Task>();

    public Section(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Iteratable<Task> getTasks(){
        return tasks;
    }

    public void addTask(Task t) throws AlreadyExistsException{
        for(Task s: tasks){
            if(s.getName() == t.getName() && s.getDescription() == t.getDescription() && s.getExpectedDuration() == t.getExpectedDuration()){
                throw new AlreadyExistsException("This task already exists!")
            }
        }
        task.add(t)
    }

    public void removeTask(Task t) throws NotFoundException{
        boolean isExist = false;
        for (Task s: tasks){
            if(s.getName() == t.getName() && s.getDescription() == t.getDescription() && s.getExpectedDuration() == t.getExpectedDuration()){
                task.remove(t);
                isExist = true;
            }
        }
        if(isExist == false){
            throw new NotFoundException("This subtask does not exist, so you cannot remove it!");
        }
    }


    public String toString() {
        return  "Project: " + name + ", description: " + description + ", deadline: " + deadline + '.';
    }

    // Function to convert project object to XML
    public String projectToXML(){
        return "<?xml version = \"1.0\" encoding = \"UTF-8\" ?>" + "\n"
                + "<project>" + "\n"
                + "    <name>" + getName() + "</name>" + "\n"
                + "    <description>" + getDescription() + "</description>" + "\n"
                + "    <deadline>" + getDeadline() + "</deadline>" + "\n"
                + "</project>";
    }

    public static void main(String[] args) throws IOException {
        //Sample project
        Project p1 = new Project("Project 1", "Project 1 description", Duration.ofHours(5), LocalDateTime.of(2000, 8, 31, 7, 30));
//        System.out.println(t1.toString());

        // Turn Project object to xml file
        String xmlStr = t1.projectToXML();
        java.io.FileWriter fw = new FileWriter("project.xml");
        fw.write(xmlStr);
        fw.close();
    }
}
