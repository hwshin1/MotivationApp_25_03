package org.example.motivation.controller;

import org.example.Container;
import org.example.motivation.entity.Motivation;
import org.example.motivation.service.MotivationService;

public class MotivationController {
    private final MotivationService motivationService;

    public MotivationController() {
        motivationService = new MotivationService();
    }

    public void add() {
        System.out.print("Content : ");
        String content = Container.getScanner().nextLine();
        System.out.print("Source : ");
        String source = Container.getScanner().nextLine();

        int id = motivationService.add(content, source);

        System.out.printf("%d 번 Motivation이 등록 되었습니다.\n", id);
    }

    public void list() {
        motivationService.list();
    }

    public void delete(String cmd) {
        int id = Integer.parseInt(cmd.split(" ")[1]);

        int foundIndex = motivationService.getIndexById(id);

        if (foundIndex == -1) {
            System.out.println("해당 등록된 글이 없습니다.");
            return;
        }

        motivationService.doDelete(foundIndex);
        System.out.println(id + "번이 삭제되었습니다.");
    }

    public void modify(String cmd) {
        int id = 0;

        try {
            id = Integer.parseInt(cmd.split(" ")[1]);
        } catch (Exception e) {
            System.out.println("명령어를 확인해주세요.");
            return;
        }

        Motivation foundMotivation = motivationService.findId(id);

        if (foundMotivation == null) {
            System.out.println("해당 등록된 글이 없습니다.");
            return;
        }

        motivationService.doModify(foundMotivation);
        System.out.println(id + "번 수정되었습니다.");
    }
}
