import java.util.*;

public class 容器 {

    public static void main(String[] args) throws InterruptedException {

        HashMap<String, String> map = new HashMap<>();

        map.put("a","b");
        map.put("a","c");

        System.out.println(map.get("a"));

        throw new RuntimeException();


    }
}
