package de.jibu.jibukitpvp.Utilities;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Source;

import java.io.File;
import java.io.IOException;

public class JavaScriptExecuterClass {

    public void executeJavaScriptFile(String filePath) {
        try (Context context = Context.create()) {
            Source source = Source.newBuilder("js", new File(filePath)).build();
            context.eval(source);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
