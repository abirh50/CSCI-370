package edu.qc.seclass;

public class BuggyClass {
    public static int buggyMethod1(int a, int b){
        int result = 0;

        if (a < b) {
            result = b / a;
        }
        else if (a > b) {
            result = a / b;
        }
        else {
            return 1;
        }

        return result;
    }

    public static int buggyMethod2(int a, int b){
        int result = 0;

        if (a < b) {
            result = b / a;
        }
        else if (a > b) {
            result = a / b;
        }
        else {
            return 1;
        }

        return result;
    }

    public static int buggyMethod3(int a){
        int result = a;

        if (result % 6 == 0){
            result = a/2;
        }

        else if (result % 2 != 0) {
            result = result / (a-7);
        }

        return result;
    }

    public void buggyMethod4(){
        /* It's not possible to create a test suite that achieves 100% statement coverage that reveals the fault
           and 100% branch coverage that does not reveal the fault. This is because branch coverage covers more than statement coverage.
        */
    }

    public void buggyMethod5(){
        /* This is not possible because 100% statement coverage means line 4 will run
           which means there will be a divide by 0 exception.
        */
    }
}
