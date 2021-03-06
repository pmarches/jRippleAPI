package jstellarapi;


import java.io.FileReader;

import jstellarapi.connection.StellarDaemonWebsocketConnectionTest;
import jstellarapi.core.DenominatedIssuedCurrencyTest;
import jstellarapi.core.StellarSeedAddress;
import jstellarapi.core.StellarSeedAddressTest;
import jstellarapi.keys.StellarSignerTest;
import jstellarapi.keys.StellarWalletTest;
import jstellarapi.serialization.ReferenceImplementationAmountTests;
import jstellarapi.serialization.StellarBinarySerializerTest;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class TestUtilities {
	static StellarSeedAddress stellarAccount;
	
	public static StellarSeedAddress getTestSeed() throws Exception {
		if(stellarAccount==null){
			JSONObject jsonWallet = (JSONObject) new JSONParser().parse(new FileReader("secrets/jStellarAPI-wallet.json"));
			String seedStr = (String)jsonWallet.get("master_seed");
			stellarAccount = new StellarSeedAddress(seedStr);
		}
		return stellarAccount;
	}
}
