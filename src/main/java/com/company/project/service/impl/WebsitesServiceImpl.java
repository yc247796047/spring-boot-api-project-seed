package com.company.project.service.impl;

import com.company.project.dao.WebsitesMapper;
import com.company.project.model.Websites;
import com.company.project.service.WebsitesService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/01/26.
 */
@Service
@Transactional
public class WebsitesServiceImpl extends AbstractService<Websites> implements WebsitesService {
    @Resource
    private WebsitesMapper websitesMapper;

}
