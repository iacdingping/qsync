package com.openteach.qsync.api;

import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.openteach.qsync.api.exception.ApiException;
import com.openteach.qsync.api.record.request.ImportCompany;
import com.openteach.qsync.api.record.request.XmlRecordRequest;
import com.openteach.qsync.api.record.request.XmlRecordRequestBody;
import com.openteach.qsync.api.record.response.XmlRecordResponse;
import com.openteach.qsync.api.utils.JaxbUtils;

public class JkfClientOverFtpTest {

	private JkfClientOverFtp jkfClient;
	
	@Before
	public void initialize() {
		jkfClient = new JkfClientOverFtp();
		jkfClient.setPusherCount(JkfClientOverFtp.DEFAULT_COUNT);
		jkfClient.setPullerCount(JkfClientOverFtp.DEFAULT_COUNT);
		jkfClient.setBufferSize(JkfClientOverFtp.DEFAULT_BUFFER_SIZE);
		jkfClient.setPusherFtpServer("60.191.76.84");
		jkfClient.setPusherFtpPort(21);
		jkfClient.setPusherFtpUsername("newyork_pub");
		jkfClient.setPusherFtpPassword("newyork_pub");
		jkfClient.setPullerFtpServer("60.191.76.84");
		jkfClient.setPullerFtpPort(21);
		jkfClient.setPullerFtpUsername("newyork_pub");
		jkfClient.setPullerFtpPassword("newyork_pub");
		jkfClient.initialize();
	}
	
	@After
	public void release() {
		jkfClient.release();
	}
	
	@Test
	public void testSyncRequest() throws ApiException {
		JkfSign jkfSign = new JkfSign();
		ImportCompany im = new ImportCompany();
		XmlRecordRequestBody body = new XmlRecordRequestBody();
		body.setJkfSign(jkfSign);
		body.setImportCompanyList(Arrays.asList(im));
		XmlRecordRequest request = new XmlRecordRequest();
		request.setBody(body);
		XmlResponse response = jkfClient.sync(request, XmlRecordResponse.class);
		System.out.println(JaxbUtils.convertToXml(response));
	}

	@Test
	public void testAsyncRequest() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testDump() throws IOException {
		StringBuilder sb = new StringBuilder();
		String line = null;
		String[] fileds = null;
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader("/home/sihai/mtop-dump.log"));
			while(null != (line = reader.readLine())) {
				sb.append(line);
				fileds = line.split("\\,\\^");
				
				System.out.println("-------------------------------------------------------------");
				for(String f : fileds) {
					System.out.println(f);
				}
			}
		} finally {
			if(null != reader) {
				reader.close();
			}
		}
	}
}
