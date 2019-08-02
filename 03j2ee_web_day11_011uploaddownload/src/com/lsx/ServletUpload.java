package com.lsx;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet("/upload")
public class ServletUpload extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*
        -----------------------------18514513125136
        Content-Disposition: form-data; name="file"; filename="php.txt"
        Content-Type: text/plain

        ×èÈû
        ÖÕ¶Ë
        Ð­µ÷
        notfiy / notifyall
        join
        setpriority
        interrupt
        isalive


        yield
        holdLock(object x)



        thread synchronization
        interthread communication
        handling thread deadlock
        major thread operation


        ÔÚµ÷ÓÃwaitµÄÊ±ºò£¬Ïß³Ì×Ô¶¯ÊÍ·ÅÆäÕ¼ÓÐµÄ¶ÔÏóËø£¬Í¬Ê±²»»áÈ¥ÉêÇë¶ÔÏóËø

        1.ÀÏ°å×ö°ü×Ó  ¹Ë¿Í³Ô°ü×Ó Ð­µ÷  À´»Ø

        Ïß³Ìµ÷¶È
        Ïß³ÌÖÐ¶Ï
        Ïß³ÌÍ¨ÐÅ
        java µÄÊµÏÖ¿ò¼Ü
        https://www.jianshu.com/p/6fd5bc61d1ed


        Ê²Ã´ÊÇxpath file DOM

        java.lang
        java.util
        java.io
        java.concurrent
        java.sql


        ÎªÊ²Ã´ÒªÓÃ»º³åÁ÷

        -----------------------------18514513125136
        Content-Disposition: form-data; name="name"

        name
        -----------------------------18514513125136
        Content-Disposition: form-data; name="password"

        password
        -----------------------------18514513125136--
         */

        request.setCharacterEncoding("utf-8");

        boolean ismultipart = ServletFileUpload.isMultipartContent(request);
        PrintWriter writer = response.getWriter();
        if(!ismultipart) {
            writer.write("form 必须是 multipart ！");
            writer.flush();
            writer.close();
        }

        //
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // set factory constrains
        // size
        // reposit

        ServletContext context = this.getServletConfig().getServletContext();
        String path2 = context.getRealPath("/");
        File rep = new File(path2);
        factory.setRepository(rep);

        // createa a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);
        // size limit

        // parst the request
        try {
            List<FileItem> item = upload.parseRequest(request);

            Iterator<FileItem> iterator = item.iterator();
            while(iterator.hasNext()) {
                FileItem next = iterator.next();
                if(!next.isFormField()) {
                    // process file
                    String fieldname = next.getFieldName();
                    String filename = next.getName();
                    String contenttype = next.getContentType();
                    boolean isInMem = next.isInMemory();
                    long sizeinbyte = next.getSize();

                    System.out.println("fieldName :" + fieldname);
                    System.out.println("filename :" + filename);
                    System.out.println("content type :" + contenttype);


                    String realPath = context.getRealPath("/");
                    String[] split = filename.split("\\.");
                    String newfilename = "";
                    for (int i = 0; i < split.length-1; i++) {
                        newfilename+=split[i];
                    }

                    System.out.println("new file name :" + newfilename);
                    File uploadFile = new File(realPath+File.separator+newfilename+ UUID.randomUUID()+"."+split[split.length-1]);

                    next.write(uploadFile);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        writer.write("success");
        writer.close();
        //

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
