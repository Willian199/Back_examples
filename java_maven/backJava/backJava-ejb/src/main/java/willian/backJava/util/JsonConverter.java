package willian.backJava.util;

import com.google.gson.Gson;

public class JsonConverter {

	public static Gson json = new Gson();

	public static <T> T fromJson(String jsonString, Class<T> classeConverter) {
		return json.fromJson(jsonString, classeConverter);
	}

	public static String toJson(Object objeto) {
		return json.toJson(objeto);
	}

}
