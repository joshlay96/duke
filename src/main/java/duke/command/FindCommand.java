package duke.command;

import duke.exception.DukeException;
import duke.storage.Storage;
import duke.ui.Ui;
import duke.task.Task;
import duke.task.TaskList;

public class FindCommand extends Command {
    public FindCommand(String userInput) {
        super(userInput);
    }

    @Override
    public String execute(Storage storage, Ui ui, TaskList tasklist) throws DukeException {
        String description = splitDoneString("find ", this.userInput);
        TaskList foundTasks = new TaskList();

        for (Task k : tasklist.getList()) {
            if (k.getDescription().contains(description)) {
                foundTasks.addToList(k);
            }
        }

        if (foundTasks.getList().isEmpty()) {
            throw new DukeException("There are no tasks with this keyword :'( ");
        } else {
            return ui.printList(foundTasks);
        }

    }

    private String splitDoneString(String regrexWanted, String userInput) {
        String[] splittedString = userInput.split(regrexWanted);
        return splittedString[1];
    }

}
