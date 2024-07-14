package fr.doranco.study_smart.service;

import fr.doranco.study_smart.entities.Course;
import fr.doranco.study_smart.entities.Module;

import java.util.List;

public interface ModuleService {
    Module saveModule(Module m);
    Module updateModule(Module m);
    void deleteModule(Module m);
    void deleteModuleById(Long id);
    Module getModule(Long id);
    List<Module> getAllModules();
    List<Module> findByCourse(Course course);
    List<Module> findByCourseId(Long id);
}
