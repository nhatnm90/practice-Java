package student;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class Student {
    private UUID Id;
    private String FirstName;
    private String LastName;
    private Calendar BirthDate;
    private Gender Gender;
    private double Score_1;
    private double Score_2;
    private double Score_3;
    private double AverageScore;
    private int Rank;
    private Grade Grade;

    public enum Gender {
        MALE,
        FEMALE,
        TBD
    }

    public enum Grade {
        A,
        B,
        C,
        D,
        E
    }



    /*
     * 1. Tạo constructor để tự gán 1 vài thông số mặc định khi khởi tạo 1 đối tượng Student (Gender...)
     * 2. Tạo constructor để tự động generate mã SV khi khởi tạo 1 đối tượng Student
     * 3. Hoàn thành các function để tạo thành 1 đối tượng Student hoàn chỉnh (get, set cho những props đã khai báo)
     * 4. Viết function in ra thông tin SV gồm FullName, Age, Id, Gender
     * 5. Tạo constructor để tự động gán điểm thi cho mỗi đối tượng Student khi đc tạo ra
     * 6. Tính điểm trung bình cho Student vừa tạo với công thức (Score_1 * 1 + Score_2 * 2 + Score_3 * 3) / 6
     * 7. Xếp loại cho đối tượng Student theo công thức sau:
     *   >= 8: A
     *   >= 7: B
     *   >= 6: C
     *   >= 5: D
     *   remaining: E
     * */

    public Student(String firstName, String lastName, int year, int month, int day, Gender gender) {
        this.Id = UUID.randomUUID();
        this.FirstName = firstName;
        this.LastName = lastName;
        this.BirthDate = generateBirthday(year, month, day);
        this.Gender = gender;
//        this.setBirthday(year, month, day);
        this.Score_1 = randomScore();
        this.Score_2 = randomScore();
        this.Score_3 = randomScore();
        this.AverageScore = calculateAverageScore();
        this.Grade = rank();



    }
    public double randomScore() {
//        int max = 10;
//        int min = 0;
//        int range = max - min;
        double randomNumber = (Math.random() * 10); // range luôn = 10
        return round(randomNumber);
    }

    private double round(double number) {
        return Math.round(number * 100.0) / 100.0;
    }

    private double round(double number, int numberOfDecimal) {
        double a = 1.0 * numberOfDecimal * 10;
        return Math.round(number * a) / a;
    }

    /*
     * Set birthdate
     * @param int year, int month, int day
     * */
    public void setBirthday(int year, int month, int day) {
        Calendar birthdate = Calendar.getInstance();
        birthdate.set(year, month - 1, day);
        this.BirthDate = birthdate;
    }

    public Calendar generateBirthday(int year, int month, int day) {
        Calendar birthdate = Calendar.getInstance();
        birthdate.set(year, month - 1, day);
        return birthdate;
    }

    /*
     * Format date to string
     * @param date calendar date
     * @return String date
     * */
    public String formatDate(Calendar date, String pattern) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);

        Date currentDate = date.getTime();

        return dateFormat.format(currentDate);
    }


    // Get
    public UUID getId() {
        return this.Id;
    }

    public String getFistName() {
        return this.FirstName;
    }

    public String getLastName() {
        return this.LastName;
    }

    public Calendar getBirthDate() {
        return this.BirthDate;
    }

    public Gender getGender() {
        return this.Gender;
    }

    // set
    public void setId(UUID id) {
        this.Id = id;
    }

    public void setFirstName(String firstName) {
        this.FirstName = firstName;
    }

    public void setLastNameName(String lastName) {
        this.LastName = lastName;
    }

    public void setBirthDate(Calendar birthDate) {
        this.BirthDate = birthDate;
    }

    public void setGender(Gender gender) {
        this.Gender = gender;
    }

    /*
     * Show Info
     * */
    public void showInfo() {
        String strBirthDate = this.formatDate(this.BirthDate, "dd-MMM-YYYY");
        System.out.println("ID: " + this.Id);
        System.out.println("Fist Name: " + this.getFistName());
        System.out.println("Last Name: " + this.getLastName());
        System.out.println("Birthday: " + strBirthDate);
        System.out.println("Gender: " + this.getGender());
        System.out.println("Score 1: " + this.Score_1);
        System.out.println("Score 2: " + this.Score_2);
        System.out.println("Score 3: " + this.Score_3);
        System.out.println("Average Score: " + this.AverageScore);
        System.out.println("Rank: " + this.Grade);
    }
    /*
     * Calculate Average Score
     * @param score_1, score_2, score_3
     * @return Average Score
     * */
    public double calculateAverageScore () {
        double avgScore = (this.Score_1 * 1 + this.Score_2 * 2 + this.Score_3 * 3) / 6;
        return round(avgScore);
    }

    /*
     * Show Rank
     * @return Grade
     * */
    public Grade rank(){
        if (this.AverageScore >= 8) {
            return Grade.A;
        } else if (this.AverageScore >= 7) {
            return Grade.B;
        } else if (this.AverageScore >= 6) {
            return Grade.C;
        } else if (this.AverageScore >= 5) {
            return Grade.D;
        } else {
            return Grade.E;
        }
    }

    /*
     * Calculate Age
     * @Param Year
     * @return age
     * */
    public int calculateAge(int year) {
        Calendar currentYear = Calendar.getInstance();
        return currentYear.get(Calendar.YEAR) - year;
    }

    public int calculateAge() {
        int totalDays = 0;
        Calendar currentDate = Calendar.getInstance();
        while (this.BirthDate.before(currentDate)) {
            this.BirthDate.add(Calendar.DATE, 1);
            totalDays = totalDays + 1;
        }
        return Math.round(totalDays / 365);
    }
}
