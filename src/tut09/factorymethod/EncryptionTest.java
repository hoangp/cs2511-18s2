package tut09.factorymethod;

public class EncryptionTest {
	public static void main(String[] args) {
		Encryptor encryptor = new Sha256Encryptor();
		encryptor.encryptFile("res/test.txt");
	}
}

