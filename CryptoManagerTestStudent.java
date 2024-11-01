/*
 * Class: CMSC203 
 * Instructor: Professor Thai
 * Description: Project 3
 * Due: 10/31/2024
 * Platform/compiler: Visual Studio Code
 * I pledge that I have completed the programming  assignment independently. 
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Johan Mbouwa Fokoua
*/

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CryptoManagerTestStudent {
    CryptoManager cryptoManager;

    @Before
    public void setUp() throws Exception {
        cryptoManager = new CryptoManager();
    }

    @After
    public void tearDown() throws Exception {
        cryptoManager = null; // Cleanup after each test
    }

    @Test
    public void testStringInBounds() {
        // Testing various strings to check bounds
        assertTrue(CryptoManager.isStringInBounds("TEST"));
        assertFalse(CryptoManager.isStringInBounds("java")); // Assuming this is out of bounds
        assertFalse(CryptoManager.isStringInBounds("{OUT_OF_BOUNDS}"));
        assertTrue(CryptoManager.isStringInBounds("\"WITH QUOTES\""));
    }

    @Test
    public void testEncryptCaesar() {
        // Testing various cases for Caesar encryption
        assertEquals("IFMMP", CryptoManager.caesarEncryption("HELLO", 1));
        assertEquals("KHOOR", CryptoManager.caesarEncryption("HELLO", 3));
        assertEquals("THXIV", CryptoManager.caesarEncryption("STRING", 3));
        assertEquals("DOL", CryptoManager.caesarEncryption("ABC", 3));
    }

    @Test
    public void testDecryptCaesar() {
        // Testing various cases for Caesar decryption
        assertEquals("HELLO", CryptoManager.caesarDecryption("IFMMP", 1));
        assertEquals("HELLO", CryptoManager.caesarDecryption("KHOOR", 3));
        assertEquals("STRING", CryptoManager.caesarDecryption("THXIV", 3));
    }

    @Test
    public void testEncryptBellaso() {
        // Testing various cases for Bellaso encryption
        assertEquals("ENCRYPTED_TEXT", CryptoManager.bellasoEncryption("PLAIN_TEXT", "KEY"));
        assertEquals("TESTING", CryptoManager.bellasoEncryption("HELLO", "KEY"));
        assertEquals("DOL", CryptoManager.bellasoEncryption("ABC", "XYZ"));
    }

    @Test
    public void testDecryptBellaso() {
        // Testing various cases for Bellaso decryption
        assertEquals("PLAIN_TEXT", CryptoManager.bellasoDecryption("ENCRYPTED_TEXT", "KEY"));
        assertEquals("HELLO", CryptoManager.bellasoDecryption("TESTING", "KEY"));
        assertEquals("ABC", CryptoManager.bellasoDecryption("DOL", "XYZ"));
    }
}

