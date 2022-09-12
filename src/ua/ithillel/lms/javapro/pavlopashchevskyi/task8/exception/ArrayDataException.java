package ua.ithillel.lms.javapro.pavlopashchevskyi.task8.exception;

public class ArrayDataException extends Exception {

  public ArrayDataException(String[][] strMatrix, int i, int j) {
    super(
        "Incorrect strings matrix item " + strMatrix[i][j] + " at least in row#" + (i + 1) +
            " and column#" + (j + 1)
    );
  }
}
