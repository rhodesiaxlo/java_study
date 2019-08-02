package com.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/captcha")
public class CaptchaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 生成验证码
        BufferedImage image = new BufferedImage(200, 100, BufferedImage.TYPE_INT_RGB);

        // 美化图片
        Graphics g = image.getGraphics();
        g.setColor(Color.pink);
        g.fillRect(0,0,200, 100);

        // 增加边框
        g.setColor(Color.blue);
        g.drawRect(0, 0, 200-1, 100-1);

        String chars = "ABCDEFGHIGKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        Random random = new Random();
        int i;

        char c;
        StringBuilder sb = new StringBuilder();
        for (int j = 1; j <= 4; j++) {
            i = random.nextInt(chars.length());
            c= chars.charAt(i);

            sb.append(c);

            // 写入字符
            g.setColor(Color.black);
            g.drawString(c + "  ", 200/5*j, 100/2);

        }

        // 画线
        request.getSession().setAttribute("captcha", sb.toString());

        // 输出
        ImageIO.write(image, "jpg", response.getOutputStream());

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
