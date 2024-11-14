package Leetcode;
/*
 *
 * You are given an array of unique integers salary where salary[i] is the salary of the ith employee.

Return the average salary of employees excluding the minimum and maximum salary. Answers within 10-5 of the actual answer will be accepted.

 

Example 1:

Input: salary = [4000,3000,1000,2000]
Output: 2500.00000
Explanation: Minimum salary and maximum salary are 1000 and 4000 respectively.
Average salary excluding minimum and maximum salary is (2000+3000) / 2 = 2500
Example 2:

Input: salary = [1000,2000,3000]
Output: 2000.00000
Explanation: Minimum salary and maximum salary are 1000 and 3000 respectively.
Average salary excluding minimum and maximum salary is (2000) / 1 = 2000
 *  
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Average Salary Excluding the Minimum and Maximum Salary.
Memory Usage: 42 MB, less than 24.51% of Java online submissions for Average Salary Excluding the Minimum and Maximum Salary.
 */
public class AverageSalary {
    
    public static void main(String[] args) {
        var as = new AverageSalary();
        System.out.println(as.average(new int[]{4000,3000,1000,2000}));
    }

    public double average(int[] salary) {
        int max =salary[0];
        int min = salary[0];
        double total =0;
        for(int i=0;i<salary.length;i++){
            if(salary[i]>max){
                max=salary[i];
            }
            else if(salary[i]<min){
                min = salary[i];
            }
            total+=salary[i];
        }
        
        total = total - min -max;
        return total/(salary.length-2);
    }
}
