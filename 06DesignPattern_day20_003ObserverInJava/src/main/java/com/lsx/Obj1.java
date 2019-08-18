package com.lsx;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Obj1 extends Observable {

    private Integer temp;
    private List<Observer> list;



    public Obj1() {
    }

    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o);
    }

    @Override
    public synchronized void deleteObserver(Observer o) {
        super.deleteObserver(o);
    }

    @Override
    public void notifyObservers() {
        super.notifyObservers(temp);
    }

    @Override
    public void notifyObservers(Object arg) {
        super.notifyObservers(arg);
    }

    @Override
    public synchronized void deleteObservers() {
        super.deleteObservers();
    }

    @Override
    protected synchronized void setChanged()
    {
        super.setChanged();
    }

    public void setTemp(Integer temp) {
        this.temp = temp;
        setChanged();
        notifyObservers();
    }
}
