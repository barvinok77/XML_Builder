package core;

import java.text.DecimalFormat;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

@Path("/")
public class Converter {

	@GET
	@Path("length/imperial/xml")
	@Produces("application/xml")
	public Response convertInToCmfromInputXML(@DefaultValue("1") @QueryParam("in>>cm") Double input) throws ParserConfigurationException {
		DecimalFormat df = new DecimalFormat("####0.00");
		Double inches = input;
		Double centimeter = inches * 2.54;
		String in = df.format(inches).toString();
		String cm = df.format(centimeter).toString();

		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		// root elements
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("calc");
		rootElement.setAttribute("conversion", "inches to centimeters");
		doc.appendChild(rootElement);

		// first element
		Element first = doc.createElement("inches");
		first.appendChild(doc.createTextNode(in));
		rootElement.appendChild(first);

		// second element
		Element second = doc.createElement("centimeter");
		second.appendChild(doc.createTextNode(cm));
		rootElement.appendChild(second);

		return Response.status(200).entity(doc).build();
	}

	@GET
	@Path("length/metric/xml")
	@Produces("application/xml")
	public Response convertCmToInfromInputXML(@DefaultValue("1") @QueryParam("cm>>in") Double input) throws ParserConfigurationException {
		DecimalFormat df = new DecimalFormat("####0.00");
		Double centimeter = input;
		Double inches = centimeter * 0.3937;
		String in = df.format(inches).toString();
		String cm = df.format(centimeter).toString();
		
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("calc");
		rootElement.setAttribute("conversion", "centimeters to inches");
		doc.appendChild(rootElement);

		Element first = doc.createElement("centimeter");
		first.appendChild(doc.createTextNode(cm));
		rootElement.appendChild(first);

		Element second = doc.createElement("inches");
		second.appendChild(doc.createTextNode(in));
		rootElement.appendChild(second);

		return Response.status(200).entity(doc).build();
	}

	@GET
	@Path("weight/imperial/xml")
	@Produces("application/xml")
	public Response convertLbToKgfromInputXML(@DefaultValue("1") @QueryParam("lb>>kg") Double input) throws ParserConfigurationException {
		DecimalFormat df = new DecimalFormat("####0.00");
		Double pound = input;
		Double kilogram = pound * 0.4536;
		String lb = df.format(pound).toString();
		String kg = df.format(kilogram).toString();
		
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("calc");
		rootElement.setAttribute("conversion", "pounds to kilograms");
		doc.appendChild(rootElement);

		Element first = doc.createElement("pound");
		first.appendChild(doc.createTextNode(lb));
		rootElement.appendChild(first);

		Element second = doc.createElement("kilogram");
		second.appendChild(doc.createTextNode(kg));
		rootElement.appendChild(second);

		return Response.status(200).entity(doc).build();
	}

	@GET
	@Path("weight/metric/xml")
	@Produces("application/xml")
	public Response convertKgToLbfromInputXML(@DefaultValue("1") @QueryParam("kg>>lb") Double input) throws ParserConfigurationException {
		DecimalFormat df = new DecimalFormat("####0.00");
		Double kilogram = input;
		Double pound = kilogram * 2.2046;
		String lb = df.format(pound).toString();
		String kg = df.format(kilogram).toString();
		
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("calc");
		rootElement.setAttribute("conversion", "kilograms to pounds");
		doc.appendChild(rootElement);

		Element first = doc.createElement("kilogram");
		first.appendChild(doc.createTextNode(lb));
		rootElement.appendChild(first);

		Element second = doc.createElement("pound");
		second.appendChild(doc.createTextNode(kg));
		rootElement.appendChild(second);

		return Response.status(200).entity(doc).build();
	}
}
