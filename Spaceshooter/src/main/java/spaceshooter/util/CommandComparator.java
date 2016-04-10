/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.util;

import spaceshooter.commands.Command;
import java.util.Comparator;

/**
 *
 * @author Aleksi
 */
public class CommandComparator  implements Comparator<Command>{

    @Override
    public int compare(Command o1, Command o2) {
        if (o1.getTime() < o2.getTime())
        {
            return -1;
        }
        if (o1.getTime() > o2.getTime())
        {
            return 1;
        }
        return 0;
    }
    
}
