package simulator;

import java.util.Comparator;

public class OrdenaTaskNome implements Comparator<Tarefa> {

    @Override
    public int compare(Tarefa o1, Tarefa o2) {
        if (o1.getNomeTask().length() == o2.getNomeTask().length()) {
            return o1.getNomeTask().compareToIgnoreCase(o2.getNomeTask());
        } else if (o1.getNomeTask().length() > o2.getNomeTask().length())
            return 1;
        else
            return 0;
    }

}
