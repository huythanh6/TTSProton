package controller;

import entity.Person;

import java.util.ArrayList;
import java.util.List;

public class MainController {
    private final List<Person> persons = new ArrayList<>();

    public MainController() {
        // Tạo danh sách 10 Person mẫu
        persons.addAll(List.of(
                new Person("An", 16, "Male"),
                new Person("Bình", 25, "Female"),
                new Person("Cường", 65, "Male"),
                new Person("Dung", 12, "Female"),
                new Person("Em", 70, "Other"),
                new Person("Hạnh", 35, "Female"),
                new Person("Khoa", 45, "Male"),
                new Person("Lan", 17, "Female"),
                new Person("Minh", 61, "Male"),
                new Person("Ngọc", 80, "Other")
        ));
    }

    public void classifyByAge() {
        persons.forEach(p -> {
            String group;
            int age = p.getAge();
            if (age < 18) {
                group = "Trẻ em";
            } else if (age <= 60) {
                group = "Người lớn";
            } else {
                group = "Người cao tuổi";
            }
            System.out.println(p.getName() + " thuộc nhóm: " + group);
        });
    }

    public void printAverageAge() {
        double avg = persons.stream()
                .mapToInt(Person::getAge)
                .average()
                .orElse(0);
        System.out.println("Tuổi trung bình: " + avg);
    }


}

