package cn.edu.jxnu.base.controller.admin.system;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.jxnu.base.common.JsonResult;
import cn.edu.jxnu.base.controller.BaseController;
import cn.edu.jxnu.base.entity.Resource;
import cn.edu.jxnu.base.entity.ZtreeView;
import cn.edu.jxnu.base.service.IResourceService;
import cn.edu.jxnu.base.service.specification.SimpleSpecificationBuilder;
import cn.edu.jxnu.base.service.specification.SpecificationOperator.Operator;

/**
 * 系统资源控制类
 */
@Controller
@RequestMapping("/admin/resource")
public class ResourceController extends BaseController {

	@Autowired
	private IResourceService resourceService;

	/**
	 * 资源树
	 */
	@RequestMapping("/tree/{resourceId}")
	@ResponseBody
	public List<ZtreeView> tree(@PathVariable Integer resourceId) {
		List<ZtreeView> list = resourceService.tree(resourceId);
		return list;
	}

	/**

	 */
	@RequestMapping("/index")
	public String index() {
		return "admin/resource/index";
	}

	/**
	 * 资源管理分页

	 */
	@RequestMapping("/list")
	@ResponseBody
	public Page<Resource> list() {
		SimpleSpecificationBuilder<Resource> builder = new SimpleSpecificationBuilder<Resource>();
		String searchText = request.getParameter("searchText");
		if (StringUtils.isNotBlank(searchText)) {
			builder.add("name", Operator.likeAll.name(), searchText);
		}
		Page<Resource> page = resourceService.findAll(builder.generateSpecification(), getPageRequest());
		return page;
	}

	/**
	 * 打开资源添加页面

	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(ModelMap map) {
		List<Resource> list = resourceService.findAll();
		map.put("list", list);
		return "admin/resource/form";
	}

	/**
	 * 打开资源修改页面
	 *

	 */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable Integer id, ModelMap map) {
		Resource resource = resourceService.find(id);
		map.put("resource", resource);

		List<Resource> list = resourceService.findAll();
		map.put("list", list);
		return "admin/resource/form";
	}

	/**
	 * 资源添加或修改

	 */
	@RequestMapping(value = { "/edit" }, method = RequestMethod.POST)
	@ResponseBody
	public JsonResult edit(Resource resource, ModelMap map) {
		try {
			resourceService.saveOrUpdate(resource);
			// 可能存在需要在增加资源的时候默认给管理员增加权限
		} catch (Exception e) {
			return JsonResult.failure(e.getMessage());
		}
		return JsonResult.success();
	}

	/**
	 * 资源删除

	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult delete(@PathVariable Integer id, ModelMap map) {
		try {
			resourceService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.failure(e.getMessage());
		}
		return JsonResult.success();
	}
}
