package testwork.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import dswork.mvc.BaseController;

@Controller
@Scope("prototype")
@RequestMapping("/i18n")
public class I18nController extends BaseController
{
	@RequestMapping("/test")
	public String index()
	{
		return "/i18n/test.jsp";
	}
}
