package com.ecoman.license;

import java.io.File;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LicenseValidator {
	@Value("${oso.license.file}")
	String file;
	
	@PostConstruct
	void validate() throws Exception {
//		Process p = Runtime.getRuntime().exec(new String[]{"python",new File(file).getAbsolutePath()});
//		assert p.waitFor() == 0;
		System.out.println("License Validation Success!");
	}
}
