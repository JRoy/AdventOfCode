package io.github.jroy.advent.twentytwenty.dayeleven;

import io.github.jroy.advent.common.Utils;
import io.github.jroy.advent.common.graph.StandardGraph;

import java.io.IOException;

public class PartTwo {

  public static void main(String[] args) throws IOException {
    StandardGraph graph = new StandardGraph(Utils.getDayInput());
    int modifications = -1;
    while (modifications != 0) {
      modifications = PartOne.applyMutation(graph, 5, true);
    }
    System.out.println("Solution: " + PartOne.countOccupied(graph));
  }

  public static int countAdjRay(int startX, int startY, StandardGraph graph) {
    int count = 0;
    Character c = '#';

    //fuck you this is how im doing it
    int offset = 0;
    while (true) {
      Character character = graph.getCharAt((startX + 1) + offset, startY);

      // If it's null, we're out of bounds
      // If it's an empty seat, stop traversing
      if (character == null || character.equals('L')) {
        break;
      }

      if (c.equals(character)) {
        count++;
        break;
      }
      offset++;
    }

    offset = 0;
    while (true) {
      Character character = graph.getCharAt((startX - 1) - offset, startY);

      // If it's null, we're out of bounds
      // If it's an empty seat, stop traversing
      if (character == null || character.equals('L')) {
        break;
      }

      if (c.equals(character)) {
        count++;
        break;
      }
      offset++;
    }

    offset = 0;
    while (true) {
      Character character = graph.getCharAt(startX, (startY + 1) + offset);

      // If it's null, we're out of bounds
      // If it's an empty seat, stop traversing
      if (character == null || character.equals('L')) {
        break;
      }

      if (c.equals(character)) {
        count++;
        break;
      }
      offset++;
    }

    offset = 0;
    while (true) {
      Character character = graph.getCharAt(startX, (startY - 1) - offset);

      // If it's null, we're out of bounds
      // If it's an empty seat, stop traversing
      if (character == null || character.equals('L')) {
        break;
      }

      if (c.equals(character)) {
        count++;
        break;
      }
      offset++;
    }

    offset = 0;
    while (true) {
      Character character = graph.getCharAt((startX + 1) + offset, (startY + 1) + offset);

      // If it's null, we're out of bounds
      // If it's an empty seat, stop traversing
      if (character == null || character.equals('L')) {
        break;
      }

      if (c.equals(character)) {
        count++;
        break;
      }
      offset++;
    }

    offset = 0;
    while (true) {
      Character character = graph.getCharAt((startX - 1) - offset, (startY - 1) - offset);

      // If it's null, we're out of bounds
      // If it's an empty seat, stop traversing
      if (character == null || character.equals('L')) {
        break;
      }

      if (c.equals(character)) {
        count++;
        break;
      }
      offset++;
    }

    offset = 0;
    while (true) {
      Character character = graph.getCharAt((startX - 1) - offset, (startY + 1) + offset);

      // If it's null, we're out of bounds
      // If it's an empty seat, stop traversing
      if (character == null || character.equals('L')) {
        break;
      }

      if (c.equals(character)) {
        count++;
        break;
      }
      offset++;
    }

    offset = 0;
    while (true) {
      Character character = graph.getCharAt((startX + 1) + offset, (startY - 1) - offset);

      // If it's null, we're out of bounds
      // If it's an empty seat, stop traversing
      if (character == null || character.equals('L')) {
        break;
      }

      if (c.equals(character)) {
        count++;
        break;
      }
      offset++;
    }
    return count;
  }
}
