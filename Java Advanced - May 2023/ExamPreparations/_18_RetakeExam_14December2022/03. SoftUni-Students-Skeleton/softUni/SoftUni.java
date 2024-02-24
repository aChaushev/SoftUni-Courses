package softUni;

import java.sql.Struct;
import java.util.ArrayList;
import java.util.List;

public class SoftUni {

    private int capacity;
    private List<Student> data = new ArrayList<>();
    // заменяме null с празен списък (new ArrayList), за да можем да добавяме в него

    public SoftUni(int capacity) {
        this.capacity = capacity;

    }

    public int getCapacity() {
        return capacity;
    }

    public int getCount() {
        return data.size();
    }

    public String insert(Student student) {
//          Returns "Added student {firstName} {lastName}." –  if the student is successfully added.
//          Returns "Student is already in the hall." –  if the student is already in the hall.
//          Returns "The hall is full." - if the hall is full.
        if (getCount() + 1 > this.capacity) {
            // когато не може да влезе още един студент т.е. броя на студентите + 1 става по-голям от капацитета
            return "The hall is full.";
        } else {
            // може да влезе още един студент, но дадния студент е вече вътре
            if (this.data.contains(student)) {
                return "Student is already in the hall.";
            } else {
                // може да влезе в залата
                this.data.add(student);
                return String.format("Added student %s %s.", student.getFirstName(), student.getLastName());
            }
        }
    }

    public String remove(Student student) {
        //имаме такъв студент
        if (this.data.contains(student)) {
            this.data.remove(student);
            return String.format("Removed student %s %s.", student.getFirstName(), student.getLastName());
        } else {
            return "Student not found.";
        }
    }

    public Student getStudent(String firstName, String lastName) {
        for (Student student : this.data) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                return student;
            }
        }
        return null;
    }

    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append("Hall size: ").append(getCount()).append(System.lineSeparator());
        this.data.forEach(student -> sb.append(student.toString()).append(System.lineSeparator()));
        return sb.toString();
    }
}
