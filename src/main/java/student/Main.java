package student;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args){
        System.out.println("Hello World");

        Calendar birthDate = Calendar.getInstance();
        birthDate.set(1990,1,21);


        Student std = new Student("Hanh", "Nguyen", 1990, 6,24, Student.Gender.FEMALE);
//        SimpleDateFormat ft = new SimpleDateFormat("MMM-dd-YYYY");
//        System.out.println(ft.format(std.getBirthDate().getTime()));
        std.showInfo();


    }

}
