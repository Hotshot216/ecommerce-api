//package client;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.Mockito.verify;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import com.nttdata.simoes.model.Client;
//import com.nttdata.simoes.repository.ClientRepository;
//import com.nttdata.simoes.service.ClientServices;
//
//@ExtendWith(MockitoExtension.class)
//public class ClientServicesTest {
//	
//	@Mock
//	private ClientRepository clientRepository;
//	private AutoCloseable autoCloseable;
//	@InjectMocks
//	private ClientServices underTest;
//	
//	@BeforeEach
//	void setUp() {
//		autoCloseable = MockitoAnnotations.openMocks(this);
//		underTest = new ClientServices(clientRepository);
//		
//	}
//	
//	@AfterEach
//	void tearDown() throws Exception {
//		autoCloseable.close();
//	}
//	
//	@Test
//	void shouldAddClient() {
//		//given
//		Client client = new Client(
//				"Test",
//				"User",
//				"Test Street"
//				);
//		
//		//when
//		underTest.addClient(client);
//		//then
//		verify(clientRepository).save(client);
//	}
//	
//	@Test
//	void shouldGetAll() {
//		//given
//		//when
//		underTest.getAll();
//		//then
//		verify(clientRepository).findAll();
//	}
//	
//	@Test
//	void shouldListById() {
//		//given
//		Client client = new Client(
//				"Test",
//				"User",
//				"Test Street"
//				);
//		underTest.addClient(client);
//		//when
//		underTest.listById(client.getId());
//		//then
//		verify(clientRepository).findById(client.getId());
//	}
//	
//	@Test
//	void shouldUpdateClient(){
//		//given
//		Client client = new Client(
//				"Test",
//				"User",
//				"Test Street"
//				);
//		underTest.addClient(client);
//		//when
//		Client newClient = new Client(
//				"New Test",
//				"New User",
//				"New Test Street"
//				);
//		underTest.updateClient(newClient, client.getId());
//		//then
//		assertThat(clientRepository.findById(client.getId()).equals(newClient));
//	}
//
//}
