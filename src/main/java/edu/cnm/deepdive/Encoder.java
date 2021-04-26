package edu.cnm.deepdive;

import java.util.LinkedList;
import java.util.List;

public class Encoder {

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
    byte[] output = new byte[workingList.size()];
    for (int j = 0; j < workingList.size(); j++) {
      output[j] = workingList.get(j);
    }
    return output;
  }

}
