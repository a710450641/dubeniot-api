/**
 * 
 */
package com.dubeniot.swagger;

import javax.servlet.ServletContext;

import springfox.documentation.spring.web.paths.RelativePathProvider;






/**
 * @author BUB-4
 *
 */
public class SiteWherePathProvider extends RelativePathProvider{

	
	public SiteWherePathProvider(ServletContext servletContext) {
		super(servletContext);
		
	}
	
	  @Override
	  protected String applicationPath() {
		  return super.applicationPath() + "api";
		  
	  }
}
