package ch.zhaw.init.its.labs.publickey;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;

public class PublicKeyLab {
	private static final String messageFilename = "message-with-signature.bin";
	private static final String keypairFilename = "keypair.rsa";

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, BadMessageException {
		PublicKeyLab lab = new PublicKeyLab();
		
		lab.exercise1();
		//lab.exercise9GenerateSignature(args);
		//lab.exercise9VerifySignature(args);
	}

	private void exercise9GenerateSignature(String[] args) throws BadMessageException, FileNotFoundException, IOException {
		final String messageString = args[0]; 
		final BigInteger message = BigIntegerEncoder.encode(messageString);

		banner("Exercise 11 (signature generation)");
		
		generateKeypairIfNotExists();
		
		// --------> Your solution here! <--------
	}

	private void generateKeypairIfNotExists() throws FileNotFoundException, IOException {
		// Generate keypair if none exists
		File f = new File(keypairFilename);
		if (!f.canRead()) {
			try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(f))) {
				RSA rsa = new RSA();
				rsa.save(os);
			}
		}
	}

	private void exercise9VerifySignature(String[] args) throws BadMessageException {
		boolean ok = false;

		banner("Exercise 11 (signature verification)");
		
		try (ObjectInputStream key = new ObjectInputStream(new FileInputStream(keypairFilename))) {
			final RSA keypair = new RSA(key);
			
			// --------> Your solution here! <--------
		} catch (FileNotFoundException e) {
			System.err.println("Can't find keypair file \"" + keypairFilename + "\"");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 	
		
		if (ok) {
			System.out.println("Signature verified successfully");
		} else {
			System.out.println("Signature did not verify successfully");			
		}
	}
	
	private void exercise1() {
		final int workFactorsBits[] = { 128, 256, 384, 512 };
		
		banner("Exercise 1");
		for (int wfBits : workFactorsBits) {
			int keyLength = findRSAKeyLengthForWorkFactorInBits(wfBits);
			System.out.format("%4d bits work factor: %6d bits RSA exponent\n", wfBits, keyLength);
		}

	}

	private void banner(String string) {
		System.out.println();
		System.out.println(string);
		for (int i = 0; i < string.length(); i++) {
			System.out.print('=');
		}
		System.out.println();
		System.out.println();
	}

	private int findRSAKeyLengthForWorkFactorInBits(int wfBits) {
		final double ln2 = Math.log(2.0);
		
		int b = 1;
		
		// --------> Your solution here! <--------
		
		return b;
	}

	private double logW(int b) {
		return 1.92 * Math.pow(b, 1.0/3.0) * Math.pow(Math.log(b), 2.0/3.0);
	}
}
