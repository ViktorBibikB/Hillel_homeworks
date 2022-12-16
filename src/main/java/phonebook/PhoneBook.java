package phonebook;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
    List<Record> records;

    public PhoneBook(){
        records = new ArrayList<>();
    }

    public void add(Record record){
        records.add(record);
    }

    public Record find(String name){
        for (Record record: records) {
            if(record.getName().equals(name))
                return record;
        }
        return null;
    }

    public List<Record> findAll(String name){
        List<Record> recordList = new ArrayList<>();
        for (Record record: records) {
            if(record.getName().equals(name))
                recordList.add(record);
        }
        return recordList.isEmpty() ? null : recordList;
    }

    public void addToFile(Record record, String filePath){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))){
            writer.write(String.valueOf(record));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "records=" + records +
                '}';
    }
}
