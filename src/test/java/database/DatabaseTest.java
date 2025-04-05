package test.java.database;

import main.java.database.Database;
import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DatabaseTest {
	
    private static Path tempFile;
    private Database db;

    @BeforeEach
    public void setup() throws IOException {
        tempFile = Files.createTempFile("test", ".csv");
        Files.write(tempFile, Arrays.asList(
                "ID,Name,Location, SpaceID",
                "1,Alice,Lot 1, 101",
                "2,Bob,Lot 2, 123",
                "3,Eve,Lot A, 132"
        ));
        db = new Database(tempFile.toString());
    }

    @AfterEach
    public void teardown() throws IOException {
        Files.deleteIfExists(tempFile);
    }



    @Test
    public void testRead() throws Exception {
        List<String[]> rows = db.read();
        assertEquals(3, rows.size());
        assertEquals("Alice", rows.get(0)[1]);
    }

    @Test
    public void testUpdateAppendsNewRow() throws Exception {
        String[] newRow = {"4", "David", "Lot B", "145"};
        db.update(newRow);

        List<String[]> rows = db.read();
        assertEquals(4, rows.size());
        String[] lastRow = rows.get(3);
        assertEquals("David", lastRow[1]);
        assertEquals("Lot B", lastRow[2]);
        assertEquals("145", lastRow[3].trim());
    }

    @Test
    public void testOverwriteRowById() throws Exception {
        String[] updatedRow = {"2", "Bob", "Lot 5", "999"};
        db.overWrite("2", updatedRow, 4);

        List<String[]> rows = db.read();
        String[] row = rows.get(1);
        assertEquals("Bob", row[1]);
        assertEquals("Lot 5", row[2]);
        assertEquals("999", row[3].trim());
    }

    @Test
    public void testOverwriteColumnValueById() throws Exception {
        db.overWrite("2", 4, 3, "888", 0); 

        List<String[]> rows = db.read();
        String[] row = rows.get(1);
        assertEquals("888", row[3].trim());
    }

    @Test
    public void testRemoveRowById() throws Exception {
        db.remove("2", 4);

        List<String[]> rows = db.read();
        assertEquals(2, rows.size());
        assertEquals("Eve", rows.get(1)[1]);
    }

    @Test
    public void testRemoveNonExistingId() throws Exception {
        db.remove("10", 4); 

        List<String[]> rows = db.read();
        assertEquals(3, rows.size());
    }

    @Test
    public void testOverwriteDoesNotChangeOtherRows() throws Exception {
        String[] updatedRow = {"2", "Bob", "Lot Z", "555"};
        db.overWrite("2", updatedRow, 4);

        List<String[]> rows = db.read();
        assertEquals("Alice", rows.get(0)[1]);      
        assertEquals("Lot Z", rows.get(1)[2]);        
        assertEquals("132", rows.get(2)[3].trim());   
    }

    @Test
    public void testMultipleColumnUpdates() throws Exception {
        db.overWrite("1", 4, 3, "200", 0);  
        db.overWrite("3", 4, 2, "Lot X", 0); 

        List<String[]> rows = db.read();
        assertEquals("200", rows.get(0)[3].trim()); 
        assertEquals("Lot X", rows.get(2)[2]);   
    }

    @Test
    public void testUpdateWithEmptyRow() throws Exception {
        String[] emptyRow = {"5", "", "", ""};
        db.update(emptyRow);

        List<String[]> rows = db.read();
        assertEquals(4, rows.size());
        assertEquals("5", rows.get(3)[0]);
        assertEquals("", rows.get(3)[1]);
    }

    @Test
    public void testReadEmptyFile() throws Exception {
        Files.write(tempFile, Collections.singletonList("ID,Name,Location, SpaceID"));
        List<String[]> rows = db.read();
        assertEquals(0, rows.size());
    }


}