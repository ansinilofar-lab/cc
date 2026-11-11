
package org.cloudbus.cloudsim.examples;

import java.util.*;



public class MinMinScheduling {

    public static void main(String[] args) {

        int[] task = {4000, 2000, 6000, 3000};
        int[] vm = {1000, 1000};

        double[] vmTime = {0, 0};
        boolean[] assigned = new boolean[4];

        System.out.println("MIN-MIN SCHEDULING");

        for (int count = 0; count < task.length; count++) {

            double minTime = Double.MAX_VALUE;
            int selectedTask = -1;
            int selectedVM = -1;

            for (int i = 0; i < task.length; i++) {

                if (!assigned[i]) {

                    for (int j = 0; j < vm.length; j++) {

                        double time = vmTime[j] +
                                      (double) task[i] / vm[j];

                        if (time < minTime) {
                            minTime = time;
                            selectedTask = i;
                            selectedVM = j;
                        }
                    }
                }
            }

            assigned[selectedTask] = true;
            vmTime[selectedVM] = minTime;

            System.out.println("Task " + selectedTask +
                    " assigned to VM " + selectedVM);
        }

        System.out.println("\nFinal VM Completion Times:");

        for (int i = 0; i < vm.length; i++) {
            System.out.println("VM " + i + ": " + vmTime[i]);
        }
    }
}
