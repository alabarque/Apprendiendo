package com.proyecto.apprendiendo;

import com.proyecto.apprendiendo.entities.dtos.*;
import com.proyecto.apprendiendo.entities.enums.ConditionType;
import com.proyecto.apprendiendo.entities.enums.RewardType;
import com.proyecto.apprendiendo.entities.enums.TargetType;
import com.proyecto.apprendiendo.entities.enums.UserType;
import com.proyecto.apprendiendo.repositories.*;
import com.proyecto.apprendiendo.services.general_services.activity_services.CreateActivityService;
import com.proyecto.apprendiendo.services.general_services.avatar_services.CreateAvatarService;
import com.proyecto.apprendiendo.services.general_services.classroom_services.CreateClassroomService;
import com.proyecto.apprendiendo.services.general_services.classroom_services.GetClassroomService;
import com.proyecto.apprendiendo.services.general_services.classroom_user_services.AddClassroomStudentsService;
import com.proyecto.apprendiendo.services.general_services.classroom_user_services.GetClassroomStudentsService;
import com.proyecto.apprendiendo.services.general_services.condition_services.CreateConditionService;
import com.proyecto.apprendiendo.services.general_services.document_services.CreateDocumentService;
import com.proyecto.apprendiendo.services.general_services.group_services.CreateGroupService;
import com.proyecto.apprendiendo.services.general_services.group_student_services.AddGroupStudentService;
import com.proyecto.apprendiendo.services.general_services.group_student_services.GetProjectStudentGroupService;
import com.proyecto.apprendiendo.services.general_services.lesson_services.CreateLessonService;
import com.proyecto.apprendiendo.services.general_services.lesson_services.GetLessonService;
import com.proyecto.apprendiendo.services.general_services.lesson_services.GetLessonStudentsProgressService;
import com.proyecto.apprendiendo.services.general_services.methodology_services.CreateMethodologyService;
import com.proyecto.apprendiendo.services.general_services.project_services.CreateProjectFromTemplateService;
import com.proyecto.apprendiendo.services.general_services.project_services.CreateProjectService;
import com.proyecto.apprendiendo.services.general_services.project_services.GetProjectService;
import com.proyecto.apprendiendo.services.general_services.project_services.GetProjectTemplateByMethodologyIdService;
import com.proyecto.apprendiendo.services.general_services.reward_services.CreateRewardService;
import com.proyecto.apprendiendo.services.general_services.statistics_services.GetActivitiesStatisticsService;
import com.proyecto.apprendiendo.services.general_services.statistics_services.GetProjectsStatisticsService;
import com.proyecto.apprendiendo.services.general_services.student_activity_services.UpdateStudentActivityProgressService;
import com.proyecto.apprendiendo.services.general_services.student_project_services.GetProjectStudentsProgressService;
import com.proyecto.apprendiendo.services.general_services.student_project_services.GetProjectStudentsService;
import com.proyecto.apprendiendo.services.general_services.student_project_services.UpdateStudentProjectProgressService;
import com.proyecto.apprendiendo.services.general_services.student_reward_services.AddRewardStudentService;
import com.proyecto.apprendiendo.services.general_services.user_services.CreateUserService;
import com.proyecto.apprendiendo.services.general_services.user_services.GetStudentService;
import com.proyecto.apprendiendo.services.general_services.user_services.GetUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import com.google.gson.*;

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
    @Autowired
    private CreateActivityService createActivityService;
    @Autowired
    private CreateDocumentService createDocumentService;
    @Autowired
    private CreateLessonService createLessonService;
    @Autowired
    private CreateProjectFromTemplateService createProjectFromTemplateService;
    @Autowired
    private GetProjectTemplateByMethodologyIdService getProjectTemplateByMethodologyIdService;
    @Autowired
    private UpdateStudentActivityProgressService updateStudentActivityProgressService;
    @Autowired
    private StudentActivityRepository studentActivityRepository;
    @Autowired
    private ActivityRepository activityRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LessonRepository lessonRepository;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private ClassroomRepository classroomRepository;
    @Autowired
    private StudentClassroomRepository studentClassroomRepository;
    @Autowired
    private GetLessonService getLessonService;
    @Autowired
    private GetProjectService getProjectService;
    @Autowired
    private GetLessonStudentsProgressService getLessonStudentsProgressService;
    @Autowired
    private CreateRewardService createRewardService;
    @Autowired
    private CreateConditionService createConditionService;
    @Autowired
    private UpdateStudentProjectProgressService updateStudentProjectProgressService;
    @Autowired
    private AddRewardStudentService addRewardStudentService;
    @Autowired
    private GetActivitiesStatisticsService getActivitiesStatisticsService;
    @Autowired
    private GetProjectsStatisticsService getProjectsStatisticsService;
    @Autowired
    private GetProjectStudentsProgressService getProjectStudentsProgressService;
    @Autowired
    private CreateGroupService createGroupService;
    @Autowired
    private GetProjectStudentGroupService getProjectStudentGroupService;
    @Autowired
    private AddGroupStudentService addGroupStudentService;


    @Override
    public void run(String... args) {
        //METODOLOGIAS
        Long proyectoMethodologyId = createMethodologyService.execute(MethodologyDTO.builder()
                                                                                    .name("Basada en Proyectos")
                                                                                    .build());
        Long aulaInvertidaMethodologyId = createMethodologyService.execute(MethodologyDTO.builder()
                                                                                         .name("Aula Invertida")
                                                                                         .build());
        Long pensamientoMethodologyId = createMethodologyService.execute(MethodologyDTO.builder()
                                                                                       .name("Basada en el Pensamiento")
                                                                                       .build());
        Long estandarMethodologyId = createMethodologyService.execute(MethodologyDTO.builder()
                                                                                    .name("Proyecto Estandar")
                                                                                    .build());


        //TEMPLATE: AULA INVERTIDA
        Long proyectoTemplateAulaInvertidaId = createProjectService.execute(ProjectDTO.builder()
                                                                                      .classroomId(0L)
                                                                                      .name("Nuevo Proyecto de Aula Invertida")
                                                                                      .description("Este es un proyecto con la metodologia de Aula Invertida")
                                                                                      .methodologyId(aulaInvertidaMethodologyId)
                                                                                      .active(Boolean.TRUE)
                                                                                      .build());

        Long templateAulaInvertidaClase1Id = createLessonService.execute(LessonDTO.builder()
                                                                                  .name("Clase 1")
                                                                                  .position(1)
                                                                                  .projectId(proyectoTemplateAulaInvertidaId)
                                                                                  .active(Boolean.TRUE)
                                                                                  .build());
        Long templateAulaInvertidaClase1ActivityId = createActivityService.execute(ActivityDTO.builder()
                                                                                              .name("Clase 1")
                                                                                              .lessonId(templateAulaInvertidaClase1Id)
                                                                                              .build());
        createDocumentService.execute(NewDocumentDTO.builder()
                                                    .dataType("TEXT")
                                                    .name("Descripcion: Clase 1")
                                                    .data("la descripcion del primer dia de aula invertida va aca")
                                                    .sourceId(templateAulaInvertidaClase1ActivityId)
                                                    .documentSourceType("ACTIVITY")
                                                    .build());
        Long templateAulaInvertidaClase2Id = createLessonService.execute(LessonDTO.builder()
                                                                                  .name("Clase 2")
                                                                                  .position(2)
                                                                                  .projectId(proyectoTemplateAulaInvertidaId)
                                                                                  .active(Boolean.TRUE)
                                                                                  .build());
        Long templateAulaInvertidaClase2ActivityId = createActivityService.execute(ActivityDTO.builder()
                                                                                              .name("Clase 2")
                                                                                              .lessonId(templateAulaInvertidaClase2Id)
                                                                                              .build());
        createDocumentService.execute(NewDocumentDTO.builder()
                                                    .dataType("TEXT")
                                                    .name("Descripcion: Clase 2")
                                                    .data("la descripcion del segundo dia de aula invertida va aca")
                                                    .sourceId(templateAulaInvertidaClase2ActivityId)
                                                    .documentSourceType("ACTIVITY")
                                                    .build());


        //TEMPLATE: PBL
        Long proyectoTemplatePBLId = createProjectService.execute(ProjectDTO.builder()
                                                                            .classroomId(0L)
                                                                            .name("Nuevo Proyecto de PBL")
                                                                            .description("Este es un proyecto con la metodologia de PBL")
                                                                            .methodologyId(proyectoMethodologyId)
                                                                            .active(Boolean.TRUE)
                                                                            .build());

        Long templatePBLClase1Id = createLessonService.execute(LessonDTO.builder()
                                                                        .name("Clase 1")
                                                                        .position(1)
                                                                        .projectId(proyectoTemplatePBLId)
                                                                        .active(Boolean.TRUE)
                                                                        .build());
        Long templatePBLClase1ActivityId = createActivityService.execute(ActivityDTO.builder()
                                                                                    .name("Actividad 1")
                                                                                    .lessonId(templatePBLClase1Id)
                                                                                    .build());
        createDocumentService.execute(NewDocumentDTO.builder()
                                                    .dataType("TEXT")
                                                    .name("Pregunta inicial")
                                                    .data(" En esta etapa, el docente selecciona un tema que esté \nligado a la realidad de los alumnos, y debe plantear una \npregunta abierta que despierte su interés y los motive a \naprender.\n El objetivo en este punto es detectar conocimientos \nprevios y que el alumno  piense qué debe investigar  y cómo\nresolver la cuestión. \\n Mediante la opción \\\"Adjuntar Material\\\" puede proporcionar\\nel material que crea conveniente a sus alumnos, tales como \\ndocumentos en formato word, excel, pdf, o incluso videos!\n\n¿Qué pregunta desea plantear?:")
                                                    .sourceId(templatePBLClase1ActivityId)
                                                    .documentSourceType("ACTIVITY")
                                                    .build());
        Long templatePBLClase2Id = createLessonService.execute(LessonDTO.builder()
                                                                        .name("Clase 2")
                                                                        .position(2)
                                                                        .projectId(proyectoTemplatePBLId)
                                                                        .active(Boolean.TRUE)
                                                                        .build());
        Long templatePBLClase2ActivityId = createActivityService.execute(ActivityDTO.builder()
                                                                                    .name("Actividad 1")
                                                                                    .lessonId(templatePBLClase2Id)
                                                                                    .build());
        createDocumentService.execute(NewDocumentDTO.builder()
                                                    .dataType("TEXT")
                                                    .name("Formando Equipos")
                                                    .data(" En base a las respuestas obtenidas en la clase \nanterior, el docente deberá formar equipos de 3 o 4\nintegrantes con diversidad de perfiles. Dándoles la \nposibilidad de que cada uno desempeñe un rol.\n También se definirá cuál es el producto o proyecto final \nque los alumnos desarrollaran en función de las \ncompetencias que se quieran alcanzar(Puede ser un folleto,\nuna presentación, una investigación científica). Se \nrecomienda que se les proporciones las rúbricas donde \nfiguren los objetivos a alcanzar y cómo se los va a \nevaluar.\n\nIngrese en el siguiente box la comunicación a los alumnos\nsobre el producto a desarrollar\\n Mediante la opción \\\"Crear equipos\\\" puede definir los \\nintegrantes de cada equipo y asignarles un nombre. Esto \\npermitirá que los alumnos colaboren y compartan tareas.")
                                                    .sourceId(templatePBLClase2ActivityId)
                                                    .documentSourceType("ACTIVITY")
                                                    .build());
        Long templatePBLClase3Id = createLessonService.execute(LessonDTO.builder()
                                                                        .name("Clase 3")
                                                                        .position(3)
                                                                        .projectId(proyectoTemplatePBLId)
                                                                        .active(Boolean.TRUE)
                                                                        .build());
        Long templatePBLClase3ActivityId = createActivityService.execute(ActivityDTO.builder()
                                                                                    .name("Actividad 1")
                                                                                    .lessonId(templatePBLClase3Id)
                                                                                    .build());
        createDocumentService.execute(NewDocumentDTO.builder()
                                                    .dataType("TEXT")
                                                    .name("Planificacion")
                                                    .data(" En esta clase se les pide a los alumnos  que armen un \nplan de trabajo, donde presenten las tareas previstas, \nel encargado de realizarlas y las fechas de resolución \nesperadas.\nEsta clase contará con un box de entregas para que los \nalumnos puedan subir el plan que crearon. Recuerde que a\npartir de esta clase, las entregas son por equipo!\nPuede ingresar un texto en el siguiente cuadro que se \nvisualizará en la pantalla de los alumnos junto con la \nconsigna mencionada anteriormente: ")
                                                    .sourceId(templatePBLClase3ActivityId)
                                                    .documentSourceType("ACTIVITY")
                                                    .build());
        Long templatePBLClase4Id = createLessonService.execute(LessonDTO.builder()
                                                                        .name("Clase 4")
                                                                        .position(4)
                                                                        .projectId(proyectoTemplatePBLId)
                                                                        .active(Boolean.TRUE)
                                                                        .build());
        Long templatePBLClase4ActivityId = createActivityService.execute(ActivityDTO.builder()
                                                                                    .name("Actividad 1")
                                                                                    .lessonId(templatePBLClase4Id)
                                                                                    .build());
        createDocumentService.execute(NewDocumentDTO.builder()
                                                    .dataType("TEXT")
                                                    .name("Investigacion")
                                                    .data("la descripcion del cuarto dia del PBL va aca")
                                                    .sourceId(templatePBLClase4ActivityId)
                                                    .documentSourceType("ACTIVITY")
                                                    .build());
        Long templatePBLClase5Id = createLessonService.execute(LessonDTO.builder()
                                                                        .name("Clase 5")
                                                                        .position(5)
                                                                        .projectId(proyectoTemplatePBLId)
                                                                        .active(Boolean.TRUE)
                                                                        .build());
        Long templatePBLClase5ActivityId = createActivityService.execute(ActivityDTO.builder()
                                                                                    .name("Actividad 1")
                                                                                    .lessonId(templatePBLClase5Id)
                                                                                    .build());
        createDocumentService.execute(NewDocumentDTO.builder()
                                                    .dataType("TEXT")
                                                    .name("Puesta en comun y Debate")
                                                    .data("la descripcion del quinto dia del PBL va aca")
                                                    .sourceId(templatePBLClase5ActivityId)
                                                    .documentSourceType("ACTIVITY")
                                                    .build());
        Long templatePBLClase6Id = createLessonService.execute(LessonDTO.builder()
                                                                        .name("Clase 6")
                                                                        .position(6)
                                                                        .projectId(proyectoTemplatePBLId)
                                                                        .active(Boolean.TRUE)
                                                                        .build());
        Long templatePBLClase6ActivityId = createActivityService.execute(ActivityDTO.builder()
                                                                                    .name("Actividad 1")
                                                                                    .lessonId(templatePBLClase6Id)
                                                                                    .build());
        createDocumentService.execute(NewDocumentDTO.builder()
                                                    .dataType("TEXT")
                                                    .name("Elaboracion del producto")
                                                    .data("la descripcion del sexto dia del PBL va aca")
                                                    .sourceId(templatePBLClase6ActivityId)
                                                    .documentSourceType("ACTIVITY")
                                                    .build());
        Long templatePBLClase7Id = createLessonService.execute(LessonDTO.builder()
                                                                        .name("Clase 7")
                                                                        .position(7)
                                                                        .projectId(proyectoTemplatePBLId)
                                                                        .active(Boolean.TRUE)
                                                                        .build());
        Long templatePBLClase7ActivityId = createActivityService.execute(ActivityDTO.builder()
                                                                                    .name("Actividad 1")
                                                                                    .lessonId(templatePBLClase7Id)
                                                                                    .build());
        createDocumentService.execute(NewDocumentDTO.builder()
                                                    .dataType("TEXT")
                                                    .name("Presentacion del Producto")
                                                    .data("la descripcion del septimo dia del PBL va aca")
                                                    .sourceId(templatePBLClase7ActivityId)
                                                    .documentSourceType("ACTIVITY")
                                                    .build());


        //TEMPLATE: TBL
        Long proyectoTemplateTBLId = createProjectService.execute(ProjectDTO.builder()
                                                                            .classroomId(0L)
                                                                            .name("Nuevo Proyecto de TBL")
                                                                            .description("Este es un proyecto con la metodologia de TBL")
                                                                            .methodologyId(pensamientoMethodologyId)
                                                                            .active(Boolean.TRUE)
                                                                            .build());

        Long templateTBLClase1Id = createLessonService.execute(LessonDTO.builder()
                                                                        .name("Clase 1")
                                                                        .position(1)
                                                                        .projectId(proyectoTemplateTBLId)
                                                                        .active(Boolean.TRUE)
                                                                        .build());
        Long templateTBLClase1ActivityId = createActivityService.execute(ActivityDTO.builder()
                                                                                    .name("Actividad 1")
                                                                                    .lessonId(templateTBLClase1Id)
                                                                                    .build());
        createDocumentService.execute(NewDocumentDTO.builder()
                                                    .dataType("TEXT")
                                                    .name("Descripcion: Clase 1")
                                                    .data("la descripcion del primer dia del TBL va aca")
                                                    .sourceId(templateTBLClase1ActivityId)
                                                    .documentSourceType("ACTIVITY")
                                                    .build());
        Long templateTBLClase2Id = createLessonService.execute(LessonDTO.builder()
                                                                        .name("Clase 2")
                                                                        .position(2)
                                                                        .projectId(proyectoTemplateTBLId)
                                                                        .active(Boolean.TRUE)
                                                                        .build());
        Long templateTBLClase2ActivityId = createActivityService.execute(ActivityDTO.builder()
                                                                                    .name("Actividad 2")
                                                                                    .lessonId(templateTBLClase2Id)
                                                                                    .build());
        createDocumentService.execute(NewDocumentDTO.builder()
                                                    .dataType("TEXT")
                                                    .name("Descripcion: Clase 2")
                                                    .data("la descripcion del segundo dia del TBL va aca")
                                                    .sourceId(templateTBLClase2ActivityId)
                                                    .documentSourceType("ACTIVITY")
                                                    .build());


        //INSTANCIACION TEMPLATES
        ProjectTemplateDTO pblTemplate = getProjectTemplateByMethodologyIdService.execute(proyectoMethodologyId);
        ProjectTemplateDTO invertedTemplate = getProjectTemplateByMethodologyIdService.execute(aulaInvertidaMethodologyId);
        ProjectTemplateDTO tblTemplate = getProjectTemplateByMethodologyIdService.execute(pensamientoMethodologyId);


        //INICIALIZACION DE TEMPLATES
        pblTemplate.setStartDate(LocalDateTime.now());
        pblTemplate.setDueDate(LocalDateTime.now().plusDays(7));
        pblTemplate.setPosition(0);

        tblTemplate.setStartDate(LocalDateTime.now());
        pblTemplate.setDueDate(LocalDateTime.now().plusDays(7));
        pblTemplate.setPosition(0);

        invertedTemplate.setStartDate(LocalDateTime.now());
        pblTemplate.setDueDate(LocalDateTime.now().plusDays(7));
        pblTemplate.setPosition(0);


        AvatarDTO avatarDTO = AvatarDTO.builder()
                                       .name("pepito")
                                       .body("b0001")
                                       .glasses("")
                                       .clothes("")
                                       .hat("")
                                       .build();


        //USUARIOS
        Long adminId = createUserService.execute(UserDTO.builder()
                                                        .username("admin")
                                                        .firstName("Alfa")
                                                        .lastName("Omega")
                                                        .address("Medrano 951, CABA")
                                                        .homePhone("(011) 1234-5678")
                                                        .mobilePhone("15 1234-5678")
                                                        .password("admin")
                                                        .build(), UserType.ADMIN);
        Long andreaId = createUserService.execute(UserDTO.builder()
                                                         .username("andrea")
                                                         .firstName("Andrea")
                                                         .lastName("Alegretti")
                                                         .address("Medrano 951, CABA")
                                                         .homePhone("(011) 1234-5678")
                                                         .mobilePhone("15 1234-5678")
                                                         .password("andrea")
                                                         .build(), UserType.TEACHER);
        Long pabloId = createUserService.execute(UserDTO.builder()
                                                        .username("pablo")
                                                        .firstName("Pablo")
                                                        .lastName("Abramowicz")
                                                        .address("Medrano 951, CABA")
                                                        .homePhone("(011) 1234-5678")
                                                        .mobilePhone("15 1234-5678")
                                                        .password("pablo")
                                                        .build(), UserType.TEACHER);
        Long javiId = createUserService.execute(UserDTO.builder()
                                                       .username("javi")
                                                       .firstName("Javier Leonardo")
                                                       .lastName("Soto")
                                                       .address("Medrano 951, CABA")
                                                       .homePhone("(011) 1234-5678")
                                                       .mobilePhone("15 1234-5678")
                                                       .password("javi")
                                                       .avatarId(createAvatarService.execute(avatarDTO))
                                                       .studentYear(5)
                                                       .studentDivision("B")
                                                       .build(), UserType.STUDENT);
        Long agusId = createUserService.execute(UserDTO.builder()
                                                       .username("agus")
                                                       .firstName("Agustin")
                                                       .lastName("Labarque")
                                                       .address("Medrano 951, CABA")
                                                       .homePhone("(011) 1234-5678")
                                                       .mobilePhone("15 1234-5678")
                                                       .password("agus")
                                                       .avatarId(createAvatarService.execute(avatarDTO))
                                                       .studentYear(5)
                                                       .studentDivision("B")
                                                       .build(), UserType.STUDENT);
        Long nazaId = createUserService.execute(UserDTO.builder()
                                                       .username("naza")
                                                       .firstName("Nazareno Eduardo")
                                                       .lastName("Anselmi")
                                                       .address("Medrano 951, CABA")
                                                       .homePhone("(011) 1234-5678")
                                                       .mobilePhone("15 1234-5678")
                                                       .password("naza")
                                                       .avatarId(createAvatarService.execute(avatarDTO))
                                                       .studentYear(5)
                                                       .studentDivision("B")
                                                       .build(), UserType.STUDENT);
        Long paoId = createUserService.execute(UserDTO.builder()
                                                      .username("pao")
                                                      .firstName("Paola")
                                                      .lastName("Carrasco")
                                                      .address("Medrano 951, CABA")
                                                      .homePhone("(011) 1234-5678")
                                                      .mobilePhone("15 1234-5678")
                                                      .password("pao")
                                                      .avatarId(createAvatarService.execute(avatarDTO))
                                                      .studentYear(5)
                                                      .studentDivision("B")
                                                      .build(), UserType.STUDENT);
        Long mariId = createUserService.execute(UserDTO.builder()
                                                       .username("mari")
                                                       .firstName("Mariel")
                                                       .lastName("Gaitan")
                                                       .address("Medrano 951, CABA")
                                                       .homePhone("(011) 1234-5678")
                                                       .mobilePhone("15 1234-5678")
                                                       .password("mari")
                                                       .avatarId(createAvatarService.execute(avatarDTO))
                                                       .studentYear(5)
                                                       .studentDivision("B")
                                                       .build(), UserType.STUDENT);

        //CLASSROOMS
        Long mateCursoId = createClassroomService.execute(ClassroomDTO.builder()
                                                                      .teacherId(andreaId)
                                                                      .division("A")
                                                                      .year(3)
                                                                      .subject("Matematica")
                                                                      .build());
        Long lenguaCursoId = createClassroomService.execute(ClassroomDTO.builder()
                                                                        .teacherId(andreaId)
                                                                        .division("A")
                                                                        .year(3)
                                                                        .subject("Lengua")
                                                                        .build());
        Long naturalesCursoId = createClassroomService.execute(ClassroomDTO.builder()
                                                                           .teacherId(andreaId)
                                                                           .division("B")
                                                                           .year(3)
                                                                           .subject("Naturales")
                                                                           .build());
        Long socialesCursoId = createClassroomService.execute(ClassroomDTO.builder()
                                                                          .teacherId(pabloId)
                                                                          .division("B")
                                                                          .year(3)
                                                                          .subject("Sociales")
                                                                          .build());


        //PROYECTOS
        invertedTemplate.setName("Aula Invertida: Dinosaurios");
        invertedTemplate.setClassroomId(naturalesCursoId);
        invertedTemplate.setDueDate(LocalDateTime.now().plusDays(7));
        Long ProyectoN1Id = createProjectFromTemplateService.execute(invertedTemplate);
        invertedTemplate.setName("Aula Invertida: Planetas");
        invertedTemplate.setClassroomId(naturalesCursoId);
        Long ProyectoN2Id = createProjectFromTemplateService.execute(invertedTemplate);
        pblTemplate.setName("Proyecto: Los Atomos");
        pblTemplate.setClassroomId(naturalesCursoId);
        Long ProyectoN3Id = createProjectFromTemplateService.execute(pblTemplate);
        pblTemplate.setName("Projecto: San Martin");
        pblTemplate.setClassroomId(socialesCursoId);
        Long ProyectoN4Id = createProjectFromTemplateService.execute(pblTemplate);
        pblTemplate.setName("Proyecto: El Cabildo");
        pblTemplate.setClassroomId(socialesCursoId);
        Long ProyectoN5Id = createProjectFromTemplateService.execute(pblTemplate);
        invertedTemplate.setName("Aula Invertida: Division");
        invertedTemplate.setClassroomId(mateCursoId);
        Long ProyectoN6Id = createProjectFromTemplateService.execute(invertedTemplate);
        pblTemplate.setName("Proyecto: Multiplicacion");
        pblTemplate.setClassroomId(mateCursoId);
        Long ProyectoN7Id = createProjectFromTemplateService.execute(pblTemplate);
        invertedTemplate.setName("Aula Invertida: Oraciones");
        invertedTemplate.setClassroomId(lenguaCursoId);
        Long ProyectoN8Id = createProjectFromTemplateService.execute(invertedTemplate);
        pblTemplate.setName("Proyecto: Gramatica");
        pblTemplate.setClassroomId(lenguaCursoId);
        Long ProyectoN9Id = createProjectFromTemplateService.execute(pblTemplate);


        //ASIGNACION DE ESTUDIANTES A CLASSROOMS
        addClassroomStudentsService.execute(mateCursoId, javiId);
        addClassroomStudentsService.execute(mateCursoId, agusId);
        addClassroomStudentsService.execute(mateCursoId, nazaId);
        addClassroomStudentsService.execute(mateCursoId, paoId);

        addClassroomStudentsService.execute(lenguaCursoId, mariId);
        addClassroomStudentsService.execute(lenguaCursoId, paoId);
        addClassroomStudentsService.execute(lenguaCursoId, nazaId);

        addClassroomStudentsService.execute(naturalesCursoId, mariId);
        addClassroomStudentsService.execute(naturalesCursoId, paoId);
        addClassroomStudentsService.execute(naturalesCursoId, nazaId);

        addClassroomStudentsService.execute(socialesCursoId, mariId);
        addClassroomStudentsService.execute(socialesCursoId, paoId);
        addClassroomStudentsService.execute(socialesCursoId, nazaId);

        Long condition10ActivitiesId = createConditionService.execute(ConditionDTO.builder()
                                                                                  .conditionType(ConditionType.X_ACTIVITIES_COMPLETED.getValue())
                                                                                  .text("Completar 10 actividades")
                                                                                  .data("10")
                                                                                  .build());


        Long rewardId = createRewardService.execute(RewardDTO.builder()
                                                             .rewardType(RewardType.BADGE.getValue())
                                                             .conditionId(condition10ActivitiesId)
                                                             .text("Completaste 10 actividades maestro!")
                                                             .name("Hiperactivo")
                                                             .build());

        Long conditionAulaInvertidaId = createConditionService.execute(ConditionDTO.builder()
                                                                                  .conditionType(ConditionType.TARGET_COMPLETED_WITH_SCORE_HIGHER_THAN_X.getValue())
                                                                                  .text("Completar: Aula Invertida: Dinosaurios con mas de 7")
                                                                                  .data("7")
                                                                                  .build());


        Long rewardAulaInvertidaId = createRewardService.execute(RewardDTO.builder()
                                                                          .rewardType(RewardType.CHALLENGE.getValue())
                                                                          .conditionId(conditionAulaInvertidaId)
                                                                          .targetType(TargetType.PROJECT.getValue())
                                                                          .targetId(ProyectoN1Id)
                                                                          .text("Sabes mucho de dinos!")
                                                                          .name("Dinoexperto")
                                                                          .build());

        Long conditionSocialId = createConditionService.execute(ConditionDTO.builder()
                                                                            .conditionType(ConditionType.SOCIAL.getValue())
                                                                            .text("Portarse bien")
                                                                            .build());


        Long rewardSocialId = createRewardService.execute(RewardDTO.builder()
                                                                   .rewardType(RewardType.SOCIAL.getValue())
                                                                   .text("Te portaste muy bien!")
                                                                   .conditionId(conditionSocialId)
                                                                   .name("Santo")
                                                                   .build());

        Long rewardBadge1 = createRewardService.execute(RewardDTO.builder()
                                                                 .conditionId(conditionSocialId)
                                                                 .rewardType(RewardType.BADGE.getValue())
                                                                 .text("Te ganaste esto, por que? no se...")
                                                                 .name("Insignia al mejor... algo... 1")
                                                                 .build());
        Long rewardBadge2 = createRewardService.execute(RewardDTO.builder()
                                                                 .conditionId(conditionSocialId)
                                                                 .rewardType(RewardType.BADGE.getValue())
                                                                 .text("Te ganaste esto, por que? no se...")
                                                                 .name("Insignia al mejor... algo... 2")
                                                                 .build());
        Long rewardBadge3 = createRewardService.execute(RewardDTO.builder()
                                                                 .conditionId(conditionSocialId)
                                                                 .rewardType(RewardType.BADGE.getValue())
                                                                 .text("Te ganaste esto, por que? no se...")
                                                                 .name("Insignia al mejor... algo... 3")
                                                                 .build());
        Long rewardBadge4 = createRewardService.execute(RewardDTO.builder()
                                                                 .conditionId(conditionSocialId)
                                                                 .rewardType(RewardType.BADGE.getValue())
                                                                 .text("Te ganaste esto, por que? no se...")
                                                                 .name("Insignia al mejor... algo... 4")
                                                                 .build());





        //Progreso de alumnos en un proyecto
        activityRepository.findAll().forEach(activity -> {
            userRepository.findByRole("ROLE_STUDENT").forEach(student -> {
                if (getClassroomStudentsService.execute(getProjectService.execute(getLessonService.execute(activity.getLessonId()).getProjectId()).getClassroomId())
                                               .stream()
                                               .anyMatch(s -> s.getId().equals(student.getId()))) {
                    StudentActivityDTO studentActivityDTO = StudentActivityDTO.builder()
                                                                              .activityId(activity.getId())
                                                                              .dateCompleted(LocalDateTime.now())
                                                                              .percentageCompleted(100.00)
                                                                              .grade(8)
                                                                              .userId(student.getId())
                                                                              .build();
                    updateStudentActivityProgressService.execute(student.getId(), activity.getId(), studentActivityDTO);
                }
            });
        });

        getClassroomStudentsService.execute(getClassroomService.execute(getProjectService.execute(ProyectoN1Id).getClassroomId()).getId()).forEach(student ->{
            StudentProjectDTO studentProjectDTO = StudentProjectDTO.builder()
                                                                   .projectId(ProyectoN1Id)
                                                                   .userId(student.getId())
                                                                   .grade(10)
                                                                   .percentageCompleted(100.00)
                                                                   .dateCompleted(LocalDateTime.now()).build();
            updateStudentProjectProgressService.execute(student.getId(), ProyectoN1Id, studentProjectDTO);
        });

        addRewardStudentService.execute(rewardSocialId,javiId);
        addRewardStudentService.execute(rewardBadge1, nazaId);
        addRewardStudentService.execute(rewardBadge2, nazaId);
        addRewardStudentService.execute(rewardBadge3, nazaId);
        addRewardStudentService.execute(rewardBadge4, nazaId);


        //TESTS
        //printObject(getActivitiesStatisticsService.execute(andreaId, "TEACHER", "STUDENT"));

        //printObject(getProjectsStatisticsService.execute(andreaId, "TEACHER"));

        //var pid = createProjectService.execute(ProjectDTO.builder().name("asdasd").classroomId(socialesCursoId).active(Boolean.TRUE).build());
        //printObject(getProjectStudentsProgressService.execute(pid));

        Long groupId = createGroupService.execute(GroupDTO.builder().name("NUEVO GRUPO").projectId(ProyectoN1Id).build());
        addGroupStudentService.execute(groupId,nazaId,"Infra");
        addGroupStudentService.execute(groupId,mariId,"Analista");
        //printObject(getProjectStudentGroupService.execute(ProyectoN1Id,mariId));



    }

    private void printObject(Object object) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(gson.toJson(object));
    }
}
