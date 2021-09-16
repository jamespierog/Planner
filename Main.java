class Main {
    public static void main(String[] args) throws AlreadyExistsException, NotFoundException{
        Planner Team = new Planner();
        Project ysc3232_p = new Project("YSC3232", "Homework");
        Task T1 = new Task("T1", "Eat", Duration.ofMinutes(10));
        Task T2 = new Task("T2", "Sleep", Duration.ofMinutes(10));
        Task T3 = new Task("T3", "Repeat", Duration.ofMinutes(10));
        Board ysc3232 = new Board("YSC3232");
        Section todo = new Section("TODO");
        Section done = new Section("Done");
    }
}

