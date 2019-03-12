package common.i18n;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class I18nTag extends SimpleTagSupport
{
	private String key;
	private String language;
	private String country;
	private List<String> args = new ArrayList<String>();

	@Override
	public void doTag() throws IOException, JspException
	{
		StringWriter sw = new StringWriter();
		JspFragment jf = getJspBody();
		jf.invoke(sw);
		String content = sw.toString();
		JspWriter out = getJspContext().getOut();
		if(key == null || "".equals(key))
		{
		}
		else if(language == null || "".equals(language))
		{
			out.write(I18nUtil.getInstance().getValue(key, getArgsArray()));
		}
		else if(country == null || "".equals(country))
		{
			out.write(I18nUtil.getInstance(language).getValue(key, getArgsArray()));
		}
		else
		{
			out.write(I18nUtil.getInstance(language, country).getValue(key, getArgsArray()));
		}
		out.write(content);
	}

	private String[] getArgsArray()
	{
		return args.toArray(new String[args.size()]);
	}

	public void setKey(String key)
	{
		this.key = key;
	}

	public String getLanguage()
	{
		return language;
	}

	public void setLanguage(String language)
	{
		this.language = language;
	}

	public String getCountry()
	{
		return country;
	}

	public void setCountry(String country)
	{
		this.country = country;
	}

	public void addArg(String v)
	{
		this.args.add(v);
	}
}
