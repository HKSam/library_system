package cn.edu.jxnu.base.controller.admin.system;

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
import cn.edu.jxnu.base.entity.Memorandum;
import cn.edu.jxnu.base.service.IMemorandumService;
import cn.edu.jxnu.base.service.specification.SimpleSpecificationBuilder;
import cn.edu.jxnu.base.service.specification.SpecificationOperator.Operator;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * 系统操作信息备忘录 控制类

 */

@Slf4j
@Controller
@RequestMapping("/admin/memorandum")
public class MemorandumController extends BaseController {
	@Autowired
	private IMemorandumService memorandumService;


	@RequestMapping("/index")
	public String index() {
		return "admin/memorandum/index";
	}

	/**
	 * 分页

	 */
	@RequestMapping("/list")
	@ResponseBody
	public Page<Memorandum> list() {
		SimpleSpecificationBuilder<Memorandum> builder = new SimpleSpecificationBuilder<Memorandum>();
		/** 查询. */
		String searchText = request.getParameter("searchText");
		if (StringUtils.isNotBlank(searchText)) {
			builder.add("userName", Operator.likeAll.name(), searchText);
		}
		Page<Memorandum> page = memorandumService.findAll(builder.generateSpecification(), getPageRequest());
		log.info("Memorandum : {}", page.getSize());
		return page;
	}

	/**
	 * 删除

	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult delete(@PathVariable Integer id, ModelMap map) {
		try {
			memorandumService.delete(id);
			log.info("删除：{}成功",id);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.failure(e.getMessage());
		}
		return JsonResult.success();
	}
}
