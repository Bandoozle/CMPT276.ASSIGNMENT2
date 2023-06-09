package cmpt276.assignment2.assignment2.models;

import jakarta.persistence.*;

@Entity
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;
    private String name;
    private int weight;
    private int height;
    private String hairColor;
    private Double gpa;
    private String email;
    private String nationality;
    private String number;
    private String gender;
    public Student() {
    }
    public Student(String name, int weight, int height, String hairColor, Double gpa, String email, String nationality, String number, String gender) {
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.hairColor = hairColor;
        this.gpa = gpa;
        this.email = email;
        this.nationality = nationality;
        this.number = number;
        this.gender = gender;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public String getHairColor() {
        return hairColor;
    }
    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }
    public Double getGpa() {
        return gpa;
    }
    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getNationality() {
        return nationality;
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public int getUid() {
        return uid;
    }
    public void setUid(int uid) {
        this.uid = uid;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
}
