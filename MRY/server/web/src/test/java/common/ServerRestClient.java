package common;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import com.google.gson.Gson;

public class ServerRestClient {
	private static final String host = "116.62.201.135:8080";

	private static final String pwd = "abc123";
	private static String authToken = "a8c2f275-403e-4f82-ae32-21a52b73c846b";

	public static void main(String[] args) throws Exception {
		// System.out.println(get("/app/api/common/provinces"));
		// System.out.println(get("/app/api/common/cities/province/1"));
		// System.out.println(get("/app/api/common/bulletin/1"));

		 authToken = "f40f6784-4e51-445b-b37d-5763bace2487-d";
		 authToken = "f1794b62-052d-4026-a0d8-9c1841c5e371-c";

		// assistant token
		// authToken = "457b2225-ae38-4eb6-8a7b-dea5fd9dca6e-d";

		// admin token
		// authToken = "c05d3d40-e40d-4db1-baf6-96651814e24f";


		// Header auth token
		// authToken = "2fe1b490-735c-4fe6-9598-7007fc0c507e-d";

		// for(int i = 0; i<21; i++){
		// testRegister(i);
		// }
	//	 testLogin();
		// testOfflineConsult();
		// testAdminLogin();

		// testJoinGroup();
		// testgetPublishBulletin();

		// testQueryRecord();
		// testOfflineConsultReply();

		//

		// System.out.println(get("/app/api/common/job/titles"));
		// testLogin();
		// System.out.println(post("/app/api/admin/login",
		// "{\"username\":\"admin\", \"password\": \"admin\"}"));

		// testCreateExclusiveConsult();

		// testReserveExclusiveConsult();
		// testUpdateExclusiveConsult();
		// testDeleteExclusiveConsult();
		// testUploadHealthInfos();

		// testUpdateWarnData();
		// testGetWarnData();

		// testAddWebsite();
		// testUploadHealthInfos();

		// testForwardWarning();
		// System.out.println(get("/app/api/common/partner/websites"));

		//get("/app/api/common/health/groups?cityId=1&doctorName=%E6%9D%8E&name=&page=1&pageSize=10&provinceId=1");
		// testCreateSchedule();

		System.out.println(get("/app/api/common/health/advice"));
	}

	public static String post(String path, String json) {
		String url = "http://" + host + path;
		HttpClient client = HttpClients.createDefault();
		log("Request Method: POST");
		log("Request URL: " + url);
		if (!StringUtils.isBlank(json)) {
			log("Request JSON: " + json);
		}

		HttpPost post = new HttpPost(url);
		post.setHeader("authToken", authToken);
		post.addHeader("Content-Type", "application/json;charset=UTF-8");
		post.addHeader("User-Agent", "Android");

		if (json != null) {
			StringEntity entity = new StringEntity(json, "UTF-8");
			post.setEntity(entity);
		}

		try {
			HttpResponse response = client.execute(post);
			response.addHeader("Content-Type", "application/json;charset=UTF-8");

			log("Response Status Code: " + response.getStatusLine().getStatusCode());

			String result = EntityUtils.toString(response.getEntity());
			log("Response Result: " + result);
			return result;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String get(String path) {
		String url = "http://" + host + path;
		log("Request Method: GET");
		log("Request URL: " + url);
		HttpClient client = HttpClients.createDefault();

		HttpGet get = new HttpGet(url);
		if (authToken != null) {
			get.setHeader("authToken", authToken);
		}
		get.addHeader("Content-Type", "application/json;charset=UTF-8");

		try {
			HttpResponse response = client.execute(get);
			response.addHeader("Content-Type", "application/json;charset=UTF-8");

			log("Status Code: " + response.getStatusLine().getStatusCode());

			String result = EntityUtils.toString(response.getEntity());
			// log("Response Result: " + result);
			return result;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void delete(String path) {
		String url = "http://" + host + path;
		log("Request Method: DELETE");
		log("Request URL: " + url);
		HttpClient client = HttpClients.createDefault();

		HttpDelete get = new HttpDelete(url);
		get.setHeader("authToken", authToken);
		// get.addHeader("Content-Type", "application/json;charset=UTF-8");

		try {
			HttpResponse response = client.execute(get);
			response.addHeader("Content-Type", "application/json;charset=UTF-8");

			log("Status Code: " + response.getStatusLine().getStatusCode());

			String result = EntityUtils.toString(response.getEntity());
			log("Response Result: " + result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String toJson(Object obj) {
		return new Gson().toJson(obj);
	}

	private static String getPicBase64(String filename) {
		byte[] data = getFileBinary(filename);
		return Base64.getEncoder().encodeToString(data);
	}

	public static byte[] getFileBinary(String filename) {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		try {
			InputStream input = new FileInputStream(new File(filename));
			byte[] buffer = new byte[1024];
			int len = -1;
			while ((len = input.read(buffer)) > -1) {
				output.write(buffer, 0, len);
			}

			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return output.toByteArray();
	}

	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");

	public static void log(Object obj) {
		System.out.println(DATE_FORMAT.format(new Date()) + " " + obj);
	}
}
