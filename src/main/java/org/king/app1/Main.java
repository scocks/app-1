package org.king.app1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        Library library = new Library();
        logger.info("Printing results");
        library.print(library.func1());
        library.print(library.func2());
    }
}