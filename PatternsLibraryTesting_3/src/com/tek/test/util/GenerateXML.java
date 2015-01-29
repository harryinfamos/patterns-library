package com.tek.test.util;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
 
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
 
public class GenerateXML {
	
	public static String[] browserName={"Chrome","Firefox","InternetExplorer"};
	public static String[] testCaseName={"CSSPatternsTest","AttPatternsTest"};
	public static String[] testCaseClassName={"com.tek.test.patterns.VerifyComponents","com.tek.test.patterns.VerifypatternsOnSite"};
 
	public static void main(String argv[]) {
 
	  try {
 
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
 
		// root elements
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("suite");
		doc.appendChild(rootElement);
		
		Attr suiteName = doc.createAttribute("name");
		suiteName.setValue("Test Suite");
		rootElement.setAttributeNode(suiteName);
 
		for(int i=0;i<browserName.length;i++)
		{
			Element test = doc.createElement("test");
			rootElement.appendChild(test);
	 
			Attr verbose = doc.createAttribute("verbose");
			verbose.setValue("2");
			test.setAttributeNode(verbose);
			
			Attr browserTestName = doc.createAttribute("name");
			browserTestName.setValue(browserName[i]+" Test");
			test.setAttributeNode(browserTestName);
			
			Element parameter = doc.createElement("parameter");
			test.appendChild(parameter);
			
			Attr browserType = doc.createAttribute("name");
			browserType.setValue("BrowserType");
			parameter.setAttributeNode(browserType);
	 
			Attr value = doc.createAttribute("value");
			value.setValue(browserName[i]);
			parameter.setAttributeNode(value);
			
			Element groups = doc.createElement("groups");
			test.appendChild(groups);
			
			Element run = doc.createElement("run");
			groups.appendChild(run);
			
			for(int j=0;j<testCaseName.length;j++)
			{
				Element include = doc.createElement("include");
				run.appendChild(include);
		 
				Attr tcname = doc.createAttribute("name");
				tcname.setValue(testCaseName[j]);
				include.setAttributeNode(tcname);
			}
			
				Element classes = doc.createElement("classes");
				test.appendChild(classes);
				
			for(int j=0;j<testCaseClassName.length;j++)
			{
				
				Element childClass = doc.createElement("class");
				classes.appendChild(childClass);
		 
				Attr className = doc.createAttribute("name");
				className.setValue(testCaseClassName[j]);
				childClass.setAttributeNode(className);
			}
		}
 
		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File("src\\generatedTestNG-suite.xml"));

 
		transformer.transform(source, result);
 
		System.out.println("File saved!");
 
	  } catch (ParserConfigurationException pce) {
		pce.printStackTrace();
	  } catch (TransformerException tfe) {
		tfe.printStackTrace();
	  }
	}
}
