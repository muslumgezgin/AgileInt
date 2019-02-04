package io.agileintllegience.ppmtool.services;

import io.agileintllegience.ppmtool.domain.Project;
import io.agileintllegience.ppmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project){


        return projectRepository.save(project);
    }

}
