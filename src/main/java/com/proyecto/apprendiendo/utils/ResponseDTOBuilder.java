package com.proyecto.apprendiendo.utils;

import com.proyecto.apprendiendo.entities.dtos.*;
import com.proyecto.apprendiendo.entities.enums.DocumentSourceType;
import com.proyecto.apprendiendo.entities.enums.TargetType;
import com.proyecto.apprendiendo.services.general_services.activity_services.GetActivityService;
import com.proyecto.apprendiendo.services.general_services.avatar_services.GetAvatarService;
import com.proyecto.apprendiendo.services.general_services.classroom_services.GetClassroomProjectsService;
import com.proyecto.apprendiendo.services.general_services.classroom_services.GetClassroomService;
import com.proyecto.apprendiendo.services.general_services.classroom_user_services.*;
import com.proyecto.apprendiendo.services.general_services.condition_services.GetConditionService;
import com.proyecto.apprendiendo.services.general_services.document_services.GetSourcesDocumentsService;
import com.proyecto.apprendiendo.services.general_services.lesson_services.GetLessonActivitiesService;
import com.proyecto.apprendiendo.services.general_services.lesson_services.GetLessonService;
import com.proyecto.apprendiendo.services.general_services.lesson_services.GetLessonStudentsProgressService;
import com.proyecto.apprendiendo.services.general_services.methodology_services.GetMethodologyService;
import com.proyecto.apprendiendo.services.general_services.project_services.GetProjectGroupsService;
import com.proyecto.apprendiendo.services.general_services.project_services.GetProjectLessonsService;
import com.proyecto.apprendiendo.services.general_services.project_services.GetProjectService;
import com.proyecto.apprendiendo.services.general_services.reward_services.GetTargetRewardsService;
import com.proyecto.apprendiendo.services.general_services.student_activity_services.GetActivityStudentsProgressService;
import com.proyecto.apprendiendo.services.general_services.student_activity_services.GetStudentActivityProgressService;
import com.proyecto.apprendiendo.services.general_services.student_project_services.GetProjectStudentsProgressService;
import com.proyecto.apprendiendo.services.general_services.student_project_services.GetStudentProjectProgressService;
import com.proyecto.apprendiendo.services.general_services.student_reward_services.GetStudentRewardsService;
import com.proyecto.apprendiendo.services.general_services.template_services.GetStoredTemplateMetadataService;
import com.proyecto.apprendiendo.services.general_services.template_services.GetTemplateReviewsService;
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
    private GetStudentClassroomProgressService getStudentClassroomProgressService;
    private GetStudentProjectProgressService getStudentProjectProgressService;
    private GetStudentActivityProgressService getStudentActivityProgressService;
    private GetSourcesDocumentsService getSourcesDocumentsService;
    private GetTargetRewardsService getTargetRewardsService;
    private GetActivityStudentsProgressService getActivityStudentsProgressService;
    private GetLessonStudentsProgressService getLessonStudentsProgressService;
    private GetLessonActivitiesService getLessonActivitiesService;
    private GetProjectStudentsProgressService getProjectStudentsProgressService;
    private GetProjectGroupsService getProjectGroupsService;
    private GetProjectLessonsService getProjectLessonsService;
    private GetClassroomStudentsProgressService getClassroomStudentsProgressService;
    private GetClassroomStudentsService getClassroomStudentsService;
    private GetClassroomProjectsService getClassroomProjectsService;
    private GetStudentClassroomsService getStudentClassroomsService;
    private GetTeacherClassroomsService getTeacherClassroomsService;
    private GetStudentRewardsService getStudentRewardsService;
    private GetTemplateReviewsService getTemplateReviewsService;
    private GetStoredTemplateMetadataService getStoredTemplateMetadataService;

    public Object build(Object simpleDTO) {
        if (simpleDTO == null) return null;
        if (simpleDTO.getClass().toString().equals(ArrayList.class.toString())){
            ArrayList<Object> simpleDTOList = (ArrayList<Object>) simpleDTO;
            return  simpleDTOList.stream()
                                 .map(dto -> buildFullDTO(dto))
                                 .collect(Collectors.toCollection(ArrayList::new));
        }

        else return buildFullDTO(simpleDTO);

    }

    private Object buildFullDTO(Object simpleDTO) {
        if (simpleDTO.getClass().equals(StoredTemplateMetadataDTO.class)){
            StoredTemplateMetadataDTO dto = (StoredTemplateMetadataDTO) simpleDTO;
            if (dto.getOwnerId() != null) if (!dto.getOwnerId().equals(0L)) dto.setOwner(getUserService.execute(dto.getOwnerId()));
            if (dto.getMethodologyId() != null) if (!dto.getMethodologyId().equals(0L)) dto.setMethodology(getMethodologyService.execute(dto.getMethodologyId()));
            dto.setReviews(getTemplateReviewsService.execute(dto.getId()));
            return dto;
        }
        if (simpleDTO.getClass().equals(StoredTemplateDTO.class)){
            StoredTemplateDTO dto = (StoredTemplateDTO) simpleDTO;
            if (dto.getOwnerId() != null) if (!dto.getOwnerId().equals(0L)) dto.setOwner(getUserService.execute(dto.getOwnerId()));
            if (dto.getMethodologyId() != null) if (!dto.getMethodologyId().equals(0L)) dto.setMethodology(getMethodologyService.execute(dto.getMethodologyId()));
            dto.setReviews(getTemplateReviewsService.execute(dto.getId()));
            return dto;
        }
        if (simpleDTO.getClass().equals(TemplateReviewDTO.class)){
            TemplateReviewDTO dto = (TemplateReviewDTO) simpleDTO;
            if (dto.getReviewerId() != null) if (!dto.getReviewerId().equals(0L)) dto.setReviewer(getUserService.execute(dto.getReviewerId()));
            if (dto.getTemplateId() != null) if (!dto.getTemplateId().equals(0L)) dto.setTemplate(getStoredTemplateMetadataService.execute(dto.getTemplateId()));
            return dto;
        }
        if (simpleDTO.getClass().equals(UserDTO.class)){
            UserDTO dto = (UserDTO) simpleDTO;
            if (dto.getAvatarId() != null) if (!dto.getAvatarId().equals(0L)) dto.setAvatar(getAvatarService.execute(dto.getAvatarId()));
            dto.setTeacherClassrooms(getTeacherClassroomsService.execute(dto.getId()));
            dto.setStudentClassrooms(getStudentClassroomsService.execute(dto.getId()));
            dto.setStudentRewards(getStudentRewardsService.execute(dto.getId(), "ANY"));
            return dto;
        }
        if (simpleDTO.getClass().equals(ActivityDTO.class)){
            ActivityDTO dto = (ActivityDTO) simpleDTO;
            if (dto.getLessonId() != null) if (!dto.getLessonId().equals(0L)) dto.setLesson(getLessonService.execute(dto.getLessonId()));
            dto.setDocuments(getSourcesDocumentsService.execute(dto.getId(), "ACTIVITY"));
            dto.setRewards(getTargetRewardsService.execute(dto.getId()));
            dto.setStudentsProgress(getActivityStudentsProgressService.execute(dto.getId()));
            return dto;
        }
        if (simpleDTO.getClass().equals(LessonDTO.class)){
            LessonDTO dto = (LessonDTO) simpleDTO;
            if (dto.getProjectId() != null) if (!dto.getProjectId().equals(0L)) dto.setProject(getProjectService.execute(dto.getProjectId()));
            dto.setDocuments(getSourcesDocumentsService.execute(dto.getId(), "LESSON"));
            dto.setStudentsProgress(getLessonStudentsProgressService.execute(dto.getId()));
            dto.setActivities(getLessonActivitiesService.execute(dto.getId()));
            return dto;
        }
        if (simpleDTO.getClass().equals(ProjectDTO.class)){
            ProjectDTO dto = (ProjectDTO) simpleDTO;
            if (dto.getMethodologyId() != null) if (!dto.getMethodologyId().equals(0L)) dto.setMethodology(getMethodologyService.execute(dto.getMethodologyId()));
            if (dto.getClassroomId() != null) if (!dto.getClassroomId().equals(0L)) dto.setClassroom(getClassroomService.execute(dto.getClassroomId()));
            dto.setDocuments(getSourcesDocumentsService.execute(dto.getId(), "PROJECT}"));
            dto.setRewards(getTargetRewardsService.execute(dto.getId()));
            dto.setStudentsProgress(getProjectStudentsProgressService.execute(dto.getId()));
            dto.setLessons(getProjectLessonsService.execute(dto.getId()));
            dto.setGroups(getProjectGroupsService.execute(dto.getId()));
            return dto;
        }
        if (simpleDTO.getClass().equals(ClassroomDTO.class)){
            ClassroomDTO dto = (ClassroomDTO) simpleDTO;
            if (dto.getTeacherId() != null) if (!dto.getTeacherId().equals(0L)) dto.setTeacher(getUserService.execute(dto.getTeacherId()));
            dto.setDocuments(getSourcesDocumentsService.execute(dto.getId(), "CLASSROOM"));
            dto.setRewards(getTargetRewardsService.execute(dto.getId()));
            dto.setStudentsProgress(getClassroomStudentsProgressService.execute(dto.getId()));
            dto.setProjects(getClassroomProjectsService.execute(dto.getId()));
            dto.setStudents(getClassroomStudentsService.execute(dto.getId()));
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
            if (dto.getMethodologyId() != null) if (!dto.getMethodologyId().equals(0L)) dto.setMethodology(getMethodologyService.execute(dto.getMethodologyId()));
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
        switch (DocumentSourceType.valueOf(documentSourceType)){
            case CLASSROOM: return getClassroomService.execute(sourceId);
            case PROJECT: return getProjectService.execute(sourceId);
            case LESSON: return getLessonService.execute(sourceId);
            case ACTIVITY: return getActivityService.execute(sourceId);
            case STUDENT_CLASSROOM: return getStudentClassroomProgressService.execute(sourceId);
            case STUDENT_PROJECT: return getStudentProjectProgressService.execute(sourceId);
            case STUDENT_ACTIVITY: return getStudentActivityProgressService.execute(sourceId);
        }
        return null;
    }

    private Object getRewardTarget(Long targetId, String targetType) {
        switch (TargetType.valueOf(targetType)){
            case CLASSROOM: return getClassroomService.execute(targetId);
            case PROJECT: return getProjectService.execute(targetId);
            case ACTIVITY: return getActivityService.execute(targetId);
        }
        return null;
    }

}
