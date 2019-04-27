package My.Test;
//Java Heap OOM
//Java 堆内存溢出
//命令-Xms最小值的堆内存 -Xmx最大值的堆内存  -XX:+HeapDumpOnOutOfMemoryError

import java.util.ArrayList;
import java.util.List;

public class TestOOM {
    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> oomObjects = new ArrayList<>();
        while (true) {
            oomObjects.add(new OOMObject());
        }
    }
}
