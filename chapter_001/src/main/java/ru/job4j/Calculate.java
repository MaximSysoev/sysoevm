package ru.job4j;

/**
* Class Calculate.
*/
public class Calculate {
   /**
   * Method echo.
   * @param name Your name.
   * @return Echo plus your name.
   */
   public String echo(String name) {
      return "Echo, echo, echo : " + name;
   }

   /**
   * Method Hello world.
   * @param args String[].
   */

   public static void main(String[] args) {
      /*System.out.println("Hello World");*/
      Integer value = 1;
      Calculate.change(value);
      System.out.println(value);
   }

   public static void change(Integer that) {
      that++;
   }
}