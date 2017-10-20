
import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;
import org.easymock.EasyMock;

public class MufasaTest {
	MufasaAccountCreation john;
	MufasaAddress userAddress;
	MufasaBankACC userBank;
	MufasaTransaction transaction;
	Transaction info;
	
	@Before
	public void setup(){
		john = EasyMock.createMock(MufasaAccountCreation.class);
		info.setAccount(john);
		
		userAddress = EasyMock.createMock(MufasaAddress.class);
		info.setAddress(userAddress);
		
		userBank = EasyMock.createMock(MufasaBankACC.class);
		info.setBank(userBank);
		
		transaction = EasyMock.createMock(MufasaTransaction.class);
		info.setTransaction(transaction);
	}

	@Test
	public void test() throws UserException, ParseException, AddressException, BankAccountException {
		//User
		User newUser = new User();
		
		newUser.setFirstName("isyana");
		newUser.setLastName("sarasvati");
		newUser.setPassword("123asdf!@#", "123asdf!@#");
		newUser.setUsername("isyana21");
		newUser.setPhoneNumber("082162628276");
		newUser.setBirthdate("01/01/1990");
		newUser.setCountry("Russia");
		newUser.setEmail("haha@haha.com", "haha@haha.com");
		
		EasyMock.expect(john.getAccInfo()).andReturn(newUser);
		EasyMock.replay(john);
		
		//Address
		Address newAddress = new Address();
		
		newAddress.setStreetAddress("tellervontie 2");
		newAddress.setCity("Oulu");
		newAddress.setPostalCode("90570");
		newAddress.setCountry("Russia");
		
		EasyMock.expect(userAddress.getAddressInfo()).andReturn(newAddress);
		EasyMock.replay(userAddress);
		
		//Bank Account
		BankAccount newBank = new BankAccount();
		
		newBank.setUserAddress(newAddress);
		newBank.setBankAccountPassword("123asdf!@#", "123asdf!@#");
		newBank.setCardHolderName("isyana sarasvati");
		newBank.setCardNumber("1000000200030004");
		newBank.setExpiryDate("09/21");
		
		EasyMock.expect(userBank.getBankInfo(newUser)).andReturn(newBank);
		EasyMock.replay(userBank);
		
		EasyMock.expect(transaction.getTransactionResult()).andReturn(334);
		
		String result = info.getTransactionResult();
		
		
		assertEquals("Transaction Passed", result);
	}

}
