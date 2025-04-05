module YorkUParkingBookingSystem {
	exports main.java.database;
	exports main.java.presentation;
	exports main.java.objects;
	exports main.java.businessLogic;

	requires java.desktop;
	requires javacsv;
    requires org.junit.jupiter.api;
    requires org.junit.jupiter.engine;
}