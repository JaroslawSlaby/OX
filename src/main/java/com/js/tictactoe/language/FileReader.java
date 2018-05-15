package com.js.tictactoe.language;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Objects;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileReader {

  private final Properties langProperties  = new Properties();
  private final String fileName;
  private InputStream input;

  private final Logger logger = Logger.getLogger(getClass().getName());

  public FileReader(String fileName) {
    this.fileName = fileName;
  }

  public String loadString(String string) {
    try {
      setUpReaders();
      langProperties.load(new InputStreamReader(input, Charset.forName("UTF-8")));
    } catch (NullPointerException | IOException e) {
      logger.log(Level.WARNING, e.getCause() + e.getLocalizedMessage());
    }

    return langProperties.getProperty(string);
  }
  private void setUpReaders() {
    String path = Objects.requireNonNull(this.getClass().getClassLoader().getResource(fileName + ".lang")).getFile();
    try {
      input = new FileInputStream(new File(path));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
}