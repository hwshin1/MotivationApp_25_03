package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    Scanner sc;

    public App(Scanner sc) {
        this.sc = sc;
    }

    public void run() {
        System.out.println("== Motivation 실행 ==");

        int lastId = 0;
        List<Motivation> motivations = new ArrayList<>();

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
                int id = lastId + 1;
                System.out.print("Motivation : ");
                String motivation = sc.nextLine();
                System.out.print("Source : ");
                String source = sc.nextLine();
                System.out.printf("%d 번 Motivation이 등록 되었습니다.\n", id);

                Motivation moty = new Motivation(id, motivation, source);
                motivations.add(moty);

                lastId++;
            } else if (cmd.equals("list")) {
                System.out.println("=".repeat(40));
                System.out.println("   번호   /   Source   /   Motivation   ");

                if (motivations.size() == 0) {
                    System.out.println("등록된 Motivation이 없습니다.");
                } else {
                    System.out.println("등록된 Motivation이 있습니다.");
                }
                System.out.println("=".repeat(40));
            }
        }
    }
}

class Motivation {
    int id;
    String motivation;
    String source;

    public Motivation(int id, String motivation, String source) {
        this.id = id;
        this.motivation = motivation;
        this.source = source;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMotivation() {
        return motivation;
    }

    public void setMotivation(String motivation) {
        this.motivation = motivation;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
