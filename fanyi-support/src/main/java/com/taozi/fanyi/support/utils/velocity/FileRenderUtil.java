package com.taozi.fanyi.support.utils.velocity;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

public class FileRenderUtil {
	
	public static void renderFile(String view, String file, Map<String, Object> params) {
		Properties p = new Properties();
		p.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, "");
		p.setProperty(Velocity.ENCODING_DEFAULT, "UTF-8");
		p.setProperty(Velocity.INPUT_ENCODING, "UTF-8");
		p.setProperty(Velocity.OUTPUT_ENCODING, "UTF-8");
		try {
		    Velocity.init(p);
		    Template template = Velocity.getTemplate(view, "UTF-8");
		    VelocityContext context = new VelocityContext();
		    for(String key : params.keySet()) {
		    	context.put(key, params.get(key));
		    }
		    FileOutputStream fos = new FileOutputStream(file);
		    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos, "UTF-8"));
		    template.merge(context, writer);
		    writer.close();
		} catch (Exception e) {
		    e.printStackTrace();
		}
	}
	
}
