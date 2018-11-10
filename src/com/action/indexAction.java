package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TCatelogDAO;
import com.dao.TObjfwDAO;
import com.model.TCatelog;
import com.model.TObjfw;
import com.opensymphony.xwork2.ActionSupport;

/**
 * ��ҳ��Ϣ��ѯ
 * @author Administrator
 *
 */
public class indexAction extends ActionSupport
{
	private TCatelogDAO catelogDAO;
	private TObjfwDAO objfwDAO;
	
	//��ҳ
	public String index(){
		String sql="from TCatelog where catelogDel='no'";
		List cateLogList=catelogDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<cateLogList.size();i++){
			TCatelog catelog=(TCatelog)cateLogList.get(i);
			String sql1="from TObjfw where objfwDel='no' and shenheFlag='1' and objfwCatelogId="+catelog.getCatelogId()+" order by objfwId";
			List list=objfwDAO.getHibernateTemplate().find(sql1);
			int k=list.size();
			if(k<6){
				for(int j=0;j<6-k;j++){
					list.add(new TObjfw());
				}
			}
			if(list.size()>6){
				list=list.subList(0, 6);
			}
			catelog.setObjfwList(list);
		}
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("cateLogList", cateLogList);
		return ActionSupport.SUCCESS;
	}
	
	//��ҳ��ͨ���ⷿ��Ϣ��ʾ
	public String zlxx(){
		String sql="from TCatelog where catelogDel='no' and catelogName like '%���ⷿ%'";
		List cateLogList=catelogDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<cateLogList.size();i++){
			TCatelog catelog=(TCatelog)cateLogList.get(i);
			String sql1="from TObjfw where objfwDel='no' and shenheFlag='1' and objfwCatelogId="+catelog.getCatelogId()+" order by objfwId";
			List list=objfwDAO.getHibernateTemplate().find(sql1);
			int k=list.size();
			if(k<6){
				for(int j=0;j<6-k;j++){
					list.add(new TObjfw());
				}
			}
			if(list.size()>6){
				list=list.subList(0, 6);
			}
			catelog.setObjfwList(list);
		}
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("cateLogList", cateLogList);
		return ActionSupport.SUCCESS;
	}
	
	
	//��ҳ������ס����Ϣ��ʾ
	public String xsxx(){
		String sql="from TCatelog where catelogDel='no' and catelogName like '%ס��%'";
		List cateLogList=catelogDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<cateLogList.size();i++){
			TCatelog catelog=(TCatelog)cateLogList.get(i);
			String sql1="from TObjfw where objfwDel='no' and shenheFlag='1' and objfwCatelogId="+catelog.getCatelogId()+" order by objfwId";
			List list=objfwDAO.getHibernateTemplate().find(sql1);
			int k=list.size();
			if(k<6){
				for(int j=0;j<6-k;j++){
					list.add(new TObjfw());
				}
			}
			if(list.size()>6){
				list=list.subList(0, 6);
			}
			catelog.setObjfwList(list);
		}
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("cateLogList", cateLogList);
		return ActionSupport.SUCCESS;
	}

	public TCatelogDAO getCatelogDAO()
	{
		return catelogDAO;
	}

	public void setCatelogDAO(TCatelogDAO catelogDAO)
	{
		this.catelogDAO = catelogDAO;
	}

	public TObjfwDAO getObjfwDAO()
	{
		return objfwDAO;
	}

	public void setObjfwDAO(TObjfwDAO objfwDAO)
	{
		this.objfwDAO = objfwDAO;
	}
	
}