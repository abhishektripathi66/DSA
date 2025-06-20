package GreedyAlgorithms;

import java.util.Arrays;

/*
 * Job Sequencing Problem
 * Given n jobs with profit and deadline and we have to find out max profit obtained and number of jobs completed
 * 
 * Time Complexity : O(nlong + N*MaxDeadLineOfAnyJob)
 * Auxilliary Time Complexity : O(1)
 * 
 * Example, 
 * Jobs = [(100, 2), (19, 1), (27, 2), (25, 1), (15, 1)] 
 * Profit = 127 (because completed jobs are (100, 2), (27, 2))
 */
public class JobSequencing {

    static class Job{
        int profit;
        int deadline;

        Job(int profit, int deadline){
            this.profit = profit;
            this.deadline = deadline;
        }
    }

    public static void main(String[] args){
        Job[] arr = {
            new Job(100, 2),
            new Job(19, 1),
            new Job(27, 2),
            new Job(25, 1),
            new Job(15, 1)
        };

        int[] res = JobSequencingUtil(arr);
        System.out.println("Job completed : "+res[0]+", Max Profit : "+res[1]);
    }

    private static int[] JobSequencingUtil(Job[] arr){

        //sorintg in reverse order based on profit
        Arrays.sort(arr, (a, b) -> b.profit - a.profit);

        //does not work because here we just consider profit rather than deadline
        // int currTime = 0;
        // int count = 0;
        // int profit = 0;
        // for(Job currJob : arr){
        //     if(currJob.deadline > currTime){
        //         profit += currJob.profit;
        //         count++;
        //         currTime += 1;
        //     }
        // }
        //return new int[]{count, profit};

        //to keep track of available timeslots
        int[] slot = new int[arr.length];

        int count = 0;
        int profit = 0;

        //starting with most profitable job and putting it at most late possible slot
        //so that other job with deadline before than that can be completed
        for(int i=0; i<arr.length; i++){
            int start = arr[i].deadline-1;
            for(int j=start; j>=0; j--){
                if(slot[j] == 0){
                    slot[j] = 1;
                    count++;
                    profit += arr[i].profit;
                    break;
                }
            }
        }

        //returning total number of jobs and max profit obtained
        return new int[]{count, profit};
    }
}