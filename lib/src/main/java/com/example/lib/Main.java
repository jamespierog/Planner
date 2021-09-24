package com.example.lib;

import java.io.IOException;
import java.time.Duration;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws IOException, AlreadyExistsException, NotFoundException {
        //Sample task
        Task t1 = new Task("Task 1", "Task 1 description", Duration.ofHours(5));
        Task t2 = new Task("Task 2", "Task 2 description", Duration.ofHours(3));
        Task t3 = new Task("Task 3", "Task 3 description", Duration.ofHours(2));

        // Sample Project
        Project ysc3232proj = new Project("YSC3232", "Team's Planner Project");

        // Add task to project
        ysc3232proj.addTask(t2);
        ysc3232proj.addTask(t1);
        ysc3232proj.addTask(t3);
        System.out.println(ysc3232proj.tasks);

        //  Sample Section
        Section todo = new Section("TODO");
        Section done = new Section("Done");

        //Adding tasks to sections
        todo.addTask(t1);
        todo.addTask(t2);
        done.addTask(t3);

        // Sample Board
        Board ysc3232board = new Board("YSC3232");

        // Add sections to board
        ysc3232board.addSection(todo);
        ysc3232board.addSection(done);

        // Sample Planner
        Planner Team = new Planner();

        // Adding Project to the Planner
        Team.addProject(ysc3232proj);

        // Adding Board to the Planner
        Team.addBoard(ysc3232board);

        // String to XML
        String xmlStr = Team.writeXMLData();
        FileWriter fw = new FileWriter("planner.xml");
        fw.write(xmlStr);
        fw.close();
    }
}
