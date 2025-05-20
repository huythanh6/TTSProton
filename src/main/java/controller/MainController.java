package controller;

import entity.Person;

import java.util.*;
import java.util.stream.Collectors;

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
    public void findOldestAndYoungest() {
        Optional<Person> oldest = persons.stream().max(Comparator.comparingInt(Person::getAge));
        Optional<Person> youngest = persons.stream().min(Comparator.comparingInt(Person::getAge));

        oldest.ifPresent(p -> System.out.println("Người lớn tuổi nhất: " + p.getName() + " (" + p.getAge() + ")"));
        youngest.ifPresent(p -> System.out.println("Người nhỏ tuổi nhất: " + p.getName() + " (" + p.getAge() + ")"));
    }

    public void countByGender() {
        Map<String, Long> genderCount = persons.stream()
                .collect(Collectors.groupingBy(Person::getGender, Collectors.counting()));

        genderCount.forEach((gender, count) ->
                System.out.println("Giới tính: " + gender + " - Số lượng: " + count));
    }

    public void addPersonFromConsole() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập tên: ");
        String name = scanner.nextLine();

        System.out.print("Nhập tuổi: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // clear buffer

        System.out.print("Nhập giới tính (Male/Female/Other): ");
        String gender = scanner.nextLine();

        if (age > 0 && age < 120) {
            Person newPerson = new Person(name, age, gender);
            persons.add(newPerson);
            System.out.println("Đã thêm: " + newPerson);
        } else {
            System.out.println("Tuổi không hợp lệ!");
        }
    }

    public void sortByAge() {
        persons.sort(Comparator.comparingInt(Person::getAge));
        System.out.println("Danh sách đã sắp xếp theo tuổi:");
        persons.forEach(System.out::println);
    }

    public void searchByName(String keyword) {
        List<Person> result = persons.stream()
                .filter(p -> p.getName().toLowerCase().contains(keyword.toLowerCase()))
                .toList();

        if (result.isEmpty()) {
            System.out.println("Không tìm thấy ai tên chứa '" + keyword + "'");
        } else {
            System.out.println("Kết quả tìm kiếm:");
            result.forEach(System.out::println);
        }
    }

    public void greetByGender() {
        persons.forEach(p -> {
            switch (p.getGender()) {
                case "Male" -> System.out.println(p.getName() + ": Hey boy!");
                case "Female" -> System.out.println(p.getName() + ": Hey girl!");
                case "Other" -> System.out.println(p.getName() + ": Hey man!");
                default -> System.out.println(p.getName() + ": Unknown gender");
            }
        });
    }


}

