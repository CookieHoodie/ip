package duke;

import duke.task.Task;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles storing of task list to disk and loading of task list from disk.
 */
public class Storage {
    /**
     * File to save the data to.
     */
    private final File dukeFile;

    /**
     * @param dukeFile file to save the data to
     */
    public Storage(File dukeFile) {
        this.dukeFile = dukeFile;
    }

    /**
     * Load the list of tasks from the duke data file on disk.
     *
     * @return the list of tasks loaded from disk if exists, or empty list if not
     * @throws DukeException If fails to read the file from disk or fails to read the format of the file to list of tasks.
     */
    public List<Task> loadTasks() throws DukeException {
        ArrayList<Task> tasks;
        // create a new list if data doesn't exist on disk yet
        if (!dukeFile.exists()) {
            tasks = new ArrayList<>();
        } else {
            FileInputStream fin = null;
            ObjectInputStream ois = null;
            try {
                fin = new FileInputStream(dukeFile);
                ois = new ObjectInputStream(fin);
                tasks = (ArrayList<Task>) ois.readObject();  // convert the file content to list of tasks
            } catch (IOException | ClassNotFoundException e) {
                throw new DukeException("Failed to load tasks from file.");
            } finally {
                // close all the resources
                try {
                    if (fin != null) {
                        fin.close();
                    }
                    if (ois != null) {
                        ois.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return tasks;
    }

    /**
     * Store the list of tasks to the duke data file on disk.
     *
     * @param tasks list of tasks to be stored to disk
     * @throws DukeException If fails to write the list of tasks to the file.
     */
    public void storeTasks(List<Task> tasks) throws DukeException {
        // create necessary parent directories if the file doesn't exist yet
        if (!dukeFile.exists()) {
            dukeFile.getParentFile().mkdirs();
        }

        FileOutputStream fout = null;
        ObjectOutputStream oos = null;
        try {
            fout = new FileOutputStream(dukeFile);
            oos = new ObjectOutputStream(fout);
            oos.writeObject(tasks);  // write the list of tasks to the file
        } catch (IOException e) {
            throw new DukeException("Failed to store tasks into file.");
        } finally {
            // close the resources
            try {
                if (fout != null) {
                    fout.close();
                }
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
