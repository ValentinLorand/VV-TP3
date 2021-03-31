package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {

  @Test
  void testCreationDate() throws Exception {
      Date result = new Date(10, 03, 1999);
      assertTrue(result instanceof Date);
  }

  @Test
  void testCreationDate2() throws Exception {
      assertThrows(Exception.class, () -> new Date(-1, 03, 1999));
      assertThrows(Exception.class, () -> new Date(30, 02, 1999));
      assertThrows(Exception.class, () -> new Date(31, 06, 1999));
      assertThrows(Exception.class, () -> new Date(00, 00, 0000));
      assertDoesNotThrow(() -> new Date(01, 01, 0000));
      assertDoesNotThrow(() -> new Date(01, 01, 00001));
  }

  @Test
  void testLeapYear() throws Exception {
    assertTrue(Date.isLeapYear(2020));
    assertTrue(Date.isLeapYear(2024));
    assertFalse(Date.isLeapYear(2021));
    assertTrue(Date.isLeapYear(4000));
  }

  @Test
  void testValidDate() throws Exception {
    assertTrue(Date.isValidDate(01, 01, 2020));
    assertFalse(Date.isValidDate(00, 00, 2020));
    assertTrue(Date.isValidDate(01, 06, 0000));
    assertFalse(Date.isValidDate(30, 02, 5000));
    assertTrue(Date.isValidDate(29, 02, 2020));
  }

  @Test
  void testNextDate() throws Exception {
    Date d = new Date(31,03,2021);
    assertEquals(d.nextDate(), new Date(01,04,2021));
    assertEquals(d.nextDate().nextDate(), new Date(02,04,2021));

    Date d2 = new Date(30,12,0001);
    assertEquals(d2.nextDate(), new Date(31,12,0001));
    assertEquals(d2.nextDate().nextDate(), new Date(01,01,0002));
  }

  @Test
  void testPreviousDate() throws Exception {
    Date d = new Date(31,03,2021);
    assertEquals(d.previousDate(), new Date(30,03,2021));
    assertEquals(d.previousDate().previousDate(), new Date(29,03,2021));

    Date d2 = new Date(02,01,0001);
    assertEquals(d2.previousDate(), new Date(01,01,0001));
    assertEquals(d2.previousDate().previousDate(), new Date(31,12,0000));

    Date d3 = new Date(01,03,0001);
    assertEquals(d3.previousDate(), new Date(28,02,0001));

    Date d4 = new Date(01,03,12);
    assertEquals(d4.previousDate(), new Date(29,02,12));
  }

  @Test
  void testCompareDate() throws Exception {
    Date d1 = new Date(30,01,0001);
    Date d2 = new Date(02,01,0001);
    Date d3 = new Date(02,01,0001);
    assertEquals(d2.compareTo(d3), 0);
    assertEquals(d1.compareTo(d2), 28);
    assertEquals(d2.compareTo(d1), -28);
  }

}