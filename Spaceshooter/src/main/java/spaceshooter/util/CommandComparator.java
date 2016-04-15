package spaceshooter.util;

import spaceshooter.commands.Command;
import java.util.Comparator;

/**
 * Comparator for commands. Ascending order.
 */
public class CommandComparator implements Comparator<Command> {

    @Override
    public int compare(Command o1, Command o2) {
        if (o1.getTime() < o2.getTime()) {
            return -1;
        }
        if (o1.getTime() > o2.getTime()) {
            return 1;
        }
        return 0;
    }

}
