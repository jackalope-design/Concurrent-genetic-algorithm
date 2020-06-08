

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public class UpdateThred implements Callable<Floor>, Constraints {

    CountDownLatch l;
    int runNum;
    char[][] floor;
    Floor mother, father;
    String machineList;

    public UpdateThred(CountDownLatch l, int numRun, Floor mother, Floor father, String machineList){
        this.l = l;
        this.runNum = numRun;
        this.father = father;
        this.mother = mother;
        this.machineList = machineList;
    }

    @Override
    public Floor call() throws Exception {
        CrossoverManager cm = new CrossoverManager();
        Floor f = cm.crossover(mother, father, machineList);
        //Thread.sleep(2000);
        l.countDown();
        return f;
    }
}