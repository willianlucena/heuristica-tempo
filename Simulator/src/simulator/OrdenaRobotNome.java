/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulator;

import java.util.Comparator;

/**
 *
 * @author suporte
 */
public class OrdenaRobotNome implements Comparator<Robot> {

    @Override
    public int compare(Robot o1, Robot o2) {
        if (o1.getId().length() == o2.getId().length()) {
            return o1.getId().compareToIgnoreCase(o2.getId());
        } else if (o1.getId().length() > o2.getId().length()) {
            return 1;
        } else {
            return 0;
        }
    }

}
