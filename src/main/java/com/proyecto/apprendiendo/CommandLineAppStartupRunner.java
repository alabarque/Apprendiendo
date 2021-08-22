package com.proyecto.apprendiendo;

import com.proyecto.apprendiendo.entities.dtos.ClassroomDTO;
import com.proyecto.apprendiendo.entities.dtos.ProjectNewDTO;
import com.proyecto.apprendiendo.entities.dtos.StudentDTO;
import com.proyecto.apprendiendo.entities.dtos.UserLoginDTO;
import com.proyecto.apprendiendo.entities.enums.UserType;
import com.proyecto.apprendiendo.services.abm_services.avatar_body_part_services.CreateAvatarBodyPartService;
import com.proyecto.apprendiendo.services.abm_services.avatar_services.CreateAvatarService;
import com.proyecto.apprendiendo.services.abm_services.classroom_services.CreateClassroomService;
import com.proyecto.apprendiendo.services.abm_services.classroom_services.GetClassroomService;
import com.proyecto.apprendiendo.services.abm_services.classroom_user_services.AddClassroomStudentsService;
import com.proyecto.apprendiendo.services.abm_services.classroom_user_services.GetClassroomStudentsService;
import com.proyecto.apprendiendo.services.abm_services.project_services.CreateProjectService;
import com.proyecto.apprendiendo.services.abm_services.project_user_services.AddProjectStudentsService;
import com.proyecto.apprendiendo.services.abm_services.project_user_services.GetProjectStudentsService;
import com.proyecto.apprendiendo.services.abm_services.user_services.CreateUserService;
import com.proyecto.apprendiendo.services.abm_services.user_services.GetStudentService;
import com.proyecto.apprendiendo.services.abm_services.user_services.GetUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {
    @Autowired
    private CreateUserService createUserService;
    @Autowired
    private CreateClassroomService createClassroomService;
    @Autowired
    private CreateProjectService createProjectService;
    @Autowired
    private CreateAvatarService createAvatarService;
    @Autowired
    private CreateAvatarBodyPartService createAvatarBodyPartService;
    @Autowired
    private GetUserService getUserService;
    @Autowired
    private GetClassroomService getClassroomService;
    @Autowired
    private GetProjectStudentsService getProjectStudentsService;
    @Autowired
    private AddProjectStudentsService updateProjectStudentsService;
    @Autowired
    private GetClassroomStudentsService getClassroomStudentsService;
    @Autowired
    private AddClassroomStudentsService updateClassroomStudentsService;
    @Autowired
    private GetStudentService getStudentService;

    @Override
    public void run(String...args) {

        Long adminId = createUserService.execute(UserLoginDTO.builder().username("admin").password("admin").build(),UserType.ADMIN);
        Long andreaId = createUserService.execute(UserLoginDTO.builder().username("andrea").password("andrea").build(),UserType.TEACHER);
        Long pabloId = createUserService.execute(UserLoginDTO.builder().username("pablo").password("pablo").build(),UserType.TEACHER);
        Long javiId = createUserService.execute(UserLoginDTO.builder().username("javi").password("javi").build(),UserType.STUDENT);
        Long agusId = createUserService.execute(UserLoginDTO.builder().username("agus").password("agus").build(),UserType.STUDENT);
        Long nazaId = createUserService.execute(UserLoginDTO.builder().username("naza").password("naza").build(),UserType.STUDENT);
        Long paoId = createUserService.execute(UserLoginDTO.builder().username("pao").password("pao").build(),UserType.STUDENT);
        Long mariId = createUserService.execute(UserLoginDTO.builder().username("mari").password("mari").build(),UserType.STUDENT);

        Long superCursoId = createClassroomService.execute(ClassroomDTO.builder().name("super curso").teacherId(andreaId).build());
        Long superCurso2Id = createClassroomService.execute(ClassroomDTO.builder().name("mega curso").teacherId(pabloId).build());

        Long superProyectoId = createProjectService.execute(ProjectNewDTO.builder().challengeId(Integer.toUnsignedLong(0)).name("super proyecto").methodologyId(Integer.toUnsignedLong(0)).build(), superCursoId);
        Long ultraProyectoId = createProjectService.execute(ProjectNewDTO.builder().challengeId(Integer.toUnsignedLong(0)).name("ultra proyecto").methodologyId(Integer.toUnsignedLong(0)).build(),superCurso2Id);
        Long megaProyectoId = createProjectService.execute(ProjectNewDTO.builder().challengeId(Integer.toUnsignedLong(0)).name("mega proyecto").methodologyId(Integer.toUnsignedLong(0)).build(),superCurso2Id);


        ArrayList<StudentDTO> estudiantesSuperCurso = new ArrayList<>();
        estudiantesSuperCurso.add(getStudentService.execute(javiId));
        estudiantesSuperCurso.add(getStudentService.execute(agusId));
        estudiantesSuperCurso.add(getStudentService.execute(nazaId));
        estudiantesSuperCurso.add(getStudentService.execute(paoId));

        ArrayList<StudentDTO> estudiantesSuperProyecto = new ArrayList<>();
        estudiantesSuperProyecto.add(getStudentService.execute(javiId));
        estudiantesSuperProyecto.add(getStudentService.execute(agusId));

        ArrayList<StudentDTO> estudiantesCurso2 = new ArrayList<>();
        estudiantesCurso2.add(getStudentService.execute(mariId));
        estudiantesCurso2.add(getStudentService.execute(paoId));
        estudiantesCurso2.add(getStudentService.execute(nazaId));

        ArrayList<StudentDTO> estudiantesUltraProyecto = new ArrayList<>();
        estudiantesUltraProyecto.add(getStudentService.execute(paoId));
        estudiantesUltraProyecto.add(getStudentService.execute(nazaId));

        ArrayList<StudentDTO> estudiantesMegaProyecto = new ArrayList<>();
        estudiantesMegaProyecto.add(getStudentService.execute(mariId));
        estudiantesMegaProyecto.add(getStudentService.execute(paoId));

        updateClassroomStudentsService.execute(superCursoId,estudiantesSuperCurso);
        updateProjectStudentsService.execute(superProyectoId,estudiantesSuperProyecto);

        updateClassroomStudentsService.execute(superCurso2Id,estudiantesCurso2);
        updateProjectStudentsService.execute(megaProyectoId,estudiantesMegaProyecto);
        updateProjectStudentsService.execute(ultraProyectoId,estudiantesUltraProyecto);
    }
}