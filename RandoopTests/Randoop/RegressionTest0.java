package Randoop;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegressionTest0 {

    public static boolean debug = false;

    @Test
    public void test001() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test001");
        objects.ParkingSpace parkingSpace2 = new objects.ParkingSpace((int) (short) 100, "hi!");
        java.util.Date date3 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str4 = parkingSpace2.getDateString(date3);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: date must not be null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test002() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test002");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot4 = null;
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace7.setType("hi!");
        objects.Client client10 = null;
        businessLogic.Visit visit13 = new businessLogic.Visit((int) (byte) 0, date1, (int) (short) -1, (int) '4', parkingLot4, parkingSpace7, client10, (int) (short) 10, " -  (hi!)");
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str14 = visit13.getDateString();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: date must not be null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test003() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test003");
        objects.ParkingSpace parkingSpace2 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.setType("hi!");
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.update(parkingSpace7, true);
        java.util.Date date10 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean13 = parkingSpace2.isOccupied(date10, (-1), (int) (short) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: date must not be null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test004() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test004");
        businessLogic.Visit visit1 = businessLogic.Visit.getVisit("31/12/1969");
        org.junit.Assert.assertNull(visit1);
    }

    @Test
    public void test005() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test005");
        objects.ParkingSpace parkingSpace2 = new objects.ParkingSpace((int) (short) 100, "hi!");
        objects.Car car3 = parkingSpace2.removeCar();
        java.util.Date date5 = null;
        parkingSpace2.occupyTime((int) (byte) 0, date5, (int) (byte) 10, (int) (byte) -1);
        java.lang.Class<?> wildcardClass9 = parkingSpace2.getClass();
        org.junit.Assert.assertNull(car3);
        org.junit.Assert.assertNotNull(wildcardClass9);
    }

    @Test
    public void test006() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test006");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot4 = null;
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace7.setType("hi!");
        objects.Client client10 = null;
        businessLogic.Visit visit13 = new businessLogic.Visit((int) (byte) 0, date1, (int) (short) -1, (int) '4', parkingLot4, parkingSpace7, client10, (int) (short) 10, " -  (hi!)");
        java.lang.String str14 = visit13.getBookingID();
        objects.Client client15 = visit13.getClientDetail();
        // The following exception was thrown during execution in test generation
        try {
            java.util.Date date16 = visit13.getEndTime();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: date must not be null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "0" + "'", str14, "0");
        org.junit.Assert.assertNull(client15);
    }

    @Test
    public void test007() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test007");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot4 = null;
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace7.setType("hi!");
        objects.Client client10 = null;
        businessLogic.Visit visit13 = new businessLogic.Visit((int) (byte) 0, date1, (int) (short) -1, (int) '4', parkingLot4, parkingSpace7, client10, (int) (short) 10, " -  (hi!)");
        java.lang.String str14 = visit13.getBookingID();
        // The following exception was thrown during execution in test generation
        try {
            visit13.setBookingID("Available");
            org.junit.Assert.fail("Expected exception of type java.lang.NumberFormatException; message: For input string: \"Available\"");
        } catch (java.lang.NumberFormatException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "0" + "'", str14, "0");
    }

    @Test
    public void test008() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test008");
        java.util.Set<java.lang.String> strSet0 = businessLogic.PaymentSystem.getAllowedPaymentMethods();
        org.junit.Assert.assertNotNull(strSet0);
    }

    @Test
    public void test009() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test009");
        businessLogic.Visit visit1 = businessLogic.Visit.getVisit("hi!");
        org.junit.Assert.assertNull(visit1);
    }

    @Test
    public void test010() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test010");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot4 = null;
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace7.setType("hi!");
        objects.Client client10 = null;
        businessLogic.Visit visit13 = new businessLogic.Visit((int) (byte) 0, date1, (int) (short) -1, (int) '4', parkingLot4, parkingSpace7, client10, (int) (short) 10, " -  (hi!)");
        objects.ParkingLot parkingLot14 = visit13.getParkingLot();
        java.lang.String str15 = visit13.getFormattedStartTime();
        java.lang.String str16 = visit13.getLicence();
        org.junit.Assert.assertNull(parkingLot14);
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + "31/12/1969" + "'", str15, "31/12/1969");
        org.junit.Assert.assertEquals("'" + str16 + "' != '" + " -  (hi!)" + "'", str16, " -  (hi!)");
    }

    @Test
    public void test011() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test011");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot4 = null;
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace7.setType("hi!");
        objects.Client client10 = null;
        businessLogic.Visit visit13 = new businessLogic.Visit((int) (byte) 0, date1, (int) (short) -1, (int) '4', parkingLot4, parkingSpace7, client10, (int) (short) 10, " -  (hi!)");
        java.lang.String str14 = visit13.getBookingID();
        objects.Client client15 = visit13.getClientDetail();
        // The following exception was thrown during execution in test generation
        try {
            visit13.setEndTime(8);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: date must not be null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "0" + "'", str14, "0");
        org.junit.Assert.assertNull(client15);
    }

    @Test
    public void test012() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test012");
        objects.Manager manager2 = new objects.Manager(" -  (hi!)", "0");
    }

    @Test
    public void test013() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test013");
        businessLogic.SystemDatabaseFacade.addRevenue(100);
    }

    @Test
    public void test014() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test014");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot4 = null;
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace7.setType("hi!");
        objects.Client client10 = null;
        businessLogic.Visit visit13 = new businessLogic.Visit((int) (byte) 0, date1, (int) (short) -1, (int) '4', parkingLot4, parkingSpace7, client10, (int) (short) 10, " -  (hi!)");
        java.lang.String str14 = visit13.getBookingID();
        java.lang.String str15 = visit13.getLicence();
        java.lang.String str16 = visit13.getFormattedStartTime();
        objects.ParkingSpace parkingSpace19 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace19.setType("hi!");
        objects.ParkingSpace parkingSpace24 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace19.update(parkingSpace24, true);
        objects.Car car27 = parkingSpace24.getParkedCar();
        objects.Client client31 = null;
        objects.Car car32 = new objects.Car("", "", "hi!", client31);
        java.lang.String str33 = car32.toString();
        car32.setModel(" -  (hi!)");
        objects.FacultyMember facultyMember38 = new objects.FacultyMember("", " -  (hi!)");
        car32.setOwner((objects.Client) facultyMember38);
        boolean boolean40 = parkingSpace24.parkCar(car32);
        visit13.setParkingSpace(parkingSpace24);
        java.lang.String str42 = parkingSpace24.getBookingId();
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "0" + "'", str14, "0");
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + " -  (hi!)" + "'", str15, " -  (hi!)");
        org.junit.Assert.assertEquals("'" + str16 + "' != '" + "31/12/1969" + "'", str16, "31/12/1969");
        org.junit.Assert.assertNull(car27);
        org.junit.Assert.assertEquals("'" + str33 + "' != '" + " -  (hi!)" + "'", str33, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + boolean40 + "' != '" + true + "'", boolean40 == true);
        org.junit.Assert.assertEquals("'" + str42 + "' != '" + "" + "'", str42, "");
    }

    @Test
    public void test015() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test015");
        objects.ParkingSpace parkingSpace2 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.setType("hi!");
        java.lang.String str5 = parkingSpace2.getOccupiedString();
        parkingSpace2.unoccupy((int) (byte) -1);
        parkingSpace2.setEnabled(true);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "Available" + "'", str5, "Available");
    }

    @Test
    public void test016() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test016");
        objects.ParkingSpace parkingSpace2 = new objects.ParkingSpace((int) (short) 100, "hi!");
        boolean boolean3 = parkingSpace2.isOccupied();
        parkingSpace2.unoccupyTime((int) '#');
        java.lang.String str6 = parkingSpace2.getEnablesString();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "Enabled" + "'", str6, "Enabled");
    }

    @Test
    public void test017() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test017");
        objects.FacultyMember facultyMember5 = new objects.FacultyMember("", " -  (hi!)");
        objects.Car car6 = new objects.Car("Available", "Manager", "0", (objects.Client) facultyMember5);
        facultyMember5.setEmail("0");
        facultyMember5.setValidated(true);
    }

    @Test
    public void test018() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test018");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot4 = null;
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace7.setType("hi!");
        objects.Client client10 = null;
        businessLogic.Visit visit13 = new businessLogic.Visit((int) (byte) 0, date1, (int) (short) -1, (int) '4', parkingLot4, parkingSpace7, client10, (int) (short) 10, " -  (hi!)");
        java.lang.String str14 = visit13.getBookingID();
        java.lang.String str15 = visit13.getLicence();
        java.lang.String str16 = visit13.getFormattedStartTime();
        visit13.setDuration((int) (byte) 10);
        java.lang.String str19 = visit13.getBookingID();
        // The following exception was thrown during execution in test generation
        try {
            visit13.setBookingID("Available");
            org.junit.Assert.fail("Expected exception of type java.lang.NumberFormatException; message: For input string: \"Available\"");
        } catch (java.lang.NumberFormatException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "0" + "'", str14, "0");
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + " -  (hi!)" + "'", str15, " -  (hi!)");
        org.junit.Assert.assertEquals("'" + str16 + "' != '" + "31/12/1969" + "'", str16, "31/12/1969");
        org.junit.Assert.assertEquals("'" + str19 + "' != '" + "0" + "'", str19, "0");
    }

    @Test
    public void test019() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test019");
        objects.ParkingLot parkingLot3 = new objects.ParkingLot(" -  (hi!)", "hi!", (int) (short) 1);
        parkingLot3.setLocation("31/12/1969");
        parkingLot3.setName("NotValidated");
    }

    @Test
    public void test020() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test020");
        objects.FacultyMember facultyMember2 = new objects.FacultyMember(" -  (hi!)", " -  (hi!)");
        int int3 = facultyMember2.getParkingRate();
        facultyMember2.setPassword("hi!");
        java.lang.String str6 = facultyMember2.getValidationStatus();
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 8 + "'", int3 == 8);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "NotValidated" + "'", str6, "NotValidated");
    }

    @Test
    public void test021() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test021");
        objects.ParkingSpace parkingSpace2 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.setType("hi!");
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.update(parkingSpace7, true);
        objects.Car car10 = parkingSpace7.getParkedCar();
        objects.Client client14 = null;
        objects.Car car15 = new objects.Car("", "", "hi!", client14);
        java.lang.String str16 = car15.toString();
        car15.setModel(" -  (hi!)");
        objects.FacultyMember facultyMember21 = new objects.FacultyMember("", " -  (hi!)");
        car15.setOwner((objects.Client) facultyMember21);
        boolean boolean23 = parkingSpace7.parkCar(car15);
        car15.setLicensePlate("31/12/1969");
        org.junit.Assert.assertNull(car10);
        org.junit.Assert.assertEquals("'" + str16 + "' != '" + " -  (hi!)" + "'", str16, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + true + "'", boolean23 == true);
    }

    @Test
    public void test022() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test022");
        objects.Client client3 = null;
        objects.Car car4 = new objects.Car("", "", "hi!", client3);
        java.lang.String str5 = car4.getLicensePlate();
        car4.setLicensePlate("Unknown");
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
    }

    @Test
    public void test023() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test023");
        objects.FacultyMember facultyMember2 = new objects.FacultyMember(" -  (hi!)", " -  (hi!)");
        int int3 = facultyMember2.getParkingRate();
        java.lang.String str4 = facultyMember2.getEmail();
        facultyMember2.setParkingRate((int) (short) -1);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 8 + "'", int3 == 8);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + " -  (hi!)" + "'", str4, " -  (hi!)");
    }

    @Test
    public void test024() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test024");
        objects.ParkingSpace parkingSpace2 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.setType("hi!");
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.update(parkingSpace7, true);
        objects.Car car10 = parkingSpace7.getParkedCar();
        parkingSpace7.setOccupied(false);
        boolean boolean13 = parkingSpace7.isEnabled();
        org.junit.Assert.assertNull(car10);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + true + "'", boolean13 == true);
    }

    @Test
    public void test025() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test025");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot4 = null;
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace7.setType("hi!");
        objects.Client client10 = null;
        businessLogic.Visit visit13 = new businessLogic.Visit((int) (byte) 0, date1, (int) (short) -1, (int) '4', parkingLot4, parkingSpace7, client10, (int) (short) 10, " -  (hi!)");
        java.lang.String str14 = visit13.getBookingID();
        objects.Client client15 = visit13.getClientDetail();
        boolean boolean16 = visit13.isCheckedIn();
        boolean boolean17 = visit13.hasExceededHour();
        int int18 = visit13.getDuration();
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "0" + "'", str14, "0");
        org.junit.Assert.assertNull(client15);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + true + "'", boolean17 == true);
        org.junit.Assert.assertTrue("'" + int18 + "' != '" + 52 + "'", int18 == 52);
    }

    @Test
    public void test026() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test026");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot4 = null;
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace7.setType("hi!");
        objects.Client client10 = null;
        businessLogic.Visit visit13 = new businessLogic.Visit((int) (byte) 0, date1, (int) (short) -1, (int) '4', parkingLot4, parkingSpace7, client10, (int) (short) 10, " -  (hi!)");
        java.lang.String str14 = visit13.getBookingID();
        objects.Client client15 = visit13.getClientDetail();
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str16 = visit13.getDateString();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: date must not be null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "0" + "'", str14, "0");
        org.junit.Assert.assertNull(client15);
    }

    @Test
    public void test027() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test027");
        objects.ParkingSpace parkingSpace2 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.setType("hi!");
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.update(parkingSpace7, true);
        objects.Car car10 = parkingSpace7.getParkedCar();
        parkingSpace7.setOccupied(false);
        java.util.Date date14 = null;
        // The following exception was thrown during execution in test generation
        try {
            parkingSpace7.occupyTime((int) (byte) 0, date14, (int) (short) -1, 1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: date must not be null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(car10);
    }

    @Test
    public void test028() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test028");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot4 = null;
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace7.setType("hi!");
        objects.Client client10 = null;
        businessLogic.Visit visit13 = new businessLogic.Visit((int) (byte) 0, date1, (int) (short) -1, (int) '4', parkingLot4, parkingSpace7, client10, (int) (short) 10, " -  (hi!)");
        java.lang.String str14 = visit13.getBookingID();
        objects.Client client15 = visit13.getClientDetail();
        // The following exception was thrown during execution in test generation
        try {
            visit13.setEndTime((int) (short) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: date must not be null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "0" + "'", str14, "0");
        org.junit.Assert.assertNull(client15);
    }

    @Test
    public void test029() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test029");
        objects.Client client3 = null;
        objects.Car car4 = new objects.Car("", "", "hi!", client3);
        java.lang.String str5 = car4.toString();
        car4.setModel(" -  (hi!)");
        objects.FacultyMember facultyMember10 = new objects.FacultyMember("", " -  (hi!)");
        car4.setOwner((objects.Client) facultyMember10);
        java.lang.String str12 = facultyMember10.getEmail();
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + " -  (hi!)" + "'", str5, " -  (hi!)");
        org.junit.Assert.assertEquals("'" + str12 + "' != '" + "" + "'", str12, "");
    }

    @Test
    public void test030() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test030");
        objects.ParkingLot parkingLot3 = new objects.ParkingLot(" -  (hi!)", "hi!", (int) (short) 1);
        java.lang.String str4 = parkingLot3.getStatus();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "Enabled" + "'", str4, "Enabled");
    }

    @Test
    public void test031() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test031");
        objects.ParkingSpace parkingSpace2 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.setType("hi!");
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.update(parkingSpace7, true);
        objects.Car car10 = parkingSpace7.getParkedCar();
        objects.Client client14 = null;
        objects.Car car15 = new objects.Car("", "", "hi!", client14);
        java.lang.String str16 = car15.toString();
        car15.setModel(" -  (hi!)");
        objects.FacultyMember facultyMember21 = new objects.FacultyMember("", " -  (hi!)");
        car15.setOwner((objects.Client) facultyMember21);
        boolean boolean23 = parkingSpace7.parkCar(car15);
        car15.setLicensePlate("hi!");
        org.junit.Assert.assertNull(car10);
        org.junit.Assert.assertEquals("'" + str16 + "' != '" + " -  (hi!)" + "'", str16, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + true + "'", boolean23 == true);
    }

    @Test
    public void test032() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test032");
        objects.ParkingLot parkingLot3 = new objects.ParkingLot(" -  (hi!)", "hi!", (int) (short) 1);
        parkingLot3.setEnabled(false);
        parkingLot3.setLocation("");
    }

    @Test
    public void test033() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test033");
        objects.ParkingSpace parkingSpace2 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.setType("hi!");
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.update(parkingSpace7, true);
        objects.Car car10 = parkingSpace7.removeCar();
        parkingSpace7.unoccupy((int) (short) -1);
        org.junit.Assert.assertNull(car10);
    }

    @Test
    public void test034() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test034");
        objects.FacultyMember facultyMember5 = new objects.FacultyMember("", " -  (hi!)");
        objects.Car car6 = new objects.Car("Available", "Manager", "0", (objects.Client) facultyMember5);
        java.lang.String str7 = facultyMember5.getPassword();
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + " -  (hi!)" + "'", str7, " -  (hi!)");
    }

    @Test
    public void test035() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test035");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot4 = null;
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace7.setType("hi!");
        objects.Client client10 = null;
        businessLogic.Visit visit13 = new businessLogic.Visit((int) (byte) 0, date1, (int) (short) -1, (int) '4', parkingLot4, parkingSpace7, client10, (int) (short) 10, " -  (hi!)");
        java.lang.String str14 = visit13.getBookingID();
        java.lang.String str15 = visit13.getLicence();
        java.lang.String str16 = visit13.getFormattedStartTime();
        objects.ParkingSpace parkingSpace19 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace19.setType("hi!");
        objects.ParkingSpace parkingSpace24 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace19.update(parkingSpace24, true);
        objects.Car car27 = parkingSpace24.getParkedCar();
        objects.Client client31 = null;
        objects.Car car32 = new objects.Car("", "", "hi!", client31);
        java.lang.String str33 = car32.toString();
        car32.setModel(" -  (hi!)");
        objects.FacultyMember facultyMember38 = new objects.FacultyMember("", " -  (hi!)");
        car32.setOwner((objects.Client) facultyMember38);
        boolean boolean40 = parkingSpace24.parkCar(car32);
        visit13.setParkingSpace(parkingSpace24);
        // The following exception was thrown during execution in test generation
        try {
            java.util.Date date42 = visit13.getEndTime();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: date must not be null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "0" + "'", str14, "0");
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + " -  (hi!)" + "'", str15, " -  (hi!)");
        org.junit.Assert.assertEquals("'" + str16 + "' != '" + "31/12/1969" + "'", str16, "31/12/1969");
        org.junit.Assert.assertNull(car27);
        org.junit.Assert.assertEquals("'" + str33 + "' != '" + " -  (hi!)" + "'", str33, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + boolean40 + "' != '" + true + "'", boolean40 == true);
    }

    @Test
    public void test036() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test036");
        objects.FacultyMember facultyMember2 = new objects.FacultyMember("", " -  (hi!)");
        java.lang.String str3 = facultyMember2.getValidationStatus();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "NotValidated" + "'", str3, "NotValidated");
    }

    @Test
    public void test037() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test037");
        objects.Client client3 = null;
        objects.Car car4 = new objects.Car("", "", "hi!", client3);
        java.lang.String str5 = car4.toString();
        car4.setModel(" -  (hi!)");
        objects.FacultyMember facultyMember10 = new objects.FacultyMember("", " -  (hi!)");
        car4.setOwner((objects.Client) facultyMember10);
        objects.Client client12 = car4.getOwner();
        objects.Client client13 = car4.getOwner();
        java.lang.String str14 = client13.getEmail();
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + " -  (hi!)" + "'", str5, " -  (hi!)");
        org.junit.Assert.assertNotNull(client12);
        org.junit.Assert.assertNotNull(client13);
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "" + "'", str14, "");
    }

    @Test
    public void test038() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test038");
        objects.FacultyMember facultyMember5 = new objects.FacultyMember("", " -  (hi!)");
        objects.Car car6 = new objects.Car("Available", "Manager", "0", (objects.Client) facultyMember5);
        java.lang.String str7 = car6.toString();
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "Available - Manager (0)" + "'", str7, "Available - Manager (0)");
    }

    @Test
    public void test039() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test039");
        businessLogic.SystemDatabaseFacade.addRevenue(8);
    }

    @Test
    public void test040() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test040");
        objects.ParkingSpace parkingSpace2 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.setType("hi!");
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.update(parkingSpace7, true);
        objects.ParkingSensor parkingSensor10 = null;
        parkingSpace2.assignSensor(parkingSensor10);
    }

    @Test
    public void test041() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test041");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot4 = null;
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace7.setType("hi!");
        objects.Client client10 = null;
        businessLogic.Visit visit13 = new businessLogic.Visit((int) (byte) 0, date1, (int) (short) -1, (int) '4', parkingLot4, parkingSpace7, client10, (int) (short) 10, " -  (hi!)");
        java.lang.String str14 = visit13.getBookingID();
        objects.Client client15 = visit13.getClientDetail();
        boolean boolean16 = visit13.isCheckedIn();
        objects.ParkingSpace parkingSpace17 = visit13.getParkingSpace();
        objects.ParkingSpace parkingSpace18 = parkingSpace17.clone();
        java.util.Date date20 = null;
        // The following exception was thrown during execution in test generation
        try {
            parkingSpace17.occupyTime((int) (short) 100, date20, 100, (int) '4');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.Date.getTime()\" because \"date\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "0" + "'", str14, "0");
        org.junit.Assert.assertNull(client15);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNotNull(parkingSpace17);
        org.junit.Assert.assertNotNull(parkingSpace18);
    }

    @Test
    public void test042() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test042");
        objects.Manager manager2 = new objects.Manager("", "31/12/1969");
        java.lang.String str3 = manager2.getRole();
        java.lang.String str4 = manager2.getPassword();
        java.lang.String str5 = manager2.getUserName();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "Manager" + "'", str3, "Manager");
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "31/12/1969" + "'", str4, "31/12/1969");
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
    }

    @Test
    public void test043() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test043");
        objects.Client client3 = null;
        objects.Car car4 = new objects.Car("", "", "hi!", client3);
        java.lang.String str5 = car4.toString();
        car4.setModel(" -  (hi!)");
        objects.FacultyMember facultyMember10 = new objects.FacultyMember("", " -  (hi!)");
        car4.setOwner((objects.Client) facultyMember10);
        objects.Client client12 = car4.getOwner();
        objects.FacultyMember facultyMember18 = new objects.FacultyMember("", " -  (hi!)");
        objects.Car car19 = new objects.Car("Available", "Manager", "0", (objects.Client) facultyMember18);
        facultyMember18.setEmail("0");
        java.lang.String str22 = facultyMember18.getValidationStatus();
        car4.setOwner((objects.Client) facultyMember18);
        car4.setModel("");
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + " -  (hi!)" + "'", str5, " -  (hi!)");
        org.junit.Assert.assertNotNull(client12);
        org.junit.Assert.assertEquals("'" + str22 + "' != '" + "NotValidated" + "'", str22, "NotValidated");
    }

    @Test
    public void test044() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test044");
        objects.Client client3 = null;
        objects.Car car4 = new objects.Car("", "", "hi!", client3);
        java.lang.String str5 = car4.toString();
        car4.setModel(" -  (hi!)");
        objects.FacultyMember facultyMember10 = new objects.FacultyMember("", " -  (hi!)");
        car4.setOwner((objects.Client) facultyMember10);
        objects.Client client12 = car4.getOwner();
        objects.FacultyMember facultyMember18 = new objects.FacultyMember("", " -  (hi!)");
        objects.Car car19 = new objects.Car("Available", "Manager", "0", (objects.Client) facultyMember18);
        facultyMember18.setEmail("0");
        java.lang.String str22 = facultyMember18.getValidationStatus();
        car4.setOwner((objects.Client) facultyMember18);
        car4.setLicensePlate("Enabled");
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + " -  (hi!)" + "'", str5, " -  (hi!)");
        org.junit.Assert.assertNotNull(client12);
        org.junit.Assert.assertEquals("'" + str22 + "' != '" + "NotValidated" + "'", str22, "NotValidated");
    }

    @Test
    public void test045() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test045");
        database.Database database1 = new database.Database("NotValidated");
    }

    @Test
    public void test046() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test046");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot4 = null;
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace7.setType("hi!");
        objects.Client client10 = null;
        businessLogic.Visit visit13 = new businessLogic.Visit((int) (byte) 0, date1, (int) (short) -1, (int) '4', parkingLot4, parkingSpace7, client10, (int) (short) 10, " -  (hi!)");
        objects.ParkingLot parkingLot14 = visit13.getParkingLot();
        // The following exception was thrown during execution in test generation
        try {
            visit13.setBookingID("Unknown");
            org.junit.Assert.fail("Expected exception of type java.lang.NumberFormatException; message: For input string: \"Unknown\"");
        } catch (java.lang.NumberFormatException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(parkingLot14);
    }

    @Test
    public void test047() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test047");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot4 = null;
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace7.setType("hi!");
        objects.Client client10 = null;
        businessLogic.Visit visit13 = new businessLogic.Visit((int) (byte) 0, date1, (int) (short) -1, (int) '4', parkingLot4, parkingSpace7, client10, (int) (short) 10, " -  (hi!)");
        java.lang.String str14 = visit13.getBookingID();
        objects.Client client15 = visit13.getClientDetail();
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str16 = visit13.getFormattedEndTime();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: date must not be null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "0" + "'", str14, "0");
        org.junit.Assert.assertNull(client15);
    }

    @Test
    public void test048() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test048");
        businessLogic.SystemDatabaseFacade.addRevenue((int) (byte) 10);
    }

    @Test
    public void test049() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test049");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot4 = null;
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace7.setType("hi!");
        objects.Client client10 = null;
        businessLogic.Visit visit13 = new businessLogic.Visit((int) (byte) 0, date1, (int) (short) -1, (int) '4', parkingLot4, parkingSpace7, client10, (int) (short) 10, " -  (hi!)");
        java.lang.String str14 = visit13.getBookingID();
        java.lang.String str15 = visit13.getLicence();
        java.lang.String str16 = visit13.getFormattedStartTime();
        objects.Client client17 = visit13.getClientDetail();
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "0" + "'", str14, "0");
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + " -  (hi!)" + "'", str15, " -  (hi!)");
        org.junit.Assert.assertEquals("'" + str16 + "' != '" + "31/12/1969" + "'", str16, "31/12/1969");
        org.junit.Assert.assertNull(client17);
    }

    @Test
    public void test050() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test050");
        objects.ParkingSpace parkingSpace2 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.setType("hi!");
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.update(parkingSpace7, true);
        objects.Car car10 = parkingSpace7.getParkedCar();
        java.lang.String str11 = parkingSpace7.getOccupiedString();
        java.util.Date date12 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str13 = parkingSpace7.getDateString(date12);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: date must not be null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(car10);
        org.junit.Assert.assertEquals("'" + str11 + "' != '" + "Available" + "'", str11, "Available");
    }

    @Test
    public void test051() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test051");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot4 = null;
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace7.setType("hi!");
        objects.Client client10 = null;
        businessLogic.Visit visit13 = new businessLogic.Visit((int) (byte) 0, date1, (int) (short) -1, (int) '4', parkingLot4, parkingSpace7, client10, (int) (short) 10, " -  (hi!)");
        java.lang.String str14 = visit13.getBookingID();
        java.lang.String str15 = visit13.getLicence();
        java.lang.String str16 = visit13.getFormattedStartTime();
        objects.ParkingSpace parkingSpace19 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace19.setType("hi!");
        objects.ParkingSpace parkingSpace24 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace19.update(parkingSpace24, true);
        objects.Car car27 = parkingSpace24.getParkedCar();
        objects.Client client31 = null;
        objects.Car car32 = new objects.Car("", "", "hi!", client31);
        java.lang.String str33 = car32.toString();
        car32.setModel(" -  (hi!)");
        objects.FacultyMember facultyMember38 = new objects.FacultyMember("", " -  (hi!)");
        car32.setOwner((objects.Client) facultyMember38);
        boolean boolean40 = parkingSpace24.parkCar(car32);
        visit13.setParkingSpace(parkingSpace24);
        parkingSpace24.unoccupyTime((int) ' ');
        parkingSpace24.unoccupyTime(52);
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "0" + "'", str14, "0");
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + " -  (hi!)" + "'", str15, " -  (hi!)");
        org.junit.Assert.assertEquals("'" + str16 + "' != '" + "31/12/1969" + "'", str16, "31/12/1969");
        org.junit.Assert.assertNull(car27);
        org.junit.Assert.assertEquals("'" + str33 + "' != '" + " -  (hi!)" + "'", str33, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + boolean40 + "' != '" + true + "'", boolean40 == true);
    }

    @Test
    public void test052() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test052");
        objects.FacultyMember facultyMember2 = new objects.FacultyMember(" -  (hi!)", " -  (hi!)");
        int int3 = facultyMember2.getParkingRate();
        facultyMember2.setParkingRate((int) (short) 1);
        java.lang.String str6 = facultyMember2.getValidationStatus();
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 8 + "'", int3 == 8);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "NotValidated" + "'", str6, "NotValidated");
    }

    @Test
    public void test053() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test053");
        database.Database database1 = new database.Database("Occupied");
    }

    @Test
    public void test054() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test054");
        objects.ParkingSpace parkingSpace2 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.setType("hi!");
        java.lang.String str5 = parkingSpace2.getOccupiedString();
        java.util.Date date7 = null;
        // The following exception was thrown during execution in test generation
        try {
            parkingSpace2.occupyTime((-1), date7, (int) (short) 10, (int) '#');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: date must not be null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "Available" + "'", str5, "Available");
    }

    @Test
    public void test055() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test055");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot4 = null;
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace7.setType("hi!");
        objects.Client client10 = null;
        businessLogic.Visit visit13 = new businessLogic.Visit((int) (byte) 0, date1, (int) (short) -1, (int) '4', parkingLot4, parkingSpace7, client10, (int) (short) 10, " -  (hi!)");
        java.lang.String str14 = visit13.getBookingID();
        objects.Client client15 = visit13.getClientDetail();
        boolean boolean16 = visit13.isCheckedIn();
        objects.ParkingSpace parkingSpace17 = visit13.getParkingSpace();
        // The following exception was thrown during execution in test generation
        try {
            java.util.Date date18 = visit13.getStartTime();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: date must not be null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "0" + "'", str14, "0");
        org.junit.Assert.assertNull(client15);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNotNull(parkingSpace17);
    }

    @Test
    public void test056() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test056");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot4 = null;
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace7.setType("hi!");
        objects.Client client10 = null;
        businessLogic.Visit visit13 = new businessLogic.Visit((int) (byte) 0, date1, (int) (short) -1, (int) '4', parkingLot4, parkingSpace7, client10, (int) (short) 10, " -  (hi!)");
        objects.ParkingLot parkingLot14 = visit13.getParkingLot();
        java.lang.String str15 = visit13.getFormattedStartTime();
        int int16 = visit13.getInitialTime();
        java.util.Date date17 = null;
        visit13.setEndTime(date17);
        org.junit.Assert.assertNull(parkingLot14);
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + "31/12/1969" + "'", str15, "31/12/1969");
        org.junit.Assert.assertTrue("'" + int16 + "' != '" + (-1) + "'", int16 == (-1));
    }

    @Test
    public void test057() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test057");
        objects.Manager manager2 = new objects.Manager("", "31/12/1969");
        java.lang.String str3 = manager2.getRole();
        java.lang.String str4 = manager2.getRole();
        java.lang.String str5 = manager2.getUserName();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "Manager" + "'", str3, "Manager");
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "Manager" + "'", str4, "Manager");
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
    }

    @Test
    public void test058() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test058");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot4 = null;
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace7.setType("hi!");
        objects.Client client10 = null;
        businessLogic.Visit visit13 = new businessLogic.Visit((int) (byte) 0, date1, (int) (short) -1, (int) '4', parkingLot4, parkingSpace7, client10, (int) (short) 10, " -  (hi!)");
        java.lang.String str14 = visit13.getBookingID();
        java.lang.String str15 = visit13.getLicence();
        java.lang.String str16 = visit13.getFormattedStartTime();
        objects.ParkingSpace parkingSpace19 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace19.setType("hi!");
        objects.ParkingSpace parkingSpace24 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace19.update(parkingSpace24, true);
        objects.Car car27 = parkingSpace24.getParkedCar();
        objects.Client client31 = null;
        objects.Car car32 = new objects.Car("", "", "hi!", client31);
        java.lang.String str33 = car32.toString();
        car32.setModel(" -  (hi!)");
        objects.FacultyMember facultyMember38 = new objects.FacultyMember("", " -  (hi!)");
        car32.setOwner((objects.Client) facultyMember38);
        boolean boolean40 = parkingSpace24.parkCar(car32);
        visit13.setParkingSpace(parkingSpace24);
        objects.Car car42 = parkingSpace24.getParkedCar();
        java.lang.String str43 = parkingSpace24.toString();
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "0" + "'", str14, "0");
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + " -  (hi!)" + "'", str15, " -  (hi!)");
        org.junit.Assert.assertEquals("'" + str16 + "' != '" + "31/12/1969" + "'", str16, "31/12/1969");
        org.junit.Assert.assertNull(car27);
        org.junit.Assert.assertEquals("'" + str33 + "' != '" + " -  (hi!)" + "'", str33, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + boolean40 + "' != '" + true + "'", boolean40 == true);
        org.junit.Assert.assertNotNull(car42);
        org.junit.Assert.assertEquals("'" + str43 + "' != '" + "Space 100 (hi!): Enabled, Occupied, No Sensor" + "'", str43, "Space 100 (hi!): Enabled, Occupied, No Sensor");
    }

    @Test
    public void test059() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test059");
        objects.Client client3 = null;
        objects.Car car4 = new objects.Car("", "", "hi!", client3);
        java.lang.String str5 = car4.toString();
        car4.setModel(" -  (hi!)");
        java.lang.String str8 = car4.getLicensePlate();
        car4.setColor("Occupied");
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + " -  (hi!)" + "'", str5, " -  (hi!)");
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "" + "'", str8, "");
    }

    @Test
    public void test060() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test060");
        objects.ParkingSpace parkingSpace2 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.setType("hi!");
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.update(parkingSpace7, true);
        objects.Car car10 = parkingSpace7.getParkedCar();
        parkingSpace7.setOccupied(false);
        objects.Car car13 = parkingSpace7.getParkedCar();
        objects.ParkingLot parkingLot17 = new objects.ParkingLot(" -  (hi!)", "hi!", (int) (short) 1);
        java.lang.String str18 = parkingLot17.getLocation();
        parkingSpace7.setParkingLot(parkingLot17);
        parkingLot17.setEnabled(true);
        boolean boolean22 = parkingLot17.isEnabled();
        org.junit.Assert.assertNull(car10);
        org.junit.Assert.assertNull(car13);
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + "hi!" + "'", str18, "hi!");
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + true + "'", boolean22 == true);
    }

    @Test
    public void test061() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test061");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot4 = null;
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace7.setType("hi!");
        objects.Client client10 = null;
        businessLogic.Visit visit13 = new businessLogic.Visit((int) (byte) 0, date1, (int) (short) -1, (int) '4', parkingLot4, parkingSpace7, client10, (int) (short) 10, " -  (hi!)");
        objects.ParkingLot parkingLot14 = visit13.getParkingLot();
        java.lang.String str15 = visit13.getFormattedStartTime();
        // The following exception was thrown during execution in test generation
        try {
            visit13.setStartTime((-1));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: date must not be null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(parkingLot14);
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + "31/12/1969" + "'", str15, "31/12/1969");
    }

    @Test
    public void test062() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test062");
        businessLogic.Visit visit1 = businessLogic.Visit.getVisit((int) '#');
        org.junit.Assert.assertNull(visit1);
    }

    @Test
    public void test063() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test063");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot4 = null;
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace7.setType("hi!");
        objects.Client client10 = null;
        businessLogic.Visit visit13 = new businessLogic.Visit((int) (byte) 0, date1, (int) (short) -1, (int) '4', parkingLot4, parkingSpace7, client10, (int) (short) 10, " -  (hi!)");
        java.lang.String str14 = visit13.getBookingID();
        java.lang.String str15 = visit13.getLicence();
        java.lang.String str16 = visit13.getFormattedStartTime();
        visit13.setDuration((int) (byte) 10);
        // The following exception was thrown during execution in test generation
        try {
            visit13.setStartTime(52);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: date must not be null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "0" + "'", str14, "0");
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + " -  (hi!)" + "'", str15, " -  (hi!)");
        org.junit.Assert.assertEquals("'" + str16 + "' != '" + "31/12/1969" + "'", str16, "31/12/1969");
    }

    @Test
    public void test064() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test064");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot4 = null;
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace7.setType("hi!");
        objects.Client client10 = null;
        businessLogic.Visit visit13 = new businessLogic.Visit((int) (byte) 0, date1, (int) (short) -1, (int) '4', parkingLot4, parkingSpace7, client10, (int) (short) 10, " -  (hi!)");
        java.lang.String str14 = visit13.getBookingID();
        java.util.Date date15 = null;
        visit13.setEndTime(date15);
        // The following exception was thrown during execution in test generation
        try {
            visit13.setBookingID("hi!");
            org.junit.Assert.fail("Expected exception of type java.lang.NumberFormatException; message: For input string: \"hi!\"");
        } catch (java.lang.NumberFormatException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "0" + "'", str14, "0");
    }

    @Test
    public void test065() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test065");
        objects.FacultyMember facultyMember5 = new objects.FacultyMember("", " -  (hi!)");
        objects.Car car6 = new objects.Car("Available", "Manager", "0", (objects.Client) facultyMember5);
        car6.setColor("");
        java.lang.String str9 = car6.toString();
        car6.setLicensePlate("Manager");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "Available - Manager ()" + "'", str9, "Available - Manager ()");
    }

    @Test
    public void test066() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test066");
        objects.ParkingLot parkingLot3 = new objects.ParkingLot(" -  (hi!)", "hi!", (int) (short) 1);
        java.lang.String str4 = parkingLot3.getName();
        int int5 = parkingLot3.getId();
        java.util.List<objects.ParkingSpace> parkingSpaceList6 = parkingLot3.getAllSpaces();
        java.util.List<objects.ParkingSpace> parkingSpaceList7 = parkingLot3.getAllSpaces();
        boolean boolean9 = parkingLot3.removeParkingSpace((int) (short) 10);
        parkingLot3.setStatus(false);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + " -  (hi!)" + "'", str4, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
        org.junit.Assert.assertNotNull(parkingSpaceList6);
        org.junit.Assert.assertNotNull(parkingSpaceList7);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + true + "'", boolean9 == true);
    }

    @Test
    public void test067() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test067");
        objects.ParkingSpace parkingSpace2 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.setType("hi!");
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.update(parkingSpace7, true);
        objects.Client client13 = null;
        objects.Car car14 = new objects.Car("", "", "hi!", client13);
        java.lang.String str15 = car14.getLicensePlate();
        car14.setColor("31/12/1969");
        objects.Client client18 = car14.getOwner();
        java.lang.String str19 = car14.getModel();
        boolean boolean20 = parkingSpace2.parkCar(car14);
        parkingSpace2.setOccupied(false);
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + "" + "'", str15, "");
        org.junit.Assert.assertNull(client18);
        org.junit.Assert.assertEquals("'" + str19 + "' != '" + "" + "'", str19, "");
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
    }

    @Test
    public void test068() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test068");
        objects.FacultyMember facultyMember2 = new objects.FacultyMember("Occupied", "Validated");
    }

    @Test
    public void test069() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test069");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot4 = null;
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace7.setType("hi!");
        objects.Client client10 = null;
        businessLogic.Visit visit13 = new businessLogic.Visit((int) (byte) 0, date1, (int) (short) -1, (int) '4', parkingLot4, parkingSpace7, client10, (int) (short) 10, " -  (hi!)");
        java.lang.String str14 = visit13.getBookingID();
        objects.Client client15 = visit13.getClientDetail();
        boolean boolean16 = visit13.isCheckedIn();
        boolean boolean17 = visit13.hasExceededHour();
        // The following exception was thrown during execution in test generation
        try {
            java.util.Date date18 = visit13.getEndTime();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: date must not be null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "0" + "'", str14, "0");
        org.junit.Assert.assertNull(client15);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + true + "'", boolean17 == true);
    }

    @Test
    public void test070() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test070");
        objects.ParkingLot parkingLot3 = new objects.ParkingLot(" -  (hi!)", "hi!", (int) (short) 1);
        java.lang.String str4 = parkingLot3.getName();
        int int5 = parkingLot3.getId();
        parkingLot3.setId((int) (byte) -1);
        boolean boolean8 = parkingLot3.isEnabled();
        java.lang.String str9 = parkingLot3.getStatus();
        int int10 = parkingLot3.getTotalCapacity();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + " -  (hi!)" + "'", str4, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "Enabled" + "'", str9, "Enabled");
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 1 + "'", int10 == 1);
    }

    @Test
    public void test071() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test071");
        objects.ParkingLot parkingLot3 = new objects.ParkingLot("Available - Manager (0)", "", (int) (byte) 10);
    }

    @Test
    public void test072() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test072");
        objects.ParkingSpace parkingSpace2 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.setType("hi!");
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.update(parkingSpace7, true);
        objects.Car car10 = parkingSpace7.getParkedCar();
        objects.Client client14 = null;
        objects.Car car15 = new objects.Car("", "", "hi!", client14);
        java.lang.String str16 = car15.toString();
        car15.setModel(" -  (hi!)");
        objects.FacultyMember facultyMember21 = new objects.FacultyMember("", " -  (hi!)");
        car15.setOwner((objects.Client) facultyMember21);
        boolean boolean23 = parkingSpace7.parkCar(car15);
        java.lang.String str24 = car15.getLicensePlate();
        car15.setLicensePlate("NotValidated");
        org.junit.Assert.assertNull(car10);
        org.junit.Assert.assertEquals("'" + str16 + "' != '" + " -  (hi!)" + "'", str16, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + true + "'", boolean23 == true);
        org.junit.Assert.assertEquals("'" + str24 + "' != '" + "" + "'", str24, "");
    }

    @Test
    public void test073() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test073");
        businessLogic.PaymentSystem paymentSystem0 = businessLogic.PaymentSystem.getInstance();
        java.lang.String str2 = paymentSystem0.getPaymentMethod((int) (byte) 10);
        boolean boolean4 = paymentSystem0.confirmRefund((int) (short) 1);
        org.junit.Assert.assertNotNull(paymentSystem0);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "Unknown" + "'", str2, "Unknown");
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
    }

    @Test
    public void test074() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test074");
        objects.ParkingSpace parkingSpace2 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.setType("hi!");
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.update(parkingSpace7, true);
        parkingSpace7.unoccupyTime(1);
        objects.ParkingSpace parkingSpace14 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace14.setType("hi!");
        objects.ParkingSpace parkingSpace19 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace14.update(parkingSpace19, true);
        objects.Car car22 = parkingSpace19.getParkedCar();
        parkingSpace19.setOccupied(false);
        objects.ParkingLot parkingLot28 = new objects.ParkingLot(" -  (hi!)", "hi!", (int) (short) 1);
        java.lang.String str29 = parkingLot28.getLocation();
        parkingSpace19.setParkingLot(parkingLot28);
        parkingSpace7.setParkingLot(parkingLot28);
        parkingSpace7.setOccupied(true);
        org.junit.Assert.assertNull(car22);
        org.junit.Assert.assertEquals("'" + str29 + "' != '" + "hi!" + "'", str29, "hi!");
    }

    @Test
    public void test075() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test075");
        objects.NonFacultyStaff nonFacultyStaff2 = new objects.NonFacultyStaff(" -  (hi!)", "Unknown");
    }

    @Test
    public void test076() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test076");
        objects.NonFacultyStaff nonFacultyStaff2 = new objects.NonFacultyStaff("Available", "0");
        java.lang.String str3 = nonFacultyStaff2.getEmail();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "Available" + "'", str3, "Available");
    }

    @Test
    public void test077() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test077");
        objects.ParkingSpace parkingSpace2 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.setType("hi!");
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.update(parkingSpace7, true);
        int int10 = parkingSpace7.getSpaceId();
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 100 + "'", int10 == 100);
    }

    @Test
    public void test078() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test078");
        objects.FacultyMember facultyMember5 = new objects.FacultyMember("0", "hi!");
        objects.Car car6 = new objects.Car("Available - Manager ()", "Manager", "Space 100 (hi!): Enabled, Occupied, No Sensor", (objects.Client) facultyMember5);
    }

    @Test
    public void test079() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test079");
        objects.ParkingSpace parkingSpace2 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.setType("hi!");
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.update(parkingSpace7, true);
        objects.Car car10 = parkingSpace7.getParkedCar();
        parkingSpace7.setOccupied(false);
        objects.Car car13 = parkingSpace7.getParkedCar();
        objects.ParkingLot parkingLot17 = new objects.ParkingLot(" -  (hi!)", "hi!", (int) (short) 1);
        java.lang.String str18 = parkingLot17.getLocation();
        parkingSpace7.setParkingLot(parkingLot17);
        parkingLot17.setEnabled(true);
        objects.ParkingSpace parkingSpace23 = parkingLot17.findSpaceById(52);
        int int24 = parkingLot17.getCapcity();
        org.junit.Assert.assertNull(car10);
        org.junit.Assert.assertNull(car13);
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + "hi!" + "'", str18, "hi!");
        org.junit.Assert.assertNotNull(parkingSpace23);
        org.junit.Assert.assertTrue("'" + int24 + "' != '" + 100 + "'", int24 == 100);
    }

    @Test
    public void test080() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test080");
        objects.Student student2 = new objects.Student("Enabled", "Manager");
        student2.setParkingRate((int) 'a');
        java.lang.String str5 = student2.getValidationStatus();
        java.lang.String str6 = student2.getValidationStatus();
        student2.setParkingRate((int) '#');
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "NotValidated" + "'", str5, "NotValidated");
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "NotValidated" + "'", str6, "NotValidated");
    }

    @Test
    public void test081() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test081");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot4 = null;
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace7.setType("hi!");
        objects.Client client10 = null;
        businessLogic.Visit visit13 = new businessLogic.Visit((int) (byte) 0, date1, (int) (short) -1, (int) '4', parkingLot4, parkingSpace7, client10, (int) (short) 10, " -  (hi!)");
        objects.ParkingLot parkingLot14 = visit13.getParkingLot();
        java.lang.String str15 = visit13.getFormattedStartTime();
        int int16 = visit13.getInitialTime();
        // The following exception was thrown during execution in test generation
        try {
            visit13.setStartTime((int) (byte) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: date must not be null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(parkingLot14);
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + "31/12/1969" + "'", str15, "31/12/1969");
        org.junit.Assert.assertTrue("'" + int16 + "' != '" + (-1) + "'", int16 == (-1));
    }

    @Test
    public void test082() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test082");
        objects.ParkingLot parkingLot3 = new objects.ParkingLot(" -  (hi!)", "hi!", (int) (short) 1);
        java.lang.String str4 = parkingLot3.getName();
        int int5 = parkingLot3.getId();
        java.util.List<objects.ParkingSpace> parkingSpaceList6 = parkingLot3.getAllSpaces();
        java.util.List<objects.ParkingSpace> parkingSpaceList7 = parkingLot3.getAllSpaces();
        boolean boolean8 = parkingLot3.isEnabled();
        parkingLot3.setLocation("Validated");
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + " -  (hi!)" + "'", str4, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
        org.junit.Assert.assertNotNull(parkingSpaceList6);
        org.junit.Assert.assertNotNull(parkingSpaceList7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
    }

    @Test
    public void test083() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test083");
        objects.Student student2 = new objects.Student("Enabled", "Manager");
        student2.setParkingRate((int) 'a');
        java.lang.String str5 = student2.getValidationStatus();
        java.lang.String str6 = student2.getValidationStatus();
        student2.setValidated(false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "NotValidated" + "'", str5, "NotValidated");
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "NotValidated" + "'", str6, "NotValidated");
    }

    @Test
    public void test084() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test084");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot4 = null;
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace7.setType("hi!");
        objects.Client client10 = null;
        businessLogic.Visit visit13 = new businessLogic.Visit((int) (byte) 0, date1, (int) (short) -1, (int) '4', parkingLot4, parkingSpace7, client10, (int) (short) 10, " -  (hi!)");
        java.lang.String str14 = visit13.getBookingID();
        boolean boolean15 = visit13.hasExceededHour();
        // The following exception was thrown during execution in test generation
        try {
            visit13.setBookingID("Super Manager");
            org.junit.Assert.fail("Expected exception of type java.lang.NumberFormatException; message: For input string: \"Super Manager\"");
        } catch (java.lang.NumberFormatException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "0" + "'", str14, "0");
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
    }

    @Test
    public void test085() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test085");
        objects.ClientFactory clientFactory0 = new objects.ClientFactory();
        objects.Client client4 = clientFactory0.getNewClient("Available - Manager ()", "Space 100 (hi!): Enabled, Occupied, No Sensor", "Occupied");
        org.junit.Assert.assertNull(client4);
    }

    @Test
    public void test086() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test086");
        objects.Student student2 = new objects.Student("Enabled", "Manager");
        student2.setParkingRate((int) 'a');
        student2.setEmail("NotValidated");
    }

    @Test
    public void test087() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test087");
        objects.ParkingLot parkingLot3 = new objects.ParkingLot(" -  (hi!)", "hi!", (int) (short) 1);
        java.lang.String str4 = parkingLot3.getName();
        int int5 = parkingLot3.getId();
        java.util.List<objects.ParkingSpace> parkingSpaceList6 = parkingLot3.getAllSpaces();
        boolean boolean7 = parkingLot3.isEnabled();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + " -  (hi!)" + "'", str4, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
        org.junit.Assert.assertNotNull(parkingSpaceList6);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
    }

    @Test
    public void test088() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test088");
        objects.ParkingSpace parkingSpace2 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.setType("hi!");
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.update(parkingSpace7, true);
        objects.Car car10 = parkingSpace7.getParkedCar();
        objects.Client client14 = null;
        objects.Car car15 = new objects.Car("", "", "hi!", client14);
        java.lang.String str16 = car15.toString();
        car15.setModel(" -  (hi!)");
        objects.FacultyMember facultyMember21 = new objects.FacultyMember("", " -  (hi!)");
        car15.setOwner((objects.Client) facultyMember21);
        boolean boolean23 = parkingSpace7.parkCar(car15);
        car15.setLicensePlate("Enabled");
        car15.setModel("Occupied");
        org.junit.Assert.assertNull(car10);
        org.junit.Assert.assertEquals("'" + str16 + "' != '" + " -  (hi!)" + "'", str16, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + true + "'", boolean23 == true);
    }

    @Test
    public void test089() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test089");
        objects.ParkingLot parkingLot3 = new objects.ParkingLot(" -  (hi!)", "hi!", (int) (short) 1);
        java.lang.String str4 = parkingLot3.getName();
        int int5 = parkingLot3.getId();
        parkingLot3.setId((int) (byte) -1);
        boolean boolean9 = parkingLot3.removeParkingSpace((int) 'a');
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + " -  (hi!)" + "'", str4, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + true + "'", boolean9 == true);
    }

    @Test
    public void test090() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test090");
        objects.Visitor visitor2 = new objects.Visitor("Manager", "Available");
        java.lang.String str3 = visitor2.getValidationStatus();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "Validated" + "'", str3, "Validated");
    }

    @Test
    public void test091() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test091");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot7 = new objects.ParkingLot(" -  (hi!)", "hi!", (int) (short) 1);
        java.lang.String str8 = parkingLot7.getName();
        int int9 = parkingLot7.getId();
        parkingLot7.setId((int) (byte) -1);
        boolean boolean12 = parkingLot7.isEnabled();
        objects.ParkingSpace parkingSpace15 = new objects.ParkingSpace((int) (short) 100, "hi!");
        objects.Client client19 = null;
        objects.Car car20 = new objects.Car("", "", "hi!", client19);
        objects.FacultyMember facultyMember23 = new objects.FacultyMember("", " -  (hi!)");
        car20.setOwner((objects.Client) facultyMember23);
        businessLogic.Visit visit27 = new businessLogic.Visit(8, date1, (int) (byte) 100, (int) (short) 10, parkingLot7, parkingSpace15, (objects.Client) facultyMember23, 8, "Enabled");
        boolean boolean28 = visit27.hasExceededHour();
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + " -  (hi!)" + "'", str8, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 0 + "'", int9 == 0);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
        org.junit.Assert.assertTrue("'" + boolean28 + "' != '" + true + "'", boolean28 == true);
    }

    @Test
    public void test092() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test092");
        objects.Manager manager2 = new objects.Manager("Enabled", "Manager");
    }

    @Test
    public void test093() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test093");
        objects.Client client3 = null;
        objects.Car car4 = new objects.Car("", "", "hi!", client3);
        java.lang.String str5 = car4.getLicensePlate();
        java.lang.String str6 = car4.toString();
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + " -  (hi!)" + "'", str6, " -  (hi!)");
    }

    @Test
    public void test094() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test094");
        objects.Client client3 = null;
        objects.Car car4 = new objects.Car("", "", "hi!", client3);
        objects.FacultyMember facultyMember7 = new objects.FacultyMember("", " -  (hi!)");
        car4.setOwner((objects.Client) facultyMember7);
        car4.setModel("0");
        car4.setColor(" -  (hi!)");
    }

    @Test
    public void test095() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test095");
        businessLogic.PaymentSystem paymentSystem0 = businessLogic.PaymentSystem.getInstance();
        java.lang.String str2 = paymentSystem0.getPaymentMethod((int) (byte) 10);
        boolean boolean4 = paymentSystem0.confirmRefund((int) (byte) -1);
        org.junit.Assert.assertNotNull(paymentSystem0);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "Unknown" + "'", str2, "Unknown");
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
    }

    @Test
    public void test096() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test096");
        objects.ParkingSpace parkingSpace3 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace3.setType("hi!");
        objects.ParkingSpace parkingSpace8 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace3.update(parkingSpace8, true);
        objects.Car car11 = parkingSpace8.getParkedCar();
        objects.Client client15 = null;
        objects.Car car16 = new objects.Car("", "", "hi!", client15);
        java.lang.String str17 = car16.toString();
        car16.setModel(" -  (hi!)");
        objects.FacultyMember facultyMember22 = new objects.FacultyMember("", " -  (hi!)");
        car16.setOwner((objects.Client) facultyMember22);
        boolean boolean24 = parkingSpace8.parkCar(car16);
        objects.ParkingSensor parkingSensor25 = new objects.ParkingSensor((int) (byte) -1, parkingSpace8);
        parkingSensor25.detectVehicle(false);
        org.junit.Assert.assertNull(car11);
        org.junit.Assert.assertEquals("'" + str17 + "' != '" + " -  (hi!)" + "'", str17, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + true + "'", boolean24 == true);
    }

    @Test
    public void test097() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test097");
        objects.ParkingLot parkingLot3 = new objects.ParkingLot(" -  (hi!)", "hi!", (int) (short) 1);
        parkingLot3.setLocation("31/12/1969");
        int int6 = parkingLot3.getCapcity();
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 100 + "'", int6 == 100);
    }

    @Test
    public void test098() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test098");
        objects.ParkingLot parkingLot3 = new objects.ParkingLot(" -  (hi!)", "hi!", (int) (short) 1);
        objects.ParkingSpace parkingSpace6 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace6.setType("hi!");
        objects.ParkingSpace parkingSpace11 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace6.update(parkingSpace11, true);
        objects.Car car14 = parkingSpace11.getParkedCar();
        parkingSpace11.setOccupied(false);
        java.lang.String str17 = parkingSpace11.getEnablesString();
        objects.Car car18 = parkingSpace11.removeCar();
        parkingLot3.addParkingSpace(parkingSpace11);
        org.junit.Assert.assertNull(car14);
        org.junit.Assert.assertEquals("'" + str17 + "' != '" + "Enabled" + "'", str17, "Enabled");
        org.junit.Assert.assertNull(car18);
    }

    @Test
    public void test099() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test099");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot4 = null;
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace7.setType("hi!");
        objects.Client client10 = null;
        businessLogic.Visit visit13 = new businessLogic.Visit((int) (byte) 0, date1, (int) (short) -1, (int) '4', parkingLot4, parkingSpace7, client10, (int) (short) 10, " -  (hi!)");
        java.lang.String str14 = visit13.getBookingID();
        java.lang.String str15 = visit13.getLicence();
        java.lang.String str16 = visit13.getFormattedStartTime();
        objects.ParkingSpace parkingSpace19 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace19.setType("hi!");
        objects.ParkingSpace parkingSpace24 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace19.update(parkingSpace24, true);
        objects.Car car27 = parkingSpace24.getParkedCar();
        objects.Client client31 = null;
        objects.Car car32 = new objects.Car("", "", "hi!", client31);
        java.lang.String str33 = car32.toString();
        car32.setModel(" -  (hi!)");
        objects.FacultyMember facultyMember38 = new objects.FacultyMember("", " -  (hi!)");
        car32.setOwner((objects.Client) facultyMember38);
        boolean boolean40 = parkingSpace24.parkCar(car32);
        visit13.setParkingSpace(parkingSpace24);
        parkingSpace24.unoccupyTime((int) ' ');
        parkingSpace24.setOccupied(true);
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "0" + "'", str14, "0");
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + " -  (hi!)" + "'", str15, " -  (hi!)");
        org.junit.Assert.assertEquals("'" + str16 + "' != '" + "31/12/1969" + "'", str16, "31/12/1969");
        org.junit.Assert.assertNull(car27);
        org.junit.Assert.assertEquals("'" + str33 + "' != '" + " -  (hi!)" + "'", str33, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + boolean40 + "' != '" + true + "'", boolean40 == true);
    }

    @Test
    public void test100() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test100");
        objects.ParkingLot parkingLot3 = new objects.ParkingLot("hi!", "superManager", (int) (byte) 100);
    }

    @Test
    public void test101() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test101");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot4 = null;
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace7.setType("hi!");
        objects.Client client10 = null;
        businessLogic.Visit visit13 = new businessLogic.Visit((int) (byte) 0, date1, (int) (short) -1, (int) '4', parkingLot4, parkingSpace7, client10, (int) (short) 10, " -  (hi!)");
        java.lang.String str14 = visit13.getBookingID();
        java.util.Date date15 = null;
        visit13.setEndTime(date15);
        boolean boolean17 = visit13.hasExceededHour();
        java.lang.String str18 = visit13.getBookingID();
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "0" + "'", str14, "0");
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + true + "'", boolean17 == true);
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + "0" + "'", str18, "0");
    }

    @Test
    public void test102() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test102");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot4 = null;
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace7.setType("hi!");
        objects.Client client10 = null;
        businessLogic.Visit visit13 = new businessLogic.Visit((int) (byte) 0, date1, (int) (short) -1, (int) '4', parkingLot4, parkingSpace7, client10, (int) (short) 10, " -  (hi!)");
        objects.ParkingLot parkingLot14 = visit13.getParkingLot();
        java.lang.String str15 = visit13.getFormattedStartTime();
        int int16 = visit13.getInitialTime();
        objects.Client client17 = visit13.getClientDetail();
        org.junit.Assert.assertNull(parkingLot14);
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + "31/12/1969" + "'", str15, "31/12/1969");
        org.junit.Assert.assertTrue("'" + int16 + "' != '" + (-1) + "'", int16 == (-1));
        org.junit.Assert.assertNull(client17);
    }

    @Test
    public void test103() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test103");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot7 = new objects.ParkingLot(" -  (hi!)", "hi!", (int) (short) 1);
        java.lang.String str8 = parkingLot7.getName();
        int int9 = parkingLot7.getId();
        parkingLot7.setId((int) (byte) -1);
        boolean boolean12 = parkingLot7.isEnabled();
        objects.ParkingSpace parkingSpace15 = new objects.ParkingSpace((int) (short) 100, "hi!");
        objects.Client client19 = null;
        objects.Car car20 = new objects.Car("", "", "hi!", client19);
        objects.FacultyMember facultyMember23 = new objects.FacultyMember("", " -  (hi!)");
        car20.setOwner((objects.Client) facultyMember23);
        businessLogic.Visit visit27 = new businessLogic.Visit(8, date1, (int) (byte) 100, (int) (short) 10, parkingLot7, parkingSpace15, (objects.Client) facultyMember23, 8, "Enabled");
        int int28 = parkingLot7.getTotalCapacity();
        parkingLot7.setEnabled(true);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + " -  (hi!)" + "'", str8, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 0 + "'", int9 == 0);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
        org.junit.Assert.assertTrue("'" + int28 + "' != '" + 1 + "'", int28 == 1);
    }

    @Test
    public void test104() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test104");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot7 = new objects.ParkingLot(" -  (hi!)", "hi!", (int) (short) 1);
        java.lang.String str8 = parkingLot7.getName();
        int int9 = parkingLot7.getId();
        parkingLot7.setId((int) (byte) -1);
        boolean boolean12 = parkingLot7.isEnabled();
        objects.ParkingSpace parkingSpace15 = new objects.ParkingSpace((int) (short) 100, "hi!");
        objects.Client client19 = null;
        objects.Car car20 = new objects.Car("", "", "hi!", client19);
        objects.FacultyMember facultyMember23 = new objects.FacultyMember("", " -  (hi!)");
        car20.setOwner((objects.Client) facultyMember23);
        businessLogic.Visit visit27 = new businessLogic.Visit(8, date1, (int) (byte) 100, (int) (short) 10, parkingLot7, parkingSpace15, (objects.Client) facultyMember23, 8, "Enabled");
        visit27.setDuration();
        // The following exception was thrown during execution in test generation
        try {
            java.util.Date date29 = visit27.getStartTime();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: date must not be null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + " -  (hi!)" + "'", str8, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 0 + "'", int9 == 0);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
    }

    @Test
    public void test105() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test105");
        objects.ParkingSpace parkingSpace2 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.setType("hi!");
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.update(parkingSpace7, true);
        java.util.Date date11 = null;
        parkingSpace7.occupyTime((int) (byte) 1, date11, (int) '4', (int) (byte) -1);
    }

    @Test
    public void test106() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test106");
        objects.Client client3 = null;
        objects.Car car4 = new objects.Car("", "", "hi!", client3);
        java.lang.String str5 = car4.toString();
        car4.setModel(" -  (hi!)");
        objects.FacultyMember facultyMember10 = new objects.FacultyMember("", " -  (hi!)");
        car4.setOwner((objects.Client) facultyMember10);
        java.lang.String str12 = facultyMember10.getPassword();
        boolean boolean13 = facultyMember10.isValidated();
        java.lang.String str14 = facultyMember10.getValidationStatus();
        java.lang.String str15 = facultyMember10.getValidationStatus();
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + " -  (hi!)" + "'", str5, " -  (hi!)");
        org.junit.Assert.assertEquals("'" + str12 + "' != '" + " -  (hi!)" + "'", str12, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "NotValidated" + "'", str14, "NotValidated");
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + "NotValidated" + "'", str15, "NotValidated");
    }

    @Test
    public void test107() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test107");
        objects.FacultyMember facultyMember5 = new objects.FacultyMember("", " -  (hi!)");
        objects.Car car6 = new objects.Car("Available", "Manager", "0", (objects.Client) facultyMember5);
        car6.setColor("");
        java.lang.String str9 = car6.toString();
        objects.FacultyMember facultyMember12 = new objects.FacultyMember(" -  (hi!)", " -  (hi!)");
        int int13 = facultyMember12.getParkingRate();
        facultyMember12.setPassword("hi!");
        car6.setOwner((objects.Client) facultyMember12);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "Available - Manager ()" + "'", str9, "Available - Manager ()");
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 8 + "'", int13 == 8);
    }

    @Test
    public void test108() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test108");
        java.util.Date date2 = null;
        objects.ParkingLot parkingLot5 = null;
        objects.ParkingSpace parkingSpace8 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace8.setType("hi!");
        objects.Client client11 = null;
        businessLogic.Visit visit14 = new businessLogic.Visit((int) (byte) 0, date2, (int) (short) -1, (int) '4', parkingLot5, parkingSpace8, client11, (int) (short) 10, " -  (hi!)");
        java.lang.String str15 = visit14.getBookingID();
        java.lang.String str16 = visit14.getLicence();
        java.lang.String str17 = visit14.getFormattedStartTime();
        objects.ParkingSpace parkingSpace20 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace20.setType("hi!");
        objects.ParkingSpace parkingSpace25 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace20.update(parkingSpace25, true);
        objects.Car car28 = parkingSpace25.getParkedCar();
        objects.Client client32 = null;
        objects.Car car33 = new objects.Car("", "", "hi!", client32);
        java.lang.String str34 = car33.toString();
        car33.setModel(" -  (hi!)");
        objects.FacultyMember facultyMember39 = new objects.FacultyMember("", " -  (hi!)");
        car33.setOwner((objects.Client) facultyMember39);
        boolean boolean41 = parkingSpace25.parkCar(car33);
        visit14.setParkingSpace(parkingSpace25);
        objects.ParkingSensor parkingSensor43 = new objects.ParkingSensor((int) 'a', parkingSpace25);
        parkingSensor43.detectVehicle(true);
        int int46 = parkingSensor43.getSensorId();
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + "0" + "'", str15, "0");
        org.junit.Assert.assertEquals("'" + str16 + "' != '" + " -  (hi!)" + "'", str16, " -  (hi!)");
        org.junit.Assert.assertEquals("'" + str17 + "' != '" + "31/12/1969" + "'", str17, "31/12/1969");
        org.junit.Assert.assertNull(car28);
        org.junit.Assert.assertEquals("'" + str34 + "' != '" + " -  (hi!)" + "'", str34, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + boolean41 + "' != '" + true + "'", boolean41 == true);
        org.junit.Assert.assertTrue("'" + int46 + "' != '" + 97 + "'", int46 == 97);
    }

    @Test
    public void test109() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test109");
        businessLogic.PaymentSystem paymentSystem0 = businessLogic.PaymentSystem.getInstance();
        java.lang.String str2 = paymentSystem0.getPaymentMethod((int) 'a');
        org.junit.Assert.assertNotNull(paymentSystem0);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "Unknown" + "'", str2, "Unknown");
    }

    @Test
    public void test110() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test110");
        businessLogic.Visit visit1 = businessLogic.Visit.getVisit("Available");
        org.junit.Assert.assertNull(visit1);
    }

    @Test
    public void test111() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test111");
        objects.ParkingSpace parkingSpace2 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.setType("hi!");
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.update(parkingSpace7, true);
        parkingSpace7.unoccupyTime(1);
        objects.ParkingSpace parkingSpace14 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace14.setType("hi!");
        objects.ParkingSpace parkingSpace19 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace14.update(parkingSpace19, true);
        objects.Car car22 = parkingSpace19.getParkedCar();
        parkingSpace19.setOccupied(false);
        objects.ParkingLot parkingLot28 = new objects.ParkingLot(" -  (hi!)", "hi!", (int) (short) 1);
        java.lang.String str29 = parkingLot28.getLocation();
        parkingSpace19.setParkingLot(parkingLot28);
        parkingSpace7.setParkingLot(parkingLot28);
        int int32 = parkingLot28.getCapcity();
        java.util.List<objects.ParkingSpace> parkingSpaceList33 = parkingLot28.getAvailableSpaces();
        parkingLot28.setId((int) (short) -1);
        boolean boolean37 = parkingLot28.removeParkingSpace(52);
        org.junit.Assert.assertNull(car22);
        org.junit.Assert.assertEquals("'" + str29 + "' != '" + "hi!" + "'", str29, "hi!");
        org.junit.Assert.assertTrue("'" + int32 + "' != '" + 100 + "'", int32 == 100);
        org.junit.Assert.assertNotNull(parkingSpaceList33);
        org.junit.Assert.assertTrue("'" + boolean37 + "' != '" + true + "'", boolean37 == true);
    }

    @Test
    public void test112() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test112");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot4 = null;
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace7.setType("hi!");
        objects.Client client10 = null;
        businessLogic.Visit visit13 = new businessLogic.Visit((int) (byte) 0, date1, (int) (short) -1, (int) '4', parkingLot4, parkingSpace7, client10, (int) (short) 10, " -  (hi!)");
        java.lang.String str14 = visit13.getBookingID();
        objects.Client client15 = visit13.getClientDetail();
        boolean boolean16 = visit13.isCheckedIn();
        objects.ParkingSpace parkingSpace17 = visit13.getParkingSpace();
        objects.ParkingSpace parkingSpace18 = parkingSpace17.clone();
        java.util.Date date19 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean22 = parkingSpace18.isOccupied(date19, 8, 0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: date must not be null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "0" + "'", str14, "0");
        org.junit.Assert.assertNull(client15);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNotNull(parkingSpace17);
        org.junit.Assert.assertNotNull(parkingSpace18);
    }

    @Test
    public void test113() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test113");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot4 = null;
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace7.setType("hi!");
        objects.Client client10 = null;
        businessLogic.Visit visit13 = new businessLogic.Visit((int) (byte) 0, date1, (int) (short) -1, (int) '4', parkingLot4, parkingSpace7, client10, (int) (short) 10, " -  (hi!)");
        java.lang.String str14 = visit13.getBookingID();
        java.lang.String str15 = visit13.getLicence();
        java.util.Date date16 = null;
        visit13.setStartTime(date16);
        objects.Client client18 = visit13.getClientDetail();
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "0" + "'", str14, "0");
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + " -  (hi!)" + "'", str15, " -  (hi!)");
        org.junit.Assert.assertNull(client18);
    }

    @Test
    public void test114() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test114");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot4 = null;
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace7.setType("hi!");
        objects.Client client10 = null;
        businessLogic.Visit visit13 = new businessLogic.Visit((int) (byte) 0, date1, (int) (short) -1, (int) '4', parkingLot4, parkingSpace7, client10, (int) (short) 10, " -  (hi!)");
        java.lang.String str14 = visit13.getBookingID();
        boolean boolean15 = visit13.hasExceededHour();
        java.util.Date date16 = null;
        visit13.setEndTime(date16);
        visit13.setMoneyPaid((int) (byte) 10);
        visit13.setMoneyPaid((int) (short) 100);
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "0" + "'", str14, "0");
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
    }

    @Test
    public void test115() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test115");
        objects.Student student2 = new objects.Student("Enabled", "Manager");
        java.lang.Class<?> wildcardClass3 = student2.getClass();
        org.junit.Assert.assertNotNull(wildcardClass3);
    }

    @Test
    public void test116() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test116");
        objects.Student student2 = new objects.Student("Enabled", "Manager");
        java.lang.String str3 = student2.getValidationStatus();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "NotValidated" + "'", str3, "NotValidated");
    }

    @Test
    public void test117() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test117");
        objects.ParkingSpace parkingSpace2 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.setType("hi!");
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.update(parkingSpace7, true);
        java.lang.String str10 = parkingSpace2.getOccupiedString();
        java.lang.String str11 = parkingSpace2.getBookingId();
        objects.Car car12 = parkingSpace2.removeCar();
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "Occupied" + "'", str10, "Occupied");
        org.junit.Assert.assertEquals("'" + str11 + "' != '" + "" + "'", str11, "");
        org.junit.Assert.assertNull(car12);
    }

    @Test
    public void test118() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test118");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot4 = null;
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace7.setType("hi!");
        objects.Client client10 = null;
        businessLogic.Visit visit13 = new businessLogic.Visit((int) (byte) 0, date1, (int) (short) -1, (int) '4', parkingLot4, parkingSpace7, client10, (int) (short) 10, " -  (hi!)");
        java.lang.String str14 = visit13.getBookingID();
        java.lang.String str15 = visit13.getLicence();
        java.lang.String str16 = visit13.getFormattedStartTime();
        objects.ParkingSpace parkingSpace19 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace19.setType("hi!");
        objects.ParkingSpace parkingSpace24 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace19.update(parkingSpace24, true);
        objects.Car car27 = parkingSpace24.getParkedCar();
        objects.Client client31 = null;
        objects.Car car32 = new objects.Car("", "", "hi!", client31);
        java.lang.String str33 = car32.toString();
        car32.setModel(" -  (hi!)");
        objects.FacultyMember facultyMember38 = new objects.FacultyMember("", " -  (hi!)");
        car32.setOwner((objects.Client) facultyMember38);
        boolean boolean40 = parkingSpace24.parkCar(car32);
        visit13.setParkingSpace(parkingSpace24);
        java.util.Date date42 = null;
        visit13.setEndTime(date42);
        // The following exception was thrown during execution in test generation
        try {
            java.util.Date date44 = visit13.getStartTime();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: date must not be null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "0" + "'", str14, "0");
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + " -  (hi!)" + "'", str15, " -  (hi!)");
        org.junit.Assert.assertEquals("'" + str16 + "' != '" + "31/12/1969" + "'", str16, "31/12/1969");
        org.junit.Assert.assertNull(car27);
        org.junit.Assert.assertEquals("'" + str33 + "' != '" + " -  (hi!)" + "'", str33, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + boolean40 + "' != '" + true + "'", boolean40 == true);
    }

    @Test
    public void test119() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test119");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot4 = null;
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace7.setType("hi!");
        objects.Client client10 = null;
        businessLogic.Visit visit13 = new businessLogic.Visit((int) (byte) 0, date1, (int) (short) -1, (int) '4', parkingLot4, parkingSpace7, client10, (int) (short) 10, " -  (hi!)");
        java.lang.String str14 = visit13.getBookingID();
        objects.Client client15 = visit13.getClientDetail();
        objects.ParkingLot parkingLot16 = visit13.getParkingLot();
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "0" + "'", str14, "0");
        org.junit.Assert.assertNull(client15);
        org.junit.Assert.assertNull(parkingLot16);
    }

    @Test
    public void test120() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test120");
        objects.Visitor visitor2 = new objects.Visitor(" -  (hi!)", "");
    }

    @Test
    public void test121() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test121");
        businessLogic.SystemDatabaseFacade.addRevenue((int) (short) -1);
    }

    @Test
    public void test122() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test122");
        objects.ParkingLot parkingLot3 = new objects.ParkingLot(" -  (hi!)", "hi!", (int) (short) 1);
        java.lang.String str4 = parkingLot3.getName();
        int int5 = parkingLot3.getId();
        parkingLot3.setId((int) (byte) -1);
        objects.ParkingLot parkingLot11 = new objects.ParkingLot(" -  (hi!)", "hi!", (int) (short) 1);
        java.lang.String str12 = parkingLot11.getName();
        int int13 = parkingLot11.getId();
        parkingLot11.setId((int) (byte) -1);
        boolean boolean16 = parkingLot11.isEnabled();
        java.util.Date date18 = null;
        objects.ParkingLot parkingLot21 = null;
        objects.ParkingSpace parkingSpace24 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace24.setType("hi!");
        objects.Client client27 = null;
        businessLogic.Visit visit30 = new businessLogic.Visit((int) (byte) 0, date18, (int) (short) -1, (int) '4', parkingLot21, parkingSpace24, client27, (int) (short) 10, " -  (hi!)");
        java.lang.String str31 = visit30.getBookingID();
        java.lang.String str32 = visit30.getLicence();
        java.lang.String str33 = visit30.getFormattedStartTime();
        objects.ParkingSpace parkingSpace36 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace36.setType("hi!");
        objects.ParkingSpace parkingSpace41 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace36.update(parkingSpace41, true);
        objects.Car car44 = parkingSpace41.getParkedCar();
        objects.Client client48 = null;
        objects.Car car49 = new objects.Car("", "", "hi!", client48);
        java.lang.String str50 = car49.toString();
        car49.setModel(" -  (hi!)");
        objects.FacultyMember facultyMember55 = new objects.FacultyMember("", " -  (hi!)");
        car49.setOwner((objects.Client) facultyMember55);
        boolean boolean57 = parkingSpace41.parkCar(car49);
        visit30.setParkingSpace(parkingSpace41);
        parkingLot11.addParkingSpace(parkingSpace41);
        objects.Car car60 = parkingSpace41.removeCar();
        int int61 = parkingSpace41.getSpaceId();
        parkingLot3.addParkingSpace(parkingSpace41);
        objects.Car car63 = parkingSpace41.getParkedCar();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + " -  (hi!)" + "'", str4, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
        org.junit.Assert.assertEquals("'" + str12 + "' != '" + " -  (hi!)" + "'", str12, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 0 + "'", int13 == 0);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + true + "'", boolean16 == true);
        org.junit.Assert.assertEquals("'" + str31 + "' != '" + "0" + "'", str31, "0");
        org.junit.Assert.assertEquals("'" + str32 + "' != '" + " -  (hi!)" + "'", str32, " -  (hi!)");
        org.junit.Assert.assertEquals("'" + str33 + "' != '" + "31/12/1969" + "'", str33, "31/12/1969");
        org.junit.Assert.assertNull(car44);
        org.junit.Assert.assertEquals("'" + str50 + "' != '" + " -  (hi!)" + "'", str50, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + boolean57 + "' != '" + true + "'", boolean57 == true);
        org.junit.Assert.assertNotNull(car60);
        org.junit.Assert.assertTrue("'" + int61 + "' != '" + 100 + "'", int61 == 100);
        org.junit.Assert.assertNull(car63);
    }

    @Test
    public void test123() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test123");
        objects.ParkingSpace parkingSpace2 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.setType("hi!");
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.update(parkingSpace7, true);
        objects.Car car10 = parkingSpace7.getParkedCar();
        objects.Car car11 = parkingSpace7.getParkedCar();
        org.junit.Assert.assertNull(car10);
        org.junit.Assert.assertNull(car11);
    }

    @Test
    public void test124() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test124");
        java.util.Date date1 = null;
        objects.ParkingSpace parkingSpace6 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace6.setType("hi!");
        objects.ParkingSpace parkingSpace11 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace6.update(parkingSpace11, true);
        objects.Car car14 = parkingSpace11.getParkedCar();
        parkingSpace11.setOccupied(false);
        objects.Car car17 = parkingSpace11.getParkedCar();
        objects.ParkingLot parkingLot21 = new objects.ParkingLot(" -  (hi!)", "hi!", (int) (short) 1);
        java.lang.String str22 = parkingLot21.getLocation();
        parkingSpace11.setParkingLot(parkingLot21);
        parkingLot21.setEnabled(true);
        java.lang.String str26 = parkingLot21.getName();
        objects.ParkingSpace parkingSpace29 = new objects.ParkingSpace((int) (short) 100, "hi!");
        objects.ParkingSensor parkingSensor30 = parkingSpace29.getSensor();
        objects.FacultyMember facultyMember33 = new objects.FacultyMember(" -  (hi!)", " -  (hi!)");
        int int34 = facultyMember33.getParkingRate();
        facultyMember33.setPassword("superManager");
        businessLogic.Visit visit39 = new businessLogic.Visit((int) (byte) 1, date1, (int) (short) 0, 0, parkingLot21, parkingSpace29, (objects.Client) facultyMember33, 10, "Enabled");
        org.junit.Assert.assertNull(car14);
        org.junit.Assert.assertNull(car17);
        org.junit.Assert.assertEquals("'" + str22 + "' != '" + "hi!" + "'", str22, "hi!");
        org.junit.Assert.assertEquals("'" + str26 + "' != '" + " -  (hi!)" + "'", str26, " -  (hi!)");
        org.junit.Assert.assertNull(parkingSensor30);
        org.junit.Assert.assertTrue("'" + int34 + "' != '" + 8 + "'", int34 == 8);
    }

    @Test
    public void test125() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test125");
        objects.SuperManager superManager0 = new objects.SuperManager();
        java.lang.String str1 = superManager0.getUserName();
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "superManager" + "'", str1, "superManager");
    }

    @Test
    public void test126() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test126");
        objects.ParkingLot parkingLot3 = new objects.ParkingLot(" -  (hi!)", "hi!", (int) (short) 1);
        java.lang.String str4 = parkingLot3.getName();
        int int5 = parkingLot3.getId();
        parkingLot3.setId((int) (byte) -1);
        objects.ParkingLot parkingLot11 = new objects.ParkingLot(" -  (hi!)", "hi!", (int) (short) 1);
        java.lang.String str12 = parkingLot11.getName();
        int int13 = parkingLot11.getId();
        parkingLot11.setId((int) (byte) -1);
        boolean boolean16 = parkingLot11.isEnabled();
        java.util.Date date18 = null;
        objects.ParkingLot parkingLot21 = null;
        objects.ParkingSpace parkingSpace24 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace24.setType("hi!");
        objects.Client client27 = null;
        businessLogic.Visit visit30 = new businessLogic.Visit((int) (byte) 0, date18, (int) (short) -1, (int) '4', parkingLot21, parkingSpace24, client27, (int) (short) 10, " -  (hi!)");
        java.lang.String str31 = visit30.getBookingID();
        java.lang.String str32 = visit30.getLicence();
        java.lang.String str33 = visit30.getFormattedStartTime();
        objects.ParkingSpace parkingSpace36 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace36.setType("hi!");
        objects.ParkingSpace parkingSpace41 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace36.update(parkingSpace41, true);
        objects.Car car44 = parkingSpace41.getParkedCar();
        objects.Client client48 = null;
        objects.Car car49 = new objects.Car("", "", "hi!", client48);
        java.lang.String str50 = car49.toString();
        car49.setModel(" -  (hi!)");
        objects.FacultyMember facultyMember55 = new objects.FacultyMember("", " -  (hi!)");
        car49.setOwner((objects.Client) facultyMember55);
        boolean boolean57 = parkingSpace41.parkCar(car49);
        visit30.setParkingSpace(parkingSpace41);
        parkingLot11.addParkingSpace(parkingSpace41);
        objects.Car car60 = parkingSpace41.removeCar();
        int int61 = parkingSpace41.getSpaceId();
        parkingLot3.addParkingSpace(parkingSpace41);
        parkingSpace41.unoccupy((int) (short) -1);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + " -  (hi!)" + "'", str4, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
        org.junit.Assert.assertEquals("'" + str12 + "' != '" + " -  (hi!)" + "'", str12, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 0 + "'", int13 == 0);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + true + "'", boolean16 == true);
        org.junit.Assert.assertEquals("'" + str31 + "' != '" + "0" + "'", str31, "0");
        org.junit.Assert.assertEquals("'" + str32 + "' != '" + " -  (hi!)" + "'", str32, " -  (hi!)");
        org.junit.Assert.assertEquals("'" + str33 + "' != '" + "31/12/1969" + "'", str33, "31/12/1969");
        org.junit.Assert.assertNull(car44);
        org.junit.Assert.assertEquals("'" + str50 + "' != '" + " -  (hi!)" + "'", str50, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + boolean57 + "' != '" + true + "'", boolean57 == true);
        org.junit.Assert.assertNotNull(car60);
        org.junit.Assert.assertTrue("'" + int61 + "' != '" + 100 + "'", int61 == 100);
    }

    @Test
    public void test127() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test127");
        java.util.Date date2 = null;
        objects.ParkingLot parkingLot5 = null;
        objects.ParkingSpace parkingSpace8 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace8.setType("hi!");
        objects.Client client11 = null;
        businessLogic.Visit visit14 = new businessLogic.Visit((int) (byte) 0, date2, (int) (short) -1, (int) '4', parkingLot5, parkingSpace8, client11, (int) (short) 10, " -  (hi!)");
        java.lang.String str15 = visit14.getBookingID();
        java.lang.String str16 = visit14.getLicence();
        java.lang.String str17 = visit14.getFormattedStartTime();
        objects.ParkingSpace parkingSpace20 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace20.setType("hi!");
        objects.ParkingSpace parkingSpace25 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace20.update(parkingSpace25, true);
        objects.Car car28 = parkingSpace25.getParkedCar();
        objects.Client client32 = null;
        objects.Car car33 = new objects.Car("", "", "hi!", client32);
        java.lang.String str34 = car33.toString();
        car33.setModel(" -  (hi!)");
        objects.FacultyMember facultyMember39 = new objects.FacultyMember("", " -  (hi!)");
        car33.setOwner((objects.Client) facultyMember39);
        boolean boolean41 = parkingSpace25.parkCar(car33);
        visit14.setParkingSpace(parkingSpace25);
        objects.ParkingSensor parkingSensor43 = new objects.ParkingSensor((int) 'a', parkingSpace25);
        boolean boolean44 = parkingSensor43.isOccupied();
        boolean boolean45 = parkingSensor43.isOccupied();
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + "0" + "'", str15, "0");
        org.junit.Assert.assertEquals("'" + str16 + "' != '" + " -  (hi!)" + "'", str16, " -  (hi!)");
        org.junit.Assert.assertEquals("'" + str17 + "' != '" + "31/12/1969" + "'", str17, "31/12/1969");
        org.junit.Assert.assertNull(car28);
        org.junit.Assert.assertEquals("'" + str34 + "' != '" + " -  (hi!)" + "'", str34, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + boolean41 + "' != '" + true + "'", boolean41 == true);
        org.junit.Assert.assertTrue("'" + boolean44 + "' != '" + false + "'", boolean44 == false);
        org.junit.Assert.assertTrue("'" + boolean45 + "' != '" + false + "'", boolean45 == false);
    }

    @Test
    public void test128() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test128");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot4 = null;
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace7.setType("hi!");
        objects.Client client10 = null;
        businessLogic.Visit visit13 = new businessLogic.Visit((int) (byte) 0, date1, (int) (short) -1, (int) '4', parkingLot4, parkingSpace7, client10, (int) (short) 10, " -  (hi!)");
        java.lang.String str14 = visit13.getBookingID();
        objects.Client client15 = visit13.getClientDetail();
        boolean boolean16 = visit13.isCheckedIn();
        objects.ParkingSpace parkingSpace17 = visit13.getParkingSpace();
        java.lang.String str18 = visit13.getLicence();
        // The following exception was thrown during execution in test generation
        try {
            java.util.Date date19 = visit13.getEndTime();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: date must not be null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "0" + "'", str14, "0");
        org.junit.Assert.assertNull(client15);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNotNull(parkingSpace17);
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + " -  (hi!)" + "'", str18, " -  (hi!)");
    }

    @Test
    public void test129() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test129");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot7 = new objects.ParkingLot(" -  (hi!)", "hi!", (int) (short) 1);
        java.lang.String str8 = parkingLot7.getName();
        int int9 = parkingLot7.getId();
        parkingLot7.setId((int) (byte) -1);
        boolean boolean12 = parkingLot7.isEnabled();
        objects.ParkingSpace parkingSpace15 = new objects.ParkingSpace((int) (short) 100, "hi!");
        objects.Client client19 = null;
        objects.Car car20 = new objects.Car("", "", "hi!", client19);
        objects.FacultyMember facultyMember23 = new objects.FacultyMember("", " -  (hi!)");
        car20.setOwner((objects.Client) facultyMember23);
        businessLogic.Visit visit27 = new businessLogic.Visit(8, date1, (int) (byte) 100, (int) (short) 10, parkingLot7, parkingSpace15, (objects.Client) facultyMember23, 8, "Enabled");
        int int28 = parkingLot7.getTotalCapacity();
        parkingLot7.setCapacity(52);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + " -  (hi!)" + "'", str8, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 0 + "'", int9 == 0);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
        org.junit.Assert.assertTrue("'" + int28 + "' != '" + 1 + "'", int28 == 1);
    }

    @Test
    public void test130() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test130");
        objects.ParkingSpace parkingSpace2 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.setType("hi!");
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.update(parkingSpace7, true);
        objects.Car car10 = parkingSpace7.getParkedCar();
        objects.Client client14 = null;
        objects.Car car15 = new objects.Car("", "", "hi!", client14);
        java.lang.String str16 = car15.toString();
        car15.setModel(" -  (hi!)");
        objects.FacultyMember facultyMember21 = new objects.FacultyMember("", " -  (hi!)");
        car15.setOwner((objects.Client) facultyMember21);
        boolean boolean23 = parkingSpace7.parkCar(car15);
        car15.setLicensePlate("Enabled");
        objects.Client client26 = car15.getOwner();
        client26.setPassword("hi!");
        org.junit.Assert.assertNull(car10);
        org.junit.Assert.assertEquals("'" + str16 + "' != '" + " -  (hi!)" + "'", str16, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + true + "'", boolean23 == true);
        org.junit.Assert.assertNotNull(client26);
    }

    @Test
    public void test131() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test131");
        objects.FacultyMember facultyMember2 = new objects.FacultyMember("0", "hi!");
        java.lang.String str3 = facultyMember2.getValidationStatus();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "NotValidated" + "'", str3, "NotValidated");
    }

    @Test
    public void test132() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test132");
        objects.ParkingSpace parkingSpace2 = new objects.ParkingSpace((int) (short) -1, "0");
    }

    @Test
    public void test133() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test133");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot4 = null;
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace7.setType("hi!");
        objects.Client client10 = null;
        businessLogic.Visit visit13 = new businessLogic.Visit((int) (byte) 0, date1, (int) (short) -1, (int) '4', parkingLot4, parkingSpace7, client10, (int) (short) 10, " -  (hi!)");
        java.lang.String str14 = visit13.getBookingID();
        java.lang.String str15 = visit13.getLicence();
        java.util.Date date16 = null;
        visit13.setStartTime(date16);
        objects.ParkingLot parkingLot18 = visit13.getParkingLot();
        visit13.setDuration((int) (byte) 1);
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "0" + "'", str14, "0");
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + " -  (hi!)" + "'", str15, " -  (hi!)");
        org.junit.Assert.assertNull(parkingLot18);
    }

    @Test
    public void test134() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test134");
        objects.ParkingSpace parkingSpace2 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.setType("hi!");
        java.lang.String str5 = parkingSpace2.getOccupiedString();
        parkingSpace2.unoccupy((int) (byte) -1);
        parkingSpace2.setOccupied(true);
        java.lang.String str10 = parkingSpace2.getType();
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "Available" + "'", str5, "Available");
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "hi!" + "'", str10, "hi!");
    }

    @Test
    public void test135() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test135");
        objects.ParkingSpace parkingSpace2 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.setType("hi!");
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.update(parkingSpace7, true);
        objects.Car car10 = parkingSpace7.getParkedCar();
        java.lang.String str11 = parkingSpace7.getOccupiedString();
        objects.ParkingSpace parkingSpace14 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace14.setType("hi!");
        objects.ParkingSpace parkingSpace19 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace14.update(parkingSpace19, true);
        objects.Car car22 = parkingSpace19.getParkedCar();
        parkingSpace7.update(parkingSpace19, false);
        java.lang.String str25 = parkingSpace19.getType();
        parkingSpace19.setType("NotValidated");
        org.junit.Assert.assertNull(car10);
        org.junit.Assert.assertEquals("'" + str11 + "' != '" + "Available" + "'", str11, "Available");
        org.junit.Assert.assertNull(car22);
        org.junit.Assert.assertEquals("'" + str25 + "' != '" + "hi!" + "'", str25, "hi!");
    }

    @Test
    public void test136() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test136");
        objects.ParkingLot parkingLot3 = new objects.ParkingLot(" -  (hi!)", "hi!", (int) (short) 1);
        java.lang.String str4 = parkingLot3.getName();
        int int5 = parkingLot3.getId();
        parkingLot3.setId((int) (byte) -1);
        boolean boolean8 = parkingLot3.isEnabled();
        java.util.Date date10 = null;
        objects.ParkingLot parkingLot13 = null;
        objects.ParkingSpace parkingSpace16 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace16.setType("hi!");
        objects.Client client19 = null;
        businessLogic.Visit visit22 = new businessLogic.Visit((int) (byte) 0, date10, (int) (short) -1, (int) '4', parkingLot13, parkingSpace16, client19, (int) (short) 10, " -  (hi!)");
        java.lang.String str23 = visit22.getBookingID();
        java.lang.String str24 = visit22.getLicence();
        java.lang.String str25 = visit22.getFormattedStartTime();
        objects.ParkingSpace parkingSpace28 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace28.setType("hi!");
        objects.ParkingSpace parkingSpace33 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace28.update(parkingSpace33, true);
        objects.Car car36 = parkingSpace33.getParkedCar();
        objects.Client client40 = null;
        objects.Car car41 = new objects.Car("", "", "hi!", client40);
        java.lang.String str42 = car41.toString();
        car41.setModel(" -  (hi!)");
        objects.FacultyMember facultyMember47 = new objects.FacultyMember("", " -  (hi!)");
        car41.setOwner((objects.Client) facultyMember47);
        boolean boolean49 = parkingSpace33.parkCar(car41);
        visit22.setParkingSpace(parkingSpace33);
        parkingLot3.addParkingSpace(parkingSpace33);
        objects.Car car52 = parkingSpace33.removeCar();
        java.lang.String str53 = car52.getModel();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + " -  (hi!)" + "'", str4, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertEquals("'" + str23 + "' != '" + "0" + "'", str23, "0");
        org.junit.Assert.assertEquals("'" + str24 + "' != '" + " -  (hi!)" + "'", str24, " -  (hi!)");
        org.junit.Assert.assertEquals("'" + str25 + "' != '" + "31/12/1969" + "'", str25, "31/12/1969");
        org.junit.Assert.assertNull(car36);
        org.junit.Assert.assertEquals("'" + str42 + "' != '" + " -  (hi!)" + "'", str42, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + boolean49 + "' != '" + true + "'", boolean49 == true);
        org.junit.Assert.assertNotNull(car52);
        org.junit.Assert.assertEquals("'" + str53 + "' != '" + " -  (hi!)" + "'", str53, " -  (hi!)");
    }

    @Test
    public void test137() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test137");
        java.util.Date date2 = null;
        objects.ParkingLot parkingLot5 = null;
        objects.ParkingSpace parkingSpace8 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace8.setType("hi!");
        objects.Client client11 = null;
        businessLogic.Visit visit14 = new businessLogic.Visit((int) (byte) 0, date2, (int) (short) -1, (int) '4', parkingLot5, parkingSpace8, client11, (int) (short) 10, " -  (hi!)");
        java.lang.String str15 = visit14.getBookingID();
        java.lang.String str16 = visit14.getLicence();
        java.lang.String str17 = visit14.getFormattedStartTime();
        objects.ParkingSpace parkingSpace20 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace20.setType("hi!");
        objects.ParkingSpace parkingSpace25 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace20.update(parkingSpace25, true);
        objects.Car car28 = parkingSpace25.getParkedCar();
        objects.Client client32 = null;
        objects.Car car33 = new objects.Car("", "", "hi!", client32);
        java.lang.String str34 = car33.toString();
        car33.setModel(" -  (hi!)");
        objects.FacultyMember facultyMember39 = new objects.FacultyMember("", " -  (hi!)");
        car33.setOwner((objects.Client) facultyMember39);
        boolean boolean41 = parkingSpace25.parkCar(car33);
        visit14.setParkingSpace(parkingSpace25);
        objects.ParkingSensor parkingSensor43 = new objects.ParkingSensor((int) 'a', parkingSpace25);
        objects.ParkingStatusObserver parkingStatusObserver44 = null;
        parkingSensor43.removeObserver(parkingStatusObserver44);
        objects.ParkingLot parkingLot49 = new objects.ParkingLot(" -  (hi!)", "hi!", (int) (short) 1);
        java.lang.String str50 = parkingLot49.getLocation();
        java.lang.String str51 = parkingLot49.getStatus();
        parkingSensor43.removeObserver((objects.ParkingStatusObserver) parkingLot49);
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + "0" + "'", str15, "0");
        org.junit.Assert.assertEquals("'" + str16 + "' != '" + " -  (hi!)" + "'", str16, " -  (hi!)");
        org.junit.Assert.assertEquals("'" + str17 + "' != '" + "31/12/1969" + "'", str17, "31/12/1969");
        org.junit.Assert.assertNull(car28);
        org.junit.Assert.assertEquals("'" + str34 + "' != '" + " -  (hi!)" + "'", str34, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + boolean41 + "' != '" + true + "'", boolean41 == true);
        org.junit.Assert.assertEquals("'" + str50 + "' != '" + "hi!" + "'", str50, "hi!");
        org.junit.Assert.assertEquals("'" + str51 + "' != '" + "Enabled" + "'", str51, "Enabled");
    }

    @Test
    public void test138() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test138");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot4 = null;
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace7.setType("hi!");
        objects.Client client10 = null;
        businessLogic.Visit visit13 = new businessLogic.Visit((int) (byte) 0, date1, (int) (short) -1, (int) '4', parkingLot4, parkingSpace7, client10, (int) (short) 10, " -  (hi!)");
        java.lang.String str14 = visit13.getBookingID();
        java.lang.String str15 = visit13.getLicence();
        java.lang.String str16 = visit13.getFormattedStartTime();
        java.lang.String str17 = visit13.getFormattedStartTime();
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "0" + "'", str14, "0");
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + " -  (hi!)" + "'", str15, " -  (hi!)");
        org.junit.Assert.assertEquals("'" + str16 + "' != '" + "31/12/1969" + "'", str16, "31/12/1969");
        org.junit.Assert.assertEquals("'" + str17 + "' != '" + "31/12/1969" + "'", str17, "31/12/1969");
    }

    @Test
    public void test139() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test139");
        objects.ParkingSpace parkingSpace2 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.setType("hi!");
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.update(parkingSpace7, true);
        objects.Car car10 = parkingSpace7.getParkedCar();
        parkingSpace7.setOccupied(false);
        objects.Car car13 = parkingSpace7.getParkedCar();
        objects.ParkingLot parkingLot17 = new objects.ParkingLot(" -  (hi!)", "hi!", (int) (short) 1);
        java.lang.String str18 = parkingLot17.getLocation();
        parkingSpace7.setParkingLot(parkingLot17);
        parkingLot17.setEnabled(true);
        java.lang.String str22 = parkingLot17.getName();
        parkingLot17.setName("Super Manager");
        org.junit.Assert.assertNull(car10);
        org.junit.Assert.assertNull(car13);
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + "hi!" + "'", str18, "hi!");
        org.junit.Assert.assertEquals("'" + str22 + "' != '" + " -  (hi!)" + "'", str22, " -  (hi!)");
    }

    @Test
    public void test140() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test140");
        objects.ParkingLot parkingLot3 = new objects.ParkingLot("Validated", "", (int) (byte) 0);
    }

    @Test
    public void test141() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test141");
        objects.Student student2 = new objects.Student("Manager", "Manager");
    }

    @Test
    public void test142() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test142");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot7 = new objects.ParkingLot(" -  (hi!)", "hi!", (int) (short) 1);
        java.lang.String str8 = parkingLot7.getName();
        int int9 = parkingLot7.getId();
        parkingLot7.setId((int) (byte) -1);
        boolean boolean12 = parkingLot7.isEnabled();
        objects.ParkingSpace parkingSpace15 = new objects.ParkingSpace((int) (short) 100, "hi!");
        objects.Client client19 = null;
        objects.Car car20 = new objects.Car("", "", "hi!", client19);
        objects.FacultyMember facultyMember23 = new objects.FacultyMember("", " -  (hi!)");
        car20.setOwner((objects.Client) facultyMember23);
        businessLogic.Visit visit27 = new businessLogic.Visit(8, date1, (int) (byte) 100, (int) (short) 10, parkingLot7, parkingSpace15, (objects.Client) facultyMember23, 8, "Enabled");
        boolean boolean28 = visit27.isCheckedIn();
        // The following exception was thrown during execution in test generation
        try {
            java.util.Date date29 = visit27.getStartTime();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: date must not be null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + " -  (hi!)" + "'", str8, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 0 + "'", int9 == 0);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
        org.junit.Assert.assertTrue("'" + boolean28 + "' != '" + false + "'", boolean28 == false);
    }

    @Test
    public void test143() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test143");
        objects.ParkingSpace parkingSpace2 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.setType("hi!");
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.update(parkingSpace7, true);
        parkingSpace2.setEnabled(true);
        java.util.Date date14 = null;
        objects.ParkingLot parkingLot17 = null;
        objects.ParkingSpace parkingSpace20 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace20.setType("hi!");
        objects.Client client23 = null;
        businessLogic.Visit visit26 = new businessLogic.Visit((int) (byte) 0, date14, (int) (short) -1, (int) '4', parkingLot17, parkingSpace20, client23, (int) (short) 10, " -  (hi!)");
        java.lang.String str27 = visit26.getBookingID();
        java.lang.String str28 = visit26.getLicence();
        java.lang.String str29 = visit26.getFormattedStartTime();
        objects.ParkingSpace parkingSpace32 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace32.setType("hi!");
        objects.ParkingSpace parkingSpace37 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace32.update(parkingSpace37, true);
        objects.Car car40 = parkingSpace37.getParkedCar();
        objects.Client client44 = null;
        objects.Car car45 = new objects.Car("", "", "hi!", client44);
        java.lang.String str46 = car45.toString();
        car45.setModel(" -  (hi!)");
        objects.FacultyMember facultyMember51 = new objects.FacultyMember("", " -  (hi!)");
        car45.setOwner((objects.Client) facultyMember51);
        boolean boolean53 = parkingSpace37.parkCar(car45);
        visit26.setParkingSpace(parkingSpace37);
        objects.ParkingSensor parkingSensor55 = new objects.ParkingSensor((int) 'a', parkingSpace37);
        boolean boolean56 = parkingSensor55.isOccupied();
        objects.ParkingSpace parkingSpace59 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace59.setType("hi!");
        objects.ParkingSpace parkingSpace64 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace59.update(parkingSpace64, true);
        objects.Car car67 = parkingSpace64.getParkedCar();
        parkingSpace64.setOccupied(false);
        java.lang.String str70 = parkingSpace64.getEnablesString();
        objects.Car car71 = parkingSpace64.removeCar();
        parkingSensor55.addObserver((objects.ParkingStatusObserver) parkingSpace64);
        parkingSpace2.assignSensor(parkingSensor55);
        parkingSpace2.unoccupy((int) (short) 0);
        org.junit.Assert.assertEquals("'" + str27 + "' != '" + "0" + "'", str27, "0");
        org.junit.Assert.assertEquals("'" + str28 + "' != '" + " -  (hi!)" + "'", str28, " -  (hi!)");
        org.junit.Assert.assertEquals("'" + str29 + "' != '" + "31/12/1969" + "'", str29, "31/12/1969");
        org.junit.Assert.assertNull(car40);
        org.junit.Assert.assertEquals("'" + str46 + "' != '" + " -  (hi!)" + "'", str46, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + boolean53 + "' != '" + true + "'", boolean53 == true);
        org.junit.Assert.assertTrue("'" + boolean56 + "' != '" + false + "'", boolean56 == false);
        org.junit.Assert.assertNull(car67);
        org.junit.Assert.assertEquals("'" + str70 + "' != '" + "Enabled" + "'", str70, "Enabled");
        org.junit.Assert.assertNull(car71);
    }

    @Test
    public void test144() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test144");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot4 = null;
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace7.setType("hi!");
        objects.Client client10 = null;
        businessLogic.Visit visit13 = new businessLogic.Visit((int) (byte) 0, date1, (int) (short) -1, (int) '4', parkingLot4, parkingSpace7, client10, (int) (short) 10, " -  (hi!)");
        java.lang.String str14 = visit13.getBookingID();
        java.lang.String str15 = visit13.getLicence();
        java.lang.String str16 = visit13.getFormattedStartTime();
        visit13.setDuration((int) (byte) 10);
        java.lang.String str19 = visit13.getBookingID();
        java.lang.String str20 = visit13.getLicence();
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "0" + "'", str14, "0");
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + " -  (hi!)" + "'", str15, " -  (hi!)");
        org.junit.Assert.assertEquals("'" + str16 + "' != '" + "31/12/1969" + "'", str16, "31/12/1969");
        org.junit.Assert.assertEquals("'" + str19 + "' != '" + "0" + "'", str19, "0");
        org.junit.Assert.assertEquals("'" + str20 + "' != '" + " -  (hi!)" + "'", str20, " -  (hi!)");
    }

    @Test
    public void test145() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test145");
        objects.ParkingLot parkingLot3 = new objects.ParkingLot(" -  (hi!)", "hi!", (int) (short) 1);
        java.lang.String str4 = parkingLot3.getName();
        int int5 = parkingLot3.getId();
        parkingLot3.setId((int) (byte) -1);
        boolean boolean8 = parkingLot3.isEnabled();
        java.lang.String str9 = parkingLot3.getStatus();
        parkingLot3.setStatus(true);
        parkingLot3.setCapacity(0);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + " -  (hi!)" + "'", str4, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "Enabled" + "'", str9, "Enabled");
    }

    @Test
    public void test146() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test146");
        businessLogic.PaymentSystem paymentSystem0 = businessLogic.PaymentSystem.getInstance();
        boolean boolean2 = paymentSystem0.confirmRefund(10);
        java.lang.String str4 = paymentSystem0.getPaymentMethod(100);
        boolean boolean8 = paymentSystem0.confirmPayment((int) (short) 10, "Available - Manager (0)", 52);
        org.junit.Assert.assertNotNull(paymentSystem0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "Unknown" + "'", str4, "Unknown");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test147() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test147");
        businessLogic.Visit visit1 = businessLogic.Visit.getVisit(1);
        org.junit.Assert.assertNotNull(visit1);
    }

    @Test
    public void test148() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test148");
        objects.ParkingSpace parkingSpace2 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.setType("hi!");
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.update(parkingSpace7, true);
        objects.Car car10 = parkingSpace7.getParkedCar();
        parkingSpace7.setOccupied(false);
        objects.Car car13 = parkingSpace7.getParkedCar();
        boolean boolean14 = parkingSpace7.isEnabled();
        objects.ParkingSpace parkingSpace17 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace17.setType("hi!");
        objects.ParkingSpace parkingSpace22 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace17.update(parkingSpace22, true);
        objects.Car car25 = parkingSpace22.getParkedCar();
        objects.Client client29 = null;
        objects.Car car30 = new objects.Car("", "", "hi!", client29);
        java.lang.String str31 = car30.toString();
        car30.setModel(" -  (hi!)");
        objects.FacultyMember facultyMember36 = new objects.FacultyMember("", " -  (hi!)");
        car30.setOwner((objects.Client) facultyMember36);
        boolean boolean38 = parkingSpace22.parkCar(car30);
        java.lang.String str39 = car30.getLicensePlate();
        objects.FacultyMember facultyMember42 = new objects.FacultyMember(" -  (hi!)", " -  (hi!)");
        int int43 = facultyMember42.getParkingRate();
        facultyMember42.setPassword("hi!");
        car30.setOwner((objects.Client) facultyMember42);
        boolean boolean47 = parkingSpace7.parkCar(car30);
        parkingSpace7.setType("Space 100 (hi!): Enabled, Occupied, No Sensor");
        objects.ParkingSpace parkingSpace50 = parkingSpace7.clone();
        org.junit.Assert.assertNull(car10);
        org.junit.Assert.assertNull(car13);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + true + "'", boolean14 == true);
        org.junit.Assert.assertNull(car25);
        org.junit.Assert.assertEquals("'" + str31 + "' != '" + " -  (hi!)" + "'", str31, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + boolean38 + "' != '" + true + "'", boolean38 == true);
        org.junit.Assert.assertEquals("'" + str39 + "' != '" + "" + "'", str39, "");
        org.junit.Assert.assertTrue("'" + int43 + "' != '" + 8 + "'", int43 == 8);
        org.junit.Assert.assertTrue("'" + boolean47 + "' != '" + true + "'", boolean47 == true);
        org.junit.Assert.assertNotNull(parkingSpace50);
    }

    @Test
    public void test149() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test149");
        objects.Client client3 = null;
        objects.Car car4 = new objects.Car("", "", "hi!", client3);
        java.lang.String str5 = car4.getLicensePlate();
        car4.setColor("31/12/1969");
        objects.Client client8 = car4.getOwner();
        objects.FacultyMember facultyMember14 = new objects.FacultyMember("", " -  (hi!)");
        objects.Car car15 = new objects.Car("Available", "Manager", "0", (objects.Client) facultyMember14);
        facultyMember14.setEmail("0");
        car4.setOwner((objects.Client) facultyMember14);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertNull(client8);
    }

    @Test
    public void test150() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test150");
        objects.SuperManager superManager0 = new objects.SuperManager();
        java.lang.String str1 = superManager0.getUserName();
        boolean boolean5 = superManager0.approveTransaction((int) 'a', "0", 52);
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "superManager" + "'", str1, "superManager");
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
    }

    @Test
    public void test151() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test151");
        objects.Client client3 = null;
        objects.Car car4 = new objects.Car("", "", "hi!", client3);
        java.lang.String str5 = car4.toString();
        car4.setModel(" -  (hi!)");
        objects.FacultyMember facultyMember10 = new objects.FacultyMember("", " -  (hi!)");
        car4.setOwner((objects.Client) facultyMember10);
        objects.Client client12 = car4.getOwner();
        objects.Client client13 = car4.getOwner();
        objects.Visitor visitor16 = new objects.Visitor("Manager", "31/12/1969");
        java.lang.String str17 = visitor16.getValidationStatus();
        car4.setOwner((objects.Client) visitor16);
        boolean boolean19 = visitor16.isValidated();
        boolean boolean20 = visitor16.isValidated();
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + " -  (hi!)" + "'", str5, " -  (hi!)");
        org.junit.Assert.assertNotNull(client12);
        org.junit.Assert.assertNotNull(client13);
        org.junit.Assert.assertEquals("'" + str17 + "' != '" + "Validated" + "'", str17, "Validated");
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + true + "'", boolean19 == true);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + true + "'", boolean20 == true);
    }

    @Test
    public void test152() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test152");
        objects.NonFacultyStaff nonFacultyStaff2 = new objects.NonFacultyStaff("Enabled", "Enabled");
    }

    @Test
    public void test153() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test153");
        objects.SuperManager superManager0 = new objects.SuperManager();
        java.lang.String str1 = superManager0.getUserName();
        boolean boolean5 = superManager0.approveTransaction((int) 'a', "Super Manager", (int) (short) 10);
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "superManager" + "'", str1, "superManager");
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
    }

    @Test
    public void test154() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test154");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot4 = null;
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace7.setType("hi!");
        objects.Client client10 = null;
        businessLogic.Visit visit13 = new businessLogic.Visit((int) (byte) 0, date1, (int) (short) -1, (int) '4', parkingLot4, parkingSpace7, client10, (int) (short) 10, " -  (hi!)");
        java.lang.String str14 = visit13.getBookingID();
        java.lang.String str15 = visit13.getLicence();
        visit13.setDuration((int) 'a');
        java.lang.String str18 = visit13.getFormattedStartTime();
        visit13.setDuration((int) (byte) 10);
        visit13.setDuration();
        java.lang.String str22 = visit13.getLicence();
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "0" + "'", str14, "0");
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + " -  (hi!)" + "'", str15, " -  (hi!)");
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + "31/12/1969" + "'", str18, "31/12/1969");
        org.junit.Assert.assertEquals("'" + str22 + "' != '" + " -  (hi!)" + "'", str22, " -  (hi!)");
    }

    @Test
    public void test155() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test155");
        objects.Manager manager2 = new objects.Manager("Manager", "Available");
    }

    @Test
    public void test156() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test156");
        objects.ParkingLot parkingLot3 = new objects.ParkingLot(" -  (hi!)", "hi!", (int) (short) 1);
        java.lang.String str4 = parkingLot3.getName();
        int int5 = parkingLot3.getId();
        parkingLot3.setId((int) (byte) -1);
        boolean boolean8 = parkingLot3.isEnabled();
        java.util.Date date10 = null;
        objects.ParkingLot parkingLot13 = null;
        objects.ParkingSpace parkingSpace16 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace16.setType("hi!");
        objects.Client client19 = null;
        businessLogic.Visit visit22 = new businessLogic.Visit((int) (byte) 0, date10, (int) (short) -1, (int) '4', parkingLot13, parkingSpace16, client19, (int) (short) 10, " -  (hi!)");
        java.lang.String str23 = visit22.getBookingID();
        java.lang.String str24 = visit22.getLicence();
        java.lang.String str25 = visit22.getFormattedStartTime();
        objects.ParkingSpace parkingSpace28 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace28.setType("hi!");
        objects.ParkingSpace parkingSpace33 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace28.update(parkingSpace33, true);
        objects.Car car36 = parkingSpace33.getParkedCar();
        objects.Client client40 = null;
        objects.Car car41 = new objects.Car("", "", "hi!", client40);
        java.lang.String str42 = car41.toString();
        car41.setModel(" -  (hi!)");
        objects.FacultyMember facultyMember47 = new objects.FacultyMember("", " -  (hi!)");
        car41.setOwner((objects.Client) facultyMember47);
        boolean boolean49 = parkingSpace33.parkCar(car41);
        visit22.setParkingSpace(parkingSpace33);
        parkingLot3.addParkingSpace(parkingSpace33);
        objects.Car car52 = parkingSpace33.removeCar();
        objects.ParkingSpace parkingSpace53 = parkingSpace33.clone();
        java.util.Date date54 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean57 = parkingSpace33.isOccupied(date54, (int) (short) 1, (int) (byte) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: date must not be null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + " -  (hi!)" + "'", str4, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertEquals("'" + str23 + "' != '" + "0" + "'", str23, "0");
        org.junit.Assert.assertEquals("'" + str24 + "' != '" + " -  (hi!)" + "'", str24, " -  (hi!)");
        org.junit.Assert.assertEquals("'" + str25 + "' != '" + "31/12/1969" + "'", str25, "31/12/1969");
        org.junit.Assert.assertNull(car36);
        org.junit.Assert.assertEquals("'" + str42 + "' != '" + " -  (hi!)" + "'", str42, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + boolean49 + "' != '" + true + "'", boolean49 == true);
        org.junit.Assert.assertNotNull(car52);
        org.junit.Assert.assertNotNull(parkingSpace53);
    }

    @Test
    public void test157() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test157");
        java.util.Date date2 = null;
        objects.ParkingLot parkingLot5 = null;
        objects.ParkingSpace parkingSpace8 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace8.setType("hi!");
        objects.Client client11 = null;
        businessLogic.Visit visit14 = new businessLogic.Visit((int) (byte) 0, date2, (int) (short) -1, (int) '4', parkingLot5, parkingSpace8, client11, (int) (short) 10, " -  (hi!)");
        java.lang.String str15 = visit14.getBookingID();
        java.lang.String str16 = visit14.getLicence();
        java.lang.String str17 = visit14.getFormattedStartTime();
        objects.ParkingSpace parkingSpace20 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace20.setType("hi!");
        objects.ParkingSpace parkingSpace25 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace20.update(parkingSpace25, true);
        objects.Car car28 = parkingSpace25.getParkedCar();
        objects.Client client32 = null;
        objects.Car car33 = new objects.Car("", "", "hi!", client32);
        java.lang.String str34 = car33.toString();
        car33.setModel(" -  (hi!)");
        objects.FacultyMember facultyMember39 = new objects.FacultyMember("", " -  (hi!)");
        car33.setOwner((objects.Client) facultyMember39);
        boolean boolean41 = parkingSpace25.parkCar(car33);
        visit14.setParkingSpace(parkingSpace25);
        objects.ParkingSensor parkingSensor43 = new objects.ParkingSensor((int) 'a', parkingSpace25);
        objects.ParkingStatusObserver parkingStatusObserver44 = null;
        parkingSensor43.removeObserver(parkingStatusObserver44);
        parkingSensor43.detectVehicle(true);
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + "0" + "'", str15, "0");
        org.junit.Assert.assertEquals("'" + str16 + "' != '" + " -  (hi!)" + "'", str16, " -  (hi!)");
        org.junit.Assert.assertEquals("'" + str17 + "' != '" + "31/12/1969" + "'", str17, "31/12/1969");
        org.junit.Assert.assertNull(car28);
        org.junit.Assert.assertEquals("'" + str34 + "' != '" + " -  (hi!)" + "'", str34, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + boolean41 + "' != '" + true + "'", boolean41 == true);
    }

    @Test
    public void test158() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test158");
        objects.Student student2 = new objects.Student("0", "superManager");
        java.lang.String str3 = student2.getValidationStatus();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "NotValidated" + "'", str3, "NotValidated");
    }

    @Test
    public void test159() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test159");
        objects.ParkingLot parkingLot3 = new objects.ParkingLot(" -  (hi!)", "hi!", (int) (short) 1);
        java.lang.String str4 = parkingLot3.getName();
        int int5 = parkingLot3.getId();
        parkingLot3.setId((int) (byte) -1);
        objects.ParkingLot parkingLot11 = new objects.ParkingLot(" -  (hi!)", "hi!", (int) (short) 1);
        java.lang.String str12 = parkingLot11.getName();
        int int13 = parkingLot11.getId();
        parkingLot11.setId((int) (byte) -1);
        boolean boolean16 = parkingLot11.isEnabled();
        java.util.Date date18 = null;
        objects.ParkingLot parkingLot21 = null;
        objects.ParkingSpace parkingSpace24 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace24.setType("hi!");
        objects.Client client27 = null;
        businessLogic.Visit visit30 = new businessLogic.Visit((int) (byte) 0, date18, (int) (short) -1, (int) '4', parkingLot21, parkingSpace24, client27, (int) (short) 10, " -  (hi!)");
        java.lang.String str31 = visit30.getBookingID();
        java.lang.String str32 = visit30.getLicence();
        java.lang.String str33 = visit30.getFormattedStartTime();
        objects.ParkingSpace parkingSpace36 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace36.setType("hi!");
        objects.ParkingSpace parkingSpace41 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace36.update(parkingSpace41, true);
        objects.Car car44 = parkingSpace41.getParkedCar();
        objects.Client client48 = null;
        objects.Car car49 = new objects.Car("", "", "hi!", client48);
        java.lang.String str50 = car49.toString();
        car49.setModel(" -  (hi!)");
        objects.FacultyMember facultyMember55 = new objects.FacultyMember("", " -  (hi!)");
        car49.setOwner((objects.Client) facultyMember55);
        boolean boolean57 = parkingSpace41.parkCar(car49);
        visit30.setParkingSpace(parkingSpace41);
        parkingLot11.addParkingSpace(parkingSpace41);
        objects.Car car60 = parkingSpace41.removeCar();
        int int61 = parkingSpace41.getSpaceId();
        parkingLot3.addParkingSpace(parkingSpace41);
        java.lang.String str63 = parkingLot3.getName();
        java.lang.String str64 = parkingLot3.getName();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + " -  (hi!)" + "'", str4, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
        org.junit.Assert.assertEquals("'" + str12 + "' != '" + " -  (hi!)" + "'", str12, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 0 + "'", int13 == 0);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + true + "'", boolean16 == true);
        org.junit.Assert.assertEquals("'" + str31 + "' != '" + "0" + "'", str31, "0");
        org.junit.Assert.assertEquals("'" + str32 + "' != '" + " -  (hi!)" + "'", str32, " -  (hi!)");
        org.junit.Assert.assertEquals("'" + str33 + "' != '" + "31/12/1969" + "'", str33, "31/12/1969");
        org.junit.Assert.assertNull(car44);
        org.junit.Assert.assertEquals("'" + str50 + "' != '" + " -  (hi!)" + "'", str50, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + boolean57 + "' != '" + true + "'", boolean57 == true);
        org.junit.Assert.assertNotNull(car60);
        org.junit.Assert.assertTrue("'" + int61 + "' != '" + 100 + "'", int61 == 100);
        org.junit.Assert.assertEquals("'" + str63 + "' != '" + " -  (hi!)" + "'", str63, " -  (hi!)");
        org.junit.Assert.assertEquals("'" + str64 + "' != '" + " -  (hi!)" + "'", str64, " -  (hi!)");
    }

    @Test
    public void test160() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test160");
        objects.FacultyMember facultyMember2 = new objects.FacultyMember("Super Manager", "superManager");
        java.lang.String str3 = facultyMember2.getValidationStatus();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "NotValidated" + "'", str3, "NotValidated");
    }

    @Test
    public void test161() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test161");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot4 = null;
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace7.setType("hi!");
        objects.Client client10 = null;
        businessLogic.Visit visit13 = new businessLogic.Visit((int) (byte) 0, date1, (int) (short) -1, (int) '4', parkingLot4, parkingSpace7, client10, (int) (short) 10, " -  (hi!)");
        objects.ParkingLot parkingLot14 = visit13.getParkingLot();
        objects.ParkingSpace parkingSpace15 = visit13.getParkingSpace();
        objects.ParkingSpace parkingSpace16 = parkingSpace15.clone();
        java.lang.String str17 = parkingSpace15.getOccupiedString();
        org.junit.Assert.assertNull(parkingLot14);
        org.junit.Assert.assertNotNull(parkingSpace15);
        org.junit.Assert.assertNotNull(parkingSpace16);
        org.junit.Assert.assertEquals("'" + str17 + "' != '" + "Available" + "'", str17, "Available");
    }

    @Test
    public void test162() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test162");
        objects.ParkingSpace parkingSpace3 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace3.setType("hi!");
        objects.ParkingSpace parkingSpace8 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace3.update(parkingSpace8, true);
        objects.Car car11 = parkingSpace8.getParkedCar();
        objects.Client client15 = null;
        objects.Car car16 = new objects.Car("", "", "hi!", client15);
        java.lang.String str17 = car16.toString();
        car16.setModel(" -  (hi!)");
        objects.FacultyMember facultyMember22 = new objects.FacultyMember("", " -  (hi!)");
        car16.setOwner((objects.Client) facultyMember22);
        boolean boolean24 = parkingSpace8.parkCar(car16);
        objects.ParkingSensor parkingSensor25 = new objects.ParkingSensor((int) (byte) -1, parkingSpace8);
        java.util.Date date27 = null;
        objects.ParkingLot parkingLot30 = null;
        objects.ParkingSpace parkingSpace33 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace33.setType("hi!");
        objects.Client client36 = null;
        businessLogic.Visit visit39 = new businessLogic.Visit((int) (byte) 0, date27, (int) (short) -1, (int) '4', parkingLot30, parkingSpace33, client36, (int) (short) 10, " -  (hi!)");
        objects.ParkingLot parkingLot40 = visit39.getParkingLot();
        objects.ParkingSpace parkingSpace41 = visit39.getParkingSpace();
        objects.ParkingSpace parkingSpace42 = parkingSpace41.clone();
        parkingSpace41.unoccupyTime(1);
        parkingSensor25.removeObserver((objects.ParkingStatusObserver) parkingSpace41);
        parkingSensor25.detectVehicle(true);
        org.junit.Assert.assertNull(car11);
        org.junit.Assert.assertEquals("'" + str17 + "' != '" + " -  (hi!)" + "'", str17, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + true + "'", boolean24 == true);
        org.junit.Assert.assertNull(parkingLot40);
        org.junit.Assert.assertNotNull(parkingSpace41);
        org.junit.Assert.assertNotNull(parkingSpace42);
    }

    @Test
    public void test163() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test163");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot7 = new objects.ParkingLot(" -  (hi!)", "hi!", (int) (short) 1);
        java.lang.String str8 = parkingLot7.getName();
        int int9 = parkingLot7.getId();
        parkingLot7.setId((int) (byte) -1);
        boolean boolean12 = parkingLot7.isEnabled();
        objects.ParkingSpace parkingSpace15 = new objects.ParkingSpace((int) (short) 100, "hi!");
        objects.Client client19 = null;
        objects.Car car20 = new objects.Car("", "", "hi!", client19);
        objects.FacultyMember facultyMember23 = new objects.FacultyMember("", " -  (hi!)");
        car20.setOwner((objects.Client) facultyMember23);
        businessLogic.Visit visit27 = new businessLogic.Visit(8, date1, (int) (byte) 100, (int) (short) 10, parkingLot7, parkingSpace15, (objects.Client) facultyMember23, 8, "Enabled");
        visit27.setDuration();
        int int29 = visit27.getInitialTime();
        int int30 = visit27.getMoneyPaid();
        visit27.setMoneyPaid((int) '#');
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + " -  (hi!)" + "'", str8, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 0 + "'", int9 == 0);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
        org.junit.Assert.assertTrue("'" + int29 + "' != '" + 100 + "'", int29 == 100);
        org.junit.Assert.assertTrue("'" + int30 + "' != '" + 0 + "'", int30 == 0);
    }

    @Test
    public void test164() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test164");
        businessLogic.Visit visit1 = businessLogic.Visit.getVisit("Manager");
        org.junit.Assert.assertNull(visit1);
    }

    @Test
    public void test165() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test165");
        objects.ParkingSpace parkingSpace2 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.setType("hi!");
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.update(parkingSpace7, true);
        objects.Car car10 = parkingSpace7.getParkedCar();
        parkingSpace7.setOccupied(false);
        objects.Car car13 = parkingSpace7.getParkedCar();
        objects.ParkingLot parkingLot17 = new objects.ParkingLot(" -  (hi!)", "hi!", (int) (short) 1);
        java.lang.String str18 = parkingLot17.getLocation();
        parkingSpace7.setParkingLot(parkingLot17);
        java.util.Date date20 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean23 = parkingSpace7.isOccupied(date20, (int) (short) 1, (int) ' ');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: date must not be null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(car10);
        org.junit.Assert.assertNull(car13);
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + "hi!" + "'", str18, "hi!");
    }

    @Test
    public void test166() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test166");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot7 = new objects.ParkingLot(" -  (hi!)", "hi!", (int) (short) 1);
        java.lang.String str8 = parkingLot7.getName();
        int int9 = parkingLot7.getId();
        parkingLot7.setId((int) (byte) -1);
        boolean boolean12 = parkingLot7.isEnabled();
        objects.ParkingSpace parkingSpace15 = new objects.ParkingSpace((int) (short) 100, "hi!");
        objects.Client client19 = null;
        objects.Car car20 = new objects.Car("", "", "hi!", client19);
        objects.FacultyMember facultyMember23 = new objects.FacultyMember("", " -  (hi!)");
        car20.setOwner((objects.Client) facultyMember23);
        businessLogic.Visit visit27 = new businessLogic.Visit(8, date1, (int) (byte) 100, (int) (short) 10, parkingLot7, parkingSpace15, (objects.Client) facultyMember23, 8, "Enabled");
        boolean boolean29 = parkingLot7.removeParkingSpace((int) (byte) -1);
        java.util.List<objects.ParkingSpace> parkingSpaceList30 = parkingLot7.getAllSpaces();
        parkingLot7.setStatus(false);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + " -  (hi!)" + "'", str8, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 0 + "'", int9 == 0);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
        org.junit.Assert.assertNotNull(parkingSpaceList30);
    }

    @Test
    public void test167() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test167");
        objects.Manager manager2 = new objects.Manager("0", "hi!");
        java.lang.String str3 = manager2.getPassword();
        java.lang.String str4 = manager2.getRole();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "hi!" + "'", str3, "hi!");
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "Manager" + "'", str4, "Manager");
    }

    @Test
    public void test168() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test168");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot4 = null;
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace7.setType("hi!");
        objects.Client client10 = null;
        businessLogic.Visit visit13 = new businessLogic.Visit((int) (byte) 0, date1, (int) (short) -1, (int) '4', parkingLot4, parkingSpace7, client10, (int) (short) 10, " -  (hi!)");
        java.lang.String str14 = visit13.getBookingID();
        java.util.Date date15 = null;
        visit13.setEndTime(date15);
        boolean boolean17 = visit13.hasExceededHour();
        java.util.Date date18 = null;
        visit13.setStartTime(date18);
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "0" + "'", str14, "0");
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + true + "'", boolean17 == true);
    }

    @Test
    public void test169() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test169");
        objects.ParkingSpace parkingSpace2 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.setType("hi!");
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.update(parkingSpace7, true);
        objects.Car car10 = parkingSpace7.getParkedCar();
        java.lang.String str11 = parkingSpace7.getOccupiedString();
        objects.ParkingSpace parkingSpace14 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace14.setType("hi!");
        objects.ParkingSpace parkingSpace19 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace14.update(parkingSpace19, true);
        objects.Car car22 = parkingSpace19.getParkedCar();
        parkingSpace7.update(parkingSpace19, false);
        java.lang.String str25 = parkingSpace19.getType();
        java.util.Date date27 = null;
        // The following exception was thrown during execution in test generation
        try {
            parkingSpace19.occupyTime((int) (short) 10, date27, (int) (short) 0, 1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: date must not be null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(car10);
        org.junit.Assert.assertEquals("'" + str11 + "' != '" + "Available" + "'", str11, "Available");
        org.junit.Assert.assertNull(car22);
        org.junit.Assert.assertEquals("'" + str25 + "' != '" + "hi!" + "'", str25, "hi!");
    }

    @Test
    public void test170() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test170");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot4 = null;
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace7.setType("hi!");
        objects.Client client10 = null;
        businessLogic.Visit visit13 = new businessLogic.Visit((int) (byte) 0, date1, (int) (short) -1, (int) '4', parkingLot4, parkingSpace7, client10, (int) (short) 10, " -  (hi!)");
        java.lang.String str14 = visit13.getBookingID();
        objects.Client client15 = visit13.getClientDetail();
        boolean boolean16 = visit13.isCheckedIn();
        objects.ParkingSpace parkingSpace17 = visit13.getParkingSpace();
        java.lang.String str18 = parkingSpace17.getEnablesString();
        java.lang.String str19 = parkingSpace17.toString();
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "0" + "'", str14, "0");
        org.junit.Assert.assertNull(client15);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNotNull(parkingSpace17);
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + "Enabled" + "'", str18, "Enabled");
        org.junit.Assert.assertEquals("'" + str19 + "' != '" + "Space 100 (hi!): Enabled, Available, No Sensor" + "'", str19, "Space 100 (hi!): Enabled, Available, No Sensor");
    }

    @Test
    public void test171() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test171");
        objects.ParkingSpace parkingSpace2 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.setType("hi!");
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.update(parkingSpace7, true);
        parkingSpace7.unoccupyTime(1);
        objects.ParkingSpace parkingSpace14 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace14.setType("hi!");
        objects.ParkingSpace parkingSpace19 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace14.update(parkingSpace19, true);
        objects.Car car22 = parkingSpace19.getParkedCar();
        parkingSpace19.setOccupied(false);
        objects.ParkingLot parkingLot28 = new objects.ParkingLot(" -  (hi!)", "hi!", (int) (short) 1);
        java.lang.String str29 = parkingLot28.getLocation();
        parkingSpace19.setParkingLot(parkingLot28);
        parkingSpace7.setParkingLot(parkingLot28);
        int int32 = parkingLot28.getCapcity();
        java.util.List<objects.ParkingSpace> parkingSpaceList33 = parkingLot28.getAvailableSpaces();
        java.util.List<objects.ParkingSpace> parkingSpaceList34 = parkingLot28.getAllSpaces();
        java.lang.Class<?> wildcardClass35 = parkingLot28.getClass();
        org.junit.Assert.assertNull(car22);
        org.junit.Assert.assertEquals("'" + str29 + "' != '" + "hi!" + "'", str29, "hi!");
        org.junit.Assert.assertTrue("'" + int32 + "' != '" + 100 + "'", int32 == 100);
        org.junit.Assert.assertNotNull(parkingSpaceList33);
        org.junit.Assert.assertNotNull(parkingSpaceList34);
        org.junit.Assert.assertNotNull(wildcardClass35);
    }

    @Test
    public void test172() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test172");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot4 = null;
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace7.setType("hi!");
        objects.Client client10 = null;
        businessLogic.Visit visit13 = new businessLogic.Visit((int) (byte) 0, date1, (int) (short) -1, (int) '4', parkingLot4, parkingSpace7, client10, (int) (short) 10, " -  (hi!)");
        java.lang.String str14 = visit13.getBookingID();
        java.util.Date date15 = null;
        visit13.setEndTime(date15);
        boolean boolean17 = visit13.hasExceededHour();
        // The following exception was thrown during execution in test generation
        try {
            visit13.setEndTime((-1));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: date must not be null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "0" + "'", str14, "0");
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + true + "'", boolean17 == true);
    }

    @Test
    public void test173() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test173");
        objects.ParkingSpace parkingSpace2 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.setType("hi!");
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.update(parkingSpace7, true);
        parkingSpace2.setEnabled(true);
        java.util.Date date14 = null;
        objects.ParkingLot parkingLot17 = null;
        objects.ParkingSpace parkingSpace20 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace20.setType("hi!");
        objects.Client client23 = null;
        businessLogic.Visit visit26 = new businessLogic.Visit((int) (byte) 0, date14, (int) (short) -1, (int) '4', parkingLot17, parkingSpace20, client23, (int) (short) 10, " -  (hi!)");
        java.lang.String str27 = visit26.getBookingID();
        java.lang.String str28 = visit26.getLicence();
        java.lang.String str29 = visit26.getFormattedStartTime();
        objects.ParkingSpace parkingSpace32 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace32.setType("hi!");
        objects.ParkingSpace parkingSpace37 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace32.update(parkingSpace37, true);
        objects.Car car40 = parkingSpace37.getParkedCar();
        objects.Client client44 = null;
        objects.Car car45 = new objects.Car("", "", "hi!", client44);
        java.lang.String str46 = car45.toString();
        car45.setModel(" -  (hi!)");
        objects.FacultyMember facultyMember51 = new objects.FacultyMember("", " -  (hi!)");
        car45.setOwner((objects.Client) facultyMember51);
        boolean boolean53 = parkingSpace37.parkCar(car45);
        visit26.setParkingSpace(parkingSpace37);
        objects.ParkingSensor parkingSensor55 = new objects.ParkingSensor((int) 'a', parkingSpace37);
        boolean boolean56 = parkingSensor55.isOccupied();
        objects.ParkingSpace parkingSpace59 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace59.setType("hi!");
        objects.ParkingSpace parkingSpace64 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace59.update(parkingSpace64, true);
        objects.Car car67 = parkingSpace64.getParkedCar();
        parkingSpace64.setOccupied(false);
        java.lang.String str70 = parkingSpace64.getEnablesString();
        objects.Car car71 = parkingSpace64.removeCar();
        parkingSensor55.addObserver((objects.ParkingStatusObserver) parkingSpace64);
        parkingSpace2.assignSensor(parkingSensor55);
        java.util.Date date76 = null;
        objects.ParkingLot parkingLot79 = null;
        objects.ParkingSpace parkingSpace82 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace82.setType("hi!");
        objects.Client client85 = null;
        businessLogic.Visit visit88 = new businessLogic.Visit((int) (byte) 0, date76, (int) (short) -1, (int) '4', parkingLot79, parkingSpace82, client85, (int) (short) 10, " -  (hi!)");
        java.lang.String str89 = visit88.getBookingID();
        objects.Client client90 = visit88.getClientDetail();
        boolean boolean91 = visit88.isCheckedIn();
        objects.ParkingSpace parkingSpace92 = visit88.getParkingSpace();
        java.lang.String str93 = parkingSpace92.getEnablesString();
        java.lang.String str94 = parkingSpace92.getEnablesString();
        objects.ParkingSensor parkingSensor95 = parkingSensor55.clone(97, parkingSpace92);
        org.junit.Assert.assertEquals("'" + str27 + "' != '" + "0" + "'", str27, "0");
        org.junit.Assert.assertEquals("'" + str28 + "' != '" + " -  (hi!)" + "'", str28, " -  (hi!)");
        org.junit.Assert.assertEquals("'" + str29 + "' != '" + "31/12/1969" + "'", str29, "31/12/1969");
        org.junit.Assert.assertNull(car40);
        org.junit.Assert.assertEquals("'" + str46 + "' != '" + " -  (hi!)" + "'", str46, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + boolean53 + "' != '" + true + "'", boolean53 == true);
        org.junit.Assert.assertTrue("'" + boolean56 + "' != '" + false + "'", boolean56 == false);
        org.junit.Assert.assertNull(car67);
        org.junit.Assert.assertEquals("'" + str70 + "' != '" + "Enabled" + "'", str70, "Enabled");
        org.junit.Assert.assertNull(car71);
        org.junit.Assert.assertEquals("'" + str89 + "' != '" + "0" + "'", str89, "0");
        org.junit.Assert.assertNull(client90);
        org.junit.Assert.assertTrue("'" + boolean91 + "' != '" + false + "'", boolean91 == false);
        org.junit.Assert.assertNotNull(parkingSpace92);
        org.junit.Assert.assertEquals("'" + str93 + "' != '" + "Enabled" + "'", str93, "Enabled");
        org.junit.Assert.assertEquals("'" + str94 + "' != '" + "Enabled" + "'", str94, "Enabled");
        org.junit.Assert.assertNotNull(parkingSensor95);
    }

    @Test
    public void test174() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test174");
        objects.ParkingSpace parkingSpace2 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.setType("hi!");
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.update(parkingSpace7, true);
        objects.Car car10 = parkingSpace7.getParkedCar();
        parkingSpace7.setOccupied(false);
        java.lang.String str13 = parkingSpace7.getBookingId();
        org.junit.Assert.assertNull(car10);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "" + "'", str13, "");
    }

    @Test
    public void test175() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test175");
        objects.ParkingSpace parkingSpace2 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.setType("hi!");
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.update(parkingSpace7, true);
        objects.Car car10 = parkingSpace7.getParkedCar();
        parkingSpace7.setOccupied(false);
        objects.Car car13 = parkingSpace7.getParkedCar();
        boolean boolean14 = parkingSpace7.isEnabled();
        objects.ParkingSpace parkingSpace17 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace17.setType("hi!");
        objects.ParkingSpace parkingSpace22 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace17.update(parkingSpace22, true);
        objects.Car car25 = parkingSpace22.getParkedCar();
        objects.Client client29 = null;
        objects.Car car30 = new objects.Car("", "", "hi!", client29);
        java.lang.String str31 = car30.toString();
        car30.setModel(" -  (hi!)");
        objects.FacultyMember facultyMember36 = new objects.FacultyMember("", " -  (hi!)");
        car30.setOwner((objects.Client) facultyMember36);
        boolean boolean38 = parkingSpace22.parkCar(car30);
        java.lang.String str39 = car30.getLicensePlate();
        objects.FacultyMember facultyMember42 = new objects.FacultyMember(" -  (hi!)", " -  (hi!)");
        int int43 = facultyMember42.getParkingRate();
        facultyMember42.setPassword("hi!");
        car30.setOwner((objects.Client) facultyMember42);
        boolean boolean47 = parkingSpace7.parkCar(car30);
        java.lang.String str48 = parkingSpace7.getEnablesString();
        org.junit.Assert.assertNull(car10);
        org.junit.Assert.assertNull(car13);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + true + "'", boolean14 == true);
        org.junit.Assert.assertNull(car25);
        org.junit.Assert.assertEquals("'" + str31 + "' != '" + " -  (hi!)" + "'", str31, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + boolean38 + "' != '" + true + "'", boolean38 == true);
        org.junit.Assert.assertEquals("'" + str39 + "' != '" + "" + "'", str39, "");
        org.junit.Assert.assertTrue("'" + int43 + "' != '" + 8 + "'", int43 == 8);
        org.junit.Assert.assertTrue("'" + boolean47 + "' != '" + true + "'", boolean47 == true);
        org.junit.Assert.assertEquals("'" + str48 + "' != '" + "Enabled" + "'", str48, "Enabled");
    }

    @Test
    public void test176() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test176");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot4 = null;
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace7.setType("hi!");
        objects.Client client10 = null;
        businessLogic.Visit visit13 = new businessLogic.Visit((int) (byte) 0, date1, (int) (short) -1, (int) '4', parkingLot4, parkingSpace7, client10, (int) (short) 10, " -  (hi!)");
        objects.ParkingLot parkingLot14 = visit13.getParkingLot();
        java.util.Date date15 = null;
        visit13.setStartTime(date15);
        org.junit.Assert.assertNull(parkingLot14);
    }

    @Test
    public void test177() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test177");
        objects.ParkingSpace parkingSpace2 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.setType("hi!");
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.update(parkingSpace7, true);
        java.lang.String str10 = parkingSpace2.getOccupiedString();
        objects.ParkingSpace parkingSpace13 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace13.setType("hi!");
        objects.ParkingSpace parkingSpace18 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace13.update(parkingSpace18, true);
        parkingSpace13.setEnabled(true);
        java.util.Date date25 = null;
        objects.ParkingLot parkingLot28 = null;
        objects.ParkingSpace parkingSpace31 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace31.setType("hi!");
        objects.Client client34 = null;
        businessLogic.Visit visit37 = new businessLogic.Visit((int) (byte) 0, date25, (int) (short) -1, (int) '4', parkingLot28, parkingSpace31, client34, (int) (short) 10, " -  (hi!)");
        java.lang.String str38 = visit37.getBookingID();
        java.lang.String str39 = visit37.getLicence();
        java.lang.String str40 = visit37.getFormattedStartTime();
        objects.ParkingSpace parkingSpace43 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace43.setType("hi!");
        objects.ParkingSpace parkingSpace48 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace43.update(parkingSpace48, true);
        objects.Car car51 = parkingSpace48.getParkedCar();
        objects.Client client55 = null;
        objects.Car car56 = new objects.Car("", "", "hi!", client55);
        java.lang.String str57 = car56.toString();
        car56.setModel(" -  (hi!)");
        objects.FacultyMember facultyMember62 = new objects.FacultyMember("", " -  (hi!)");
        car56.setOwner((objects.Client) facultyMember62);
        boolean boolean64 = parkingSpace48.parkCar(car56);
        visit37.setParkingSpace(parkingSpace48);
        objects.ParkingSensor parkingSensor66 = new objects.ParkingSensor((int) 'a', parkingSpace48);
        boolean boolean67 = parkingSensor66.isOccupied();
        objects.ParkingSpace parkingSpace70 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace70.setType("hi!");
        objects.ParkingSpace parkingSpace75 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace70.update(parkingSpace75, true);
        objects.Car car78 = parkingSpace75.getParkedCar();
        parkingSpace75.setOccupied(false);
        java.lang.String str81 = parkingSpace75.getEnablesString();
        objects.Car car82 = parkingSpace75.removeCar();
        parkingSensor66.addObserver((objects.ParkingStatusObserver) parkingSpace75);
        parkingSpace13.assignSensor(parkingSensor66);
        parkingSpace2.update(parkingSpace13, true);
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "Occupied" + "'", str10, "Occupied");
        org.junit.Assert.assertEquals("'" + str38 + "' != '" + "0" + "'", str38, "0");
        org.junit.Assert.assertEquals("'" + str39 + "' != '" + " -  (hi!)" + "'", str39, " -  (hi!)");
        org.junit.Assert.assertEquals("'" + str40 + "' != '" + "31/12/1969" + "'", str40, "31/12/1969");
        org.junit.Assert.assertNull(car51);
        org.junit.Assert.assertEquals("'" + str57 + "' != '" + " -  (hi!)" + "'", str57, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + boolean64 + "' != '" + true + "'", boolean64 == true);
        org.junit.Assert.assertTrue("'" + boolean67 + "' != '" + false + "'", boolean67 == false);
        org.junit.Assert.assertNull(car78);
        org.junit.Assert.assertEquals("'" + str81 + "' != '" + "Enabled" + "'", str81, "Enabled");
        org.junit.Assert.assertNull(car82);
    }

    @Test
    public void test178() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test178");
        objects.ParkingSpace parkingSpace2 = new objects.ParkingSpace((int) (short) 100, "hi!");
        int int3 = parkingSpace2.getSpaceId();
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 100 + "'", int3 == 100);
    }

    @Test
    public void test179() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test179");
        objects.FacultyMember facultyMember2 = new objects.FacultyMember(" -  (hi!)", " -  (hi!)");
        java.lang.String str3 = facultyMember2.getValidationStatus();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "NotValidated" + "'", str3, "NotValidated");
    }

    @Test
    public void test180() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test180");
        objects.Student student2 = new objects.Student("NotValidated", "Available");
    }

    @Test
    public void test181() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test181");
        objects.ParkingLot parkingLot3 = new objects.ParkingLot(" -  (hi!)", "hi!", (int) (short) 1);
        java.lang.String str4 = parkingLot3.getName();
        int int5 = parkingLot3.getId();
        parkingLot3.setId((int) (byte) -1);
        boolean boolean8 = parkingLot3.isEnabled();
        java.lang.String str9 = parkingLot3.getStatus();
        parkingLot3.setStatus(false);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + " -  (hi!)" + "'", str4, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "Enabled" + "'", str9, "Enabled");
    }

    @Test
    public void test182() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test182");
        objects.Student student2 = new objects.Student("Super Manager", "Space 100 (hi!): Enabled, Available, No Sensor");
    }

    @Test
    public void test183() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test183");
        objects.ParkingSpace parkingSpace2 = new objects.ParkingSpace((int) (short) 100, "hi!");
        objects.Car car3 = parkingSpace2.removeCar();
        java.lang.String str4 = parkingSpace2.getBookingId();
        org.junit.Assert.assertNull(car3);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "" + "'", str4, "");
    }

    @Test
    public void test184() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test184");
        objects.Manager manager2 = new objects.Manager("0", "hi!");
        java.lang.String str3 = manager2.getUserName();
        boolean boolean7 = manager2.approveTransaction((int) ' ', "0", (int) (byte) 10);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "0" + "'", str3, "0");
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
    }

    @Test
    public void test185() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test185");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot7 = new objects.ParkingLot("31/12/1969", "", 0);
        objects.ParkingSpace parkingSpace10 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace10.setType("hi!");
        objects.ParkingSpace parkingSpace15 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace10.update(parkingSpace15, true);
        objects.Car car18 = parkingSpace15.getParkedCar();
        objects.Client client22 = null;
        objects.Car car23 = new objects.Car("", "", "hi!", client22);
        java.lang.String str24 = car23.toString();
        car23.setModel(" -  (hi!)");
        objects.FacultyMember facultyMember29 = new objects.FacultyMember("", " -  (hi!)");
        car23.setOwner((objects.Client) facultyMember29);
        boolean boolean31 = parkingSpace15.parkCar(car23);
        java.util.Date date33 = null;
        objects.ParkingLot parkingLot39 = new objects.ParkingLot(" -  (hi!)", "hi!", (int) (short) 1);
        java.lang.String str40 = parkingLot39.getName();
        int int41 = parkingLot39.getId();
        parkingLot39.setId((int) (byte) -1);
        boolean boolean44 = parkingLot39.isEnabled();
        objects.ParkingSpace parkingSpace47 = new objects.ParkingSpace((int) (short) 100, "hi!");
        objects.Client client51 = null;
        objects.Car car52 = new objects.Car("", "", "hi!", client51);
        objects.FacultyMember facultyMember55 = new objects.FacultyMember("", " -  (hi!)");
        car52.setOwner((objects.Client) facultyMember55);
        businessLogic.Visit visit59 = new businessLogic.Visit(8, date33, (int) (byte) 100, (int) (short) 10, parkingLot39, parkingSpace47, (objects.Client) facultyMember55, 8, "Enabled");
        businessLogic.Visit visit62 = new businessLogic.Visit(1, date1, 0, (-1), parkingLot7, parkingSpace15, (objects.Client) facultyMember55, (-1), "NotValidated");
        org.junit.Assert.assertNull(car18);
        org.junit.Assert.assertEquals("'" + str24 + "' != '" + " -  (hi!)" + "'", str24, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + true + "'", boolean31 == true);
        org.junit.Assert.assertEquals("'" + str40 + "' != '" + " -  (hi!)" + "'", str40, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + int41 + "' != '" + 0 + "'", int41 == 0);
        org.junit.Assert.assertTrue("'" + boolean44 + "' != '" + true + "'", boolean44 == true);
    }

    @Test
    public void test186() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test186");
        objects.ParkingSpace parkingSpace2 = new objects.ParkingSpace((int) (short) 100, "hi!");
        boolean boolean3 = parkingSpace2.isOccupied();
        parkingSpace2.unoccupyTime((int) '#');
        objects.Car car6 = parkingSpace2.getParkedCar();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertNull(car6);
    }

    @Test
    public void test187() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test187");
        objects.NonFacultyStaff nonFacultyStaff2 = new objects.NonFacultyStaff("Unknown", "Available - Manager (0)");
        java.lang.String str3 = nonFacultyStaff2.getValidationStatus();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "NotValidated" + "'", str3, "NotValidated");
    }

    @Test
    public void test188() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test188");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot4 = null;
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace7.setType("hi!");
        objects.Client client10 = null;
        businessLogic.Visit visit13 = new businessLogic.Visit((int) (byte) 0, date1, (int) (short) -1, (int) '4', parkingLot4, parkingSpace7, client10, (int) (short) 10, " -  (hi!)");
        java.lang.String str14 = visit13.getBookingID();
        objects.Client client15 = visit13.getClientDetail();
        boolean boolean16 = visit13.isCheckedIn();
        objects.ParkingSpace parkingSpace17 = visit13.getParkingSpace();
        java.lang.String str18 = visit13.getLicence();
        java.util.Date date19 = null;
        visit13.setStartTime(date19);
        visit13.setDuration();
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str22 = visit13.getDateString();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: date must not be null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "0" + "'", str14, "0");
        org.junit.Assert.assertNull(client15);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNotNull(parkingSpace17);
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + " -  (hi!)" + "'", str18, " -  (hi!)");
    }

    @Test
    public void test189() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test189");
        objects.ParkingSpace parkingSpace2 = new objects.ParkingSpace((int) (short) 100, "hi!");
        objects.Car car3 = parkingSpace2.removeCar();
        int int4 = parkingSpace2.getSpaceId();
        org.junit.Assert.assertNull(car3);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 100 + "'", int4 == 100);
    }

    @Test
    public void test190() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test190");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot4 = null;
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace7.setType("hi!");
        objects.Client client10 = null;
        businessLogic.Visit visit13 = new businessLogic.Visit((int) (byte) 0, date1, (int) (short) -1, (int) '4', parkingLot4, parkingSpace7, client10, (int) (short) 10, " -  (hi!)");
        java.lang.String str14 = visit13.getBookingID();
        java.lang.String str15 = visit13.getLicence();
        visit13.setDuration((int) 'a');
        java.lang.String str18 = visit13.getFormattedStartTime();
        visit13.setDuration((int) (byte) 10);
        visit13.setMoneyPaid(0);
        int int23 = visit13.getDuration();
        java.lang.String str24 = visit13.getLicence();
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "0" + "'", str14, "0");
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + " -  (hi!)" + "'", str15, " -  (hi!)");
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + "31/12/1969" + "'", str18, "31/12/1969");
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + 10 + "'", int23 == 10);
        org.junit.Assert.assertEquals("'" + str24 + "' != '" + " -  (hi!)" + "'", str24, " -  (hi!)");
    }

    @Test
    public void test191() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test191");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot4 = null;
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace7.setType("hi!");
        objects.Client client10 = null;
        businessLogic.Visit visit13 = new businessLogic.Visit((int) (byte) 0, date1, (int) (short) -1, (int) '4', parkingLot4, parkingSpace7, client10, (int) (short) 10, " -  (hi!)");
        java.lang.String str14 = visit13.getBookingID();
        objects.Client client15 = visit13.getClientDetail();
        boolean boolean16 = visit13.isCheckedIn();
        objects.ParkingSpace parkingSpace17 = visit13.getParkingSpace();
        java.lang.String str18 = visit13.getLicence();
        java.util.Date date19 = null;
        visit13.setStartTime(date19);
        visit13.setDuration();
        int int22 = visit13.getInitialTime();
        visit13.setDuration();
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "0" + "'", str14, "0");
        org.junit.Assert.assertNull(client15);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNotNull(parkingSpace17);
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + " -  (hi!)" + "'", str18, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + int22 + "' != '" + (-1) + "'", int22 == (-1));
    }

    @Test
    public void test192() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test192");
        objects.NonFacultyStaff nonFacultyStaff2 = new objects.NonFacultyStaff("Available", "0");
        java.lang.String str3 = nonFacultyStaff2.getValidationStatus();
        nonFacultyStaff2.setEmail("hi!");
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "NotValidated" + "'", str3, "NotValidated");
    }

    @Test
    public void test193() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test193");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot4 = null;
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace7.setType("hi!");
        objects.Client client10 = null;
        businessLogic.Visit visit13 = new businessLogic.Visit((int) (byte) 0, date1, (int) (short) -1, (int) '4', parkingLot4, parkingSpace7, client10, (int) (short) 10, " -  (hi!)");
        java.lang.String str14 = visit13.getBookingID();
        objects.Client client15 = visit13.getClientDetail();
        boolean boolean16 = visit13.isCheckedIn();
        boolean boolean17 = visit13.hasExceededHour();
        java.util.Date date20 = null;
        objects.ParkingLot parkingLot23 = null;
        objects.ParkingSpace parkingSpace26 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace26.setType("hi!");
        objects.Client client29 = null;
        businessLogic.Visit visit32 = new businessLogic.Visit((int) (byte) 0, date20, (int) (short) -1, (int) '4', parkingLot23, parkingSpace26, client29, (int) (short) 10, " -  (hi!)");
        java.lang.String str33 = visit32.getBookingID();
        java.lang.String str34 = visit32.getLicence();
        java.lang.String str35 = visit32.getFormattedStartTime();
        objects.ParkingSpace parkingSpace38 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace38.setType("hi!");
        objects.ParkingSpace parkingSpace43 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace38.update(parkingSpace43, true);
        objects.Car car46 = parkingSpace43.getParkedCar();
        objects.Client client50 = null;
        objects.Car car51 = new objects.Car("", "", "hi!", client50);
        java.lang.String str52 = car51.toString();
        car51.setModel(" -  (hi!)");
        objects.FacultyMember facultyMember57 = new objects.FacultyMember("", " -  (hi!)");
        car51.setOwner((objects.Client) facultyMember57);
        boolean boolean59 = parkingSpace43.parkCar(car51);
        visit32.setParkingSpace(parkingSpace43);
        objects.ParkingSensor parkingSensor61 = new objects.ParkingSensor((int) 'a', parkingSpace43);
        boolean boolean62 = parkingSensor61.isOccupied();
        java.util.Date date64 = null;
        objects.ParkingLot parkingLot67 = null;
        objects.ParkingSpace parkingSpace70 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace70.setType("hi!");
        objects.Client client73 = null;
        businessLogic.Visit visit76 = new businessLogic.Visit((int) (byte) 0, date64, (int) (short) -1, (int) '4', parkingLot67, parkingSpace70, client73, (int) (short) 10, " -  (hi!)");
        java.lang.String str77 = visit76.getBookingID();
        objects.Client client78 = visit76.getClientDetail();
        boolean boolean79 = visit76.isCheckedIn();
        objects.ParkingSpace parkingSpace80 = visit76.getParkingSpace();
        parkingSensor61.removeObserver((objects.ParkingStatusObserver) parkingSpace80);
        visit13.setParkingSpace(parkingSpace80);
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "0" + "'", str14, "0");
        org.junit.Assert.assertNull(client15);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + true + "'", boolean17 == true);
        org.junit.Assert.assertEquals("'" + str33 + "' != '" + "0" + "'", str33, "0");
        org.junit.Assert.assertEquals("'" + str34 + "' != '" + " -  (hi!)" + "'", str34, " -  (hi!)");
        org.junit.Assert.assertEquals("'" + str35 + "' != '" + "31/12/1969" + "'", str35, "31/12/1969");
        org.junit.Assert.assertNull(car46);
        org.junit.Assert.assertEquals("'" + str52 + "' != '" + " -  (hi!)" + "'", str52, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + boolean59 + "' != '" + true + "'", boolean59 == true);
        org.junit.Assert.assertTrue("'" + boolean62 + "' != '" + false + "'", boolean62 == false);
        org.junit.Assert.assertEquals("'" + str77 + "' != '" + "0" + "'", str77, "0");
        org.junit.Assert.assertNull(client78);
        org.junit.Assert.assertTrue("'" + boolean79 + "' != '" + false + "'", boolean79 == false);
        org.junit.Assert.assertNotNull(parkingSpace80);
    }

    @Test
    public void test194() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test194");
        objects.ParkingLot parkingLot3 = new objects.ParkingLot(" -  (hi!)", "hi!", (int) (short) 1);
        java.lang.String str4 = parkingLot3.getName();
        int int5 = parkingLot3.getId();
        java.util.List<objects.ParkingSpace> parkingSpaceList6 = parkingLot3.getAllSpaces();
        java.util.List<objects.ParkingSpace> parkingSpaceList7 = parkingLot3.getAllSpaces();
        boolean boolean8 = parkingLot3.isEnabled();
        java.lang.String str9 = parkingLot3.getStatus();
        parkingLot3.setId(100);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + " -  (hi!)" + "'", str4, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
        org.junit.Assert.assertNotNull(parkingSpaceList6);
        org.junit.Assert.assertNotNull(parkingSpaceList7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "Enabled" + "'", str9, "Enabled");
    }

    @Test
    public void test195() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test195");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot4 = null;
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace7.setType("hi!");
        objects.Client client10 = null;
        businessLogic.Visit visit13 = new businessLogic.Visit((int) (byte) 0, date1, (int) (short) -1, (int) '4', parkingLot4, parkingSpace7, client10, (int) (short) 10, " -  (hi!)");
        java.lang.String str14 = visit13.getBookingID();
        java.lang.String str15 = visit13.getLicence();
        java.lang.String str16 = visit13.getFormattedStartTime();
        objects.ParkingSpace parkingSpace19 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace19.setType("hi!");
        objects.ParkingSpace parkingSpace24 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace19.update(parkingSpace24, true);
        objects.Car car27 = parkingSpace24.getParkedCar();
        objects.Client client31 = null;
        objects.Car car32 = new objects.Car("", "", "hi!", client31);
        java.lang.String str33 = car32.toString();
        car32.setModel(" -  (hi!)");
        objects.FacultyMember facultyMember38 = new objects.FacultyMember("", " -  (hi!)");
        car32.setOwner((objects.Client) facultyMember38);
        boolean boolean40 = parkingSpace24.parkCar(car32);
        visit13.setParkingSpace(parkingSpace24);
        objects.Car car42 = parkingSpace24.getParkedCar();
        car42.setLicensePlate("Available");
        car42.setLicensePlate("Space 100 (hi!): Enabled, Available, No Sensor");
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "0" + "'", str14, "0");
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + " -  (hi!)" + "'", str15, " -  (hi!)");
        org.junit.Assert.assertEquals("'" + str16 + "' != '" + "31/12/1969" + "'", str16, "31/12/1969");
        org.junit.Assert.assertNull(car27);
        org.junit.Assert.assertEquals("'" + str33 + "' != '" + " -  (hi!)" + "'", str33, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + boolean40 + "' != '" + true + "'", boolean40 == true);
        org.junit.Assert.assertNotNull(car42);
    }

    @Test
    public void test196() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test196");
        objects.ParkingLot parkingLot3 = new objects.ParkingLot(" -  (hi!)", "hi!", (int) (short) 1);
        java.lang.String str4 = parkingLot3.getName();
        int int5 = parkingLot3.getId();
        parkingLot3.setId((int) (byte) -1);
        boolean boolean8 = parkingLot3.isEnabled();
        java.util.Date date10 = null;
        objects.ParkingLot parkingLot13 = null;
        objects.ParkingSpace parkingSpace16 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace16.setType("hi!");
        objects.Client client19 = null;
        businessLogic.Visit visit22 = new businessLogic.Visit((int) (byte) 0, date10, (int) (short) -1, (int) '4', parkingLot13, parkingSpace16, client19, (int) (short) 10, " -  (hi!)");
        java.lang.String str23 = visit22.getBookingID();
        java.lang.String str24 = visit22.getLicence();
        java.lang.String str25 = visit22.getFormattedStartTime();
        objects.ParkingSpace parkingSpace28 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace28.setType("hi!");
        objects.ParkingSpace parkingSpace33 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace28.update(parkingSpace33, true);
        objects.Car car36 = parkingSpace33.getParkedCar();
        objects.Client client40 = null;
        objects.Car car41 = new objects.Car("", "", "hi!", client40);
        java.lang.String str42 = car41.toString();
        car41.setModel(" -  (hi!)");
        objects.FacultyMember facultyMember47 = new objects.FacultyMember("", " -  (hi!)");
        car41.setOwner((objects.Client) facultyMember47);
        boolean boolean49 = parkingSpace33.parkCar(car41);
        visit22.setParkingSpace(parkingSpace33);
        parkingLot3.addParkingSpace(parkingSpace33);
        objects.Car car52 = parkingSpace33.removeCar();
        objects.ParkingSpace parkingSpace53 = parkingSpace33.clone();
        java.lang.String str54 = parkingSpace53.getOccupiedString();
        java.lang.String str55 = parkingSpace53.getType();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + " -  (hi!)" + "'", str4, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertEquals("'" + str23 + "' != '" + "0" + "'", str23, "0");
        org.junit.Assert.assertEquals("'" + str24 + "' != '" + " -  (hi!)" + "'", str24, " -  (hi!)");
        org.junit.Assert.assertEquals("'" + str25 + "' != '" + "31/12/1969" + "'", str25, "31/12/1969");
        org.junit.Assert.assertNull(car36);
        org.junit.Assert.assertEquals("'" + str42 + "' != '" + " -  (hi!)" + "'", str42, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + boolean49 + "' != '" + true + "'", boolean49 == true);
        org.junit.Assert.assertNotNull(car52);
        org.junit.Assert.assertNotNull(parkingSpace53);
        org.junit.Assert.assertEquals("'" + str54 + "' != '" + "Available" + "'", str54, "Available");
        org.junit.Assert.assertEquals("'" + str55 + "' != '" + "hi!" + "'", str55, "hi!");
    }

    @Test
    public void test197() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test197");
        database.Database database1 = new database.Database("");
    }

    @Test
    public void test198() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test198");
        objects.ParkingSpace parkingSpace2 = new objects.ParkingSpace((int) (short) 100, "hi!");
        boolean boolean3 = parkingSpace2.isOccupied();
        parkingSpace2.unoccupy(100);
        java.lang.String str6 = parkingSpace2.getOccupiedString();
        parkingSpace2.setSpaceId((int) (short) 10);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "Available" + "'", str6, "Available");
    }

    @Test
    public void test199() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test199");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot7 = new objects.ParkingLot("Available - Manager ()", "ParkingS25!", 52);
        java.lang.String str8 = parkingLot7.getName();
        objects.ParkingSpace parkingSpace11 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace11.setType("hi!");
        objects.ParkingSpace parkingSpace16 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace11.update(parkingSpace16, true);
        objects.Car car19 = parkingSpace16.getParkedCar();
        parkingSpace16.setOccupied(false);
        objects.Car car22 = parkingSpace16.getParkedCar();
        objects.ParkingLot parkingLot26 = new objects.ParkingLot(" -  (hi!)", "hi!", (int) (short) 1);
        java.lang.String str27 = parkingLot26.getLocation();
        parkingSpace16.setParkingLot(parkingLot26);
        parkingLot26.setEnabled(true);
        objects.ParkingSpace parkingSpace32 = parkingLot26.findSpaceById(52);
        objects.FacultyMember facultyMember35 = new objects.FacultyMember(" -  (hi!)", " -  (hi!)");
        int int36 = facultyMember35.getParkingRate();
        businessLogic.Visit visit39 = new businessLogic.Visit(0, date1, 8, 10, parkingLot7, parkingSpace32, (objects.Client) facultyMember35, 52, "NotValidated");
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "Available - Manager ()" + "'", str8, "Available - Manager ()");
        org.junit.Assert.assertNull(car19);
        org.junit.Assert.assertNull(car22);
        org.junit.Assert.assertEquals("'" + str27 + "' != '" + "hi!" + "'", str27, "hi!");
        org.junit.Assert.assertNotNull(parkingSpace32);
        org.junit.Assert.assertTrue("'" + int36 + "' != '" + 8 + "'", int36 == 8);
    }

    @Test
    public void test200() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test200");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot4 = null;
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace7.setType("hi!");
        objects.Client client10 = null;
        businessLogic.Visit visit13 = new businessLogic.Visit((int) (byte) 0, date1, (int) (short) -1, (int) '4', parkingLot4, parkingSpace7, client10, (int) (short) 10, " -  (hi!)");
        java.lang.String str14 = visit13.getBookingID();
        boolean boolean15 = visit13.hasExceededHour();
        java.util.Date date16 = null;
        visit13.setEndTime(date16);
        objects.ParkingLot parkingLot18 = visit13.getParkingLot();
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str19 = visit13.getFormattedEndTime();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: date must not be null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "0" + "'", str14, "0");
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        org.junit.Assert.assertNull(parkingLot18);
    }

    @Test
    public void test201() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test201");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot4 = null;
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace7.setType("hi!");
        objects.Client client10 = null;
        businessLogic.Visit visit13 = new businessLogic.Visit((int) (byte) 0, date1, (int) (short) -1, (int) '4', parkingLot4, parkingSpace7, client10, (int) (short) 10, " -  (hi!)");
        objects.ParkingLot parkingLot14 = visit13.getParkingLot();
        objects.ParkingSpace parkingSpace15 = visit13.getParkingSpace();
        java.lang.String str16 = visit13.getFormattedStartTime();
        org.junit.Assert.assertNull(parkingLot14);
        org.junit.Assert.assertNotNull(parkingSpace15);
        org.junit.Assert.assertEquals("'" + str16 + "' != '" + "31/12/1969" + "'", str16, "31/12/1969");
    }

    @Test
    public void test202() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test202");
        objects.Client client3 = null;
        objects.Car car4 = new objects.Car("", "", "hi!", client3);
        java.lang.String str5 = car4.getModel();
        objects.FacultyMember facultyMember8 = new objects.FacultyMember(" -  (hi!)", " -  (hi!)");
        int int9 = facultyMember8.getParkingRate();
        java.lang.String str10 = facultyMember8.getEmail();
        java.lang.String str11 = facultyMember8.getValidationStatus();
        car4.setOwner((objects.Client) facultyMember8);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 8 + "'", int9 == 8);
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + " -  (hi!)" + "'", str10, " -  (hi!)");
        org.junit.Assert.assertEquals("'" + str11 + "' != '" + "NotValidated" + "'", str11, "NotValidated");
    }

    @Test
    public void test203() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test203");
        java.util.Date date2 = null;
        objects.ParkingLot parkingLot5 = null;
        objects.ParkingSpace parkingSpace8 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace8.setType("hi!");
        objects.Client client11 = null;
        businessLogic.Visit visit14 = new businessLogic.Visit((int) (byte) 0, date2, (int) (short) -1, (int) '4', parkingLot5, parkingSpace8, client11, (int) (short) 10, " -  (hi!)");
        java.lang.String str15 = visit14.getBookingID();
        java.lang.String str16 = visit14.getLicence();
        java.lang.String str17 = visit14.getFormattedStartTime();
        objects.ParkingSpace parkingSpace20 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace20.setType("hi!");
        objects.ParkingSpace parkingSpace25 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace20.update(parkingSpace25, true);
        objects.Car car28 = parkingSpace25.getParkedCar();
        objects.Client client32 = null;
        objects.Car car33 = new objects.Car("", "", "hi!", client32);
        java.lang.String str34 = car33.toString();
        car33.setModel(" -  (hi!)");
        objects.FacultyMember facultyMember39 = new objects.FacultyMember("", " -  (hi!)");
        car33.setOwner((objects.Client) facultyMember39);
        boolean boolean41 = parkingSpace25.parkCar(car33);
        visit14.setParkingSpace(parkingSpace25);
        objects.ParkingSensor parkingSensor43 = new objects.ParkingSensor((int) 'a', parkingSpace25);
        objects.ParkingSpace parkingSpace47 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace47.setType("hi!");
        objects.ParkingSpace parkingSpace52 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace47.update(parkingSpace52, true);
        objects.Car car55 = parkingSpace52.getParkedCar();
        parkingSpace52.setOccupied(false);
        objects.ParkingLot parkingLot61 = new objects.ParkingLot(" -  (hi!)", "hi!", (int) (short) 1);
        java.lang.String str62 = parkingLot61.getLocation();
        parkingSpace52.setParkingLot(parkingLot61);
        java.lang.String str64 = parkingSpace52.getEnablesString();
        objects.ParkingSensor parkingSensor65 = parkingSensor43.clone((int) (short) 1, parkingSpace52);
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + "0" + "'", str15, "0");
        org.junit.Assert.assertEquals("'" + str16 + "' != '" + " -  (hi!)" + "'", str16, " -  (hi!)");
        org.junit.Assert.assertEquals("'" + str17 + "' != '" + "31/12/1969" + "'", str17, "31/12/1969");
        org.junit.Assert.assertNull(car28);
        org.junit.Assert.assertEquals("'" + str34 + "' != '" + " -  (hi!)" + "'", str34, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + boolean41 + "' != '" + true + "'", boolean41 == true);
        org.junit.Assert.assertNull(car55);
        org.junit.Assert.assertEquals("'" + str62 + "' != '" + "hi!" + "'", str62, "hi!");
        org.junit.Assert.assertEquals("'" + str64 + "' != '" + "Enabled" + "'", str64, "Enabled");
        org.junit.Assert.assertNotNull(parkingSensor65);
    }

    @Test
    public void test204() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test204");
        objects.ParkingSpace parkingSpace2 = new objects.ParkingSpace((int) (short) 100, "hi!");
        objects.Car car3 = parkingSpace2.removeCar();
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace7.setType("hi!");
        objects.ParkingSpace parkingSpace12 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace7.update(parkingSpace12, true);
        parkingSpace12.unoccupyTime(1);
        objects.ParkingSpace parkingSpace19 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace19.setType("hi!");
        objects.ParkingSpace parkingSpace24 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace19.update(parkingSpace24, true);
        objects.Car car27 = parkingSpace24.getParkedCar();
        parkingSpace24.setOccupied(false);
        objects.ParkingLot parkingLot33 = new objects.ParkingLot(" -  (hi!)", "hi!", (int) (short) 1);
        java.lang.String str34 = parkingLot33.getLocation();
        parkingSpace24.setParkingLot(parkingLot33);
        parkingSpace12.setParkingLot(parkingLot33);
        objects.ParkingSensor parkingSensor37 = new objects.ParkingSensor(100, parkingSpace12);
        parkingSpace2.update(parkingSpace12, true);
        org.junit.Assert.assertNull(car3);
        org.junit.Assert.assertNull(car27);
        org.junit.Assert.assertEquals("'" + str34 + "' != '" + "hi!" + "'", str34, "hi!");
    }

    @Test
    public void test205() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test205");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot4 = null;
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace7.setType("hi!");
        objects.Client client10 = null;
        businessLogic.Visit visit13 = new businessLogic.Visit((int) (byte) 0, date1, (int) (short) -1, (int) '4', parkingLot4, parkingSpace7, client10, (int) (short) 10, " -  (hi!)");
        java.lang.String str14 = visit13.getBookingID();
        objects.Client client15 = visit13.getClientDetail();
        boolean boolean16 = visit13.isCheckedIn();
        objects.ParkingSpace parkingSpace17 = visit13.getParkingSpace();
        objects.ParkingSpace parkingSpace18 = parkingSpace17.clone();
        parkingSpace17.unoccupy((int) '#');
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "0" + "'", str14, "0");
        org.junit.Assert.assertNull(client15);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNotNull(parkingSpace17);
        org.junit.Assert.assertNotNull(parkingSpace18);
    }

    @Test
    public void test206() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test206");
        objects.Client client3 = null;
        objects.Car car4 = new objects.Car("", "", "hi!", client3);
        java.lang.String str5 = car4.toString();
        car4.setModel(" -  (hi!)");
        objects.FacultyMember facultyMember10 = new objects.FacultyMember("", " -  (hi!)");
        car4.setOwner((objects.Client) facultyMember10);
        facultyMember10.setPassword("Manager");
        int int14 = facultyMember10.getParkingRate();
        java.lang.String str15 = facultyMember10.getValidationStatus();
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + " -  (hi!)" + "'", str5, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + int14 + "' != '" + 8 + "'", int14 == 8);
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + "NotValidated" + "'", str15, "NotValidated");
    }

    @Test
    public void test207() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test207");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot4 = null;
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace7.setType("hi!");
        objects.Client client10 = null;
        businessLogic.Visit visit13 = new businessLogic.Visit((int) (byte) 0, date1, (int) (short) -1, (int) '4', parkingLot4, parkingSpace7, client10, (int) (short) 10, " -  (hi!)");
        java.lang.String str14 = visit13.getBookingID();
        objects.Client client15 = visit13.getClientDetail();
        boolean boolean16 = visit13.isCheckedIn();
        boolean boolean17 = visit13.hasExceededHour();
        visit13.setDuration();
        objects.Client client22 = null;
        objects.Car car23 = new objects.Car("", "", "hi!", client22);
        objects.FacultyMember facultyMember26 = new objects.FacultyMember("", " -  (hi!)");
        car23.setOwner((objects.Client) facultyMember26);
        java.lang.String str28 = facultyMember26.getPassword();
        facultyMember26.setParkingRate(8);
        visit13.setClientDetail((objects.Client) facultyMember26);
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "0" + "'", str14, "0");
        org.junit.Assert.assertNull(client15);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + true + "'", boolean17 == true);
        org.junit.Assert.assertEquals("'" + str28 + "' != '" + " -  (hi!)" + "'", str28, " -  (hi!)");
    }

    @Test
    public void test208() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test208");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot4 = null;
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace7.setType("hi!");
        objects.Client client10 = null;
        businessLogic.Visit visit13 = new businessLogic.Visit((int) (byte) 0, date1, (int) (short) -1, (int) '4', parkingLot4, parkingSpace7, client10, (int) (short) 10, " -  (hi!)");
        objects.ParkingLot parkingLot14 = visit13.getParkingLot();
        objects.ParkingSpace parkingSpace15 = visit13.getParkingSpace();
        visit13.setDuration((int) '4');
        visit13.checkIn();
        boolean boolean19 = visit13.hasExceededHour();
        // The following exception was thrown during execution in test generation
        try {
            java.util.Date date20 = visit13.getStartTime();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: date must not be null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(parkingLot14);
        org.junit.Assert.assertNotNull(parkingSpace15);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + true + "'", boolean19 == true);
    }

    @Test
    public void test209() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test209");
        objects.SuperManager superManager0 = new objects.SuperManager();
        java.lang.String[] strArray1 = superManager0.generateManagerAccount();
        java.lang.String str2 = superManager0.getUserName();
        org.junit.Assert.assertNotNull(strArray1);
// flaky "1) test209(RegressionTest0)":         org.junit.Assert.assertArrayEquals(strArray1, new java.lang.String[] { "Manager3", ",2Uki!3MP7=!c1Tc" });
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "superManager" + "'", str2, "superManager");
    }

    @Test
    public void test210() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test210");
        objects.Manager manager2 = new objects.Manager("", "31/12/1969");
        java.lang.String str3 = manager2.getRole();
        boolean boolean7 = manager2.approveTransaction((int) (byte) 1, "Space 100 (hi!): Enabled, Occupied, No Sensor", (int) (byte) 100);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "Manager" + "'", str3, "Manager");
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
    }

    @Test
    public void test211() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test211");
        objects.ParkingSpace parkingSpace3 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace3.setType("hi!");
        objects.ParkingSpace parkingSpace8 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace3.update(parkingSpace8, true);
        objects.Car car11 = parkingSpace8.getParkedCar();
        objects.Client client15 = null;
        objects.Car car16 = new objects.Car("", "", "hi!", client15);
        java.lang.String str17 = car16.toString();
        car16.setModel(" -  (hi!)");
        objects.FacultyMember facultyMember22 = new objects.FacultyMember("", " -  (hi!)");
        car16.setOwner((objects.Client) facultyMember22);
        boolean boolean24 = parkingSpace8.parkCar(car16);
        objects.ParkingSensor parkingSensor25 = new objects.ParkingSensor((int) (byte) -1, parkingSpace8);
        parkingSpace8.setOccupied(false);
        org.junit.Assert.assertNull(car11);
        org.junit.Assert.assertEquals("'" + str17 + "' != '" + " -  (hi!)" + "'", str17, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + true + "'", boolean24 == true);
    }

    @Test
    public void test212() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test212");
        objects.Student student2 = new objects.Student("Enabled", "Manager");
        int int3 = student2.getParkingRate();
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 5 + "'", int3 == 5);
    }

    @Test
    public void test213() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test213");
        objects.SuperManager superManager0 = new objects.SuperManager();
        boolean boolean4 = superManager0.approveTransaction((int) 'a', "Available - Manager ()", (int) (byte) -1);
        java.lang.String str5 = superManager0.getPassword();
        java.lang.String str6 = superManager0.getRole();
        boolean boolean10 = superManager0.approveTransaction((int) ' ', "superManager", 0);
        java.lang.String[] strArray11 = superManager0.generateManagerAccount();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "ParkingS25!" + "'", str5, "ParkingS25!");
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "Super Manager" + "'", str6, "Super Manager");
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertNotNull(strArray11);
// flaky "2) test213(RegressionTest0)":         org.junit.Assert.assertArrayEquals(strArray11, new java.lang.String[] { "Manager4", ",TJ:5fbfP22<r!3P" });
    }

    @Test
    public void test214() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test214");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot4 = null;
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace7.setType("hi!");
        objects.Client client10 = null;
        businessLogic.Visit visit13 = new businessLogic.Visit((int) (byte) 0, date1, (int) (short) -1, (int) '4', parkingLot4, parkingSpace7, client10, (int) (short) 10, " -  (hi!)");
        java.lang.String str14 = visit13.getBookingID();
        java.util.Date date15 = null;
        visit13.setEndTime(date15);
        java.util.Date date17 = visit13.getDate();
        objects.ParkingSpace parkingSpace20 = new objects.ParkingSpace((int) (short) 100, "hi!");
        boolean boolean21 = parkingSpace20.isOccupied();
        parkingSpace20.unoccupyTime((int) '#');
        visit13.setParkingSpace(parkingSpace20);
        visit13.setDuration(97);
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "0" + "'", str14, "0");
        org.junit.Assert.assertNull(date17);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
    }

    @Test
    public void test215() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test215");
        objects.ParkingSpace parkingSpace3 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace3.setType("hi!");
        objects.ParkingSpace parkingSpace8 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace3.update(parkingSpace8, true);
        java.lang.String str11 = parkingSpace3.getOccupiedString();
        objects.ParkingSensor parkingSensor12 = new objects.ParkingSensor((int) '4', parkingSpace3);
        org.junit.Assert.assertEquals("'" + str11 + "' != '" + "Occupied" + "'", str11, "Occupied");
    }

    @Test
    public void test216() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test216");
        objects.ParkingLot parkingLot3 = new objects.ParkingLot(" -  (hi!)", "hi!", (int) (short) 1);
        java.lang.String str4 = parkingLot3.getName();
        int int5 = parkingLot3.getId();
        parkingLot3.setId((int) (byte) -1);
        boolean boolean8 = parkingLot3.isEnabled();
        java.util.Date date10 = null;
        objects.ParkingLot parkingLot13 = null;
        objects.ParkingSpace parkingSpace16 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace16.setType("hi!");
        objects.Client client19 = null;
        businessLogic.Visit visit22 = new businessLogic.Visit((int) (byte) 0, date10, (int) (short) -1, (int) '4', parkingLot13, parkingSpace16, client19, (int) (short) 10, " -  (hi!)");
        java.lang.String str23 = visit22.getBookingID();
        java.lang.String str24 = visit22.getLicence();
        java.lang.String str25 = visit22.getFormattedStartTime();
        objects.ParkingSpace parkingSpace28 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace28.setType("hi!");
        objects.ParkingSpace parkingSpace33 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace28.update(parkingSpace33, true);
        objects.Car car36 = parkingSpace33.getParkedCar();
        objects.Client client40 = null;
        objects.Car car41 = new objects.Car("", "", "hi!", client40);
        java.lang.String str42 = car41.toString();
        car41.setModel(" -  (hi!)");
        objects.FacultyMember facultyMember47 = new objects.FacultyMember("", " -  (hi!)");
        car41.setOwner((objects.Client) facultyMember47);
        boolean boolean49 = parkingSpace33.parkCar(car41);
        visit22.setParkingSpace(parkingSpace33);
        parkingLot3.addParkingSpace(parkingSpace33);
        java.util.List<objects.ParkingSpace> parkingSpaceList52 = parkingLot3.getAvailableSpaces();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + " -  (hi!)" + "'", str4, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertEquals("'" + str23 + "' != '" + "0" + "'", str23, "0");
        org.junit.Assert.assertEquals("'" + str24 + "' != '" + " -  (hi!)" + "'", str24, " -  (hi!)");
        org.junit.Assert.assertEquals("'" + str25 + "' != '" + "31/12/1969" + "'", str25, "31/12/1969");
        org.junit.Assert.assertNull(car36);
        org.junit.Assert.assertEquals("'" + str42 + "' != '" + " -  (hi!)" + "'", str42, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + boolean49 + "' != '" + true + "'", boolean49 == true);
        org.junit.Assert.assertNotNull(parkingSpaceList52);
    }

    @Test
    public void test217() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test217");
        objects.Client client3 = null;
        objects.Car car4 = new objects.Car("", "", "hi!", client3);
        objects.FacultyMember facultyMember7 = new objects.FacultyMember("", " -  (hi!)");
        car4.setOwner((objects.Client) facultyMember7);
        java.lang.String str9 = facultyMember7.getPassword();
        facultyMember7.setParkingRate(8);
        java.lang.String str12 = facultyMember7.getValidationStatus();
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + " -  (hi!)" + "'", str9, " -  (hi!)");
        org.junit.Assert.assertEquals("'" + str12 + "' != '" + "NotValidated" + "'", str12, "NotValidated");
    }

    @Test
    public void test218() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test218");
        objects.ParkingLot parkingLot3 = new objects.ParkingLot(" -  (hi!)", "hi!", (int) (short) 1);
        java.lang.String str4 = parkingLot3.getName();
        int int5 = parkingLot3.getId();
        java.util.List<objects.ParkingSpace> parkingSpaceList6 = parkingLot3.getAllSpaces();
        java.util.List<objects.ParkingSpace> parkingSpaceList7 = parkingLot3.getAllSpaces();
        java.util.List<objects.ParkingSpace> parkingSpaceList8 = parkingLot3.getAvailableSpaces();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + " -  (hi!)" + "'", str4, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
        org.junit.Assert.assertNotNull(parkingSpaceList6);
        org.junit.Assert.assertNotNull(parkingSpaceList7);
        org.junit.Assert.assertNotNull(parkingSpaceList8);
    }

    @Test
    public void test219() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test219");
        objects.ClientFactory clientFactory0 = new objects.ClientFactory();
        objects.Client client4 = clientFactory0.getNewClient("Available", "superManager", " -  (hi!)");
        objects.Client client8 = clientFactory0.getNewClient("", "Available - Manager (0)", "0");
        org.junit.Assert.assertNull(client4);
        org.junit.Assert.assertNull(client8);
    }

    @Test
    public void test220() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test220");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot7 = new objects.ParkingLot(" -  (hi!)", "hi!", (int) (short) 1);
        java.lang.String str8 = parkingLot7.getLocation();
        parkingLot7.setName("0");
        objects.ParkingSpace parkingSpace13 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace13.setType("hi!");
        objects.ParkingSpace parkingSpace18 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace13.update(parkingSpace18, true);
        objects.Car car21 = parkingSpace18.getParkedCar();
        parkingSpace18.setOccupied(false);
        objects.ParkingLot parkingLot27 = new objects.ParkingLot(" -  (hi!)", "hi!", (int) (short) 1);
        java.lang.String str28 = parkingLot27.getLocation();
        parkingSpace18.setParkingLot(parkingLot27);
        java.lang.String str30 = parkingSpace18.getEnablesString();
        objects.FacultyMember facultyMember33 = new objects.FacultyMember("Super Manager", "superManager");
        businessLogic.Visit visit36 = new businessLogic.Visit(0, date1, (int) (short) 1, 97, parkingLot7, parkingSpace18, (objects.Client) facultyMember33, (int) (byte) 0, "");
        parkingSpace18.setEnabled(true);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "hi!" + "'", str8, "hi!");
        org.junit.Assert.assertNull(car21);
        org.junit.Assert.assertEquals("'" + str28 + "' != '" + "hi!" + "'", str28, "hi!");
        org.junit.Assert.assertEquals("'" + str30 + "' != '" + "Enabled" + "'", str30, "Enabled");
    }

    @Test
    public void test221() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test221");
        objects.ParkingSpace parkingSpace3 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace3.setType("hi!");
        java.lang.String str6 = parkingSpace3.getOccupiedString();
        objects.ParkingSensor parkingSensor7 = new objects.ParkingSensor((int) (byte) 100, parkingSpace3);
        objects.ParkingSpace parkingSpace8 = parkingSensor7.getMonitoredSpace();
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "Available" + "'", str6, "Available");
        org.junit.Assert.assertNotNull(parkingSpace8);
    }

    @Test
    public void test222() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test222");
        objects.ParkingLot parkingLot3 = new objects.ParkingLot("Available - Manager (0)", "Occupied", 10);
        parkingLot3.setName("Space 100 (hi!): Enabled, Available, No Sensor");
    }

    @Test
    public void test223() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test223");
        objects.ParkingSpace parkingSpace2 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.setType("hi!");
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.update(parkingSpace7, true);
        objects.Car car10 = parkingSpace7.getParkedCar();
        objects.Client client14 = null;
        objects.Car car15 = new objects.Car("", "", "hi!", client14);
        java.lang.String str16 = car15.toString();
        car15.setModel(" -  (hi!)");
        objects.FacultyMember facultyMember21 = new objects.FacultyMember("", " -  (hi!)");
        car15.setOwner((objects.Client) facultyMember21);
        boolean boolean23 = parkingSpace7.parkCar(car15);
        java.lang.String str24 = car15.getLicensePlate();
        objects.FacultyMember facultyMember27 = new objects.FacultyMember(" -  (hi!)", " -  (hi!)");
        int int28 = facultyMember27.getParkingRate();
        facultyMember27.setPassword("hi!");
        car15.setOwner((objects.Client) facultyMember27);
        car15.setModel("ParkingS25!");
        org.junit.Assert.assertNull(car10);
        org.junit.Assert.assertEquals("'" + str16 + "' != '" + " -  (hi!)" + "'", str16, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + true + "'", boolean23 == true);
        org.junit.Assert.assertEquals("'" + str24 + "' != '" + "" + "'", str24, "");
        org.junit.Assert.assertTrue("'" + int28 + "' != '" + 8 + "'", int28 == 8);
    }

    @Test
    public void test224() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test224");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot4 = null;
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace7.setType("hi!");
        objects.Client client10 = null;
        businessLogic.Visit visit13 = new businessLogic.Visit((int) (byte) 0, date1, (int) (short) -1, (int) '4', parkingLot4, parkingSpace7, client10, (int) (short) 10, " -  (hi!)");
        java.lang.String str14 = visit13.getBookingID();
        objects.Client client15 = visit13.getClientDetail();
        boolean boolean16 = visit13.isCheckedIn();
        objects.ParkingSpace parkingSpace17 = visit13.getParkingSpace();
        objects.ParkingSpace parkingSpace18 = parkingSpace17.clone();
        parkingSpace18.setEnabled(false);
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "0" + "'", str14, "0");
        org.junit.Assert.assertNull(client15);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNotNull(parkingSpace17);
        org.junit.Assert.assertNotNull(parkingSpace18);
    }

    @Test
    public void test225() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test225");
        businessLogic.PaymentSystem paymentSystem0 = businessLogic.PaymentSystem.getInstance();
        boolean boolean2 = paymentSystem0.confirmRefund(10);
        java.lang.String str4 = paymentSystem0.getPaymentMethod((int) (byte) 10);
        org.junit.Assert.assertNotNull(paymentSystem0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "Unknown" + "'", str4, "Unknown");
    }

    @Test
    public void test226() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test226");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot4 = null;
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace7.setType("hi!");
        objects.Client client10 = null;
        businessLogic.Visit visit13 = new businessLogic.Visit((int) (byte) 0, date1, (int) (short) -1, (int) '4', parkingLot4, parkingSpace7, client10, (int) (short) 10, " -  (hi!)");
        objects.ParkingLot parkingLot14 = visit13.getParkingLot();
        objects.ParkingSpace parkingSpace15 = visit13.getParkingSpace();
        visit13.setDuration((int) '4');
        visit13.checkIn();
        // The following exception was thrown during execution in test generation
        try {
            visit13.setEndTime(10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: date must not be null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(parkingLot14);
        org.junit.Assert.assertNotNull(parkingSpace15);
    }

    @Test
    public void test227() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test227");
        objects.ParkingSpace parkingSpace2 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.setType("hi!");
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.update(parkingSpace7, true);
        objects.Car car10 = parkingSpace7.getParkedCar();
        objects.Client client14 = null;
        objects.Car car15 = new objects.Car("", "", "hi!", client14);
        java.lang.String str16 = car15.getLicensePlate();
        car15.setColor("31/12/1969");
        objects.Client client19 = car15.getOwner();
        java.lang.String str20 = car15.getModel();
        boolean boolean21 = parkingSpace7.parkCar(car15);
        car15.setModel("");
        org.junit.Assert.assertNull(car10);
        org.junit.Assert.assertEquals("'" + str16 + "' != '" + "" + "'", str16, "");
        org.junit.Assert.assertNull(client19);
        org.junit.Assert.assertEquals("'" + str20 + "' != '" + "" + "'", str20, "");
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + true + "'", boolean21 == true);
    }

    @Test
    public void test228() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test228");
        businessLogic.PaymentSystem paymentSystem0 = businessLogic.PaymentSystem.getInstance();
        boolean boolean2 = paymentSystem0.confirmRefund(10);
        java.lang.String str4 = paymentSystem0.getPaymentMethod(100);
        java.lang.String str6 = paymentSystem0.getPaymentMethod(0);
        org.junit.Assert.assertNotNull(paymentSystem0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "Unknown" + "'", str4, "Unknown");
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "Unknown" + "'", str6, "Unknown");
    }

    @Test
    public void test229() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test229");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot4 = null;
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace7.setType("hi!");
        objects.Client client10 = null;
        businessLogic.Visit visit13 = new businessLogic.Visit((int) (byte) 0, date1, (int) (short) -1, (int) '4', parkingLot4, parkingSpace7, client10, (int) (short) 10, " -  (hi!)");
        java.lang.String str14 = visit13.getBookingID();
        objects.Client client15 = visit13.getClientDetail();
        visit13.setDuration();
        objects.Client client17 = visit13.getClientDetail();
        objects.ParkingLot parkingLot18 = visit13.getParkingLot();
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "0" + "'", str14, "0");
        org.junit.Assert.assertNull(client15);
        org.junit.Assert.assertNull(client17);
        org.junit.Assert.assertNull(parkingLot18);
    }

    @Test
    public void test230() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test230");
        objects.ClientFactory clientFactory0 = new objects.ClientFactory();
        objects.Client client4 = clientFactory0.getNewClient("Occupied", "Enabled", "superManager");
        org.junit.Assert.assertNull(client4);
    }

    @Test
    public void test231() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test231");
        objects.ParkingSpace parkingSpace2 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.setType("hi!");
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.update(parkingSpace7, true);
        parkingSpace7.unoccupyTime(1);
        objects.ParkingSpace parkingSpace14 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace14.setType("hi!");
        objects.ParkingSpace parkingSpace19 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace14.update(parkingSpace19, true);
        objects.Car car22 = parkingSpace19.getParkedCar();
        parkingSpace19.setOccupied(false);
        objects.ParkingLot parkingLot28 = new objects.ParkingLot(" -  (hi!)", "hi!", (int) (short) 1);
        java.lang.String str29 = parkingLot28.getLocation();
        parkingSpace19.setParkingLot(parkingLot28);
        parkingSpace7.setParkingLot(parkingLot28);
        int int32 = parkingLot28.getCapcity();
        java.util.List<objects.ParkingSpace> parkingSpaceList33 = parkingLot28.getAvailableSpaces();
        parkingLot28.setId((int) (short) -1);
        java.lang.Class<?> wildcardClass36 = parkingLot28.getClass();
        org.junit.Assert.assertNull(car22);
        org.junit.Assert.assertEquals("'" + str29 + "' != '" + "hi!" + "'", str29, "hi!");
        org.junit.Assert.assertTrue("'" + int32 + "' != '" + 100 + "'", int32 == 100);
        org.junit.Assert.assertNotNull(parkingSpaceList33);
        org.junit.Assert.assertNotNull(wildcardClass36);
    }

    @Test
    public void test232() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test232");
        objects.ParkingSpace parkingSpace2 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.setType("hi!");
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.update(parkingSpace7, true);
        objects.Car car10 = parkingSpace7.getParkedCar();
        parkingSpace7.setOccupied(false);
        objects.ParkingLot parkingLot16 = new objects.ParkingLot(" -  (hi!)", "hi!", (int) (short) 1);
        java.lang.String str17 = parkingLot16.getLocation();
        parkingSpace7.setParkingLot(parkingLot16);
        int int19 = parkingLot16.getAvailableSpacesCount();
        org.junit.Assert.assertNull(car10);
        org.junit.Assert.assertEquals("'" + str17 + "' != '" + "hi!" + "'", str17, "hi!");
        org.junit.Assert.assertTrue("'" + int19 + "' != '" + 100 + "'", int19 == 100);
    }

    @Test
    public void test233() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test233");
        objects.Manager manager2 = new objects.Manager("Available - Manager ()", "superManager");
    }

    @Test
    public void test234() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test234");
        objects.NonFacultyStaff nonFacultyStaff2 = new objects.NonFacultyStaff("NotValidated", "NotValidated");
        java.lang.String str3 = nonFacultyStaff2.getValidationStatus();
        java.lang.Class<?> wildcardClass4 = nonFacultyStaff2.getClass();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "NotValidated" + "'", str3, "NotValidated");
        org.junit.Assert.assertNotNull(wildcardClass4);
    }

    @Test
    public void test235() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test235");
        objects.ParkingSpace parkingSpace3 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace3.setType("hi!");
        objects.ParkingSpace parkingSpace8 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace3.update(parkingSpace8, true);
        objects.Car car11 = parkingSpace8.getParkedCar();
        parkingSpace8.setOccupied(false);
        objects.ParkingLot parkingLot17 = new objects.ParkingLot(" -  (hi!)", "hi!", (int) (short) 1);
        java.lang.String str18 = parkingLot17.getLocation();
        parkingSpace8.setParkingLot(parkingLot17);
        objects.ParkingSensor parkingSensor20 = new objects.ParkingSensor((int) (short) 10, parkingSpace8);
        org.junit.Assert.assertNull(car11);
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + "hi!" + "'", str18, "hi!");
    }

    @Test
    public void test236() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test236");
        objects.NonFacultyStaff nonFacultyStaff2 = new objects.NonFacultyStaff("Available", "0");
        java.lang.String str3 = nonFacultyStaff2.getValidationStatus();
        java.lang.String str4 = nonFacultyStaff2.getValidationStatus();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "NotValidated" + "'", str3, "NotValidated");
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "NotValidated" + "'", str4, "NotValidated");
    }

    @Test
    public void test237() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test237");
        objects.Student student2 = new objects.Student("Enabled", "Manager");
        student2.setParkingRate((int) 'a');
        java.lang.String str5 = student2.getValidationStatus();
        boolean boolean6 = student2.isValidated();
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "NotValidated" + "'", str5, "NotValidated");
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test238() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test238");
        objects.SuperManager superManager0 = objects.SuperManager.getInstance();
        java.lang.String[] strArray1 = superManager0.generateManagerAccount();
        org.junit.Assert.assertNotNull(superManager0);
        org.junit.Assert.assertNotNull(strArray1);
// flaky "3) test238(RegressionTest0)":         org.junit.Assert.assertArrayEquals(strArray1, new java.lang.String[] { "Manager5", "E6Fpp@@0Z:4Ar=z7" });
    }

    @Test
    public void test239() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test239");
        businessLogic.Visit visit1 = businessLogic.Visit.getVisit((int) 'a');
        org.junit.Assert.assertNull(visit1);
    }

    @Test
    public void test240() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test240");
        objects.ParkingSpace parkingSpace2 = new objects.ParkingSpace((int) (byte) 1, " -  (hi!)");
    }

    @Test
    public void test241() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test241");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot4 = null;
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace7.setType("hi!");
        objects.Client client10 = null;
        businessLogic.Visit visit13 = new businessLogic.Visit((int) (byte) 0, date1, (int) (short) -1, (int) '4', parkingLot4, parkingSpace7, client10, (int) (short) 10, " -  (hi!)");
        java.lang.String str14 = visit13.getBookingID();
        java.util.Date date15 = null;
        visit13.setEndTime(date15);
        java.util.Date date17 = null;
        visit13.setEndTime(date17);
        // The following exception was thrown during execution in test generation
        try {
            java.util.Date date19 = visit13.getStartTime();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: date must not be null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "0" + "'", str14, "0");
    }

    @Test
    public void test242() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test242");
        objects.NonFacultyStaff nonFacultyStaff2 = new objects.NonFacultyStaff("0", "Available");
        java.lang.String str3 = nonFacultyStaff2.getValidationStatus();
        java.lang.String str4 = nonFacultyStaff2.getPassword();
        java.lang.String str5 = nonFacultyStaff2.getValidationStatus();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "NotValidated" + "'", str3, "NotValidated");
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "Available" + "'", str4, "Available");
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "NotValidated" + "'", str5, "NotValidated");
    }

    @Test
    public void test243() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test243");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot7 = new objects.ParkingLot(" -  (hi!)", "hi!", (int) (short) 1);
        java.lang.String str8 = parkingLot7.getLocation();
        parkingLot7.setName("0");
        objects.ParkingSpace parkingSpace13 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace13.setType("hi!");
        objects.ParkingSpace parkingSpace18 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace13.update(parkingSpace18, true);
        objects.Car car21 = parkingSpace18.getParkedCar();
        parkingSpace18.setOccupied(false);
        objects.ParkingLot parkingLot27 = new objects.ParkingLot(" -  (hi!)", "hi!", (int) (short) 1);
        java.lang.String str28 = parkingLot27.getLocation();
        parkingSpace18.setParkingLot(parkingLot27);
        java.lang.String str30 = parkingSpace18.getEnablesString();
        objects.FacultyMember facultyMember33 = new objects.FacultyMember("Super Manager", "superManager");
        businessLogic.Visit visit36 = new businessLogic.Visit(0, date1, (int) (short) 1, 97, parkingLot7, parkingSpace18, (objects.Client) facultyMember33, (int) (byte) 0, "");
        int int37 = visit36.getMoneyPaid();
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "hi!" + "'", str8, "hi!");
        org.junit.Assert.assertNull(car21);
        org.junit.Assert.assertEquals("'" + str28 + "' != '" + "hi!" + "'", str28, "hi!");
        org.junit.Assert.assertEquals("'" + str30 + "' != '" + "Enabled" + "'", str30, "Enabled");
        org.junit.Assert.assertTrue("'" + int37 + "' != '" + 0 + "'", int37 == 0);
    }

    @Test
    public void test244() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test244");
        objects.SuperManager superManager0 = new objects.SuperManager();
        boolean boolean4 = superManager0.approveTransaction((int) 'a', "Available - Manager ()", (int) (byte) -1);
        java.lang.String str5 = superManager0.getRole();
        java.lang.String[] strArray6 = superManager0.generateManagerAccount();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "Super Manager" + "'", str5, "Super Manager");
        org.junit.Assert.assertNotNull(strArray6);
// flaky "4) test244(RegressionTest0)":         org.junit.Assert.assertArrayEquals(strArray6, new java.lang.String[] { "Manager7", "sK7#!X&%5KPe6oo9" });
    }

    @Test
    public void test245() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test245");
        objects.ParkingLot parkingLot3 = new objects.ParkingLot(" -  (hi!)", "hi!", (int) (short) 1);
        java.lang.String str4 = parkingLot3.getName();
        int int5 = parkingLot3.getId();
        parkingLot3.setId((int) (byte) -1);
        objects.ParkingLot parkingLot11 = new objects.ParkingLot(" -  (hi!)", "hi!", (int) (short) 1);
        java.lang.String str12 = parkingLot11.getName();
        int int13 = parkingLot11.getId();
        parkingLot11.setId((int) (byte) -1);
        boolean boolean16 = parkingLot11.isEnabled();
        java.util.Date date18 = null;
        objects.ParkingLot parkingLot21 = null;
        objects.ParkingSpace parkingSpace24 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace24.setType("hi!");
        objects.Client client27 = null;
        businessLogic.Visit visit30 = new businessLogic.Visit((int) (byte) 0, date18, (int) (short) -1, (int) '4', parkingLot21, parkingSpace24, client27, (int) (short) 10, " -  (hi!)");
        java.lang.String str31 = visit30.getBookingID();
        java.lang.String str32 = visit30.getLicence();
        java.lang.String str33 = visit30.getFormattedStartTime();
        objects.ParkingSpace parkingSpace36 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace36.setType("hi!");
        objects.ParkingSpace parkingSpace41 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace36.update(parkingSpace41, true);
        objects.Car car44 = parkingSpace41.getParkedCar();
        objects.Client client48 = null;
        objects.Car car49 = new objects.Car("", "", "hi!", client48);
        java.lang.String str50 = car49.toString();
        car49.setModel(" -  (hi!)");
        objects.FacultyMember facultyMember55 = new objects.FacultyMember("", " -  (hi!)");
        car49.setOwner((objects.Client) facultyMember55);
        boolean boolean57 = parkingSpace41.parkCar(car49);
        visit30.setParkingSpace(parkingSpace41);
        parkingLot11.addParkingSpace(parkingSpace41);
        objects.Car car60 = parkingSpace41.removeCar();
        int int61 = parkingSpace41.getSpaceId();
        parkingLot3.addParkingSpace(parkingSpace41);
        java.util.List<objects.ParkingSpace> parkingSpaceList63 = parkingLot3.getAllSpaces();
        int int64 = parkingLot3.getAvailableSpacesCount();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + " -  (hi!)" + "'", str4, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
        org.junit.Assert.assertEquals("'" + str12 + "' != '" + " -  (hi!)" + "'", str12, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 0 + "'", int13 == 0);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + true + "'", boolean16 == true);
        org.junit.Assert.assertEquals("'" + str31 + "' != '" + "0" + "'", str31, "0");
        org.junit.Assert.assertEquals("'" + str32 + "' != '" + " -  (hi!)" + "'", str32, " -  (hi!)");
        org.junit.Assert.assertEquals("'" + str33 + "' != '" + "31/12/1969" + "'", str33, "31/12/1969");
        org.junit.Assert.assertNull(car44);
        org.junit.Assert.assertEquals("'" + str50 + "' != '" + " -  (hi!)" + "'", str50, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + boolean57 + "' != '" + true + "'", boolean57 == true);
        org.junit.Assert.assertNotNull(car60);
        org.junit.Assert.assertTrue("'" + int61 + "' != '" + 100 + "'", int61 == 100);
        org.junit.Assert.assertNotNull(parkingSpaceList63);
        org.junit.Assert.assertTrue("'" + int64 + "' != '" + 101 + "'", int64 == 101);
    }

    @Test
    public void test246() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test246");
        businessLogic.PaymentSystem paymentSystem0 = businessLogic.PaymentSystem.getInstance();
        boolean boolean2 = paymentSystem0.confirmRefund(10);
        boolean boolean6 = paymentSystem0.confirmPayment((int) ' ', "Available", (int) (short) 0);
        boolean boolean10 = paymentSystem0.confirmPayment((int) ' ', "Super Manager", (int) (short) 100);
        org.junit.Assert.assertNotNull(paymentSystem0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
    }

    @Test
    public void test247() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test247");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot4 = null;
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace7.setType("hi!");
        objects.Client client10 = null;
        businessLogic.Visit visit13 = new businessLogic.Visit((int) (byte) 0, date1, (int) (short) -1, (int) '4', parkingLot4, parkingSpace7, client10, (int) (short) 10, " -  (hi!)");
        java.lang.String str14 = visit13.getBookingID();
        objects.Client client15 = visit13.getClientDetail();
        boolean boolean16 = visit13.isCheckedIn();
        objects.ParkingSpace parkingSpace17 = visit13.getParkingSpace();
        objects.ParkingSpace parkingSpace18 = parkingSpace17.clone();
        parkingSpace18.unoccupy((int) (short) 100);
        objects.ParkingSensor parkingSensor21 = parkingSpace18.getSensor();
        objects.Car car22 = parkingSpace18.getParkedCar();
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "0" + "'", str14, "0");
        org.junit.Assert.assertNull(client15);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNotNull(parkingSpace17);
        org.junit.Assert.assertNotNull(parkingSpace18);
        org.junit.Assert.assertNull(parkingSensor21);
        org.junit.Assert.assertNull(car22);
    }

    @Test
    public void test248() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test248");
        objects.ParkingSpace parkingSpace2 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.setType("hi!");
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.update(parkingSpace7, true);
        java.lang.String str10 = parkingSpace2.getOccupiedString();
        parkingSpace2.unoccupyTime((int) (short) 1);
        java.util.Date date13 = null;
        boolean boolean16 = parkingSpace2.isOccupied(date13, (int) '4', (int) (short) -1);
        objects.Client client20 = null;
        objects.Car car21 = new objects.Car("", "", "hi!", client20);
        java.lang.String str22 = car21.getLicensePlate();
        car21.setColor("31/12/1969");
        boolean boolean25 = parkingSpace2.parkCar(car21);
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "Occupied" + "'", str10, "Occupied");
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertEquals("'" + str22 + "' != '" + "" + "'", str22, "");
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + true + "'", boolean25 == true);
    }

    @Test
    public void test249() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test249");
        objects.Student student2 = new objects.Student("Occupied", "NotValidated");
    }

    @Test
    public void test250() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test250");
        objects.Client client6 = null;
        objects.Car car7 = new objects.Car("", "", "hi!", client6);
        objects.FacultyMember facultyMember10 = new objects.FacultyMember("", " -  (hi!)");
        car7.setOwner((objects.Client) facultyMember10);
        objects.Car car12 = new objects.Car("31/12/1969", "0", "Enabled", (objects.Client) facultyMember10);
    }

    @Test
    public void test251() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test251");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot4 = null;
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace7.setType("hi!");
        objects.Client client10 = null;
        businessLogic.Visit visit13 = new businessLogic.Visit((int) (byte) 0, date1, (int) (short) -1, (int) '4', parkingLot4, parkingSpace7, client10, (int) (short) 10, " -  (hi!)");
        java.lang.String str14 = visit13.getBookingID();
        objects.Client client15 = visit13.getClientDetail();
        boolean boolean16 = visit13.isCheckedIn();
        objects.ParkingSpace parkingSpace17 = visit13.getParkingSpace();
        java.lang.String str18 = visit13.getLicence();
        visit13.setDuration(10);
        int int21 = visit13.getMoneyPaid();
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "0" + "'", str14, "0");
        org.junit.Assert.assertNull(client15);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNotNull(parkingSpace17);
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + " -  (hi!)" + "'", str18, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + int21 + "' != '" + 0 + "'", int21 == 0);
    }

    @Test
    public void test252() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test252");
        objects.ParkingLot parkingLot3 = new objects.ParkingLot(" -  (hi!)", "hi!", (int) (short) 1);
        java.lang.String str4 = parkingLot3.getName();
        int int5 = parkingLot3.getId();
        parkingLot3.setId((int) (byte) -1);
        parkingLot3.setLocation("Manager");
        int int10 = parkingLot3.getId();
        int int11 = parkingLot3.getTotalCapacity();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + " -  (hi!)" + "'", str4, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + (-1) + "'", int10 == (-1));
        org.junit.Assert.assertTrue("'" + int11 + "' != '" + 1 + "'", int11 == 1);
    }

    @Test
    public void test253() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test253");
        java.util.Date date2 = null;
        objects.ParkingLot parkingLot5 = null;
        objects.ParkingSpace parkingSpace8 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace8.setType("hi!");
        objects.Client client11 = null;
        businessLogic.Visit visit14 = new businessLogic.Visit((int) (byte) 0, date2, (int) (short) -1, (int) '4', parkingLot5, parkingSpace8, client11, (int) (short) 10, " -  (hi!)");
        java.lang.String str15 = visit14.getBookingID();
        java.lang.String str16 = visit14.getLicence();
        java.lang.String str17 = visit14.getFormattedStartTime();
        objects.ParkingSpace parkingSpace20 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace20.setType("hi!");
        objects.ParkingSpace parkingSpace25 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace20.update(parkingSpace25, true);
        objects.Car car28 = parkingSpace25.getParkedCar();
        objects.Client client32 = null;
        objects.Car car33 = new objects.Car("", "", "hi!", client32);
        java.lang.String str34 = car33.toString();
        car33.setModel(" -  (hi!)");
        objects.FacultyMember facultyMember39 = new objects.FacultyMember("", " -  (hi!)");
        car33.setOwner((objects.Client) facultyMember39);
        boolean boolean41 = parkingSpace25.parkCar(car33);
        visit14.setParkingSpace(parkingSpace25);
        objects.ParkingSensor parkingSensor43 = new objects.ParkingSensor((int) 'a', parkingSpace25);
        boolean boolean44 = parkingSensor43.isOccupied();
        java.util.Date date46 = null;
        objects.ParkingLot parkingLot49 = null;
        objects.ParkingSpace parkingSpace52 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace52.setType("hi!");
        objects.Client client55 = null;
        businessLogic.Visit visit58 = new businessLogic.Visit((int) (byte) 0, date46, (int) (short) -1, (int) '4', parkingLot49, parkingSpace52, client55, (int) (short) 10, " -  (hi!)");
        java.lang.String str59 = visit58.getBookingID();
        objects.Client client60 = visit58.getClientDetail();
        boolean boolean61 = visit58.isCheckedIn();
        objects.ParkingSpace parkingSpace62 = visit58.getParkingSpace();
        parkingSensor43.removeObserver((objects.ParkingStatusObserver) parkingSpace62);
        objects.ParkingSpace parkingSpace64 = parkingSensor43.getMonitoredSpace();
        objects.ParkingSpace parkingSpace65 = parkingSpace64.clone();
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + "0" + "'", str15, "0");
        org.junit.Assert.assertEquals("'" + str16 + "' != '" + " -  (hi!)" + "'", str16, " -  (hi!)");
        org.junit.Assert.assertEquals("'" + str17 + "' != '" + "31/12/1969" + "'", str17, "31/12/1969");
        org.junit.Assert.assertNull(car28);
        org.junit.Assert.assertEquals("'" + str34 + "' != '" + " -  (hi!)" + "'", str34, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + boolean41 + "' != '" + true + "'", boolean41 == true);
        org.junit.Assert.assertTrue("'" + boolean44 + "' != '" + false + "'", boolean44 == false);
        org.junit.Assert.assertEquals("'" + str59 + "' != '" + "0" + "'", str59, "0");
        org.junit.Assert.assertNull(client60);
        org.junit.Assert.assertTrue("'" + boolean61 + "' != '" + false + "'", boolean61 == false);
        org.junit.Assert.assertNotNull(parkingSpace62);
        org.junit.Assert.assertNotNull(parkingSpace64);
        org.junit.Assert.assertNotNull(parkingSpace65);
    }

    @Test
    public void test254() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test254");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot4 = null;
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace7.setType("hi!");
        objects.Client client10 = null;
        businessLogic.Visit visit13 = new businessLogic.Visit((int) (byte) 0, date1, (int) (short) -1, (int) '4', parkingLot4, parkingSpace7, client10, (int) (short) 10, " -  (hi!)");
        java.lang.String str14 = visit13.getBookingID();
        java.lang.String str15 = visit13.getLicence();
        visit13.setDuration((int) 'a');
        java.lang.String str18 = visit13.getBookingID();
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "0" + "'", str14, "0");
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + " -  (hi!)" + "'", str15, " -  (hi!)");
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + "0" + "'", str18, "0");
    }

    @Test
    public void test255() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test255");
        database.Database database1 = new database.Database("Manager");
    }

    @Test
    public void test256() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test256");
        objects.ParkingLot parkingLot3 = new objects.ParkingLot(" -  (hi!)", "hi!", (int) (short) 1);
        java.lang.String str4 = parkingLot3.getName();
        int int5 = parkingLot3.getId();
        java.util.List<objects.ParkingSpace> parkingSpaceList6 = parkingLot3.getAllSpaces();
        java.util.List<objects.ParkingSpace> parkingSpaceList7 = parkingLot3.getAllSpaces();
        boolean boolean9 = parkingLot3.removeParkingSpace((int) (short) 10);
        java.lang.String str10 = parkingLot3.getLocation();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + " -  (hi!)" + "'", str4, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
        org.junit.Assert.assertNotNull(parkingSpaceList6);
        org.junit.Assert.assertNotNull(parkingSpaceList7);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + true + "'", boolean9 == true);
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "hi!" + "'", str10, "hi!");
    }

    @Test
    public void test257() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test257");
        objects.Client client3 = null;
        objects.Car car4 = new objects.Car("", "", "hi!", client3);
        java.lang.String str5 = car4.toString();
        car4.setModel(" -  (hi!)");
        objects.FacultyMember facultyMember10 = new objects.FacultyMember("", " -  (hi!)");
        car4.setOwner((objects.Client) facultyMember10);
        java.lang.String str12 = facultyMember10.getPassword();
        boolean boolean13 = facultyMember10.isValidated();
        facultyMember10.setEmail("Super Manager");
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + " -  (hi!)" + "'", str5, " -  (hi!)");
        org.junit.Assert.assertEquals("'" + str12 + "' != '" + " -  (hi!)" + "'", str12, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
    }

    @Test
    public void test258() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test258");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot4 = null;
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace7.setType("hi!");
        objects.Client client10 = null;
        businessLogic.Visit visit13 = new businessLogic.Visit((int) (byte) 0, date1, (int) (short) -1, (int) '4', parkingLot4, parkingSpace7, client10, (int) (short) 10, " -  (hi!)");
        java.lang.String str14 = visit13.getBookingID();
        java.lang.String str15 = visit13.getLicence();
        visit13.setDuration((int) 'a');
        java.lang.String str18 = visit13.getFormattedStartTime();
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str19 = visit13.getDateString();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: date must not be null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "0" + "'", str14, "0");
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + " -  (hi!)" + "'", str15, " -  (hi!)");
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + "31/12/1969" + "'", str18, "31/12/1969");
    }

    @Test
    public void test259() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test259");
        java.util.Date date1 = null;
        objects.ParkingLot parkingLot4 = null;
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace7.setType("hi!");
        objects.Client client10 = null;
        businessLogic.Visit visit13 = new businessLogic.Visit((int) (byte) 0, date1, (int) (short) -1, (int) '4', parkingLot4, parkingSpace7, client10, (int) (short) 10, " -  (hi!)");
        objects.ParkingLot parkingLot14 = visit13.getParkingLot();
        int int15 = visit13.getDuration();
        org.junit.Assert.assertNull(parkingLot14);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 52 + "'", int15 == 52);
    }

    @Test
    public void test260() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test260");
        java.util.Date date2 = null;
        objects.ParkingLot parkingLot5 = null;
        objects.ParkingSpace parkingSpace8 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace8.setType("hi!");
        objects.Client client11 = null;
        businessLogic.Visit visit14 = new businessLogic.Visit((int) (byte) 0, date2, (int) (short) -1, (int) '4', parkingLot5, parkingSpace8, client11, (int) (short) 10, " -  (hi!)");
        java.lang.String str15 = visit14.getBookingID();
        java.lang.String str16 = visit14.getLicence();
        java.lang.String str17 = visit14.getFormattedStartTime();
        objects.ParkingSpace parkingSpace20 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace20.setType("hi!");
        objects.ParkingSpace parkingSpace25 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace20.update(parkingSpace25, true);
        objects.Car car28 = parkingSpace25.getParkedCar();
        objects.Client client32 = null;
        objects.Car car33 = new objects.Car("", "", "hi!", client32);
        java.lang.String str34 = car33.toString();
        car33.setModel(" -  (hi!)");
        objects.FacultyMember facultyMember39 = new objects.FacultyMember("", " -  (hi!)");
        car33.setOwner((objects.Client) facultyMember39);
        boolean boolean41 = parkingSpace25.parkCar(car33);
        visit14.setParkingSpace(parkingSpace25);
        objects.ParkingSensor parkingSensor43 = new objects.ParkingSensor((int) 'a', parkingSpace25);
        boolean boolean44 = parkingSensor43.isOccupied();
        java.util.Date date46 = null;
        objects.ParkingLot parkingLot49 = null;
        objects.ParkingSpace parkingSpace52 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace52.setType("hi!");
        objects.Client client55 = null;
        businessLogic.Visit visit58 = new businessLogic.Visit((int) (byte) 0, date46, (int) (short) -1, (int) '4', parkingLot49, parkingSpace52, client55, (int) (short) 10, " -  (hi!)");
        java.lang.String str59 = visit58.getBookingID();
        objects.Client client60 = visit58.getClientDetail();
        boolean boolean61 = visit58.isCheckedIn();
        objects.ParkingSpace parkingSpace62 = visit58.getParkingSpace();
        parkingSensor43.removeObserver((objects.ParkingStatusObserver) parkingSpace62);
        parkingSensor43.detectVehicle(true);
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + "0" + "'", str15, "0");
        org.junit.Assert.assertEquals("'" + str16 + "' != '" + " -  (hi!)" + "'", str16, " -  (hi!)");
        org.junit.Assert.assertEquals("'" + str17 + "' != '" + "31/12/1969" + "'", str17, "31/12/1969");
        org.junit.Assert.assertNull(car28);
        org.junit.Assert.assertEquals("'" + str34 + "' != '" + " -  (hi!)" + "'", str34, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + boolean41 + "' != '" + true + "'", boolean41 == true);
        org.junit.Assert.assertTrue("'" + boolean44 + "' != '" + false + "'", boolean44 == false);
        org.junit.Assert.assertEquals("'" + str59 + "' != '" + "0" + "'", str59, "0");
        org.junit.Assert.assertNull(client60);
        org.junit.Assert.assertTrue("'" + boolean61 + "' != '" + false + "'", boolean61 == false);
        org.junit.Assert.assertNotNull(parkingSpace62);
    }

    @Test
    public void test261() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test261");
        objects.ParkingLot parkingLot3 = new objects.ParkingLot("Available - Manager ()", "ParkingS25!", 52);
        java.util.List<objects.ParkingSpace> parkingSpaceList4 = parkingLot3.getAvailableSpaces();
        org.junit.Assert.assertNotNull(parkingSpaceList4);
    }

    @Test
    public void test262() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test262");
        objects.Visitor visitor2 = new objects.Visitor("31/12/1969", "ParkingS25!");
        visitor2.setParkingRate((int) (byte) -1);
    }

    @Test
    public void test263() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test263");
        objects.ParkingSpace parkingSpace2 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.setType("hi!");
        objects.ParkingSpace parkingSpace7 = new objects.ParkingSpace((int) (short) 100, "hi!");
        parkingSpace2.update(parkingSpace7, true);
        objects.Car car10 = parkingSpace7.getParkedCar();
        objects.Client client14 = null;
        objects.Car car15 = new objects.Car("", "", "hi!", client14);
        java.lang.String str16 = car15.toString();
        car15.setModel(" -  (hi!)");
        objects.FacultyMember facultyMember21 = new objects.FacultyMember("", " -  (hi!)");
        car15.setOwner((objects.Client) facultyMember21);
        boolean boolean23 = parkingSpace7.parkCar(car15);
        java.lang.String str24 = car15.toString();
        org.junit.Assert.assertNull(car10);
        org.junit.Assert.assertEquals("'" + str16 + "' != '" + " -  (hi!)" + "'", str16, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + true + "'", boolean23 == true);
        org.junit.Assert.assertEquals("'" + str24 + "' != '" + " -  -  (hi!) (hi!)" + "'", str24, " -  -  (hi!) (hi!)");
    }

    @Test
    public void test264() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test264");
        objects.ParkingLot parkingLot3 = new objects.ParkingLot(" -  (hi!)", "hi!", (int) (short) 1);
        java.lang.String str4 = parkingLot3.getName();
        int int5 = parkingLot3.getId();
        parkingLot3.setId((int) (byte) -1);
        boolean boolean8 = parkingLot3.isEnabled();
        java.lang.String str9 = parkingLot3.getStatus();
        parkingLot3.setStatus(true);
        int int12 = parkingLot3.getId();
        parkingLot3.setName("Unknown");
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + " -  (hi!)" + "'", str4, " -  (hi!)");
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "Enabled" + "'", str9, "Enabled");
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + (-1) + "'", int12 == (-1));
    }

    @Test
    public void test265() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test265");
        objects.ParkingLot parkingLot3 = new objects.ParkingLot(" -  (hi!)", "hi!", (int) (short) 1);
        parkingLot3.setLocation("31/12/1969");
        parkingLot3.setEnabled(true);
    }
}
