package willian.backJava.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Convert {

	public static Object convert(Object sender, Object receiver)
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {

		for (Method m : sender.getClass().getMethods()) {
			String getMethod = m.getName();

			if (getMethod.startsWith("get") && !getMethod.equals("getClass")) {
				String setMethod = getMethod.replace("get", "set");

				Method type = sender.getClass().getMethod(getMethod);
				Object value = sender.getClass().getMethod(getMethod).invoke(sender);

				try {
					Method callMethod = receiver.getClass().getMethod(setMethod, type.getReturnType());

					callMethod.invoke(receiver, value);
				} catch (Exception e) {
					// TODO: handle exception
				}

			}

		}

		return receiver;

	}

}
