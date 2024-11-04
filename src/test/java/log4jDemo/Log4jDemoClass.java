package log4jDemo;

import org.apache.logging.log4j.*;


public class Log4jDemoClass {

	public static void main(String[] args) {
		
		Logger log = LogManager.getFormatterLogger(Log4jDemoClass.class);
		
		log.info("Browser has been launch");
		log.debug("demo debug code");
		log.trace("demo trace code");
		log.fatal("Demo fatal code");
		log.error("demo Error code");

	}

}
