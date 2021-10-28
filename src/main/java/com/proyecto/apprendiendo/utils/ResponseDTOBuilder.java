package com.proyecto.apprendiendo.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.proyecto.apprendiendo.entities.dtos.*;
import com.proyecto.apprendiendo.services.general_services.activity_services.GetActivityService;
import com.proyecto.apprendiendo.services.general_services.avatar_services.GetAvatarService;
import com.proyecto.apprendiendo.services.general_services.classroom_services.GetClassroomService;
import com.proyecto.apprendiendo.services.general_services.condition_services.GetConditionService;
import com.proyecto.apprendiendo.services.general_services.group_services.GetGroupService;
import com.proyecto.apprendiendo.services.general_services.lesson_services.GetLessonService;
import com.proyecto.apprendiendo.services.general_services.methodology_services.GetMethodologyService;
import com.proyecto.apprendiendo.services.general_services.project_services.GetProjectService;
import com.proyecto.apprendiendo.services.general_services.user_services.GetStudentService;
import com.proyecto.apprendiendo.services.general_services.user_services.GetUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ResponseDTOBuilder {
    private GetAvatarService getAvatarService;
    private GetActivityService getActivityService;
    private GetLessonService getLessonService;
    private GetProjectService getProjectService;
    private GetClassroomService getClassroomService;
    private GetUserService getUserService;
    private GetStudentService getStudentService;
    private GetMethodologyService getMethodologyService;
    private GetConditionService getConditionService;

    public Object build(Object simpleDTO) {
        if (simpleDTO.getClass().toString().equals(ArrayList.class.toString())){
            ArrayList<Object> simpleDTOList = (ArrayList<Object>) simpleDTO;
            printObject(simpleDTOList);
            return  simpleDTOList.stream()
                                 .map(dto -> {
                                     printObject(dto);
                                     return buildFullDTO(dto);
                                 })
                                 .collect(Collectors.toCollection(ArrayList::new));
        }

        else return buildFullDTO(simpleDTO);

    }

    private Object buildFullDTO(Object simpleDTO) {
        if (simpleDTO.getClass().equals(UserDTO.class)){
            UserDTO dto = (UserDTO) simpleDTO;

            if (dto.getAvatarId() != null) if (!dto.getAvatarId().equals(0L)) dto.setAvatar(getAvatarService.execute(dto.getAvatarId()));
            return dto;
        }
        if (simpleDTO.getClass().equals(ActivityDTO.class)){
            ActivityDTO dto = (ActivityDTO) simpleDTO;
            if (dto.getLessonId() != null) if (!dto.getLessonId().equals(0L)) dto.setLesson(getLessonService.execute(dto.getLessonId()));
            return dto;
        }
        if (simpleDTO.getClass().equals(LessonDTO.class)){
            LessonDTO dto = (LessonDTO) simpleDTO;
            if (dto.getProjectId() != null) if (!dto.getProjectId().equals(0L)) dto.setProject(getProjectService.execute(dto.getProjectId()));
            return dto;
        }
        if (simpleDTO.getClass().equals(ProjectDTO.class)){
            ProjectDTO dto = (ProjectDTO) simpleDTO;
            if (dto.getMethodologyId() != null) if (!dto.getMethodologyId().equals(0L)) dto.setMethodology(getMethodologyService.execute(dto.getMethodologyId()));
            if (dto.getClassroomId() != null) if (!dto.getClassroomId().equals(0L)) dto.setClassroom(getClassroomService.execute(dto.getClassroomId()));
            return dto;
        }
        if (simpleDTO.getClass().equals(ClassroomDTO.class)){
            ClassroomDTO dto = (ClassroomDTO) simpleDTO;
            if (dto.getTeacherId() != null) if (!dto.getTeacherId().equals(0L)) dto.setTeacher(getUserService.execute(dto.getTeacherId()));
            return dto;
        }
        if (simpleDTO.getClass().equals(StudentProjectDTO.class)){
            StudentProjectDTO dto = (StudentProjectDTO) simpleDTO;
            if (dto.getStudentId() != null) if (!dto.getStudentId().equals(0L)) dto.setStudent(getStudentService.execute(dto.getStudentId()));
            if (dto.getProjectId() != null) if (!dto.getProjectId().equals(0L)) dto.setProject(getProjectService.execute(dto.getProjectId()));
            return dto;
        }
        if (simpleDTO.getClass().equals(StudentLessonDTO.class)){
            StudentLessonDTO dto = (StudentLessonDTO) simpleDTO;
            if (dto.getStudentId() != null) if (!dto.getStudentId().equals(0L)) dto.setStudent(getStudentService.execute(dto.getStudentId()));
            if (dto.getLessonId() != null) if (!dto.getLessonId().equals(0L)) dto.setLesson(getLessonService.execute(dto.getLessonId()));
            return dto;
        }
        if (simpleDTO.getClass().equals(StudentActivityDTO.class)){
            StudentActivityDTO dto = (StudentActivityDTO) simpleDTO;
            if (dto.getStudentId() != null) if (!dto.getStudentId().equals(0L)) dto.setStudent(getStudentService.execute(dto.getStudentId()));
            if (dto.getActivityId() != null) if (!dto.getActivityId().equals(0L)) dto.setActivity(getActivityService.execute(dto.getActivityId()));
            return dto;
        }
        if (simpleDTO.getClass().equals(StudentClassroomDTO.class)){
            StudentClassroomDTO dto = (StudentClassroomDTO) simpleDTO;
            if (dto.getStudentId() != null) if (!dto.getStudentId().equals(0L)) dto.setStudent(getStudentService.execute(dto.getStudentId()));
            if (dto.getClassroomId() != null) if (!dto.getClassroomId().equals(0L)) dto.setClassroom(getClassroomService.execute(dto.getClassroomId()));
            return dto;
        }
        if (simpleDTO.getClass().equals(GroupStudentDTO.class)){
            GroupStudentDTO dto = (GroupStudentDTO) simpleDTO;
            if (dto.getStudentId() != null) if (!dto.getStudentId().equals(0L)) dto.setStudent(getStudentService.execute(dto.getStudentId()));
            return dto;
        }
        if (simpleDTO.getClass().equals(RewardDTO.class)){
            RewardDTO dto = (RewardDTO) simpleDTO;
            if (dto.getConditionId() != null) if (!dto.getConditionId().equals(0L)) dto.setCondition(getConditionService.execute(dto.getConditionId()));
            if (dto.getTargetId() != null) if (!dto.getTargetId().equals(0L)) dto.setTarget(this.getRewardTarget(dto.getTargetId(), dto.getTargetType()));
            return dto;
        }
        if (simpleDTO.getClass().equals(DocumentDTO.class)){
            DocumentDTO dto = (DocumentDTO) simpleDTO;
            if (dto.getSourceId() != null) if (!dto.getSourceId().equals(0L)) dto.setSource(this.getDocumentSource(dto.getSourceId(), dto.getDocumentSourceType()));
            return dto;
        }
        if (simpleDTO.getClass().equals(ProjectTemplateDTO.class)){
            ProjectTemplateDTO dto = (ProjectTemplateDTO) simpleDTO;
            if (dto.getClassroomId() != null) if (!dto.getClassroomId().equals(0L)) dto.setClassroom(getClassroomService.execute(dto.getClassroomId()));
            return dto;
        }
        if (simpleDTO.getClass().equals(GroupDTO.class)){
            GroupDTO dto = (GroupDTO) simpleDTO;
            if (dto.getProjectId() != null) if (!dto.getProjectId().equals(0L)) dto.setProject(getProjectService.execute(dto.getProjectId()));
            return dto;
        }
        else return simpleDTO;
    }

    private Object getDocumentSource(Long sourceId, String documentSourceType) {
        return null;
    }

    private Object getRewardTarget(Long targetId, String targetType) {
        return null;
    }

    private void printObject(Object object) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(gson.toJson(object));
    }


}
