package struts;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jamie
 * @date 19-4-11
 */
public class StrutsAction1 extends ActionSupport {

    HttpServletRequest request = ServletActionContext.getRequest();
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;


    @Override
    public String execute() throws Exception {
        System.out.println("name为："+name);
        request.setAttribute("name",name);
        return SUCCESS;
    }

    public String jump() throws Exception {
        System.out.println("jump跳来的，name为："+name);
        request.setAttribute("name","jump跳来的，name为："+name);
        return SUCCESS;
    }
}
