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

/**
 * This is a utility class that encrypts and decrypts a phrase using two
 * different approaches. The first approach is called the Caesar Cipher and is a
 * simple �substitution cipher� where characters in a message are replaced by a
 * substitute character. The second approach, due to Giovan Battista Bellaso,
 * uses a key word, where each character in the word specifies the offset for
 * the corresponding character in the message, with the key word wrapping around
 * as needed.
 * 
 * @author Farnaz Eivazi
 * @version 7/16/2022
 */
public class CryptoManager {
	
	private static final char LOWER_RANGE = ' ';
	private static final char UPPER_RANGE = '_';
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_RANGE and UPPER_RANGE characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean isStringInBounds (String plainText) {
		if (plainText == null || plainText.isEmpty()) {
            return false;
		}
		for ( char c: plainText.toCharArray() ) {
			if ( c < LOWER_RANGE || c > UPPER_RANGE ) {
				return false; // Character is out of bounds.
			}
		}
		return true; // All characters are within bounds.
        }
		

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String caesarEncryption(String plainText, int key) {

		// Validate that all characters are uppercase A-Z
		for ( char c: plainText.toCharArray() ) {
			if ( c < LOWER_RANGE || c > UPPER_RANGE ) {
				return "The selected strings is not in bound. Try again.";
			}
		}

		StringBuilder encryptedText = new StringBuilder();

		// Encrypt each character
		for ( char c: plainText.toCharArray() ) {
			// Shift character and wrap around using modulo operation
			if ( c >= 'A' && c <= 'Z' ) {
			char encryptedChar = (char) (((c - 'A' + key) % 26) + 'A');
			encryptedText.append(encryptedChar);
			}  else {
				encryptedText.append(c);
			}
		}

		return encryptedText.toString();

	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String bellasoEncryption (String plainText, String bellasoStr) {

		// Check for null or empty input
		if ( bellasoStr == null || bellasoStr.isEmpty() ) {
			return "The selected string is not in bounds, Try again.";
		}

		StringBuilder encryptedText = new StringBuilder();
		int bellasoLength = bellasoStr.length();

		// Encrypt each character
		for ( int i = 0; i < plainText.length; i++ ) {
			char pChar = plainText.charAt(i); // pChar stands for plainText character.
			char bChar = bellasoStr.charAt( i % bellasoLength ); // Repeat bellasoStr, bChar stands for bellasoStr Character

			// Calculate new character by offsetting
			char encryptedChar = (char) (((pChar + bChar - 2 * LOWER_RANGE) % RANGE) + LOWER_RANGE);
			encryptedText.append(encryptedChar);
		}

		return encryptedText.toString();
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String caesarDecryption (String encryptedText, int key) {

		StringBuilder decryptedText = new StringBuilder();

		// Decrypt each character.
		for ( char c: encryptedText.toCharArray() ) {
			if ( c >= 'A' && c <= 'Z') {
			char decryptedChar = (char) (((c - 'A' - key + 26) %26) + 'A');
			decryptedText.append(decryptedChar);
			} else if (c == ' ') {
				// Preserve spaces
				decryptedText.append(' ');
			} else {
				// Handle other characters if needed
				decryptedText.append(c);
			}	
		} 
		return decryptedText.toString();
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String bellasoDecryption(String encryptedText, String bellasoStr) {
		// Check for null or empty input
		if ( bellasoStr == null || bellasoStr.isEmpty() ) {
			return "The selected string is not in bounds, Try again.";
		}

		StringBuilder decryptedText = new StringBuilder();
		int bellasoLength = bellasoStr.length();

		// Decrypt each character
		for ( int i = 0; i < encryptedText.length; i++ ) {
			char eChar = encryptedText.charAt(i); // eChar stands for encryptedText character.
			char bChar = bellasoStr.charAt( i % bellasoLength ); // Repeat bellasoStr, bChar stands for bellasoStr Character

			// Calculate new character by offsetting
			char decryptedChar = (char) (((eChar - bChar + RANGE) % RANGE) + LOWER_RANGE);
			decryptedText.append(decryptedChar);
		}

		return decryptedText.toString();
	}
}
