package de.guskoeln;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;

@MicronautTest
public class FormatFuncControllerTest {

	@Inject
	@Client("/")
	RxHttpClient client;

	@Test
	public void testFormatFuncFirstSeq() {
		HttpRequest<String> request = HttpRequest.GET("/formatfunc/ord01010_ech");
		String body = client.toBlocking().retrieve(request);
		
		assertNotNull(body);
		assertEquals("1", body);
	}
	
	@Test
	public void testFormatFuncFourthSeq() {
		HttpRequest<String> request = HttpRequest.GET("/formatfunc/ord01010_ech");
		String body = null;
		for(int i = 0; i < 3; i++) {
			body = client.toBlocking().retrieve(request);			
		}
		assertNotNull(body);
		assertEquals("4", body);
	}
	
	@Test
	public void testMiscFormats() {
		Map<String, Integer> formatFuncMap = new HashMap<>();
		formatFuncMap.put("ord001_ech", 1000);
		formatFuncMap.put("ord002_ech", 1001);
		HttpRequest<String> request = null;
		String body = null;
		
		for(String format : formatFuncMap.keySet()) {
			request = HttpRequest.GET("/formatfunc/" + format);
			for(int i = 0; i < formatFuncMap.get(format); i++) {
				client.toBlocking().retrieve(request);
			}
			
			body = client.toBlocking().retrieve(request);
			assertNotNull(body);
			assertEquals(String.valueOf(formatFuncMap.get(format) + 1), body);
		}
	}
}
