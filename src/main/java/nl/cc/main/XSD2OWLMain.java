package nl.cc.main;

import java.io.File;
import java.io.FileOutputStream;

import tr.com.srdc.ontmalizer.XSD2OWLMapper;

public class XSD2OWLMain {

	public static void main(String[] args) {

		// This part converts XML schema to OWL ontology.
		XSD2OWLMapper mapping = new XSD2OWLMapper(new File("src/test/resources/oo/PARTIJ.xsd"));
		mapping.setObjectPropPrefix("");
		mapping.setDataTypePropPrefix("");
		mapping.convertXSD2OWL();

		// This part prints the ontology to the specified file.
		FileOutputStream ont;
		try {
		   File f = new File("src/test/resources/output/cda-ontology.rdf");
		   f.getParentFile().mkdirs();
		   ont = new FileOutputStream(f);
		   mapping.writeOntology(ont, "RDF/XML");
		   ont.close();
		} catch (Exception e) {
		   e.printStackTrace();
		}
		

	}

}
