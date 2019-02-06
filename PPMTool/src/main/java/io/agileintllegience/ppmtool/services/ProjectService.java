package io.agileintllegience.ppmtool.services;

import io.agileintllegience.ppmtool.domain.Project;
import io.agileintllegience.ppmtool.exceptions.ProjectIdException;
import io.agileintllegience.ppmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project){
        try{
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        }
        catch (Exception e){
            throw  new ProjectIdException("Project ID'"+project.getProjectIdentifier().toUpperCase()+"'+already exist");
        }
    }

    public Project findProjectByIdentifier(String projectId){

        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());

        if(project == null){
            throw new ProjectIdException("Project ID '"+projectId.toUpperCase()+"' does not exist");
        }
        return project;
    }



}
