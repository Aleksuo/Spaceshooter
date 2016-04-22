package spaceshooter.util;

import spaceshooter.commands.SpawnEnemyCommand;
import spaceshooter.commands.Command;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;

/**
 * Class used for loading level information from textfiles. \n Format(commands
 * are separated by lines): float time, COMMAND, commandargument1,
 * commandargument2...
 */
public class LevelLoader {

    /**
     * Method that parses a level file.
     *
     * @param filename Name of the file int path: Resources/Levels/
     * @return Returns a PriorityQueue that has commands sorted in an Ascending
     * order.
     */
    public PriorityQueue<Command> loadLevelFromFile(String filename) {
        PriorityQueue<Command> commands = new PriorityQueue<Command>(new CommandComparator());
        try (BufferedReader br = new BufferedReader(new FileReader("Resources/Levels/" + filename))) {
            String line = br.readLine();

            while (line != null) {
                String trimmedLine = line.replaceAll("\\s", "");
                String[] split = trimmedLine.split("[,]");
                System.out.println(trimmedLine.toString());
                Command command;
                if (split[1].equals("SPAWN_ENEMY")) {
                    command = parseCommand(split);
                    commands.add(command);
                }

                line = br.readLine();

            }

        } catch (IOException e) {

        }
        System.out.println("Komentoja: " + commands.size());
        return commands;
    }

    /**
     * Parses line into a SpawnEnemyCommand.
     *
     * @param line Split line from textfile.
     * @return Returns a command for spawning an enemy.
     */
    public SpawnEnemyCommand parseCommand(String[] line) {
        double time = Double.parseDouble(line[0]);
        int id = Integer.parseInt(line[2]);
        float x = Float.parseFloat(line[3]);
        float y = Float.parseFloat(line[4]);

        return new SpawnEnemyCommand(time, id, x, y);
    }

}
