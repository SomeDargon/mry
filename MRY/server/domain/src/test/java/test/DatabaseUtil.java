package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DatabaseUtil {	
	//Production MySql
//	private static final String HOST = "www.uyidoctor.com";
//	private static final String USERNAME = "youyi";
//	private static final String PASSWORD = "remedyq_password";
	
	//##########################3
	
//	private static final String HOST = "120.26.117.129";
//	private static final String USERNAME = "root";
//	private static final String PASSWORD = "root";
	
	//Local MySql
	private static final String HOST = "localhost";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	
	
//	private static final String HOST = "116.62.201.135";
//	private static final String USERNAME = "youyi";
//	private static final String PASSWORD = "youyi";


	private static final String DB_NAME = "youyi";

	private static final String CONN_URL = "jdbc:mysql://" + HOST + ":3306/"
			+ DB_NAME + "?user=" + USERNAME + "&password=" + PASSWORD
			+ "&useUnicode=true&characterEncoding=UTF-8";

	static String scriptDir = ".." + File.separator + "database"
			+ File.separator + "scripts" + File.separator + "init"
			+ File.separator;
	static String initScriptsFile = scriptDir + "init.sql";
	static String testScriptsFile = scriptDir + "test_data.sql";

	public static void main(String[] args) throws Exception {
		configLogback();

		createDatabase();
		createTables();
		importData();

		//Test.main(null);
	}

	private static void importData() {
		try {
			log("Start to import init and test data to " + DB_NAME
					+ " database.");
			Connection connection = DriverManager.getConnection(CONN_URL);

			Statement st = connection.createStatement();
			List<String> lines = parseScriptToLines(loadFile(initScriptsFile));
			for (String line : lines) {
				log(line);
				st.execute(line);
			}

			// lines = parseScriptToLines(loadFile(testScriptsFile));
			// for (String line : lines) {
			// log(line);
			// st.execute(line);
			// }
			st.close();
			log("\n\nFinish importing init and test data to " + DB_NAME);
		} catch (Exception e) {
			log("Import " + DB_NAME + " database Exception, reason: "
					+ e.getMessage());
		}

	}

	public static boolean createDatabase() {
		try {
			log("#####: " + CONN_URL);
			
			String CONN_URL = "jdbc:mysql://" + HOST + ":3306/"
					+ "test" + "?user=" + USERNAME + "&password=" + PASSWORD
					+ "&useUnicode=true&characterEncoding=UTF-8";
			Connection connection = DriverManager
					.getConnection(CONN_URL);
			Statement stmt = connection.createStatement();
			log("droping old " + DB_NAME + " database...");
			stmt.executeUpdate("DROP DATABASE IF EXISTS " + DB_NAME);
			log("Drop old " + DB_NAME + " database successfully.");

			log("Create new " + DB_NAME + " database...");
			// CREATE DATABASE remedyq DEFAULT CHARACTER SET gbk COLLATE
			// gbk_chinese_ci;
			stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS " + DB_NAME
					+ " DEFAULT CHARACTER SET gbk COLLATE gbk_chinese_ci");
			log("Create new " + DB_NAME + " successfully.");

			stmt.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			log("Create " + DB_NAME + " database Exception, reason: "
					+ e.getMessage());
			return false;
		}
	}

	public static void createTables() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("persistence.mry");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		em.getTransaction().commit();
		em.close();
		factory.close();
	}

	private static void configLogback() {
		configLogback("org.hibernate", ch.qos.logback.classic.Level.WARN);
		configLogback("java.sql", ch.qos.logback.classic.Level.WARN);

		configLogback("net.sf.ehcache", ch.qos.logback.classic.Level.WARN);
		configLogback("n.s.e.config", ch.qos.logback.classic.Level.WARN);
	}

	private static void configLogback(String packageName,
			ch.qos.logback.classic.Level level) {
		org.slf4j.Logger logger = org.slf4j.LoggerFactory
				.getLogger(packageName);
		if (!(logger instanceof ch.qos.logback.classic.Logger)) {
			return;
		}
		ch.qos.logback.classic.Logger logbackLogger = (ch.qos.logback.classic.Logger) logger;
		logbackLogger.setLevel(level);
	}

	private static String loadFile(String filepath) {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					new FileInputStream(filepath), "UTF-8"));
			StringBuilder builder = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				builder.append(line).append("\n");
			}
			reader.close();
			return builder.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static List<String> parseScriptToLines(String scripts) {
		List<String> list = new ArrayList<String>();
		String[] arr = scripts.split(";");
		for (String s : arr) {
			if (s.trim().length() == 0) {
				continue;
			}
			list.add(s + ";");
		}
		return list;
	}

	private static void log(Object obj) {
		System.out.println(obj);
	}
}
