package runner;

import java.util.Date;

public class TestResult {
    private int totalTestsCount;
    private int passedTestsCount;
    private int failedTestsCount;
    private int totalRunTime;

    public TestResult(int totalTestsCount, int passedTestsCount, int failedTestsCount, int runTime) {
        this.totalTestsCount = totalTestsCount;
        this.passedTestsCount = passedTestsCount;
        this.failedTestsCount = failedTestsCount;
        totalRunTime = runTime;
    }

    public int getTotalTestsCount() {
        return totalTestsCount;
    }

    public int getPassedTestsCount() {
        return passedTestsCount;
    }

    public int getFailedTestsCount() {
        return failedTestsCount;
    }

    public int getTotalRunTime() {
        return totalRunTime;
    }

    @Override
    public String toString() {
        return
                "totalTestsCount= " + totalTestsCount +
                ", passedTestsCount= " + passedTestsCount +
                ", failedTestsCount= " + failedTestsCount +
                ", totalRunTime= " + totalRunTime + " ms" +
                '}';
    }
}
