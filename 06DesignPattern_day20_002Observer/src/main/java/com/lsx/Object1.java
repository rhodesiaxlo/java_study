package com.lsx;

import java.util.ArrayList;
import java.util.List;

public class Object1 {
    private Integer temp;
    private List<IObser> list = new ArrayList<IObser>();

    public Object1(Integer temp, List<IObser> list) {
        this.temp = temp;
        this.list = list;
    }

    public Object1() {
    }

    void registerObser(IObser o){
        list.add(o);
    }

    void removeObser(IObser o) {
        list.remove(o);
    }

    /**
     * 实践
     */
    void measureChanged(){
        notifyOthers();
    }

    void notifyOthers(){

        for (IObser iObser : list) {
            iObser.update(temp);
        }
    }



    public void setTemp(Integer temp) {
        this.temp = temp;
        measureChanged();
    }
}
