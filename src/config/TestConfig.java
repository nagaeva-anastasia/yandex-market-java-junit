package config;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.openqa.jetty.html.List;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class TestConfig {	
	private ArrayList<Element> nodes;
	
	public TestConfig(String path)
	{		
		nodes = GetTestConfig(path);
	}
	
	public ArrayList<Element> GetTestConfig(String path)
	{			
		try {
	        File fXmlFile = new File(path);
	        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	        Document doc = dBuilder.parse(fXmlFile); 
	        doc.getDocumentElement().normalize(); 
	        
	        NodeList nList = doc.getElementsByTagName("test");
	        nodes = new ArrayList<Element>();
	
	        for (int temp = 0; temp < nList.getLength(); temp++) {
	        	Node nNode = nList.item(temp);		        
	        	if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	        		Element el = (Element)nNode;
			        nodes.add(el);
	        	}
	        }
       } catch (Exception e) {
    	   e.printStackTrace();
       }	
		
		return nodes;
	}	
		
	public ArrayList<ConfigStruct> GetValues()
	{
		ArrayList<ConfigStruct> values = new ArrayList<ConfigStruct>();
		
		for(Element node : nodes)
		{
			ConfigStruct config = new ConfigStruct();
			config.browser = node.getElementsByTagName("browser").item(0).getTextContent();
			config.priceFrom = node.getElementsByTagName("priceFrom").item(0).getTextContent();
			config.priceTo = node.getElementsByTagName("priceTo").item(0).getTextContent();
			config.type = node.getElementsByTagName("type").item(0).getTextContent();
			config.platform = node.getElementsByTagName("platform").item(0).getTextContent();
			
			values.add(config);
		}
		
		return values;
	}
}
