package web;

import javax.ejb.Stateless;
import java.io.File;

@Stateless
public class FileReaderEjb {


    StringBuffer result = new StringBuffer();

    public String getResult() {
        return String.valueOf(result);
    }

    public void readFiles(File baseDirectory){
        if (baseDirectory.isDirectory()) {
            result.append("<ul>");
            for (File file : baseDirectory.listFiles()) {
                if (file.isFile()) {
                    result.append("<li>" + file.getName() + "</li>");
                } else {
                    result.append("<li>" + file.getName() + "</li>");
                    readFiles(file);
                }
            }
            result.append("</ul>");
        }
    }
}
