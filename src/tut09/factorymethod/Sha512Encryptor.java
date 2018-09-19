package tut09.factorymethod;

public class Sha512Encryptor extends Encryptor {
	@Override
  public EncryptionAlgorithm getEncryptionAlgorithm() {
      return new Sha512EncryptionAlgorithm();
  }
}
