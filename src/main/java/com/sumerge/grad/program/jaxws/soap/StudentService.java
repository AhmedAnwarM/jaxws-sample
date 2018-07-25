package com.sumerge.grad.program.jaxws.soap;

import com.sumerge.grad.program.jaxws.repositories.boundary.Repository;
import com.sumerge.grad.program.jaxws.repositories.entity.Student;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.Collection;
import java.util.logging.Logger;

import static java.util.logging.Level.SEVERE;

@WebService
public class StudentService {

    private static final Logger LOGGER = Logger.getLogger(StudentService.class.getName());

    @EJB
    private Repository repo;

    @WebMethod
    public Collection<Student> getAllStudents() {
        try {
            return repo.getAllStudents();
        } catch (Exception e) {
            LOGGER.log(SEVERE, e.getMessage(), e);
            return null;
        }
    }

    @WebMethod
    public Student getStudent(Long id) {
        try {
            return repo.getStudent(id);
        } catch (Exception e) {
            LOGGER.log(SEVERE, e.getMessage(), e);
        }
        return null;
    }
}
