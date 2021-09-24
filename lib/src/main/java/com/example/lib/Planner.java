package com.example.lib;

import java.util.HashSet;
import java.util.Set;

public class Planner implements IPlanner{
    Set<Project> projects = new HashSet<Project>();
    Set<Board> boards = new HashSet<Board>();

    public Iterable<Project> getProjects(){
        return projects;
    }

    public Iterable<Board> getBoards(){
        return boards;
    }

    public String toString() {
        return  "Planner created!";
    }

    public void addProject(Project p) throws AlreadyExistsException {
        for(Project s: projects){
            if(s.getName() == p.getName() && s.getDescription() == p.getDescription()){
                throw new AlreadyExistsException("This project already exists!");
            }
        }
        projects.add(p);
    }

    public void removeProject(Project p) throws NotFoundException {
        boolean isExist = false;
        for (Project s: projects){
            if(s.getName() == p.getName() && s.getDescription() == p.getDescription()){
                projects.remove(s);
                isExist = true;
                break;
            }
        }
        if(isExist == false){
            throw new NotFoundException("This project does not exist, so you cannot remove it!");
        }
    }

    public void addBoard(Board b) throws AlreadyExistsException {
        for(Board s: boards){
            if(s.getName() == b.getName()){
                throw new AlreadyExistsException("This board already exists!");
            }
        }
        boards.add(b);
    }

    public void removeBoard(Project b) throws NotFoundException {
        boolean isExist = false;
        for (Board s: boards){
            if(s.getName() == b.getName()){
                boards.remove(b);
                isExist = true;
                break;
            }
        }
        if(isExist == false){
            throw new NotFoundException("This board does not exist, so you cannot remove it!");
        }
    }

    public String writeXMLData(){
        String projres = "";
        for (Project p: projects){
            projres = projres + p.projectToXML();
        }
        String boardres = "";
        for (Board b: boards){
            boardres = boardres + b.boardToXML();
        }
        return "<?xml version = \"1.0\" encoding = \"UTF-8\" ?>" + "\n"
                + "<planner>" + "\n"
                + projres
                + boardres
                + "</planner>";
    }


}
