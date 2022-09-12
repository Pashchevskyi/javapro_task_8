package ua.ithillel.lms;

import ua.ithillel.lms.javapro.pavlopashchevskyi.task8.ArrayValueCalculator;
import ua.ithillel.lms.javapro.pavlopashchevskyi.task8.exception.ArrayDataException;
import ua.ithillel.lms.javapro.pavlopashchevskyi.task8.exception.ArraySizeException;

public class Main {

  public static void main(String[] args) {
    ArrayValueCalculator avc = new ArrayValueCalculator();
    String strAllCorrectMatrix[][] = {
        {"1", "2", "3", "4"},
        {"5", "6", "7", "8"},
        {"9", "10", "11", "12"},
        {"13", "14", "15", "16"}
    };
    String strIncorrectRowsMatrix[][] = {
        {"1", "2", "3", "4"},
        {"5", "6", "7", "8"},
        {"9", "10", "11", "12"}
    };
    String strIncorrectColumnsMatrix[][] = {
        {"1", "2", "3", "4"},
        {"5", "6", "7"},
        {"8", "9", "10", "11"},
        {"12", "13", "14", "15"}
    };
    String strIncorrectDataMatrix[][] = {
        {"1", "2", "3", "4"},
        {"5", "6", "7", "8"},
        {"9", "10a", "11", "12"},
        {"13", "14", "15", "16"}
    };
    try {
      //test case: all is correct
      int S = avc.doCalc(strAllCorrectMatrix);
      System.out.println("Sum of matrix: " + S);
      //end test case: all is correct
      //test case: rows count is incorrect
      S = avc.doCalc(strIncorrectRowsMatrix);
      System.out.println("Sum of matrix: " + S);
      //end test case: rows count is incorrect
      //test case: columns count is incorrect
      S = avc.doCalc(strIncorrectColumnsMatrix);
      System.out.println("Sum of matrix: " + S);
      //end test case: columns count is incorrect
      //test case: strings matrix data is incorrect
      S = avc.doCalc(strIncorrectDataMatrix);
      System.out.println("Sum of matrix: " + S);
      //end test case: strings matrix data is incorrect
    } catch (ArraySizeException | ArrayDataException e) {
      System.out.println(e.getMessage());
    }
  }
}
