package com.mry.entity.helper;

import org.hibernate.jpa.AvailableSettings;

import javax.persistence.Persistence;
import java.io.*;
import java.util.Properties;

public class JpaSchemaExport {

	public static void main(String[] args) throws IOException {
		execute(args[0], args[1]);
		addSemicolon(args[1]);
		System.exit(0);
	}

	public static void execute(String persistenceUnitName, String destination) {
		System.out.println("Generating DDL create script to : " + destination);

		final Properties persistenceProperties = new Properties();

		persistenceProperties.setProperty(
				org.hibernate.cfg.AvailableSettings.HBM2DDL_AUTO, "");
		persistenceProperties.setProperty(
				AvailableSettings.SCHEMA_GEN_DATABASE_ACTION, "none");

		// persistenceProperties.setProperty(AvailableSettings.SCHEMA_GEN_CREATE_SCHEMAS,
		// "true");
		persistenceProperties.setProperty(
				AvailableSettings.SCHEMA_GEN_SCRIPTS_ACTION, "create");
		persistenceProperties.setProperty(
				AvailableSettings.SCHEMA_GEN_CREATE_SOURCE, "metadata");
		persistenceProperties
				.setProperty(
						AvailableSettings.SCHEMA_GEN_SCRIPTS_CREATE_TARGET,
						destination);

		Persistence.generateSchema(persistenceUnitName, persistenceProperties);
	}

	private static void addSemicolon(String destination) {
		File file = new File(destination);
		BufferedReader reader = null;
		FileWriter writer = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			StringBuilder builder = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				if (line.trim().length() > 0) {
					builder.append(line).append(";\n");
				}
			}

			writer = new FileWriter(file);
			writer.write(builder.toString());
			writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
