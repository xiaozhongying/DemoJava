package common.i18n;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class I18nUtil
{
	private static final String BASE_NAME = "config.i18n.message";
	private static Map<String, I18nUtil> instanceCache = new HashMap<String, I18nUtil>();

	private ResourceBundle bundle = null;
	private Map<String, String> valueCache = new HashMap<String, String>();

	private I18nUtil()
	{
	}

	public static I18nUtil getInstance()
	{
		return getInstance("", "");
	}

	public static I18nUtil getInstance(String language)
	{
		return getInstance(language, "");
	}

	public static I18nUtil getInstance(String language, String country)
	{
		String key = language + country;
		I18nUtil instance = instanceCache.get(key);
		if(instance == null)
		{
			Locale locale = getLocale(language, country);
			instance = new I18nUtil();
			instance.bundle = getBundle(locale);
			instanceCache.put(key, instance);
		}
		return instance;
	}

	private static Locale getLocale(String language, String country)
	{
		if((language == null || "".equals(language)) && (country == null || "".equals(country)))
		{
			return Locale.getDefault();
		}
		return new Locale(language, country);
	}

	private static ResourceBundle getBundle(Locale locale)
	{
		try
		{
			return ResourceBundle.getBundle(BASE_NAME, locale);
		}
		catch(MissingResourceException e)// 没有该地区语言的配置文件，采用默认配置文件
		{
		}
		return ResourceBundle.getBundle(BASE_NAME);
	}

	public String getValue(String key, String... args)
	{
		String value = valueCache.get(key);
		if(value == null)
		{
			try
			{
				value = bundle.getString(key);
				valueCache.put(key, value);
			}
			catch(Exception e)// 可能没有配置这个key
			{
			}
		}
		if(value == null)
		{
			return "";
		}
		if(args == null || args.length == 0)
		{
			return value;
		}
		MessageFormat mf = new MessageFormat(value);
		return mf.format(args);
	}

	// TEST
	public static void main(String[] args)
	{
		System.out.println(I18nUtil.getInstance().getValue("hello", "中国"));
		System.out.println(I18nUtil.getInstance("en").getValue("hello", "中国"));
		System.out.println(I18nUtil.getInstance("en", "US").getValue("hello", "中国"));
		System.out.println(I18nUtil.getInstance("zh", "TW").getValue("hello", "中国"));
		System.out.println(I18nUtil.getInstance().getValue("hello", "中国"));
	}
}
