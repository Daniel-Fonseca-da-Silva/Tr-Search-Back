package com.trsearch.trsearch;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.trsearch.trsearch.model.UserCorp;
import com.trsearch.trsearch.service.UserCorpRepository;
import com.trsearch.trsearch.service.UserCorpService;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TrSearchApplicationTests {
	
	@MockBean
    public UserCorpRepository repository;
	
	@Autowired
    public UserCorpService service;
	
	@Test
	public void TestCreateUserCorp() {
		
		UserCorp userCorp = new UserCorp();
		
		userCorp.setId(1L);
		userCorp.setNameCorp("Levi e Benício Marcenaria ME");
		userCorp.setCnpjCorp("39.219.520/0001-25");
		userCorp.setLoginCorp("admin");
		userCorp.setEmailCorp("cceciliamayapeixoto@amure.com.br");
		userCorp.setPasswordCorp("nTxrKgY$L@");
		
		UserCorp userCorpp = service.createUserCorp(userCorp);
		assertNotNull(userCorpp);
		assertEquals(userCorpp, userCorp);
		assertNotNull(userCorpp.getId());
		assertEquals("Levi e Benício Marcenaria ME", userCorpp.getNameCorp());
		assertEquals("39.219.520/0001-25", userCorpp.getCnpjCorp());
		assertEquals("admin", userCorpp.getLoginCorp());
		assertEquals("cceciliamayapeixoto@amure.com.br", userCorpp.getEmailCorp());
		assertEquals("nTxrKgY$L@", userCorpp.getPasswordCorp());
		assertFalse(service.deleteUserCorp(userCorpp.getId()));
		service.deleteUserCorp(userCorpp.getId());
		assertFalse(service.getUserCorpById(userCorpp.getId()).isPresent());
	}
	
	@Test
	public void TestGetIdUserCorpp() {
		UserCorp userCorp = new UserCorp();
		userCorp.setId(1L);
		userCorp.setNameCorp("Levi e Benício Marcenaria ME");
		userCorp.setCnpjCorp("39.219.520/0001-25");
		userCorp.setLoginCorp("admin");
		userCorp.setEmailCorp("cceciliamayapeixoto@amure.com.br");
		userCorp.setPasswordCorp("nTxrKgY$L@");
		
		UserCorp userCorpp = service.createUserCorp(userCorp);
		assertNotNull(service.getUserCorpById(userCorpp.getId()));
		service.deleteUserCorp(userCorpp.getId());
	}

}

