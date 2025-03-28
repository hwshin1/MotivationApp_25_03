package org.example.motivation.controller;

import org.example.motivation.entity.Motivation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MotivationController {
    Scanner sc;
    int lastId = 0;
    List<Motivation> motivations = new ArrayList<>();

    public MotivationController(Scanner sc) {
        this.sc = sc;
    }

    public void add() {
        int id = lastId + 1;
        System.out.print("Content : ");
        String content = sc.nextLine();
        System.out.print("Source : ");
        String source = sc.nextLine();
        System.out.printf("%d 번 Motivation이 등록 되었습니다.\n", id);

        Motivation moty = new Motivation(id, content, source);
        motivations.add(moty);

        lastId++;
    }

    public void list() {
        if (motivations.isEmpty()) {
            System.out.println("등록된 Motivation이 없습니다.");
        }

        System.out.println("=".repeat(40));
        System.out.println("   번호   /   Source   /   Content   ");

        for (int i = motivations.size() - 1; i >= 0; i--) { // 출력 될 때 역순으로 출력
            Motivation motivation = motivations.get(i);

            if (motivation.getSource().length() > 7) {
                // Source 출력 때 길이가 7보다 길면 ... 으로 표시해준다.
                System.out.printf("   %d   /   %s   /   %s   \n", motivation.getId(), motivation.getSource().substring(0,5) + "...", motivation.getContent());
                continue;
            }
            System.out.printf("   %d   /   %s   /   %s   \n", motivation.getId(), motivation.getSource(), motivation.getContent());
        }

        System.out.println("=".repeat(40));
    }
}
