package Cms;

import java.util.logging.Logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.divergentsl.clinicmanagementsystem.ClinicManagementSystem;

public class Cms {
	static final Logger myLogger = Logger.getLogger("Clinic-Management-Systemm/src/main/java/Cms/Cms");

	public static void main(String[] args) {
		myLogger.info("---*---Login Panel---*--------- ");
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("Confi.xml");
		ClinicManagementSystem system = (ClinicManagementSystem)context.getBean("loginpanel");
		system.show();
	}

}
