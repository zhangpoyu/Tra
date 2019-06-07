package com.unrule;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

/**
 * 会员控制器
 *
 * @author 刘冬 博客出处：http://www.cnblogs.com/GoodHelper/
 *
 */
@RestController
@RequestMapping("owner")
public class OwnerController {

	@Autowired
	private OwnerRepository repository;

	@GetMapping("get/{id}")
	public Owner get(@PathVariable String id) {
		return repository.findOne(id);
	}

	@PostMapping("save")
	public ExecuteDTO save(@RequestBody Owner entity) {
		repository.save(entity);
		return new ExecuteDTO(true, "保存成功", entity.id);
	}

	@PostMapping("loadPage")
	public PageResultDTO loadPage(@RequestBody PageQueryParamDTO params) {

		// 动态查询条件
		Specification<Owner> spec = (root, query, cb) -> {
			if (params.getQuery() != null) {
				// 筛选 会员姓名
				query.where(cb.equal(root.get("name"), params.getQuery().toString()));
			}

			return null;
		};
		Pageable pageable = new PageRequest(params.getPage() - 1, params.getSize());
		Page<Owner> pageResult = repository.findAll(spec, pageable);

		// 返回分页数据
		return new PageResultDTO(pageResult.getTotalElements(), pageResult.getContent());
	}

	@GetMapping("remove/{id}")
	public ExecuteDTO remove(@PathVariable String id) {
		repository.delete(id);
		return new ExecuteDTO(true, "删除成功", id);
	}

}
