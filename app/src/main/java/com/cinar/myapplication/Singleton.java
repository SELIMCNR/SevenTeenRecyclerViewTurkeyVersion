package com.cinar.myapplication;

public class Singleton {
//Singleton her zaman aynı objeyi oluşturur.

  private  Landmark setLandmark;
  private  static  Singleton singleton;
     private  Singleton() {

    }

    public Landmark getSetLandmark() {
        return setLandmark;
    }

    public void setSetLandmark(Landmark setLandmark) {
        this.setLandmark = setLandmark;
    }
    public  static  Singleton getInstance(){
         if (singleton == null){
             singleton = new Singleton();
         }
        return  singleton;
    }
}
