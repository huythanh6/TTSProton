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
                0. Thoát
                """);
            System.out.print("Chọn: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> controller.classifyByAge();
                case 2 -> controller.printAverageAge();
                case 0 -> System.out.println("Thoát.");
                default -> System.out.println("Không hợp lệ.");
            }

        } while (choice != 0);
    }

}