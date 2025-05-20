package com.orm;

import controller.MainController;
import entity.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MainController controller = new MainController();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("""
                === MENU ===
                1. Phân loại theo độ tuổi
                2. Tính tuổi trung bình
                3. Tìm người lớn/nhỏ tuổi nhất
                4. Đếm theo giới tính
                5. Thêm Person từ console
                6. Sắp xếp theo tuổi
                7. Tìm người theo tên
                8. Greet theo giới tính
                0. Thoát
                """);
            System.out.print("Chọn: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> controller.classifyByAge();
                case 2 -> controller.printAverageAge();
                case 3 -> controller.findOldestAndYoungest();
                case 4 -> controller.countByGender();
                case 5 -> controller.addPersonFromConsole();
                case 6 -> controller.sortByAge();
                case 7 -> {
                    System.out.print("Nhập tên: ");
                    String name = sc.nextLine();
                    controller.searchByName(name);
                }
                case 8 -> controller.greetByGender();
                case 0 -> System.out.println("Thoát.");
                default -> System.out.println("Không hợp lệ.");
            }

        } while (choice != 0);
    }

}