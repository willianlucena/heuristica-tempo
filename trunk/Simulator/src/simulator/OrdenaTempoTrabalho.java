package simulator;

import java.util.Comparator;

public class OrdenaTempoTrabalho implements Comparator<Robot> {

    @Override
    public int compare(Robot o1, Robot o2) {
        return o1.getTempoTrabalhoRobot() - o2.getTempoTrabalhoRobot();
    }
}
