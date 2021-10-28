package com.proyecto.apprendiendo.utils;

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
    private GetGroupService getGroupService;
    private GetConditionService getConditionService;

    public Object build(Object simpleDTO) {

        if (simpleDTO.getClass().equals(UserDTO.class)){
            UserDTO dto = (UserDTO) simpleDTO;
            dto.setAvatar(getAvatarService.execute(dto.getAvatarId()));
            return dto;
        }
        if (simpleDTO.getClass().equals(ActivityDTO.class)){
            ActivityDTO dto = (ActivityDTO) simpleDTO;
            dto.setLesson(getLessonService.execute(dto.getLessonId()));
            return dto;
        }
        if (simpleDTO.getClass().equals(LessonDTO.class)){
            LessonDTO dto = (LessonDTO) simpleDTO;
            dto.setProject(getProjectService.execute(dto.getProjectId()));
            return dto;
        }
        if (simpleDTO.getClass().equals(ProjectDTO.class)){
            ProjectDTO dto = (ProjectDTO) simpleDTO;
            dto.setMethodology(getMethodologyService.execute(dto.getMethodologyId()));
            dto.setClassroom(getClassroomService.execute(dto.getClassroomId()));
            return dto;
        }
        if (simpleDTO.getClass().equals(ClassroomDTO.class)){
            ClassroomDTO dto = (ClassroomDTO) simpleDTO;
            dto.setTeacher(getUserService.execute(dto.getTeacherId()));
            return dto;
        }
        if (simpleDTO.getClass().equals(StudentProjectDTO.class)){
            StudentProjectDTO dto = (StudentProjectDTO) simpleDTO;
            dto.setStudent(getStudentService.execute(dto.getStudentId()));
            dto.setProject(getProjectService.execute(dto.getProjectId()));
            return dto;
        }
        if (simpleDTO.getClass().equals(StudentLessonDTO.class)){
            StudentLessonDTO dto = (StudentLessonDTO) simpleDTO;
            dto.setStudent(getStudentService.execute(dto.getStudentId()));
            dto.setLesson(getLessonService.execute(dto.getLessonId()));
            return dto;
        }
        if (simpleDTO.getClass().equals(StudentActivityDTO.class)){
            StudentActivityDTO dto = (StudentActivityDTO) simpleDTO;
            dto.setStudent(getStudentService.execute(dto.getStudentId()));
            dto.setActivity(getActivityService.execute(dto.getActivityId()));
            return dto;
        }
        if (simpleDTO.getClass().equals(StudentClassroomDTO.class)){
            StudentClassroomDTO dto = (StudentClassroomDTO) simpleDTO;
            dto.setStudent(getStudentService.execute(dto.getStudentId()));
            dto.setClassroom(getClassroomService.execute(dto.getClassroomId()));
            return dto;
        }
        if (simpleDTO.getClass().equals(GroupStudentDTO.class)){
            GroupStudentDTO dto = (GroupStudentDTO) simpleDTO;
            dto.setStudent(getStudentService.execute(dto.getStudentId()));
            dto.setGroup(getGroupService.execute(dto.getGroupId()));
            return dto;
        }
        if (simpleDTO.getClass().equals(RewardDTO.class)){
            RewardDTO dto = (RewardDTO) simpleDTO;
            dto.setCondition(getConditionService.execute(dto.getConditionId()));
            dto.setTarget(this.getRewardTarget(dto.getTargetId(), dto.getTargetType()));
            return dto;
        }
        if (simpleDTO.getClass().equals(DocumentDTO.class)){
            DocumentDTO dto = (DocumentDTO) simpleDTO;
            dto.setSource(this.getDocumentSource(dto.getSourceId(), dto.getDocumentSourceType()));
            return dto;
        }
        if (simpleDTO.getClass().equals(ProjectTemplateDTO.class)){
            ProjectTemplateDTO dto = (ProjectTemplateDTO) simpleDTO;
            dto.setClassroom(getClassroomService.execute(dto.getClassroomId()));
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


}
