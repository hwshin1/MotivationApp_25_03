package org.example.motivation.service;

import org.example.Container;
import org.example.motivation.entity.Motivation;

import java.util.ArrayList;
import java.util.List;

public class MotivationService {
    List<Motivation> motivations;
    int lastId;

    public MotivationService() {
        motivations = new ArrayList<>();
        lastId = 0;
    }

    public int add(String content, String source) {
        int id = lastId + 1;

        Motivation moty = new Motivation(id, content, source);
        motivations.add(moty);

        lastId++;
        return id;
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

    public int getIndexById(int id) {
        int foundIndex = -1;
        for (int i = 0; i < motivations.size(); i++) {
            Motivation motivation = motivations.get(i);
            if (motivation.getId() == id) {
                foundIndex = i;
                break;
            }
        }
        return foundIndex;
    }

    public void doDelete(int foundIndex) {
        foundIndex = getIndexById(foundIndex);
        motivations.remove(foundIndex);
    }

    public Motivation findId(int id) {
        for (Motivation motivation : motivations) {
            if (motivation.getId() == id) {
                return motivation;
            }
        }
        return null;
    }


    public void doModify(Motivation foundMotivation) {
        System.out.println("Content: " + foundMotivation.getContent());
        System.out.println("Source: " + foundMotivation.getSource());

        String newContent;
        String newSource;

        while (true) {
            System.out.print("new Content : ");
            newContent = Container.getScanner().nextLine();

            if (!newContent.isEmpty()) {
                break;
            }

            System.out.println("수정할 Content를 입력해주세요.");
        }

        while (true) {
            System.out.print("new Source : ");
            newSource = Container.getScanner().nextLine();

            if (!newSource.isEmpty()) {
                break;
            }

            System.out.println("수정할 Source를 입력해주세요.");
        }

        foundMotivation.setContent(newContent);
        foundMotivation.setSource(newSource);
    }
}
