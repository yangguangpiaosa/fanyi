package com.taozi.fanyi.utils.html;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.htmlparser.visitors.HtmlPage;

import com.taozi.fanyi.utils.Constants;

public class Test {

	public static String openFile(String szFileName) {
		try {
			BufferedReader bis = new BufferedReader(new InputStreamReader(new FileInputStream(new File(szFileName)), Constants.ENCODE_UTF8));
			String szContent = "";
			String szTemp;

			while ((szTemp = bis.readLine()) != null) {
				szContent += szTemp + "\n";
			}
			bis.close();
			return szContent;
		} catch (Exception e) {
			return "";
		}
	}

	public static void main(String[] args) {
        
	   String htmlcode = Test.openFile("C:\\_code\\gen\\static\\index.html");
	   Parser parser = Parser.createParser(htmlcode, "UTF-8");
	   HtmlPage page = new HtmlPage(parser);
	   try {
		   parser.visitAllNodesWith(page);
	   }
	   catch (ParserException e1) {
		   e1.printStackTrace();
	   }
	   NodeList nodelist = page.getBody();
	   NodeFilter filter = new TagNameFilter("a");
	   nodelist = nodelist.extractAllNodesThatMatch(filter, true);
	   for (int i = 0; i < nodelist.size(); i++){
		   LinkTag link=(LinkTag) nodelist.elementAt(i);
		   System.out.println(link.getAttribute("href")+" -- "+link.getLinkText());
	   }
    }
}
