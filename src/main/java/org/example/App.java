package org.example;

import java.util.Scanner;

public class App {
    Scanner sc;

    public App(Scanner sc) {
        this.sc = sc;
    }

    int lastId = 1;

    public void run() {
        System.out.println("== Motivation 실행 ==");

        while (true) {
            System.out.print("명령어 ) ");
            String cmd = sc.nextLine().trim();

            if (cmd.equals("exit")) {
                System.out.println("== Motivation 종료 ==");
                break;
            } else if (cmd.length() == 0) {
                System.out.println("명령어가 입력되지 않았습니다.");
                continue;
            }

            if (cmd.equals("add")) {
                System.out.print("Motivation : ");
                String motivation = sc.nextLine();
                System.out.print("Source : ");
                String source = sc.nextLine();
                System.out.printf("%d 번 Motivation이 등록 되었습니다.\n", lastId);
                lastId++;
            } else if (cmd.equals("list")) {
                System.out.println("=".repeat(40));
                System.out.println("   번호   /   Source   /   Motivation   ");
            }
        }
    }
}