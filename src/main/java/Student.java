import java.util.Date;
import java.util.UUID;

public class Student {
    private UUID Id;
    private String FirstName;
    private String LastName;
    private Date BirthDate;
    private Gender Gender;
    private float Score_1;
    private float Score_2;
    private float Score_3;
    private float AverageScore;
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

    public void setFirstName(String firstName) {
        this.FirstName = firstName;
    }

    public String getFirstName() {
        return this.FirstName;
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


}
