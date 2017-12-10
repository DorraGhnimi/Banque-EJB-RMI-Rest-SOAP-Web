package services;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;


@ApplicationPath("/myApp")
public class WebApp extends Application{
	
	
	
	
	
	/*
	 * pour deployer un web service Restful :   
	 * deployer Jersey : il faut la  declarer dans web.xml  du dynamique web project, 
	 * cad il faut depoyer une sevlet qui permet de representer le conteneur de JAX-RS
	 * 
	 * 
	 * mais ici , on a pas besoin, parce qu'on utilise un serveur d'app, 
	 * JBOSS utilise une impleentation JAX-RS predefinie 'Res tEasy', 
	 * et donc on doit tt splm creer un "context d'application " <=> classe extends "Application" de "javax.ws.rs.core"
	 * 
	 * 
	 * 
	 */
	 
	
	
	
	

}
