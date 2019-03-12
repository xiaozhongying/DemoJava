/**
 * 美食Dao
 */
package common.ipx;

import org.springframework.stereotype.Repository;
import dswork.core.db.BaseDao;

@Repository
@SuppressWarnings("all")
public class IpxDao extends BaseDao<Ipx, Long>
{
	@Override
	public Class getEntityClass()
	{
		return Ipx.class;
	}

	public int deleteAll()
	{
		return executeDelete("deleteAll", null);
	}
}