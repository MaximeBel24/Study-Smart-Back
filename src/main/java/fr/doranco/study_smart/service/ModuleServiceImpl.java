package fr.doranco.study_smart.service;

import fr.doranco.study_smart.entities.Course;
import fr.doranco.study_smart.entities.Module;
import fr.doranco.study_smart.repositories.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ModuleServiceImpl implements ModuleService{

    @Autowired
    ModuleRepository moduleRepository;

    @Override
    public Module saveModule(Module m) {
        return moduleRepository.save(m);
    }

    @Override
    public Module updateModule(Module m) {
        return moduleRepository.save(m);
    }

    @Override
    public void deleteModule(Module m) {
        moduleRepository.delete(m);
    }

    @Override
    public void deleteModuleById(Long id) {
//        Module m = getModule(id);
//
//        try{
//
//        } catch (IOException) {
//
//        }
        moduleRepository.deleteById(id);
    }

    @Override
    public Module getModule(Long id) {
        return moduleRepository.findById(id).get();
    }

    @Override
    public List<Module> getAllModules() {
        return moduleRepository.findAll();
    }

    @Override
    public List<Module> findByCourse(Course course) {
        return moduleRepository.findByCourse(course);
    }

    @Override
    public List<Module> findByCourseId(Long id) {
        return moduleRepository.findByCourseId(id);
    }
}
