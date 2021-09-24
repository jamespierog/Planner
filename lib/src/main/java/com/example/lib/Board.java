package com.example.lib;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Board implements IBoard{
    String name;
    Set<Section> sections = new HashSet<Section>();

    public Board(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Iterable<Section> getSections(){
        return sections;
    }

    public String toString() {
        return  "Board: " + name + '.';
    }

    @Override
    public void addSection(Section t) throws AlreadyExistsException {
        for(Section s: sections){
            if(s.getName() == t.getName()){
                throw new AlreadyExistsException("This sections already exists!");
            }
        }
        sections.add(t);
    }

    @Override
    public void removeSection(Section t) throws NotFoundException {
        boolean isExist = false;
        for (Section s: sections){
            if(s.getName() == t.getName()){
                sections.remove(t);
                isExist = true;
                break;
            }
        }
        if(isExist == false){
            throw new NotFoundException("This section does not exist, so you cannot remove it!");
        }
    }

    @Override
    public Section getSection(String sectionName) throws NotFoundException {
        return null;
    }

    public String boardToXML(){
        String res = "";
        for (Section s: sections){
            res = res + s.sectionToXML();
        }
        return "    <board>" + "\n"
                + res
                + "    </board>" + "\n";
    }


}
