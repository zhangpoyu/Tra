package com.unrule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("supermanagerlogin")

public class SuperManagerLoginController {
    @Autowired
    private SuperManagerLoginRepository repository;

    @GetMapping("get/{login_name}")
    public SuperManagerLogin get(@PathVariable String login_name) {
        return repository.findOne(login_name);
    }

    @PostMapping("save")
    public ExecuteDTO save(@RequestBody SuperManagerLogin entity) {
        repository.save(entity);
        return new ExecuteDTO(true, "保存成功", entity.login_name);
    }

    @PostMapping("loadPage")
    public PageResultDTO loadPage(@RequestBody PageQueryParamDTO params) {

        // 动态查询条件
        Specification<SuperManagerLogin> spec = (root, query, cb) -> {
            if (params.getQuery() != null) {
                // 筛选 会员姓名
                query.where(cb.equal(root.get("login_name"), params.getQuery().toString()));
            }

            return null;
        };
        Pageable pageable = new PageRequest(params.getPage() - 1, params.getSize());
        Page<SuperManagerLogin> pageResult = repository.findAll(spec, pageable);

        // 返回分页数据
        return new PageResultDTO(pageResult.getTotalElements(), pageResult.getContent());
    }

    @GetMapping("remove/{login_name}")
    public ExecuteDTO remove(@PathVariable String login_name) {
        repository.delete(login_name);
        return new ExecuteDTO(true, "删除成功", login_name);
    }

}
