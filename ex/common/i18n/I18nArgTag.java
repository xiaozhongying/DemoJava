package common.i18n;

import javax.servlet.jsp.tagext.SimpleTagSupport;

public class I18nArgTag extends SimpleTagSupport
{
	private String v;
	private String language;
	private String country;

	@Override
	public void doTag()
	{
		I18nTag parent = (I18nTag) getParent();
		if(v.startsWith("@"))
		{
			v = v.substring(1);
			if(!v.startsWith("@"))
			{
				if(language == null || "".equals(language))
				{
					language = parent.getLanguage();
				}
				if(country == null || "".equals(country))
				{
					country = parent.getCountry();
				}
				if(language == null || "".equals(language))
				{
					v = I18nUtil.getInstance().getValue(v);
				}
				else if(country == null || "".equals(country))
				{
					v = I18nUtil.getInstance(language).getValue(v);
				}
				else
				{
					v = I18nUtil.getInstance(language, country).getValue(v);
				}
			}
		}
		parent.addArg(v);
	}

	public void setV(String v)
	{
		this.v = v;
	}

	public void setLanguage(String language)
	{
		this.language = language;
	}

	public void setCountry(String country)
	{
		this.country = country;
	}
}
