package io.github.anantharajuc.aes;

import io.github.anantharajuc.aes.constants.ApplicationConstants;
import io.github.anantharajuc.aes.domain.model.User;
import io.github.anantharajuc.aes.domain.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Arrays;
import java.util.Base64;

/*
 * aes-128-ecb
 */
@Log4j2
@SpringBootApplication
public class AesMysqlJavaApplication implements CommandLineRunner {

	private String key = "dsfdfdsfsdfdfsfs";

	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(AesMysqlJavaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = userRepository.getReferenceById(1L);
		log.info("User first name encrypted: " + user.getFirstName());

		byte[] cipherBytes = user.getFirstName().getBytes();

		log.info("User First Name Cipher bytes: " + cipherBytes);
		log.info("User First Name Cipher bytes Array: " + Arrays.toString(cipherBytes));

		// return an ISO-8859-1 encoded String
		String cipherString = Base64.getEncoder().encodeToString(cipherBytes);

		log.info("cipherBytes - encodeToString via Base64 encoder: "+cipherString);

		Key key1 = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), ApplicationConstants.AES);
		try {
			Cipher cipher = Cipher.getInstance(ApplicationConstants.AES_ECB_PKCS_5_PADDING);
			cipher.init(Cipher.DECRYPT_MODE, key1);
			String decrypted = new String(cipher.doFinal(Base64.getDecoder().decode(user.getFirstName())));
			log.info("User first name decrypted: " + decrypted);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
}
