

class testList extends student implements main2{
    @Override
    public void sort() {
        System.out.println("排序");
    }
}

public class Main  {

    public static void main(String[] args) {
        testList list = new testList();
        list.remove(2);
    }

}

abstract class student implements main2 {

    public boolean add(Integer a){
        return  true;
    }

    public void remove(Integer b){
        System.out.println("nihao");
    }
}

interface  main2{

    boolean add(Integer a);

    void remove(Integer b);

    void sort();

}
