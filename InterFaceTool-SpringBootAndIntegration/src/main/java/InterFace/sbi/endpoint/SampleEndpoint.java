/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package InterFace.sbi.endpoint;

import java.io.File;
import java.io.FileInputStream;
import java.util.Random;

import org.apache.commons.lang3.RandomUtils;
import org.elasticsearch.common.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.util.StreamUtils;

import InterFace.sbi.service.ExcelDao;
import InterFace.sbi.service.HelloWorldService;

@MessageEndpoint
public class SampleEndpoint {

	@Autowired
	private HelloWorldService helloWorldService;
	
	@Autowired
	private Recieved recieved;

	@ServiceActivator
	public String hello(File input) throws Exception {
		try (FileInputStream in = new FileInputStream(input)){
			String name = new String(StreamUtils.copyToByteArray(in));
			recieved.execute(
					RandomUtils.nextInt(1, 100), 
					org.apache.commons.lang3.StringUtils.right(name, 10));
		return this.helloWorldService.getHelloMessage(name);
		}
	}

}
