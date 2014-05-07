package com.jw.bs;

import com.jw.common.FUtil;
import com.jw.common.IO;
import com.jw.common.SUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: jeff.wu
 * Date: 5/6/14
 * Time: 9:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class Parser {
    private static final Logger LOGGER = LoggerFactory.getLogger(Parser.class);

    public final static String BS_CSS_FILE = "/Users/jeff.wu/projects/z1/z2/z3/z4/bsparser/data/bootstrap.css";
    public final static String BS_CSS_CLASS_FILE_PATH = "/Users/jeff.wu/projects/z1/z2/z3/z4/bsparser/out/";

    public static void main(String[]arg){
        parse(BS_CSS_FILE);

    }

    public static void parse(String bsCssFile){
        byte[] buf = FUtil.readFileInBytes(BS_CSS_FILE);
        String css = new String(buf);
        css = SUtil.removeComment(css);

        parse1(css);
//        IO.println(css);

    }

    public static void  parse1(String css)
    {

        String re1="((?:[a-z][a-z]+))";	// Word 1
        String re2="(\\s+)";	// White Space 1
        String re3="(\\{.*?\\})";	// Curly Braces 1

        Pattern p = Pattern.compile(re1+re2+re3,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher m = p.matcher(css);

        while (m.find())
        {
            String word1=m.group(1);
            String ws1=m.group(2);
            String cbraces1=m.group(3);
            System.out.print(word1.toString()+" "+ws1.toString()+" "+cbraces1.toString()+" "+"\n");
        }

        String ex = re1 + re2 + re3;
        IO.println(ex);
    }

}
