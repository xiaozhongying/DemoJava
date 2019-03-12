/**
 * 美食Service
 */
package common.ipx;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dswork.core.db.EntityDao;
import dswork.core.db.BaseService;

@Service
@SuppressWarnings("all")
public class IpxService extends BaseService<Ipx, Long>
{
	@Autowired
	private IpxDao dao;

	@Override
	protected EntityDao getEntityDao()
	{
		return dao;
	}

	public int deleteAll()
	{
		return dao.deleteAll();
	}
}
