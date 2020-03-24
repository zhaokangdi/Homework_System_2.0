package Model;

public class Homework {
    private String homework_title;
    private String teacher_name;

    public Homework() {

    }

    public Homework(String homework_title, String teacher_name) {
        this.homework_title = homework_title;
        this.teacher_name = teacher_name;
    }

    public void setHomework_title(String homework_title) {
        this.homework_title = homework_title;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getHomework_title() {
        return homework_title;
    }

    public String getTeacher_name() {
        return teacher_name;
    }
}
