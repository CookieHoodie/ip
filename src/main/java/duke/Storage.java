package duke;

import duke.task.Task;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    private final File dukeFile;

    public Storage(File dukeFile) {
        this.dukeFile = dukeFile;
    }

    public List<Task> loadTasks() throws DukeException {
        ArrayList<Task> tasks = null;
        if (dukeFile.exists()) {
            FileInputStream fin = null;
            ObjectInputStream ois = null;
            try {
                fin = new FileInputStream(dukeFile);
                ois = new ObjectInputStream(fin);
                tasks = (ArrayList<Task>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                throw new DukeException("Failed to load tasks from file.");
            } finally {
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

    public void storeTasks(List<Task> tasks) throws DukeException {
        if (!dukeFile.exists()) {
            dukeFile.getParentFile().mkdirs();  // create necessary parent directories
        }

        FileOutputStream fout = null;
        ObjectOutputStream oos = null;
        try {
            fout = new FileOutputStream(dukeFile);
            oos = new ObjectOutputStream(fout);
            oos.writeObject(tasks);
        } catch (IOException e) {
            throw new DukeException("Failed to store tasks into file.");
        } finally {
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
