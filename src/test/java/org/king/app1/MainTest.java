package org.king.app1;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {    
    @Test
    void testFun1() {
        Library library = new Library();
        ArrayList<String> result = library.func1();
        assertEquals(3, result.size());
        assertEquals("greet from plataforma, app1", result.get(0));
        assertEquals("greet from plataforma-consumer-1 app1", result.get(1));
        assertEquals("greet from libdep1, app1", result.get(2));
    }    
    @Test
    void testFun2() {
        Library library = new Library();
        ArrayList<String> result = library.func2();
        assertEquals(5, result.size());
        assertEquals("greet from plataforma, app1", result.get(0));
        assertEquals("greet1 from plataforma greet from libdep1, app1", result.get(1));
        assertEquals("greet2 from plataforma greet from libdep2, app1", result.get(2));
        assertEquals("greet from plataforma-consumer-1 app1", result.get(3));
        assertEquals("greet from libdep1, app1", result.get(4));
    }    
    @Test
    void testFun3() throws Exception {
        Library library = new Library();
        File file = getFileFromResources("people.json");
        ArrayList<String> result = library.func3(file.getAbsolutePath());
        assertEquals(12, result.size());
        assertEquals("greet from plataforma, John Doe", result.get(0));
        assertEquals("greet1 from plataforma greet from libdep1, 123 Elm Street", result.get(1));
        assertEquals("greet2 from plataforma greet from libdep2, 30", result.get(2));
        assertEquals("greet3 from plataforma greet from libdep3, Caucasian", result.get(3));
        assertEquals("greet4 from plataforma greet from libdep4, Male", result.get(4));
        assertEquals("greet5 from plataforma greet from libdep5, Software Engineer", result.get(5));
        assertEquals("greet from plataforma, Jane Smith", result.get(6));
        assertEquals("greet1 from plataforma greet from libdep1, 456 Pine Street", result.get(7));
        assertEquals("greet2 from plataforma greet from libdep2, 32", result.get(8));
        assertEquals("greet3 from plataforma greet from libdep3, Asian", result.get(9));
        assertEquals("greet4 from plataforma greet from libdep4, Female", result.get(10));
        assertEquals("greet5 from plataforma greet from libdep5, Project Manager", result.get(11));
    }    

    private File getFileFromResources(String fileName) throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        URI uri = classLoader.getResource(fileName).toURI();
        return new File(uri);
    }
}
