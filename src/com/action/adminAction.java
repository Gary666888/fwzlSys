package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TAdminDAO;
import com.model.TAdmin;
import com.opensymphony.xwork2.ActionSupport;
import com.util.Pagination;

/**
 * ����Ա��Ϣ������
 * @author Administrator
 *
 */
public class adminAction extends ActionSupport
{
	private int userId;
	private String userName;
	private String userPw;
	 
	private String message;
	private String path;
	
	private int index=1;

	private TAdminDAO adminDAO;
	private  Integer  currentPage;

	
	/**
	 * ����Ա���
	 * @author Administrator
	 *
	 */
	public String adminAdd()
	{
		TAdmin admin=new TAdmin();
		admin.setUserName(userName);
		admin.setUserPw(userPw);
		adminDAO.save(admin); //����adminDao��save��������admin�����ݿ�
		this.setMessage("�����ɹ�");//����action�е�message����Ϊ"��ӳɹ�"
		this.setPath("adminManage.action");//������ת·��ΪadminManage.action
		return "succeed";
	}
	
	
	/**
	 * ����Ա�б�鿴
	 * @author Administrator
	 *
	 */
	public String adminManage()
	{
		List adminList=adminDAO.findAll(); //dao�е�findAll ����dao��ʹ�õ���Hibernate
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("adminList", adminList);//���б����adminList
		return ActionSupport.SUCCESS;
		
		/*Integer length =2;
		//currentPage=Integer.parseInt(ServletActionContext.getRequest().getParameter("currentPage"));
		if(currentPage == null){
			currentPage =1;
		}
		Integer start =(currentPage-1)*length;//start����Ҳ�õ�һ�������ǵڼ�������
        Map request=(Map)ServletActionContext.getContext().get("request");
		String sql="from TAdmin where userName='admin'";
		List adminList=adminDAO.findGoods(start,length,sql);
		Integer pageCount = 0;
        if(adminList != null){
        	int c = adminList.size();
        	pageCount=(c+2)/3;
        }		 
		request.put("adminList", adminList);
		request.put("currentPage", currentPage);
		request.put("start", start);
		request.put("pageCount", pageCount);
		return ActionSupport.SUCCESS;*/
	}
	
	public String adminManageFenye()
	{
		List adminList=adminDAO.findAll();//���ҳ����е�adminList
		int pageSize=8;//ÿҳ8��
		int fromIndex = (index - 1) * pageSize;//ѡ��ӵڼ�����ʼ
		int toIndex = Math.min(fromIndex + pageSize, adminList.size());//����Math.min����ȡĿ����
		List adminListFenye = adminList.subList(fromIndex, toIndex);//�������б��н�ȡ���б�
		

        Pagination p = new Pagination();//���� ��ҳ����
        p.setIndex(index);//����ҳ��
        p.setPageSize(pageSize);//����ÿҳ����
        p.setTotle(adminList.size());//�����ܹ�������
        p.setData(adminListFenye);//��������
        p.setPath("adminManageFenye.action?");//��ת��·��

		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("page", p);
		return ActionSupport.SUCCESS;
		/*List stuList=stuDAO.getHibernateTemplate().find("from TStu where del='no'");
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("stuList", stuList);
		return ActionSupport.SUCCESS;*/
		
		/*Integer length =2;
		//currentPage=Integer.parseInt(ServletActionContext.getRequest().getParameter("currentPage"));
		if(currentPage == null){
			currentPage =1;
		}
		Integer start =(currentPage-1)*length;//start����Ҳ�õ�һ�������ǵڼ�������
        Map request=(Map)ServletActionContext.getContext().get("request");
		String sql="from TAdmin";
		List adminList=adminDAO.findGoods(start,length,sql);
		Integer pageCount = 0;
        if(adminList != null){
        	int c = adminList.size();
        	pageCount=(c+2)/3;
        }		 
		request.put("adminList", adminList);
		request.put("currentPage", currentPage);
		request.put("start", start);
		request.put("pageCount", pageCount);
		return ActionSupport.SUCCESS;
*/
		
		
		
		
		
	}
	
	/**
	 * ����Աɾ��
	 * @author Administrator
	 *
	 */
	public String adminDel()
	{
		adminDAO.delete(adminDAO.findById(userId));//��ͨ��id���ҵ���adminɾ��
		this.setMessage("ɾ���ɹ�");
		this.setPath("adminManage.action");
		return "succeed";
	}
	
	

	public TAdminDAO getAdminDAO()
	{
		return adminDAO;
	}

	public void setAdminDAO(TAdminDAO adminDAO)
	{
		this.adminDAO = adminDAO;
	}

	public String getMessage()
	{
		return message;
	}

	public int getIndex()
	{
		return index;
	}



	public void setIndex(int index)
	{
		this.index = index;
	}



	public void setMessage(String message)
	{
		this.message = message;
	}

	public String getPath()
	{
		return path;
	}

	public void setPath(String path)
	{
		this.path = path;
	}

	public int getUserId()
	{
		return userId;
	}

	public void setUserId(int userId)
	{
		this.userId = userId;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getUserPw()
	{
		return userPw;
	}

	public void setUserPw(String userPw)
	{
		this.userPw = userPw;
	}
	 
	/*public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}*/

}
