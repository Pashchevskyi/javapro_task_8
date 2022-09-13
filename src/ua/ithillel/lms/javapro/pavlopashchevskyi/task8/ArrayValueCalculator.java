package ua.ithillel.lms.javapro.pavlopashchevskyi.task8;

import ua.ithillel.lms.javapro.pavlopashchevskyi.task8.exception.ArrayDataException;
import ua.ithillel.lms.javapro.pavlopashchevskyi.task8.exception.ArraySizeException;
import ua.ithillel.lms.javapro.pavlopashchevskyi.task8.validator.StringMatrixValidator;

public class ArrayValueCalculator {

  public int doCalc(String[][] strMatrix) throws ArraySizeException, ArrayDataException {
    StringMatrixValidator.validate(strMatrix, 4, 4);
    int S = 0;
    for (int i = 0; i < strMatrix.length; i++) {
      for (int j = 0; j < strMatrix[i].length; j++) {
        S += Integer.parseInt(strMatrix[i][j]);
      }
    }

    return S;
  }
}
