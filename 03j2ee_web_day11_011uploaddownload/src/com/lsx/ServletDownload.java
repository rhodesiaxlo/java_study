package com.lsx;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/download")
public class ServletDownload extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取文件项目路径
        // 获取文件的真实路径

        // 设置 disposition-type
        // 字节流输出
        request.setCharacterEncoding("utf-8");

        String filepath = request.getParameter("path");
        ServletContext context = request.getServletContext();
        String filefullpath = context.getRealPath(filepath);

        FileInputStream fis = new FileInputStream(filefullpath);

        response.setHeader("content-type", context.getMimeType(filefullpath));
        response.setHeader("content-disposition","attachment;filename="+filepath);

        ServletOutputStream os = response.getOutputStream();

        BufferedInputStream bis = new BufferedInputStream(fis);

        int len = 0;
        byte[] buffer = new byte[1024];
        while((len=bis.read(buffer))!=-1) {
            // 写入读入数据
            os.write(buffer, 0, len);
        }

        os.close();
        bis.close();


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
