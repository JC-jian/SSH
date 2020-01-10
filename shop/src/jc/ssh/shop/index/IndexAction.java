package jc.ssh.shop.index;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 首页访问的Action
 * @author v-Jc
 *
 */
public class IndexAction extends ActionSupport {
	public String execute() throws Exception{
		return "indexSuccess";
	}

}
