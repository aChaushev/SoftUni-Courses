package _06_Encapsulation_Exercise;

public class Demo {
    public static void main(String[] args) {

        String a = null;
        if( a!= null && a.equals("Pesho")){
            System.out.println("Yes");
        }

        String b = null;
        if( "Pesho".equals(b)){
            System.out.println("Yes");
        }
    }
}
