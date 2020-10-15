package mvcOHNETemplate;

import java.lang.module.Configuration;
import java.util.Locale;
import java.util.logging.Logger;

// Fragen/Probleme: 
// 1. Konstruktor sollte private sein, auf protcted gestellt momentan
// 		damit in der init() Methode in der Main Klasse keine Fehlermeldung ist
// 2. Translator -> schlägt momentan noch ungewünschten Import vor
// 3. Die globale Konstante aus dem JAT habe ich vorerst noch entfernt
// 		final private Class<?> APP_CLASS = JavaFX_App_Template.class;


/**
* Copyright 2015, FHNW, Prof. Dr. Brad Richards. All rights reserved. This code
* is licensed under the terms of the BSD 3-clause license (see the file
* license.txt).
* 
* The singleton instance of this class provide central storage for resources
* used by the program. It also defines application-global constants, such as
* the application name.
* 
* @author Brad Richards
*/

public class ServiceLocator {
	
	// Der ServiceLocator als singleton -> Behälter
	// um die globalen Resourcen zu verwalten
   private static ServiceLocator serviceLocator; // singleton


   // Konstante für den Namen der Applikation
   final private String APP_NAME = "Geography Miniproject";
   
   // Unterstütze Sprachen (Supported locales (for translations))
   final private Locale[] locales = new Locale[] { new Locale("en"), new Locale("de") };

   // Resources
   private Logger logger;
   private Configuration configuration;
// private Translator translator;

   /**
    * Factory method for returning the singleton
    * @param mainClass The main class of this program
    * @return The singleton resource locator
    */
   public static ServiceLocator getServiceLocator() {
       if (serviceLocator == null)
           serviceLocator = new ServiceLocator();
       return serviceLocator;
   }

   /**
    * Private constructor, because this class is a singleton
    * @param appName Name of the main class of this program
    */
   protected ServiceLocator() {
       // Currently nothing to do here. We must define this constructor anyway,
       // because the default constructor is public
   }

   
   public String getAPP_NAME() {
       return APP_NAME;
   }

   public Logger getLogger() {
       return logger;
   }

   public void setLogger(Logger logger) {
       this.logger = logger;
   }

   public Configuration getConfiguration() {
       return configuration;
   }

   public void setConfiguration(Configuration configuration) {
       this.configuration = configuration;
   }

   public Locale[] getLocales() {
       return locales;
   }

//   public Translator getTranslator() {
//       return translator;
//   }
//   
//   public void setTranslator(Translator translator) {
//       this.translator = translator;
//   }
}
