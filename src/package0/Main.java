package package0;

public class Main {
    public static void main(String[] args) {
        ThreadSafeList<String> list = new ThreadSafeList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        System.out.println(list.get(1));
        list.remove(1);
        System.out.println(list.get(1));

        ThreadSafeList<Integer> list02 = new ThreadSafeList<>();
        list02.add(12);
        list02.add(13);
        list02.add(14);
        System.out.println(list02.get(0));
        list02.remove(0);
        System.out.println(list02.get(0));


    }
}