package org.example;

import org.example.motivation.controller.MotivationController;
import org.example.system.SystemController;

public class App {
    public void run() {
        System.out.println("== Motivation 실행 ==");

        SystemController systemController = new SystemController();
        MotivationController motivationController = new MotivationController();

        while (true) {
            System.out.print("명령어 ) ");
            String cmd = Container.getScanner().nextLine().trim();

            if (cmd.equals("exit")) {
                systemController.exit();
                break;
            } else if (cmd.isEmpty()) {
                System.out.println("명령어가 입력되지 않았습니다.");
                continue;
            }

            if (cmd.equals("add")) {
                motivationController.add();
            } else if (cmd.equals("list")) {
                motivationController.list();
            } else if (cmd.startsWith("delete?")) {
                motivationController.newDelete(cmd);
            } else if (cmd.startsWith("delete")) {
                motivationController.delete(cmd);
            } else if (cmd.startsWith("modify")) {
                motivationController.modify(cmd);
            } else {
                System.out.println("사용할 수 없는 명령어 입니다.");
            }
        }
    }
}
