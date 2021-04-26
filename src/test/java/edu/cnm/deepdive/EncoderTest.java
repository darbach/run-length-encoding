package edu.cnm.deepdive;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class EncoderTest {

  private Encoder encoder = new Encoder();


  @ParameterizedTest(name = "[{index}]Asserting encode({0}) == {1}")
  @MethodSource(value = "encode")
  void encode(byte[] input, byte[] expected) {
    assertArrayEquals(expected, encoder.encode(input));
  }

  @ParameterizedTest(name = "[{index}]Asserting decode({0}) == {1}")
  @MethodSource(value = "decode")
  void decode(byte[] input, byte[] expected) {
    assertArrayEquals(expected, encoder.decode(input));
  }

  static Stream<Arguments> encode() {
    return Stream.of(
        Arguments.of(new byte[]{1, 1, 1, 1, 4, 4, 4, 3, 3, 3, 3, 3, 2, 2},
            new byte[]{4, 1, 3, 4, 5, 3, 2, 2})
    );
  }

  static Stream<Arguments> decode() {
    return Stream.of(
        Arguments.of(new byte[]{4, 1, 3, 4, 5, 3, 2, 2},
            new byte[]{1, 1, 1, 1, 4, 4, 4, 3, 3, 3, 3, 3, 2, 2})
    );
  }

}