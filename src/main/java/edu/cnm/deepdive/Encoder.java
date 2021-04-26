package edu.cnm.deepdive;

import java.util.LinkedList;
import java.util.List;

/**
 * Run-length encoding (RLE) is a simple, lossless compression technique that, while not nearly as
 * effective or general-purpose as more advanced techniques, is relatively straightforward to
 * implement, and works reasonably well for some types of data.
 *
 * In its simplest form, RLE replaces a sequence of repeated values with a count, value pair. For
 * example, consider the following input data:
 *
 *     byte[] data = {1, 1, 1, 1, 4, 4, 4, 3, 3, 3, 3, 3, 2, 2};
 *
 * An RLE-based equivalent representation might be
 *
 *     {4, 1, 3, 4, 5, 3, 2, 2}
 *
 * In the second array, the initial pair of values, 4 and 1, indicate that the source data contains
 * a sequence of 4 occurrences of the value 1; following that, we have a sequence of 3 occurrences
 * of the value 4, then a sequence of 5 occurrences of 3, and finally 2 occurrences of 2.
 *
 * For this problem, you’ll implement one method that RLE-encodes, and another that decodes.
 */
public class Encoder {

  /**
   * Condense byte array data into a run-length encoded equivalent.
   *
   * @param data The data to be encoded
   * @return The encoded data
   */
  public byte[] encode(byte[] data) {
    List<Byte> workingList = new LinkedList<>();
    int sequenceStart = 0;
    int i = 1;
    while (i <= data.length) {
      if (i == data.length || data[sequenceStart] != data[i]) {
        workingList.add((byte) (i - sequenceStart));
        workingList.add(data[sequenceStart]);
        sequenceStart = i;
      }
      i++;
    }
    return listToByteArray(workingList);
  }

  /**
   * Inflate run-length encoded data into a normal equivalent.
   *
   * @param data The encoded data
   * @return The decoded data
   */
  public byte[] decode(byte[] data) {
    List<Byte> workingList = new LinkedList<>();
    int workingIndex = 0;
    for (int i = 0; i < data.length; i += 2) {
      int startingLocation = workingIndex;
      for (; workingIndex < startingLocation + data[i]; workingIndex++) {
        workingList.add(data[i + 1]);
      }
    }
    return listToByteArray(workingList);
  }

  private byte[] listToByteArray(List<Byte> data) {
    byte[] output = new byte[data.size()];
    for (int j = 0; j < data.size(); j++) {
      output[j] = data.get(j);
    }
    return output;
  }
}
