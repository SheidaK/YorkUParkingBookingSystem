package database;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import objects.Manager;
import objects.SuperManager;
public class Database {
	String filePath;
	public Database(String path) {
		this.filePath= path;
	}
	public List<String[]> read()throws Exception{
        List<String[]> rows = new ArrayList<>();
		CsvReader reader;
		try {
			reader = new CsvReader(this.filePath);
			reader.readHeaders();
			while (reader.readRecord()) {
				rows.add(reader.getValues());
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		return rows;
	}
	public void overWrite() {
		
	}
	public void update(String[] newRow) {
		try {
			CsvReader reader = new CsvReader(this.filePath);
            CsvWriter csvOutput = new CsvWriter(new FileWriter(this.filePath, true), ',');
            reader.readHeaders(); // Skip headers if present
			 List<String[]> existingData = new ArrayList<>();
			 while (reader.readRecord()) {
				 existingData.add(reader.getValues()); // Write the existing records to the new file
	         }
			csvOutput.writeRecord(newRow);
			reader.close();
			csvOutput.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void remove(String id,int numOfHeaders) {
		try {
			CsvReader reader = new CsvReader(this.filePath);
            reader.readHeaders(); 
			 List<String[]> existingData = new ArrayList<>();
			 String[] header = new String[numOfHeaders];
			 header = reader.getHeaders();
			 existingData.add(header);
			 while (reader.readRecord()) {
				 String[] row = reader.getValues();
				 if(!row[0].equals(id)) {
					 existingData.add(row);
				 }
	         }
			 reader.close();
			 CsvWriter csvOutput = new CsvWriter(new FileWriter(this.filePath, false), ',');
			 for (String[] row : existingData) {
				 csvOutput.writeRecord(row);
	            }
			csvOutput.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
