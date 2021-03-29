package fr.istic.vv;

import java.util.LinkedList;
import java.util.Queue;

public class BalancedString {

  public static Boolean isBalanced(String str) {

    Queue<Integer> q = new LinkedList<Integer>();

    for (int i =0; i< str.length(); i++) {
      //Cas ouvrant
      if(str.charAt(i) == '{') q.add(1);
      else if(str.charAt(i) == '[') q.add(2);
      else if(str.charAt(i) == '(') q.add(3);

      //Cas fermant
      else if(str.charAt(i) == '}') {
        int tmp = q.poll();
        if(tmp != 1) return null;
      }
      else if(str.charAt(i) == ']') {
        int tmp = q.poll();
        if(tmp != 2) return null;
      }
      else if(str.charAt(i) == ')') {
        int tmp = q.poll();
        if(tmp != 3) return null;
      }
    }

    if (q.size() != 0) return null;

    return true;
  }
}
