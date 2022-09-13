package ua.ithillel.lms.javapro.pavlopashchevskyi.task8.validator;

import java.util.Map;
import ua.ithillel.lms.javapro.pavlopashchevskyi.task8.exception.ArrayDataException;
import ua.ithillel.lms.javapro.pavlopashchevskyi.task8.exception.ArraySizeException;

public class StringMatrixValidator {

  public static void validate(String[][] stringMatrix, int legalRowsQ, int legalColumnsQ) {
    validateRowsQuantity(stringMatrix, legalRowsQ);
    validateColumnsQuantity(stringMatrix, legalColumnsQ);
    validateClauses(stringMatrix);
  }

  private static void validateRowsQuantity(String stringMatrix[][], int valueToCompare) {
    if (stringMatrix.length != valueToCompare) {
      throw new ArraySizeException(
          "Matrix of strings transferred must have only 4 rows, but you've transferred "
              + stringMatrix.length);
    }
  }

  private static void validateColumnsQuantity(String stringMatrix[][], int valueToCompare) {
    int incorrectColumnsQuantity = 0;
    int incorrectRows[] = new int[stringMatrix.length];
    int incorrectColumnQuantities[] = new int[stringMatrix.length];
    StringBuilder sb = new StringBuilder();
    sb.append("Matrix of strings transferred must have only ");
    sb.append(valueToCompare);
    sb.append(" columns, but you have ");
    for (int i = 0; i < stringMatrix.length; i++) {
      if (stringMatrix[i].length != 4) {
        incorrectRows[incorrectColumnsQuantity] = i + 1;
        incorrectColumnQuantities[incorrectColumnsQuantity] = stringMatrix[i].length;
        incorrectColumnsQuantity++;
      }
    }
    for (int k = 0; k < incorrectColumnsQuantity; k++) {
      sb.append(incorrectColumnQuantities[k]);
      sb.append(" columns in row#");
      sb.append(incorrectRows[k]);
      sb.append((k < incorrectColumnsQuantity - 1) ? ", " : ".");
    }
    if (incorrectColumnsQuantity > 0) {
      throw new ArraySizeException(sb.toString());
    }
  }

  private static void validateClauses(String stringMatrix[][]) {
    int incorrectClausesQuantity = 0;
    StringBuilder sb = new StringBuilder();
    sb.append("Incorrect strings matrix items:\n");
    for (int i = 0; i < stringMatrix.length; i++) {
      for (int j = 0; j < stringMatrix[i].length; j++) {
        try {
          Integer.parseInt(stringMatrix[i][j]);
        } catch (NumberFormatException e) {
          incorrectClausesQuantity++;
          sb.append(stringMatrix[i][j]);
          sb.append(" in row#");
          sb.append(i + 1);
          sb.append(" and column#");
          sb.append(j + 1);
          sb.append("\n");
        }
      }
    }
    if (incorrectClausesQuantity > 0) {
      throw new ArrayDataException(sb.toString());
    }
  }
}
