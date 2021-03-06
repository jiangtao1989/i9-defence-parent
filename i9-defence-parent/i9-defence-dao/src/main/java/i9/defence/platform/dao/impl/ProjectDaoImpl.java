package i9.defence.platform.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import i9.defence.platform.dao.ProjectDao;
import i9.defence.platform.dao.mapper.ProjectMapper;
import i9.defence.platform.dao.vo.ProjectSearchDto;
import i9.defence.platform.model.Project;
import i9.defence.platform.model.ProjectExample;
import i9.defence.platform.utils.PageBounds;

/**
 * 项目DaoImpl
 * @author 姜哲
 * @create 2018年1月8日
 */
@Repository
public class ProjectDaoImpl implements ProjectDao{
	
	@Autowired
	private ProjectMapper projectMapper;

	@Override
	public void addProject(Project project) throws Exception {
		projectMapper.insertSelective(project);
	}

	@Override
	public void updateProject(Project project) throws Exception {
		projectMapper.updateByPrimaryKeySelective(project);
		
	}

	@Override
	public void deleteProject(List<Integer> ids) throws Exception {
		projectMapper.deleteByPrimaryKey(ids);		
	}

	@Override
	public Project getProjectById(int id) throws Exception {
		return projectMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Project> findAllProject() throws Exception {
		ProjectExample example = new ProjectExample();
		return projectMapper.selectByExample(example);
	}

	@Override
	public PageBounds<Project> selectByLimitPage(ProjectSearchDto projectSearchDto, int currectPage, int pageSize)
			throws Exception {
		final int totalSize = projectMapper.countByExample(projectSearchDto);
        PageBounds<Project> pageBounds = new PageBounds<Project>(currectPage, totalSize, pageSize);
        List<Project> list = projectMapper.selectByLimitPage(projectSearchDto, pageBounds.getOffset(), pageBounds.getPageSize());
        pageBounds.setPageList(list);
        return pageBounds;
	}

}
