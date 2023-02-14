package model;

public class Lesson {
    int id;
    String name;
    String updatedTime;
    Homework homework;

    public Lesson() {
    }

    public Lesson(String name, String updatedTime, int homeworkId) {
        homework = new Homework();
        homework.setId(homeworkId);
        this.name = name;
        this.updatedTime = updatedTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Homework getHomework() {
        return homework;
    }

    public void setHomework(Homework homework) {
        this.homework = homework;
    }

    public String getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", homework='" + homework + '\'' +
                '}' + "\n";
    }
}
