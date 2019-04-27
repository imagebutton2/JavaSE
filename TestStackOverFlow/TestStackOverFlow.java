package My.Test;

//StackOverFlow
//Java虚拟机栈深度超出
public class TestStackOverFlow {
    //JVM参数为:-Xss128k
    private int stackLength = 0;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }


    public static void main(String[] args) {
        TestStackOverFlow testStackOverFlow = new TestStackOverFlow();
        try {
            testStackOverFlow.stackLeak();
        } catch (Throwable e) {
            System.out.println("Stack Length: " + testStackOverFlow.stackLength);
            throw e;
        }
    }
}