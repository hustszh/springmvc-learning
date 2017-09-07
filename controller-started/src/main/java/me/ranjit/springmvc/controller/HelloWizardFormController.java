package me.ranjit.springmvc.controller;

import me.ranjit.springmvc.model.NewUserModel;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractWizardFormController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by suzh on 8/29/2017.
 */
public class HelloWizardFormController extends AbstractWizardFormController {

    public HelloWizardFormController() {
        setCommandClass(NewUserModel.class);
        setCommandName("user");
    }

    /*
    page: 是根据请求中以“_target”开头的参数名来确定的，如“_target0”，则页码为0；
     */
    protected Map referenceData(HttpServletRequest request, int page) throws Exception {
        Map map = new HashMap();
        if(page==1) { //如果是填写学校信息页 需要学校类型信息
            map.put("schoolTypeList", Arrays.asList("Primary", "Middle", "University"));
        }
        if(page==2) {//如果是填写工作信息页 需要工作城市信息
            map.put("cityList", Arrays.asList("bei", "shang", "guang"));
        }
        return map;
    }

    /*
    page: 是根据请求中以“_target”开头的参数名来确定的，如“_target0”，则页码为0；
     */
    protected void validatePage(Object command, Errors errors, int page) {
        //提供每一页数据的验证处理方法
    }

    /*
    page: 是根据请求中以“_target”开头的参数名来确定的，如“_target0”，则页码为0；
     */
    protected void postProcessPage(HttpServletRequest request, Object command, Errors errors, int page) throws Exception {
        //提供给每一页完成时的后处理方法
    }

    protected ModelAndView processFinish(HttpServletRequest req, HttpServletResponse resp, Object command, BindException errors) throws Exception {
        //成功后的处理方法
        System.out.println(command);
        return new ModelAndView("success");
    }

    protected ModelAndView processCancel(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        //取消后的处理方法
        System.out.println(command);
        return new ModelAndView("cancel");
    }
}
