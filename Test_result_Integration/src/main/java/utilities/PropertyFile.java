package utilities;
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.util.Properties;



	public class PropertyFile   {
		public static Properties prop = new Properties();

		public static void initialize1() throws IOException {
			// File file = new File (".//ObjectRepo//webconfig.properties");
			File file = new File(System.getProperty("user.dir") + "//ObjectRepo//webconfig.properties");
			FileInputStream fileInput = null;
			try {
				fileInput = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

			prop.load(fileInput);
			
		}


	}




