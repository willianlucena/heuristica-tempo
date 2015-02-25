package simulator;

import java.util.Comparator;

public class OrdenaTempo implements Comparator<Robot> {

    @Override
    public int compare(Robot o1, Robot o2) {
        if (o1.getTempoRobot() == o2.getTempoRobot()) {
            return 1;
        } else {
            return o1.getTempoRobot() - o2.getTempoRobot();
        }
    }
}
