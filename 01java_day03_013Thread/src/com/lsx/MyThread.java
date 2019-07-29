package com.lsx;

public class MyThread extends Thread{
    private String myname;

    @Override
    public void run() {
        int i = 20;
        while(i>0) {
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.getMyname() +"==>" + i);
            i--;
        }
    }

    public String getMyname() {
        return myname;
    }

    public void setMyname(String myname) {
        this.myname = myname;
    }

    public MyThread(String name, String myname) {
        super(name);
        this.myname = myname;
    }


}
