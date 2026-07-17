/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bindingjaxb;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.XMLConstants;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
/**
 *
 * @author jakk
 */
public class Main {

    public static void main(String[] args) throws Exception {
           demoValidationXSD();
    }
    
    
    //**************************************************************************
    // Marshalling
    //**************************************************************************
    
    public static void demoMarshalling()throws Exception{

        Etudiant e = new Etudiant(
            1,
            "Diallo",
            "Aminata",
            "Informatique",
            2,
            Arrays.asList(15.5, 14.0, 16.5)
        );

        JAXBContext context = JAXBContext.newInstance(Etudiant.class);
        Marshaller marshaller = context.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshaller.marshal(e, System.out);
        
        
    }
    
    //******************************************************************************
    // Unmarshalling 
    //******************************************************************************

    public static void demoUnmarshalling()throws Exception{
                String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                                "<etudiant xmlns=\"http://mycompany.com/etudiant\" id=\"1\">" +
                                "    <nom>Diallo</nom>" +
                                "    <prenom>Aminata</prenom>" +
                                "    <filiere>Informatique</filiere>" +
                                "    <annee>2</annee>" +
                                "    <notes>" +
                                "        <note>15.5</note>" +
                                "        <note>14.0</note>" +
                                "        <note>13.5</note>" +
                                "    </notes>" +
                                "</etudiant>";

        JAXBContext context = JAXBContext.newInstance(Etudiant.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        Etudiant e = (Etudiant) unmarshaller.unmarshal(new StringReader(xml));

        System.out.println("Nom: " + e.getNom());
        System.out.println("Prénom: " + e.getPrenom());
        System.out.println("Filière: " + e.getFiliere());
        System.out.println("Année: " + e.getAnnee());
        System.out.println("Moyenne: " + e.getNotes());
    }
    
    
    //**************************************************************************
    //Unmarshalling avec validation XSD
    //**************************************************************************
    
    public static void demoValidationXSD() throws Exception{
         String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<etudiant xmlns=\"http://mycompany.com/etudiant\" id=\"1\">" +
                        "    <nom>Diallo</nom>" +
                        "    <prenom>Aminata</prenom>" +
                        "    <filiere>Informatique</filiere>" +
                        "    <annee>2</annee>" +
                        "    <notes>" +
                        "        <note>15.5</note>" +
                        "        <note>14.0</note>" +
                        "        <note>16.5</note>" +
                        "    </notes>" +
                        "</etudiant>";


        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = sf.newSchema(Main.class.getResource("/etudiant.xsd"));

        JAXBContext context = JAXBContext.newInstance(Etudiant.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        unmarshaller.setSchema(schema);

        unmarshaller.setEventHandler((ValidationEvent event) -> {
            System.out.println("Erreur : " + event.getMessage());
            return false;
        });

        Etudiant e = (Etudiant) unmarshaller.unmarshal(new StringReader(xml));

        System.out.println("Nom: " + e.getNom());
        System.out.println("Prénom: " + e.getPrenom());
        System.out.println("Filière: " + e.getFiliere());
        System.out.println("Année: " + e.getAnnee());
        System.out.println("Moyenne: " + e.getNotes());
        
    }
}