class Task {

    // For whether its To-do(T), Deadline (D), Event (E)
    public enum Task_Codes {
        T, D, E
    }

    private String description;
    private boolean isDone;
    private String space = "        ";
    private String lines = "        ____________________________________________________________";


    Task(String description) {
        this.description = description;
        this.isDone = false;
    }


    String format_tasks() throws DukeException {
        return "";
    }

    String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    // Get the description
     String getDescription() {
        return description;
    }

    // Set the task as complete
     void setDone(boolean done) {
        isDone = done;
    }

    void setDescription(String s) throws DukeException {
        this.description = s;
    }

    void got_it_line() {
        System.out.println(space + " Got it. I've added this task: ");
    }

    @Override
    public String toString(){
         return  " [" + this.getStatusIcon() + "] " + getDescription();
    }
}

