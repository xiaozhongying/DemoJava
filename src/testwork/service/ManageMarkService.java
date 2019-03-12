/**
 * MyBatis样例Service
 */
package testwork.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dswork.core.db.EntityDao;
import dswork.core.db.BaseService;
import dswork.core.page.Page;
import dswork.core.page.PageRequest;
import dswork.core.util.UniqueId;
import testwork.model.Demo;
import testwork.model.Mark;
import testwork.dao.DemoDao;
import testwork.dao.MarkDao;

@Service
@SuppressWarnings("all")
public class ManageMarkService
{
	@Autowired
	private DemoDao demoDao;
	@Autowired
	private MarkDao markDao;

	public Page<Demo> queryPage(PageRequest pageRequest)
	{
		System.out.println(org.springframework.transaction.support.TransactionSynchronizationManager.isSynchronizationActive());
		return demoDao.queryPage(pageRequest);
	}

	public Demo get(Long primaryKey)
	{
		System.out.println(org.springframework.transaction.support.TransactionSynchronizationManager.isSynchronizationActive());
		Demo x = (Demo) demoDao.get(primaryKey);
		x.setId(UniqueId.genId());
		demoDao.save(x);
		return (Demo) demoDao.get(primaryKey);
	}
	
	public List<Mark> queryListMark(Long demoid)
	{
		System.out.println(org.springframework.transaction.support.TransactionSynchronizationManager.isSynchronizationActive());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("demoid", demoid);
		return markDao.queryList(map);
	}
	public int save(List<Mark> list)
	{
		System.out.println(org.springframework.transaction.support.TransactionSynchronizationManager.isSynchronizationActive());
		for(Mark m : list)
		{
			markDao.save(m);
		}
		return 1;
	}
}
