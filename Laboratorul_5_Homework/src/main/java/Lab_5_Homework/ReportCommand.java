package Lab_5_Homework;

import com.fasterxml.jackson.core.Version;
import freemarker.template.Template;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;


public class ReportCommand {

    public void ReportCom(Catalog catalog) throws FileNotFoundException{
        Configuration cfg = new Configuration();

        Template template = null;
        try {
            template = cfg.getTemplate("src/main/resources/HTMLreport/report.html");
            Writer file = new FileWriter(new File("reportHTML.html"));
            template.process(catalog, file);
            file.flush();
            file.close();
            File path = new File("reportHTML.html");
            Desktop desktop = Desktop.getDesktop();
            desktop.open(path);
        } catch (IOException e) {    //in caz ca e o prob cu pathu /file/report.html
            e.printStackTrace();
            throw new FileNotFoundException(e);
        } catch (TemplateException e) {
            e.printStackTrace(); //template.process e problema
        }

    }

}
