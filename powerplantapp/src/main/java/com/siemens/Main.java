package com.siemens;

public class Main {
    public static void main(String[] args) {
        String name="Parameswari";
        //runnable
       Runnable runnable=()->{
          for(char ch : name.toCharArray())
          {
              System.out.print(ch);
              try {
                  Thread.sleep(1500);
              } catch (InterruptedException e) {
                  throw new RuntimeException(e);
              }
          }
       } ;
       Thread thread=new Thread(runnable);
       thread.start();


    }
}