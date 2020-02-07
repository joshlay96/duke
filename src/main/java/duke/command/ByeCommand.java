package duke.command;


import duke.duke.Duke;
import duke.exception.DukeException;
import duke.storage.Storage;
import duke.ui.Ui;
import duke.task.TaskList;


/**
 * Class which consists a command to terminate the program
 * When the user types "bye".
 */
public class ByeCommand extends Command {

    /**
     * Instantiates a new Bye command.
     *
     * @param userInput the user input
     */
    public ByeCommand(String userInput) {
        super(userInput);
    }


    /**
     * Overwrites the execute method from Abstract class execute
     * Check against the user's input then pass it UI class to print the Bye Message.
     *
     * @param storage  Deals with loading tasks from file.
     * @param ui       Deals with interactions with the user
     * @param taskList List containing all the tasks
     * @throws DukeException Main exception method I have created
     */
    @Override
    public String execute(Storage storage, Ui ui, TaskList taskList) throws DukeException {

        try {
            String ans = ui.printBye();
            taskList.getList().clear();
            assert (taskList.getList().isEmpty())
                    : "taskList should be empty by this point in ByeCommand";
            return ans;
        } catch (Exception e) {
            throw new DukeException(e.getMessage());
        }
    }
}