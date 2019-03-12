package common.ipx;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;
import org.springframework.context.support.GenericXmlApplicationContext;

import dswork.core.util.UniqueId;
import dswork.spring.BeanFactory;

/**
 * 本地方式启动应用
 */
public class IpxUtil
{
	public static void main(String[] args)
	{
		try
		{
			// ********初始化log4j配置********
			java.net.URL url = IpxUtil.class.getResource("/config/log4j2_local.xml");
			ConfigurationSource source = new ConfigurationSource(new java.io.FileInputStream(new File(url.getPath())), url);
			Configurator.initialize(null, source);

			// ********初始化spring容器********
			GenericXmlApplicationContext context =  new GenericXmlApplicationContext();
			context.setValidating(false);
			context.load("classpath*:/config/applicationContext*.xml");
			context.refresh();
			BeanFactory.setApplicationContext(context);// 非web应用时，需要使用该方法设置spring容器

			IpxService service = (IpxService)BeanFactory.getBean(IpxService.class);
			url = IpxUtil.class.getResource("/config/ipx.txt");
			FileInputStream fis = new FileInputStream(new File(url.getPath()));
			InputStreamReader isr = new InputStreamReader(fis, "gbk");
			BufferedReader br = new BufferedReader(isr);
			service.deleteAll();
			String line;
			while ((line = br.readLine()) != null)
			{
				try
				{
					IpxParser ip = new IpxParser(line);
					String[] ss = ip.parse();
//					System.out.println(ss[0] + "," + ss[1] + "," + ss[2] + "," + ss[3]);
					Ipx po = new Ipx();
					po.setId(UniqueId.genId());
					po.setBegin(ss[0]);
					po.setEnd(ss[1]);
					po.setAddress(ss[2]);
					po.setIpx(ss[3]);
					service.save(po);
				}
				catch(Exception e)
				{
				}
			}
			br.close();
			isr.close();
			fis.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
