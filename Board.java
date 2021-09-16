public class Board {
    String name;
    Set<Section> sections = new TreeSet<Section>();

    public Board(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Iteratable<Section> getSections(){
        return sections;
    }

    public void addSection(Section t) throws AlreadyExistsException{
        for(Section s: sections){
            if(s.getName() == t.getName()){
                throw new AlreadyExistsException("This sections already exists!")
            }
        }
        sections.add(t);
    }

    public void removeSection(Section t) throws NotFoundException{
        boolean isExist = false;
        for (Section s: sections){
            if(s.getName() == t.getName()){
                sections.remove(t);
                isExist = true;
            }
        }
        if(isExist == false){
            throw new NotFoundException("This section does not exist, so you cannot remove it!");
        }
    }


//    public String toString() {
//        return  "Board: " + name + '.';
//    }

//    // Function to convert project object to XML
//    public String projectToXML(){
//        return "<?xml version = \"1.0\" encoding = \"UTF-8\" ?>" + "\n"
//                + "<board>" + "\n"
//                + "    <name>" + getName() + "</name>" + "\n"
//                + "</board>";
//    }
//
//    public static void main(String[] args) {
//
//    }
}
