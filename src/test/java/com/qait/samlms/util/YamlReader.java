package com.qait.samlms.util;



import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Map;
import java.util.StringTokenizer;
import org.yaml.snakeyaml.Yaml;

@SuppressWarnings("unchecked")
public class YamlReader {
    public static String yamlFilePath = "resources//testdata//TestData.yml";

    public static String setYamlFilePath(String filePath) {
        yamlFilePath = filePath;
        System.out.println(yamlFilePath);
        return yamlFilePath;
    }
    
    public static String getYamlValue(String token){
        try {
            return getValue(token);
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
     
	public static Map<String, Object> getYamlValues(String token){
        Reader doc;
        try {
            doc = new FileReader(yamlFilePath);
        } catch (FileNotFoundException ex) {
            System.out.println("File not valid or missing!!!");
            ex.printStackTrace();
            return null;
        }
        Yaml yaml = new Yaml();
        //TODO: check the type casting of object into the Map and create instance in one place
       Map<String, Object> object = (Map<String, Object>) yaml.load(doc);
        return parseMap(object, token);
    }

    
    private static String getValue(String token) throws FileNotFoundException {
        Reader doc = new FileReader(yamlFilePath);
        Yaml yaml = new Yaml();
        Map<String, Object> object = (Map<String, Object>) yaml.load(doc);
        return getMapValue(object, token);

    }

    public static String getMapValue(Map<String, Object> object, String token) {
        //TODO: check for proper yaml token string based on presence of '.'
        String[] st = token.split("\\.");
        return parseMap(object, token).get(st[st.length - 1]).toString();
    }

    private static Map<String, Object> parseMap(Map<String, Object> object, String token) {
        if (token.contains(".")) {
            String[] st = token.split("\\.");
            object = parseMap((Map<String, Object>) object.get(st[0]), token.replace(st[0] + ".", ""));
        }
        return object;
    }
    
    public static  Map<String, Object> getYamlNodesArray(String yamlToken) {
		Reader reader = null;
		int tokenCount = 0, i = 0;
		 Map<String, Object> map = null;

		StringTokenizer st = new java.util.StringTokenizer(yamlToken + ".x", ".");
		try {
			
			reader = new FileReader(yamlFilePath);
			Yaml yaml = new Yaml();
			map = ( Map<String, Object>) yaml.load(reader);
			tokenCount = st.countTokens();
			for (i = 1; i < tokenCount; i++) {
				String token = st.nextToken();
				map = ( Map<String, Object>) map.get(token);
			}
			return map;
		} catch (Exception e) {
			System.out.println("Either Yaml file not found or there is problem with token passed!!!\n" + e);
			return null;
		}
	}

}
