package com.netease.kaola.banka.boot;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by hzwangqiqing
 * on 2018/7/27.
 */
public class ContextStartSuccessListener implements ApplicationListener<ApplicationEvent> {
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ContextRefreshedEvent) {
            printHelloWorld();
        }
    }

    private void printHelloWorld() {
        BufferedImage image = new BufferedImage(244, 32, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setFont(new Font("Dialog", Font.PLAIN, 12));
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics.drawString("HELLO WORLD BANKA", 6, 24);

        for (int y = 0; y < 32; y++) {
            StringBuilder sb = new StringBuilder();
            for (int x = 0; x < 244; x++) {
                sb.append(image.getRGB(x, y) == -16777215 ? " " : image.getRGB(x, y) == -1 ? "#" : "*");
            }
            System.out.println(sb);
        }
    }
}
