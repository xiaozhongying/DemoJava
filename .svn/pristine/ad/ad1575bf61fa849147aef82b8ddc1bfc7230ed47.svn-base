package common.ipx;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IpxParser
{
	private String src;
	private int px;

	public IpxParser(String src)
	{
		this.src = src;
		this.px = 0;
	}

	public String next()
	{
		while(px < src.length())
		{
			if(src.charAt(px) == ' ')
			{
				px++;
				continue;
			}
//			int i = px++;
//			while(px < src.length() && src.charAt(px) != ' ')
//			{
//				px++;
//			}
//			return src.substring(i, px);
			String tk = src.substring(px).split(" ")[0];
			px += tk.length();
			return tk;
		}
		return "";
	}

	public String leftPad(String src, int len, char pad)
	{
		int gap = len - src.length();
		if(gap > 0)
		{
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < gap; i++)
			{
				sb.append(pad);
			}
			return sb.append(src).toString();
		}
		return src;
	}

	public String ipAdjust(String ip)
	{
		String[] ss = ip.split("\\.");
		ss[0] = leftPad(ss[0], 3, '0');
		ss[1] = leftPad(ss[1], 3, '0');
		ss[2] = leftPad(ss[2], 3, '0');
		ss[3] = leftPad(ss[3], 3, '0');
		return ss[0] + "." + ss[1] + "." + ss[2] + "." + ss[3];
	}

	public String[] parse()
	{
		String[] ss = new String[4];
		ss[0] = next();
		ss[0] = ipAdjust(ss[0]);
		ss[1] = next();
		ss[1] = ipAdjust(ss[1]);
		ss[2] = next();
		ss[3] = next();
		return ss;
	}

	//test
	public static void main(String[] argv) throws IOException
	{
		FileInputStream fis = new FileInputStream("D://ipx.txt");
		InputStreamReader isr = new InputStreamReader(fis, "gbk");
		BufferedReader br = new BufferedReader(isr);

		FileOutputStream fos = new FileOutputStream("D://ipx_out.txt");
		OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);

		String line;
		while ((line = br.readLine()) != null)
		{
			try
			{
				IpxParser ip = new IpxParser(line);
				String[] ss = ip.parse();
				System.out.println(ss[0] + "," + ss[1] + "," + ss[2] + "," + ss[3]);
				bw.write(ss[0] + "," + ss[1] + "," + ss[2] + "," + ss[3]);
				bw.newLine();
			}
			catch(Exception e)
			{
			}
		}

		bw.close();
		osw.close();
		fos.close();

		br.close();
		isr.close();
		fis.close();
	}
}
