import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class A_Collection {
    public static void main(String[] args) {

        List<String> lst = new ArrayList<>();
        lst.add("Hello");
        lst.add("Hello");
        lst.add("Hello");
        lst.add("World");
        lst.add("World");
        lst.add("World");
        lst.add("World");
        lst.add("olleH");

//        System.out.println(lst.size());
//        System.out.println(lst.contains("Hello"));
//        System.out.println(lst.indexOf("World"));
//        System.out.println(lst.get(3));
//        System.out.println(lst.set(3, "dlroW"));
//        System.out.println(lst.get(3));


        for (int i = 0; i < 10; i++) {
            lst.add("num " + i);
        }
//
//        for (String a : lst) {
//            System.out.println(a);
//        }

        Set<String> st = new HashSet<>();

        for (int i = 0; i < 10; i++) {
            st.add("num ");
        }

        st.addAll(lst);
        System.out.println(st.size());


        for (String a : lst) {
            System.out.println(a);
        }

        for (String a : st) {
            System.out.println(a);
        }



//        String[] obj = new String[10];
//        obj[0] = "new String()";
//        obj[1] = "new String()";
//        obj[2] = "new String()";
//        obj[3] = "new String()";

//        int[] arr1 = getIntArr();
//
//        for (int i=0; i<arr1.length;i++){
//            arr1[i]=i;
//        }
//
//        for (int i=0; i<arr1.length;i++){
//            System.out.print(arr1[i]+" ");
//        }
//
//        System.out.println(getIntArr(arr1).length);
//
//
//
//    }
//
//    public static int[] getIntArr(){
//        return new int[10];
//    }
//
//    public static int[] getIntArr(int[] arr){
//        int[] arrDefault =  new int[arr.length + 10];
//        for (int i=0; i<arr.length; i++) {
//            arrDefault[i]=arr[i];
//        }
//        return arrDefault;
    }
}
