import com.designpattern.creational.SingletonLazy;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");



        //Builder Pattern
//        UserProfile user = new UserProfile.UserProfileBuilder("Vivek", "viveki1s10@gmail.com")
//                .setPhone("8848598011")
//                .setAddress("Flat No 401")
//                .setAge(25).build();
//
//        System.out.println(user);



        //SingletonEager
//        SingletonEager singletonEager = SingletonEager.getInstance();
//        singletonEager.log("I am Vivek");

        SingletonLazy singletonLazy = SingletonLazy.getInstance();
        singletonLazy.log("I am Vivek.");



    }
}