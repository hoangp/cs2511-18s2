package tut09.factorymethod.strategy;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class EncryptionTest {
	public static void main(String[] args) {
		// Choose a strategy
		EncryptionAlgorithm cipher = new Sha256CEncryptionAlgorithm();

		// Read contents from file
		String contents = "";
		try {
			contents = new String(Files.readAllBytes(Paths.get("res/test.txt")));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Encrypt contents
		String cyphertext = cipher.encrypt(contents);
		System.out.println(contents);
		System.out.println(cyphertext);

		// Write encrypted file to disk
		try (FileOutputStream outputStream = new FileOutputStream("res/test.txt.encrypted")) {
			outputStream.write(cyphertext.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
