package comparator.core;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class FileComparator {
    public static void Compare(String file1, String file2) {

        ObjectMapper objectMapper = new ObjectMapper();
        
        System.out.println(file1);
        try {
            JsonNode rootNode = objectMapper.readTree(new File(file1));
            JsonNode rootNode2 = objectMapper.readTree(new File(file2));
            Iterator<Map.Entry<String, JsonNode>> fieldsIterator = rootNode.fields();
            Iterator<Map.Entry<String, JsonNode>> fieldsIterator2 = rootNode2.fields();
            while (fieldsIterator.hasNext()) {
                Map.Entry<String, JsonNode> field = fieldsIterator.next();
                if(!rootNode2.has(field.getKey())){
                    System.out.println("+"+field.getKey()+" : "+field.getValue());
                }
               
            }
            while (fieldsIterator2.hasNext()) {
                Map.Entry<String, JsonNode> field = fieldsIterator2.next();
                if(!rootNode.has(field.getKey())){
                    System.out.println("-"+field.getKey()+" : "+field.getValue());
                }
               
            }
        
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }    
}
