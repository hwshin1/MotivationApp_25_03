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
                System.out.printf("   %d   /   %s   /   %s   \n", motivation.getId(), motivation.getSource().substring(0, 5) + "...", motivation.getContent());
                continue;
            }
            System.out.printf("   %d   /   %s   /   %s   \n", motivation.getId(), motivation.getSource(), motivation.getContent());
        }

        System.out.println("=".repeat(40));
    }

    public void delete(String cmd) {
        int id = Integer.parseInt(cmd.split(" ")[1]);

        Motivation foundMotivation = null;
        int foundIndex = -1;

        for (int i = 0; i < motivations.size(); i++) {
            Motivation motivation = motivations.get(i);
            if (motivation.getId() == id) {
                foundMotivation = motivation;
                foundIndex = i;
                break;
            }
        }

        if (foundMotivation == null) {
            System.out.println("해당 등록된 글이 없습니다.");
            return;
        }

        motivations.remove(foundIndex);
        System.out.println(id + "번이 삭제되었습니다.");
    }

    // 명령어 : delete?id=1
    public void newDelete(String cmd) {
        Rq rq = new Rq(cmd);

        System.out.println("rq.getParams(\"id\") : " + rq.getParams("id"));

        int id = Integer.parseInt(rq.getParams("id"));

        Motivation foundMotivation = null;

        for (Motivation motivation : motivations) {
            if (motivation.getId() == id) {
                foundMotivation = motivation;
                break;
            }
        }

        if (foundMotivation == null) {
            System.out.println("해당 등록된 글이 없습니다.");
            return;
        }

        motivations.remove(foundMotivation);
        System.out.println(id + "번이 삭제되었습니다.");
    }
}
