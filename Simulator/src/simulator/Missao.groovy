package simulator;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/*Classe responsável pela execução da missão e exibição das configurações das tarefas e dos robôs definidos no ambiente.*/
public class Missao {

    /* Listas de robôs e tarefas definidos para a missão */
    private TreeSet<Robot> candidates = new TreeSet<Robot>(new OrdenaRobotNome());
    private Set<Tarefa> toDo = new LinkedHashSet<Tarefa>();

    /* Suprimir 'warnings' da IDE Eclipse 3.7.0 */
    public void execMissao() {
        System.out.println("\n-----------------");
        System.out.println("EXECUÇÃO DA MISSÃO");
        System.out.print("-----------------");
        for (Tarefa t : toDo) {
            /* Conjuntos de Aptidão dos Robôs, organizados por peso */
            TreeSet<Robot> aptosCompletos = new TreeSet<Robot>(new OrdenaTempo());
            TreeSet<Robot> aptosFisic = new TreeSet<Robot>(new OrdenaTempo());
            TreeSet<Robot> aptosItelect = new TreeSet<Robot>(new OrdenaTempo());
            TreeSet<Robot> aptosTroca = new TreeSet<Robot>(new OrdenaTempo());
            for (Robot r : candidates) {
                /* Aptos completamente */
                if ((r.getSabeRobot().containsAll(t.getSabeTask()) && r.getFazRobot().containsAll(t.getFazTask())) && t.isSolved() == false && r.getPeso() <= 1) {
                    aptosCompletos.add(r);
                }
                /* Aptos fisicamente */
                if (r.getFazRobot().containsAll(t.getFazTask())) {
                    aptosFisic.add(r);
                }
                /* Aptos intelectualmente */
                if (r.getSabeRobot().containsAll(t.getSabeTask())) {
                    aptosItelect.add(r);
                } else {
                    /* Aptos para troca de conhecimentos */
                    for (String tmp : t.getSabeTask()) {
                        for (String tmp2 : r.getSabeRobot()) {
                            if (tmp == tmp2) {
                                aptosTroca.add(r);
                            }
                        }
                    }
                }
            }
            /* ROBÔ COMPLETAMENTE APTO */
            if (aptosCompletos.isEmpty() == false && aptosCompletos.first().getTempoRobot() == 0) {
                /* Há robô apto */
                t.setHasApto(true);
                /* Garante que o peso do robô utilizado será incrementado */
                aptosCompletos.first().incrementaPeso();
                /* Informa o tempo que o robô deverá se dedicar à tarefa */
                aptosCompletos.first().setTempoRobot(aptosCompletos.first().getTempoRobot() + t.getTempoTask());
                /* Guarda o tempo total que o robô trabalhou */
                aptosCompletos.first().setTempoTrabalhoRobot(aptosCompletos.first().getTempoTrabalhoRobot() + t.getTempoTask());
                /* MARCA O ROBÔ NA TAREFA */
                t.setApto(aptosCompletos.first());
                /* Atualiza o peso e o tempo dos robôs em candidates */
                aptosCompletos.retainAll(candidates);
                /* Libera o conjunto dos Robôs Completamente Aptos */
                aptosCompletos.clear();
            } else {
                /* ROBÔ INTELECTUALMENTE APTO */
                if (aptosItelect.isEmpty() == false) {
                    /* Isola o conhecimento do 1º robô Apto Intelectualmente */
                    Set<String> knowsBotAI = aptosItelect.first().getSabeRobot();
                    /* Isola o conhecimento necessário para resolver a tarefa */
                    Set<String> knowsTaskAI = t.getSabeTask();
                    /* Clona os conhecimentos para não corromper os dados */
                    Set<String> cloneKnowsBotAI = (Set) ((TreeSet<String>) knowsBotAI).clone();
                    Set<String> cloneKnowsTaskAI = (Set) ((TreeSet<String>) knowsTaskAI).clone();
                    /*
                     * Isola no robô apenas o conhecimento necessário para
                     * resolver a tarefa, evitando repassar conhecimentos
                     * desnecessários
                     */
                    cloneKnowsBotAI.retainAll(cloneKnowsTaskAI);
                    if (aptosFisic.isEmpty() == false) {
                        /* Isola o conhecimento do 1º robô Apto Fisicamente */
                        Set<String> knowsBotAIAF = aptosFisic.first().getSabeRobot();
                        /* Clona o conhecimento para não corromper os dados */
                        Set<String> cloneKnowsBotAIAF = (Set) ((TreeSet<String>) knowsBotAIAF).clone();
                        /*
                         * Guarda o conhecimento do 1º robô Apto Fisicamente,
                         * acrescido apenas do conhecimento necessário para
                         * solucionar a tarefa.
                         */
                        cloneKnowsBotAIAF.addAll(cloneKnowsBotAI);
                        /*
                         * Robô auxiliar, utilizado para garantir que o
                         * conhecimento acima só será repassado ao 1º Robô Apto
                         * Fisicamente caso esse seja de fato suficiente para
                         * solucionar a tarefa. As linhas a seguir testam essa
                         * condição.
                         */
                        Robot tmpBotAI = (Robot) aptosFisic.first().clone();
                        tmpBotAI.setSabeRobot(cloneKnowsBotAIAF);
                        if ((tmpBotAI.getSabeRobot().containsAll(t.getSabeTask()) && tmpBotAI.getFazRobot().containsAll(t.getFazTask())) && t.isSolved() == false) {
                            /* Há robô apto */
                            t.setHasApto(true);
                            /*
                             * Repassa o conhecimento ao 1º robô Apto
                             * Fisicamente
                             */
                            aptosFisic.first().setSabeRobot(cloneKnowsBotAIAF);
                            /* Incrementa o peso do robô */
                            aptosFisic.first().incrementaPeso();
                            /*
                             * Informa o tempo que o robô deverá se dedicar à
                             * tarefa
                             */
                            aptosFisic.first().setTempoRobot(aptosFisic.first().getTempoRobot() + t.getTempoTask());
                            /* Guarda o tempo total que o robô trabalhou */
                            aptosFisic.first().setTempoTrabalhoRobot(aptosFisic.first().getTempoTrabalhoRobot() + t.getTempoTask());
                            /* MARCA O ROBÔ NA TAREFA */
                            t.setApto(aptosFisic.first());
                            /*
                             * Atualiza na lista principal candidates o peso e o
                             * novo conhecimento do robô escolhido.
                             */
                            aptosFisic.retainAll(candidates);
                            /* Libera o conjuntos dos Robôs Fisicamente Aptos */
                            aptosFisic.clear();
                        }
                    }
                } else {
                    /* ROBÔ APTO A INTERCÂMBIO */
                    if (aptosTroca.isEmpty() == false) {
                        /*
                         * Armazena o conhecimento necessário à resolução da
                         * tarefa.
                         */
                        Set<String> troca = new TreeSet<String>();
                        for (String tmpT : t.getSabeTask()) {
                            for (Robot tmpR : aptosTroca) {
                                /*
                                 * Recolhe dos robôs aptos a intercâmbio apenas
                                 * o conhecimento necesário à resolução da
                                 * tarefa.
                                 */
                                if (tmpR.getSabeRobot().contains(tmpT)) {
                                    for (String tmpTroca : tmpR.getSabeRobot()) {
                                        troca.add(tmpTroca);
                                    }
                                }
                            }
                        }
                        /*
                         * Isola o conhecimento necessário à resolução da tarefa
                         */
                        troca.retainAll(t.getSabeTask());
                        if (aptosFisic.isEmpty() == false) {
                            /* Isola o conhecimento do 1º robô Apto Fisicamente */
                            Set<String> knowsBotATAF = aptosFisic.first().getSabeRobot();
                            /* Clona o conhecimento para não corromper os dados */
                            Set<String> cloneKnowsBotATAF = (Set) ((TreeSet<String>) knowsBotATAF).clone();
                            /*
                             * Adiciona ao conhecimento necessário à resolução
                             * da tarefa o conhecimento do 1º robô Apto
                             * Fisicamente
                             */
                            for (String tmpATAF : cloneKnowsBotATAF) {
                                troca.add(tmpATAF);
                            }
                            /*
                             * Robô auxiliar, utilizado para garantir que o
                             * conhecimento acima só será repassado ao 1º Robô
                             * Apto Fisicamente caso esse seja de fato
                             * suficiente para solucionar a tarefa. As linhas a
                             * seguir testam essa condição.
                             */
                            Robot tmpATAF = aptosFisic.first().clone();
                            tmpATAF.setSabeRobot(troca);
                            if ((tmpATAF.getSabeRobot().containsAll(t.getSabeTask()) && tmpATAF.getFazRobot().containsAll(t.getFazTask())) && t.isSolved() == false) {
                                /* Há robô apto */
                                t.setHasApto(true);
                                /*
                                 * Repassa o conhecimento ao robô Apto
                                 * Fisicamente
                                 */
                                aptosFisic.first().setSabeRobot(tmpATAF.getSabeRobot());
                                /* Incrementa o peso do robô */
                                aptosFisic.first().incrementaPeso();
                                /*
                                 * Informa o tempo que o robô deverá se dedicar
                                 * à tarefa
                                 */
                                aptosFisic.first().setTempoRobot(aptosFisic.first().getTempoRobot() + t.getTempoTask());
                                /* Guarda o tempo total que o robô trabalhou */
                                aptosFisic.first().setTempoTrabalhoRobot(aptosFisic.first().getTempoTrabalhoRobot() + t.getTempoTask());
                                /* MARCA O ROBÔ NA TAREFA */
                                t.setApto(aptosFisic.first());
                                /*
                                 * Atualiza na lista principal candidates o peso
                                 * e o novo conhecimento do robô escolhido.
                                 */
                                aptosFisic.retainAll(candidates);
                                /*
                                 * Libera o conjuntos dos Fisicamente Aptos
                                 */
                                aptosFisic.clear();
                            }
                        }
                    }
                }
            }
        }
        /* RESOLUÇÃO DE TAREFAS */
        /* Lista auxiliar que guarda os robôs por tempo de trabalho */
        TreeSet<Robot> tempoExecucao = new TreeSet<Robot>(new OrdenaTempoTrabalho());
        tempoExecucao.addAll(candidates);
        for (Tarefa t : toDo) {
            if (t.isHasApto() == true) {
                /* Decrementa to[i] */
                while (t.getApto().getTempoRobot() > 0) {
                    t.getApto().decrementaTempo();
                }
                /* Resolve a tarefa */
                if (t.getApto().getTempoRobot() == 0) {
                    t.setSolved(true);
                    t.setLogRobot(t.getApto().getId());
                }
            }
        }
        for (Tarefa t : toDo) {
            // Imprime a resolução de tarefas
            if (t.isSolved() == true) {
                System.out.printf("\n%-3s foi resolvida por %-3s", t.getNomeTask(), t.getLogRobot());
            } else {
                System.out.printf("\n%-3s não foi resolvida", t.getNomeTask());
            }
        }
        System.out.println("\nTempo total de execução: "
            + tempoExecucao.last().getTempoTrabalhoRobot()
            + " unidades de tempo.");
    }

    // Exibe as configurações dos robôs
    public void configRobots() {
        System.out.println("-----------------");
        System.out.println("ATRIBUTOS DOS ROBÔS");
        System.out.println("-----------------");
        for (Robot r : candidates) {
            Set<String> tmp = new TreeSet<String>();
            tmp = r.getSabeRobot();
            tmp.remove("");
            System.out.println(r.getId() + "=" + "{" + tmp + ";"
                + r.getFazRobot() + ";[" + r.getTempoRobot() + "]} -> \""
                + r.getTempoTrabalhoRobot() + "\"");
        }
    }

    // Exibe as configurações das tarefas
    public void configTasks() {
        System.out.println("\n-----------------");
        System.out.println("ATRIBUTOS DE TAREFAS");
        System.out.println("-----------------");
        TreeSet<Tarefa> ordenaTask = new TreeSet<Tarefa>(new OrdenaTaskNome());
        ordenaTask.addAll(toDo);
        for (Tarefa t : ordenaTask) {
            System.out.println(t.getNomeTask() + "=" + "{" + t.getSabeTask()
                + ";" + t.getFazTask() + ",[" + t.getTempoTask() + "]}");
        }
        ordenaTask.clear();
    }

    // Exibe a lista de robôs
    public void listaRobots() {
        System.out.println("\n-----------------");
        System.out.println("LISTA DE ROBÔS");
        System.out.println("-----------------");
        int cont = 0;
        System.out.print("{");
        if (candidates.isEmpty()) {
            System.out.print("");
        } else {
            for (Robot r : candidates) {
                if (cont == (candidates.size() - 1)) {
                    System.out.print(r.getId());
                } else {
                    System.out.print(r.getId() + ", ");
                }
                cont++;
            }
        }
        System.out.print("}\n");
    }

    // Exibe a lista de tarefas
    public void listaTasks() {
        System.out.println("\n-----------------");
        System.out.println("LISTA DE TAREFAS");
        System.out.println("-----------------");
        int cont = 0;
        System.out.print("{");
        if (toDo == null) {
            System.out.print("");
        } else {
            for (Tarefa t : toDo) {
                if (cont == (toDo.size() - 1)) {
                    System.out.print(t.getNomeTask());
                } else {
                    System.out.print(t.getNomeTask() + ", ");
                }
                cont++;
            }
        }
        System.out.print("}\n");
    }

    public TreeSet<Robot> getCandidates() {
        return candidates;
    }

    public void setCandidates(TreeSet<Robot> candidates) {
        this.candidates = candidates;
    }

    public Set<Tarefa> getToDo() {
        return toDo;
    }

    public void setToDo(Set<Tarefa> toDo) {
        this.toDo = toDo;
    }
}
