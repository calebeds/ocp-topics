package questions.threads;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

class ComplicatedAction extends RecursiveAction {
    int[] ia;
    int low;
    int high;

    public ComplicatedAction(int[] ia, int low, int high) {
        this.ia = ia;
        this.low = low;
        this.high = high;
    }

    @Override
    protected void compute() {
        if(low == high) {
            ia[low] = UtilityClass.utilityMethod(ia[low]);
        } else {
            int mid = (low + high) / 2;
            ComplicatedAction newTask1 = new ComplicatedAction(ia, low, mid);
            ComplicatedAction newTask2 = new ComplicatedAction(ia, mid + 1, high);
            newTask2.fork();
            newTask1.compute();
            newTask2.join();

        }
    }

    public static void main(String[] args) {
        int ia[] = new int[] {1, 2, 3, 4, 5, 6, 7};
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ComplicatedAction complicatedAction = new ComplicatedAction(ia, 0, 6);
        forkJoinPool.invoke(complicatedAction);
        System.out.print("New Array Values =");
        for (int i: ia) {
            System.out.print(i + " ");
        }
    }
}

class UtilityClass {
    static int utilityMethod(int element) {
        return element + 1;
    }
}

class Q2_1241 {
}
