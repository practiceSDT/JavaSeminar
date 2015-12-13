/*
 * Copyright 2012-2014 the original author or authors.
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

package study.spring;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;

import lombok.Setter;

@ConfigurationProperties(prefix = "service", ignoreUnknownFields = false)
@ManagedResource
@Setter
public class ServiceProperties {

	private String answer = "Hello";

	@ManagedAttribute
	public String getAnswer() {
		return this.answer;
	}

	private String sep = ",";

	@ManagedAttribute
	public String getSep() {
		return this.sep;
	}


}
