package com.taozi.fanyi.support.web.comn.render;

import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map.Entry;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import javax.servlet.ServletContext;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;

import com.jfinal.render.Render;
import com.jfinal.render.RenderException;

public class ClsPathVmRender extends Render {
	
	private static final String contentType = "text/html; charset=" + getEncoding();
	private static final Properties properties = new Properties();
	
	private static boolean notInit = true;
	
	public ClsPathVmRender(String view) {
		this.view = view;
	}
	
	/*
	static {
		String webPath = RenderFactory.getServletContext().getRealPath("/");
		
		Properties properties = new Properties();
		properties.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, webPath);
		properties.setProperty(Velocity.ENCODING_DEFAULT, encoding); 
		properties.setProperty(Velocity.INPUT_ENCODING, encoding); 
		properties.setProperty(Velocity.OUTPUT_ENCODING, encoding); 
		
		Velocity.init(properties);	// Velocity.init("velocity.properties");	// setup
	}*/
	
	static void init(ServletContext servletContext) {
		properties.setProperty("resource.loader", "class"); 
		properties.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		properties.setProperty(Velocity.ENCODING_DEFAULT, getEncoding()); 
		properties.setProperty(Velocity.INPUT_ENCODING, getEncoding()); 
		properties.setProperty(Velocity.OUTPUT_ENCODING, getEncoding());
	}
	
	public static void setProperties(Properties properties) {
		Set<Entry<Object, Object>> set = properties.entrySet();
		for (Iterator<Entry<Object, Object>> it=set.iterator(); it.hasNext();) {
			Entry<Object, Object> e = it.next();
			ClsPathVmRender.properties.put(e.getKey(), e.getValue());
		}
	}
	
	public String getContentType() {
		return contentType;
	}
	
	public void render() {
		 if (notInit) {
			 Velocity.init(properties);	// Velocity.init("velocity.properties");	// setup
			 notInit = false;
		 }
		
		PrintWriter writer = null;
        try {
            /*
             *  Make a context object and populate with the data.  This
             *  is where the Velocity engine gets the data to resolve the
             *  references (ex. $list) in the template
             */
            VelocityContext context = new VelocityContext();
            
    		// Map root = new HashMap();
    		for (Enumeration<String> attrs=request.getAttributeNames(); attrs.hasMoreElements();) {
    			String attrName = attrs.nextElement();
    			context.put(attrName, request.getAttribute(attrName));
    		}
    		
            /*
             *  get the Template object.  This is the parsed version of your
             *  template input file.  Note that getTemplate() can throw
             *   ResourceNotFoundException : if it doesn't find the template
             *   ParseErrorException : if there is something wrong with the VTL
             *   Exception : if something else goes wrong (this is generally
             *        indicative of as serious problem...)
             */
            Template template = Velocity.getTemplate(view);
            
            /*
             *  Now have the template engine process your template using the
             *  data placed into the context.  Think of it as a  'merge'
             *  of the template and the data to produce the output stream.
             */
           response.setContentType(getContentType());
           writer = response.getWriter();	// BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
            
           template.merge(context, writer);
           writer.flush();	// flush and cleanup
        }
        catch(ResourceNotFoundException e) {
        	throw new RenderException("Example : error : cannot find template " + view, e);
        }
        catch( ParseErrorException e) {
            throw new RenderException("Example : Syntax error in template " + view + ":" + e, e);
        }
        catch(Exception e ) {
            throw new RenderException(e);
        }
        finally {
        	if (writer != null)
        		writer.close();
        }
	}
}
