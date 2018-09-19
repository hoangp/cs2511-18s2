package tut09.factorymethod.stategy;

import org.apache.commons.codec.digest.DigestUtils;

public class Sha256CEncryptionAlgorithm implements EncryptionAlgorithm{
	@Override
	public String encrypt(String plaintext) {
		return DigestUtils.sha256Hex(plaintext);
	}
}
