package tut09.factorymethod;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public abstract class Encryptor {
	public void encryptFile(String filename) {
		EncryptionAlgorithm cipher = getEncryptionAlgorithm();
		
	  // Read contents from file
		String contents = "";
		try {
			contents = new String(Files.readAllBytes(Paths.get(filename)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Encrypt contents
		String cyphertext = cipher.encrypt(contents);
		System.out.println(contents);
		System.out.println(cyphertext);

		// Write encrypted file to disk
		try (FileOutputStream outputStream = new FileOutputStream(filename + ".encrypted")) {
			outputStream.write(cyphertext.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public abstract EncryptionAlgorithm getEncryptionAlgorithm();
}
