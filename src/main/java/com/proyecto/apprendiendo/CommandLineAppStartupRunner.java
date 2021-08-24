package com.proyecto.apprendiendo;

import com.proyecto.apprendiendo.entities.dtos.*;
import com.proyecto.apprendiendo.entities.enums.UserType;
import com.proyecto.apprendiendo.services.abm_services.avatar_body_part_services.CreateAvatarBodyPartService;
import com.proyecto.apprendiendo.services.abm_services.avatar_services.CreateAvatarService;
import com.proyecto.apprendiendo.services.abm_services.classroom_services.CreateClassroomService;
import com.proyecto.apprendiendo.services.abm_services.classroom_services.GetClassroomService;
import com.proyecto.apprendiendo.services.abm_services.classroom_user_services.AddClassroomStudentsService;
import com.proyecto.apprendiendo.services.abm_services.classroom_user_services.GetClassroomStudentsService;
import com.proyecto.apprendiendo.services.abm_services.methodology_services.CreateMethodologyService;
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
    private GetClassroomStudentsService getClassroomStudentsService;
    @Autowired
    private AddClassroomStudentsService addClassroomStudentsService;
    @Autowired
    private GetStudentService getStudentService;
    @Autowired
    private CreateMethodologyService createMethodologyService;

    @Override
    public void run(String...args) {

        Long proyectoMethodologyId = createMethodologyService.execute(MethodologyDTO.builder().name("Proyecto").build());
        Long aulaInvertidaMethodologyId = createMethodologyService.execute(MethodologyDTO.builder().name("Aula Invertida").build());

        Long adminId = createUserService.execute(UserLoginDTO.builder().username("admin").password("admin").build(),UserType.ADMIN);
        Long andreaId = createUserService.execute(UserLoginDTO.builder().username("andrea").password("andrea").build(),UserType.TEACHER);
        Long pabloId = createUserService.execute(UserLoginDTO.builder().username("pablo").password("pablo").build(),UserType.TEACHER);
        Long javiId = createUserService.execute(UserLoginDTO.builder().username("javi").password("javi").build(),UserType.STUDENT);
        Long agusId = createUserService.execute(UserLoginDTO.builder().username("agus").password("agus").build(),UserType.STUDENT);
        Long nazaId = createUserService.execute(UserLoginDTO.builder().username("naza").password("naza").build(),UserType.STUDENT);
        Long paoId = createUserService.execute(UserLoginDTO.builder().username("pao").password("pao").build(),UserType.STUDENT);
        Long mariId = createUserService.execute(UserLoginDTO.builder().username("mari").password("mari").build(),UserType.STUDENT);

        Long mateCursoId = createClassroomService.execute(ClassroomDTO.builder().teacherId(andreaId).division("A").year(3).subject("Matematica").build());
        Long lenguaCursoId = createClassroomService.execute(ClassroomDTO.builder().teacherId(andreaId).division("A").year(3).subject("Lengua").build());
        Long naturalesCursoId = createClassroomService.execute(ClassroomDTO.builder().teacherId(andreaId).division("B").year(3).subject("Naturales").build());
        Long socialesCursoId = createClassroomService.execute(ClassroomDTO.builder().teacherId(pabloId).division("B").year(3).subject("Sociales").build());

        Long ProyectoN1Id = createProjectService.execute(ProjectNewDTO.builder().challengeId(Integer.toUnsignedLong(0)).name("Aula Invertida: Dinosaurios").methodologyId(aulaInvertidaMethodologyId).build(), naturalesCursoId);
        Long ProyectoN2Id = createProjectService.execute(ProjectNewDTO.builder().challengeId(Integer.toUnsignedLong(0)).name("Aula Invertida: Planetas ").methodologyId(aulaInvertidaMethodologyId).build(),naturalesCursoId);
        Long ProyectoN3Id = createProjectService.execute(ProjectNewDTO.builder().challengeId(Integer.toUnsignedLong(0)).name("Proyecto: Los Atomos").methodologyId(proyectoMethodologyId).build(),naturalesCursoId);
        Long ProyectoS4Id = createProjectService.execute(ProjectNewDTO.builder().challengeId(Integer.toUnsignedLong(0)).name("Projecto: San Martin").methodologyId(proyectoMethodologyId).build(),socialesCursoId);
        Long ProyectoS5Id = createProjectService.execute(ProjectNewDTO.builder().challengeId(Integer.toUnsignedLong(0)).name("Proyecto: El Cabildo").methodologyId(proyectoMethodologyId).build(),socialesCursoId);
        Long ProyectoM6Id = createProjectService.execute(ProjectNewDTO.builder().challengeId(Integer.toUnsignedLong(0)).name("Aula Invertida: Division").methodologyId(aulaInvertidaMethodologyId).build(),mateCursoId);
        Long ProyectoM7Id = createProjectService.execute(ProjectNewDTO.builder().challengeId(Integer.toUnsignedLong(0)).name("Proyecto: Multiplicacion").methodologyId(proyectoMethodologyId).build(),mateCursoId);
        Long ProyectoL8Id = createProjectService.execute(ProjectNewDTO.builder().challengeId(Integer.toUnsignedLong(0)).name("Aula Invertida: Oraciones").methodologyId(aulaInvertidaMethodologyId).build(),lenguaCursoId);
        Long ProyectoL9Id = createProjectService.execute(ProjectNewDTO.builder().challengeId(Integer.toUnsignedLong(0)).name("Proyecto: Gramatica").methodologyId(proyectoMethodologyId).build(),lenguaCursoId);


        ArrayList<StudentDTO> estudiantesMate = new ArrayList<>();
        estudiantesMate.add(getStudentService.execute(javiId));
        estudiantesMate.add(getStudentService.execute(agusId));
        estudiantesMate.add(getStudentService.execute(nazaId));
        estudiantesMate.add(getStudentService.execute(paoId));

        ArrayList<StudentDTO> estudiantesLengua = new ArrayList<>();
        estudiantesLengua.add(getStudentService.execute(mariId));
        estudiantesLengua.add(getStudentService.execute(paoId));
        estudiantesLengua.add(getStudentService.execute(nazaId));

        ArrayList<StudentDTO> estudiantesNaturales = new ArrayList<>();
        estudiantesNaturales.add(getStudentService.execute(mariId));
        estudiantesNaturales.add(getStudentService.execute(paoId));
        estudiantesNaturales.add(getStudentService.execute(nazaId));

        ArrayList<StudentDTO> estudiantesSociales = new ArrayList<>();
        estudiantesSociales.add(getStudentService.execute(mariId));
        estudiantesSociales.add(getStudentService.execute(paoId));
        estudiantesSociales.add(getStudentService.execute(nazaId));


        addClassroomStudentsService.execute(mateCursoId,estudiantesMate);

        addClassroomStudentsService.execute(naturalesCursoId,estudiantesNaturales);

        addClassroomStudentsService.execute(lenguaCursoId,estudiantesLengua);

        addClassroomStudentsService.execute(socialesCursoId,estudiantesSociales);

    }
}