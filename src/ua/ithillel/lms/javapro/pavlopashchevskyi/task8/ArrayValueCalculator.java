package ua.ithillel.lms.javapro.pavlopashchevskyi.task8;

import ua.ithillel.lms.javapro.pavlopashchevskyi.task8.exception.ArrayDataException;
import ua.ithillel.lms.javapro.pavlopashchevskyi.task8.exception.ArraySizeException;

public class ArrayValueCalculator {

  public int doCalc(String[][] strMatrix) throws ArraySizeException, ArrayDataException {
    if (strMatrix.length != 4) {
      throw new ArraySizeException(
          "Matrix of strings transferred must have only 4 rows, but you've transferred "
              + strMatrix.length
      );
    }
    int S = 0;
    for (int i = 0; i < strMatrix.length; i++) {
      if (strMatrix[i].length != 4) {
        throw new ArraySizeException(
            "Matrix of strings transferred must have only 4 columns, but you've transferred " +
                strMatrix[i].length + " at least in row " + (i + 1)
        );
      }
      for (int j = 0; j < strMatrix[i].length; j++) {
        try {
          S += Integer.parseInt(strMatrix[i][j]);
        } catch (NumberFormatException e) {
          throw new ArrayDataException(strMatrix, i, j);
        }
      }
    }
    return S;
  }
}
