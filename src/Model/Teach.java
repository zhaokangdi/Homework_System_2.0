package Model;

public class Teach {
    private String student_name;
    private String teacher_name;

    public Teach(String student_name, String teacher_name) {
        this.student_name = student_name;
        this.teacher_name = teacher_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getStudent_name() {
        return student_name;
    }

    public String getTeacher_name() {
        return teacher_name;
    }
}
